package ranktracker.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ranktracker.entity.Account;
import ranktracker.entity.Alertsdata;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Customers;
import ranktracker.entity.Mailhistory;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;
import ranktracker.entity.Site;
import ranktracker.entity.Users;
import ranktracker.form.Alertsform;

/**
 * DAO layer class for Customer Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

    static Logger l = Logger.getLogger(CustomerDaoImpl.class.getName());

    /**
     * The method checks if an email id is present in the database
     *
     * @param emailID
     * @return boolean
     */
    @Override
    public boolean isEmailIDAvailable(String emailID) {

        //forming the <hqlQuery> to retrieve <Users> object having 'loginID' as 'emailID'
        String hqlQuery = "From Users where loginID=:emailID";

        //creating the query object for <hqlQuery>
        Query objQuery = getSession().createQuery(hqlQuery);

        //setting the parameter for 'emailID'
        //parameter are the where clauses
        objQuery.setParameter("emailID", emailID);
        List<Users> lstUsers = objQuery.list();

        //if user email id already available then return false ,else return true
        if (!lstUsers.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * The method saves a new customer record to database
     *
     * @param objCustomer
     * @param objUser
     * @return Customers
     */
    @Override
    public Customers saveCustomer(Customers objCustomer, Users objUser) {

        //calling the getSession() method to save the customer object
        getSession().persist(objCustomer);

        //now saving the <objCustomer> in <objUser> object
        objUser.setCustomerID(objCustomer);

        //calling the getSession() method to save the User object
        getSession().persist(objUser);
        return objCustomer;
    }

    /**
     * The method gets password for a given email-id
     *
     * @param emailId
     * @return Users
     */
    @Override
    public Users getPassword(String emailId) {

        //forming the <hqlQuery> to retrieve <Users> object having 'loginID' as 'emailID'
        String hqlQuery = "From Users where loginID=:emailID";

        //creating the query object for <hqlQuery>
        Query objQuery = getSession().createQuery(hqlQuery);

        //setting the parameter for 'emailID'
        //parameter are the where clauses
        objQuery.setParameter("emailID", emailId);
        List<Users> lstUsers = objQuery.list();

        //if user exist then return that User object ,else return null
        if (lstUsers.isEmpty()) {
            return null;
        } else {
            return lstUsers.get(0);
        }
    }

    /**
     * The method validates login credentials of a user
     *
     * @param userName
     * @param password
     * @return Users
     */
    @Override
    public Users isValidLogin(String userName, String password) {

        //calling the getSession() to create Criteria for Users class and instantiating objCriteria object 
        Criteria objCriteria = getSession().createCriteria(Users.class);

        //adding the Restrictions for <loginId> and <password>
        //Restrictions are where clauses
        objCriteria.add(Restrictions.eq("loginID", userName));
        objCriteria.add(Restrictions.eq("password", password));
        objCriteria.add(Restrictions.eq("active", 1));

        //retrieving the Users object, if exist
        //else return null
        List<Users> lstUsers = objCriteria.list();
        if (lstUsers.isEmpty()) {
            return null;
        }
        return lstUsers.get(0);
    }

    /**
     * The method retrieves customer object by given customer id
     *
     * @param customerId
     * @return Customers
     */
    @Override
    public Customers getCustomerDetails(Integer customerId) {

        //calling the getSession() to get the <objCustomer> object for <customerId>
        Customers objCustomer = (Customers) getSession().get(Customers.class, customerId);

        //returning the customer object
        return objCustomer;
    }

    /**
     * The method retrieves a user details by given userid
     *
     * @param userID
     * @return Users
     */
    @Override
    public Users getUserDetails(Integer userID) {

        //calling the getSession() to get the <objUser> object for <userID>
        Users objUser = (Users) getSession().get(Users.class, userID);

        //returning the user object
        return objUser;
    }
    
    /**
     * The method retrieves a user details by given token
     *
     * @param token
     * @return Users
     */
    @Override
    public Users getUserDetails(String token) {

         //calling the getSession() to create Criteria for Users class and instantiating objCriteria object 
        Criteria objCriteria = getSession().createCriteria(Users.class);

        //adding the Restrictions for <loginId> and <password>
        //Restrictions are where clauses
        objCriteria.add(Restrictions.eq("token", token));

        //retrieving the Users object, if exist
        //else return null
        List<Users> lstUsers = objCriteria.list();
        if (lstUsers.isEmpty()) {
            return null;
        }
        return lstUsers.get(0);
    }

    /**
     * The method updates timezone of a customer
     *
     * @param customerId
     * @param timezone
     */
    @Override
    public void updateTimezone(Integer customerId, Integer timezone) {
//        Timezones objTimezone = (Timezones) getSession().get(Timezones.class, timezone);
//        String timezoneValue = objTimezone.getTimezoneName().substring(4, 7);
//        Customers objCustomer = (Customers) getSession().get(Customers.class, customerId);
//        objCustomer.setTimezoneValue(timezone.toString());
//        objCustomer.setTimezoneValue(timezoneValue);
//        getSession().update(objCustomer);
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

        //calling the getSession() to create Criteria for Users class and instantiating objCriteria object 
        Criteria objCriteria = getSession().createCriteria(Users.class);

        //adding the Restrictions for <userId> and <password>
        //Restrictions are where clauses
        objCriteria.add(Restrictions.eq("userID", userID));
        objCriteria.add(Restrictions.eq("password", oldPassword));

        //retrieving the matched object
        List<Users> lstUser = objCriteria.list();
        if (!lstUser.isEmpty()) {

            //if user exist, then update the old password with new
            Users objUser = lstUser.get(0);
            try {
                objUser.setPassword(newpassword);
                getSession().update(objUser);
            } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
                l.error(ex + "  " + ex.getMessage());
            }
            return objUser;
        } else {
            return null;
        }
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
    public void updateEmailOptions(Integer customerId, String[] siteId, String[] reportEmailId, String[] frequency) {

        for (int i = 0; i < siteId.length; i++) {
            //iterating the loop for all campaigns

            //calling the getSession() and retrieving the Campaigns object for <siteId[i]>
            Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, Integer.parseInt(siteId[i]));
            try {

                //now invoking the setters methods of Campaigns class for reportEmailId[i],frequency[i]
                //date on which mail has to be send
                objCampaigns.setReportEmailID(reportEmailId[i]);
                objCampaigns.setReportFrequency(Integer.parseInt(frequency[i]));
//                Calendar origDay = Calendar.getInstance();
//                origDay.add(Calendar.DATE, objCampaigns.getReportFrequency());
                Calendar day = Calendar.getInstance();

                if (objCampaigns.getMailSentOn() == null) {
                    objCampaigns.setMailSentOn(day.getTime());
                } else {
                    day.add(Calendar.HOUR_OF_DAY, Integer.parseInt(frequency[i]));
                    objCampaigns.setMailSentOn(day.getTime());
                }
                //now calling the getSession() method and updating the objCampaigns object
                getSession().update(objCampaigns);
            } catch (Exception ex) {
                l.error(ex + "  " + ex.getMessage());
            }
        }
    }

    /**
     * The method gets alerts data for a customer for a given date
     *
     * @param customerId
     * @param date
     * @return List<Alertsdata>
     */
    @Override
    public List<Alertsform> getAlerts(Integer customerId, java.util.Date date) {

        //invoking the getSession() to createCriteria() for Alertsdata class
        Criteria objCriteria = getSession().createCriteria(Alertsdata.class);

        //now adding the Restrictions for <customerId>
        objCriteria.add(Restrictions.eq("customerID", new Customers(customerId)));

        if (date == null) {

            //if date is null then add the current date for trackDate
            objCriteria.add(Restrictions.eq("trackDate", new java.util.Date()));
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
            java.util.Date d2 = calendar.getTime();
            objCriteria.add(Restrictions.between("trackDate", date, d2));
        }
        objCriteria.addOrder(Order.desc("trackDate"));
        List<Alertsdata> lstTrack = objCriteria.list();
        List<Alertsform> lstAlerts = new ArrayList<>();
        Iterator itr = lstTrack.iterator();
        while (itr.hasNext()) {
            Alertsdata alertdata = (Alertsdata) itr.next();
            Alertsform alertsform = new Alertsform();
            alertsform.setAlertId(alertdata.getAlertID());
            alertsform.setCampaign(alertdata.getCampaign());
            alertsform.setCampaignId(alertdata.getCustomerID().getCampaignsCollection().iterator().next().getCampaignID());
            alertsform.setCurrentRank(alertdata.getCurrentRank());
            alertsform.setCustomerId(alertdata.getCustomerID().getCustomerID());
            alertsform.setEngine(alertdata.getEngine());
            alertsform.setKeyword(alertdata.getKeyword());
            alertsform.setPreviousRank(alertdata.getPreviousRank());
            alertsform.setResellerId(alertdata.getResellerId());
            alertsform.setTrackDate(alertdata.getTrackDate());
            alertsform.setUrl(alertdata.getUrl());
            lstAlerts.add(alertsform);
        }
        return lstAlerts;
    }

    /**
     * The method gets alerts data for a customer for a given date
     *
     * @param customerId
     * @param date
     * @return List<Alertsdata>
     */
    @Override
    public String getTimezoneID(Integer customerId) {
        String timezone_id = "";
        try {
            //invoking getSession() method to retrieve the Customers object for customerId
            Customers objCustomer = (Customers) getSession().get(Customers.class, customerId);

            timezone_id = objCustomer.getTimezoneID();
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
        }
        if (timezone_id == null) {
            timezone_id = "America/New_York";
        }
        return timezone_id;
    }

    /**
     * The method updates last mail sent record for a campaign
     *
     * @param mailhistory
     */
    @Override
    public void updateMailHistory(Mailhistory mailhistory) {

        //invoking getSession() method to save mailhistory object
        getHibernateTemplate().save(mailhistory);
    }

    /**
     * The method sets next mail sending time for a campaign
     *
     * @param objCampaign
     */
    @Override
    public void updateNextMailSendDate(Campaigns objCampaign) {

        Calendar cal = Calendar.getInstance();
        try {

            Campaigns campaigns = (Campaigns) getSession().get(Campaigns.class, objCampaign.getCampaignID());
            cal.add(Calendar.HOUR_OF_DAY, objCampaign.getReportFrequency());

            //updating the date to send next mail
            campaigns.setMailSentOn(cal.getTime());

            //invoking the getSession() method to update the objCampaign object
            getSession().update(campaigns);
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The method gets keywords count value for a customer
     *
     * @param customerId
     * @return List<Integer>
     */
    @Override
    public List<Integer> getKeywordsCount(Integer customerId) {
        //list of Integer
        List<Integer> lstKeywordData = new ArrayList<Integer>();

        try {
            //invoking getSession() method to retrieve the Customers object for customerId
            Customers objCustomer = (Customers) getSession().get(Customers.class, customerId);

            //adding the active keyword count from customer object to lstKeywordData object
            lstKeywordData.add(objCustomer.getActiveKeywordCount() + objCustomer.getActiveVideoKeywordCount());

            //adding the allowed keyword count from customer object to lstKeywordData object
            lstKeywordData.add(objCustomer.getAllowedKeywordCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //now returning lstKeywordData object
        return lstKeywordData;
    }

    /**
     * The method searches alerts data for a given customer id and campaign
     *
     * @param customerID
     * @param campaign
     * @return List<Alertsdata>
     */
    @Override
    public List<Alertsdata> searchAlert(Integer customerID, String campaign) {

        //invoking the getSession() to create Criteria for Alertsdata class
        Criteria objCriteria = getSession().createCriteria(Alertsdata.class);

        //adding Restrictions for <customerID>,<campaign>
        //adding restrictions for ordering of trackdate by descending
        //restrictions are where clauses
        objCriteria.add(Restrictions.eq("customerId", customerID));
        objCriteria.add(Restrictions.eq("campaign", "%" + campaign + "%"));
        objCriteria.addOrder(Order.desc("trackDate"));

        //now retrieving the list of Alertsdata object
        List<Alertsdata> lstTrack = objCriteria.list();

        //returning lstTrack object
        return lstTrack;
    }

    /**
     * The method gets account details for a given customer id
     *
     * @param customerId
     * @return Account
     */
    @Override
    public Account getAccountDetails(Integer customerId) {
        Account account = new Account();

        //invoking the getSession() method to create Criteria for Payments class
        Criteria objCriteria = getSession().createCriteria(Payments.class);
        try {

            //adding Restrictions for <customerId>
            objCriteria.add(Restrictions.eq("customerID.customerID", customerId));

            //now retrieving the list of payments object
            List<Payments> lstPayments = objCriteria.list();
            Payments objPayments = lstPayments.get(0);

            //retrieving the planid for <objPayments>
            Integer planId = objPayments.getPlanID().getPlanID();

            //retrieving Mailid for <objpayments>
            String mail = objPayments.getPayerID();

            //retrieving the customer object from <objPayments>
            Customers objCustomers = objPayments.getCustomerID();

            //retrieving firstname and lastname
            String name = objCustomers.getFirstName() + objCustomers.getLastName();

            //invoking the getSession() method to create Criteria for Plans class
            objCriteria = getSession().createCriteria(Plans.class);

            //adding Restrictions for <planId>
            objCriteria.add(Restrictions.eq("planID", planId));

            //retrieving the plan object from <objCriteria>
            Plans objPlans = (Plans) objCriteria.list().get(0);

            //initializing account object with all the required details
            account.setPlanName(objPlans.getName());
            account.setCampaignDetail((objCustomers.getActiveSerpCampaignsCount() + objCustomers.getActiveVideoCampaignCount()) + "/" + objCustomers.getAllowedCampaignsCount());
            account.setKeywordDetail(objCustomers.getActiveKeywordCount() + objCustomers.getActiveVideoKeywordCount() + "/" + objCustomers.getAllowedKeywordCount());
            account.setUserDetail(objCustomers.getActiveUserCount() + "/" + objCustomers.getAllowedUserCount());
            account.setMail(mail);
            account.setName(name);
        } catch (Exception e) {
            l.error(e + " " + e.getMessage());
        }
        return account;
    }

    @Override
    public Site getSiteData(String host) {

        //invoking the getSession() to create Criteria object for Site class
        Criteria objCriteria = getSession().createCriteria(Site.class);

        //adding Restrictions for <domain>
        objCriteria.add(Restrictions.eq("domain", host));

        //now retriving objSite
        List<Site> lstSite = objCriteria.list();
        Site objSite = lstSite.get(0);
        return objSite;
    }

    @Override
    public List<Integer> getVideoKeywordsCount(Integer customerId) {
        Customers objCustomer = (Customers) getSession().get(Customers.class, customerId);

        //list of Integer
        List<Integer> lstKeywordData = new ArrayList<Integer>();

        //adding the active keyword count from customer object to lstKeywordData object
        lstKeywordData.add(objCustomer.getActiveKeywordCount() + objCustomer.getActiveVideoKeywordCount());

        //adding the allowed keyword count from customer object to lstKeywordData object
        lstKeywordData.add(objCustomer.getAllowedKeywordCount());

        //now returning lstKeywordData object
        return lstKeywordData;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Users> getAllUsersList() {
        List list = null;
        try {
            list = getHibernateTemplate().find("from Users where userType = 0");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * @param editUserId
     * @param editLoginId
     * @param editPassword
     * @param editUserType
     * @return
     */
    @Override
    public int editUser(String editUserId, String editLoginId, String editPassword, String editUserType) {
        // Queue<Users> queueUsers = new LinkedList<>();
        int userid = Integer.parseInt(editUserId);
        int usertype = Integer.parseInt(editUserType);

        Users objUser = (Users) getSession().get(Users.class, userid);

        try {
            objUser.setLoginID(editLoginId);
            objUser.setPassword(editPassword);
            objUser.setUserType(usertype);
            getSession().update(objUser);

            //getSession().save(objCampaign);
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
            return 0;
        }
        return 1;
    }

    @Override
    public int activeUser(int customerId) {
        List<Users> lstUsers;

        //invoking the getSession() method to create Criteria for Seokeyworddetails class
        Criteria objCriteria = getSession().createCriteria(Users.class);

        //adding the Restrictions for <keywordID>
        objCriteria.add(Restrictions.eq("customerID.customerID", customerId));

        lstUsers = objCriteria.list();

        try {
            if (!lstUsers.isEmpty()) {
                String query = "update Users set active = 1 where customerID.customerID = ?";
                getHibernateTemplate().bulkUpdate(query, new Object[]{customerId});
            }

            //now invoking the getSession()
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deactiveUser(int customerId) {
        List<Users> lstUsers;

        //invoking the getSession() method to create Criteria for Seokeyworddetails class
        Criteria objCriteria = getSession().createCriteria(Users.class);

        //adding the Restrictions for <keywordID>
        objCriteria.add(Restrictions.eq("customerID.customerID", customerId));

        lstUsers = objCriteria.list();

        try {
            if (!lstUsers.isEmpty()) {
                String query = "update Users set active = 0 where customerID.customerID = ?";
                getHibernateTemplate().bulkUpdate(query, new Object[]{customerId});
            }

            //now invoking the getSession()
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            ex.printStackTrace();
        }
        return 1;
    }

    @Override
    public int updatePlan(int customerId, String plan, int planId, float amount, int campaign, int keyword, int user) {
        try {
            Plans objPlans = new Plans();
            objPlans.setPlanID(planId);
            String query1 = "update Payments set planID=?, amount=?, plan=? where customerID.customerID = ?";
            getHibernateTemplate().bulkUpdate(query1, new Object[]{objPlans, amount, plan, customerId});

            String query2 = "update Customers set allowedCampaignsCount=?, allowedKeywordCount=?, allowedUserCount=? where customerID = ?";
            getHibernateTemplate().bulkUpdate(query2, new Object[]{campaign, keyword, user, customerId});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int confirmAccount(String token) {
        List<Users> lstUsers;

        //invoking the getSession() method to create Criteria for Seokeyworddetails class
        Criteria objCriteria = getSession().createCriteria(Users.class);

        //adding the Restrictions for <keywordID>
        objCriteria.add(Restrictions.eq("token", token));

        lstUsers = objCriteria.list();

        try {
            if (!lstUsers.isEmpty()) {
                String query = "update Users set active = 1,token='' where token = ?";
                return getHibernateTemplate().bulkUpdate(query, new Object[]{token});
            }

            //now invoking the getSession()
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("EXCEPTION IN confirmAccount : " + ex);
            return 0;
        }
        return 0;
    }

   // Below methods are for OAuth authentication
    public String encrypt(String message) throws Exception {

        // use key coss2
        SecretKeySpec skeySpec = new SecretKeySpec("oauth2provider_1".getBytes("UTF-8"), "AES");

        // Instantiate the cipher
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] encrypted = cipher.doFinal(message.getBytes());
        return binaryToHex(encrypted);

    }

    public String decrypt(String encrypted) throws Exception {

        SecretKeySpec skeySpec = new SecretKeySpec("oauth2provider_1".getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] original = cipher.doFinal(hexToBinary(encrypted));
        String originalString = new String(original);
        return originalString;
    }

    public String generateAccessToken(String username, String userid, String password, String referalcode) {
        try {
            String prev = encrypt(username + "&" + userid);
            String next = getHmacSha256(password + "&" + referalcode);
            next = next.substring(0, 16);

            return prev + "_" + next;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] hexToBinary(String hex) {
        if (hex == null || hex.length() == 0) {
            return null;
        }

        byte[] ba = new byte[hex.length() / 2];
        for (int i = 0; i < ba.length; i++) {
            ba[i] = (byte) Integer
                    .parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return ba;
    }

    // byte[] to hex
    public String binaryToHex(byte[] ba) {
        if (ba == null || ba.length == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer(ba.length * 2);
        String hexNumber;
        for (int x = 0; x < ba.length; x++) {
            hexNumber = "0" + Integer.toHexString(0xff & ba[x]);

            sb.append(hexNumber.substring(hexNumber.length() - 2));
        }
        return sb.toString();
    }

    public String getHmacSha256(String str) {
        byte[] binary = null;
        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(str.getBytes("UTF-8"));
            binary = sh.digest();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return binaryToHex(binary);
    }

}
