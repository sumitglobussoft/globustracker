/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
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
import ranktracker.crawler.metacafe.MetacafePagenLinks;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Videokeywords;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class Metacafe_search extends Thread {

    private ApplicationContext appContext;
    private List<Videokeywords> lstVideokeywords;
    private KeywordsDao objKeywordDao;
    private FetchPagewithClientAthentication fetchSourcewithAuthentication;
    String mcUrl;
    String mcKeyword;
    Integer mcKeywordId;
    private Boolean flag = false;
    int metacaferank;
    String metacafeurl;
    private boolean store = false;
    boolean matchfound = false;
    ProxyDao objProxyDao;

    public Metacafe_search(List<Videokeywords> lstVideokeywords, ApplicationContext appContext) {
        this.appContext = appContext;
        this.lstVideokeywords = lstVideokeywords;
        this.fetchSourcewithAuthentication = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    public Metacafe_search() {
    }

//    public void run() {
//        MetacafePagenLinks metacafepagenlinks = new MetacafePagenLinks();
//        int count = 0;
//        try {
//            for (Videokeywords videoKeywords : lstVideokeywords) {
//                store = false;
//                count = 0;
//                Map<String, String> mainlinks = new LinkedHashMap<>();
//                Queue<String> pagenlinks = new LinkedList<>();
//                Queue<String> pagenlinks2 = new LinkedList<>();
//
//                Map<String, String> otherlinks = new LinkedHashMap<>();
//                Map<String, String> pagelist = new LinkedHashMap<>();
//                mcUrl = videoKeywords.getMetacafeURL();
//                mcKeyword = videoKeywords.getVideoKeyword();
//                mcKeywordId = videoKeywords.getVideokeywordID();
//
//                if (!videoKeywords.getMetacafeURL().isEmpty()) {
//                    mcKeyword = mcKeyword.replace(" ", "_");
//                    System.out.println("Metacafe Keyword = " + mcKeyword);
//                    URI uri = new URIBuilder()
//                            .setScheme("http")
//                            .setHost("metacafe.com")
//                            .setPath("/topics/" + mcKeyword)
//                            .build();
//                    String mainpagename = "/metacafe.txt";
//                    fetchSourcewithAuthentication.fetchPageSourceFromMetacafe(uri, mainpagename);
//                    String mainpagepath = fetchSourcewithAuthentication.getShowPage() + mainpagename;
//                    System.out.println("mainpage = " + mainpagepath);
//                    mainlinks = getMetacafePageCitationLinks(mainpagepath);
//                    pagenlinks = getMetacafePaginationLinks(mainpagepath);
//
//                    pagenlinks.poll();
//                    int s = pagenlinks.size();
////                    System.out.println("s = " + s);
//                    Iterator itr = pagenlinks.iterator();
//                    while (itr.hasNext()) {
//                        count++;
//                        Object o = itr.next();
//                        if (count != s) {
//                            pagenlinks2.add(o.toString());
//                        }
//                    }
//                    pagenlinks.clear();
//                    otherlinks = metacafepagenlinks.getOtherMetacafePagenLinks(pagenlinks2);
//                    pagelist.putAll(otherlinks);
//                    Iterator itrmap = pagelist.entrySet().iterator();
//                    while (itrmap.hasNext()) {
//                        count++;
//                        flag = false;
//                        Map.Entry mapentry = (Map.Entry) itrmap.next();
//                        //System.out.println("Key = "+mentry.getKey());
//                        flag = findMetacafeRank(mapentry.getKey().toString(), mcUrl);
//                        if (flag) {
//                            metacaferank = count;
//                            metacafeurl = mapentry.getValue().toString();
//                            mcKeyword = mcKeyword.replace("_", " ");
//                            objKeywordDao.saveMetacafeResult(mcKeywordId, mcKeyword, metacafeurl, metacaferank);
//                            store = true;
//                            break;
//                        }
//                    }
//                    if (!store) {
//                       
//                            mcKeyword = mcKeyword.replace("_", " ");
//                            objKeywordDao.saveMetacafeResult(mcKeywordId, mcKeyword, "No Link Found", 0);
//                       
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public boolean checkForRecentUpdatedKeyword(Videokeywords videoKeywords) {
        try {
            String currentDate[] = (new Date()).toString().split(" ");
            String endDate[] = videoKeywords.getMetaCafeUpdatedDate().split(" ");
            System.out.println("============currentDate[]===========" + (new Date()));
            System.out.println("===================endDate=============" + videoKeywords.getMetaCafeUpdatedDate());

            //Tue Jan 20 15:50:36 IST 2015
            //Wed Jan 07 13:45:08 IST 2015
            //Fri Jan 02 13:40:06 IST 2015
            if (currentDate[0].equalsIgnoreCase(endDate[0])) {
                if (currentDate[1].equalsIgnoreCase(endDate[1])) {

                    if (currentDate[2].equalsIgnoreCase(endDate[2])) {

                        if (currentDate[5].equalsIgnoreCase(endDate[5])) {

                            System.out.println("SAME TIME : " + videoKeywords.getVideoKeyword() + " [" + videoKeywords.getVideokeywordID() + "]");
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

    public void run() {
        List<ProxyData> proxylist = objProxyDao.getProxyList();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try {
            for (Videokeywords videoKeywords : lstVideokeywords) {

                if (checkForRecentUpdatedKeyword(videoKeywords)) {
                    continue;
                }
                executor.submit(new MetacafePagenLinks(appContext, objKeywordDao, fetchSourcewithAuthentication, mcUrl, mcKeyword, mcKeywordId, videoKeywords, proxylist));

//                count = 0;
//                List<String> mainlinks = new ArrayList<>();
//                String pagenlinks = "";
//
//                mcUrl = videoKeywords.getMetacafeURL();
//                mcKeyword = videoKeywords.getVideoKeyword();
//                mcKeywordId = videoKeywords.getVideokeywordID();
//
//                if (!videoKeywords.getMetacafeURL().isEmpty()) {
//
//                    mcKeyword = mcKeyword.replace(" ", "_");
//                    System.out.println("Metacafe Keyword = " + mcKeyword);
//                    URI uri = new URIBuilder()
//                            .setScheme("http")
//                            .setHost("metacafe.com")
//                            .setPath("/topics/" + mcKeyword)
//                            .build();
//                    do {
//                        String mainpagename = "/metacafe.txt";
//                        String mainpagepath = fetchSourcewithAuthentication.fetchPageSourceFromMetacafe(uri, mainpagename);
//                //    String mainpagepath = fetchSourcewithAuthentication.getShowPage() + mainpagename;
//
//                        mainlinks = getMetacafePageCitationLinks1(mainpagepath);
//                        //System.out.println("mainlinks"+mainlinks);
//                        matchfound = findSingleLink(mainlinks, mcUrl, count);
//                        if (matchfound) {
//                            break;
//                        }
//                        count = count + mainlinks.size();
//                        System.out.println("count==" + count);
//                        pagenlinks = getMetacafePaginationLinks(mainpagepath);
//                        System.out.println("pagenlinks" + pagenlinks);
//                        // uri = "http://www.metacafe.com" + pagenlinks;
//                        uri = new URIBuilder()
//                                .setScheme("http")
//                                .setHost("metacafe.com")
//                                .setPath(pagenlinks)
//                                .build();
//                        System.out.println("uri==" + uri);
//                    } while (mainlinks.size() != 0);
//
//                    if (!matchfound) {
//
//                        mcKeyword = mcKeyword.replace("_", " ");
//                        objKeywordDao.saveMetacafeResult(mcKeywordId, mcKeyword, "No Link Found", 0);
//
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
            Logger.getLogger(Metacafe_search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getMetacafePageCitationLinks1(String metacafeResponse) {
        List<String> metacitelinks = new ArrayList<>();
        try {

            Document doc = Jsoup.parse(metacafeResponse);
            Elements e2 = doc.select("ul[id=Catalog1] li h1[class=ItemTitle] a");

            for (Element element : e2) {
                //   System.out.println("URL:- " + "http://www.metacafe.com" + element.attr("href"));
                String mclinks = element.attr("href");
//                System.out.println("TITLE : " + element.text());
                metacitelinks.add(mclinks);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metacitelinks;
    }

    public Map<String, String> getMetacafePageCitationLinks(String url) {
        Map<String, String> metacitelinks = new LinkedHashMap<>();
        try {
            File f = new File(url);
            Document doc = Jsoup.parse(f, "UTF-8");
//            Element links = doc.getElementById("Catalog1");
//            Elements links2 = links.getElementsByTag("li");
//            Elements nlinks = links2.select("article > a");
//            for (Element el2 : nlinks) {
//                String mclinks = el2.attr("href");
//                //System.out.println("Main Links "+mclinks);
//                String mctitles = el2.attr("title");
//                //System.out.println("metitles = " + mctitles);
//                metacitelinks.put(mctitles, mclinks);
//            }
//            Document doc = Jsoup.parse(pagepath);
            Elements e2 = doc.select("ul[id=Catalog1] li h1[class=ItemTitle] a");

            for (Element element : e2) {
                System.out.println("URL : " + "http://www.metacafe.com" + element.attr("href"));
                String mctitles = element.attr("href");
//                System.out.println("TITLE : " + element.text());
                String mclinks = element.text();
                metacitelinks.put(mctitles, mclinks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metacitelinks;

    }

    public String getMetacafePaginationLinks(String metacafeResponse) {
        String othpagenlinks = "";
        try {

            Document doc = Jsoup.parse(metacafeResponse);
            Elements plinks = doc.select("div[id=CatalogPageSelector]");
            Elements pagenlinks = plinks.select("ul li[id=Next] a[href]");
            for (Element el1 : pagenlinks) {
                String pilinks = el1.attr("href");
                System.out.println("Pagenation Links : " + "http://www.metacafe.com" + pilinks);
                othpagenlinks = pilinks;
                System.out.println("====================================================================================================================================");
//                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return othpagenlinks;
    }

    public Boolean findMetacafeRank(String title, String domainurl) throws MalformedURLException {
        Boolean fod = false;

        if (domainurl.contains(title)) {
            fod = true;
        }
        return fod;
    }

    public Boolean findSingleLink(List links, String mcUrl, int count) {
        Boolean store = false;

        Iterator itrmap = links.iterator();
        while (itrmap.hasNext()) {
            boolean flag = false;
            String mentry = itrmap.next().toString();
            count++;
            flag = findMetacafeLink(mentry, mcUrl);
            store = false;
            if (flag) {
                metacaferank = count;
                System.out.println("metarank = " + metacaferank);
//insert code here
                objKeywordDao.saveMetacafeResult(mcKeywordId, mcKeyword, mcUrl, metacaferank);
                store = true;
                break;
            }
        }
        return store;
    }

    public Boolean findMetacafeLink(String link, String mcUrl) {

        mcUrl = mcUrl + "/";
        System.out.println("link" + link);
        System.out.println("mcUrl" + mcUrl);
        Boolean fod = false;
        if (mcUrl.contains(link) || link.contains(mcUrl)) {
            System.out.println("match found");
            fod = true;
        }
        return fod;
    }
}
