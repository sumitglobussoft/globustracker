/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.vimeo;

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
import ranktracker.utility.FetchPageBodySource;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.Vimeo_search;

/**
 *
 * @author User
 */
public class VimeoPagenLinks implements Callable<String> {

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
    Videokeywords videokeywords;
    List<ProxyData> proxyList;

    public VimeoPagenLinks(List<Videokeywords> lstVideokeywords, KeywordsDao objKeywordDao, String vimUrl, String vimKeyword, Integer vimKeywordId, FetchPagewithClientAthentication fetchSourcewithAuthentication, FetchPageBodySource fetchsource, Videokeywords videokeywords, List<ProxyData> proxyList) {
        this.lstVideokeywords = lstVideokeywords;
        this.objKeywordDao = objKeywordDao;
        this.vimUrl = vimUrl;
        this.vimKeyword = vimKeyword;
        this.vimKeywordId = vimKeywordId;
        this.fetchSourcewithAuthentication = fetchSourcewithAuthentication;
        this.fetchsource = fetchsource;
        this.videokeywords = videokeywords;
        this.proxyList = proxyList;
    }

    @Override
    public String call() throws Exception {
        Boolean matchfound = false;
        vimUrl = videokeywords.getVimeoURL();
        vimKeyword = videokeywords.getVideoKeyword();
        vimKeywordId = videokeywords.getVideokeywordID();
        //vimKeyword=vimKeyword.replaceAll(" ", "+");
        System.out.println("Vim Keyword = " + vimKeyword);
                //String newurl="http://vimeo.com/search/sort:relevant/format:detail?q="+vimKeyword;
        // http://vimeo.com/search/sort:relevant/format:detail?q=Best+self+help+books
        if (!videokeywords.getVimeoURL().isEmpty()) {

            try {
//                       
                int count = 0;
                URI uri = new URIBuilder()//http://vimeo.com/search?q=superman+hero
                        .setScheme("http")
                        .setHost("vimeo.com")
                        .setPath("/search/page:1/sort:relevant/format:detail")
                        .setParameter("q", vimKeyword)
                        .build();
                String newuri = uri.toString();
                //String newuri="http://vimeo.com/search/page:1/sort:relevant/format:detail?q="+vimKeyword;
                for (int k = 1; k <= 10; k++) {
                    int l = 0;

                    System.out.println("searchurl = " + newuri);
                    String pagesource = fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(uri, "", 0, this.proxyList);
                    while (pagesource.length() < 1000 && l <= 3) {
                        System.out.println("second attempt searchurl = " + newuri);
                        pagesource = fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(uri, "", 0, this.proxyList);
                        l++;
                    }
                    System.out.println("pagelsource lenth " + pagesource.length());
                    mainlinks = getVimeoPageCitationLinks(pagesource);
                    matchfound = findSingleLink(mainlinks, vimUrl, count);
                    if (matchfound) {
                        break;
                    } else {
                        newuri = getVimeoPaginationLinks(pagesource);
                        if (newuri.length() <= 10) {
                            break;
                        } else {
                            newuri = "http://vimeo.com" + newuri;
                        }
                    }
                    count = count + 10;
                }
                if (!matchfound) {
                    objKeywordDao.saveVimeoResult(vimKeywordId, vimKeyword, "No Link Found", 501);
                }

            } catch (Exception ex) {
                Logger.getLogger(Vimeo_search.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

        }

        return "done";

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

    public Boolean findSingleLink(Queue links, String vmurl, int count) {
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
        try {
            if (vimUrl.contains(link) || link.contains(vimUrl)) {
                fod = true;
            }
        } catch (Exception e) {
        }
        return fod;
    }

    public String getVimeoPaginationLinks(String pagepath) {
        String pagelinks = "";
        try {
            System.out.println("--------paginatin-----");
            Document doc = Jsoup.parse(pagepath);
            Element element = doc.getElementById("pagination");
            Elements paglinks = element.select("ol li a");
            for (Element ele : paglinks) {
                String check = ele.toString();
                if (check.contains("Next")) {
                    pagelinks = ele.attr("href");
                }
//                System.out.println("foundlinks = " + foundlinks);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagelinks;
    }

//    FetchPagewithClientAthentication fetchclientpage;
//    String vimUrl;
//
//    public VimeoPagenLinks(FetchPagewithClientAthentication fetchclientpage) {
//        this.fetchclientpage = fetchclientpage;
//    }
//
//    public Queue<String> getOtherVimeoPageLinksCrawl(Queue<String> pagenLinks, String vimUrl) throws IOException, InterruptedException {
//        Boolean matchfound = false;
//        //Vimeo_search vimsearch = new Vimeo_search();
//        Queue<String> otherlinks = new LinkedList<>();
//        ExecutorService executor = Executors.newCachedThreadPool();
//        List<Future<Queue<String>>> future = new ArrayList<>();
////      /search/page:6/sort:relevant/format:thumbnail?q=superman+hero
//        String firstpage = pagenLinks.element();
//        String[] pageincut = firstpage.split("page:");
//        String secondpageincut = pageincut[1].substring(1, pageincut[1].length());
//        String stringb = null;
//        for (int i = 2; i < 10; i++) {
//            stringb = new StringBuilder().append(pageincut[0]).append("page:").append(i).append(secondpageincut).toString();
//            otherlinks.addAll(getExtraPageLinksCrawl(stringb, future, executor, i));
//        }
//        matchfound = findSingleLink(otherlinks);
//        if (!matchfound) {
//            for (int i = 11; i < 20; i++) {
//                stringb = new StringBuilder().append(pageincut[0]).append("page:").append(i).append(secondpageincut).toString();
//                otherlinks.addAll(getExtraPageLinksCrawl(stringb, future, executor, i));
//            }
//        }
//        executor.shutdown();
//        return otherlinks;
//    }
//
//    public Queue<String> getExtraPageLinksCrawl(String newpageurl, List<Future<Queue<String>>> future, ExecutorService executor, int i) throws IOException, InterruptedException {
//        Queue<String> newpagelinks = new LinkedList<>();
//        HttpGet httpget = new HttpGet((String) "http://vimeo.com" + newpageurl);
//        future = ((List<Future<Queue<String>>>) executor.invokeAll((Arrays.asList(new GetVimeoThread(httpget, i, fetchclientpage)))));
//        if (future.isEmpty()) {
//            return newpagelinks;
//        }
//        Iterator itr1 = future.iterator();
//        while (itr1.hasNext()) {
//            try {
//                Future<Queue<String>> futur = (Future<Queue<String>>) itr1.next();
//                for (String futur1 : futur.get()) {
//                    newpagelinks.add(futur1);
//                }
//            } catch (InterruptedException | ExecutionException ex) {
//                Logger.getLogger(GetVimeoThread.class.getName()).log(Level.SEVERE, null, ex);
//                ex.printStackTrace();
//                return newpagelinks;
//            }
//        }
//        return newpagelinks;
//    }
//
//    public Boolean findSingleLink(Queue links) {
//        int count = 0;
//        Boolean store = false;
//        Boolean flag = false;
//        Iterator itrmap = links.iterator();
//        while (itrmap.hasNext()) {
//            //flag=false;
//            String mentry = itrmap.next().toString();
//            count++;
//            flag = findVimeoLink(mentry, vimUrl);
//            store = false;
//            if (flag) {
//                store = true;
//                break;
//            }
//        }
//        return store;
//    }

  
}
