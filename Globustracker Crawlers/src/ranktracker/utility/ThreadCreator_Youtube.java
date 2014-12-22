
package ranktracker.utility;

import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.crawler.youtube.WebRankYoutube;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;


/**
 * Utility Class to create thread groups for crawling.
 *
 * @author user
 */
public class ThreadCreator_Youtube extends Thread {

    static Logger l = Logger.getLogger(ThreadCreator_Youtube.class.getName());
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

    public ThreadCreator_Youtube(ApplicationContext appContext) {
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.appContext = appContext;
    }

    /**
     * Constructor to set all the variables
     *
     * @param setDomains
     * @param lstKeywords
     * @param appContext
     * @param iCount
     *
     */
    public ThreadCreator_Youtube(Set<String> setDomains, List<Serpkeywords> lstKeywords, ApplicationContext appContext ) {

        this.setDomains = setDomains;
        this.lstKeywords = lstKeywords;
        this.appContext = appContext;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.iCount = iCount;
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
        //Integer[] configuration = ReadConfiguration.readProperties();
        //        int countForKeyword = configuration[1];
//        int rangeForKeyword = countForKeyword / 50;
//
//        Thread[] googleThread = new Thread[50];
//
//        for (int iCountz = 0; iCountz <= 49; iCountz++) {
//
//            Integer sKeywordID = (iCountz * rangeForKeyword) + 1;
//            Integer eKeywordID = (iCountz * rangeForKeyword) + rangeForKeyword;
//
//            lstKeywords = objKeywordDao.getKeywords(sKeywordID, eKeywordID);
//            Set<String> setDomains = new HashSet<String>(0);
//            for (Keywords objKeyword : lstKeywords) {
//                setDomains.add(objKeyword.getUrl().trim());
//            }
//
//            //read start trackid and end trackid from table
//            try {
//                Integer[] trackIdRange = objKeywordDao.getTrackIdRange(lstKeywords);
//                startTrackId = trackIdRange[0];
//                endtrackId = trackIdRange[1];
//            } catch (Exception e) {
//                l.debug(e.getMessage() + " ");
//            }
//            
//            try {
//                googleThread[iCountz] = new Thread(new WebRankYoutube(iCountz, lstKeywords, appContext, startTrackId, endtrackId));
//                googleThread[iCountz].start();
//            } catch (Exception e) {
//                l.debug(e.getMessage() + "  " + e.getMessage());
//            }
//        }
//
//        for (int iCountz = 0; iCountz <= 49; iCountz++) {
//            try {
//                googleThread[iCountz].join();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }


        //only for debug
        try {
           // startTrackId = configuration[2];
           // endtrackId = configuration[3];
            Thread WebRankYoutube = new Thread(new WebRankYoutube(iCount, lstKeywords, appContext));
            WebRankYoutube.start();
            WebRankYoutube.join();
        } catch (Exception e) {
            l.debug(e.getMessage() + "  " + e.getMessage());
        }

//        try {
//            Thread tUpdateRecords = new Thread(new UpdateRecords(lstKeywords, objKeywordDao, startTrackId, endtrackId));
//            tUpdateRecords.start();
//        } catch (Exception e) {
//            l.debug(e.getMessage() + "  " + e.getMessage());
//        }
    }
}
