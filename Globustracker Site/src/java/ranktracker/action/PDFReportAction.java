/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ranktracker.entity.Serpkeywords;
import ranktracker.service.KeywordsService;

/**
 * Action layer class for actions initiated for pdf report generation module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class PDFReportAction extends HibernateDaoSupport {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * objResponse The HttpServletResponse object
     */
    private HttpServletResponse objResponse;
    /**
     * objKeywordsService The service layer object variable for KeywordsService
     * object
     */
    private KeywordsService objKeywordsService;
    /**
     * objHttpSession The HttpSession object
     */
    private HttpSession objHttpSession;
    /**
     * driver The database driver name
     */
    public static String driver = "com.mysql.jdbc.Driver";
    /**
     * url The database url
     */
    public static String url = "jdbc:mysql://localhost:3306/databasename";
    /**
     * username The database username
     */
    public static String username = "username";
    /**
     * password The database password
     */
    public static String password = "password";
    /**
     * conn The JDBC Connection object
     */
    public static Connection conn = null;
    private static final int BUFSIZE = 4096;

    /**
     * The method generates report pdf and streams generated pdf to client
     *
     * @throws Exception
     */
    public void execute() throws Exception {

        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //fileName The string containing pdf file name suffix
        String fileName;

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {
            try {

                //initializing http request object
                objRequest = ServletActionContext.getRequest();
                objResponse = ServletActionContext.getResponse();
                Integer campaignID = Integer.parseInt(objRequest.getParameter("campaignId"));
                String campaignName = objRequest.getParameter("campaignName");
                fileName = campaignName + ".pdf";
                /*
                 Object[] dataObject = objKeywordsService.getData(campaignID);
                 lstkeywords = (List<Serpkeywords>) dataObject[0];
                 JRBeanCollectionDataSource beanBurritoWrap = new JRBeanCollectionDataSource(lstkeywords);
               
                 URL reportFileURL = getClass().getResource(reportPath);
                 File reportFile = new File(reportFileURL.toURI());
                 JasperDesign jasperDesign = JRXmlLoader.load(reportFile);

                 */
                try {
                    /*
                     * Open the Database Connection
                     */

                    Class.forName(driver).newInstance();
                    conn = DriverManager.getConnection(url, username, password);

                    /*
                     * Load JRXML files on JasperDesign
                     */
                    URL reportFileURL = getClass().getResource("../jaspertemplates/google.jrxml");
                    File reportFile = new File(reportFileURL.toURI());
                    JasperDesign jdgoogle = JRXmlLoader.load(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/yahoo.jrxml");
                    reportFile = new File(reportFileURL.toURI());
                    JasperDesign jdyahoo = JRXmlLoader.load(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/bing.jrxml");
                    reportFile = new File(reportFileURL.toURI());
                    JasperDesign jdbing = JRXmlLoader.load(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/moz.jrxml");
                    reportFile = new File(reportFileURL.toURI());
                    JasperDesign jdmoz = JRXmlLoader.load(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/socialnetwork.jrxml");
                    reportFile = new File(reportFileURL.toURI());
                    JasperDesign jdsocial = JRXmlLoader.load(reportFile);

                    /*
                     * SQL Query for Search Engine
                     */
                    String searchEngine = "select a.CampaignID, b.KeywordID, b.Url, b.Keyword, b.RankGoogle, b.BestMatchRankGoogle, "
                            + "b.GooglePageRank, b.RankBing, b.BestMatchRankBing, b.RankYahoo, b.BestMatchRankYahoo, b.GoogleUpdatedDate, "
                            + "b.BingUpdateDate, b.YahooUpdateDate, a.Campaign, a.CompanyName, a.CompanyURLLink, a.CompanyLogoLink "
                            + "from campaigns a inner join serpkeywords b on a.CampaignID = b.CampaignID "
                            + "where a.CampaignID = " + campaignID + " and b.Visibility = 1 group by b.KeywordID";

                    /*
                     * SQL Query for Search Engine
                     */
                    String moz = "select a.CampaignID, a.Campaign, a.CompanyName, a.CompanyURLLink, a.CompanyLogoLink, b.Url, "
                            + "b.Keyword, b.SearchVolume, b.GoogleCPC, b.KeywordCompetition, b.NumberofResult, b.SiteIndexing, "
                            + "b.RankAlexa, b.CountBackLinks, b.CountMonthlySearches, b.GooglePA, b.GoogleDA "
                            + "from campaigns a join seokeyworddetails b on a.CampaignID = b.CampaignID "
                            + "where a.CampaignID = " + campaignID + " and b.Visibility = 1";

                    /*
                     * SQL Query for Search Engine
                     */
                    String socialNetwork = "select * from campaigns a "
                            + "join socialsignalurls b on a.CampaignID = b.CampaignID "
                            + "where a.CampaignID = " + campaignID + " and b.Visibility = 1";

                    /*
                     * Read the JRXML file and create a google PDF File
                     */
                    JRDesignQuery newQuery1 = new JRDesignQuery();
                    newQuery1.setText(searchEngine);
                    jdgoogle.setQuery(newQuery1);
                    JasperReport jrgoogle = JasperCompileManager.compileReport(jdgoogle);
                    JasperPrint jpgoogle = JasperFillManager.fillReport(jrgoogle, null, conn);
                    reportFileURL = getClass().getResource("../jaspertemplates/Google.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    JasperExportManager.exportReportToPdfFile(jpgoogle, reportFile.getAbsolutePath());

                    /*
                     * Read the JRXML file and create a yahoo PDF File
                     */
                    JRDesignQuery newQuery2 = new JRDesignQuery();
                    newQuery2.setText(searchEngine);
                    jdyahoo.setQuery(newQuery2);
                    JasperReport jryahoo = JasperCompileManager.compileReport(jdyahoo);
                    JasperPrint jpyahoo = JasperFillManager.fillReport(jryahoo, null, conn);
                    reportFileURL = getClass().getResource("../jaspertemplates/Yahoo.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    JasperExportManager.exportReportToPdfFile(jpyahoo, reportFile.getAbsolutePath());

                    /*
                     * Read the JRXML file and create a bing PDF File
                     */
                    JRDesignQuery newQuery3 = new JRDesignQuery();
                    newQuery3.setText(searchEngine);
                    jdbing.setQuery(newQuery3);
                    JasperReport jrbing = JasperCompileManager.compileReport(jdbing);
                    JasperPrint jpbing = JasperFillManager.fillReport(jrbing, null, conn);
                    reportFileURL = getClass().getResource("../jaspertemplates/Bing.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    JasperExportManager.exportReportToPdfFile(jpbing, reportFile.getAbsolutePath());

                    /*
                     * Read the JRXML file and create a moz PDF File
                     */
                    JRDesignQuery newQuery4 = new JRDesignQuery();
                    newQuery4.setText(moz);
                    jdmoz.setQuery(newQuery4);
                    JasperReport jrmoz = JasperCompileManager.compileReport(jdmoz);
                    JasperPrint jpmoz = JasperFillManager.fillReport(jrmoz, null, conn);
                    reportFileURL = getClass().getResource("../jaspertemplates/Moz.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    JasperExportManager.exportReportToPdfFile(jpmoz, reportFile.getAbsolutePath());

                    /*
                     * Read the JRXML file and create a social website PDF File
                     */
                    JRDesignQuery newQuery5 = new JRDesignQuery();
                    newQuery5.setText(socialNetwork);
                    jdsocial.setQuery(newQuery5);
                    JasperReport jrsocial = JasperCompileManager.compileReport(jdsocial);
                    JasperPrint jpsocial = JasperFillManager.fillReport(jrsocial, null, conn);
                    reportFileURL = getClass().getResource("../jaspertemplates/SocialNetwork.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    JasperExportManager.exportReportToPdfFile(jpsocial, reportFile.getAbsolutePath());

                    /*
                     * Take PDF file as a input through FileInputStream
                     */
                    reportFileURL = getClass().getResource("../jaspertemplates/Google.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileInputStream fis1 = new FileInputStream(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/Yahoo.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileInputStream fis2 = new FileInputStream(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/Bing.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileInputStream fis3 = new FileInputStream(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/Moz.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileInputStream fis4 = new FileInputStream(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/SocialNetwork.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileInputStream fis5 = new FileInputStream(reportFile);

                    /*
                     * Read the PDF Files
                     */
                    PdfReader file1 = new PdfReader(fis1);
                    PdfReader file2 = new PdfReader(fis2);
                    PdfReader file3 = new PdfReader(fis3);
                    PdfReader file4 = new PdfReader(fis4);
                    PdfReader file5 = new PdfReader(fis5);

                    /*
                     * Give the Resulting PDF location
                     */
                    reportFileURL = getClass().getResource("../jaspertemplates/Result.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileOutputStream fos = new FileOutputStream(reportFile);
                    PdfCopyFields copy = new PdfCopyFields(fos);

                    /*
                     * Copy the all contents of the PDF files data into one file
                     */
                    copy.addDocument(file1);
                    copy.addDocument(file2);
                    copy.addDocument(file3);
                    copy.addDocument(file4);
                    copy.addDocument(file5);
                    copy.close();

                    System.out.println("Done ...");
                    ServletOutputStream outStream = objResponse.getOutputStream();
                    objResponse.setContentType("application/pdf");
                    objResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName);
                    byte[] byteBuffer = new byte[BUFSIZE];
                    int length = 0;
                    //File file = new File("D:\\ranktracker\\ranktracker_site\\src\\java\\ranktracker\\jaspertemplates\\Result.pdf");

                    objResponse.setContentLength((int) reportFile.length());
                    DataInputStream in = new DataInputStream(new FileInputStream(reportFile));

                    // reads the file's bytes and writes them to the objResponse stream
                    while ((in != null) && ((length = in.read(byteBuffer)) != -1)) {
                        outStream.write(byteBuffer, 0, length);
                    }

                    in.close();
                    outStream.close();

                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | URISyntaxException | JRException | IOException | DocumentException e) {
                    e.printStackTrace();
                }
                /*
                 JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), beanBurritoWrap);


                 ServletOutputStream outStream = objResponse.getOutputStream();
                 objResponse.setContentType("application/pdf");
                 objResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                 JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
                 * */
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getPDFReportsForVideo() throws Exception {

        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //fileName The string containing pdf file name suffix
        String fileName;

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {
            try {

                //initializing http request object
                objRequest = ServletActionContext.getRequest();
                objResponse = ServletActionContext.getResponse();
                Integer campaignID = Integer.parseInt(objRequest.getParameter("campaignId"));
                String campaignName = objRequest.getParameter("campaignName");
                fileName = campaignName + ".pdf";
                try {
                    /*
                     * Open the Database Connection
                     */

                    Class.forName(driver).newInstance();
                    conn = DriverManager.getConnection(url, username, password);

                    /*
                     * Load JRXML files on JasperDesign
                     */
                    URL reportFileURL = getClass().getResource("../jaspertemplates/youtube.jrxml");
                    File reportFile = new File(reportFileURL.toURI());
                    JasperDesign jd1 = JRXmlLoader.load(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/vimeo.jrxml");
                    reportFile = new File(reportFileURL.toURI());
                    JasperDesign jd2 = JRXmlLoader.load(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/dailymotion.jrxml");
                    reportFile = new File(reportFileURL.toURI());
                    JasperDesign jd3 = JRXmlLoader.load(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/metacafe.jrxml");
                    reportFile = new File(reportFileURL.toURI());
                    JasperDesign jd4 = JRXmlLoader.load(reportFile);

                    /*
                     * New SQL Query
                     */
                    String sql = "select * from videokeywords A "
                            + "join campaigns B on A.CampaignID = B.CampaignID "
                            + "where A.CampaignID = " + campaignID + " and A.Visibility = 1";

                    /*
                     * Read the JRXML file and create a new PDF File
                     */
                    JRDesignQuery newQuery1 = new JRDesignQuery();
                    newQuery1.setText(sql);
                    jd1.setQuery(newQuery1);
                    JasperReport jr1 = JasperCompileManager.compileReport(jd1);
                    JasperPrint jp1 = JasperFillManager.fillReport(jr1, null, conn);
                    reportFileURL = getClass().getResource("../jaspertemplates/Youtube.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    JasperExportManager.exportReportToPdfFile(jp1, reportFile.getAbsolutePath());

                    /*
                     * Read the JRXML file and create a new PDF File
                     */
                    JRDesignQuery newQuery2 = new JRDesignQuery();
                    newQuery2.setText(sql);
                    jd2.setQuery(newQuery2);
                    JasperReport jr2 = JasperCompileManager.compileReport(jd2);
                    JasperPrint jp2 = JasperFillManager.fillReport(jr2, null, conn);
                    reportFileURL = getClass().getResource("../jaspertemplates/Vimeo.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    JasperExportManager.exportReportToPdfFile(jp2, reportFile.getAbsolutePath());

                    /*
                     * Read the JRXML file and create a new PDF File
                     */
                    JRDesignQuery newQuery3 = new JRDesignQuery();
                    newQuery3.setText(sql);
                    jd3.setQuery(newQuery3);
                    JasperReport jr3 = JasperCompileManager.compileReport(jd3);
                    JasperPrint jp3 = JasperFillManager.fillReport(jr3, null, conn);
                    reportFileURL = getClass().getResource("../jaspertemplates/DailyMotion.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    JasperExportManager.exportReportToPdfFile(jp3, reportFile.getAbsolutePath());

                    /*
                     * Read the JRXML file and create a new PDF File
                     */
                    JRDesignQuery newQuery4 = new JRDesignQuery();
                    newQuery4.setText(sql);
                    jd4.setQuery(newQuery4);
                    JasperReport jr4 = JasperCompileManager.compileReport(jd4);
                    JasperPrint jp4 = JasperFillManager.fillReport(jr4, null, conn);
                    reportFileURL = getClass().getResource("../jaspertemplates/Metacafe.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    JasperExportManager.exportReportToPdfFile(jp4, reportFile.getAbsolutePath());

                    /*
                     * Take PDF file as a input through FileInputStream
                     */
                    reportFileURL = getClass().getResource("../jaspertemplates/Youtube.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileInputStream fis1 = new FileInputStream(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/Vimeo.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileInputStream fis2 = new FileInputStream(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/DailyMotion.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileInputStream fis3 = new FileInputStream(reportFile);
                    reportFileURL = getClass().getResource("../jaspertemplates/Metacafe.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileInputStream fis4 = new FileInputStream(reportFile);

                    /*
                     * Read the PDF Files
                     */
                    PdfReader file1 = new PdfReader(fis1);
                    PdfReader file2 = new PdfReader(fis2);
                    PdfReader file3 = new PdfReader(fis3);
                    PdfReader file4 = new PdfReader(fis4);

                    /*
                     * Give the Resulting PDF location
                     */
                    reportFileURL = getClass().getResource("../jaspertemplates/Result.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileOutputStream fos = new FileOutputStream(reportFile);
                    PdfCopyFields copy = new PdfCopyFields(fos);

                    /*
                     * Copy the all contents of the PDF files data into one file
                     */
                    copy.addDocument(file1);
                    copy.addDocument(file2);
                    copy.addDocument(file3);
                    copy.addDocument(file4);
                    copy.close();

                    System.out.println("Done ...");
                    ServletOutputStream outStream = objResponse.getOutputStream();
                    objResponse.setContentType("application/pdf");
                    objResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName);
                    byte[] byteBuffer = new byte[BUFSIZE];
                    int length = 0;

                    objResponse.setContentLength((int) reportFile.length());
                    DataInputStream in = new DataInputStream(new FileInputStream(reportFile));

                    // reads the file's bytes and writes them to the objResponse stream
                    while ((in != null) && ((length = in.read(byteBuffer)) != -1)) {
                        outStream.write(byteBuffer, 0, length);
                    }

                    in.close();
                    outStream.close();

                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | URISyntaxException | JRException | IOException | DocumentException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getCrawledHistory() throws Exception {

        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //fileName The string containing pdf file name suffix
        String fileName;

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {
            try {

                //initializing http request object
                objRequest = ServletActionContext.getRequest();
                objResponse = ServletActionContext.getResponse();
                Integer keywordID = Integer.parseInt(objRequest.getParameter("keywordId"));
                Serpkeywords keywords = (Serpkeywords) getSession().get(Serpkeywords.class, keywordID);
                fileName = keywords.getKeyword() + ".pdf";
                try {
                    /*
                     * Open the Database Connection
                     */

                    Class.forName(driver).newInstance();
                    conn = DriverManager.getConnection(url, username, password);

                    /*
                     * Load JRXML files on JasperDesign
                     */
                    URL reportFileURL = getClass().getResource("../jaspertemplates/crawledhistory.jrxml");
                    File reportFile = new File(reportFileURL.toURI());
                    JasperDesign jd = JRXmlLoader.load(reportFile);

                    /*
                     * New SQL Query
                     */
                    String sql = "select TrackDate, Rank, BestMatchRank, BestMatchLink, CompanyName, CompanyURLLink, "
                            + "CompanyLogoLink, Keyword,Url from serpkeywords A join campaigns B on B.CampaignID = A.CampaignID "
                            + "join serpstrackhistory C on A.KeywordId = C.KeywordID "
                            + "where A.KeywordID = " + keywordID + " and C.SearchEngine = 'google.com' order by TrackDate Desc limit 50 ";

                    /*
                     * Read the JRXML file and create a new PDF File
                     */
                    JRDesignQuery newQuery = new JRDesignQuery();
                    newQuery.setText(sql);
                    jd.setQuery(newQuery);
                    JasperReport jr = JasperCompileManager.compileReport(jd);
                    JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
                    reportFileURL = getClass().getResource("../jaspertemplates/CrawledResults.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    JasperExportManager.exportReportToPdfFile(jp, reportFile.getAbsolutePath());

                    /*
                     * Take PDF file as a input through FileInputStream
                     */
                    reportFileURL = getClass().getResource("../jaspertemplates/CrawledResults.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileInputStream fis = new FileInputStream(reportFile);

                    /*
                     * Read the PDF Files
                     */
                    PdfReader file = new PdfReader(fis);

                    /*
                     * Give the Resulting PDF location
                     */
                    reportFileURL = getClass().getResource("../jaspertemplates/Result.pdf");
                    reportFile = new File(reportFileURL.toURI());
                    FileOutputStream fos = new FileOutputStream(reportFile);
                    PdfCopyFields copy = new PdfCopyFields(fos);

                    /*
                     * Copy the all contents of the PDF files data into one file
                     */
                    copy.addDocument(file);
                    copy.close();

                    System.out.println("Done ...");
                    ServletOutputStream outStream = objResponse.getOutputStream();
                    objResponse.setContentType("application/pdf");
                    objResponse.setHeader("Content-Disposition", "attachment; filename=\"" + fileName);
                    byte[] byteBuffer = new byte[BUFSIZE];
                    int length = 0;

                    objResponse.setContentLength((int) reportFile.length());
                    DataInputStream in = new DataInputStream(new FileInputStream(reportFile));

                    // reads the file's bytes and writes them to the objResponse stream
                    while ((in != null) && ((length = in.read(byteBuffer)) != -1)) {
                        outStream.write(byteBuffer, 0, length);
                    }

                    in.close();
                    outStream.close();

                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | URISyntaxException | JRException | IOException | DocumentException e) {
                    e.printStackTrace();
                }

            } catch (NumberFormatException | DataAccessResourceFailureException | IllegalStateException | HibernateException e) {
                e.printStackTrace();
            }
        }
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
}