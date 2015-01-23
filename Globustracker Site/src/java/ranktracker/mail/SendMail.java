/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.mail;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import ranktracker.action.ExcelReportAction;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Customers;
import ranktracker.entity.Mailhistory;
import ranktracker.entity.MasterEmail;
import ranktracker.entity.Seokeyworddetails;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Users;
import ranktracker.entity.Videokeywords;
import ranktracker.form.ContactUsForm;
import ranktracker.form.KeywordsLastUpdatedForm;
import ranktracker.service.CampaignsService;
import ranktracker.service.CustomerService;
import ranktracker.service.KeywordsService;
import ranktracker.service.SettingsService;

/**
 * Utility class to send emails
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class SendMail extends ActionSupport {

    static Logger l = Logger.getLogger(SendMail.class.getName());
    /**
     * emailType The email content is selected on emailType value
     */
    private int emailType;
    /**
     * objCustomerService The service layer object variable for CustomerService
     * object
     */
    private CustomerService objCustomerService;
    /**
     * objCampaignsService The service layer object variable for
     * CampaignsService
     */
    private CampaignsService objCampaignsService;
    /**
     * objKeywordsService The service layer object variable for KeywordsService
     * object
     */
    private KeywordsService objKeywordsService;
    /**
     * objExcelReportAction The action layer object variable for
     * ExcelReportAction object
     */
    private ExcelReportAction objExcelReportAction;
    /**
     * objKeywordsDao The database layer object variable for KeywordsDao object
     */
    private KeywordsDao objKeywordsDao;
    /**
     * fileName The Report file name
     */
    private String fileName = "SiteReport.xls";
    /**
     * objWorkbook The HSSFWorkbook object
     */
    private HSSFWorkbook objWorkbook = new HSSFWorkbook();
    /**
     * objSettingsService The service layer object variable for SettingsService
     * object
     */
    private SettingsService objSettingsService;
    /**
     * jString The Json string received from ajax call
     */
    private String jString;
    /**
     * objRequest The HttpSession object
     */
    private HttpServletRequest objRequest;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;
    private List<Videokeywords> lstvideokeywords;
    private List<KeywordsLastUpdatedForm> lstkeywordslastupdate;
    private List<KeywordsLastUpdatedForm> lstsocialsignalupdate;
    private List<Serpkeywords> lstUpdatedKeywords;
    private List<Seokeyworddetails> lstSeoDetails;

    /**
     *
     * @param mailType
     * @param objUser
     * @return
     */
    public String execute(int mailType, Users objUser,String itemName) {
        this.emailType = mailType;

        if (emailType > 0) {
            setMailContaint(objUser, emailType,itemName);
        }
        return SUCCESS;
    }

    /**
     * The method retrieves content for contacts us action and invokes
     * sendmail(params)
     *
     * @param objContactUsForm
     * @param emailType
     */
    public void setMailContaint(ContactUsForm objContactUsForm) {
        String complete_Email_Tags = "";
       // complete_Email_Tags = emailBeginTags();
        complete_Email_Tags = MailContent.getContactUsContent(objContactUsForm);
        try {
            //complete_Email_Tags = complete_Email_Tags + showEmailLogoTags();
            try {
                sendMail("support@globustracker.com", "Customer's FeedBack", complete_Email_Tags);
            } catch (Exception ex) {
                l.error(ex + "  " + ex.getMessage());
            }
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
    }

    /**
     * The method retrieves content for various actions and invokes
     * sendmail(params)
     *
     * @param objUser
     * @param mailType
     */
    public void setMailContaint(Users objUser, int mailType,String itemName) {
        String emailId = objUser.getLoginID();
        String complete_Email_Tags = "";
        if (mailType == 1) {
            //complete_Email_Tags = emailBeginTags();
            complete_Email_Tags = MailContent.getSignUpMailContent(objUser,itemName);
        } else if (mailType == 2) {
            //complete_Email_Tags = emailBeginTags();
            complete_Email_Tags = MailContent.getForgotPassContent(objUser);
        } else if (mailType == 3) {
           // complete_Email_Tags = emailBeginTags();
            complete_Email_Tags = MailContent.getChangePassContent(objUser);
        }
        try {
            //complete_Email_Tags = complete_Email_Tags + showEmailLogoTags();
            try {
                if (mailType == 1) {
                    sendMail(emailId, "Globustracker Registration", complete_Email_Tags);
                } else if (mailType == 2) {
                    sendMail(emailId, "Your Globustracker Password", complete_Email_Tags);
                } else if (mailType == 3) {
                    sendMail(emailId, "Your Changed Password", complete_Email_Tags);
                }
            } catch (Exception ex) {
                l.error(ex + "  " + ex.getMessage());
            }
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
    }

    /**
     * The method generates email content header
     *
     * @param subject
     * @return String
     */
    public String showEmailFormatDocDecTagsForType12(String subject) {
        String doc_dec_html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
                + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
                + "<head>"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"
                + "<title>E-mail</title>"
                + "</head>"
                + "<body>"
                + "<div style=\"width:600px; height:auto; margin:0 auto 0 auto; font-family:sans-serif;\">"
                + "<div style=\"width:500px; height:30px; margin-left:15px;\">" + subject + "</div>";
        return doc_dec_html;
    }

    /**
     * The method generates email content footer
     *
     * @param message
     * @param masterEmail
     * @return String
     */
    public String showEmailFormatMessageTags(String message, MasterEmail masterEmail) {
        String message_html = "<div style=\"width:600px; height:auto;\">"
                + "<div style=\"width:600px; height:26px; background-color:#ebeff9;\">"
                + "<div style=\"width:600px; height:3px; background-color:#ebeff9;\"></div>"
                + "<div style=\"width:594px; height:20px; margin:0 auto 0 auto; background-color:#e36c0a; font-size:15px;\">"
                + "<div style=\"width:30%; height:20px; float:left; color:#000; font-weight:bold; padding-top:2px;\">" + "Bradzter" + "</div>"
                + "<div style=\"width:70%; height:20px; float:right; color:#000; text-align:right;\"><b>STATUS ALERT</b></div>"
                + "</div>"
                + "</div>"
                + "<div style=\"width:590px; height:auto; padding-left:10px;\">" + message + "</div>"
                + "</div>"
                + "<div style=\"width:600px; height:auto;\">"
                + "<div style=\"width:600px; float:left; margin-top:30px; height:auto;\">"
                + "<div style=\"width:600px; float:left; height:auto;\">"
                + "<a style=\"font-family:Arial, Helvetica, sans-serif; font-size:13px; color:#0000ff; text-decoration:underline;\" href=\"" + masterEmail.getLoginUrl() + "\">MY DASHBOARD</a>" + "<br>"
                + "<a>Sincerely,</a><br>"
                + masterEmail.getSignature() + "<br>"
                + "</div>";
        return message_html;
    }
    //starting email tags to create a html page

    /**
     * The method generates email content header
     *
     * @return String
     */
    public String emailBeginTags() {
        StringBuilder begin_html = new StringBuilder();
        try {
            begin_html.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
            begin_html.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
            begin_html.append("<head>");
            begin_html.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
            begin_html.append("<title>Globustracker signup email</title>");
            begin_html.append("</head>");
            begin_html.append("");
            begin_html.append("<body>");
            begin_html.append("");
            begin_html.append("      <div style=\"width:600px; height:auto; margin:10px auto; border:1px solid #999; padding-bottom:1px;\">");
            begin_html.append("  ");
            begin_html.append("    <!--header starts-->");
            begin_html.append("     <div style=\"width:593px; height:22px; font-size:12px; font-family:Arial; color:#161616; padding: 6px 0 0 7px;\">Welcome To Globustracker</div>");
            begin_html.append("     ");
            begin_html.append("     <div style=\"background:url(http://i46.tinypic.com/o52x5t.png); height:69px; width:600px;\">");
            begin_html.append("       ");
            begin_html.append("        <div style=\" width:320px; height:49px; float:right;\"><a href=\"http://www.globustracker.com\"><img src=\"https://s3.amazonaws.com/images_ranktracker/Globustracker-logo-mail.png\" style=\"margin:18px 0 0 9px;\" /></a></div>");
            begin_html.append("     ");
            begin_html.append("     </div>");
            begin_html.append("   <!--header ends-->");
            begin_html.append("       <div style=\"width:600px; height:auto; background:url(http://i47.tinypic.com/359bg8z.png); padding-bottom:1px;\">");
            begin_html.append("          ");
            begin_html.append("             <div style=\"width:580px; height:10px; margin:0 auto;\"></div>");
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return begin_html.toString();
    }

    /**
     * The method generates email logo content
     *
     * @return String
     */
    public String showEmailLogoTags() {
        StringBuilder end_html = new StringBuilder();
        try {
//            end_html.append("         </div>");
            end_html.append("         </div>");
            end_html.append("       <!--Footer Start-->");
            end_html.append("             <div style=\"height: 40px; border: 1px solid rgb(255, 255, 255); background-color: rgb(119, 211, 252); margin: 7px auto; width: 577px;\">");
            end_html.append("       ");
            end_html.append("                <div style=\" width:120px; height:25px; float:left;margin: 8px 0 0 11px;\">");
            end_html.append("                ");
            end_html.append("                   <div style=\"width:33px; height:26px; float:left;\"><a href=\"http://www.twitter.com/Globustrackerr\"><img src=\"http://i47.tinypic.com/2n0uhso.png\" alt=\"\" /></a></div>");
            end_html.append("                   <div style=\"width:21px; height:21px; float:left; margin:5px;\"><a href=\"https://www.facebook.com/pages/GlobusTracker/1494928880747668\"><img src=\"http://i50.tinypic.com/2nta28.png\" alt=\"\" /></a></div>");
            end_html.append("                   <div style=\"width:25px; height:18px; float:left; margin:5px;\"><a href=\"mailto:support@globustracker.com\"><img src=\"http://i47.tinypic.com/dqmxcw.png\" alt=\"\" /></a></div>");
            end_html.append("                ");
            end_html.append("                </div>");
            end_html.append("                 ");
            end_html.append("              <div style=\"width:208px; height:25px; float:right; font-size:12px; color:#fff; font-family:arial; text-shadow:0 1px 1px #000; ");
            end_html.append("                          font-weight:bold;\">");
            end_html.append("              ");
            end_html.append("              <div style=\"width:124px; height:25px; float:right; font-size:12px; color:#fff; font-family:arial; text-shadow:0 1px 1px #000; margin-top: -5px;");
            end_html.append("                          font-weight:bold;\">");
//            end_html.append("               <a href=\"http://www.globussoft.com/\"><img src=\"https://s3.amazonaws.com/images_ranktracker/glb_icon.png\" alt=\"\" /></a></div>");
            end_html.append("</div> ");
            end_html.append("           ");
            end_html.append("       ");
            end_html.append("       </div>");
            end_html.append("             ");
            end_html.append("       <!--Footer End-->");
//            end_html.append("       ");
//            end_html.append("     ");
//            end_html.append("     </div>");
//            end_html.append("");
            end_html.append("</body>");
            end_html.append("</html>");
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return end_html.toString();
    }

    /**
     * The method generates email content for report
     *
     * @return String
     */
    public String showEmailForReport() {
        StringBuilder signup_html = new StringBuilder();
        try {
//            signup_html.append("   ");
//            signup_html.append("   ");
//            signup_html.append("       <!--content starts-->");
//            signup_html.append("       ");
//            signup_html.append("         <div style=\"width:600px; height:auto; background:url(http://i47.tinypic.com/359bg8z.png); padding-bottom:1px;\">");
//            signup_html.append("             ");
//            signup_html.append("             <div style=\"width:545px; height:auto; font-family:Arial; font-size:14px; font-weight:bold; margin:0 auto; padding:20px 0; color:#fff;\">");
//            signup_html.append("             ");
//            signup_html.append("                Please find requested report as attachment. <br />");
//            signup_html.append("             ");
//            signup_html.append("             </div>");
//            signup_html.append("             ");
//            signup_html.append("       <!--content ends-->");
            
            
//             signup_html.append("<html lang=3D\"en\">\n"
//                    + "<head>\n"
//                    + "</head>\n"
//                    + "\n"
//                    + "<body>\n"
//                    + "\n"
//                    + "<div> \n"
//                    + "    <iframe src=\"http://"+getText("email.domain")+"/ReportContent.action\" width=\"800px\" height=\"800px\" style=\"overflow:auto;border:0px ridge blue;border-radius:10px\">\n"
//                    + "    </iframe></div>\n"
//                    + "</body>\n"
//                    + "\n"
//                    + "</html>");

             Document doc =Jsoup.connect("http://"+getText("email.domain")+"/ReportContent.action").get();
             signup_html.append(doc.toString());
           
            
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return signup_html.toString();
    }

    /**
     * The method sends email to given recipients
     *
     * @param mail_recipients
     * @param mail_subject
     * @param mail_body
     */
    private void sendMail(String mail_recipients, String mail_subject,
            String mail_body) throws Exception {
        try {

            final String protocol = getText("email.protocol");
            final String host = getText("email.host"); //Reading from package.properties file
            final String user = getText("email.user");
            final String pwd = getText("email.pwd");
            //final String port = getText("email.port");
            final String auth = getText("email.auth");

            Properties props = new Properties();
            props.setProperty("mail.smtp.protocol", protocol);
            props.setProperty("mail.smtp.host", host);
            // props.put("mail.smtp.port", port);
            props.put("mail.smtp.auth", auth);

            Session mailSession = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user, pwd);
                        }
                    });

            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(user));
            message.setSender(new InternetAddress(user));
            message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(mail_recipients));
            try {
                if (mail_recipients.contains(",")) {
                    String[] bccMailIds = mail_recipients.split(",");
                    for (int i = 0; i < bccMailIds.length; i++) {
                        message.addRecipient(javax.mail.Message.RecipientType.BCC, new InternetAddress(mail_recipients));
                    }
                }
            } catch (Exception ex) {
                l.error(ex + "  " + ex.getMessage());
                ex.printStackTrace();
            }
            message.setSubject(mail_subject);
            //   message.setContent(mail_body, "text/plain");
            message.setContent(mail_body, "text/html");
            // Part two is attachment
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Fill the message
            messageBodyPart.setText(mail_body);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            multipart.addBodyPart(messageBodyPart);
            Transport.send(message);

            System.out.println("Message Send Successfully to : " + mail_recipients);
        } catch (MessagingException ex) {
            l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
            //  System.out.println("Unable to Send Mail");
        }
    }

    /**
     * The method sends scheduled reports
     */
    @Scheduled(cron = "* */30 * * * ?")
    public synchronized void sendReport() throws IOException {
        java.util.Date todayDate = new java.util.Date();
//        System.out.println("todayDate ========================= " + todayDate);
        List<Campaigns> emailIds = objCampaignsService.getEmailIdsForReport(todayDate);
        String mailTo = "";
        FileOutputStream fileOut = null;
        for (Campaigns objSite : emailIds) {
            if (objSite.getReportEmailID().isEmpty()) {
                continue;
            }
            // Users objUser = new Users();
            String campaignname = objSite.getCampaign();
            fileName = getShowPage() + "tmp/" + campaignname + ".xls";
            //fileName = fileName.replace("http", "").replace("/", "");
//            File file = new File(fileName);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
            try {
                mailTo = objSite.getReportEmailID();
                if (mailTo.equals("")) {
                    continue;
                }
//                System.out.println("--------------trycatch1----------------");
                Customers objcustomer = objSite.getCustomerID();
                Integer customerID = objcustomer.getCustomerID();
                Integer campaignID = objSite.getCampaignID();
                Object[] dataObject = objKeywordsService.getSerpData(campaignID, customerID);
                lstUpdatedKeywords = (List<Serpkeywords>) dataObject[0];
                lstsocialsignalupdate = (List<KeywordsLastUpdatedForm>) dataObject[1];
                lstSeoDetails = (List<Seokeyworddetails>) dataObject[3];
                String campaigntype = objSite.getCampaignType();
                if (campaigntype.contains("serp")) {
                    objWorkbook = objExcelReportAction.serpMailReport(lstUpdatedKeywords, lstSeoDetails, lstsocialsignalupdate, campaignname);
                } else if (campaigntype.contains("video")) {
                    Object[] dataObject1 = objKeywordsService.getVideoData(campaignID, customerID);
                    lstvideokeywords = (List<Videokeywords>) dataObject1[0];
                    //calling the createVideoExcelWorkBook method to create the <objWorkbook> object
                    objWorkbook = objExcelReportAction.createVideoExcelWorkBook(true, lstvideokeywords);
                }
//                fileOut = new FileOutputStream(fileName);
//                byte[] contentInBytes = objWorkbook.getBytes();
//                fileOut.write(contentInBytes);
//                fileOut.close();
                fileOut = new FileOutputStream(fileName);
                objWorkbook.write(fileOut);
                fileOut.close();
            } catch (NumberFormatException | IOException e) {
                l.error(e + "  " + e.getMessage());
                e.printStackTrace();
            }

            final String protocol = getText("email.protocol");
            final String host = getText("email.host"); //Reading from application.peorperties file
            final String user = getText("email.user");
            final String pwd = getText("email.pwd");
            final String auth = getText("email.auth");

            Properties props = new Properties();
            props.setProperty("mail.smtp.protocol", protocol);
            props.setProperty("mail.smtp.host", host);
            props.put("mail.smtp.auth", auth);
            String complete_Email_Tags = "";
 //           complete_Email_Tags = emailBeginTags();
            complete_Email_Tags =  showEmailForReport();
//            complete_Email_Tags = complete_Email_Tags + showEmailLogoTags();
            try {
                Session mailSession = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(user, pwd);
                            }
                        });
                MimeMessage message = new MimeMessage(mailSession);
                message.setFrom(new InternetAddress(user));
                message.setSender(new InternetAddress(user));
                String[] mailToBcc = mailTo.split(",");
                mailTo = mailToBcc[0];

                message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(mailTo));
                if (mailToBcc.length > 1) {
                    try {
                        for (int i = 1; i < mailToBcc.length; i++) {
                            message.addRecipient(javax.mail.Message.RecipientType.BCC, new InternetAddress(mailToBcc[i].trim()));

                        }
                    } catch (Exception ex) {
                        l.error(ex + "  " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                message.setSubject("Scheduled report for the campaign : " + objSite.getCampaign());
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(complete_Email_Tags, "text/html");
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
                // Part two is attachment
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(fileName);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(objSite.getCampaign() + "_" + ".xls");
                multipart.addBodyPart(messageBodyPart);
                message.setContent(multipart);
                try {
                    Transport.send(message);
                    Mailhistory mailHistory = new Mailhistory();
                    mailHistory.setEmailId(mailTo);
                    mailHistory.setMailSentOn(todayDate);
                    Integer custid = objSite.getCustomerID().getCustomerID();
                    System.out.println("custid = " + custid);
                    mailHistory.setCustomerId(new Customers(custid));
                    objCustomerService.updateMailHistory(mailHistory);
                } catch (SendFailedException sfe) {
                    l.error(sfe + "  " + sfe.getMessage());
                    sfe.printStackTrace();
                    message.setRecipients(Message.RecipientType.TO, sfe.getValidUnsentAddresses());
                    Transport.send(message);
                } catch (Exception e) {
                    l.error(e + "  " + e.getMessage());
                    e.printStackTrace();
                }
                File file1 = new File(fileName);
                file1.delete();
                objSettingsService.updateNextMailSendDate(objSite);
            } catch (Exception ex) {
                l.error(ex + "  " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        //return SUCCESS;
    }

    /**
     * The method mails a campaign report to given email-id
     *
     * @return String
     */
    public String sendSerpCampaignReport() {
        Integer campaignID = 0;
        String emailID = "";
        String[] temp = jString.split(":");
        objRequest = ServletActionContext.getRequest();
        objSession = objRequest.getSession();
        campaignID = Integer.parseInt(temp[0]);
        emailID = temp[1];
        Campaigns objCampaigns = objCampaignsService.getCampaignObj(campaignID);
        String campaignname = objCampaigns.getCampaign().toString();
        FileOutputStream fileOut = null;
        fileName = getShowPage() + "tmp/" + campaignname + ".xls";
        try {
            int customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
            Object[] dataObject = objKeywordsService.getSerpData(campaignID, customerID);
            lstUpdatedKeywords = (List<Serpkeywords>) dataObject[0];
            lstsocialsignalupdate = (List<KeywordsLastUpdatedForm>) dataObject[1];
            lstSeoDetails = (List<Seokeyworddetails>) dataObject[3];
            objWorkbook = objExcelReportAction.serpMailReport(lstUpdatedKeywords, lstSeoDetails, lstsocialsignalupdate, campaignname);
            fileOut = new FileOutputStream(fileName);
            objWorkbook.write(fileOut);
            fileOut.close();
            //objUser = objSite.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String complete_Email_Tags = "";
      //  complete_Email_Tags = emailBeginTags();
        complete_Email_Tags =  showEmailForReport();
       // complete_Email_Tags = complete_Email_Tags + showEmailLogoTags();
        final String protocol = getText("email.protocol");
        final String host = getText("email.host"); //Reading from application.peorperties file
        final String user = getText("email.user");
        final String pwd = getText("email.pwd");
        final String port = getText("email.port");
        final String auth = getText("email.auth");

        Properties props = new Properties();
        props.setProperty("mail.smtp.protocol", protocol);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", auth);
        //props.put("mail.smtp.port", port);

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pwd);
                    }
                });

        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress(user));
            message.setSender(new InternetAddress(user));
            message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(emailID));
            message.setSubject(objCampaigns.getCampaign() + "_Report");
            //message.setContent("", "text/html");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(complete_Email_Tags, "text/html");
            //messageBodyPart.setText(complete_Email_Tags);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(objCampaigns.getCampaign() + "_" + ".xls");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            try {
                Transport.send(message);
                objSession.setAttribute("message", "Mail Sent.Please Check");
            } catch (SendFailedException sfe) {
                l.error(sfe + "  " + sfe.getMessage());
                message.setRecipients(Message.RecipientType.TO, sfe.getValidUnsentAddresses());
                Transport.send(message);

            } finally {
                try {
                    File file = new File(fileName);
                    file.delete();
                } catch (Exception ex) {
                    l.error(ex + "  " + ex.getMessage());
                }
            }
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    public String sendVideoCampaignReport() {
        Integer campaignID = 0;
        String emailID = "";
        String[] temp = jString.split(":");
        objRequest = ServletActionContext.getRequest();
        objSession = objRequest.getSession();
        campaignID = Integer.parseInt(temp[0]);
        emailID = temp[1];
        Campaigns objCampaigns = objCampaignsService.getCampaignObj(campaignID);
        String campaignname = objCampaigns.getCampaign().toString();
        FileOutputStream fileOut = null;
        fileName = getShowPage() + "tmp/" + campaignname + ".xls";
        int customerId = Integer.parseInt(objSession.getAttribute("customerID").toString());
        try {
            Object[] dataObject1 = objKeywordsService.getVideoData(campaignID, customerId);
            lstvideokeywords = (List<Videokeywords>) dataObject1[0];
            //calling the createVideoExcelWorkBook method to create the <objWorkbook> object
            objWorkbook = objExcelReportAction.createVideoExcelWorkBook(true, lstvideokeywords);
            fileOut = new FileOutputStream(fileName);
            objWorkbook.write(fileOut);
            fileOut.close();
            //objUser = objSite.getUsers();
        } catch (Exception e) {
            l.error(e + "  " + e.getMessage());
            e.printStackTrace();
        }

        String complete_Email_Tags = "";
     //   complete_Email_Tags = emailBeginTags();
        complete_Email_Tags =  showEmailForReport();
       // complete_Email_Tags = complete_Email_Tags + showEmailLogoTags();
        final String protocol = getText("email.protocol");
        final String host = getText("email.host"); //Reading from application.peorperties file
        final String user = getText("email.user");
        final String pwd = getText("email.pwd");
        final String port = getText("email.port");
        final String auth = getText("email.auth");

        Properties props = new Properties();
        props.setProperty("mail.smtp.protocol", protocol);
        props.setProperty("mail.smtp.host", host);
        // props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", auth);

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pwd);
                    }
                });

        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress(user));
            message.setSender(new InternetAddress(user));
            message.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(emailID));
            message.setSubject("Campaign " + objCampaigns.getCampaign() + " Report");
            //message.setContent("", "text/html");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(complete_Email_Tags, "text/html");
            //messageBodyPart.setText(complete_Email_Tags);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(objCampaigns.getCampaign() + "_" + ".xls");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            try {
                Transport.send(message);
                objSession.setAttribute("message", "Mail Sent.Please Check");
            } catch (SendFailedException sfe) {
                l.error(sfe + "  " + sfe.getMessage());
                message.setRecipients(Message.RecipientType.TO, sfe.getValidUnsentAddresses());
                Transport.send(message);

            } finally {
                try {
                    File file = new File(fileName);
                    file.delete();
                } catch (Exception ex) {
                    l.error(ex + "  " + ex.getMessage());
                }
            }
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * The method validates form of given email-id
     */
    @Override
    public void validate() {
        try {
            String[] temp = jString.split(":");
            if (temp.length < 2) {
                addActionError("Please provide Email Id");
            } else {
                String emailId = temp[1];
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(emailId);
                boolean matchFound = m.matches();
                if (!matchFound) {
                    addActionError("Please Provide valid Email ID");
                }
            }
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
    }

    /**
     * The method replaces special characters from given string
     *
     * @param str
     * @return String
     */
    public String convertedString(String str) {
        str = str.replace(" ", "");
        str = str.replace("@", "").replace("#", "").replace("$", "").replace("&", "").
                replace("%", "").replace(",", "").replace("?", "").replace("-", "");
        return str;
    }

    public String getShowPage() {
        String str = null;
        try {
            str = this.getClass().getClassLoader().getResource("").getPath();
            if (str.contains("%20")) {
                str = str.replaceAll("%20", " ");
            }
        } catch (Exception e) {
            str = System.getProperty("user.dir");
        }
        return str;
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
     * @return objCampaignsService
     */
    public CampaignsService getObjCampaignsService() {
        return objCampaignsService;
    }

    /**
     *
     * @param objCampaignsService
     */
    public void setObjCampaignsService(CampaignsService objCampaignsService) {
        this.objCampaignsService = objCampaignsService;
    }

    /**
     *
     * @return objKeywordsService
     */
    public KeywordsService getObjKeywordsService() {
        return objKeywordsService;
    }

    /**
     *
     * @param objKeywordsService
     */
    public void setObjKeywordsService(KeywordsService objKeywordsService) {
        this.objKeywordsService = objKeywordsService;
    }

    /**
     *
     * @return objExcelReportAction
     */
    public ExcelReportAction getObjExcelReportAction() {
        return objExcelReportAction;
    }

    /**
     *
     * @param objExcelReportAction
     */
    public void setObjExcelReportAction(ExcelReportAction objExcelReportAction) {
        this.objExcelReportAction = objExcelReportAction;
    }

    /**
     *
     * @return objKeywordsDao
     */
    public KeywordsDao getObjKeywordsDao() {
        return objKeywordsDao;
    }

    /**
     *
     * @param objKeywordsDao
     */
    public void setObjKeywordsDao(KeywordsDao objKeywordsDao) {
        this.objKeywordsDao = objKeywordsDao;
    }

    /**
     *
     * @return objSettingsService
     */
    public SettingsService getObjSettingsService() {
        return objSettingsService;
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
     * @return jString
     */
    public String getJString() {
        return jString;
    }

    /**
     *
     * @param jString
     */
    public void setJString(String jString) {
        this.jString = jString;
    }
}
