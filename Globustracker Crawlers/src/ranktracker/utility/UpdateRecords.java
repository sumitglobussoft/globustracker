package ranktracker.utility;

import java.util.List;
import org.apache.log4j.Logger;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;

/**
 * Utility class to update Keywords, Alerts and Crawl Info.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
class UpdateRecords implements Runnable {

    static Logger l = Logger.getLogger(UpdateRecords.class.getName());
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
     * Constructor to set all the variables
     *
     * @param lstKeywords
     * @param objKeywordDao
     * @param startTrackId
     * @param endtrackId
     *
     */
    public UpdateRecords(List<Serpkeywords> lstKeywords, KeywordsDao objKeywordDao, Integer startTrackId, Integer endtrackId) {
        this.objKeywordDao = objKeywordDao;
        this.lstKeywords = lstKeywords;
        this.startTrackId = startTrackId;
        this.endtrackId = endtrackId;
    }

    /**
     * This method makes database layer calls to
     *
     * @method updateKeywords(
     * @params)to update keywords table
     * @method setCrawlInfo(
     * @params) to set crawl info in monitor table
     * @method updateAlerts(
     * @params) to update alerts in alerts table
     */
    @Override
    public void run() {
        try {
            objKeywordDao.updateKeywords(lstKeywords, startTrackId, endtrackId);

        } catch (Exception ex) {
            l.debug(ex.getMessage() + "  " + ex.getMessage());
        }
        try {
            objKeywordDao.setCrawlInfo(lstKeywords, startTrackId, endtrackId);
            objKeywordDao.updateAlerts(lstKeywords, startTrackId, endtrackId);
        } catch (Exception e) {
            l.debug(e.getMessage() + "  " + e.getMessage());

        }
    }
}
