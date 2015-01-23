/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.dao.PaymentDAO;
import ranktracker.dao.PaymentDAOImpl;
import ranktracker.entity.Customers;
import ranktracker.entity.Users;
import ranktracker.form.SignInForm;
import ranktracker.service.CustomerService;

/**
 * Action layer class for actions initiated for signin module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class SignInSubmitAction extends ActionSupport implements ModelDriven<SignInForm> {

    /**
     * objSignInForm The SignInForm object containing user's sign in credentials
     */
    private SignInForm objSignInForm;
    /**
     * objCustomerService The service layer object variable for CustomerService
     * object
     */
    private CustomerService objCustomerService;
    /**
     * objHttpSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * objCustomer The Customers entity object
     */
    private Customers objCustomer;
    /**
     * objRequest The HttpSession object
     */
    private HttpServletRequest objRequest;
    /**
     * objUser The Users entity object
     */
    private Users objUser;

    private PaymentDAO objPaymentDAO;

    /**
     * The method validates login credentials
     *
     * @return struts return value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        int activationPeriod = 1;
        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //now invoking the isValidLogin method of CustomerServiceimpl class to validate the username and password
        objUser = objCustomerService.isValidLogin(objSignInForm.getUserName(), objSignInForm.getPassword());
        System.out.println("Username : " + objSignInForm.getUserName());
        System.out.println("Password : " + objSignInForm.getPassword());
        if (objUser != null) {
            int usertype = objUser.getUserType();
            if (usertype != 10) {

                objCustomer = objUser.getCustomerID();

                String paymentMessage = "welcome";

                try {

                    Date enddate = objPaymentDAO.getPaymentEndingDate(objCustomer.getCustomerID());

//              
                    Date currentDate = new Date();
                    //System.out.println("==== end date : " + enddate);

                    long diff = enddate.getTime() - currentDate.getTime();
                    diff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    //System.out.println("Difference is : " + diff);
                    if (diff > 0L) {

                        paymentMessage = "Only " + diff + " days left in activation period. Your Activation will end on " + enddate;
                    } else {
                        paymentMessage = "Your activation period has been expired on";
                        activationPeriod = 0;
                    }

                } catch (Exception es) {
                    System.out.println("EXCEPTION IS : " + es);
                    // objSession.setAttribute("paymentMessage","EXCEPTION IS : "+es);

                }

                objSession.setAttribute("notification", 0);
                objSession.setAttribute("paymentMessage", paymentMessage);
                objSession.setAttribute("activationPeriod", activationPeriod);

                objSession.setAttribute("customerID", objCustomer.getCustomerID());
                objSession.setAttribute("customerName", objCustomer.getFirstName() + " " + objCustomer.getLastName());
                objSession.setAttribute("userID", objUser.getUserID());
                objRequest.setAttribute("highlight", "Sites");
                objSession.setAttribute("allowedKeywordCount", objCustomer.getAllowedKeywordCount());
                objSession.setAttribute("allowedCampaignCount", objCustomer.getAllowedCampaignsCount());
                objSession.setAttribute("objCustomer", objCustomer);
                objSession.setAttribute("userType", objUser.getUserType());
                System.out.println("UserType : " + objSession.getAttribute("userType"));
                if (activationPeriod == 0) {
                    return "renewal";
                }
                return SUCCESS;
            } else {
                addActionError("Admin User should login through Admin panel");
            }
        } else {
            addActionError("Either EmailID or Password is Incorrect");
        }
        return INPUT;
    }

    public String executeLogin() throws Exception {

        int activationPeriod = 1;
        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //now invoking the isValidLogin method of CustomerServiceimpl class to validate the username and password
        objUser = objCustomerService.isValidLogin(objSignInForm.getUserName(), objSignInForm.getPassword());
        System.out.println("Username : " + objSignInForm.getUserName());
        System.out.println("Password : " + objSignInForm.getPassword());
        if (objUser != null) {
            int usertype = objUser.getUserType();
            if (usertype != 10) {

                objCustomer = objUser.getCustomerID();

                String paymentMessage = "welcome";

                try {

                    Date enddate = objPaymentDAO.getPaymentEndingDate(objCustomer.getCustomerID());

//              
                    Date currentDate = new Date();
                    //System.out.println("==== end date : " + enddate);

                    long diff = enddate.getTime() - currentDate.getTime();
                    diff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    //System.out.println("Difference is : " + diff);
                    if (diff > 0L) {

                        paymentMessage = "Only " + diff + " days left in activation period. Your Activation will end on " + enddate;
                    } else {
                        paymentMessage = "Your activation period has been expired on";
                        activationPeriod = 0;
                    }

                } catch (Exception es) {
                    System.out.println("EXCEPTION IS : " + es);
                    // objSession.setAttribute("paymentMessage","EXCEPTION IS : "+es);

                }

                objSession.setAttribute("notification", 0);
                objSession.setAttribute("paymentMessage", paymentMessage);
                objSession.setAttribute("activationPeriod", activationPeriod);

                objSession.setAttribute("customerID", objCustomer.getCustomerID());
                objSession.setAttribute("customerName", objCustomer.getFirstName() + " " + objCustomer.getLastName());
                objSession.setAttribute("userID", objUser.getUserID());
                objRequest.setAttribute("highlight", "Sites");
                objSession.setAttribute("allowedKeywordCount", objCustomer.getAllowedKeywordCount());
                objSession.setAttribute("allowedCampaignCount", objCustomer.getAllowedCampaignsCount());
                objSession.setAttribute("objCustomer", objCustomer);
                objSession.setAttribute("userType", objUser.getUserType());
                System.out.println("UserType : " + objSession.getAttribute("userType"));

                if (activationPeriod == 0) {
                    return "renewal";
                }

                return SUCCESS;
            } else {
                addActionError("Admin User should login through Admin panel");
            }
        } else {
            addActionError("Either EmailID or Password is Incorrect");
        }
        return INPUT;
    }

    public String executeRenewal() throws Exception {
        return SUCCESS;
    }

    public String adminLoginIn() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //now invoking the isValidLogin method of CustomerServiceimpl class to validate the username and password
        objUser = objCustomerService.isValidLogin(objSignInForm.getUserName(), objSignInForm.getPassword());
        if (objUser != null) {
            int usertype = objUser.getUserType();
            if (usertype == 5) {
                //if objUser is not null then add <customerID>,<customerName>,<userID> in session
                objCustomer = objUser.getCustomerID();
                objSession.setAttribute("AdminID", objCustomer.getCustomerID());
                objSession.setAttribute("customerName", objCustomer.getFirstName() + " " + objCustomer.getLastName());
                objSession.setAttribute("userID", objUser.getUserID());
                objRequest.setAttribute("highlight", "Sites");
                objSession.setAttribute("allowedKeywordCount", objCustomer.getAllowedKeywordCount());
                objSession.setAttribute("allowedCampaignCount", objCustomer.getAllowedCampaignsCount());
                objSession.setAttribute("objCustomer", objCustomer);
                objSession.setAttribute("userType", objUser.getUserType());
                return SUCCESS;
            } else {
                addActionError("Either EmailID or Password is Incorrect");
            }
        } else {
            addActionError("Either EmailID or Password is Incorrect");
        }
        return INPUT;
    }

    /**
     *
     * @return objSignInForm
     */
    public SignInForm getObjSignInForm() {
        return objSignInForm;
    }

    /**
     *
     * @param objSignInForm
     */
    public void setObjSignInForm(SignInForm objSignInForm) {
        this.objSignInForm = objSignInForm;
    }

    /**
     * The method validates the form inputs
     */
    @Override
    public void validate() {
        if (objSignInForm.getUserName() == null || objSignInForm.getUserName().isEmpty() || objSignInForm.getUserName().equals("Email")) {
            addActionError("EmailID is Required");
        }
        if (objSignInForm.getUserName() == null || objSignInForm.getPassword().isEmpty() || objSignInForm.getPassword().equals("Password")) {
            addActionError("Password is Required");
        }
    }

    /**
     *
     * @return objSignInForm
     */
    @Override
    public SignInForm getModel() {
        return objSignInForm;
    }

    /**
     *
     * @return objCustomerService
     */
    public CustomerService getObjCustomerService() {
        return objCustomerService;
    }

    /**
     *
     * @param objCustomerService
     */
    public void setObjCustomerService(CustomerService objCustomerService) {
        this.objCustomerService = objCustomerService;
    }

    public PaymentDAO getObjPaymentDAO() {
        return objPaymentDAO;
    }

    public void setObjPaymentDAO(PaymentDAO objPaymentDAO) {
        this.objPaymentDAO = objPaymentDAO;
    }
}
