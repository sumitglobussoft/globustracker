/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import ranktracker.crawler.yahoo.YahooPagenLinks;
import ranktracker.entity.Serpkeywords;

/**
 *
 * @Author Laxmi Kiran Nallam (laxmikiran@globussoft.com)
 */
@Repository("yahooSearch")
public class Yahoo_search implements Runnable {

    private List<Serpkeywords> lstKeywords;
    private ApplicationContext appContext;
    private String yaUrl;
    private String yaKeyword;
    private String yaLinkYahoo;
    private Integer yaKeywordID;

    public Yahoo_search() {
    }

    public Yahoo_search(ApplicationContext appContext, List<Serpkeywords> lstkeywords) {
        this.lstKeywords = lstkeywords;
        this.appContext = appContext;
    }

    @Override
    public void run() {

        //int keywordcount = lstKeywords.size();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Iterator yahooitr = lstKeywords.iterator();
        while (yahooitr.hasNext()) {
            try {
                Serpkeywords objKeyword = (Serpkeywords) yahooitr.next();
                yaUrl = objKeyword.getUrl();
                yaKeyword = objKeyword.getKeyword();
                yaLinkYahoo = "search.yahoo.com";
                yaKeywordID = objKeyword.getKeywordID();
                Runnable worker = new YahooPagenLinks(yaUrl, yaKeyword, yaLinkYahoo, yaKeywordID, appContext);
                // worker.start();
                // worker.join();
                executor.execute(worker);
            } //executor.shutdown();
            catch (Exception ex) {
                Logger.getLogger(Yahoo_search.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(Google_search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Queue<String> getYahooMainLinks(String filepath) {
        Queue<String> l = new LinkedList<>();
        Queue<String> newlink = new LinkedList<>();
        try {
            File input = new File(filepath);
            Document doc = Jsoup.parse(input, "UTF-8");
            Element links = doc.getElementById("web");
            Elements links1 = links.getElementsByTag("li");
            //Elements nlinks = links1.select("h3 > a");
            Elements links2 = links1.select("div[class=res]");
            Elements nlinks = links2.select("span[class=url]");
            for (Element el2 : nlinks) {
                String golinks = el2.text();
                //System.out.println(golinks);
                l.add(golinks);
            }
            System.out.println("-------------------------------");
            Iterator itr = l.iterator();
            while (itr.hasNext()) {
                String link = itr.next().toString();
                newlink.add(link);
//                if (link.contains("http") || link.contains("https")) {
//                    String[] str2 = link.split("http");
//                    str2[1] = str2[1].replace("%3a", "http:");
//                    // System.out.println(str2[1]);
//                    newlink.add(str2[1]);

//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newlink;
    }
}
