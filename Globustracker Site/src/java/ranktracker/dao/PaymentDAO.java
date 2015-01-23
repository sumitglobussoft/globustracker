package ranktracker.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.util.List;
import ranktracker.entity.Customers;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;

/**
 * DAO layer interface for Payments Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public interface PaymentDAO {

    /**
     * The method saves a payment record
     *
     * @param payments
     * @return int
     */
    public int savePayment(Payments payments);

    /**
     * The method gets a plan object by given plan name
     *
     * @param planName
     * @return List<Plans>
     */
    public List<Plans> getPlans(String planName);
    /**
     * This method will return the date of ending the activation period
     * @param customerID
     * @return
     */

    public Date getPaymentEndingDate(Integer customerID);

    /**
     * This method is used to upgrade the plan for a particular customer
     * This Method makes changes in payments & customers table 
     * @param objPayments
     * @param objCustomers
     * @param customerId 
     */
    public void editPaymentDetails(Payments objPayments, Customers objCustomers, Integer customerId);
}
