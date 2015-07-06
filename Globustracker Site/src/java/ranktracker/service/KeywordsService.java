/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ranktracker.entity.Displaysettings;
import ranktracker.entity.Globustrackerevents;
import ranktracker.entity.Serpkeywordgoal;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Serpstrackhistory;
import ranktracker.entity.Socialtrackhistory;
import ranktracker.entity.Videokeywords;

/**
 * Service layer interface for Keywords Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
@Transactional(readOnly = true)
public interface KeywordsService {

    /**
     * The method retrieves campaign object and keywords for a given campaign id
     *
     * @param siteID
     * @return Object[]
     */
    public Object[] getData(Integer siteID, Integer customerId);

    /**
     * 
     * @param siteID
     * @param customerId
     * @return 
     */
    public Object[] getSerpData(Integer siteID,Integer customerId);
    /**
     *
     * @param campaignID
     * @return
     */
    public Object[] getVideoData(Integer campaignID,Integer customerId);

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
    @Transactional(propagation = Propagation.REQUIRED)
    public int addKeyword(List keys, Integer siteId, String url, String linkGoogle, String matchLink, String matchRank, String engine);

    /**
     * This method adds keyword to VideoKeywords table
     *
     * @param keys
     * @param siteId
     * @param url
     * @param linkGoogle
     * @param matchLink
     * @param matchRank
     * @param engine
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int addVideoKeyword(List keys, Integer campaignID, String youtubeurl, String vimeourl, String dailymotionurl, String metacafeurl);

    /**
     * The method edits/updates a given keyword
     *
     * @param keywordId
     * @param keyword
     * @param url
     * @param linkGoogle
     * @param campaignId
     * @return int
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer editKeyword(Integer keywordId, String keyword, String url, String linkGoogle, Integer campaignId);

    /**
     *
     * @param customerId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Displaysettings> getCustomerSettings(Integer customerId);

    /**
     *
     * @param keywordId
     * @param keyword
     * @param url
     * @param linkGoogle
     * @param campaignId
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int editVideoKeywords(Integer campaignId, Integer keywordId, String keyword, String youtubeurl, String vimeourl, String dailymotionurl, String metacafeurl);

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
     * 
     * @param campaignId
     * @return 
     */
    public List<Videokeywords> getVideoChartData(Integer campaignId);

    /**
     * The method gets socialtrackhistory table data for charts module
     *
     * @param keywordId
     * @param range
     * @return List<Serpstrackhistory>
     */
    public List<Socialtrackhistory> getChartDataSocial(Integer urlId, Integer range);

    /**
     * The method deletes a keyword
     *
     * @param keywordId
     * @param campaignId
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteKeyword(Integer keywordId, Integer campaignId);

    /**
     *
     * @param keywordId
     * @param campaignId
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteVideoKeyword(Integer keywordId, Integer campaignId);

    /**
     * The method gets keywords for a given customer id
     *
     * @param customerID
     * @return Object[]
     */
    public Object[] getDataForReports(Integer customerID);

    /**
     * The method adds better ranking url for a given keyword, engine
     *
     * @param keywordId
     */
    @Transactional(propagation = Propagation.REQUIRED)
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
     * @param siteId
     * @param url
     * @param linkGoogle
     * @param matchLink
     * @param matchRank
     * @param engine
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int addBestMatchKeyword(List keys, Integer siteId, String url, String linkGoogle, String matchLink, String matchRank, String engine);

    /**
     *
     * @param customerId
     * @param campaign
     * @return
     */
    public List<Serpkeywords> getKeywords(Integer customerId, String campaign);

    /**
     *
     * @param siteID
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Serpkeywords> getKeywords(Integer siteID);

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
    @Transactional(propagation = Propagation.REQUIRED)
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

    public Object[] getSerpDataLimited(Integer campaignId, int initial);
    
}
