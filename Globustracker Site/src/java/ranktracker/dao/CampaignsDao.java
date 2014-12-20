package ranktracker.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Videokeywords;
import ranktracker.form.EcomtrackerForm;

/**
 * DAO layer interface for Campaigns Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public interface CampaignsDao {

    /**
     * The method to retrieve campaigns list
     *
     * @param customerId
     * @return list of campaigns
     */
    public List<Campaigns> getCampaigns(Integer customerId);

    /**
     * The method to retrieve campaigns list
     *
     * @param customerId
     * @return list of campaigns
     */
    public List<Campaigns> getSerpCampaigns(Integer customerId);

    /**
     * The method to retrieve campaigns list
     *
     * @param customerId
     * @return list of campaigns
     */
    public List<Campaigns> getVideoCampaigns(Integer customerId);

    /**
     * The method to add new campaign
     *
     * @param siteName
     * @param customerID
     * @return int result
     */
    public Integer addCampaign(String siteName, Integer userID);

    /**
     *
     * @param siteName
     * @param customerID
     * @return
     */
    public Integer addVideoCampaign(String siteName, Integer userID);

    /**
     * The method edits/updates given campaign
     *
     * @param siteId
     * @param siteName
     * @param userID
     * @return int result
     */
    public int editCampaign(Integer siteId, String siteName, Integer userID);

    /**
     * The method deletes a campaign
     *
     * @param siteId
     * @param customerID
     */
    public String deleteCampaign(Integer siteId, Integer customerID);

    /**
     *
     * @param siteId
     * @param customerID
     */
    public String deleteVideoCampaign(Integer siteId, Integer customerID);

    /**
     * The method retrieves list of campaigns for given date to send mails
     *
     * @param todayDate
     * @return list of campaigns
     */
    public List<Campaigns> getEmailIdsForReport(java.util.Date todayDate);

    /**
     * The method retrieves campaign name
     *
     * @param campaignID
     * @return campaign name
     */
    public String getCampaign(Integer campaignID, Integer customerId);

    /**
     *
     * @param customerID
     * @return
     */
    public List<Serpkeywords> getCustomerRankList(Integer customerID);

     /**
     *
     * @param customerID
     * @return
     */
    public List<Videokeywords> getCustomerRankListVideo(Integer customerID);

    
    /**
     * The method retrieves campaign object
     *
     * @param campaignID
     * @return campaign object
     */
    public Campaigns getCampaignObj(Integer campaignID);

    /**
     * the method searches for campaigns based on search key and customer id
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
     * @return campaigns list
     */
    public List<Campaigns> getViewKeyData(String viewKey);

    public int refreshCampaign(Integer siteId, String siteName, Integer userID);

    /**
     * The method updates pdf options of a customer
     *
     * @param customerId
     * @param companyName
     * @param companyUrl
     * @param companyLogo
     */
    public void updatePdfOptions(Integer campaignId, String companyName, String companyUrllink, String companyLogoLink);
    
    public List<Campaigns> getEcomCampaigns(Integer customerId);
    
    public List<EcomtrackerForm> getEcomComparisons(Collection<Serpkeywords> lstSerpkeywords);
}
