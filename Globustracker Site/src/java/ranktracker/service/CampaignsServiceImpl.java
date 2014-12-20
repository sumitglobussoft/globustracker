/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import org.apache.log4j.Logger;
import ranktracker.dao.CampaignsDao;
import ranktracker.dao.CustomerDao;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Videokeywords;

/**
 * Service layer class for Campaigns Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class CampaignsServiceImpl implements CampaignsService {

    static Logger l = Logger.getLogger(CampaignsServiceImpl.class.getName());
    /**
     * objCampaignsDao The database layer object variable for CampaignsDao
     * object
     */
    
    //This object name 'objCampaignsDao' should be same as declared bean in 'beans.xml' for ranktracker.dao.CampaignsDaoImpl class
    //then we have to generate getter and setter method for objCampaignsDao object.
    //by doing so, spring container initialize the objCampaignsDao object. 
    
    
    private CampaignsDao objCampaignsDao;
    /**
     * objCustomerDao The database layer object variable for CustomerDao object
     */
    private CustomerDao objCustomerDao;

    /**
     * The method to get campaigns and keywords for a customerid
     *
     * @param customerId
     * @return Object[]
     */
    @Override
    public Object[] getData(Integer customerId) {

        //calling  getKeywordsCount() of CustomerDaoImpl class 
        List<Integer> lstKeywordData = objCustomerDao.getKeywordsCount(customerId);

        //calling  getCampaigns() method of CampaignsDaoImpl
        List<Campaigns> lstCampaigns = objCampaignsDao.getCampaigns(customerId);
        return new Object[]{lstKeywordData, lstCampaigns};
    }
    
    /**
     * The method to get campaigns and keywords for a customerid
     *
     * @param customerId
     * @return Object[]
     */
    @Override
    public Object[] getSerpData(Integer customerId) {

        //calling  getKeywordsCount() of CustomerDaoImpl class 
        List<Integer> lstKeywordData = objCustomerDao.getKeywordsCount(customerId);

        //calling  getCampaigns() method of CampaignsDaoImpl
        List<Campaigns> lstCampaigns = objCampaignsDao.getSerpCampaigns(customerId);
        return new Object[]{lstKeywordData, lstCampaigns};
    }

    /**
     * 
     * @param customerId
     * @return 
     */
    @Override
    public Object[] getVideoData(Integer customerId) {
     
         //callint getVideoKeywordsCount() of CustomerDaoImpl class
         List<Integer> lstKeywordData = objCustomerDao.getVideoKeywordsCount(customerId);
         
         //calling getCampaign() method 
         List<Campaigns> lstCampaigns = objCampaignsDao.getVideoCampaigns(customerId);
         return new Object[]{lstKeywordData, lstCampaigns};
    }
    
    /**
     * The method to add new campaign
     *
     * @param siteName
     * @param customerID
     * @return int result
     */
    @Override
    public Integer addCampaign(String campaignName, Integer userID) {

        //calling addCampaign() method of CampaignsDaoImpl class
        return objCampaignsDao.addCampaign(campaignName, userID);
    }

    /**
     * The method edits/updates given campaign
     *
     * @param siteId
     * @param siteName
     * @param userID
     * @return int result
     */
    @Override
    public int editCampaign(Integer campaignId, String campaignName, Integer userID) {

        //calling editCampaign() method of CampaignsDaoImpl class
        return objCampaignsDao.editCampaign(campaignId, campaignName, userID);
    }

    /**
     * The method deletes a campaign
     *
     * @param siteId
     * @param customerID
     */
    @Override
    public String deleteCampaign(Integer campaignId, Integer customerID) {

        //calling deleteCampaign() method of CampaignsDaoImpl class
        return objCampaignsDao.deleteCampaign(campaignId, customerID);
    }

    /**
     * The method retrieves list of campaigns for given date to send mails
     *
     * @param todayDate
     * @return list of campaigns
     */
    @Override
    public List getEmailIdsForReport(java.util.Date todayDate) {

        //calling getEmailIdsForReport() method of CampaignsDaoImpl class
        return objCampaignsDao.getEmailIdsForReport(todayDate);
    }

    /**
     * The method retrieves campaign object
     *
     * @param campaignID
     * @return campaign object
     */
    @Override
    public Campaigns getCampaignObj(Integer campaignID) {

        //calling getCampaignObj() method of CampaignsDaoImpl class
        return objCampaignsDao.getCampaignObj(campaignID);
    }

    /**
     * The method searches for campaigns based on search key and customer id
     *
     * @param campaign
     * @param customerID
     * @return list of campaigns
     */
    @Override
    public List<Campaigns> searchCampaign(String campaign, Integer customerID) {

        //calling searchCampaign() method of CampaignsDaoImpl class
        return objCampaignsDao.searchCampaign(campaign, customerID);
    }

    /**
     * The method validates view key and retrieves corresponding campaign object
     *
     * @param viewKey
     * @return Object[]
     */
    @Override
    public Object[] getViewKeyDetails(String viewKey) {

        //calling getViewKeyData() method of CampaignsDaoImpl class
        List<Campaigns> lstCampaigns = objCampaignsDao.getViewKeyData(viewKey);
        return new Object[]{lstCampaigns};
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

    /**
     *
     * @return objCustomerDao
     */
    public CustomerDao getObjCustomerDao() {
        return objCustomerDao;
    }

    /**
     *
     * @param objCustomerDao
     */
    public void setObjCustomerDao(CustomerDao objCustomerDao) {
        this.objCustomerDao = objCustomerDao;
    }

    @Override
    public List<Serpkeywords> getRankData(Integer customerId) {
        return objCampaignsDao.getCustomerRankList(customerId);
    }

    @Override
    public List<Videokeywords> getRankDataVideo(Integer customerId) {
        return objCampaignsDao.getCustomerRankListVideo(customerId);
    }
    
    @Override
    public Integer addVideoCampaign(String campaignName, Integer userID) {
        return objCampaignsDao.addVideoCampaign(campaignName, userID);
    }

     @Override
    public int refreshCampaign(Integer campaignId, String campaignName, Integer userID) {

        //calling editCampaign() method of CampaignsDaoImpl class
        return objCampaignsDao.refreshCampaign(campaignId, campaignName, userID);
    }

    @Override
    public String deleteVideoCampaign(Integer campaignId, Integer customerID) {
        return objCampaignsDao.deleteVideoCampaign(campaignId, customerID);
    }
   
}
