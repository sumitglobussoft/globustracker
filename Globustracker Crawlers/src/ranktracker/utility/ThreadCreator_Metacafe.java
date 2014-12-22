package ranktracker.utility;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.crawler.metacafe.WebRankMetaCafe;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.Serpkeywords;

/**
 * Utility Class to create thread groups for crawling.
 *
 * @author user
 */
public class ThreadCreator_Metacafe extends Thread {

    static Logger l = Logger.getLogger(ThreadCreator_Metacafe.class.getName());
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

    public ThreadCreator_Metacafe(ApplicationContext appContext) {
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
    public ThreadCreator_Metacafe(Set<String> setDomains, List<Serpkeywords> lstKeywords, ApplicationContext appContext) {

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
     * @method readProperties(). read the properties start TrackId,end trackId,start KeywordID,end KeywordID from properties file
     * 
     * @method run() : start 50 threads for google crawler
     */
    @Override
    public void run() {
        Integer[] configuration = ReadConfiguration.readProperties();
        startTrackId = configuration[2];
        endtrackId = configuration[3];

        int countForKeyword = configuration[1];
        int rangeForKeyword = countForKeyword / 10;

        Thread[] googleThread = new Thread[10];

        for (int iCountz = 0; iCountz <= 9; iCountz++) {

            Integer sKeywordID = (iCountz * rangeForKeyword) + 1;
            Integer eKeywordID = (iCountz * rangeForKeyword) + rangeForKeyword;

            lstKeywords = objKeywordDao.getKeywords(sKeywordID, eKeywordID);
            Set<String> setDomains = new HashSet<String>(0);
            for (Serpkeywords objKeyword : lstKeywords) {
                setDomains.add(objKeyword.getUrl().trim());
            }

            //read start trackid and end trackid from table
            try {
                Integer[] trackIdRange = objKeywordDao.getTrackIdRange(lstKeywords);
                startTrackId = trackIdRange[0];
                endtrackId = trackIdRange[1];
            } catch (Exception e) {
                l.debug(e.getMessage() + " ");
            }
            
            try {
                googleThread[iCountz] = new Thread(new WebRankMetaCafe(iCountz, lstKeywords, appContext, startTrackId, endtrackId));
                googleThread[iCountz].start();
            } catch (Exception e) {
                l.debug(e.getMessage() + "  " + e.getMessage());
            }
        }

        for (int iCountz = 0; iCountz <= 9; iCountz++) {
            try {
                googleThread[iCountz].join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            Thread tUpdateRecords = new Thread(new UpdateRecords(lstKeywords, objKeywordDao, startTrackId, endtrackId));
            tUpdateRecords.start();
        } catch (Exception e) {
            l.debug(e.getMessage() + "  " + e.getMessage());
        }
    }
}
