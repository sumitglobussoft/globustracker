package ranktracker.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import ranktracker.entity.Account;
import ranktracker.entity.Alertsdata;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Customers;
import ranktracker.entity.Mailhistory;
import ranktracker.entity.Site;
import ranktracker.entity.Users;
import ranktracker.form.Alertsform;

/**
 * DAO layer interface for Customer Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public interface CustomerDao {

    /**
     * The method checks if an email id is present in the database
     *
     * @param emailID
     * @return boolean
     */
    public boolean isEmailIDAvailable(String emailID);

    /**
     * The method retrieves customer object by given customer id
     *
     * @param customerId
     * @return Customers
     */
    public Customers getCustomerDetails(Integer customerId);

    /**
     * The method updates timezone of a customer
     *
     * @param customerId
     * @param timezone
     */
    public void updateTimezone(Integer customerId, Integer timezone);

    /**
     * The method updates password of a customer
     *
     * @param userID
     * @param oldPassword
     * @param newpassword
     * @return Users
     */
    public Users updatePassword(Integer userID, String oldPassword, String newpassword);

    /**
     * The method updates email settings for campaigns
     *
     * @param customerId
     * @param siteId
     * @param reportEmailId
     * @param frequency
     */
    public void updateEmailOptions(Integer customerId, String[] siteId, String[] reportEmailId, String[] frequency);

    /**
     * The method validates login credentials of a user
     *
     * @param userName
     * @param password
     * @return Users
     */
    public Users isValidLogin(String userName, String password);

    /**
     * The method saves a new customer record to database
     *
     * @param objCustomer
     * @param objUser
     * @return Customers
     */
    public Customers saveCustomer(Customers objCustomer, Users objUser);

    /**
     * The method gets alerts data for a customer for a given date
     *
     * @param customerId
     * @param date
     * @return List<Alertsdata>
     */
    public List<Alertsform> getAlerts(Integer customerId, java.util.Date date);

    /**
     * The method gets alerts data for a customer for a given date
     *
     * @param customerId
     * @param date
     * @return List<Alertsdata>
     */
    public String getTimezoneID(Integer customerId);

    /**
     * The method gets password for a given email-id
     *
     * @param emailId
     * @return Users
     */
    public Users getPassword(String emailId);

    /**
     * The method updates last mail sent record for a campaign
     *
     * @param mailhistory
     */
    public void updateMailHistory(Mailhistory mailhistory);

    /**
     * The method sets next mail sending date for a campaign
     *
     * @param objSite
     */
    public void updateNextMailSendDate(Campaigns objSite);

    /**
     * The method retrieves a user details by given userid
     *
     * @param userID
     * @return Users
     */
    public Users getUserDetails(Integer userID);
     /**
     * The method retrieves a user details by given token
     *
     * @param userID
     * @return Users
     */
    public Users getUserDetails(String token);

    /**
     * The method gets keywords count value for a customer
     *
     * @param customerId
     * @return List<Integer>
     */
    public List<Integer> getKeywordsCount(Integer customerId);

    /**
     * This method gets video keywords count value for a customer
     *
     * @param customerId
     * @return
     */
    public List<Integer> getVideoKeywordsCount(Integer customerId);

    /**
     * The method searches alerts data for a given customer id and campaign
     *
     * @param customerID
     * @param campaign
     * @return List<Alertsdata>
     */
    public List<Alertsdata> searchAlert(Integer customerID, String campaign);

    /**
     * The method gets account details for a given customer id
     *
     * @param customerId
     * @return Account
     */
    public Account getAccountDetails(Integer customerId);

    /**
     *
     * @param host
     * @return
     */
    public Site getSiteData(String host);

    /**
     *
     * @return
     */
    public List<Users> getAllUsersList();

    /**
     *
     * @return
     */
    public int editUser(String editUserId, String editLoginId, String editPassword, String editUserType);

    /**
     *
     * @return
     */
    public int activeUser(int customerId);

    /**
     *
     * @return
     */
    public int deactiveUser(int customerId);

    /**
     *
     * @return
     */
    public int updatePlan(int customerId, String plan, int planId, float amount, int campaign, int keyword, int user);

    // Below methods are for OAuth authentication
    
    public String encrypt(String message) throws Exception;

    public String decrypt(String encrypted) throws Exception;

    public String generateAccessToken(String username, String userid, String password, String referalcode);

    public byte[] hexToBinary(String hex);

    // byte[] to hex
    public String binaryToHex(byte[] ba);

    public String getHmacSha256(String str);
    
    //this method is for email confirmation & activation of the account
    
    public int confirmAccount(String token);

}
