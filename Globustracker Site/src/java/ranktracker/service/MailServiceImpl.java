/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;
import ranktracker.entity.MasterEmail;

/**
 * Service layer class for Mail Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class MailServiceImpl extends ActionSupport implements MailService {

    static Logger l = Logger.getLogger(MailServiceImpl.class.getName());

     /**
     * The method sends reminder password to customer
     *
     * @param emailId
     * @param password
     */
    @Override
    public void sendReminderPassword(String emailId, String password) {
        MimeMessage message = null;
        
        //reading the subject and content key from 'package.properties' file
        String subject = getText("subject");
        String content = getText("content");
        try {

            //creating the properties object
            Properties props = new Properties();
            
            //setting all the mail sending properties in property object
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", getText("smtp"));
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", 587);
            props.put("mail.smtp.socketFactory.port", 587);
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.quitwait", "false");

            //setting username and password for authentication
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            //getText("mailsender") : will read the 'mailsender' key from 'package.properties' file
                            return new PasswordAuthentication(getText("mailsender"), getText("mailpass"));
                        }
                    });
            
            message = new MimeMessage(session);
            message.setSender(new InternetAddress(getText("mailsender")));
            message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(emailId));
            message.setSubject(subject);
            //   message.setContent(mail_body, "text/plain");
            message.setContent(content + password, "text/html");
            // Part two is attachment
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Fill the message
            messageBodyPart.setText(content);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            multipart.addBodyPart(messageBodyPart);
            Transport.send(message);
            System.out.println("Message Send Successfully to : " + emailId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

     /**
     * The method retrieves mail settings by given mailer id
     *
     * @param mailerId
     * @return MasterEmail
     */
    @Override
    public MasterEmail getMasterEmailSettings(int mailerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
