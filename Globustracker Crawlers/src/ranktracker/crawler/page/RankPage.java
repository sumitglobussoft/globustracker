package ranktracker.crawler.page;

import com.temesoft.google.pr.PageRankService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;

/**
 * The crawler class gets Google Page rank for a given domain.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class RankPage implements Runnable {

    static Logger l = Logger.getLogger(RankPage.class.getName());
    /**
     * setDomains The unique collection of domains
     */
    private Set<String> setDomains;
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
     * iCount Counter variable for passing thread group information
     */
    private Integer iCount;

    /**
     * Constructor to set all the variables
     *
     * @param iCount
     * @param setDomains
     * @param lstKeywords
     * @param appContext
     * @param startTrackId
     * @param endtrackId
     *
     */
    public RankPage( Set<String> setDomains, List<Serpkeywords> lstKeywords,
            ApplicationContext appContext, Integer startTrackId, Integer endtrackId) {

       
        this.setDomains = setDomains;
        this.lstKeywords = lstKeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.startTrackId = startTrackId;
        this.endtrackId = endtrackId;
    }

    /**
     * This method delegates call to PageRankService class to retieve page rank
     * which internally calls google pagerank url, adding jenkins hash of given
     * url and the url to google pagerank url.
     *
     * @param domain
     * @return Integer
     */
    public Integer getRankPage(String domain) throws Exception {

        return new PageRankService().getPR(domain);
    }

    /**
     * This method passes the domains from setDomains set to
     *
     * @method getRankPage(
     * @params) and gets the result in Map<String, Integer> setRankPage. Then
     * iterates over lstKeywords, gets webPageRank value from setRankPage and
     * sends data to database layer by calling
     * @method savePageRankResult(
     * @params).
     */
    @Override
    public void run() {

        Map<String, Integer> setRankPage = new HashMap<String, Integer>(0);
        try {
            for (String domainName : setDomains) {
                try {
                    Thread.currentThread().sleep(10000);
                } catch (Exception e) {
                    l.debug(e + "  " + e.getMessage());
                    //e.printStackTrace();
                }
                setRankPage.put(domainName.trim(), getRankPage(domainName.trim()));
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage());
        }


        Integer webPageRank;
        Integer keywordId;
        String domainName;
        try {
            for (Serpkeywords objKeywords : lstKeywords) {
                domainName = objKeywords.getUrl().trim();
                keywordId = objKeywords.getKeywordID();
                webPageRank = setRankPage.get(domainName);
                objKeywordDao.savePageRankResult(keywordId, webPageRank, startTrackId,
                        endtrackId);
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage());
        }

    }
}
