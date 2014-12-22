package ranktracker.utility;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;

/**
 * Utility Class to generate rows in Trackhistory table pertaining to current
 * keyword list
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class RowCreator {

    static Logger l = Logger.getLogger(RowCreator.class.getName());
    /**
     * lstKeywords The working list of Keywords objects
     */
    private List<Serpkeywords> lstKeywords = null;
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;

    /**
     * Constructor to set all the variables
     *
     * @param lstKeywords
     * @param appContext
     */
    public RowCreator(List<Serpkeywords> lstKeywords, ApplicationContext appContext) {
        this.lstKeywords = lstKeywords;
        objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
    }

    /**
     * This method delegates call to database layer to create rows in
     * trackhistory table for given list of keywords. The database layer returns
     * an Integer[] of start and trackid for given lstKeywords.
     *
     * @return Integer[] startTrackId, endTrackId
     */
    public Integer[] createRows() {
        return objKeywordDao.createRows(lstKeywords);
    }
    /**
     * This method delegates call to database layer to create rows in
     * trackhistory table for given list of keywords. The database layer returns
     * an Integer[] of start and trackid for given lstKeywords.
     *
     * @return Integer[] startTrackId, endTrackId
     */
   public Integer[] getTrackIdRange() {
        return objKeywordDao.getTrackIdRange(lstKeywords);
    }         
}
