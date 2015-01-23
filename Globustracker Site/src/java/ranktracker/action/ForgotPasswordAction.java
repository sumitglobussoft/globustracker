/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Users;
import ranktracker.mail.SendMail;
import ranktracker.service.CustomerService;
import ranktracker.service.MailService;

/**
 * Action layer class for actions initiated for forgot password module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class ForgotPasswordAction extends ActionSupport {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * emailId The email string received from front end
     */
    private String emailId;
    /**
     * objCustomerService The service layer object variable for CustomerService
     * object
     */
    private CustomerService objCustomerService;
    /**
     * objMailService The service layer object variable for MailService object
     */
    private MailService objMailService;
    /**
     * objSendMail The SendMail object
     */
    private SendMail objSendMail;
    /**
     * objUser The Users entity object
     */
    private Users objUser;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;

    /**
     * The method validates client supplied data and invokes mail module to send
     * forgot password mail
     *
     * @return struts return value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        
        //initializing http session object
        objSession = objRequest.getSession();
        if (objRequest.getParameter("mailId") != null) {
            
            //retrieving the 'mailId' parameter from request
            emailId = objRequest.getParameter("mailId").toString();
            
            //if it is empty then add action error
            if (emailId.equals("")) {
                addActionError("Please Provide an Email-Id");
            } else {
                
                //else retrieving the user object for <emailId>
                objUser = objCustomerService.getPassword(emailId);

                if (objUser != null) {
                    addActionMessage("Please Check Your Mail for Your Password.");
                    
                    //invoking the execute() method of SendMail class to send password details for <emailId>
                    objSendMail.execute(2, objUser,"");
                } else {
                    addActionError("This Email-Id does not Exist in our Records. Please Check if the Email Id You Entered is Correct.");
                }
            }
        }
        return super.execute();

    }

    /**
     * The method validates the form inputs
     */
    @Override
    public void validate() {
        
        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        if (objRequest.getParameter("mailId") != null) {
            emailId = objRequest.getParameter("mailId");
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(emailId);
            boolean matchFound = m.matches();
            if (!matchFound) {
                addActionError("Please Provide Valid Email ID");
            }
        } else {
            addActionError("Email ID is Required");
        }
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
     * @return objMailService
     */
    public MailService getObjMailService() {
        return objMailService;
    }

    /**
     *
     * @param objMailService
     */
    public void setObjMailService(MailService objMailService) {
        this.objMailService = objMailService;
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
}
