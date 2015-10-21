/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.yahoo;

import ranktracker.utility.Yahoo_search;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @Laxmi Kiran Nallam (laxmikiran@globussoft.com)
 */
public class YahooPagenLinks implements Callable<String> {

    Serpkeywords objSerpKeywords;
    ApplicationContext appContext;
    KeywordsDao objKeywordDao;
    FetchPagewithClientAthentication fetchSourcewithProx;
    int keywordNumber = 0;
    List<ProxyData> proxyList;
    public String yaLinkYahoo = "search.yahoo.com";
    public int yaCrawlCount;
    boolean found = false;
    boolean bestMatchRankFound = false;
    boolean rankFound = false;
    int counter = 0;

    static org.apache.log4j.Logger l = org.apache.log4j.Logger.getLogger(Yahoo_search.class.getName());

    public YahooPagenLinks(Serpkeywords objSerpKeywords, ApplicationContext appContext, int i, List<ProxyData> proxyList) {
        this.objSerpKeywords = objSerpKeywords;
        this.appContext = appContext;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.fetchSourcewithProx = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
        this.keywordNumber = i;
        this.proxyList = proxyList;
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
                    if (new URL("http://" + url.replace("http://", "").replace("https://", "").replace("www.", "")).getHost().equalsIgnoreCase(new URL("http://" + objSerpKeywords.getUrl()).getHost())) {
                        objSerpKeywords.setBestMatchRankYahoo(counter);
                        bestMatchRankFound = true;
                        objSerpKeywords.setBestMatchLinkYahoo(url);
                        System.out.println("        -- Best Match Link : " + objSerpKeywords.getBestMatchLinkYahoo());
                        System.out.println("        -- Best Match Rank : " + objSerpKeywords.getBestMatchRankYahoo());
                    }
                }
                if (!rankFound) {
                    // url = result.select("cite").first().text();
                    if (getRank(url, objSerpKeywords.getUrl())) {
                        objSerpKeywords.setRankYahoo(counter);
                        rankFound = true;
                        System.out.println("        -- Rank Found : " + objSerpKeywords.getRankYahoo());
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
            System.out.println("    -- yaKeyword = " + objSerpKeywords.getKeyword());
            System.out.println("    -- yaKeywordID = " + objSerpKeywords.getKeywordID());
            System.out.println("    -- yaLinkYahoo = " + yaLinkYahoo);
            System.out.println("    -- yaUrl = " + objSerpKeywords.getUrl());

            String yahoostring = "http://" + yaLinkYahoo + "/search?p=" + objSerpKeywords.getKeyword().replace(" ", "+");
            System.out.println("    -- Yahoo Url: " + yahoostring);

            Document doc = Jsoup.parse(fetchSourcewithProx.fetchPageSourcefromClientGoogle(new URI(yahoostring), "", 0, this.proxyList));

            // System.out.println("" + doc);
            findRanks(doc, 1);
			
			if (!rankFound) {
                String nextLink;
                for (int i = 2; i < 26; i++) {
                    try {
                        nextLink = doc.select("a[class=next]").first().attr("href");
                        System.out.println("nextLink : " + nextLink);
                        doc = Jsoup.parse(fetchSourcewithProx.fetchPageSourcefromClientGoogle(new URI(nextLink), "", 0, this.proxyList));
                        if (findRanks(doc, i)) {
                            break;
                        }
                    } catch (Exception ex) {
                        System.out.println(objSerpKeywords.getKeyword()+"=====EXCEPTION IN PAGINATION : " + ex);
                    }
                }
            }

            if (!rankFound) {
                String nextLink;
                for (int i = 2; i < 26; i++) {
                    try {
                        nextLink = doc.select("a[class=next]").first().attr("href");
                        System.out.println("nextLink : " + nextLink);
                        doc = Jsoup.parse(fetchSourcewithProx.fetchPageSourcefromClientGoogle(new URI(nextLink), "", 0, this.proxyList));
                        if (findRanks(doc, i)) {
                            break;
                        }
                    } catch (Exception ex) {
                        System.out.println(objSerpKeywords.getKeyword()+"=====EXCEPTION IN PAGINATION : " + ex);
                    }
                }
            }

            System.out.println("bestMatchRankYahoo : " + objSerpKeywords.getBestMatchRankYahoo());
            System.out.println("bestMatchLinkYahoo : " + objSerpKeywords.getBestMatchLinkYahoo());
            System.out.println("rankYahoo : " + objSerpKeywords.getRankYahoo());

            Integer startYahoo = objSerpKeywords.getStartYahoo() == 0 ? objSerpKeywords.getRankYahoo() : objSerpKeywords.getStartYahoo();

            objKeywordDao.saveResult(objSerpKeywords.getKeywordID(), startYahoo, objSerpKeywords.getRankYahoo(), objSerpKeywords.getBestMatchRankYahoo(), objSerpKeywords.getBestMatchLinkYahoo(), "yahoo.com", objSerpKeywords.getKeyword(), objSerpKeywords.getUrl());
        } catch (Exception run1) {
            Logger.getLogger(Yahoo_search.class.getName()).log(Level.SEVERE, null, run1);
            run1.printStackTrace();
            return "failed";
        }
        return "success";
    }
}
