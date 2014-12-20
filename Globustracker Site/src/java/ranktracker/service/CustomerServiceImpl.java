/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import java.util.Queue;
import org.apache.log4j.Logger;
import ranktracker.dao.CustomerDao;
import ranktracker.dao.UtilityDataDao;
import ranktracker.entity.Account;
import ranktracker.entity.Alertsdata;
import ranktracker.entity.Customers;
import ranktracker.entity.Mailhistory;
import ranktracker.entity.Users;
import ranktracker.form.Alertsform;

/**
 * Service layer class for Customer Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class CustomerServiceImpl implements CustomerService {

    static Logger l = Logger.getLogger(CustomerServiceImpl.class.getName());
    /**
     * objCustomerDao The database layer object variable for CustomerDao object
     */
    private CustomerDao objCustomerDao;
    
    private UtilityDataDao objUtilityDataDao;

    /**
     * The method checks if an email id is present in the database
     *
     * @param emailID
     * @return boolean
     */
    @Override
    public boolean isEmailIDAvailable(String emailID) {
        
        //calling the isEmailIDAvailable method of CustomerDaoImpl class
        return objCustomerDao.isEmailIDAvailable(emailID);
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
     * The method validates login credentials of a user
     *
     * @param userName
     * @param password
     * @return Users
     */
    @Override
    public Users isValidLogin(String userName, String password) {
        
        //calling the isValidLogin method of CustomerDaoImpl class
        return objCustomerDao.isValidLogin(userName, password);
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
        
        //calling the saveCustomer method of CustomerDaoImpl class
        return objCustomerDao.saveCustomer(objCustomer, objUser);
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
        
        //calling the getAlerts method of CustomerDaoImpl class
        return objCustomerDao.getAlerts(customerId, date);
    }
     /**
     * The method gets alerts data for a customer for a given date
     *
     * @param customerId
     * @return Timezone
     */
    
    @Override
    public String getTimezoneID(Integer customerId) {
        
        //calling the getTimezoneID method of CustomerDaoImpl class
        return objCustomerDao.getTimezoneID(customerId);
    }

    /**
     * The method gets password for a given email-id
     *
     * @param emailId
     * @return Users
     */
    @Override
    public Users getPassword(String emailId) {
        
        //calling the getPassword method of CustomerDaoImpl class
        return objCustomerDao.getPassword(emailId);
    }

    /**
     * The method updates last mail sent record for a campaign
     *
     * @param mailhistory
     */
    @Override
    public void updateMailHistory(Mailhistory mailhistory) {
        
        //calling the updateMailHistory method of CustomerDaoImpl class
        objCustomerDao.updateMailHistory(mailhistory);
    }

    /**
     * The method retrieves customer object by given customer id
     *
     * @param customerId
     * @return Customers
     */
    @Override
    public Customers getCustomerDetails(Integer customerId) {
        
        //calling the getCustomerDetails method of CustomerDaoImpl class
        return objCustomerDao.getCustomerDetails(customerId);
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
        
        //calling the searchAlert method of CustomerDaoImpl class
        return objCustomerDao.searchAlert(customerID, campaign);
    }

    /**
     * The method gets account details for a given customer id
     *
     * @param customerId
     * @return Account
     */
    @Override
    public Account getAccountDetails(Integer customerId) {
        
        //calling the getAccountDetails method of CustomerDaoImpl class
        return objCustomerDao.getAccountDetails(customerId);
    }

    /**
     * This method returns the Users list
     * 
     * @return 
     */
    @Override
    public List<Users> getAllUsersList() {
        return objCustomerDao.getAllUsersList();
    }
    
    /**
     * This method edit the User details from admin
     * 
     * @return 
     */
     @Override
    public int editUser(String editUserId, String editLoginId,String editPassword,String editUserType) {
        return objCustomerDao.editUser(editUserId,  editLoginId,editPassword, editUserType);
    }
 
}
