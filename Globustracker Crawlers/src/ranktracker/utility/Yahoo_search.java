/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.File;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import ranktracker.crawler.yahoo.YahooPagenLinks;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;
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
    ProxyDao objProxyDao;

    public Yahoo_search() {
    }

    public Yahoo_search(ApplicationContext appContext, List<Serpkeywords> lstkeywords) {
        this.lstKeywords = lstkeywords;
        this.appContext = appContext;
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    public boolean checkForRecentUpdatedKeyword(Serpkeywords serpkeyword) {
        try {

            String currentDate[] = (new Date()).toString().split(" ");
            String endDate[] = serpkeyword.getYahooUpdateDate().split(" ");

            //Wed Jan 07 13:45:08 IST 2015
            //Fri Jan 02 13:40:06 IST 2015
            if (currentDate[0].equalsIgnoreCase(endDate[0])) {
                if (currentDate[1].equalsIgnoreCase(endDate[1])) {

                    if (currentDate[2].equalsIgnoreCase(endDate[2])) {

                        if (currentDate[5].equalsIgnoreCase(endDate[5])) {

                            System.out.println("SAME TIME : " + serpkeyword.getKeyword() + " [" + serpkeyword.getKeywordID() + "]");
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

        System.out.println("++++++++++++++++  STARTING YAHOO CRAWLER ++++++++++++++++++++++++");
        System.out.println("Available Processors :" + Runtime.getRuntime().availableProcessors());
        //int keywordcount = lstKeywords.size();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Iterator yahooitr = lstKeywords.iterator();
        int i = 0;
        List<ProxyData> proxylist=objProxyDao.getProxyList();
        while (yahooitr.hasNext()) {
            i++;
            try {
                Serpkeywords objKeyword = (Serpkeywords) yahooitr.next();
//                if (checkForRecentUpdatedKeyword(objKeyword)) {
//                    continue;
//                }
//                yaUrl = objKeyword.getUrl();
//                yaKeyword = objKeyword.getKeyword();
//                yaLinkYahoo = "search.yahoo.com";
//                yaKeywordID = objKeyword.getKeywordID();
                // Runnable worker = new YahooPagenLinks(yaUrl, yaKeyword, yaLinkYahoo, yaKeywordID, appContext);
                // worker.start();
                // worker.join();
                //executor.execute(worker);
                executor.submit(new YahooPagenLinks(objKeyword, appContext, i, proxylist));
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
            Logger.getLogger(Yahoo_search.class.getName()).log(Level.SEVERE, null, ex);
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
