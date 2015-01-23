/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.dailymotion;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Videokeywords;
import ranktracker.utility.FetchPagewithClientAthentication;

/**
 *
 * @author User
 */
public class DailymotionPagenLinks implements Callable<String>{
    
    private KeywordsDao objKeywordDao;
    private FetchPagewithClientAthentication fetchSourcewithAuthentication;
    String dmUrl;
    String dmKeyword;
    Integer dmKeywordId;
    Queue<String> pagenlinks = new LinkedList<>();
    Queue<String> pagenlinks2 = new LinkedList<>();
    int dmrank;
    private Boolean flag = false;
    String dailymotionurl;
    Queue<String> mainlinks = new LinkedList<>();
    Queue<String> pageslinks = new LinkedList<>();
    Queue<String> othermainlinks = new LinkedList<>();
    Videokeywords videokeywords;
     List<ProxyData> proxyList;

    public DailymotionPagenLinks(KeywordsDao objKeywordDao, FetchPagewithClientAthentication fetchSourcewithAuthentication, String dmUrl, String dmKeyword, Integer dmKeywordId, String dailymotionurl, Videokeywords videokeywords,List<ProxyData> proxyList) {
        this.objKeywordDao = objKeywordDao;
        this.fetchSourcewithAuthentication = fetchSourcewithAuthentication;
        this.dmUrl = dmUrl;
        this.dmKeyword = dmKeyword;
        this.dmKeywordId = dmKeywordId;
        this.dailymotionurl = dailymotionurl;
        this.videokeywords = videokeywords;
        this.proxyList = proxyList;
    }

    @Override
    public String call() throws Exception {
          Boolean matchfound1 = false;

        if (!videokeywords.getDailymotionURL().isEmpty()) {
                    dmUrl = videokeywords.getDailymotionURL();
                    dmKeyword = videokeywords.getVideoKeyword();
                    dmKeywordId = videokeywords.getVideokeywordID();
                    //dmKeyword = dmKeyword.replace(" ", "+");
                    int count = 0;

                    for (int k = 1; k <= 12; k++) {
                        int l = 0;
                        String num=Integer.toString(k);
                        URI newuri = new URIBuilder()
                                .setScheme("http")
                                .setHost("www.dailymotion.com")
                                .setPath("/en/relevance/universal/search/" + dmKeyword + "/"+num)
                                .build();
                       // String newuri = "http://www.dailymotion.com/us/relevance/search/" + dmKeyword + "/" + k;

                        String pagesource = fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(newuri, "", 0, this.proxyList);
                        while (pagesource.length() < 1000 && l <= 3) {
                            System.out.println("second attempt searchurl = " + newuri);
                            pagesource = fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(newuri, "", 0, this.proxyList);
                            l++;
                        }
                        if (pagesource.length() <= 1000) {
                            System.out.println("THIS PAGE LEFT" + newuri);
                        }
                        mainlinks = getDailymotionCitationLinksCrawl(pagesource);
                        matchfound1 = findandSaveDailyMotionRank(mainlinks, count);
                        count = count + 18;
                        if (matchfound1) {
                            break;
                        }
                    }
                    if (!matchfound1) {
                        objKeywordDao.saveDailymotionResult(dmKeywordId, dmKeyword, "No Link Found", 501);
                    }
                }
       return "done";
    }
       public Queue getDailymotionCitationLinksCrawl(String pagepapth) {
        Queue mainpagelinks = new LinkedList();
        try {

            Document doc = Jsoup.parse(pagepapth);
            String pageSource = doc.toString();
            
            
            try {
                doc = Jsoup.parse(pagepapth);

                Elements e1 = doc.select("div[class=js-list-list col-8]");
                Elements e2 = e1.select("div[class=media-block]");
                Elements e3 = e2.select("div[class=title font-lg mrg-btm-sm] a");

                for (Element element : e3) {
                    System.out.println("URL : " + "http://www.dailymotion.com" + element.attr("href"));
                    mainpagelinks.add("URL : " + "http://www.dailymotion.com" + element.attr("href"));
                }
            } catch (Exception e) {
            }

            try {
                doc = Jsoup.parse(pagepapth);
                Elements e4 = doc.select("div[class=pages align-center] a[class=font-xl icon-arrow_right alt-link]");
                String nextLink = "http://www.dailymotion.com";
                for (Element element : e4) {

                    nextLink = nextLink + element.attr("href");
                    System.out.println("===============================================================================================");
                    System.out.println("URL: --- " + nextLink);
                    getDailymotionCitationLinksCrawl(nextLink);
//                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
        }
        return mainpagelinks;
    }
        public Boolean findandSaveDailyMotionRank(Queue mainlinks, int count) {
        Boolean store = false;
        Iterator itrmap = mainlinks.iterator();
        while (itrmap.hasNext()) {
            flag = false;
            String mentry = itrmap.next().toString();
            count++;
            flag = findDailymotionLink(mentry, dmUrl);
            store = false;
            if (flag) {
                dmrank = count;
                System.out.println("DailymotionRank for = "+dmKeyword+"is" + dmrank);
                System.out.println("=====********========*******=====");
                dmUrl = mentry;
                objKeywordDao.saveDailymotionResult(dmKeywordId, dmKeyword, dmUrl, dmrank);
                store = true;
                break;
            }
        }
        return store;
    }

    

//    public Queue getOtherDailymotionPageLinksCrawl(Queue pagenlinks, String dmUrl) throws IOException, InterruptedException {
//        Boolean matchfound = false;
//        Queue otherlinks = new LinkedList();
//        ExecutorService executor = Executors.newCachedThreadPool();
//        List<Future<Queue<String>>> future = new ArrayList<>();
//        Queue pagelist = pagenlinks;
//        String lastpage = null;
//        Iterator itr = pagelist.iterator();
//        for (int i = 0; itr.hasNext(); i++) {
//            String pl = (String) itr.next();
//            otherlinks.addAll(getExtraPageLinksCrawl(pl, future, executor, i));
//            lastpage = pl;
//        }
//        matchfound = findSingleLink(otherlinks, dmUrl);
//        if (!matchfound) {
//            String lastvalue = lastpage.substring(lastpage.length() - 1, lastpage.length());
//            int index = Integer.parseInt(lastvalue);
//            for (int i = 0; i < 22; i++) {
//                index++;
//                String temp = lastpage.replace(lastvalue, "");
//                String newpage = temp + index;
//                System.out.println("newpage = " + newpage);
//                otherlinks.addAll(getExtraPageLinksCrawl(newpage, future, executor, i));
//            }
//        }
//        executor.shutdown();
//        return otherlinks;
//    }
//
//    public Queue getExtraPageLinksCrawl(String newpageurl, List<Future<Queue<String>>> future, ExecutorService executor, int i) throws IOException, InterruptedException {
//        Queue newpagelinks = new LinkedList();
//        HttpGet httpget = new HttpGet((String) "http://www.dailymotion.com" + newpageurl);
//        future = ((List<Future<Queue<String>>>) executor.invokeAll((Arrays.asList(new GetDailymotionThread(httpget, i)))));
//        Iterator itr1 = future.iterator();
//        while (itr1.hasNext()) {
//            try {
//                Future<Queue<String>> futur = (Future<Queue<String>>) itr1.next();
//                for (String futur1 : futur.get()) {
//                    newpagelinks.add(futur1);
//                }
//            } catch (InterruptedException | ExecutionException ex) {
//                Logger.getLogger(DailymotionPagenLinks.class.getName()).log(Level.SEVERE, null, ex);
//                ex.printStackTrace();
//            }
//        }
//        return newpagelinks;
//    }
//
//    public Boolean findSingleLink(Queue links, String url) {
//        int count = 0;
//        Boolean store = false;
//        Boolean flag = false;
//        Iterator itrmap = links.iterator();
//        while (itrmap.hasNext()) {
//            String str = itrmap.next().toString();
//            count++;
//            flag = findDailymotionLink(str, url);
//            store = false;
//            if (flag) {
//                store = true;
//                break;
//            }
//        }
//        return store;
//    }

    public Boolean findDailymotionLink(String link, String dmUrl) {
        Boolean fod = false;
        try {
            if (dmUrl.contains(link) || link.contains(dmUrl)) {
                fod = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fod;
    }
}
