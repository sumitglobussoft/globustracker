/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
import ranktracker.crawler.google.GetGoogleThread;
import ranktracker.dao.KeywordsDao;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class GooglePagenLinksSearch implements Runnable {

    ApplicationContext appContext;
    String goUrl;
    String goKeyword;
    String goLinkGoogle;
    int goCrawlCount;
    int goKeywordID;
    String bestMatchLinkGoogle;
    KeywordsDao objKeywordDao;
    FetchPagewithClientAthentication fetchclientpage;
    Google_search googleSearch;
    private int portno;

    public GooglePagenLinksSearch(String goUrl, String goKeyword, String goLinkGoogle, int goKeywordID, ApplicationContext applicationContext) {
        this.goUrl = goUrl;
        this.goKeyword = goKeyword;
        this.goLinkGoogle = goLinkGoogle;
        this.goKeywordID = goKeywordID;
        this.appContext = applicationContext;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
        this.googleSearch = appContext.getBean("googleSearch", Google_search.class);
    }

    public GooglePagenLinksSearch() {
    }

    public List<String> getGoogleOtherPageLinksCrawl(Queue pagenLinks, String goLinkGoogle, String goUrl,int portNo)
            throws IOException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Queue<String>>> future = new ArrayList<>();
        List<String> pageslist = new ArrayList<>();
        Queue pagelist = pagenLinks;
        String lstpage = null;
        Iterator itr = pagelist.iterator();
        for (int i = 0; itr.hasNext(); i++) {
            String pl = (String) itr.next();
            pageslist.addAll(getExtraPageLinksCrawl(pl, future, executor, i, goLinkGoogle,portNo));
            Boolean foundmatch = findLinksofDomaininPagination(pageslist, goUrl);
            if (foundmatch) {
                return pageslist;
            }
            lstpage = pl;
        }
        int str1 = 0;
        String str2 = null;
        String[] splitstring1 = lstpage.split("\\&start\\=");
        String newsplitstring1 = splitstring1[1];
        str1 = Integer.parseInt(newsplitstring1.substring(0, 2));
        str2 = newsplitstring1.substring(2, newsplitstring1.length());
        for (int i = 0; i < 25; i++) {
            str1 = str1 + 10;
            lstpage = new StringBuilder().append(splitstring1[0]).append("&start=").append(str1).append(str2).toString();
            System.out.println("URL = " + lstpage);
            pageslist.addAll(getExtraPageLinksCrawl(lstpage, future, executor, i, goLinkGoogle,portNo));
            Boolean foundmatch = findLinksofDomaininPagination(pageslist, goUrl);
            if (foundmatch) {
                return pageslist;
            }
        }
        System.out.println("Total size of pagelist is " + pageslist.size());
        executor.shutdown();
        return pageslist;
    }

    public List getExtraPageLinksCrawl(String newpageurl, List<Future<Queue<String>>> future,
            ExecutorService executor, int i, String goLinkGoogle,int portNo) throws IOException, InterruptedException {
        List<String> newpagelinks = new LinkedList<>();
        HttpGet httpget = new HttpGet((String) "https://" + goLinkGoogle + newpageurl);
        future = ((List<Future<Queue<String>>>) executor.invokeAll((Arrays.asList(new GetGoogleThread(httpget, i,portNo)))));
        for (Future<Queue<String>> futur : future) {
            try {
                while (!futur.get().isEmpty()) {
                    String s = futur.get().poll();
                    //   System.out.println(s);
                    newpagelinks.add(s);
                }
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(GooglePagenLinksSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return newpagelinks;
    }

    public Boolean findLinksofDomaininPagination(List linkslist, String domainurl) {
        Boolean foundmatch = false;
        Iterator itr = linkslist.iterator();
        while (itr.hasNext()) {
            String o = itr.next().toString();
            if (o.contains(domainurl)) {
                foundmatch = true;
                break;
            }
        }
        return foundmatch;
    }

    @Override
    public void run() {
        Queue<String> mainlinks = new LinkedList<>();
        Queue<String> pagenlinks = new LinkedList<>();
        Queue<String> newpagenlinks = new LinkedList<>();
        String responsebody = null;
        int tStop = 0;
              try {
            List otherlinks = new ArrayList();
            goCrawlCount = 0;
            String bestmatchlink = null;
            System.out.println("goLinkGoogle = " + goLinkGoogle);
            System.out.println("goKeyword = " + goKeyword);
            //String newurl="https://www.google.com/search?num=30&q="+goKeyword+"&oq="+goKeyword;
            //https://www.google.com/search?q=upper%20division%20marketing&ie=utf-8&oe=utf-8&aq=t&rls=org.mozilla:en-US:official&client=firefox-a&channel=np&source=hp
            URI newurl = new URIBuilder()
                    .setScheme("https")
                    .setHost(goLinkGoogle)
                    .setPath("/search")
                    .setParameter("q", goKeyword)
                    .build();
            System.out.println("newurl ===================== " + newurl);
            Boolean foundmatch = true;
            String mainpagename = "/googlemainpage" + Thread.currentThread() + ".txt";
            String mainpage = fetchclientpage.getShowPage() + mainpagename;
            try {
                //Fetches page source using proxy and writes the file in a location with name 'googlemainpage.txt'
                responsebody = fetchclientpage.fetchPageSourcefromClientGoogle(newurl, mainpagename,portno);
//                System.out.println("mainpage = " + mainpage);
                //Fetches all the main links in first page
                // mainlinks = googleSearch.getGooglePageCitationLinks(mainpage);
                mainlinks = getGooglePageCitationLinksFromString(responsebody);
                //Fetches pagination links first page
                pagenlinks = getGooglePagenationLinksfromString(responsebody);
                //Checks whether any of main links matches the domain url
                foundmatch = findLinksofSite(mainlinks);

                if (foundmatch) {
                    tStop = 1;

                    //Deletes the file
//                    File f = new File(mainpage);
//                    f.delete();

                    //Storing the Urls which are fetched from first page
//                    String path = goKeyword + ".txt";
//                    Queue firstPageLinks = new LinkedList<>(mainlinks);
//                    writeUrlFile(firstPageLinks, path);
//                    System.out.println("pageslist.size() " + mainlinks.size());
                }

                if (tStop != 1) {


                    //Deletes the file
                    File f = new File(mainpage);
                    f.delete();

                    //pagenlinks.poll();
                    int qlength = pagenlinks.size();
                    int c = 0;
                    //It removes the last link in pagination links
                    Iterator itr = pagenlinks.iterator();
                    while (itr.hasNext()) {
                        String o = itr.next().toString();
                        c++;
                        if (qlength != c) {
                            newpagenlinks.add(o);
                        }
                    }
                    System.out.println("Pagen Links Length " + pagenlinks.size());

                    //This line fetches the other links for pagination
                    otherlinks = getGoogleOtherPageLinksCrawl(newpagenlinks, goLinkGoogle, goUrl,portno);
                }
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Google_search.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

            if (tStop != 1) {
                Queue<String> pageslist = new LinkedList<>(mainlinks);

                //pageslist will contains list of Urls which are fetched from all the pages of google website for a given keyword
                pageslist.addAll(otherlinks);

                //Storing all the Urls for a given keyword into a file
//                String path = goKeyword + ".txt";
//                writeUrlFile(pageslist, path);
                System.out.println("pageslist.size() " + pageslist.size());

                Boolean flag = true;
                Boolean flag2 = true;
                Boolean fond2 = false;
                int count = 0;
                int newWebRankGoogle = 0;
                int bestMatchRankGoogle = 0;
                int reg = 0;
                Iterator itrr = pageslist.iterator();
                while (itrr.hasNext()) {
                    String linksinpage = (String) itrr.next();
                    count++;
                    Boolean fond = false;
                    bestmatchlink = findBestMatchLink(linksinpage, goUrl);
                    if (bestmatchlink != null) {
                        if (flag2) {
                            bestMatchLinkGoogle = bestmatchlink;
                            System.out.println("bestMatchLinkGoogle for " + goKeyword + " : " + bestMatchLinkGoogle);
                            bestMatchRankGoogle = count;
                            System.out.println("bestMatchRankgoogle for " + goKeyword + " : " + bestMatchRankGoogle);
                            fond2 = true;
                            flag2 = false;
                            reg = 1;
                        }
                    }
                    fond = findGoogleLinkRank(linksinpage, goKeyword, goUrl);
                    if (fond2) {
                        if (fond) {
                            if (flag) {
                                newWebRankGoogle = count;
                                System.out.println("newWebRankGoogle for " + goKeyword + " : " + newWebRankGoogle);
                                System.out.println("Best Matched Url for " + goKeyword + " : " + linksinpage);
                                objKeywordDao.saveResult(goKeywordID, newWebRankGoogle, bestMatchRankGoogle, bestMatchLinkGoogle, "google.com");
                                flag = false;
                                reg = 2;
                                break;
                            }
                        }
                    }
                }
                if (reg == 1) {
                    newWebRankGoogle = 501;
                    objKeywordDao.saveResult(goKeywordID, newWebRankGoogle, bestMatchRankGoogle, bestMatchLinkGoogle, "google.com");
                }
                if (reg == 0) {
                    newWebRankGoogle = 501;
                    bestMatchRankGoogle = 501;
                    objKeywordDao.saveResult(goKeywordID, newWebRankGoogle, bestMatchRankGoogle, " No Link Found ", "google.com");
                }
            }

            // Code to get Google Page Rank
//            String googleprurl = new StringBuilder().append("http://www.").append(goUrl).toString();
//            Thread searchgooglepr = new Thread(new PRGenerator(appContext, googleprurl, goKeywordID));
//            searchgooglepr.start();

        } catch (Exception e) {
            Logger.getLogger(Google_search.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
    }

    public Boolean findLinksofSite(Queue urlList) {
        String bestmatchlink = null;
        Boolean foundmatch = false;
        Boolean flag = true;
        Boolean flag2 = true;
        Boolean fond2 = false;
        int bestMatchRankGoogle = 0;
        int newWebRankGoogle = 0;
        int count = 0;
        try {
            Iterator itrr = urlList.iterator();
            while (itrr.hasNext()) {
                String linksinpage = (String) itrr.next();
                count++;
                Boolean fond = false;
                bestmatchlink = findBestMatchLink(linksinpage, goUrl);
                if (bestmatchlink != null) {
                    if (flag2) {
                        bestMatchLinkGoogle = bestmatchlink;
                        System.out.println("bestMatchLinkGoogle for " + goKeyword + " : " + bestMatchLinkGoogle);
                        bestMatchRankGoogle = count;
                        System.out.println("bestMatchRankgoogle for " + goKeyword + " : " + bestMatchRankGoogle);
                        fond2 = true;
                        flag2 = false;
                    }
                }
                fond = findGoogleLinkRank(linksinpage, goKeyword, goUrl);
                if (fond2) {
                    if (fond) {
                        if (flag) {
                            newWebRankGoogle = count;
                            System.out.println("newWebRankGoogle for " + goKeyword + " : " + newWebRankGoogle);
                            System.out.println("Best Matched Url for " + goKeyword + " : " + linksinpage);
                            objKeywordDao.saveResult(goKeywordID, newWebRankGoogle, bestMatchRankGoogle, bestMatchLinkGoogle, "google.com");
                            foundmatch = true;
                            flag = false;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foundmatch;
    }

    public String findBestMatchLink(String newurl, String domainurl) {
//        System.out.println("domainurl = " + domainurl);
//        System.out.println("newurl = " + newurl);

        String bestmatch = null;
        String[] domainsparts = new String[5];
        if (domainurl.contains("/")) {
            domainsparts = domainurl.split("/");            
        } else {
            domainsparts[0] = domainurl;
            //domainsparts.add(domainurl);
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

    public Boolean findGoogleLinkRank(String newurl, String keyword, String domainurl) {
        Boolean fod = false;
        Boolean flag = false;
        String[] domainsparts = new String[5];
        //String newkeyword=keyword.replace("+", "-");
        if (domainurl.contains("/")) {
            domainsparts = domainurl.split("/");
            flag = true;
        } else {
            domainsparts[0] = domainurl;
        }
        if (flag) {
            for (int i = 1; i < domainsparts.length; i++) {
                if (newurl.contains(domainsparts[0]) && newurl.contains(domainsparts[i])) {
                    if (newurl.contains(domainurl)) {
                        fod = true;
                    }
                }
            }
        } else {
            //B   if (newurl.contains(domainurl) && newurl.contains(domainsparts[0])) {
            if (newurl.contains(domainurl)) {
                fod = true;
            }
        }
        return fod;
    }

    public void writeUrlFile(Queue url, String filename) {
        String str = getShowPage();
        String domainUrl = null;
        File file;
        try {
            FileOutputStream fop = null;
            file = new File(str + "/Urltextfilesgoogle/" + filename);
            System.out.println(file.getAbsolutePath());
            if (!file.exists()) {
                file.createNewFile();
            }
            fop = new FileOutputStream(file);
            Iterator itrr = url.iterator();
            while (itrr.hasNext()) {
                domainUrl = (String) itrr.next();
                byte[] contentInBytes = domainUrl.getBytes();
                fop.write(contentInBytes);
                fop.write(System.getProperty("line.separator").getBytes());
            }
            fop.flush();
            fop.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getShowPage() {
        String str = null;
        try {
            str = this.getClass().getClassLoader().getResource("").getPath();
            if (str.contains("%20")) {
                str = str.replaceAll("%20", " ");
            }
        } catch (Exception e) {
            str = System.getProperty("user.dir");
        }
        return str;
    }

    public Queue<String> getGooglePagenationLinksfromString(String responsebody) {
        Queue<String> othpagenlinks = new LinkedList<>();
        try {
            //File f = new File(url);
            Document doc = Jsoup.parse(responsebody);
            Element plinks = doc.getElementById("foot");
            Elements pagenlinks = plinks.select("a[href]");
            for (Element el1 : pagenlinks) {
                String pilinks = el1.attr("href");
                if (pilinks.contains("/search?")) {
                    //       System.out.println("Pagenation Links" + pilinks);
                    othpagenlinks.add(pilinks);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return othpagenlinks;
    }

    public Queue<String> getGooglePageCitationLinksFromString(String responsebody) {
        Queue<String> mainlinks = new LinkedList<>();
        try {
            // File f = new File(url);
            Document doc = Jsoup.parse(responsebody);
//            Element links = doc.getElementById("ires");
//            Elements links2 = links.getElementsByTag("li");
//            Elements nlinks = links2.select("h3.r > a");

            Elements nlinks = doc.select("div[class=srg] li h3[class=r] a");
            
            for (Element el2 : nlinks) {
                String golinks = el2.attr("href");
                System.out.println("Main Links "+golinks);
                mainlinks.add(golinks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mainlinks;
    }
}