/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.dao.CustomerDao;
import ranktracker.entity.Customers;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;
import ranktracker.entity.Site;
import ranktracker.entity.Users;
import ranktracker.service.PaymentService;
import ranktracker.service.SettingsService;

/**
 * Action layer class for actions initiated for page redirects to .jsp page
 * without interaction with business layer
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class PageLinkAction extends ActionSupport {

    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    private Site objSite;
    private SettingsService objSettingsService;
    private HttpServletResponse servletResponse;
    private CustomerDao objCustomerDao;
    /**
     * objPaymentService The service layer object variable for PaymentService
     * object
     */
    private PaymentService objPaymentService;

    /**
     * The redirect method for home.action
     *
     * @return
     */
    public String home() {
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();
        if (objSession.getAttribute("customerID") != null) {

            return SUCCESS;
        }
        return LOGIN;
    }

    /**
     * The redirect method for signIn.action
     *
     * @return
     */
    public String signIn() {

        //initializing http session object
        objSession = ServletActionContext.getRequest().getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            return LOGIN;
        } else {
            return SUCCESS;
        }
    }

    /**
     * The redirect method for signOut.action
     *
     * @return struts return value
     */
    public String signOut() {

        //initializing http session object
        objSession = ServletActionContext.getRequest().getSession();
        objSession.removeAttribute("customerID");
        objSession.removeAttribute("customerName");
        objSession.removeAttribute("userID");
        return SUCCESS;
    }

    /**
     * The redirect method for payment.action
     *
     * @return struts return value
     */
    public String payment() {
        return SUCCESS;
    }

    /**
     * The redirect method for signUp.action
     *
     * @return struts return value
     */
    public String signUp() {
        return SUCCESS;
    }

    /**
     * The redirect method for sitesList.action
     *
     * @return struts return value
     */
    public String sitesList() {
        return SUCCESS;
    }

    /**
     * The redirect method for siteDetail.action
     *
     * @return struts return value
     */
    public String siteDetail() {
        return SUCCESS;
    }

    /**
     * The redirect method for sitesAll.action
     *
     * @return struts return value
     */
    public String sitesAll() {
        return SUCCESS;
    }

    /**
     * The redirect method for signUpSubmit.action
     *
     * @return struts return value
     */
    public String signUpSubmit() {
        return SUCCESS;
    }

    /**
     * The redirect method for paymentInfoSubmit.action
     *
     * @return struts return value
     */
    public String paymentInfoSubmit() {
        return SUCCESS;
    }

    /**
     * The redirect method for signInSubmit.action
     *
     * @return struts return value
     */
    public String signInSubmit() {
        return SUCCESS;
    }

    /**
     * The redirect method for settings.action
     *
     * @return struts return value
     */
    public String settings() {
        return SUCCESS;
    }

    /**
     * The redirect method for chart.action
     *
     * @return struts return value
     */
    public String chart() {
        return SUCCESS;
    }

    /**
     * The redirect method for forgotPassword.action
     *
     * @return struts return value
     */
    public String forgotPassword() {
        return SUCCESS;
    }

    /**
     * The redirect method for services.action
     *
     * @return struts return value
     * @throws Exception
     */
    public String services() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        objRequest.setAttribute("highlight", "SERVICES");
        return SUCCESS;
    }

    /**
     * The redirect method for about.action
     *
     * @return struts return value
     * @throws Exception
     */
    public String about() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        objRequest.setAttribute("highlight", "ABOUT");
        return SUCCESS;
    }

    /**
     * The redirect method for features.action
     *
     * @return struts return value
     * @throws Exception
     */
    public String features() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        objRequest.setAttribute("highlight", "FEATURES");
        return SUCCESS;
    }

    public String privacy() throws Exception {

        return SUCCESS;
    }

    /**
     * The redirect method for pricing.action
     *
     * @return struts return value
     * @throws Exception
     */
    public String pricing() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        objRequest.setAttribute("highlight", "PRICING");
        return SUCCESS;
    }

    /**
     * The redirect method for tour.action
     *
     * @return struts return value
     * @throws Exception
     */
    public String tour() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        objRequest.setAttribute("highlight", "TOUR");
        return SUCCESS;
    }

    /**
     * This method shows the Frequently asked questions page
     *
     * @return
     * @throws Exception
     */
    public String faq() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        objRequest.setAttribute("highlight", "FAQ");
        return SUCCESS;
    }

    /**
     * The redirect method for contact.action
     *
     * @return struts return value
     * @throws Exception
     */
    public String contact() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        objRequest.setAttribute("highlight", "CONTACT");
        return SUCCESS;
    }

    /**
     * The redirect method for account.action
     *
     * @return struts return value
     * @throws Exception
     */
    public String account() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        objRequest.setAttribute("highlight", "ACCOUNT");
        return SUCCESS;
    }

    public String adminlogin() throws Exception {

        //initializing http request object
        System.out.println("*****************************************");
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();
        if (objSession.getAttribute("AdminID") != null) {

            return SUCCESS;
        }
        return LOGIN;
    }

    /**
     * This method is responsible for receiving the account activation request &
     * activate the account if the user is registered under freeBeeta. If the
     * user is registered in paid account then it sets the customer general
     * information in the session & redirect to accountoptions jsp page
     *
     * @return
     * @throws Exception
     * @author rinkesh jha
     */
    public String accountActivation() throws Exception {

        try {
            //getting request object
            objRequest = ServletActionContext.getRequest();
            //getting response object
            objSession = objRequest.getSession();

            //storing the token
            String token = objRequest.getParameter("token");
            //storing the itemName(plan name)
            String itemName = objRequest.getParameter("itemName");

            System.out.println("TOKEN RECIEVED : " + token);
            System.out.println("ITEM : " + itemName);

            // if token will be null then it will go to error page
            if (token == null) {
                return "error";
            } else if (itemName == null) {
                return "error";
            }

            // if the itemName is freebeeta then it simply activate that account & redirect to accountconfirmed jsp page
            if (itemName.equalsIgnoreCase("FreeBeta")) {
                // activating the account & getting the result
                int result = objCustomerDao.confirmAccount(token);

                System.out.println("result : " + result);

                // if the result is zero then nothing is updated , in that case it will go to erro page
                if (result == 0) {
                    return "error";
                }
                return SUCCESS;
            } else {
                // If the itemName is not freeBeeta then it sets some values in the session & redirects to accountoptions jsp page

                //setting some attributes in thesession
                objSession.setAttribute("itemName", itemName);
                objSession.setAttribute("token", token);

                // getting Users object using the token
                Users objUser = objCustomerDao.getUserDetails(token);
                // getting the Customers table object
                Customers objCustomers = objUser.getCustomerID();

                //setting customers general informations
                objSession.setAttribute("firstname", objCustomers.getFirstName());
                objSession.setAttribute("lastname", objCustomers.getLastName());
                objSession.setAttribute("customerID", objCustomers.getCustomerID());

                // redirecting to accountoptions jsp page
                return "CONTINUE";
            }

        } catch (Exception ex) {
            System.out.println("EXCEPTION IN CONFIRMATION : " + ex);
            return "error";
        }
    }

    public String seoIntelligence() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public SettingsService getObjSettingsService() {
        return objSettingsService;
    }

    public void setObjSettingsService(SettingsService objSettingsService) {
        this.objSettingsService = objSettingsService;
    }

    public CustomerDao getObjCustomerDao() {
        return objCustomerDao;
    }

    public void setObjCustomerDao(CustomerDao objCustomerDao) {
        this.objCustomerDao = objCustomerDao;
    }

    public PaymentService getObjPaymentService() {
        return objPaymentService;
    }

    public void setObjPaymentService(PaymentService objPaymentService) {
        this.objPaymentService = objPaymentService;
    }

}
