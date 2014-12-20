/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import ranktracker.dao.CampaignsDao;
import ranktracker.dao.CustomerDao;
import ranktracker.dao.UtilityDataDao;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Displaysettings;
import ranktracker.entity.Reportfrequency;
import ranktracker.entity.Site;
import ranktracker.entity.Users;

/**
 * Service layer class for Settings Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class SettingsServiceImpl implements SettingsService {

    static Logger l = Logger.getLogger(SettingsServiceImpl.class.getName());
    /**
     * objCustomerDao The database layer object variable for CustomerDao object
     */
    private CustomerDao objCustomerDao;
    //This object name 'objCustomerDao' should be same as declared bean in 'beans.xml' for ranktracker.dao.CustomerDaoImpl class
    //then we have to generate getter and setter method for objPaymentDAO object.
    //by doing so, spring container initialize the objCustomerDao object.
    /**
     * objCampaignsDao The database layer object variable for CampaignsDao
     * object
     */
    private CampaignsDao objCampaignsDao;
    /**
     * objUtilityDataDao The database layer object variable for UtilityDataDao
     * object
     */
    private UtilityDataDao objUtilityDataDao;

    /**
     * The method retrieves user data and campaigns for a given user id
     *
     * @param userID
     * @return
     */
    @Override
    public Object[] getPageData(Integer userID) {

        Users objUser = objCustomerDao.getUserDetails(userID);

        //calling the getCampaigns method of CampaignsDaoImpl class
        List<Campaigns> lstCampaigns = objCampaignsDao.getCampaigns(objUser.getCustomerID().getCustomerID());

//        Showcolumns objShowColumn = objShowColumnsDao.getShowColumns(customerId);
//
//        List<Alertsettings> lstAlertsetting = objUtilityDataDao.getAlertSettings();
//
//        List<Reportfrequency> lstReportfrequency = objUtilityDataDao.getReportfrequency();
//
//        List< Timezones> lstTimezones = objUtilityDataDao.getTimezones();

        return new Object[]{objUser, lstCampaigns};
    }

    /**
     * The method updates timezone of a customer
     *
     * @param customerId
     * @param timezone
     */
    @Override
    public void updateTimezone(Integer customerId, Integer timezone) {

        //calling the updateTimezone method of CustomerDaoImpl class
        objCustomerDao.updateTimezone(customerId, timezone);
    }

    /**
     * The method updates password of a customer
     *
     * @param userID
     * @param oldPassword
     * @param newpassword
     * @return Users
     */
    @Override
    public Users updatePassword(Integer userID, String oldPassword, String newpassword) {

        //calling the updatePassword method of CustomerDaoImpl class
        return objCustomerDao.updatePassword(userID, oldPassword, newpassword);
    }

    /**
     * The method updates pdf options of a customer
     *
     * @param customerId
     * @param companyUrl
     * @param companyLogo
     * @param companyDesc
     */
    @Override
    public void updatePdfOptions(Integer campaignId, String companyName, String companyUrllink, String companyLogoLink) {

        //calling the updatePdfOptions method of CustomerDaoImpl class
        objCampaignsDao.updatePdfOptions(campaignId, companyName, companyUrllink, companyLogoLink);
    }

    /**
     * The method updates email settings for campaigns
     *
     * @param customerId
     * @param siteId
     * @param reportEmailId
     * @param frequency
     */
    @Override
    public void updateEmailSettings(Integer customerId, String[] siteId, String[] reportEmailId, String[] frequency) {

        //calling the updateEmailOptions method of CustomerDaoImpl class
        objCustomerDao.updateEmailOptions(customerId, siteId, reportEmailId, frequency);
    }

    /**
     * The method adds a new user to database
     *
     * @param email
     * @param password
     * @param userType
     * @param customerID
     */
    @Override
    public void addUser(String email, String password, Integer userType, Integer customerID) {

        //calling the addUser method of UtilityDataDaoImpl class
        objUtilityDataDao.addUser(email, password, userType, customerID);
    }

    /**
     * The method checks number of existing users for a customer
     *
     * @param customerID
     * @return int
     */
    @Override
    public Integer checkAddUserQuota(Integer customerID) {

        //calling the checkAddUserQuota method of UtilityDataDaoImpl class
        return objUtilityDataDao.checkAddUserQuota(customerID);
    }

    /**
     * The method to retrieve campaigns list by given customer id
     *
     * @param customerId
     * @return list of campaigns
     */
    @Override
    public List<Campaigns> getCampaigns(Integer customerID) {

        //calling the getCampaigns method of CampaignsDaoImpl class
        return objCampaignsDao.getCampaigns(customerID);
    }

    /**
     * The method retrieves reportfrequency data
     *
     * @return List<ReportFrequency>
     */
    @Override
    public List<Reportfrequency> getFrequency() {

        //calling the getFrequency method of UtilityDataDaoImpl class
        return objUtilityDataDao.getFrequency();
    }

    /**
     * The method retrieves user records for a given customer id
     *
     * @param customerID
     * @param userID
     * @return List
     */
    @Override
    public Object[] getUserDetails(Integer customerID, Integer userID) {

        //calling the getUsers method of UtilityDataDaoImpl class
        return new Object[]{objUtilityDataDao.getUsers(customerID, userID),objUtilityDataDao.getUserType(customerID,userID)};
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
     * @return objUtilityDataDao
     */
    public UtilityDataDao getObjUtilityDataDao() {
        return objUtilityDataDao;
    }

    /**
     *
     * @param objUtilityDataDao
     */
    public void setObjUtilityDataDao(UtilityDataDao objUtilityDataDao) {
        this.objUtilityDataDao = objUtilityDataDao;
    }

    /**
     * The method sets next mail sending date for a campaign
     *
     * @param objSite
     */
    @Override
    public void updateNextMailSendDate(Campaigns objSite) {
        objCustomerDao.updateNextMailSendDate(objSite);
    }

    @Override
    public Site getSiteData(String host) {
        return objCustomerDao.getSiteData(host);
    }

    /**
     * This method adds the settings to database by calling addSettingsStore in
     * UtilityDataDaoImpl
     *
     * @param tabsettings
     * @return
     */
    @Override
    public Integer addSettings(Map tabsettings) {
        return objUtilityDataDao.addSettingsStore(tabsettings);
    }

    /**
     *
     * @param customerID
     * @return 
     */
    @Override
    public List<Displaysettings> showSettings(Integer customerID) {
        return objUtilityDataDao.showSettingUser(customerID);
    }

    @Override
    public Campaigns pdfUpdateReport(Integer customerID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
