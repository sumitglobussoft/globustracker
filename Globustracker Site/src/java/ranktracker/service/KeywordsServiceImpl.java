/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import org.apache.log4j.Logger;
import ranktracker.dao.CampaignsDao;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Displaysettings;
import ranktracker.entity.Globustrackerevents;
import ranktracker.entity.Serpkeywordgoal;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Serpstrackhistory;
import ranktracker.entity.Socialtrackhistory;
import ranktracker.entity.Videokeywords;

/**
 * Service layer class for Keywords Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class KeywordsServiceImpl implements KeywordsService {

    static Logger l = Logger.getLogger(KeywordsServiceImpl.class.getName());
    /**
     * objKeywordsDao The database layer object variable for KeywordsDao object
     */
    private KeywordsDao objKeywordsDao;
    //This object name 'objKeywordsDao' should be same as declared bean in 'beans.xml' for ranktracker.dao.KeywordsDaoImpl class
    //then we have to generate getter and setter method for objKeywordsDao object.
    //by doing so, spring container initialize the objKeywordsDao object.
    /**
     * lstkeywords The list containing Keywords objects
     */
    private List<Serpkeywords> lstkeywords;
    /**
     * objCampaignsDao The database layer object variable for CampaignsDao
     * object
     */
    private CampaignsDao objCampaignsDao;

    /**
     * The method retrieves campaign object and keywords for a given campaign id
     *
     * @param siteID
     * @return Object[]
     */
    @Override
    public Object[] getData(Integer campaignID, Integer customerId) {
        //lstkeywords = objKeywordsDao.getKeywords(campaignID);
        //campaignName = objCampaignsDao.getCampaign(campaignID);

        //calling the getKeywords and getCampaign method of KeywordsDaoImpl class
        return new Object[]{objKeywordsDao.getKeywords(campaignID),
            objCampaignsDao.getCampaign(campaignID, customerId)};
    }

    /**
     *
     * @param campaignID
     * @param customerId
     * @return
     */
    @Override
    public Object[] getSerpData(Integer campaignID,Integer customerId) {

        //calling the getKeywords and getCampaign method of KeywordsDaoImpl class
        return new Object[]{objKeywordsDao.getSerpKeywords(campaignID), objKeywordsDao.getSocialSignalData(campaignID),
            objCampaignsDao.getCampaign(campaignID, customerId), objKeywordsDao.getSeoDetails(campaignID)};
    }

    @Override
    public Object[] getSerpDataLimited(Integer campaignID, int initial) {
        //calling the getKeywords and getCampaign method of KeywordsDaoImpl class
        return new Object[]{objKeywordsDao.getSerpKeywords(campaignID),
            objKeywordsDao.getSeoDetails(campaignID)};
    }

    /**
     *
     * @param campaignID
     * @return
     */
    @Override
    public Object[] getVideoData(Integer campaignID, Integer customerId) {

        return new Object[]{objKeywordsDao.getVideoKeywords(campaignID),
            objCampaignsDao.getCampaign(campaignID, customerId)};
    }

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
    @Override
    public int addKeyword(List keys, Integer campaignId, String url, String linkGoogle, String matchLink, String matchRank, String engine) {

        //calling the addKeyword method of KeywordsDaoImpl class
        return objKeywordsDao.addKeyword(keys, campaignId, url, linkGoogle, matchLink, matchRank, engine);
    }

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
    @Override
    public int addVideoKeyword(List keys, Integer campaignID, String youtubeurl, String vimeourl, String dailymotionurl, String metacafeurl) {

        //calling addVideoKeyword method of KeywordsDaoImpl class
        return objKeywordsDao.addVideoKeyword(keys, campaignID, youtubeurl, vimeourl, dailymotionurl, metacafeurl);
    }

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
    @Override
    public Integer editKeyword(Integer keywordId, String keyword, String url, String linkGoogle, Integer campaignId) {

        //calling the editKeyword method of KeywordsDaoImpl class
        return objKeywordsDao.editKeyword(keywordId, keyword, url, linkGoogle, campaignId);
    }

    /**
     * The method gets serpstrackhistory table data for charts module
     *
     * @param keywordId
     * @param range
     * @return List<Trackhistory>
     */
    @Override
    public List<Serpstrackhistory> getChartData(Integer keywordId, Integer range) {

        //calling the getChartData method of KeywordsDaoImpl class
        return objKeywordsDao.getChartData(keywordId, range);
    }

    @Override
    public List<Integer> getCampaignChartData(Integer campaignId) {

        return objKeywordsDao.getCampaignChartData(campaignId);
    }

    /**
     *
     * @param campaignId
     * @return
     */
    @Override
    public List<Videokeywords> getVideoChartData(Integer campaignId) {

        return objKeywordsDao.getChartDataVideo(campaignId);
    }

    /**
     * The method gets socialtrackhistory table data for charts module
     *
     * @param keywordId
     * @param range
     * @return List<Trackhistory>
     */
    @Override
    public List<Socialtrackhistory> getChartDataSocial(Integer urlId, Integer range) {
        //calling the getChartData method of KeywordsDaoImpl class
        return objKeywordsDao.getChartDataSocial(urlId, range);
    }

    /**
     * The method deletes a keyword
     *
     * @param keywordId
     * @param campaignId
     */
    @Override
    public void deleteKeyword(Integer keywordId, Integer campaignId) {

        //calling the deleteKeyword method of KeywordsDaoImpl class
        objKeywordsDao.deleteKeyword(keywordId, campaignId);
    }

    /**
     * The method gets keywords for a given customer id
     *
     * @param customerID
     * @return Object[]
     */
    @Override
    public Object[] getDataForReports(Integer customerID) {

        //calling the getKeywordses method of KeywordsDaoImpl class
        lstkeywords = objKeywordsDao.getKeywordses(customerID);
        return new Object[]{lstkeywords};
    }

    /**
     * the method checks keyword quota of a customer
     *
     * @param userID
     * @return int
     */
    @Override
    public int checkKeywordQuota(Integer userID) {

        //calling the checkKeywordQuota method of KeywordsDaoImpl class
        return objKeywordsDao.checkKeywordQuota(userID);
    }

    /**
     * The method adds better ranking url for a given keyword, engine
     *
     * @param keywordId
     */
    @Override
    public void addBetterRankingKeyword(Integer keywordId) {

        //calling the addBetterRankingKeyword method of KeywordsDaoImpl class
        objKeywordsDao.addBetterRankingKeyword(keywordId);
    }

    @Override
    public List<Serpkeywords> getKeywords(Integer customerId, String campaign) {

        //calling the getKeywords method of KeywordsDaoImpl class
        return objKeywordsDao.getKeywords(customerId, campaign);
    }

    /**
     *
     * @return objKeywordsDao
     */
    public KeywordsDao getObjKeywordsDao() {
        return objKeywordsDao;
    }

    /**
     *
     * @param objKeywordsDao
     */
    public void setObjKeywordsDao(KeywordsDao objKeywordsDao) {
        this.objKeywordsDao = objKeywordsDao;
    }

    /**
     *
     * @return objCampaignsDao
     */
    public CampaignsDao getObjCampaignsDao() {
        return objCampaignsDao;
    }

    /**
     *
     * @param objCampaignsDao
     */
    public void setObjCampaignsDao(CampaignsDao objCampaignsDao) {
        this.objCampaignsDao = objCampaignsDao;
    }

    @Override
    public int addBestMatchKeyword(List keys, Integer siteId, String url, String linkGoogle, String matchLink, String matchRank, String engine) {

        //calling the addBestMatchKeyword method of KeywordsDaoImpl class
        return objKeywordsDao.addBestMatchKeyword(keys, siteId, url, linkGoogle, matchLink, matchRank, engine);
    }

    /**
     *
     * @param keywordId
     * @param keyword
     * @param url
     * @param linkGoogle
     * @param campaignId
     * @return
     */
    @Override
    public int editVideoKeywords(Integer campaignId, Integer keywordId, String keyword, String youtubeurl, String vimeourl,
            String dailymotionurl, String metacafeurl) {

        //calling the editVideoKeyword method of KeywordDaoImpl class
        return objKeywordsDao.editVideoKeyword(campaignId, keywordId, keyword, youtubeurl, vimeourl, dailymotionurl, metacafeurl);
    }

    /**
     *
     * @param keywordId
     * @param campaignId
     */
    @Override
    public void deleteVideoKeyword(Integer keywordId, Integer campaignId) {

        //calling the deleteVideoKeyword of KeywordsDaoImpl
        objKeywordsDao.deleteVideoKeyword(keywordId, campaignId);
    }

    /**
     *
     * @param customerId
     * @return
     */
    @Override
    public List<Displaysettings> getCustomerSettings(Integer customerId) {
        return objKeywordsDao.showCustomerSettings(customerId);
    }

    /**
     *
     * @param siteID
     * @return
     */
    @Override
    public List<Serpkeywords> getKeywords(Integer siteID) {
        return objKeywordsDao.getKeywords(siteID);
    }

    @Override
    public List<Serpkeywordgoal> getChartGoalData(Integer keywordId) {
        return objKeywordsDao.getChartGoalData(keywordId);
    }

    @Override
    public int setSerpsKeywordGoal(Integer keywordId, Integer goalRank, String dategoal) {
        System.out.println("-----------------Keywords---------------------");
        return objKeywordsDao.setSerpsKeywordGoal(keywordId, goalRank, dategoal);
    }

    @Override
    public List<Globustrackerevents> getChartEventData() {

        return objKeywordsDao.getChartEventData();
    }

    @Override
    public String getKeywordName(Integer keywordID) {

        return objKeywordsDao.getKeywordName(keywordID);
    }
}
