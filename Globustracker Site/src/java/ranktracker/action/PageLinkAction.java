/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Site;
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

    public SettingsService getObjSettingsService() {
        return objSettingsService;
    }

    public void setObjSettingsService(SettingsService objSettingsService) {
        this.objSettingsService = objSettingsService;
    }
}
