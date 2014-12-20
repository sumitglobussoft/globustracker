/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Customers;
import ranktracker.entity.Displaysettings;
import ranktracker.entity.Reportfrequency;
import ranktracker.entity.Site;
import ranktracker.entity.Users;

/**
 * Service layer interface for Settings Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
@Transactional(readOnly = true)
public interface SettingsService {

    /**
     * The method retrieves user data and campaigns for a given user id
     *
     * @param userID
     * @return
     */
    public Object[] getPageData(Integer userID);

    /**
     * The method updates password of a customer
     *
     * @param userID
     * @param oldPassword
     * @param newpassword
     * @return Users
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Users updatePassword(Integer userID, String oldPassword, String newpassword);

    /**
     * The method updates email settings for campaigns
     *
     * @param customerId
     * @param siteId
     * @param reportEmailId
     * @param frequency
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateEmailSettings(Integer customerId, String[] siteId, String[] reportEmailId, String[] frequency);

   
    /**
     * The method sets next mail sending date for a campaign
     *
     * @param objSite
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateNextMailSendDate(Campaigns objSite);

    /**
     * The method updates timezone of a customer
     *
     * @param customerId
     * @param timezone
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateTimezone(Integer customerId, Integer timezone);

    /**
     * The method updates pdf options of a customer
     *
     * @param customerId
     * @param companyUrl
     * @param companyLogo
     * @param companyDesc
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePdfOptions(Integer campaignId,String companyName, String companyUrllink, String companyLogoLink);

    /**
     * The method adds a new user to database
     *
     * @param email
     * @param password
     * @param userType
     * @param customerID
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addUser(String email, String password, Integer userType, Integer customerID);

    /**
     * This method shows the settings of individual user
     * 
     * @param customerID 
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Displaysettings> showSettings(Integer customerID);
    
    /**
     * The method checks number of existing users for a customer
     *
     * @param customerID
     * @return int
     */
    public Integer checkAddUserQuota(Integer customerID);

    /**
     * 
     * @param tabsettings
     * @return 
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer addSettings(Map tabsettings);
    
    /**
     * The method to retrieve campaigns list by given customer id
     *
     * @param customerId
     * @return list of campaigns
     */
    public List<Campaigns> getCampaigns(Integer customerID);

    /**
     * The method retrieves reportfrequency data
     *
     * @return List<ReportFrequency>
     */
    public List<Reportfrequency> getFrequency();

    /**
     * The method retrieves user records for a given customer id
     *
     * @param customerID
     * @param userID
     * @return List
     */
    public Object[] getUserDetails(Integer customerID, Integer userID);
    
    /**
     * 
     * @param host
     * @return 
     */
    public Site getSiteData(String host);
    
    
    @Transactional(propagation = Propagation.REQUIRED)
    public Campaigns pdfUpdateReport(Integer customerID);
}
