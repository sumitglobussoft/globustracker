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
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Serpkeywords;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
@Repository("googleSearch")
public class Google_search implements Runnable {

    private List<Serpkeywords> lstKeywords;
    ApplicationContext appContext;
    String goUrl;
    String goKeyword;
    String goLinkGoogle;
    int goKeywordID;
    Boolean found = false;
    String bestMatchLinkGoogle = null;
    ProxyDao objProxyDao;

    public Google_search() {
    }

    public Google_search(ApplicationContext appContext, List<Serpkeywords> lstKeywords) {
        this.appContext = appContext;
        this.lstKeywords = lstKeywords;
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    public boolean checkForRecentUpdatedKeyword(Serpkeywords serpkeyword) {
        try {
            String currentDate[] = (new Date()).toString().split(" ");
            String endDate[] = serpkeyword.getGoogleUpdatedDate().split(" ");

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
        //int keywordcount = lstKeywords.size();
        System.out.println("++++++++++++++++  STARTING GOOGLE CRAWLER ++++++++++++++++++++++++");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        System.out.println("Available Processors :" + Runtime.getRuntime().availableProcessors());

        //ExecutorService executor=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        //This loop selects one keyword at a moment
//        Stack<Serpkeywords> lstKeywordsStack = new Stack<>();
//        for (Serpkeywords serpkeywords : lstKeywords) {
//            lstKeywordsStack.push(serpkeywords);
//        }
        int i = 0;
        List<ProxyData> proxylist=objProxyDao.getProxyList();
        Iterator googleitr = lstKeywords.iterator();
        while (googleitr.hasNext()) {
            //while (!lstKeywordsStack.empty()) {
            try {
                i++;

                Serpkeywords k = (Serpkeywords) googleitr.next();

                if (checkForRecentUpdatedKeyword(k)) {
                    continue;
                }
//                goUrl = k.getUrl();
//                goKeyword = k.getKeyword();
//                goLinkGoogle = "www." + k.getLinkGoogle();
//                goKeywordID = k.getKeywordID();
                //Runnable worker = new GooglePagenLinksSearch(goUrl, goKeyword, goLinkGoogle, goKeywordID, appContext);
//                Thread worker = new Thread(new GooglePagenLinksSearch(goUrl, goKeyword, goLinkGoogle, goKeywordID, appContext));
//                worker.start();
//                worker.join();
                //executor.execute(worker);

                executor.submit(new GooglePagenLinksSearch(k, appContext, i, proxylist));

            } // catch (InterruptedException ex) {
            catch (Exception ex) {
                Logger.getLogger(Google_search.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

        }
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(Google_search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Queue<String> getGooglePageCitationLinks(String url) {
        Queue<String> mainlinks = new LinkedList<>();
        try {
            File f = new File(url);
            Document doc = Jsoup.parse(f, "UTF-8");
            Element links = doc.getElementById("ires");
            Elements links2 = links.getElementsByTag("li");
            Elements nlinks = links2.select("h3.r > a");
            for (Element el2 : nlinks) {
                String golinks = el2.attr("href");
                //System.out.println("Main Links "+golinks);
                mainlinks.add(golinks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mainlinks;
    }

    public Queue<String> getGooglePagenationLinks(String url) {
        Queue<String> othpagenlinks = new LinkedList<>();
        try {
            File f = new File(url);
            Document doc = Jsoup.parse(f, "UTF-8");
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

    public ProxyDao getObjProxyDao() {
        return objProxyDao;
    }

    public void setObjProxyDao(ProxyDao objProxyDao) {
        this.objProxyDao = objProxyDao;
    }
}
