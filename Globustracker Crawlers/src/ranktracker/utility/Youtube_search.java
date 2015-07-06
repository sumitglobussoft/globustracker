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
import java.net.URL;
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
import ranktracker.crawler.youtube.YoutubePagenLinks;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Videokeywords;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class Youtube_search implements Runnable {

    private ApplicationContext appContext;
    private List<Videokeywords> lstVideokeywords;
    private KeywordsDao objKeywordDao;
    private FetchPagewithClientAthentication fetchSourcewithAuthentication;
    String yoUrl;
    String yoKeyword;
    Integer yoKeywordId;
    private Boolean flag = false;
    int youtuberank;
    String youtubeurl;
    ProxyDao objProxyDao;

    public Youtube_search(List<Videokeywords> lstVideokeywords, ApplicationContext appContext) {
        this.appContext = appContext;
        this.lstVideokeywords = lstVideokeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.fetchSourcewithAuthentication = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    public Youtube_search() {
    }
    
    public boolean checkForRecentUpdatedKeyword(Videokeywords keywords ) {
        try {
            String currentDate[] = (new Date()).toString().split(" ");
            String endDate[] = keywords.getYoutubeUpdatedDate().split(" ");

            //Wed Jan 07 13:45:08 IST 2015
            //Fri Jan 02 13:40:06 IST 2015
            if (currentDate[0].equalsIgnoreCase(endDate[0])) {
                if (currentDate[1].equalsIgnoreCase(endDate[1])) {

                    if (currentDate[2].equalsIgnoreCase(endDate[2])) {

                        if (currentDate[5].equalsIgnoreCase(endDate[5])) {

                            System.out.println("SAME TIME : " + keywords.getVideoKeyword() + " [" + keywords.getVideokeywordID()+ "]");
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
        List<ProxyData> proxylist = objProxyDao.getProxyList();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try {
//            YoutubePagenLinks youtubepagenlinks = new YoutubePagenLinks();
            
            for (Videokeywords keywords : lstVideokeywords) {
                
                if (checkForRecentUpdatedKeyword(keywords)) {
                    continue;
                }
                
                executor.submit(new YoutubePagenLinks(objKeywordDao, fetchSourcewithAuthentication,  yoUrl,  yoKeyword,  yoKeywordId,  youtuberank,  youtubeurl, keywords,proxylist));
                
                
//                if (! keywords.getYoutubeURL().isEmpty()) {
//                    Boolean rankcheck = false;
//                    Map<String, String> mainlinks = new LinkedHashMap<>();
//                    Map<String, String> otherlinks = new LinkedHashMap<>();
//                    Map<String, String> pagelist = new LinkedHashMap<>();
//                    Queue<String> pagenlinks = new LinkedList<>();
//                    Queue<String> pagenlinks2 = new LinkedList<>();
//                    Boolean store = false;
//                    youtuberank = 0;
//                    yoUrl = keywords.getYoutubeURL();
//                    yoKeyword = keywords.getVideoKeyword();
//                    yoKeywordId = keywords.getVideokeywordID();
//                    //yoKeyword=yoKeyword.replaceAll(" ", "+");
//                    System.out.println("yoKeywordId = " + yoKeywordId);
//                    System.out.println("searchurl = " +yoUrl );
//                    //http://www.youtube.com/results?search_query=best+self+help+book&oq=best+self+help+book
//                    try {
////                       
//                        int count=0;
//                       
//                        for(int k=1;k<=10;k++){
//                            int l=0;
//                            String num=Integer.toString(k);
//                             URI newuri = new URIBuilder()
//                                .setScheme("http")
//                                .setHost("www.youtube.com")
//                                .setPath("/results")
//                                .setParameter("search_query", yoKeyword)
//                                .setParameter("page",num)
//                                .build();
//                        //String newuri="http://www.youtube.com/results?search_query="+yoKeyword+"&page="+k;
//                        
//                        System.out.println("searchurl = " + newuri);
//                        String pagesource=fetchSourcewithAuthentication.fetchPageSourcefromYoutube(newuri);
//                        while (pagesource.length()<1000 && l<=3){
//                            System.out.println("second attempt searchurl = " + newuri);
//                         pagesource=fetchSourcewithAuthentication.fetchPageSourcefromYoutube(newuri);
//                         l++;
//                        }
//                         System.out.println("pagelsource lenth "+ pagesource.length());
//                        mainlinks = getYoutubePageCitationLinks(pagesource);
//                        rankcheck = findRankforyoutubeMap(mainlinks, yoUrl,count);
//                        count=count+20;
//                        if (rankcheck){break;}
//                        }
//                         if (!rankcheck) {
//                                objKeywordDao.saveYoutubeResult(yoKeywordId, yoKeyword, "No Link Found", 501);
//                            }
//                        
//                    } catch (Exception ex) {
//                        Logger.getLogger(Youtube_search.class.getName()).log(Level.SEVERE, null, ex);
//                        ex.printStackTrace();
//                    }
//
//                   // String mainpagepath = fetchSourcewithAuthentication.getShowPage() + "/youmainpage.html";
//                  //  System.out.println("mainpage = " + mainpagepath);
////                    mainlinks = getYoutubePageCitationLinks(mainpagepath);
////                    rankcheck = findRankforyoutubeMap(mainlinks, yoUrl);
////                    if (!rankcheck) {
////                        pagenlinks = getYoutubePagenationLinks(mainpagepath);
////                        pagenlinks.poll();
////                        int pagenlinksize = pagenlinks.size();
////                        Iterator itr = pagenlinks.iterator();
////                        int c = 0;
////                        while (itr.hasNext()) {
////                            Object o = itr.next();
////                            c++;
////                            if (!(pagenlinksize == c)) {
////                                pagenlinks2.add(o.toString());
////                            }
////                        }
////                        pagenlinks.clear();
////                        System.out.println("pagenlinks length " + pagenlinks2.size());
////
////                        synchronized (youtubepagenlinks) {
////                            otherlinks = youtubepagenlinks.getOtherYoutubePageLinksCrawl(pagenlinks2);
////                            pagelist.putAll(mainlinks);
////                            pagelist.putAll(otherlinks);
////                            System.out.println("pagelist size " + pagelist.size());
////                            store = findRankforyoutubeMap(pagelist, yoUrl);
////                            if (!store) {
////                                objKeywordDao.saveYoutubeResult(yoKeywordId, yoKeyword, "No Link Found", 0);
////                            }
////                        }
////                    }
//                }
            }
               
        } catch (Exception e) {
            e.printStackTrace();
        }
         executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(Youtube_search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Boolean findRankforyoutubeMap(Map pagelist, String yoURL,int count) throws MalformedURLException {
        Boolean store = false;
        Iterator itrmap = pagelist.entrySet().iterator();
        while (itrmap.hasNext()) {
            flag = false;
            Map.Entry mentry = (Map.Entry) itrmap.next();
            count++;
            flag = findYoutubeRank(mentry.getValue().toString(), yoURL);
            if (flag) {
                youtuberank = count;
                System.out.println("youtuberank = " + youtuberank);
                youtubeurl = mentry.getValue().toString();
                objKeywordDao.saveYoutubeResult(yoKeywordId, yoKeyword, youtubeurl, youtuberank);
                store = true;
                break;
            }
        }
        return store;
    }

    public Map<String, String> getYoutubePageCitationLinks(String pagesource) {
        Map<String, String> youcitelinks = new LinkedHashMap<>();
        try {
            Document doc = Jsoup.parse(pagesource);
            Element links = doc.getElementById("results");
            Elements links2 = links.getElementsByTag("li");
            Elements nlinks = links2.select("h3.yt-lockup-title > a");
            for (Element el2 : nlinks) {
             String youlinks = el2.attr("href");
             System.out.println("Main Links "+youlinks);
             String youtitles = el2.attr("title");
             System.out.println("youtitles = " + youtitles+"  "+" youlink : "+youlinks);
             youcitelinks.put(youtitles, youlinks);
//            File f = new File(url);
//            Document doc = Jsoup.parse(f, "UTF-8");
//            Element links = doc.getElementById("results");
//            Elements links2 = links.getElementsByTag("li");
//            Elements nlinks = links2.select("h3.yt-lockup-title > a");
//            for (Element el2 : nlinks) {
//                String youlinks = el2.attr("href");
//                //System.out.println("Main Links "+youlinks);
//                String youtitles = el2.attr("title");
//                //System.out.println("youtitles = " + youtitles+"  "+" youlink : "+youlinks);
//                youcitelinks.put(youtitles, youlinks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return youcitelinks;
    }

    public Queue<String> getYoutubePagenationLinks(String url) {
        Queue<String> othpagenlinks = new LinkedList<>();
        try {
            File f = new File(url);
            Document doc = Jsoup.parse(f, "UTF-8");
            Element plinks = doc.getElementById("gh-activityfeed");
            Elements pagenlks = plinks.select("div.yt-uix-pager a[href]");
            for (Element el1 : pagenlks) {
                String pilinks = el1.attr("href");
                //System.out.println("Pagenation Links  "+pilinks);
                othpagenlinks.add(pilinks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return othpagenlinks;
    }

    public Boolean findYoutubeRank(String title, String domainurl) throws MalformedURLException {
        Boolean fod = false;
        if (domainurl.contains(title)) {
            fod = true;
        }
        return fod;
    }
}
