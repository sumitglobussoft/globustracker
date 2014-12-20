/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import java.util.Queue;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ranktracker.entity.Account;
import ranktracker.entity.Alertsdata;
import ranktracker.entity.Customers;
import ranktracker.entity.Mailhistory;
import ranktracker.entity.Users;
import ranktracker.form.Alertsform;

/**
 * Service layer interface for Customer Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
@Transactional(readOnly = true)
public interface CustomerService {

    /**
     * The method checks if an email id is present in the database
     *
     * @param emailID
     * @return boolean
     */
    public boolean isEmailIDAvailable(String emailID);

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
    @Transactional(propagation = Propagation.REQUIRED)
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
     * @return Timezone
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
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateMailHistory(Mailhistory mailhistory);

    /**
     * The method retrieves customer object by given customer id
     *
     * @param customerId
     * @return Customers
     */
    public Customers getCustomerDetails(Integer customerId);

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
     * This method gets the users list
     *
     * @return
     */
    public List<Users> getAllUsersList();

    /**
     * This method edit the user details
     *
     * @return int
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int editUser(String editUserId, String editLoginId, String editPassword, String editUserType);
}
