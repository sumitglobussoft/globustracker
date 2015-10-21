/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import ranktracker.crawler.google.GooglePagenLinksSearch;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            if (!"-".equals(serpkeyword.getRankGoogleRefresherDate())) {
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
            }
        } catch (Exception s) {
            System.out.println("" + s);
        }
        return false;
    }

    @Override
    public void run() {
        System.out.println("++++++++++++++++  STARTING GOOGLE CRAWLER ++++++++++++++++++++++++");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        System.out.println("Available Processors :" + Runtime.getRuntime().availableProcessors());

        int i = 0;
        List<ProxyData> proxylist = objProxyDao.getProxyList();
        Iterator googleitr = lstKeywords.iterator();
        while (googleitr.hasNext()) {
            try {
                i++;
                Serpkeywords k = (Serpkeywords) googleitr.next();
                if (checkForRecentUpdatedKeyword(k)) {
                    continue;
                }
                executor.submit(new GooglePagenLinksSearch(k, appContext, i, proxylist));
            } catch (Exception ex) {
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
}
