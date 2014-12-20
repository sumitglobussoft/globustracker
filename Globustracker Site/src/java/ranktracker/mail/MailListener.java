/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.mail;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Customers;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Mailhistory;
import ranktracker.service.CampaignsService;
import ranktracker.service.CustomerService;
import ranktracker.service.KeywordsService;

/**
 * Redundant class, due for removal
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class MailListener implements ServletContextListener {

    static Logger l = Logger.getLogger(MailListener.class.getName());
//    private ScheduledExecutorService scheduler;
//    private CustomerService objCustomerService;
//    private CampaignsService objSitesListService;
//    private KeywordsService objSiteDetailService;
//    private List<Keywords> lstkeywords;
//    private HSSFWorkbook objWorkbook = new HSSFWorkbook();
//    private HSSFSheet objSheet = null;
//    private HSSFRow objRow = null;
//    private static final int BUFSIZE = 4096;
//    String fileName = "SiteReport_" + ".xls";

    /**
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //scheduler = Executors.newSingleThreadScheduledExecutor();
        //scheduler.scheduleAtFixedRate(new SendReport(), 0, 1, TimeUnit.DAYS);
    }

    /**
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //scheduler.shutdownNow();
    }
    /*
     private class SendReport implements Runnable {

     public SendReport() {
     }

     @Override
     public void run() {
     java.util.Date todayDate = new java.util.Date();
     List<Campaigns> emailIds = objSitesListService.getEmailIdsForReport(todayDate);
     String[] mailSendTo = new String[emailIds.size()];
     Iterator<Campaigns> it = emailIds.iterator();
     int i = 0;
     Customers objCustomer = new Customers();
     while (it.hasNext()) {
     try {
     Campaigns objSites = it.next();
     mailSendTo[i] = objSites.getReportEmailId();
     generateExcel(objSites.getCustomerId());
     objCustomer = null;//objSites.getCustomers();
     } catch (Exception e) {
     l.error(e + "  " + e.getMessage());
     e.printStackTrace();
     }
     }
     String host = "mail.globussoft.com";
     String from = "kalpana@globussoft.com";
     String filename = fileName;

     // Get system properties
     Properties props = System.getProperties();
     props.put("mail.smtp.host", host);
     props.put("mail.smtp.port", 587);
     Session session = Session.getInstance(props, null);
     System.out.println(session.getProperties());

     try {
     Message message = new MimeMessage(session);
     message.setFrom(new InternetAddress(from));
     InternetAddress[] toAddress = new InternetAddress[mailSendTo.length];
     for (int j = 0; j < mailSendTo.length; j++) {
     toAddress[j] = new InternetAddress(mailSendTo[j]);
     }
     message.setRecipients(Message.RecipientType.TO, toAddress);
     message.setSubject("Alert Mail");
     BodyPart messageBodyPart = new MimeBodyPart();
     messageBodyPart.setText("Here's the file");
     Multipart multipart = new MimeMultipart();
     multipart.addBodyPart(messageBodyPart);
     messageBodyPart = new MimeBodyPart();
     DataSource source = new FileDataSource(filename);
     messageBodyPart.setDataHandler(new DataHandler(source));
     messageBodyPart.setFileName(filename);
     multipart.addBodyPart(messageBodyPart);
     message.setContent(multipart);
     try {
     Transport.send(message);
     Mailhistory mailHistory = new Mailhistory();
     mailHistory.setEmailId(mailSendTo[i]);
     mailHistory.setMailSentOn(todayDate);
     mailHistory.setCustomers(objCustomer);
     objCustomerService.updateMailHistory(mailHistory);
     } catch (SendFailedException sfe) {
     l.error(sfe + "  " + sfe.getMessage());
     message.setRecipients(Message.RecipientType.TO, sfe.getValidUnsentAddresses());
     Transport.send(message);
     }
     } catch (Exception e) {
     l.error(e + "  " + e.getMessage());
     e.printStackTrace();
     }
     }
     }*/
//    /**
//     *
//     * @return
//     */
//    public CustomerService getObjCustomerService() {
//        return objCustomerService;
//    }
//
//    /**
//     *
//     * @param objCustomerService
//     */
//    public void setObjCustomerService(CustomerService objCustomerService) {
//        this.objCustomerService = objCustomerService;
//    }
//
//    /**
//     *
//     * @param CustomerID
//     * @throws Exception
//     */
//    public void generateExcel(Integer CustomerID) throws Exception {
//
//        Object[] dataObject = objSiteDetailService.getDataForReports(CustomerID);
//        lstkeywords = (List<Keywords>) dataObject[0];
//        objSheet = objWorkbook.createSheet("Keywords");
//
//        objSheet.autoSizeColumn(0, true);
//        objSheet.autoSizeColumn(1, true);
//
//        int rownum = 1;
//        boolean b = false;
//        for (Keywords objKeyword : lstkeywords) {
//
//            if (b) {
//                rownum = rownum + 2;
//
//                objRow = objSheet.createRow(rownum);
//                objRow.createCell(0).setCellValue("Site");
//                //objRow.createCell(1).setCellValue(objKeyword.getSites().getSite());
//                rownum++;
//                //write all headers
//                objRow = objSheet.createRow(rownum);
//                objRow.createCell(0).setCellValue("Url");
//                objRow.createCell(1).setCellValue("Keyword");
//                objRow.createCell(2).setCellValue("Google");
//                objRow.createCell(3).setCellValue("Day Change");
//                objRow.createCell(4).setCellValue("Week Change");
//                objRow.createCell(5).setCellValue("Month Change");
//                objRow.createCell(6).setCellValue("Bing");
//                objRow.createCell(7).setCellValue("Day Change");
//                objRow.createCell(8).setCellValue("Week Change");
//                objRow.createCell(9).setCellValue("Month Change");
//                objRow.createCell(10).setCellValue("Yahoo");
//                objRow.createCell(11).setCellValue("Day Change");
//                objRow.createCell(12).setCellValue("Week Change");
//                objRow.createCell(13).setCellValue("Month Change");
//                objRow.createCell(14).setCellValue("PR");
//                objRow.createCell(15).setCellValue("Alexa Rank");
//                objRow.createCell(16).setCellValue("Back Links Count");
//                objRow.createCell(17).setCellValue("Monthly Searches Count");
//
//                rownum++;
//                b = false;
//            }
//
//            if (objKeyword.getKeyword().equals("")) {
//                b = true;
//                continue;
//            }
//
//            try {
//                objRow = objSheet.createRow(rownum);
//
//                objRow.createCell(0).setCellValue(objKeyword.getUrl());
//
//                objRow.createCell(1).setCellValue(objKeyword.getKeyword());
//                objRow.createCell(2).setCellValue(objKeyword.getRankGoogle());
//                objRow.createCell(3).setCellValue(objKeyword.getRankGoogleDayChange());
//                objRow.createCell(4).setCellValue(objKeyword.getRankGoogleWeekChange());
//                objRow.createCell(5).setCellValue(objKeyword.getRankGoogleMonthChange());
//                objRow.createCell(6).setCellValue(objKeyword.getRankBing());
//                objRow.createCell(7).setCellValue(objKeyword.getRankGoogleDayChange());
//                objRow.createCell(8).setCellValue(objKeyword.getRankGoogleWeekChange());
//                objRow.createCell(9).setCellValue(objKeyword.getRankGoogleMonthChange());
//                objRow.createCell(10).setCellValue(objKeyword.getRankYahoo());
//                objRow.createCell(11).setCellValue(objKeyword.getRankGoogleDayChange());
//                objRow.createCell(12).setCellValue(objKeyword.getRankGoogleWeekChange());
//                objRow.createCell(13).setCellValue(objKeyword.getRankGoogleMonthChange());
//                objRow.createCell(14).setCellValue(objKeyword.getRankPage());
//                objRow.createCell(15).setCellValue(objKeyword.getRankAlexa());
//                objRow.createCell(16).setCellValue(objKeyword.getCountBackLinks());
//                objRow.createCell(16).setCellValue(objKeyword.getCountBackLinks());
//                objRow.createCell(17).setCellValue(objKeyword.getCountMonthlySearches());
//                objSheet.setColumnWidth(0, 7500);
//                objSheet.setColumnWidth(1, 7500);
//
//                rownum++;
//            } catch (Exception e) {
//                l.error(e + "  " + e.getMessage());
//                System.out.println("Exception comes in:::" + rownum);
//                e.printStackTrace();
//            }
//        }
//        FileOutputStream fileOut = new FileOutputStream(fileName);
//        objWorkbook.write(fileOut);
//        fileOut.close();
//    }
//
//    /**
//     *
//     * @return
//     */
//    public KeywordsService getObjSiteDetailService() {
//        return objSiteDetailService;
//    }
//
//    /**
//     *
//     * @param objSiteDetailService
//     */
//    public void setObjSiteDetailService(KeywordsService objSiteDetailService) {
//        this.objSiteDetailService = objSiteDetailService;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public CampaignsService getObjSitesListService() {
//        return objSitesListService;
//    }
//
//    /**
//     *
//     * @param objSitesListService
//     */
//    public void setObjSitesListService(CampaignsService objSitesListService) {
//        this.objSitesListService = objSitesListService;
//    }
}
