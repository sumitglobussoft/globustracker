/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import ranktracker.crawler.bing.BingPagenLinks;
import ranktracker.entity.Serpkeywords;

/**
 *
 * @author User
 */
@Repository("bingSearch")
public class Bing_search implements Runnable {

    static Logger l = Logger.getLogger(Bing_search.class.getName());
    private List<Serpkeywords> lstKeywords;
    ApplicationContext appContext;
    String bnUrl;
    String bnKeyword;
    int bnKeywordID;

    public Bing_search() {
    }

    public Bing_search(ApplicationContext appContext, List<Serpkeywords> lstKeywords) {
        this.appContext = appContext;
        this.lstKeywords = lstKeywords;
    }

    @Override
    public void run() {

        //http://www.bing.com/search?q=htc+touch+cost+in+india&qs=n&form=QBLH&pq=htc+touch+cost+in+india
        //&sc=0-12&sp=-1&sk=&cvid=1cbaedc2958740098d9c5739d08e605c
        //http://www.bing.com/search?q=nexus+7+price+in+india&qs=AS&sk=AS6&pq=nexus&sc=8-5&sp=7&
        //cvid=11c80f4404f54af094ab61243f897880&FORM=QBLH
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Iterator bingitr = lstKeywords.iterator();
        while (bingitr.hasNext()) {
            try {
                Serpkeywords objKeyword = (Serpkeywords) bingitr.next();
                bnUrl = objKeyword.getUrl();
                bnKeyword = objKeyword.getKeyword();
                bnKeywordID = objKeyword.getKeywordID();
                Runnable worker = new BingPagenLinks(bnUrl, bnKeyword, bnKeywordID, appContext);
                executor.execute(worker);
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(Bing_search.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(Bing_search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Queue<String> getBingMainLinks(String str, String keyword) {
        Queue<String> mainlinks = new LinkedList<>();
        try {
            Document doc = Jsoup.parse(str, "UTF-8");
            Element links = doc.getElementById("b_results");
            Elements nlinks = links.select("li[class=b_algo] h2 a[href]");
            for (Element el2 : nlinks) {
                String golinks = el2.attr("abs:href");
                System.out.println(golinks);
                mainlinks.add(golinks);
            }
            System.out.println("-------------------------------");
        } catch (Exception e) {
            System.out.println("Exception Occured in " + keyword);
        }
        return mainlinks;
    }

    public Queue<String> getBingPageinationLinks(String str) {
        Queue<String> pagenlinks = new LinkedList<>();
        try {
            Document doc = Jsoup.parse(str, "UTF-8");
            Element links = doc.getElementById("b_results");
            Elements nlinks = links.select("li[class=b_pag] nav ul li a[href]");
            for (Element el2 : nlinks) {
                String golinks = el2.attr("href");
                System.out.println(golinks);
                pagenlinks.add(golinks);
            }
            int pagenlinksize = pagenlinks.size();
            Iterator itr = pagenlinks.iterator();
            int c = 0;
            while (itr.hasNext()) {
                String o = itr.next().toString();
                c++;
                if (pagenlinksize == c) {
                    pagenlinks.remove(o);
                }
            }
            System.out.println("Pagen Links size --------------" + pagenlinks.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagenlinks;
    }
}
