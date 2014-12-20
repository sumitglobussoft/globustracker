/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Videokeywords;

/**
 * Service layer interface for Campaigns Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
@Transactional(readOnly = true)
public interface CampaignsService {

    /**
     * The method to get campaigns and keywords for a customerid
     *
     * @param customerId
     * @return Object[]
     */
    public Object[] getData(Integer customerId);
    
    /**
     * The method to get campaigns and keywords for a customerid
     *
     * @param customerId
     * @return Object[]
     */
    public Object[] getSerpData(Integer customerId);

    /**
     * The method to get campaigns and keywords for a customerid
     *
     * @param customerId
     * @return Object[]
     */
    public Object[] getVideoData(Integer customerId);
    
    /**
     * The method to add new campaign
     *
     * @param campaignName
     * @param userID
     * @return int result
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer addCampaign(String campaignName, Integer userID);

    /**
     * 
     * @param campaignName
     * @param customerID
     * @return 
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer addVideoCampaign(String campaignName, Integer customerID);
    
    /**
     * The method deletes a campaign
     *
     * @param siteId
     * @param customerID
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public String deleteCampaign(Integer campaignId, Integer customerID);

    /**
     * 
     * @param campaignId
     * @param customerID 
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public String deleteVideoCampaign(Integer campaignId, Integer customerID);
    
    /**
     * The method retrieves list of campaigns for given date to send mails
     *
     * @param todayDate
     * @return list of campaigns
     */
    public List<Campaigns> getEmailIdsForReport(java.util.Date todayDate);

    /**
     * The method edits/updates given campaign
     *
     * @param siteId
     * @param siteName
     * @param userID
     * @return int result
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int editCampaign(Integer campaignId, String campaignName, Integer userID);

    /**
     * The method retrieves campaign object
     *
     * @param campaignID
     * @return campaign object
     */
    public Campaigns getCampaignObj(Integer campaignID);

    /**
     * The method searches for campaigns based on search key and customer id
     *
     * @param campaign
     * @param customerID
     * @return list of campaigns
     */
    public List<Campaigns> searchCampaign(String campaign, Integer customerID);

    /**
     * The method validates view key and retrieves corresponding campaign object
     *
     * @param viewKey
     * @return Object[]
     */
    public Object[] getViewKeyDetails(String parameter);
       
    /**
     * 
     * @param customerId
     * @return 
     */
    public List<Serpkeywords> getRankData(Integer customerId);
    
     /**
     * 
     * @param customerId
     * @return 
     */
    public List<Videokeywords> getRankDataVideo(Integer customerId);
    
    
    @Transactional(propagation = Propagation.REQUIRED)
    public int refreshCampaign(Integer campaignId, String campaignName, Integer userID);

}
