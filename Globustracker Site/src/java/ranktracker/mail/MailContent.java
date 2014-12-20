/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.mail;

import org.apache.log4j.Logger;
import ranktracker.entity.Users;
import ranktracker.form.ContactUsForm;

/**
 * Content class for generating message content for mails
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class MailContent {

    static Logger l = Logger.getLogger(MailContent.class.getName());

    /**
     * The method creates mail content for sign up action
     *
     * @param objUser
     * @return String mailcontent
     */
    public static String getSignUpMailContent(Users objUser) {
        StringBuilder signup_html = new StringBuilder();
        try {
            signup_html.append("   ");
            signup_html.append("   ");
            signup_html.append("       <!--content starts-->");
            signup_html.append("       ");
            signup_html.append("         <div style=\"width:600px; height:auto; background:url(http://i47.tinypic.com/359bg8z.png); padding-bottom:1px;\">");
            signup_html.append("             ");
            signup_html.append("             <div style=\"width:545px; height:auto; font-family:Arial; font-size:14px; font-weight:bold; margin:0 auto; padding:20px 0; color:#000000;\">");
            signup_html.append("             ");
            signup_html.append("                Thank you for registering with Globustracker. <br />");
//            signup_html.append("                Your registered mail id is : ").append(objUser.getLoginId()).append("<br />");
            signup_html.append("                Your login id : ").append(objUser.getLoginID()).append("<br />");
            signup_html.append("                Your login password : ").append(objUser.getPassword()).append("");
            signup_html.append("             ");
            signup_html.append("             </div>");
            signup_html.append("             ");
            signup_html.append("             <div style=\"width:545px; height:auto; font-family:Arial; font-size:10px; font-weight:bold; margin:0 auto; padding:12px 0; color:#000000;\">");
            // signup_html.append("                NOTE :- Please update pasword after first login<br />");
            signup_html.append("             </div>");
            signup_html.append("       <!--content ends-->");
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return signup_html.toString();
    }

    /**
     * The method creates mail content for forgot password action
     *
     * @param objUser
     * @return String mailcontent
     */
    public static String getForgotPassContent(Users objUser) {
        StringBuilder forgotpass_html = new StringBuilder();
        try {
            forgotpass_html.append("   ");
            forgotpass_html.append("   ");
            forgotpass_html.append("       <!--content starts-->");
            forgotpass_html.append("       ");
            forgotpass_html.append("         <div style=\"width:600px; height:auto; background:url(http://i47.tinypic.com/359bg8z.png); padding-bottom:1px;\">");
            forgotpass_html.append("             ");
            forgotpass_html.append("             <div style=\"width:545px; height:auto; font-family:Arial; font-size:14px; font-weight:bold; margin:0 auto; padding:20px 0; color:#000000;\">");
            forgotpass_html.append("             ");
            forgotpass_html.append("                Your Globustracker Login Details <br />");
            forgotpass_html.append("                Your registered mail id is : ").append(objUser.getLoginID()).append("<br />");
            forgotpass_html.append("                Your login password : ").append(objUser.getPassword()).append("");
            forgotpass_html.append("             ");
            forgotpass_html.append("             </div>");
            forgotpass_html.append("             ");
            forgotpass_html.append("             <div style=\"width:545px; height:auto; font-family:Arial; font-size:10px; font-weight:bold; margin:0 auto; padding:12px 0; color:#000000;\">");
            // forgotpass_html.append("                NOTE :- Please update pasword after first login<br />");
            forgotpass_html.append("             </div>");
            forgotpass_html.append("       <!--content ends-->");
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return forgotpass_html.toString();
    }

    /**
     * The method creates mail content for change password action
     *
     * @param objUser
     * @return String mailcontent
     */
    public static String getChangePassContent(Users objUser) {
        StringBuilder changepass_html = new StringBuilder();
        try {
            changepass_html.append("   ");
            changepass_html.append("   ");
            changepass_html.append("       <!--content starts-->");
            changepass_html.append("       ");
            changepass_html.append("         <div style=\"width:600px; height:auto; background:url(http://i47.tinypic.com/359bg8z.png); padding-bottom:1px;\">");
            changepass_html.append("             ");
            changepass_html.append("             <div style=\"width:545px; height:auto; font-family:Arial; font-size:14px; font-weight:bold; margin:0 auto; padding:20px 0; color:#000000;\">");
            changepass_html.append("             ");
            changepass_html.append("                Your Globustracker Password has successfully changed <br />");
            changepass_html.append("                Your registered mail id is : ").append(objUser.getLoginID()).append("<br />");
            changepass_html.append("                Your login password : ").append(objUser.getPassword()).append("");
            changepass_html.append("             ");
            changepass_html.append("             </div>");
            changepass_html.append("             ");
            changepass_html.append("             <div style=\"width:545px; height:auto; font-family:Arial; font-size:10px; font-weight:bold; margin:0 auto; padding:12px 0; color:#000000;\">");
            // changepass_html.append("                NOTE :- Please update pasword after first login<br />");
            changepass_html.append("             </div>");
            changepass_html.append("       <!--content ends-->");
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return changepass_html.toString();
    }

    /**
     * The method creates mail content for contact us action
     *
     * @param contactUsForm
     * @return String mailcontent
     */
    public static String getContactUsContent(ContactUsForm contactUsForm) {
        StringBuilder contactus_html = new StringBuilder();
        try {
            contactus_html.append("   ");
            contactus_html.append("   ");
            contactus_html.append("       <!--content starts-->");
            contactus_html.append("       ");
            contactus_html.append("         <div style=\"width:600px; height:auto; background:url(http://i47.tinypic.com/359bg8z.png); padding-bottom:1px;\">");
            contactus_html.append("             ");
            contactus_html.append("             <div style=\"width:545px; height:auto; font-family:Arial; font-size:14px; font-weight:bold; margin:0 auto; padding:20px 0; color:#000000;\">");
            contactus_html.append("             ");
            contactus_html.append("                Customer's Feedback. <br /><br />");
            contactus_html.append("                Name : ").append(contactUsForm.getName().trim()).append("<br />");
            contactus_html.append("                E-Mail Address : ").append(contactUsForm.getEmail().trim()).append("<br />");
            contactus_html.append("                Member : ").append(contactUsForm.getCustType().trim()).append("<br />");
            contactus_html.append("                Message : ").append(contactUsForm.getMessage().trim()).append("");
            contactus_html.append("             ");
            contactus_html.append("             </div>");
            contactus_html.append("             ");
            contactus_html.append("       <!--content ends-->");
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return contactus_html.toString();
    }
}
