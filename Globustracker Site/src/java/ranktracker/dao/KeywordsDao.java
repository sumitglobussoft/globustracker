package ranktracker.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ranktracker.entity.Displaysettings;
import ranktracker.entity.Globustrackerevents;
import ranktracker.entity.Seokeyworddetails;
import ranktracker.entity.Serpkeywordgoal;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Serpstrackhistory;
import ranktracker.entity.Socialtrackhistory;
import ranktracker.entity.Videokeywords;
import ranktracker.form.KeywordsLastUpdatedForm;

/**
 * DAO layer interface for Keywords Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public interface KeywordsDao {

    /**
     * The method gets keywords for a given campaign id
     *
     * @param siteID
     * @return List<Keywords>
     */
    public List<Serpkeywords> getKeywords(Integer siteID);

    /**
     *
     * @param siteID
     * @return
     */
    public List<Serpkeywords> getSerpKeywords(Integer siteID);
    
    /**
     *
     * @param siteID
     * @return
     */
    public List<Seokeyworddetails> getSeoDetails(Integer siteID);

    /**
     * The method adds new keyword records to database
     *
     * @param keys
     * @param siteId
     * @param url
     * @param googleRegion
     * @param matchLink
     * @param matchRank
     * @param engine
     * @return int
     */
    public int addKeyword(List keys, Integer siteId, String url, String googleRegion, String matchLink, String matchRank, String engine);

    /**
     * This method adds keywords to VIdeoKEywords table
     *
     * @param keys
     * @param siteId
     * @param url
     * @param googleRegion
     * @param matchLink
     * @param matchRank
     * @param engine
     * @return
     */
    public int addVideoKeyword(List keys, Integer campaignID, String youtubeurl, String vimeourl, String dailymotionurl, String metacafeurl);

    /**
     * The method gets serpstrackhistory table data for charts module
     *
     * @param keywordId
     * @param range
     * @return List<Serpstrackhistory>
     */
    public List<Serpstrackhistory> getChartData(Integer keywordId, Integer range);

    /**
     *
     * @param campaignId
     * @return
     */
    public List<Integer> getCampaignChartData(Integer campaignId);

    /**
     * The method gets socialtrackhistory table data for charts module
     *
     * @param keywordId
     * @param range
     * @return List<Serpstrackhistory>
     */
    public List<Socialtrackhistory> getChartDataSocial(Integer urlId, Integer range);

    /**
     * The method edits/updates a given keyword
     *
     * @param keywordId
     * @param keyword
     * @param url
     * @param searchEngine
     * @param campaignId
     * @return int
     */
    public Integer editKeyword(Integer keywordId, String keyword, String url, String searchEngine, Integer campaignId);

    /**
     *
     * @param keywordId
     * @param keyword
     * @param url
     * @param searchEngine
     * @param campaignId
     * @return
     */
    public int editVideoKeyword(Integer campaignId, Integer keywordId, String keyword, String youtubeurl, String vimeourl, String dailymotionurl,
            String metacafeurl);

    /**
     *
     * @param keywordId
     * @param range
     * @return
     */
    public List<Videokeywords> getChartDataVideo(Integer campId);

    /**
     *
     * @param campaignId
     * @return
     */
    public List<Videokeywords> getVideoKeywords(Integer campaignId);

    /**
     * The method deletes a keyword
     *
     * @param keywordId
     * @param campaignId
     */
    public void deleteKeyword(Integer keywordId, Integer campaignId);

    /**
     *
     * @param keywordId
     * @param campaignId
     */
    public void deleteVideoKeyword(Integer keywordId, Integer campaignId);

    /**
     * The method retrieves keyword records for a given customer id
     *
     * @param customerID
     * @return List<Keywords>
     */
    public List<Serpkeywords> getKeywordses(Integer customerID);

    /**
     * The method adds better ranking url for a given keyword, engine
     *
     * @param keywordId
     */
    public void addBetterRankingKeyword(Integer keywordId);

    /**
     * the method checks keyword quota of a customer
     *
     * @param userID
     * @return int
     */
    public int checkKeywordQuota(Integer userID);

    /**
     *
     * @param keys
     * @param campaignId
     * @param url
     * @param linkGoogle
     * @param matchLink
     * @param matchRank
     * @param engine
     * @return
     */
    public int addBestMatchKeyword(List keys, Integer campaignId, String url, String linkGoogle, String matchLink, String matchRank, String engine);

    /**
     *
     * @param customerId
     * @param campaign
     * @return
     */
    public List<Serpkeywords> getKeywords(Integer customerId, String campaign);

    /**
     *
     * @param customerID
     * @return
     */
    public List<Displaysettings> showCustomerSettings(Integer customerID);

    /**
     *
     * @param keywordId
     * @return
     */
    public List<Serpkeywordgoal> getChartGoalData(Integer keywordId);

    /**
     *
     * @param keywordId
     * @param goalRank
     * @param dategoal
     * @return
     */
    public int setSerpsKeywordGoal(Integer keywordId, Integer goalRank, String dategoal);

    /**
     *
     * @return
     */
    public List<Globustrackerevents> getChartEventData();

    /**
     *
     * @param keywordID
     * @return
     */
    public String getKeywordName(Integer keywordID);

    /**
     *
     * @param campaignID
     * @param url
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int addUrl(Integer campaignID, String url);

    @Transactional(propagation = Propagation.REQUIRED)
    public List<KeywordsLastUpdatedForm> getSocialSignalData(Integer siteID);

    @Transactional(propagation = Propagation.REQUIRED)
    public int editUrl(Integer urlID, String url, Integer campaignID);

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUrl(Integer urlID, Integer campaignID);
}
