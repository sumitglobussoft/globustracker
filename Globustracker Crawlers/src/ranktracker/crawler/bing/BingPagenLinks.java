/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.bing;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Serpkeywords;
import ranktracker.utility.FetchPagewithClientAthentication;

/**
 *
 * @author User
 */
public class BingPagenLinks implements Callable {

    Serpkeywords objSerpKeywords;
    ApplicationContext appContext;
    KeywordsDao objKeywordDao;
    FetchPagewithClientAthentication fetchclientpage;  
    int keywordNumber = 0;
    List<ProxyData> proxyList;
    String bnLinkBing = "www.bing.com";
    int bnCrawlCount;
    boolean bestMatchRankFound = false;
    boolean rankFound = false;
    int counter = 0;

    public BingPagenLinks(Serpkeywords objSerpKeywords, ApplicationContext applicationContext, int i, List<ProxyData> proxyList) {
        this.objSerpKeywords = objSerpKeywords;
        this.appContext = applicationContext;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);       
        this.keywordNumber = i;
        this.proxyList = proxyList;
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
            if (new URL("http://" + url.replace("http://", "").replace("https://", "").replace("www.", "")).getHost().equalsIgnoreCase(new URL("http://" + domain).getHost())) {
                //System.out.println("two");
                return true;
            }
        }
        return false;
    }

    public boolean findRanks(Document doc, int page) throws MalformedURLException {
        Element links = doc.getElementById("b_results");
        Elements results = links.select("li[class=b_algo] h2 a[href]");

        System.out.println("-- PAGE : " + page);
        for (Element result : results) {
            try {
                counter++;
                String url = result.attr("abs:href");
                //String url = result.select("cite").first().text();
                System.out.println("        -- RESULT : " + counter + " --- ---- ---- ---- ---- ---- ");
                System.out.println("        -- URL : " + url);

                if (!bestMatchRankFound) {
                    if (new URL("http://" + url.replace("http://", "").replace("https://", "").replace("www.", "")).getHost().equalsIgnoreCase(new URL("http://" + objSerpKeywords.getUrl()).getHost())) {
                        objSerpKeywords.setBestMatchRankBing(counter);
                        bestMatchRankFound = true;
                        objSerpKeywords.setBestMatchLinkBing(url);
                        System.out.println("        -- Best Match Link : " + objSerpKeywords.getBestMatchLinkBing());
                        System.out.println("        -- Best Match Rank : " + objSerpKeywords.getBestMatchRankBing());
                    }
                }

                if (!rankFound) {
                    // url = result.select("cite").first().text();
                    if (getRank(url, objSerpKeywords.getUrl())) {
                        objSerpKeywords.setRankBing(counter);
                        rankFound = true;
                        System.out.println("        -- Rank Found : " + objSerpKeywords.getRankBing());
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
            System.out.println("------ BingPagenLinks");
            System.out.println("    -- bnKeyword = " + objSerpKeywords.getKeyword());
            System.out.println("    -- bnKeywordID = " + objSerpKeywords.getKeywordID());
            System.out.println("    -- bnLinkBing = " + bnLinkBing);
            System.out.println("    -- bnUrl = " + objSerpKeywords.getUrl());
            String bingstring = "http://" + bnLinkBing + "/search?q=" + objSerpKeywords.getKeyword().replace(" ", "+");
            System.out.println("    -- Bing Url: " + bingstring);

            Document doc = Jsoup.parse(fetchclientpage.fetchPageSourcefromClientGoogle(new URI(bingstring), "", 0, this.proxyList));

            findRanks(doc, 1);

            if (!rankFound) {
                String nextLink;
                for (int i = 2; i < 26; i++) {
                    try {
                        nextLink = "http://" + bnLinkBing + doc.select("a[class*=sb_pagN]").last().attr("href");
                        System.out.println("nextLink : " + nextLink);
                        doc = Jsoup.parse(fetchclientpage.fetchPageSourcefromClientGoogle(new URI(nextLink), "", 0, this.proxyList));
                        if (findRanks(doc, i)) {
                            break;
                        }
                    } catch (Exception ex) {
                        System.out.println("EXCEPTION IN PAGINATION : " + ex);
                    }
                }
            }

            System.out.println("bestMatchRankBing : " + objSerpKeywords.getBestMatchRankBing());
            System.out.println("bestMatchLinkBing : " + objSerpKeywords.getBestMatchLinkBing());
            System.out.println("rankBing : " + objSerpKeywords.getRankBing());
            Integer startBing = objSerpKeywords.getStartBing() == 0 ? objSerpKeywords.getRankBing() : objSerpKeywords.getStartBing();
            objKeywordDao.saveResult(objSerpKeywords.getKeywordID(), startBing, objSerpKeywords.getRankBing(), objSerpKeywords.getBestMatchRankBing(), objSerpKeywords.getBestMatchLinkBing(), "bing.com", objSerpKeywords.getKeyword(), objSerpKeywords.getUrl());

        } catch (Exception e) {
        }

        return "success";
    }  	   
}
