/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.dao.UtilityDataDao;
import ranktracker.entity.Account;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Displaysettings;
import ranktracker.entity.Users;
import ranktracker.form.SettingsForm;
import ranktracker.mail.SendMail;
import ranktracker.service.CustomerService;
import ranktracker.service.SettingsService;

/**
 * Action layer class for actions initiated for settings module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class SettingsAction extends ActionSupport {

    /**
     * objSettingsService The service layer object variable for SettingsService
     * object
     */
    private SettingsService objSettingsService;
    /**
     * objUtilityDataDao The UtilityDataDao object
     */
    private UtilityDataDao objUtilityDataDao;
    /**
     * objSettingsForm The SettingsForm object
     */
    private SettingsForm objSettingsForm;
    /**
     * objUserVO The Users view object
     */
    private Users objUserVO;
    /**
     * lstSiteVO The list containing Campaigns objects
     */
    private List<Campaigns> lstSiteVO;
    /**
     * customerId The Integer variable containing customer id
     */
    private Integer customerId;
    /**
     * objHttpSession The HttpSession object
     */
    private HttpSession objHttpSession;
    /**
     * objRequest The HttpSession object
     */
    private HttpServletRequest objRequest;
    /**
     * objCustomerService The service layer object variable for CustomerService
     * object
     */
    private CustomerService objCustomerService;
    /**
     * objSendMail The SendMail object
     */
    private SendMail objSendMail;
    /**
     * objUser The Users entity object
     */
    private Users objUser;
    /**
     * userId The Userid, this is different from customer id
     */
    private Integer userId;
    /**
     * message The ajax string variable to store action message
     */
    private String message;
    /**
     * lstUsers The list containing User objects
     */
    private List lstUsers;
    /**
     * account The Account object used to display information in my account
     * module
     */
    private Account account;
    /**
     *
     */
    private List<Displaysettings> lstDisplaysettings;
    /**
     * oldpassword object
     */
    private String oldpassword;
    /**
     * newpassword object
     */
    private String newpassword;
    /**
     * useremail object
     */
    private String useremail;
    /**
     * userpassword object
     */
    private String userpassword;
    private Integer userType;
    private String editUserId;
    private String editLoginId;
    private String editPassword;
    private String delUserId;

    /**
     * The method retrieves all customer related information
     *
     * @return struts return value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {

            if (objHttpSession.getAttribute("activationPeriod").toString().equals("0")) {
                return "renewal";
            }
            //reading the 'userID' from session and type casting it to integer
            userId = (Integer) objHttpSession.getAttribute("userID");
            Object[] dataObject = objSettingsService.getPageData(userId);
            objUserVO = (Users) dataObject[0];
            lstSiteVO = (List<Campaigns>) dataObject[1];
//            objShowColumnsVO = (Showcolumns) dataObject[2];
//            lstAlertsettingsVO = (List<Alertsettings>) dataObject[3];
//            lstReportfrequencyVO = (List<Reportfrequency>) dataObject[4];
//            lstTimezonesVO = (List<Timezones>) dataObject[5];

            ServletActionContext.getRequest().setAttribute("highlight", "SETTINGS");
            if (objHttpSession.getAttribute("message") != null) {
                addActionMessage(objHttpSession.getAttribute("message").toString());
                objHttpSession.removeAttribute("message");
            }
            customerId = Integer.parseInt(objHttpSession.getAttribute("customerID").toString());
            lstDisplaysettings = objSettingsService.showSettings(customerId);

            Object[] userObj = objSettingsService.getUserDetails((Integer) objHttpSession.getAttribute("customerID"), userId);
            lstUsers = (List) userObj[0];
            userType = (Integer) userObj[1];

            // objHttpSession.setAttribute("companyName",(String)objHttpSession.getAttribute("companyName"));
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method updates timezone of a customer
     *
     * @return struts return value
     */
    public String updateTimezone() {

        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {

            //reading the 'customerID' from session and type casting it to integer
            customerId = (Integer) objHttpSession.getAttribute("customerID");
            if (!objSettingsForm.getTimezone().isEmpty()) {

                //updating the time zone
                objSettingsService.updateTimezone(customerId, Integer.valueOf(objSettingsForm.getTimezone()));
            }
            addActionMessage("Timezone Updated Successfully");
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method updates password for a customer
     *
     * @return struts return value
     */
    public String changePassword() {
        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        if (getNewpassword().equals("") || getOldpassword().equals("")) {
            addActionError("Please Provide Password Details");
            return SUCCESS;
        } else {

            //checking for 'customerID' attribute in session
            if (objHttpSession.getAttribute("customerID") != null) {

                //reading the 'userID' from session and type casting it to integer
                userId = (Integer) objHttpSession.getAttribute("userID");
                if (!getNewpassword().isEmpty()) {
                    System.out.println("Old Password--------->" + getOldpassword());
                    System.out.println("New Password--------->" + getNewpassword());
                    System.out.println("New Password------>" + getNewpassword());
                    //updating the password
                    objUser = objSettingsService.updatePassword(userId, getOldpassword(), getNewpassword());
                }
                //objHttpSession.setAttribute("password", "");
                if (objUser == null) {
                    message = "Sorry You Provided Wrong Password";
                    objHttpSession.setAttribute("message", message);

                } else {

                    //sending mail on password change
                    objSendMail.execute(3, objUser,"");
                    message = "Successfully Updated your Password";
                    objHttpSession.setAttribute("message", message);

                }

                return SUCCESS;
            } else {

                //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
                //this result parameter is mapped in 'struts.xml'
                return SUCCESS;
            }
        }
    }

    /**
     * The method updates password for a admin
     *
     * @return struts return value
     */
    public String changeAdminPassword() {
        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        if (getNewpassword().equals("") || getOldpassword().equals("")) {
            addActionError("Please Provide Password Details");
            return SUCCESS;
        } else {

            //checking for 'customerID' attribute in session
            if (objHttpSession.getAttribute("AdminID") != null) {

                //reading the 'userID' from session and type casting it to integer
                userId = (Integer) objHttpSession.getAttribute("userID");
                if (!getNewpassword().isEmpty()) {
                    System.out.println("Old Password--------->" + getOldpassword());
                    System.out.println("New Password--------->" + getNewpassword());
                    //updating the password
                    objUser = objSettingsService.updatePassword(userId, getOldpassword(), getNewpassword());
                }
                //objHttpSession.setAttribute("password", "");
                if (objUser == null) {
                    message = "Sorry You Provided Wrong Password";
                    objHttpSession.setAttribute("message", message);
                } else {

                    //sending mail on password change
                    objSendMail.execute(3, objUser,"");
                    message = "Successfully Updated your Password";
                    objHttpSession.setAttribute("message", message);
                }
                return SUCCESS;
            } else {

                //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
                //this result parameter is mapped in 'struts.xml'
                return SUCCESS;
            }
        }
    }

    /**
     * The method updates email settings for campaigns
     *
     * @return struts return value
     */
    public String updateEmailSettings() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objHttpSession = objRequest.getSession();
        Map<String, String[]> mailSettingsDetail = objRequest.getParameterMap();
        String[] siteId = mailSettingsDetail.get("siteId");
        String[] reportEmailId = mailSettingsDetail.get("reportEmailId");
        String[] frequency = mailSettingsDetail.get("frequency");

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {

            //updating the email setting property
            objSettingsService.updateEmailSettings(customerId, siteId, reportEmailId, frequency);
            addActionMessage("Setting Save Successfully");
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }


    /*
     * This method stores the settings in database
     */
    public String tabSettings() {

        //initializing Request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objHttpSession = objRequest.getSession();

        if (objHttpSession.getAttribute("customerID") != null) {

            //Reading the customerId from session and typecasting it to Integer
            String sCustomerId = objHttpSession.getAttribute("customerID").toString();
            Integer customerID = Integer.parseInt(sCustomerId);
            System.out.println("customerID =================== " + customerID);
            try {
                // Setting all the changes in Map object
                Map tabsettings = new LinkedHashMap();
                tabsettings.put("customerID", customerID);
                int googletab = Integer.parseInt(objRequest.getParameter("googletab"));
                tabsettings.put("googletab", googletab);
                int bingtab = Integer.parseInt(objRequest.getParameter("bingtab"));
                tabsettings.put("bingtab", bingtab);
                int yahootab = Integer.parseInt(objRequest.getParameter("yahootab"));
                tabsettings.put("yahootab", yahootab);
                int daychange = Integer.parseInt(objRequest.getParameter("daychange"));
                tabsettings.put("daychange", daychange);
                int weektab = Integer.parseInt(objRequest.getParameter("weektab"));
                tabsettings.put("weektab", weektab);
                int monthtab = Integer.parseInt(objRequest.getParameter("monthtab"));
                tabsettings.put("monthtab", monthtab);
                int alexatab = Integer.parseInt(objRequest.getParameter("alexatab"));
                tabsettings.put("alexatab", alexatab);
                int backlinktab = Integer.parseInt(objRequest.getParameter("backlinktab"));
                tabsettings.put("backlinktab", backlinktab);
                int monthlysearch = Integer.parseInt(objRequest.getParameter("monthlysearch"));
                tabsettings.put("monthlysearch", monthlysearch);
                int serpcampaigntab = Integer.parseInt(objRequest.getParameter("serpcampaigntab"));
                tabsettings.put("serpcampaigntab", serpcampaigntab);
                int videocampaigntab = Integer.parseInt(objRequest.getParameter("videocampaigntab"));
                tabsettings.put("videocampaigntab", videocampaigntab);
                Integer result = objSettingsService.addSettings(tabsettings);
                System.out.println("result = " + result);
                objHttpSession.setAttribute("message", "Settings Changed Successfully");
                return SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return LOGIN;

    }

    /**
     * The method adds a new user to database
     *
     * @return struts return value
     */
    public String addUser() {
        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {

            //reading the 'userID' from session and type casting it to integer
            userId = (Integer) objHttpSession.getAttribute("userID");

            //reading the 'customerID' from session and type casting it to integer
            Integer customerID = (Integer) objHttpSession.getAttribute("customerID");

            //checking the add user quota
            Integer quota = objSettingsService.checkAddUserQuota(customerID);
            if (quota > 0) {
                String email = getUseremail();
                String password = getUserpassword();
                if (email.equals("") || password.equals("")) {
                    message = "Please Provide Email Id and Password";
                    addActionError(message);
                }
                boolean mailIdavailableStatus = objCustomerService.isEmailIDAvailable(email);
                if (mailIdavailableStatus == true) {
                    objSettingsService.addUser(email, password, 1, customerID);
                    message = "User Added";
                } else {
                    message = "Sorry Email Address already registered";
                }
            } else {
                message = "Sorry Your Quota for adding user has been Completed";
                addActionError(message);
            }
            objHttpSession.setAttribute("message", message);
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method updates the user details to database
     *
     * @return struts return value
     */
    public String updateUserDetails() {
        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {
            int isEmailAvail;
            isEmailAvail = objUtilityDataDao.updateUserInfo(Integer.parseInt(editUserId), editLoginId, editPassword);
            if (isEmailAvail == 1) {
                message = "User Details updated successfully";
                objHttpSession.setAttribute("message", message);
            } else {
                message = "Sorry Email Address already registered";
                objHttpSession.setAttribute("message", message);
            }
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method delete the user from database
     *
     * @return struts return value
     */
    public String deleteUser() {
        System.out.println("---------Delete---------");
        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objHttpSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {

            Integer customerID = (Integer) objHttpSession.getAttribute("customerID");
            objUtilityDataDao.deleteUserAccount(Integer.parseInt(delUserId), customerID);
            message = "User Account has been Deleted";
            objHttpSession.setAttribute("message", message);
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method retrieves client's account details
     *
     * @return struts return value
     */
    public String getAccountDetails() {

        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {

            if (objHttpSession.getAttribute("activationPeriod").toString().equals("0")) {
                return "renewal";
            }
            //reading the 'customerID' from session and type casting it to integer
            customerId = (Integer) objHttpSession.getAttribute("customerID");

            //retrieving the account details for 'customerId'
            account = objCustomerService.getAccountDetails(customerId);
            setAccount(account);
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String getAdminUserDetails() {

        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //reading the 'customerID' from session and type casting it to integer
        customerId = Integer.valueOf(objRequest.getParameter("customerID"));

        objHttpSession.setAttribute("custID", customerId);

        //retrieving the account details for 'customerId'
        account = objCustomerService.getAccountDetails(customerId);
        setAccount(account);
        return SUCCESS;

    }

    /**
     *
     * @return objSettingsService
     */
    public SettingsService getObjSettingsService() {
        return objSettingsService;
    }

    /**
     * The method validates the change password form inputs
     */
    @Override
    public void validate() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        try {
            if (objRequest.getParameter("email").equals("")) {
                message = "Email Id Required";
                addActionError(message);
            }
            if (objRequest.getParameter("password").equals("")) {
                message = "Password Required";
                addActionError(message);
            }
            if (!objRequest.getParameter("password").equals("")) {
                String emailId = objRequest.getParameter("email");
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(emailId);
                boolean matchFound = m.matches();
                if (!matchFound) {
                    message = "Please Provide Valid Email ID";
                    addActionError(message);
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     *
     * @param objSettingsService
     */
    public void setObjSettingsService(SettingsService objSettingsService) {
        this.objSettingsService = objSettingsService;
    }

    /**
     *
     * @return objUserVO
     */
    public Users getObjUserVO() {
        return objUserVO;
    }

    /**
     *
     * @param objUserVO
     */
    public void setObjUserVO(Users objUserVO) {
        this.objUserVO = objUserVO;
    }

    /**
     *
     * @return lstSiteVO
     */
    public List<Campaigns> getLstSiteVO() {
        return lstSiteVO;
    }

    /**
     *
     * @param lstSiteVO
     */
    public void setLstSiteVO(List<Campaigns> lstSiteVO) {
        this.lstSiteVO = lstSiteVO;
    }

    /**
     *
     * @param objSettingsForm
     */
    public void setObjSettingsForm(SettingsForm objSettingsForm) {
        this.objSettingsForm = objSettingsForm;
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

    /**
     *
     * @return objSendMail
     */
    public SendMail getObjSendMail() {
        return objSendMail;
    }

    /**
     *
     * @param objSendMail
     */
    public void setObjSendMail(SendMail objSendMail) {
        this.objSendMail = objSendMail;
    }

    /**
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return lstUsers
     */
    public List getLstUsers() {
        return lstUsers;
    }

    /**
     *
     * @param lstUsers
     */
    public void setLstUsers(List lstUsers) {
        this.lstUsers = lstUsers;
    }

    /**
     *
     * @return account
     */
    public Account getAccount() {
        return account;
    }

    /**
     *
     * @param account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Displaysettings> getLstDisplaysettings() {
        return lstDisplaysettings;
    }

    public void setLstDisplaysettings(List<Displaysettings> lstDisplaysettings) {
        this.lstDisplaysettings = lstDisplaysettings;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getEditUserId() {
        return editUserId;
    }

    public void setEditUserId(String editUserId) {
        this.editUserId = editUserId;
    }

    public String getEditLoginId() {
        return editLoginId;
    }

    public void setEditLoginId(String editLoginId) {
        this.editLoginId = editLoginId;
    }

    public String getEditPassword() {
        return editPassword;
    }

    public void setEditPassword(String editPassword) {
        this.editPassword = editPassword;
    }

    public UtilityDataDao getObjUtilityDataDao() {
        return objUtilityDataDao;
    }

    public void setObjUtilityDataDao(UtilityDataDao objUtilityDataDao) {
        this.objUtilityDataDao = objUtilityDataDao;
    }

    public String getDelUserId() {
        return delUserId;
    }

    public void setDelUserId(String delUserId) {
        this.delUserId = delUserId;
    }
}
