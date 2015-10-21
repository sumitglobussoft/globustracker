/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

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
            if (!"-".equals(serpkeyword.getRankYahooRefresherDate())) {
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

        System.out.println("++++++++++++++++  STARTING YAHOO CRAWLER ++++++++++++++++++++++++");
        System.out.println("Available Processors :" + Runtime.getRuntime().availableProcessors());
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Iterator yahooitr = lstKeywords.iterator();
        int i = 0;
        List<ProxyData> proxylist = objProxyDao.getProxyList();
        while (yahooitr.hasNext()) {
            i++;
            try {
                Serpkeywords objKeyword = (Serpkeywords) yahooitr.next();
                if (checkForRecentUpdatedKeyword(objKeyword)) {
                    continue;
                }
                executor.submit(new YahooPagenLinks(objKeyword, appContext, i, proxylist));
            } catch (Exception ex) {
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
}
