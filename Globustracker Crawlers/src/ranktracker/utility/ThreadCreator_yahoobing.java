package ranktracker.utility;

import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.crawler.alexa.WebRankAlexa;
import ranktracker.crawler.bing.WebRankBing;
import ranktracker.crawler.page.RankPage;
import ranktracker.crawler.seomoz.BacklinksCounter;
import ranktracker.crawler.yahoo.WebRankYahoo;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;

/**
 * Utility Class to create thread groups for crawling.
 *
 * @author Kalpana
 */
public class ThreadCreator_yahoobing extends Thread {

    static Logger l = Logger.getLogger(ThreadCreator_yahoobing.class.getName());
    /**
     * lstKeywords The working list of Keywords objects
     */
    private List<Serpkeywords> lstKeywords = null;
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;
    /**
     * startTrackId The first trackid for a given crawl thread
     */
    private Integer startTrackId;
    /**
     * endtrackId The last trackid for a given crawl thread
     */
    private Integer endtrackId;
    /**
     * appContext The ApplicationContext object variable
     */
    private ApplicationContext appContext;
    /**
     * setDomains The set of unique domain strings
     */
    private Set<String> setDomains;
    /**
     * iCount Counter variable for passing thread group information
     */
    private Integer iCount;

    /**
     * Constructor to set all the variables
     *
     * @param setDomains
     * @param lstKeywords
     * @param appContext
     * @param iCount
     *
     */
    public ThreadCreator_yahoobing(int sKeywordID,int eKeywordID,Set<String> setDomains, List<Serpkeywords> lstKeywords, ApplicationContext appContext) {
        this.startTrackId=sKeywordID;
        this.endtrackId=eKeywordID;
        this.setDomains = setDomains;
        this.lstKeywords = lstKeywords;
        this.appContext = appContext;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        
    }

    /**
     * This method asks for creation of new rows in trackhistory table using
     *
     * @method createRows(). Then all crawlers objects are created with supplied
     * information and started. The main thread awaits completion of all crawler
     * threads and after joining with every crawler thread, invokes
     * UpdateRecords object to update crawled records to Keywords table.
     */
    @Override
    public void run() {
         Integer[] track = new RowCreator(lstKeywords, appContext).getTrackIdRange();
        Integer[] configuration = ReadConfiguration.readProperties();
        startTrackId = configuration[2];
        endtrackId = configuration[3];

        try {

            Thread tWebRankBing = new Thread(new WebRankBing( lstKeywords, appContext, startTrackId, endtrackId));
            Thread tWebRankYahoo = new Thread(new WebRankYahoo( lstKeywords, appContext, startTrackId, endtrackId));
            Thread tBacklinksCounter = new Thread(new BacklinksCounter( setDomains, lstKeywords, appContext));
            Thread tWebRankAlexa = new Thread(new WebRankAlexa( setDomains, lstKeywords, appContext));
            Thread tRankPage = new Thread(new RankPage( setDomains, lstKeywords, appContext, startTrackId, endtrackId));
              
            tWebRankBing.start();
            tWebRankYahoo.start();
            tBacklinksCounter.start();
            tWebRankAlexa.start();
            tRankPage.start();
             
              
            tWebRankBing.join();
            tWebRankYahoo.join();
            tBacklinksCounter.join();
            tWebRankAlexa.join();
            tRankPage.join();
            
        } catch (Exception e) {
            l.debug(e.getMessage() + "  " + e.getMessage());
        }
        try {
            Thread tUpdateRecords = new Thread(new UpdateRecords(lstKeywords, objKeywordDao, startTrackId, endtrackId));
            tUpdateRecords.start();
        } catch (Exception e) {
            l.debug(e.getMessage() + "  " + e.getMessage());
        }
    }
}
