/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.dao.CustomerDao;
import ranktracker.dao.PaymentDAO;
import ranktracker.entity.Customers;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;
import ranktracker.service.PaymentService;

/**
 * This class is used to activate the user (Simply setting the active value to 1
 * in Users table ) It also upgrade the user plans after the payments
 *
 * @author rinkesh jha
 */
public class AccountCreatedAction extends ActionSupport {

    // service layer variable for Payment service used to do payment related operations
    private PaymentService objPaymentService;
    //http session
    private HttpSession objSession;
    // variable for CustomerDao, used to do customer & user table related operations
    private CustomerDao objCustomerDao;
    // Used for storing the plans
    List<Plans> lstPlans;
    // variable for PaymentDao , used for payment related operations
    private PaymentDAO objPaymentDAO;

    /**
     * This method is used to activate & upgrade the plans of the customer This
     * method is applicable only when the user is registered under paid plans
     *
     * @return
     * @throws Exception
     * @author rinkesh jha
     */
    @Override
    public String execute() throws Exception {

        try {
            //getting the session object
            objSession = ServletActionContext.getRequest().getSession();

            // getting the result after account activation operation
            int result = objCustomerDao.confirmAccount(objSession.getAttribute("token").toString());

            System.out.println("result : " + result);

            // checking the result ,if its 0 then nothing will be update so, it will go to error page
            if (result == 0) {
                return "error";
            }

            //getting customer id from the session
            Integer customerId = Integer.parseInt(objSession.getAttribute("customerID").toString());
            //getting plan for the plan name (itemName)
            lstPlans = objPaymentDAO.getPlans(objSession.getAttribute("itemName").toString());

            System.out.println("customerId : " + customerId);
            System.out.println("lstPlans : " + lstPlans.get(0).getName());

            // creating the Payments table object for doing payments related operations
            Payments objPayment = new Payments();

            //setting the values in the Payment object
            objPayment.setBeginDate(new Date());
            //calculating the time gap for 30 days
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_YEAR, 30);

            objPayment.setAmount(lstPlans.get(0).getAmount());
            objPayment.setEndDate(calendar.getTime());
            objPayment.setPaymentDate(new Date());
            objPayment.setPlanID(lstPlans.get(0));
            objPayment.setPlan(objSession.getAttribute("itemName").toString());

            //creating Customers table object used to upgrade some fields of Customers table
            Customers objCustomers = new Customers();

            objCustomers.setAllowedUserCount(lstPlans.get(0).getUsers());
            objCustomers.setAllowedCampaignsCount(lstPlans.get(0).getCampaigns());
            objCustomers.setAllowedKeywordCount(lstPlans.get(0).getKeywords());

            // updating the Customers & Payments table a/c to that customerId
            objPaymentDAO.editPaymentDetails(objPayment, objCustomers, customerId);
            // deleting the session
            objSession.invalidate();
        } catch (Exception ex) {
            return "error";
        }
        return "success";

    }

    /**
     * This method is used to simple activate the user account using the token
     * It is used when the user chooses the free trial version at the time of
     * email confirmation
     *
     * @return
     * @throws Exception
     * @author rinkesh jha
     */
    public String activateFree() throws Exception {

        try {
            //getting the session object
            objSession = ServletActionContext.getRequest().getSession();

            // getting the result after account activation operation
            int result = objCustomerDao.confirmAccount(objSession.getAttribute("token").toString());

            System.out.println("result : " + result);

            // checking the result ,if its 0 then nothing will be update so, it will go to error page
            if (result == 0) {
                return "error";
            }

            objSession.invalidate();
        } catch (Exception ex) {
            return "error";
        }
        return "login";
    }

    public PaymentService getObjPaymentService() {
        return objPaymentService;
    }

    public void setObjPaymentService(PaymentService objPaymentService) {
        this.objPaymentService = objPaymentService;
    }

    public CustomerDao getObjCustomerDao() {
        return objCustomerDao;
    }

    public void setObjCustomerDao(CustomerDao objCustomerDao) {
        this.objCustomerDao = objCustomerDao;
    }

    public PaymentDAO getObjPaymentDAO() {
        return objPaymentDAO;
    }

    public void setObjPaymentDAO(PaymentDAO objPaymentDAO) {
        this.objPaymentDAO = objPaymentDAO;
    }

}
