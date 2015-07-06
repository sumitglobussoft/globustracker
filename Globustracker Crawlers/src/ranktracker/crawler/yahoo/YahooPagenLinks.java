/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.yahoo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
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
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Serpkeywords;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.Yahoo_search;

/**
 *
 * @Laxmi Kiran Nallam (laxmikiran@globussoft.com)
 */
public class YahooPagenLinks implements Callable<String> {

    Serpkeywords objSerpKeeywords;
    ApplicationContext appContext;
    KeywordsDao objKeywordDao;
    FetchPagewithClientAthentication fetchSourcewithProx;
    Yahoo_search yahoosearch;
    int keywordNumber = 0;
    List<ProxyData> proxyList;

//    public String yaUrl;
//    public String yaKeyword;
    public String yaLinkYahoo = "search.yahoo.com";
    public int yaCrawlCount;
//    public Integer yaKeywordID;
    boolean found = false;
//    public String bestMatchLinkYahoo = "No Link Found";

//    public int bestMatchRankYahoo;
    // int newWebRankYahoo;
    boolean bestMatchRankFound = false;
    boolean rankFound = false;
    int counter = 0;

    static org.apache.log4j.Logger l = org.apache.log4j.Logger.getLogger(Yahoo_search.class.getName());

    public YahooPagenLinks(Serpkeywords objSerpKeeywords, ApplicationContext appContext, int i, List<ProxyData> proxyList) {
//        this.yaUrl = yaUrl;
//        this.yaKeyword = yaKeyword;
//        this.yaLinkYahoo = yaLinkYahoo;
//        this.yaKeywordID = yaKeywordID;
        this.objSerpKeeywords = objSerpKeeywords;
        this.appContext = appContext;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.fetchSourcewithProx = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
        this.yahoosearch = appContext.getBean("yahooSearch", Yahoo_search.class);
        this.keywordNumber = i;
        this.proxyList = proxyList;
    }

    public List getOtherYahooPageLinksCrawl(Queue pagenLinks, int portno) throws IOException, InterruptedException, URISyntaxException {
        //ApplicationContext applcontext,String goKeyword,String goUrl,Integer goKeywordId
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.println("----------------------**----------------");
        //CloseableHttpClient httpclient=HttpClients.custom().setConnectionManager(executor).build();

        List<Future<Queue<String>>> future = new ArrayList<>();
        List<String> pageslist = new ArrayList<>();
        String lstpage = null;
        Queue pagelist = pagenLinks;
        Iterator itr = pagelist.iterator();
        for (int i = 0; itr.hasNext(); i++) {
            String pl = (String) itr.next();
            lstpage = pl;
            pageslist.addAll(getExtraPageLinksCrawl(pl, future, executor, i, portno));
        }

        System.out.println("Total size of pagelist is " + pageslist.size());
        executor.shutdown();
        return pageslist;
    }

    public List getExtraPageLinksCrawl(String newpageurl, List<Future<Queue<String>>> future, ExecutorService executor, int i, int portno) throws IOException, InterruptedException {
        List<String> newpagelinks = new LinkedList<>();
        HttpGet httpget = new HttpGet((String) newpageurl);
        future = ((List<Future<Queue<String>>>) executor.invokeAll((Arrays.asList(new GetYahooThread(httpget, i, portno)))));
        for (Future<Queue<String>> futur : future) {
            try {
                while (!futur.get().isEmpty()) {
                    String s = futur.get().poll();
                    newpagelinks.add(s);
                }
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(YahooPagenLinks.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return newpagelinks;
    }

    public boolean getRank(String url, String domain) throws MalformedURLException {

        // System.out.println("getRank");
        // System.out.println("url: " + url);
        // System.out.println("domain: " + domain);
        String tempurl = url.replace("https://", "").replace("http://", "").replace("www.", "");
        tempurl = tempurl.replace("/", "");
       
        String tempdomain = domain.replace("/", "");

        if (tempurl.equalsIgnoreCase(tempdomain)) {
            // System.out.println("one");
            return true;
        } else if (!domain.contains("/")) {
            if (new URL("http://" + url.replace("http://", "").replace("https://", "").replace("www.", "")).getHost().toString().equalsIgnoreCase(new URL("http://" + domain).getHost().toString())) {
                //System.out.println("two");
                return true;
            }
        }
        return false;
    }

    public boolean findRanks(Document doc, int page) throws MalformedURLException {

       // Elements results = doc.select("div[id=web] ol li span[class*=url]");
        Elements results = doc.select("div[id=web] ol li div[class=compTitle options-toggle] span[class]");
        System.out.println("-- PAGE : " + page);
        for (Element result : results) {
            try {
                counter++;
                String url = "http://" + result.text();
                //String url = result.select("cite").first().text();
                System.out.println("        -- RESULT : " + counter + " --- ---- ---- ---- ---- ---- ");
                System.out.println("        -- URL : " + url);

                if (!bestMatchRankFound) {
                    if (new URL("http://" + url.replace("http://", "").replace("https://", "").replace("www.", "")).getHost().toString().equalsIgnoreCase(new URL("http://" + objSerpKeeywords.getUrl()).getHost().toString())) {
                        objSerpKeeywords.setBestMatchRankYahoo(counter);
                        bestMatchRankFound = true;
                        objSerpKeeywords.setBestMatchLinkYahoo(url);
                        System.out.println("        -- Best Match Link : " + objSerpKeeywords.getBestMatchLinkYahoo());
                        System.out.println("        -- Best Match Rank : " + objSerpKeeywords.getBestMatchRankYahoo());

                    }
                }

                if (!rankFound) {
                    // url = result.select("cite").first().text();
                    if (getRank(url, objSerpKeeywords.getUrl())) {
                        objSerpKeeywords.setRankYahoo(counter);
                        rankFound = true;
                        System.out.println("        -- Rank Found : " + objSerpKeeywords.getRankYahoo());
                        return true;

                    }
                }
            } catch (Exception ew) {
            }
        }
        return false;
    }

    @Override
    public String call() throws InterruptedException {
        try {
            System.out.println("== [ " + this.keywordNumber + " ] =======================================================================================================");
            System.out.println("------ YahooPagenLinks");
            System.out.println("    -- yaKeyword = " + objSerpKeeywords.getKeyword());
            System.out.println("    -- yaKeywordID = " + objSerpKeeywords.getKeywordID());
            System.out.println("    -- yaLinkYahoo = " + yaLinkYahoo);
            System.out.println("    -- yaUrl = " + objSerpKeeywords.getUrl());

            String yahoostring = "http://" + yaLinkYahoo + "/search?p=" + objSerpKeeywords.getKeyword().replace(" ", "+");
            System.out.println("    -- Yahoo Url: " + yahoostring);

            Document doc = Jsoup.parse(fetchSourcewithProx.fetchPageSourcefromClientGoogle(new URI(yahoostring), "", 0, this.proxyList));

           // System.out.println("" + doc);
            findRanks(doc, 1);

//            if (!rankFound) {
//                String nextLink;
//                for (int i = 2; i < 26; i++) {
//                    try {
//                        nextLink = doc.select("a[id=pg-next]").first().attr("href");
//                        System.out.println("nextLink : " + nextLink);
//                        doc = Jsoup.parse(fetchSourcewithProx.fetchPageSourcefromClientGoogle(new URI(nextLink), "", 0, this.proxyList));
//                        if (findRanks(doc, i)) {
//                            break;
//                        }
//                    } catch (Exception ex) {
//                        System.out.println("EXCEPTION IN PAGINATION : " + ex);
//                    }
//                }
//            }

            System.out.println("bestMatchRankYahoo : " + objSerpKeeywords.getBestMatchRankYahoo());
            System.out.println("bestMatchLinkYahoo : " + objSerpKeeywords.getBestMatchLinkYahoo());
            System.out.println("rankYahoo : " + objSerpKeeywords.getRankYahoo());
           objKeywordDao.saveResult(objSerpKeeywords.getKeywordID(), objSerpKeeywords.getRankYahoo(),objSerpKeeywords.getBestMatchRankYahoo(), objSerpKeeywords.getBestMatchLinkYahoo(), "yahoo.com",objSerpKeeywords.getKeyword(),objSerpKeeywords.getUrl());
        } catch (Exception run1) {
            Logger.getLogger(Yahoo_search.class.getName()).log(Level.SEVERE, null, run1);
            run1.printStackTrace();
            return "failed";
        }
        return "success";
    }

//    @Override
//    public String call() throws InterruptedException {
//        System.out.println("== [ " + this.keywordNumber + " ] =======================================================================================================");
//        System.out.println("------ YahooPagenLinks");
//        System.out.println("    -- yaKeyword = " + objSerpKeeywords.getKeyword());
//        System.out.println("    -- yaKeywordID = " + objSerpKeeywords.getKeywordID());
//        System.out.println("    -- yaLinkYahoo = " + yaLinkYahoo);
//        System.out.println("    -- yaUrl = " + objSerpKeeywords.getUrl());
//
//        // yaLinkYahoo = "in.search.yahoo.com";
//        Boolean foundmatch = false;
//        Queue<String> mainlinks = new LinkedList<>();
//        int j = 1;
//
//        try {
//            for (int i = 1; i <= 600; i = i + 100) {
//                int l = 0;
//                String basicuri = new URIBuilder()
//                        .setScheme("http")
//                        .setHost(yaLinkYahoo)
//                        .build()
//                        .toString();
//                String input = fetchSourcewithProx.fetchPageSourcefromClientYahoo(basicuri, this.proxyList);
////                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~" + input);
////            String input=FetchGooglePage.fetchGoogleIndex(basicuri);
//                try {
//
//                    String proxylt = getYahooylt(input);
//
//                    String uri = new URIBuilder()
//                            .setScheme("http")
//                            .setHost(yaLinkYahoo)
//                            .setPath("/search;" + proxylt)
//                            .setParameter("p", objSerpKeeywords.getKeyword())
//                            //                          .setParameter("toggle", "1")
//                            //                          .setParameter("cop", "mss")
//                            .setParameter("ei", "UTF-8")
//                            //                          .setParameter("fr2", "sb-top")
//                            .setParameter("fr", "yfp-t-746")
//                            .setParameter("b", "" + i)
//                            .setParameter("pstart", "" + j)
//                            .setParameter("n", "100")
//                            .build()
//                            .toString();
////                    System.out.println("*************" + uri);//4
//                    String mainpage = fetchSourcewithProx.fetchPageSourcefromClientYahoo(uri, this.proxyList);
//                    while (mainpage.length() < 100 && l <= 4) {
//                        System.out.println("second attempt searchurl = " + uri);
//                        mainpage = fetchSourcewithProx.fetchPageSourcefromClientYahoo(uri, this.proxyList);
//                        l++;
//                    }
//                    mainlinks = getYahooMainLinks(mainpage);
//                    if (mainlinks == null) {
//                        System.out.println("NO Results for" + objSerpKeeywords.getKeyword());
//                        break;
//                    }
//                } catch (NullPointerException e) {
//                }
//                // System.out.println(mainlinks);
//                if (i <= 10) {
//                    foundmatch = findLinksofSite(mainlinks, i, objSerpKeeywords.getUrl());
//                    System.out.println("    ~~~~~~~~~~~ FOUND MATCH URL ~~~~~~~~~~~~~" + foundmatch);
//                } else {
//                    foundmatch = findLinksofSite(mainlinks, i / 2, objSerpKeeywords.getUrl());
//                    System.out.println("    ~~~~~~~~~~~ FOUND MATCH URL ~~~~~~~~~~~~~" + foundmatch);
//                }
//                if (foundmatch) {
//                    System.out.println("    complete");
//                    objKeywordDao.saveResult(objSerpKeeywords.getKeywordID(), objSerpKeeywords.getBestMatchRankYahoo(), objSerpKeeywords.getBestMatchRankYahoo(), objSerpKeeywords.getBestMatchLinkYahoo(), "yahoo.com");
//                    System.out.println("    saved");
//                    System.out.println("    ------finish keyword" + objSerpKeeywords.getKeyword() + "-----------");
//                    break;
//                } else {
//                }
//                j++;
//            }
//            if (!foundmatch) {
//                objKeywordDao.saveResult(objSerpKeeywords.getKeywordID(), 0, objSerpKeeywords.getBestMatchRankYahoo(), "No link found", "yahoo.com");
//                System.out.println("    ------finish keyword" + objSerpKeeywords.getKeyword() + "-----------");
//            }
//
//        } catch (Exception ex) {
//        }
//
//        return "success";
//    }
//    @Override
//    public void run() {
//        System.out.println("------start keyword" + objSerpKeeywords.getKeyword() + "-----------");
//        yaLinkYahoo = "in.search.yahoo.com";
//        int yaCrawlCount;
//        Boolean foundmatch = false;
//        int tStop = 0;
//        Queue<String> mainlinks = new LinkedList<>();
//        Queue<String> pagenyahoolinks = new LinkedList<>();
//        int j = 1;
//        int portno = generateRandomPortforYahoo();
//
//        try {
//            for (int i = 1; i <= 600; i = i + 100) {
//                int l = 0;
//                String basicuri = new URIBuilder()
//                        .setScheme("http")
//                        .setHost(yaLinkYahoo)
//                        .build()
//                        .toString();
//                String input = fetchSourcewithProx.fetchPageSourcefromClientYahoo(basicuri, this.proxyList);
////                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~" + input);
////            String input=FetchGooglePage.fetchGoogleIndex(basicuri);
//                try {
//
//                    String proxylt = getYahooylt(input);
//
//                    String uri = new URIBuilder()
//                            .setScheme("http")
//                            .setHost(yaLinkYahoo)
//                            .setPath("/search;" + proxylt)
//                            .setParameter("p", yaKeyword)
//                            //                          .setParameter("toggle", "1")
//                            //                          .setParameter("cop", "mss")
//                            .setParameter("ei", "UTF-8")
//                            //                          .setParameter("fr2", "sb-top")
//                            .setParameter("fr", "yfp-t-746")
//                            .setParameter("b", "" + i)
//                            .setParameter("pstart", "" + j)
//                            .setParameter("n", "100")
//                            .build()
//                            .toString();
////                    System.out.println("*************" + uri);//4
//                    String mainpage = fetchSourcewithProx.fetchPageSourcefromClientYahoo(uri, this.proxyList);
//                    while (mainpage.length() < 100 && l <= 4) {
//                        System.out.println("second attempt searchurl = " + uri);
//                        mainpage = fetchSourcewithProx.fetchPageSourcefromClientYahoo(uri, this.proxyList);
//                        l++;
//                    }
//                    mainlinks = getYahooMainLinks(mainpage);
//                    if (mainlinks == null) {
//                        System.out.println("NO Results for" + yaKeyword);
//                        break;
//                    }
//                } catch (NullPointerException e) {
//                }
//                // System.out.println(mainlinks);
//                if (i <= 10) {
//                    foundmatch = findLinksofSite(mainlinks, i, yaUrl);
//                    System.out.println("~~~~~~~~~~~ FOUND MATCH URL ~~~~~~~~~~~~~" + foundmatch);
//                } else {
//                    foundmatch = findLinksofSite(mainlinks, i / 2, yaUrl);
//                    System.out.println("~~~~~~~~~~~ FOUND MATCH URL ~~~~~~~~~~~~~" + foundmatch);
//                }
//                if (foundmatch) {
//                    System.out.println("complete");
//                    objKeywordDao.saveResult(yaKeywordID, bestMatchRankYahoo, bestMatchRankYahoo, bestMatchLinkYahoo, "yahoo.com");
//                    System.out.println("saved");
//                    System.out.println("------finish keyword" + yaKeyword + "-----------");
//                    break;
//                } else {
//                }
//                j++;
//            }
//            if (!foundmatch) {
//                objKeywordDao.saveResult(yaKeywordID, 0, bestMatchRankYahoo, "No link found", "yahoo.com");
//                System.out.println("------finish keyword" + yaKeyword + "-----------");
//            }
//
//        } catch (Exception ex) {
//        }
//    }
    public static Queue<String> getYahooMainLinks(String mainpage) {
        int count = 0;
        Queue<String> l = new LinkedList<>();
        Queue<String> newlink = new LinkedList<>();
        try {
//            Document doc = Jsoup.parse(mainpage);
//            Element links = doc.getElementById("web");
//            Elements links1 = links.getElementsByTag("li");
//            Elements links2 = links1.select("div[class=res]");
//            Elements nlinks = links2.select("span[class=url]");
//            for (Element el2 : nlinks) {
//                String golinks = el2.text();
//                System.out.println(golinks);
//                l.add(golinks);
//            }
//            //System.out.println("-------------------------------");
//            Iterator itr = l.iterator();
//            while (itr.hasNext()) {
//                String link = itr.next().toString();
//
//                newlink.add(link);
//
//            }
            Document doc = Jsoup.parse(mainpage);
            Elements e1 = doc.select("div[id=web]");
            Elements e2 = e1.select("li div[class=res] span[class^=url]");

            for (Element el2 : e2) {
//                String golinks = el2.text();
//              System.out.println(golinks);
//                l.add(golinks);
                if (el2.text().contains("")) {
                    String[] str = el2.text().split("");
//                    System.out.println("" + str[0]);
//                    l.add(str[0]);
                } else {
                    String golinks = el2.text();
//                    System.out.println(golinks); //1
                    l.add(golinks);
                }
            }

            //  System.out.println("------------------FETCHING YAHOO URL-------------------");
            Iterator itr = l.iterator();
            while (itr.hasNext()) {
                String link = itr.next().toString();
//                System.out.print(link); //2
                newlink.add(link);
            }
        } catch (Exception e) {
            return null;
        }
        return newlink;
    }

    public static String getYahooylt(String input) {
        String[] stringylt = new String[2];

        Document doc;
        try {
            doc = Jsoup.parse(input);
            Element links = doc.getElementById("sf");
            String links1 = links.attr("action");
            stringylt = links1.split(";");
//            System.out.println(stringylt[1]); //3
        } catch (NullPointerException e) {
//            e.printStackTrace();
        }

        return stringylt[1];
    }

    public Boolean findLinksofSite(Queue mainlinks, int count, String yaUrl) {
        String bestmatchlink = null;
        Boolean foundmatch = false;
        Boolean flag = true;
        Boolean flag2 = true;
        Boolean fond2 = false;

        int bestfirstMatchRankYahoo = 0;
        int newWebRankYahoo = 0;
        try {
            Iterator itrr = mainlinks.iterator();
            while (itrr.hasNext()) {
                String linksinpage = (String) itrr.next();
                System.out.println(linksinpage);

                System.out.print(count + " ");
                Boolean fond = false;

                bestmatchlink = findBestMatchLink(linksinpage, yaUrl);

                if (bestmatchlink != null) {
                    if (flag2) {
                        objSerpKeeywords.setBestMatchLinkYahoo(bestmatchlink);
                        System.out.println("bestMatchLink"
                                + "Yahoo = " + bestmatchlink);
                        bestfirstMatchRankYahoo = count;
                        objSerpKeeywords.setBestMatchRankYahoo(bestfirstMatchRankYahoo);

                        System.out.println("bestMatchRankYahoo = " + bestfirstMatchRankYahoo);
                        foundmatch = true;
                    }
                    return foundmatch;
                }
                count++;

//                fond = findYahooLinkRank(linksinpage, yaKeyword, yaUrl);
//                if (fond2) {
//                    if (fond) {
//                        if (flag) {
//                            newWebRankYahoo = count;
//                            System.out.println("newWebRankYahoo = " + newWebRankYahoo);
//                            System.out.println("Best Matched Url " + linksinpage);
//                            objKeywordDao.saveResult(yaKeywordID, newWebRankYahoo, bestfirstMatchRankYahoo, bestMatchLinkYahoo, "yahoo.com");
//                            foundmatch = true;
//                            flag = false;
//                            break;
//                        }
//                    }
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundmatch;
    }

    public static String findBestMatchLink(String newurl, String domainurl) {
        String bestmatch = null;
        String[] domainsparts = new String[5];
        if (domainurl.contains("/")) {
            domainsparts = domainurl.split("/");
        } else {
            domainsparts[0] = domainurl;
        }
        if (newurl.contains(domainsparts[0])) {
            if (newurl.contains("www.")) {
                String spliturl = newurl.replace("www.", "");
                bestmatch = spliturl;
            } else if (newurl.contains("http:")) {
                String spliturl = newurl.replace("http://", "");
                bestmatch = spliturl;
            } else if (newurl.contains("https:")) {
                String spliturl = newurl.replace("https://", "");
                bestmatch = spliturl;
            } else {
                bestmatch = newurl;
            }
        }
        return bestmatch;
    }

//    public Boolean storeLinksofSite(Queue mainlinks) {
//        String bestmatchlink = null;
//        Boolean foundmatch = false;
//        Boolean flag = true;
//        Boolean flag2 = true;
//        Boolean fond2 = false;
//        int count = 0;
//        int bestfirstMatchRankYahoo = 0;
//        int newWebRankYahoo = 0;
//        try {
//            Iterator itrr = mainlinks.iterator();
//            while (itrr.hasNext()) {
//                String linksinpage = (String) itrr.next();
//                count++;
//                Boolean fond = false;
//
//                bestmatchlink = findBestMatchLink(linksinpage, yaUrl);
//                if (bestmatchlink != null) {
//                    if (flag2) {
//                        bestMatchLinkYahoo = bestmatchlink;
//                        System.out.println("bestMatchLinkYahoo = " + bestMatchLinkYahoo);
//                        bestfirstMatchRankYahoo = count;
//                        System.out.println("bestMatchRankYahoo = " + bestfirstMatchRankYahoo);
//                        fond2 = true;
//                        flag2 = false;
//                    }
//                }
//                fond = findYahooLinkRank(linksinpage, yaKeyword, yaUrl);
//                if (fond2) {
//                    if (fond) {
//                        if (flag) {
//                            newWebRankYahoo = count;
//                            System.out.println("newWebRankYahoo = " + newWebRankYahoo);
//                            System.out.println("Best Matched Url " + linksinpage);
//                            objKeywordDao.saveResult(yaKeywordID, newWebRankYahoo, bestfirstMatchRankYahoo, bestMatchLinkYahoo, "yahoo.com");
//                            foundmatch = true;
//                            flag = false;
//                            break;
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return foundmatch;
//    }
//    public List<String> getExtraYahooLinks(String yahookeyword) throws URISyntaxException {
//        FetchPagewithClientAthentication fetchclientpage = new FetchPagewithClientAthentication();
//        List otherlinks = new ArrayList();
//        int portno = generateRandomPortforYahoo();
//        //http://search.yahoo.com/search?n=100&ei=UTF-8&va_vt=any&vo_vt=any&ve_vt=any&vp_vt=any&vst=0&vf=all&vm=i&fl=0&fr=yfp-t-900&p=ipage+reviews&vs=
//        URI uri = new URIBuilder()
//                .setScheme("http")
//                .setHost("search.yahoo.com")
//                .setPath("/search")
//                .setParameter("n", "100")
//                .setParameter("ei", "UTF-8")
//                .setParameter("va_vt", "any")
//                .setParameter("vo_vt", "any")
//                .setParameter("ve_vt", "any")
//                .setParameter("vp_vt", "any")
//                .setParameter("vst", "0")
//                .setParameter("vf", "all")
//                .setParameter("vm", "i")
//                .setParameter("fl", "0")
//                .setParameter("fr", "yfp-t-900")
//                .setParameter("p", yahookeyword)
//                .setParameter("vs", "")
//                .build();
//        Queue<String> mainlinks = new LinkedList<>();
//        Queue<String> pagenlinks = new LinkedList<>();
//        //Queue<String> newpagenlinks = new LinkedList<>();
//        String threadname = Thread.currentThread().getName();
//        String mainpage = fetchSourcewithProx.getShowPage() + "/" + threadname + ".txt";
//        try {
//            fetchclientpage.fetchPageSourcefromClientYahoo(uri, "/" + threadname + ".txt", portno);
//            mainlinks = yahoosearch.getYahooMainLinks(mainpage);
//            pagenlinks = getYahooPageinationLinks(mainpage);
//            File f = new File(mainpage);
//            f.delete();
//            otherlinks = getOtherYahooPageLinksCrawl(pagenlinks, portno);
//            otherlinks.addAll(mainlinks);
//            System.out.println("Pagen Links Length " + pagenlinks.size());
//
//        } catch (IOException | InterruptedException | URISyntaxException ex) {
//            java.util.logging.Logger.getLogger(Yahoo_search.class.getName()).log(Level.SEVERE, null, ex);
//            ex.printStackTrace();
//        }
//        return otherlinks;
//    }
//
//    public String getYahooylt(String pagepath) {
//        String[] stringylt = new String[2];
//        File input = new File(pagepath);
//        Document doc;
//        String links1 = null;
//        try {
//            doc = Jsoup.parse(input, "UTF-8");
//            Element links = doc.getElementById("sf");
//            links1 = links.attr("action");
//            stringylt = links1.split(";");
//            System.out.println(stringylt[1]);
//        } catch (IOException ex) {
//            java.util.logging.Logger.getLogger(Yahoo_search.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return stringylt[1];
//    }
//
//    public String findBestMatchLink(String newurl, String domainurl) {
//        String bestmatch = null;
//        String[] domainsparts = new String[5];
//        if (domainurl.contains("/")) {
//            domainsparts = domainurl.split("/");
//        } else {
//            domainsparts[0] = domainurl;
//        }
//        if (newurl.contains(domainsparts[0])) {
//            if (newurl.contains("www.")) {
//                String spliturl = newurl.replace("www.", "");
//                bestmatch = spliturl;
//            } else if (newurl.contains("http:")) {
//                String spliturl = newurl.replace("http://", "");
//                bestmatch = spliturl;
//            } else if (newurl.contains("https:")) {
//                String spliturl = newurl.replace("https://", "");
//                bestmatch = spliturl;
//            } else {
//                bestmatch = newurl;
//            }
//        }
//        return bestmatch;
//    }
//
//    public Queue<String> getNewYahooPageinationLinks(String filepath) {
//        Queue<String> pagenlinks = new LinkedList<>();
//        try {
//            File input = new File(filepath);
//            Document doc = Jsoup.parse(input, "UTF-8");
//            Element links = doc.getElementById("pg");
//            Elements nlinks = links.select("a[href]");
//            for (Element el2 : nlinks) {
//                String golinks = el2.attr("href");
//                System.out.println(golinks);
//                pagenlinks.add(golinks);
//            }
//            int pagenlinksize = pagenlinks.size() / 2;
//            Iterator itr = pagenlinks.iterator();
//            int c = 0;
//            while (itr.hasNext()) {
//                Object o = itr.next();
//                c++;
//                if (pagenlinksize == c) {
//                    pagenlinks.poll();
//                }
//            }
//            System.out.println("Pagen Links size --------------" + pagenlinks.size());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return pagenlinks;
//    }
//
//    public Boolean findYahooLinkRank(String newurl, String keyword, String domainurl) {
//        Boolean fod = false;
//        Boolean flag = false;
//        String[] domainsparts = new String[5];
//        if (domainurl.contains("/")) {
//            domainsparts = domainurl.split("/");
//            flag = true;
//        } else {
//            domainsparts[0] = domainurl;
//        }
//        if (flag) {
//            for (int i = 1; i < domainsparts.length; i++) {
//                if (newurl.contains(domainsparts[0]) && newurl.contains(domainsparts[i])) {
//                    if (newurl.contains(domainurl)) {
//                        fod = true;
//                    }
//                }
//            }
//        } else {
//            if (newurl.contains(domainurl) && newurl.contains(domainsparts[0])) {
//                fod = true;
//            }
//        }
//        return fod;
//    }
//
//    public Queue<String> getYahooPageinationLinks(String filepath) {
//        Queue<String> pagenlinks = new LinkedList<>();
//        try {
//            File input = new File(filepath);
//            Document doc = Jsoup.parse(input, "UTF-8");
//            Element links = doc.getElementById("pg");
//            Elements nlinks = links.select("a[href]");
//            for (Element el2 : nlinks) {
//                String golinks = el2.attr("href");
//                System.out.println(golinks);
//                pagenlinks.add(golinks);
//            }
//            int pagenlinksize = pagenlinks.size();
//            Iterator itr = pagenlinks.iterator();
//            int c = 0;
//            while (itr.hasNext()) {
//                String o = itr.next().toString();
//                c++;
//                if (pagenlinksize == c) {
//                    pagenlinks.remove(o);
//                }
//            }
//            System.out.println("Pagen Links size --------------" + pagenlinks.size());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return pagenlinks;
//    }
//
//    /**
//     * public List<String> getExtraLinks(Queue<String> pageslist) throws
//     * URISyntaxException { List<String> pageotherlinks = new LinkedList<>();
//     * while (pageslist.size() > 1) { pageslist.poll(); } if (pageslist.size()
//     * == 1) { try { String lastPageLink = pageslist.peek();
//     *
//     * File input = new File(lastPageLink); Document doc = Jsoup.parse(input,
//     * "UTF-8"); Element links = doc.getElementById("pg"); Elements nlinks =
//     * links.select("a[href]"); List<String> pagenlinks = new
//     * ArrayList<String>();
//     *
//     * for (Element el2 : nlinks) { String golinks = el2.attr("href");
//     * pagenlinks.add(golinks); } for (int i = 3; i < pagenlinks.size() - 1;
//     * i++) { pageotherlinks.add(pagenlinks.get(i)); } List other; other =
//     * getOtherYahooPageLinksCrawl((Queue) pageotherlinks,portno); Boolean
//     * foundmatch = storeLinksofSite((Queue) other); } catch
//     * (IOException|InterruptedException ex) {
//     * Logger.getLogger(YahooPagenLinks.class.getName()).log(Level.SEVERE, null,
//     * ex); } } return pageotherlinks; }
//     */
//    /**
//     * public List getYahooSecondaryPageLinks(Queue pagenyahoolinkscopy) { int
//     * checkcount = 0; String lastpage = null; List otherpagenmainlinks = new
//     * CopyOnWriteArrayList(); int pagenlinksize;
//     *
//     * pagenlinksize = pagenyahoolinkscopy.size(); Iterator ittr =
//     * pagenyahoolinkscopy.iterator(); int c = 0; while (ittr.hasNext()) {
//     * Object o = ittr.next(); c++; if (pagenlinksize == c) { lastpage =
//     * o.toString(); } } System.out.println("lastpage ========== " + lastpage);
//     * List<String> newpagenyahoolinks = new CopyOnWriteArrayList<>(); do { if
//     * (lastpage != null) { try { HttpGet httpget = new HttpGet((String)
//     * "http://search.yahoo.com" + lastpage);
//     * fetchSourcewithProx.fetchPageSourcefromClientYahoo(httpget.getURI(),
//     * "yahoolastpage" + Thread.currentThread().getName() + ".txt",port); String
//     * lastlinkspage = fetchSourcewithProx.getShowPage() + "/yahoolastpage" +
//     * Thread.currentThread().getName() + ".txt"; newpagenyahoolinks = (List)
//     * getNewYahooPageinationLinks(lastlinkspage); File f = new
//     * File(lastlinkspage); f.delete();
//     * otherpagenmainlinks.addAll(getOtherYahooPageLinksCrawl((Queue)
//     * newpagenyahoolinks));
//     *
//     * } catch (IOException | InterruptedException | URISyntaxException e) {
//     * e.printStackTrace(); } } pagenlinksize = pagenyahoolinkscopy.size();
//     * Iterator newlastpagesittr = pagenyahoolinkscopy.iterator(); c = 0; while
//     * (newlastpagesittr.hasNext()) { Object o = newlastpagesittr.next(); c++;
//     * if (pagenlinksize == c) { lastpage = o.toString(); } } checkcount++; }
//     * while (checkcount != 5);
//     *
//     * return otherpagenmainlinks; }
//     */
//    /**
//     * This method generates random port number from 2732 to 2829
//     *
//     */
    private int generateRandomPortforYahoo() {

        Random random = new Random();
        int[] portList = new int[98];
        int portBegin = 2732;
        int portNo;

        for (int i = 0; i < portList.length; i++) {
            portList[i] = portBegin;
            portBegin = portBegin + 1;
        }

        int num = random.nextInt(98);
        portNo = portList[num];
        return portNo;
    }
}
