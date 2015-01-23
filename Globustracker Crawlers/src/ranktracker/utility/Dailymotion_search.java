/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import ranktracker.crawler.dailymotion.DailymotionPagenLinks;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Videokeywords;

/**
 *
 * @author User
 */
public class Dailymotion_search extends Thread {

    private ApplicationContext appContext;
    private List<Videokeywords> lstVideokeywords;
    private KeywordsDao objKeywordDao;
    private FetchPagewithClientAthentication fetchSourcewithAuthentication;
    String dmUrl;
    String dmKeyword;
    Integer dmKeywordId;
    Queue<String> pagenlinks = new LinkedList<>();
    Queue<String> pagenlinks2 = new LinkedList<>();
    private Boolean flag = false;
    int dmrank;
    String dailymotionurl;
    Queue<String> mainlinks = new LinkedList<>();
    Queue<String> pageslinks = new LinkedList<>();
    Queue<String> othermainlinks = new LinkedList<>();
     ProxyDao objProxyDao;

    public Dailymotion_search(List<Videokeywords> lstVideokeywords, ApplicationContext appContext) {
        this.appContext = appContext;
        this.lstVideokeywords = lstVideokeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.fetchSourcewithAuthentication = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    public Dailymotion_search() {
    }

      public boolean checkForRecentUpdatedKeyword(Videokeywords videokeywords) {
        try {
            String currentDate[] = (new Date()).toString().split(" ");
            String endDate[] = videokeywords.getDailymotionUpdatedDate().split(" ");

            //Wed Jan 07 13:45:08 IST 2015
            //Fri Jan 02 13:40:06 IST 2015
            if (currentDate[0].equalsIgnoreCase(endDate[0])) {
                if (currentDate[1].equalsIgnoreCase(endDate[1])) {

                    if (currentDate[2].equalsIgnoreCase(endDate[2])) {

                        if (currentDate[5].equalsIgnoreCase(endDate[5])) {

                            System.out.println("SAME TIME : " + videokeywords.getVideoKeyword() + " [" + videokeywords.getVideokeywordID() + "]");
                            return true;
                        }
                    }
                }
            }

        } catch (Exception s) {
            System.out.println("" + s);

        }
        return false;
    }
    
    @Override
    public void run() {
//        Boolean matchfound1 = false;
//        Boolean matchfound2 = false;
//        FetchPageBodySource fetchsource=appContext.getBean("fetchSource", FetchPageBodySource.class);
        List<ProxyData> proxylist=objProxyDao.getProxyList();
         ExecutorService executor = Executors.newFixedThreadPool(10);
       // DailymotionPagenLinks dailymotionpagenlinks = new DailymotionPagenLinks();
        try {
           

            for (Videokeywords videokeywords : lstVideokeywords) {
               
                if (checkForRecentUpdatedKeyword(videokeywords)) {
                    continue;
                }
                
                executor.submit(new DailymotionPagenLinks(objKeywordDao, fetchSourcewithAuthentication, dmUrl, dmKeyword, dmKeywordId, dailymotionurl, videokeywords,proxylist));
                
//                if (!videokeywords.getDailymotionURL().isEmpty()) {
//                    dmUrl = videokeywords.getDailymotionURL();
//                    dmKeyword = videokeywords.getVideoKeyword();
//                    dmKeywordId = videokeywords.getVideokeywordID();
//                    //dmKeyword = dmKeyword.replace(" ", "+");
//                    int count = 0;
//
//                    for (int k = 1; k <= 12; k++) {
//                        int l = 0;
//                        String num=Integer.toString(k);
//                        URI newuri = new URIBuilder()
//                                .setScheme("http")
//                                .setHost("www.dailymotion.com")
//                                .setPath("/en/relevance/universal/search/" + dmKeyword + "/"+num)
//                                .build();
//                       // String newuri = "http://www.dailymotion.com/us/relevance/search/" + dmKeyword + "/" + k;
//
//                        String pagesource = fetchSourcewithAuthentication.fetchPageSourcefromDailymotion(newuri);
//                        while (pagesource.length() < 1000 && l <= 3) {
//                            System.out.println("second attempt searchurl = " + newuri);
//                            pagesource = fetchSourcewithAuthentication.fetchPageSourcefromDailymotion(newuri);
//                            l++;
//                        }
//                        if (pagesource.length() <= 1000) {
//                            System.out.println("THIS PAGE LEFT" + newuri);
//                        }
//                        mainlinks = getDailymotionCitationLinksCrawl(pagesource);
//                        matchfound1 = findandSaveDailyMotionRank(mainlinks, count);
//                        count = count + 18;
//                        if (matchfound1) {
//                            break;
//                        }
//                    }
//                    if (!matchfound1) {
//                        objKeywordDao.saveDailymotionResult(dmKeywordId, dmKeyword, "No Link Found", 501);
//                    }
//                }
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
               executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(Dailymotion_search.class.getName()).log(Level.SEVERE, null, ex);
        }

//        Boolean matchfound1 = false;
//        Boolean matchfound2 = false;
////        FetchPageBodySource fetchsource=appContext.getBean("fetchSource", FetchPageBodySource.class);
//        DailymotionPagenLinks dailymotionpagenlinks = new DailymotionPagenLinks();
//        try {
//
//            for (Videokeywords videokeywords : lstVideokeywords) {
//                if (!videokeywords.getDailymotionURL().isEmpty()) {
//                    dmUrl = videokeywords.getDailymotionURL();
//                    dmKeyword = videokeywords.getVideoKeyword();
//                    dmKeywordId = videokeywords.getVideokeywordID();
//                    String changedkeyword = dmKeyword.replace(" ", "+");
//                    String newurl = "/us/relevance/search/" + changedkeyword + "/1";
//                    try {
//                        URI newuri = new URIBuilder()
//                                .setScheme("http")
//                                .setHost("www.dailymotion.com")
//                                .setPath("/us/relevance/search/" + changedkeyword + "/1")
//                                .build();
//
//                        fetchSourcewithAuthentication.fetchPageSourcefromDailymotion(newuri, "dailymotionmainpage.html");
//                    } catch (URISyntaxException ex) {
//                        Logger.getLogger(Dailymotion_search.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    String mainpagepath = fetchSourcewithAuthentication.getShowPage() + "/dailymotionmainpage.html";
//                    mainlinks = getDailymotionCitationLinksCrawl(mainpagepath);
//                    matchfound1 = findandSaveDailyMotionRank(mainlinks);
//                    if (!matchfound1) {
//                        pagenlinks = getDailymotionPagenationLinks(newurl);
//                        File f = new File(mainpagepath);
//                        f.delete();
//                        pagenlinks.poll();
//                        int pagenlinksize = pagenlinks.size();
//                        Iterator itr = pagenlinks.iterator();
//                        int c = 0;
//                        while (itr.hasNext()) {
//                            Object o = itr.next();
//                            c++;
//                            if (!(pagenlinksize == c)) {
//                                pagenlinks2.add(o.toString());
//                            }
//                        }
//                        pagenlinks.clear();
//                        System.out.println("pagenlinks length " + pagenlinks2.size());
//
//                        othermainlinks = dailymotionpagenlinks.getOtherDailymotionPageLinksCrawl(pagenlinks2, dmUrl);
//                        pagenlinks2.clear();
//                        pageslinks.addAll(mainlinks);
//                        pageslinks.addAll(othermainlinks);
//                        matchfound2 = findandSaveDailyMotionRank(pageslinks);
//                        if (!matchfound2) {
//                            System.out.println("DailymotionRank = " + 501);
//                            System.out.println("=====********========*******=====");
//                            objKeywordDao.saveDailymotionResult(dmKeywordId, dmKeyword, "No Link Found", 501);
//                        }
//                    }
//                }
//            }
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public Queue getDailymotionCitationLinksCrawl(String pagepapth) {
        Queue mainpagelinks = new LinkedList();
        try {
//            File input = new File(pagepapth);
            Document doc = Jsoup.parse(pagepapth);
            String pageSource = doc.toString();

//            while (true) {
//                String contentsource = "";
//                int optionStartIndex = 0;
//                int optionEndIndex = 0;
//                optionStartIndex = pageSource.indexOf("sd_list_list", optionStartIndex);
//                optionEndIndex = pageSource.indexOf("pdg-sm mrg-top-lg", optionStartIndex);
//                contentsource = pageSource.substring(optionStartIndex, optionEndIndex);
//
//                optionStartIndex = 0;
//                optionEndIndex = 0;
//                while (true) {
//                    optionStartIndex = contentsource.indexOf("href=\"", optionStartIndex);
//                    if (optionStartIndex > 0) {
//                        optionEndIndex = contentsource.indexOf("\"", optionStartIndex + 10);
//                        //optionEndIndex = districtPageSource.indexOf("\" ", optionStartIndex);
//                        String value = contentsource.substring(optionStartIndex + "href=\"".length(), optionEndIndex);
//                        mainpagelinks.add("dailymotion.com" + value);
//                        optionEndIndex = contentsource.indexOf("views foreground2", optionEndIndex);
//                        optionStartIndex = optionEndIndex;
//                        //String name = districtPageSource.substring(namestartIndex + ">".length(), nameEndIndex).trim();
//                        // name = ReplaceAllHtmlTage.GetOnlyData(name);
//                    } else {
//                        return mainpagelinks;
//                    }
//                }
//                //i++;
//            }
            
            
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
//                    System.out.println("@@@@@@@@@@@@@@@@@"+element.text());
//                    if (element.text().contains("Next")) {
                    nextLink = nextLink + element.attr("href");
                    System.out.println("===============================================================================================");
                    System.out.println("URL: --- " + nextLink);
                    getDailymotionCitationLinksCrawl(nextLink);
//                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
//            Document doc = Jsoup.parse(input, "UTF-8");
//            Element links = doc.getElementById("search_results");
//            Elements nlinks = links.select("div> div > a");
//            for (Element el2 : nlinks) {
//                String dmlinks = el2.attr("href");
//                if (dmlinks.contains("/video/")) {
////                    System.out.println(dmlinks);
//                    mainpagelinks.add(dmlinks);
//                }
//            }
        } catch (Exception e) {
        }
        return mainpagelinks;
    }

    public Queue<String> getDailymotionPagenationLinks(String url) {
        Queue<String> othpagenlinks = new LinkedList<>();
        try {
            String pageIndex = url.substring(url.lastIndexOf("/") + "/".length(), url.length());
            int i = Integer.valueOf(pageIndex);
            while (i <= 20) {
                i++;
                String newurl = url.replace("/" + pageIndex, "/" + i);
                othpagenlinks.add(newurl);

            }

//            File input = new File(url);
//            Document doc = Jsoup.parse(input, "UTF-8");
//            Element plinks = doc.getElementById("dual_list");
//            Elements pagenlin = plinks.select("div.mo_pagination div > a");
//            for (Iterator<Element> it = pagenlin.iterator(); it.hasNext();) {
//                Element el1 = it.next();
//                String pilinks = el1.attr("href").trim();
//                //System.out.println("Pagenation Links"+pilinks);
//                othpagenlinks.add(pilinks);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return othpagenlinks;
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

    public Boolean findDailymotionLink(String link, String dmUrl) {
        Boolean fod = false;
        if (dmUrl.contains(link) || link.contains(dmUrl)) {
            fod = true;
        }
        return fod;
    }
}
