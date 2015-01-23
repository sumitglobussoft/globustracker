/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
import ranktracker.crawler.vimeo.VimeoPagenLinks;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Videokeywords;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class Vimeo_search extends Thread {

    private ApplicationContext appContext;
    private List<Videokeywords> lstVideokeywords;
    private KeywordsDao objKeywordDao;
    String vimUrl;
    String vimKeyword;
    Integer vimKeywordId;
    Queue<String> mainlinks = new LinkedList<>();
    Queue<String> pagenlinks = new LinkedList<>();
    Queue<String> othermainlinks = new LinkedList<>();
    private Boolean flag = false;
    int vimeorank;
    String vimeourl;
    FetchPagewithClientAthentication fetchSourcewithAuthentication;
    FetchPageBodySource fetchsource;
     ProxyDao objProxyDao;

    public Vimeo_search(List<Videokeywords> lstVideokeywords, ApplicationContext appContext) {
        this.appContext = appContext;
        this.lstVideokeywords = lstVideokeywords;
        this.fetchSourcewithAuthentication = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
         this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    public Vimeo_search() {
    }
    public boolean checkForRecentUpdatedKeyword(Videokeywords videokewords) {
        try {
            String currentDate[] = (new Date()).toString().split(" ");
            String endDate[] = videokewords.getVimeoUpdatedDate().split(" ");

            //Wed Jan 07 13:45:08 IST 2015
            //Fri Jan 02 13:40:06 IST 2015
            if (currentDate[0].equalsIgnoreCase(endDate[0])) {
                if (currentDate[1].equalsIgnoreCase(endDate[1])) {

                    if (currentDate[2].equalsIgnoreCase(endDate[2])) {

                        if (currentDate[5].equalsIgnoreCase(endDate[5])) {

                            System.out.println("SAME TIME : " + videokewords.getVideoKeyword()+ " [" + videokewords.getVideokeywordID() + "]");
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
//        Boolean matchfound = false;
//        VimeoPagenLinks vimeopagenlinks = new VimeoPagenLinks(fetchSourcewithAuthentication);
        ExecutorService executor = Executors.newFixedThreadPool(10);
             List<ProxyData> proxylist=objProxyDao.getProxyList();
        try {
             
            for (Videokeywords videokewords : lstVideokeywords) {
                
                 if (checkForRecentUpdatedKeyword(videokewords)) {
                    continue;
                }
//                
                executor.submit(new VimeoPagenLinks(lstVideokeywords, objKeywordDao, vimUrl, vimKeyword, vimKeywordId, fetchSourcewithAuthentication, fetchsource, videokewords,proxylist));
                
//                vimUrl = videokewords.getVimeoURL();
//                vimKeyword = videokewords.getVideoKeyword();
//                vimKeywordId = videokewords.getVideokeywordID();
//                //vimKeyword=vimKeyword.replaceAll(" ", "+");
//                System.out.println("Vim Keyword = " + vimKeyword);
//                //String newurl="http://vimeo.com/search/sort:relevant/format:detail?q="+vimKeyword;
//                // http://vimeo.com/search/sort:relevant/format:detail?q=Best+self+help+books
//                if (!videokewords.getVimeoURL().isEmpty()) {
//
//                      try {
////                       
//                       int count=0;
//                       URI uri = new URIBuilder()//http://vimeo.com/search?q=superman+hero
//                            .setScheme("http")
//                            .setHost("vimeo.com")
//                            .setPath("/search/page:1/sort:relevant/format:detail")
//                            .setParameter("q", vimKeyword)
//                            .build();
//                       String newuri=uri.toString();
//                       //String newuri="http://vimeo.com/search/page:1/sort:relevant/format:detail?q="+vimKeyword;
//                        for(int k=1;k<=10;k++){
//                            int l=0; 
//                            
//                        System.out.println("searchurl = " + newuri);
//                        String pagesource=fetchSourcewithAuthentication.fetchPageSourcefromVimeo(newuri);;
//                        while (pagesource.length()<1000 && l<=3){
//                            System.out.println("second attempt searchurl = " + newuri);
//                         pagesource=fetchSourcewithAuthentication.fetchPageSourcefromVimeo(newuri);;
//                         l++;
//                        }
//                         System.out.println("pagelsource lenth "+ pagesource.length());
//                        mainlinks = getVimeoPageCitationLinks(pagesource);
//                        matchfound = findSingleLink(mainlinks, vimUrl,count);
//                        if (matchfound){break;}
//                        else{newuri=getVimeoPaginationLinks(pagesource);
//                        if(newuri.length()<=10){break;}
//                        else{
//                           newuri="http://vimeo.com"+newuri;
//                        }}
//                        count=count+10;
//                        }
//                         if (!matchfound) {
//                                objKeywordDao.saveYoutubeResult(vimKeywordId, vimKeyword, "No Link Found", 501);
//                            }
//                        
//                    } catch (Exception ex) {
//                        Logger.getLogger(Youtube_search.class.getName()).log(Level.SEVERE, null, ex);
//                        ex.printStackTrace();
//                    }
//                    
//                    
//                    
//                    
//                    
//                    
////                    URI uri = new URIBuilder()//http://vimeo.com/search?q=superman+hero
////                            .setScheme("http")
////                            .setHost("vimeo.com")
////                            .setPath("/search")
////                            .setParameter("q", videokewords.getVideoKeyword())
////                            .build();
////
////                    String mainpagename = "/vimeomain.html";
////                    fetchSourcewithAuthentication.fetchPageSourcefromVimeo(uri, mainpagename);
////                    String mainpagepath = fetchSourcewithAuthentication.getShowPage() + mainpagename;
////                    mainlinks = getVimeoPageCitationLinks(mainpagepath);
////                    matchfound = findSingleLink(mainlinks);
////                    if (!matchfound) {
////                        pagenlinks = getVimeoPaginationLinks(mainpagepath);
////                        File f = new File(mainpagepath);
////                        f.delete();
////                        try {
////                            othermainlinks = vimeopagenlinks.getOtherVimeoPageLinksCrawl(pagenlinks, vimUrl);
////                            findandSaveVimeoRank(othermainlinks);
////                        } catch (IOException | InterruptedException ex) {
////                            Logger.getLogger(Vimeo_search.class.getName()).log(Level.SEVERE, null, ex);
////                        }
////                    }
//
//                }
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
            executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(Vimeo_search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void findandSaveVimeoRank(Queue mainlinks) {
        int count = 0;
        Boolean store = false;
        Iterator itrmap = mainlinks.iterator();
        while (itrmap.hasNext()) {
            flag = false;
            String mentry = itrmap.next().toString();
            count++;
            flag = findVimeoLink(mentry, vimUrl);
            store = false;
            if (flag) {
                vimeorank = count;
                System.out.println("vimeorank = " + vimeorank);
                vimeourl = mentry;
                objKeywordDao.saveVimeoResult(vimKeywordId, vimKeyword, vimeourl, vimeorank);
                store = true;
                break;
            }
        }
        if (!store) {
            objKeywordDao.saveVimeoResult(vimKeywordId, vimKeyword, "No Link Found", 501);
        }
    }

//    public Boolean findSingleLink(Queue links) {
//        int count = 0;
     public Boolean findSingleLink(Queue links,String vmurl,int count) {
        Boolean store = false;
        Iterator itrmap = links.iterator();
        while (itrmap.hasNext()) {
            flag = false;
            String mentry = itrmap.next().toString();
            count++;
            flag = findVimeoLink(mentry, vimUrl);
            store = false;
            if (flag) {
                vimeorank = count;
                System.out.println("vimeorank = " + vimeorank);
                vimeourl = mentry;
                objKeywordDao.saveVimeoResult(vimKeywordId, vimKeyword, vimeourl, vimeorank);
                store = true;
                break;
            }
        }
        return store;
    }

    public Boolean findVimeoLink(String link, String vimUrl) {
        Boolean fod = false;
        if (vimUrl.contains(link) || link.contains(vimUrl)) {
            fod = true;
        }
        return fod;
    }

    public Queue<String> getVimeoPageCitationLinks(String pagepath) {
        Queue<String> vimeocitlinks = new LinkedList<>();
        try {
            Document doc = Jsoup.parse(pagepath);  
//            File f = new File(pagepath);
//            Document doc = Jsoup.parse(f, "UTF-8");
            Element links = doc.getElementById("browse_content");
            Element links2 = links.getElementsByTag("ol").first();
            Elements nlinks = links2.select("li > a");
            for (Element el2 : nlinks) {
                String vimlinks = el2.attr("href");
//                System.out.println("Main Links " + vimlinks);
//                String vimtitles = el2.attr("title");
//                System.out.println("youtitles = " + vimtitles);
                vimeocitlinks.add(vimlinks);

            }
        } catch (Exception e) {
           // e.printStackTrace();
            System.out.println("No links found inthis page");
        }
        return vimeocitlinks;
    }

//    public Queue<String> getVimeoPaginationLinks(String pagepath) {
//        Queue<String> pagelinks = new LinkedList<>();
//        try {
//            File f = new File(pagepath);
//            Document doc = Jsoup.parse(f, "UTF-8");
//            Element element = doc.getElementById("pagination");
//            Elements paglinks = element.select("ol li a");
//            for (Element ele : paglinks) {
//                String foundlinks = ele.attr("href");
////                System.out.println("foundlinks = " + foundlinks);
//                pagelinks.add(foundlinks);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return pagelinks;
//    }
      public String getVimeoPaginationLinks(String pagepath) {
        String pagelinks = "";
        try {
            System.out.println("--------paginatin-----");
            Document doc = Jsoup.parse(pagepath);
            Element element = doc.getElementById("pagination");
            Elements paglinks = element.select("ol li a");
            for (Element ele : paglinks) {
                String check=ele.toString();
                if(check.contains("Next"))
                {
                 pagelinks = ele.attr("href");}
//                System.out.println("foundlinks = " + foundlinks);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagelinks;
    }
}
