/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.LOGIN;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;
import ranktracker.dao.CustomerDao;
import ranktracker.entity.Customers;
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

    private Plans objPlansDetails;

    private List<Plans> objPlans;

    /**
     * The redirect method for home.action
     *
     * @return
     */
    public String home() {
        objRequest = ServletActionContext.getRequest();

        objSession = ServletActionContext.getRequest().getSession();

        objPlans = objPaymentService.getAllPlansDetails();

        objSession.setAttribute("listPlans", objPlans);

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

        objSession = ServletActionContext.getRequest().getSession();

        objPlans = objPaymentService.getAllPlansDetails();

        objSession.setAttribute("listPlans", objPlans);

        return SUCCESS;
    }

    /*
     *@Author Nitesh Shah
     *Date 6-SEP-2015
     *In this adminPanelFeaturesListDetails method we are getting the list of plan details from Plans table 
     *and returning success means it will redirect to package.jsp page
     */
    public String adminPanelFeaturesListDetails() {

        objSession = ServletActionContext.getRequest().getSession();

        try {
            if (objSession.getAttribute("AdminID") != null) {

                objPlans = objPaymentService.getAllPlansDetails();

                objSession.setAttribute("listPlans", objPlans);

            } else {
                return INPUT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    /*
     *@Author Nitesh Shah 
     *Date 6-SEP-2015
     *In this insertPackageDetails method we are getting the package details from package.jsp page
     *while creating the package, then we are creatiing JSON object and putting all the field details
     *in json, then we are inserting the package details in Plan table and returning json response in
     *package.jsp page. 
     */
    public void insertPackageDetails() throws IOException, JSONException {

        try {

            objSession = ServletActionContext.getRequest().getSession();

            objRequest = ServletActionContext.getRequest();

            servletResponse = ServletActionContext.getResponse();

            String Name = objRequest.getParameter("name").trim();
            int Amount = Integer.parseInt(objRequest.getParameter("amount").trim());
            int Campaigns = Integer.parseInt(objRequest.getParameter("campaigns").trim());
            int Keywords = Integer.parseInt(objRequest.getParameter("keywords").trim());
            int Users = Integer.parseInt(objRequest.getParameter("users").trim());
            int websiteReview = Integer.parseInt(objRequest.getParameter("websiteReview").trim());
            int keywordResearch = Integer.parseInt(objRequest.getParameter("keywordResearch").trim());
            int webmastertools = Integer.parseInt(objRequest.getParameter("webmastertools").trim());
            int googleAnalytics = Integer.parseInt(objRequest.getParameter("googleAnalytics").trim());
            int accurateLocalRanking = Integer.parseInt(objRequest.getParameter("accurateLocalRanking").trim());
            int linkAnalysis = Integer.parseInt(objRequest.getParameter("linkAnalysis").trim());

            JSONObject json = new JSONObject();

            json.put("Name", Name);
            json.put("Amount", Amount);
            json.put("Campaigns", Campaigns);
            json.put("Keywords", Keywords);
            json.put("Users", Users);
            json.put("websiteReview", websiteReview);
            json.put("keywordResearch", keywordResearch);
            json.put("webmastertools", webmastertools);
            json.put("googleAnalytics", googleAnalytics);
            json.put("accurateLocalRanking", accurateLocalRanking);
            json.put("linkAnalysis", linkAnalysis);

            objPlansDetails = new Plans();
            objPlansDetails.setName(Name);
            objPlansDetails.setAmount(Amount);
            objPlansDetails.setCurrency("USD");
            objPlansDetails.setCampaigns(Campaigns);
            objPlansDetails.setKeywords(Keywords);
            objPlansDetails.setUsers(Users);
            objPlansDetails.setGoogleAnalytics(googleAnalytics);
            objPlansDetails.setKeywordResearch(keywordResearch);
            objPlansDetails.setWebmastertools(webmastertools);
            objPlansDetails.setWebsiteReview(websiteReview);
            objPlansDetails.setAccurateLocalRanking(accurateLocalRanking);
            objPlansDetails.setLinkAnalysis(linkAnalysis);

            objPaymentService.insertPlansDetails(objPlansDetails);

            System.out.println("Plan ID : " + objPlansDetails.getPlanID());

            Integer planid = objPlansDetails.getPlanID();
            json.put("PlanID", planid);

            servletResponse.setContentType("text");
            servletResponse.setHeader("Cache-Control", "no-cache");
            servletResponse.getWriter().write(json.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     *@Author Nitesh Shah 
     *Date 6-SEP-2015
     *In this updateFeatureDetails method we are getting the particular plan deatils form package.jsp page
     *then updating the plan details in Plan table
     */
    public void updateFeatureDetails() throws IOException {

        objSession = ServletActionContext.getRequest().getSession();

        objRequest = ServletActionContext.getRequest();

        servletResponse = ServletActionContext.getResponse();
        try {
            int planID = Integer.parseInt(objRequest.getParameter("planID"));
            String Name = objRequest.getParameter("name").trim();
            int Amount = Integer.parseInt(objRequest.getParameter("amount").trim());
            int Campaigns = Integer.parseInt(objRequest.getParameter("campaigns").trim());
            int Keywords = Integer.parseInt(objRequest.getParameter("keywords").trim());
            int Users = Integer.parseInt(objRequest.getParameter("users").trim());
            int websiteReview = Integer.parseInt(objRequest.getParameter("websiteReview").trim());
            int keywordResearch = Integer.parseInt(objRequest.getParameter("keywordResearch").trim());
            int webmastertools = Integer.parseInt(objRequest.getParameter("webmastertools").trim());
            int googleAnalytics = Integer.parseInt(objRequest.getParameter("googleAnalytics").trim());
            int accurateLocalRanking = Integer.parseInt(objRequest.getParameter("accurateLocalRanking").trim());
            int linkAnalysis = Integer.parseInt(objRequest.getParameter("linkAnalysis").trim());

            objPlansDetails = new Plans();
            objPlansDetails.setPlanID(planID);
            objPlansDetails.setName(Name);
            objPlansDetails.setAmount(Amount);
            objPlansDetails.setCurrency("USD");
            objPlansDetails.setCampaigns(Campaigns);
            objPlansDetails.setKeywords(Keywords);
            objPlansDetails.setUsers(Users);
            objPlansDetails.setGoogleAnalytics(googleAnalytics);
            objPlansDetails.setKeywordResearch(keywordResearch);
            objPlansDetails.setWebmastertools(webmastertools);
            objPlansDetails.setWebsiteReview(websiteReview);
            objPlansDetails.setAccurateLocalRanking(accurateLocalRanking);
            objPlansDetails.setLinkAnalysis(linkAnalysis);

            objPaymentService.updatePlansDetails(objPlansDetails);

        } catch (Exception e) {
            e.printStackTrace();
        }
        servletResponse.setContentType("text");
        servletResponse.setHeader("Cache-Control", "no-cache");
        servletResponse.getWriter().write("Nitesh Shah");
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

    public String youtubechecker() {

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

   public String keywordResearch() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if keywd equal to 1 then it will show the keywordResearch features otherwise it will
            //return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int keywd = userPlanObj.getKeywordResearch();

            if (keywd == 1) {

                return SUCCESS;

            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String pageSpeedAnalysis() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if pageSpeedAnalysis equal to 1 then it will show the pageSpeedAnalysis features
            //of webmaster tool otherwise it will return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int pageSpeedAnalysis = userPlanObj.getWebmastertools();

            if (pageSpeedAnalysis == 1) {

                return SUCCESS;

            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String getStructureData() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if structureData equal to 1 then it will show the StructureData features
            //of webmaster tool otherwise it will return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int structureData = userPlanObj.getWebmastertools();

            if (structureData == 1) {

                return SUCCESS;

            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String mobileUsability() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if mobileUsability equal to 1 then it will show the MobileUsability features
            //of webmaster tool return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int mobileUsability = userPlanObj.getWebmastertools();

            if (mobileUsability == 1) {

                return SUCCESS;

            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String getAccurateLocalRankingPage() {
        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if accurateLocalRank equal to 1 then it will show the AccurateLocalRanking features otherwise  
            //it will return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int accurateLocalRank = userPlanObj.getAccurateLocalRanking();

            if (accurateLocalRank == 1) {

                return SUCCESS;
            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String getRobotsChecker() {
        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if robotsChecker equal to 1 then it will show the RobotsChecker features
            //of webmaster tool otherwise it will return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int robotsChecker = userPlanObj.getWebmastertools();

            if (robotsChecker == 1) {

                return SUCCESS;
            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String getLinkAnalysis() {
        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if linkAnalysis equal to 1 then it will show the LinkAnalysis features otherwise it will
            //return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int linkAnalysis = userPlanObj.getLinkAnalysis();

            if (linkAnalysis == 1) {

                return SUCCESS;
            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String googleAnalytics() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if googleAnalytics equal to 1 then it will show the googleAnalytics features otherwise it will
            //return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int googleAnalytics = userPlanObj.getGoogleAnalytics();

            if (googleAnalytics == 1) {

                return SUCCESS;

            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String googleAcquisition() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if googleAcquisition equal to 1 then it will show the google acquisition features 
            //of google analytics otherwise it will return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int googleAcquisition = userPlanObj.getGoogleAnalytics();

            if (googleAcquisition == 1) {

                return SUCCESS;

            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String googleBrowserMobile() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if googleBrowserMobile equal to 1 then it will show the google browser mobile features
            //of google analytics otherwise it will return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int googleBrowserMobile = userPlanObj.getGoogleAnalytics();

            if (googleBrowserMobile == 1) {

                return SUCCESS;

            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String googleSiteSpeed() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if googleSiteSpeed equal to 1 then it will show the google site speed features
            //of google analytics otherwise it will return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int googleSiteSpeed = userPlanObj.getGoogleAnalytics();

            if (googleSiteSpeed == 1) {

                return SUCCESS;

            } else {
                return "failure";
            }
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String googleAdwords() {

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

    public String googleSocials() {

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

    public String searchanalytics() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //Making plans table object then i am getting the customerID of particular User and checking in the plans table 
            //on the basis of plans then if searchAnalytics equal to 1 then it will show the searchanalytics features 
            //of webmaster tools otherwise it will return failure and redirect to upgrade.jsp page
            Plans userPlanObj = objPaymentService.getCustomerPlanID((int) objSession.getAttribute("customerID"));

            int searchAnalytics = userPlanObj.getWebmastertools();

            if (searchAnalytics == 1) {

                return SUCCESS;

            } else {
                return "failure";
            }
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
