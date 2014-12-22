/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.site.settings;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ranktracker.crawler.StartCrawler;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Serpkeywords;
import ranktracker.utility.Bing_search;
import ranktracker.utility.Google_search;
import ranktracker.utility.Yahoo_search;

/**
 *
 * @author glb-074
 */
public class RankRefresher {

//    @Scheduled(cron = "* */55 * * * ?")
    public synchronized void rankRefresher() throws IOException {
        ApplicationContext appContext;
        KeywordsDao objKeywordDao;
        List<Serpkeywords> lstKeywords = null;
        Set<String> setDomains = new LinkedHashSet<>(0);

        appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);

        InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
        Properties props = new Properties();
        props.load(inStream);
        PropertyConfigurator.configure(props);

        List<Campaigns> lstCampaigns = objKeywordDao.getRankRefresherCampaignsList();
        if (!lstCampaigns.isEmpty()) {
            Iterator campitr = lstCampaigns.iterator();
            while (campitr.hasNext()) {
                Campaigns campaigns = (Campaigns) campitr.next();
                Integer campaignId = campaigns.getCampaignID();
               
                System.out.println("Refreshing Rank of  : "+campaigns.getCampaignID());
                
                lstKeywords = objKeywordDao.getCampaignsKeywords(campaignId);
                campaigns.setRankRefresherStatus(0);

                Iterator ittr = lstKeywords.iterator();

                while (ittr.hasNext()) {
                    Serpkeywords keywrds = (Serpkeywords) ittr.next();
                    //set of all the url; url for the specified keyword
                    setDomains.add(keywrds.getUrl().trim());
                }

                if (!lstKeywords.isEmpty()) {
                    try {
                        Thread searchgoogle = new Thread(new Google_search(appContext, lstKeywords));
                        searchgoogle.start();
                        searchgoogle.join();

                        Thread yahoosearch = new Thread(new Yahoo_search(appContext, lstKeywords));
                        yahoosearch.start();
                        yahoosearch.join();

                        Thread bingsearch = new Thread(new Bing_search(appContext, lstKeywords));
                        bingsearch.start();
                        bingsearch.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RankRefresher.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            System.out.println("No Campaign to refresh");
        }
    }
}
