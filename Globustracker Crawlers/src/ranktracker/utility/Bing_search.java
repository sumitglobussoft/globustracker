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
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import ranktracker.crawler.bing.BingPagenLinks;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;
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
    ProxyDao objProxyDao;

    public Bing_search() {
    }

    public Bing_search(ApplicationContext appContext, List<Serpkeywords> lstKeywords) {
        this.appContext = appContext;
        this.lstKeywords = lstKeywords;
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    public boolean checkForRecentUpdatedKeyword(Serpkeywords serpkeyword) {
        try {
            String currentDate[] = (new Date()).toString().split(" ");
            String endDate[] = serpkeyword.getBingUpdateDate().split(" ");

            //Wed Jan 07 13:45:08 IST 2015
            //Fri Jan 02 13:40:06 IST 2015
            if (!"-".equals(serpkeyword.getRankBingRefresherDate())) {
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

        System.out.println("++++++++++++++++  STRATING BING CRAWLER ++++++++++++++++++++++++");
        System.out.println("Available Processors :" + Runtime.getRuntime().availableProcessors());
        //http://www.bing.com/search?q=htc+touch+cost+in+india&qs=n&form=QBLH&pq=htc+touch+cost+in+india
        //&sc=0-12&sp=-1&sk=&cvid=1cbaedc2958740098d9c5739d08e605c
        //http://www.bing.com/search?q=nexus+7+price+in+india&qs=AS&sk=AS6&pq=nexus&sc=8-5&sp=7&
        //cvid=11c80f4404f54af094ab61243f897880&FORM=QBLH
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Iterator bingitr = lstKeywords.iterator();
        int i = 0;
        List<ProxyData> proxylist = objProxyDao.getProxyList();
        while (bingitr.hasNext()) {
            i++;
            try {
                Serpkeywords objKeyword = (Serpkeywords) bingitr.next();
                if (checkForRecentUpdatedKeyword(objKeyword)) {
                    continue;
                }
                executor.submit(new BingPagenLinks(objKeyword, appContext, i, proxylist));
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
}
