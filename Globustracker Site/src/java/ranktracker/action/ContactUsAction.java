/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.form.ContactUsForm;
import ranktracker.mail.SendMail;

/**
 * Action layer class for actions initiated for contact us module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class ContactUsAction extends ActionSupport implements ModelDriven<ContactUsForm> {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * objContactUsForm The ContactUsForm object
     */
    private ContactUsForm objContactUsForm;
    /**
     * objSendMail The SendMail object
     */
    private SendMail objSendMail;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;

    /**
     * The method invokes mail module to send customer feedback mail
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
        String name = objContactUsForm.getName();
        System.out.println(name);
        System.out.println(objContactUsForm.getCustType());
        System.out.println(objContactUsForm.getEmail());
        System.out.println(objContactUsForm.getMessage());
        //checking for 'customerID' attribute in session
        if (name != null) {
            objRequest.setAttribute("highlight", "CONTACT");

            //invoking the execute method of SendMail class to send the mail with the password details
            objSendMail.setMailContaint(objContactUsForm);
            addActionMessage("Your message has been submitted successfully we will contact you shortly");
            reset();
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method resets form fields in contacts us page
     *
     * @return struts return value
     * @throws Exception
     */
    public void reset() throws Exception {
        objContactUsForm.setName("");
        objContactUsForm.setEmail("");
        objContactUsForm.setCustType("");
        objContactUsForm.setMessage("");
    }

    /**
     * The method validates the form inputs
     */
    @Override
    public void validate() {
        boolean b = false;

        //retrieving the contact us form details from request object
        String firstName = objContactUsForm.getName().trim();
        String email = objContactUsForm.getEmail().trim();
        String message = objContactUsForm.getMessage().trim();

        //now validating each of the field
        if (firstName.isEmpty()) {
            addFieldError("name", getText("name.required"));
            b = true;
        }

        if (email.isEmpty()) {
            addFieldError("email", getText("email.required"));
            b = true;
        }
        if (!b) {
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(email);
            boolean matchFound = m.matches();
            if (!matchFound) {
                addFieldError("email", "Please Provide Valid Email ID");
            }
        }

        if (message.isEmpty()) {
            addFieldError("message", getText("message.required"));
            b = true;
        }

        if (!b) {
            boolean matches = message.matches("[<>!~@$%^&\"|!\\[#$]");
            if (matches) {
                addFieldError("message", "Please Provide Valid Message Name");
                b = true;
            }
        }
    }

    /**
     *
     * @return objRequest
     */
    public HttpServletRequest getObjRequest() {
        return objRequest;
    }

    /**
     *
     * @param objRequest
     */
    public void setObjRequest(HttpServletRequest objRequest) {
        this.objRequest = objRequest;
    }

    /**
     *
     * @return objContactUsForm
     */
    public ContactUsForm getObjContactUsForm() {
        return objContactUsForm;
    }

    /**
     *
     * @param objContactUsForm
     */
    public void setObjContactUsForm(ContactUsForm objContactUsForm) {
        this.objContactUsForm = objContactUsForm;
    }

    /**
     *
     * @return objContactUsForm
     */
    @Override
    public ContactUsForm getModel() {
        return objContactUsForm;
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
