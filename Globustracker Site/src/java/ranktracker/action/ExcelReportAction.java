/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Seokeyworddetails;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Videokeywords;
import ranktracker.service.KeywordsService;
import ranktracker.entity.Socialsignalurls;
import ranktracker.form.KeywordsLastUpdatedForm;

/**
 * Action layer class for actions initiated for excel report generation module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class ExcelReportAction {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * objResponse The HttpServletResponse object
     */
    private HttpServletResponse objResponse;
    /**
     * objHttpSession The HttpSession object
     */
    private HttpSession objHttpSession;
    /**
     * objKeywordsService The service layer object variable for KeywordsService
     * object
     */
    private KeywordsService objKeywordsService;
    /**
     * lstkeywords The list containing Keywords objects
     */
    private List<Serpkeywords> lstkeywords;
    private List<Videokeywords> lstvideokeywords;
    private List<KeywordsLastUpdatedForm> lstkeywordslastupdate;
    private List<KeywordsLastUpdatedForm> lstsocialsignalupdate;
    private static final int BUFSIZE = 4096;

    private List<Serpkeywords> lstUpdatedKeywords;
    private List<Seokeyworddetails> lstSeoDetails;

    /**
     * The method streams generated excel sheet to client
     *
     * @throws Exception
     */
    public void execute() throws Exception {

        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {

            //initializing http session object
            objRequest = ServletActionContext.getRequest();
            objResponse = ServletActionContext.getResponse();

            Integer campaignID = Integer.parseInt(objRequest.getParameter("campaignId"));
            String campaignname = objRequest.getParameter("campaignName");

            if (campaignname.contains(" ")) {
                campaignname = campaignname.replace(" ", "");
            }
            int customerId = Integer.parseInt(objHttpSession.getAttribute("customerID").toString());
            //now invoking the getData method of KeywordsServiceImpl class
            Object[] dataObject = objKeywordsService.getSerpData(campaignID, customerId);
            lstUpdatedKeywords = (List<Serpkeywords>) dataObject[0];
            lstsocialsignalupdate = (List<KeywordsLastUpdatedForm>) dataObject[1];
            lstSeoDetails = (List<Seokeyworddetails>) dataObject[3];

            HSSFWorkbook objWorkbook = null;

            //name of excel file
            String fileName = getShowPage() + "tmp/" + campaignname + ".xls";

            //calling the createSerpExcelWorkBook method to create the <objWorkbook> object
            objWorkbook = createSerpExcelWorkBook(true, lstUpdatedKeywords, lstSeoDetails, lstsocialsignalupdate, campaignname);

            FileOutputStream fileOut = new FileOutputStream(fileName);
            objWorkbook.write(fileOut);
            fileOut.close();

            ServletOutputStream outStream = objResponse.getOutputStream();

            FileInputStream in = new FileInputStream(fileName);

            objResponse.setContentType("application/excel");

            // sets HTTP header attachment; filename=\"report.pdf\"
            objResponse.setHeader("Content-Disposition", "attachment; filename=" + campaignname + ".xls");

            // reads the file's bytes and writes them to the objResponse stream
            int length;
            while ((length = in.read()) != -1) {
                outStream.write(length);
            }
            in.close();
            outStream.close();
        }
    }

    /**
     * The method streams generated excel sheet to client
     *
     * @throws Exception
     */
    public void getExcelReportsForVideo() throws Exception {

        //initializing http session object
        objHttpSession = ServletActionContext.getRequest().getSession();

        //checking for 'customerID' attribute in session
        if (objHttpSession.getAttribute("customerID") != null) {

            //initializing http session object
            objRequest = ServletActionContext.getRequest();
            objResponse = ServletActionContext.getResponse();

            Integer campaignID = Integer.parseInt(objRequest.getParameter("campaignId"));
            String campaignname = objRequest.getParameter("campaignName");

            if (campaignname.contains(" ")) {
                campaignname = campaignname.replace(" ", "");
            }

            int customerId = Integer.parseInt(objHttpSession.getAttribute("customerID").toString());
            //now invoking the getVideoData method of KeywordsServiceImpl class
            Object[] dataObject = objKeywordsService.getVideoData(campaignID, customerId);

            //retrieving the list of keywords from <dataObject>
            lstvideokeywords = (List<Videokeywords>) dataObject[0];
            HSSFWorkbook objWorkbook = null;

            //name of excel file
            String fileName = getShowPage() + "tmp/" + campaignname + ".xls";

            //calling the createVideoExcelWorkBook method to create the <objWorkbook> object
            objWorkbook = createVideoExcelWorkBook(true, lstvideokeywords);

            FileOutputStream fileOut = new FileOutputStream(fileName);
            objWorkbook.write(fileOut);
            fileOut.close();

            ServletOutputStream outStream = objResponse.getOutputStream();

            FileInputStream in = new FileInputStream(fileName);

            objResponse.setContentType("application/excel");

            // sets HTTP header attachment; filename=\"report.pdf\"
            objResponse.setHeader("Content-Disposition", "attachment; filename=" + campaignname + ".xls");

            // reads the file's bytes and writes them to the objResponse stream
            int length;
            while ((length = in.read()) != -1) {
                outStream.write(length);
            }
            in.close();
            outStream.close();
        }
    }

    /**
     * The method returns generated excel sheet to caller function
     *
     * @param lstkeywords
     * @return objWorkbook created workbook
     */
    public HSSFWorkbook serpMailReport(List<Serpkeywords> lstUpdatedKeywords, List<Seokeyworddetails> lstSeoDetails, List<KeywordsLastUpdatedForm> lstsocialsignalupdate, String campaignname) {
        HSSFWorkbook objWorkbook = null;
        objWorkbook = createSerpExcelWorkBook(true, lstUpdatedKeywords, lstSeoDetails, lstsocialsignalupdate, campaignname);
        return objWorkbook;
    }

    /**
     * The method returns generated excel sheet to caller function
     *
     * @param lstkeywords
     * @return objWorkbook created workbook
     */
    public HSSFWorkbook videoMailReport(Object[] dataObj, Integer campaignID) {
        int customerId = Integer.parseInt(objHttpSession.getAttribute("customerID").toString());
        Object[] dataObject = objKeywordsService.getVideoData(campaignID, customerId);
        lstvideokeywords = (List<Videokeywords>) dataObject[0];
        HSSFWorkbook objWorkbook = null;
        objWorkbook = createVideoExcelWorkBook(true, lstvideokeywords);
        return objWorkbook;
    }

    /**
     * The method generates excel sheet for given keywords list
     *
     * @param row
     * @param lstkeywords
     * @return objWorkbook created workbook
     */
    private HSSFWorkbook createSerpExcelWorkBook(boolean row, List<Serpkeywords> lstUpdatedKeywords, List<Seokeyworddetails> lstSeoDetails, List<KeywordsLastUpdatedForm> lstsocialsignalupdate, String campaignname) {

        HSSFWorkbook objWorkbook = new HSSFWorkbook();
        HSSFSheet objSheet = null;
        HSSFRow objRow = null;

        int rownum = 0;
        int rownumseo = 0;
        int rownumsocial = 0;
        boolean a = row;
        boolean b = row;
        boolean c = row;

        objSheet = objWorkbook.createSheet("Serps");
        // wrap column 1 and 2

        objSheet.autoSizeColumn(0, true);
        objSheet.autoSizeColumn(1, true);
        // creating header rows

        for (Serpkeywords objKeyword : lstUpdatedKeywords) {
            if (a) {
                //    rownum = rownum + 2;
                objRow = objSheet.createRow(rownum);
                objRow.createCell(0).setCellValue("Campaign");
                objRow.createCell(1).setCellValue(campaignname);

                rownum++;
                objRow = objSheet.createRow(rownum);
                objRow.createCell(2).setCellValue("Google");
                objSheet.addMergedRegion(new CellRangeAddress(1, 1, 2, 10));
                objRow.createCell(11).setCellValue("Yahoo");
                objSheet.addMergedRegion(new CellRangeAddress(1, 1, 11, 14));
                objRow.createCell(15).setCellValue("Bing");
                objSheet.addMergedRegion(new CellRangeAddress(1, 1, 15, 18));

                //write all headers
                rownum++;
                objRow = objSheet.createRow(rownum);
                objRow.createCell(0).setCellValue("Url");
                objRow.createCell(1).setCellValue("Keyword");
                objRow.createCell(2).setCellValue("Rank");
                objRow.createCell(3).setCellValue("Day Change");
                objRow.createCell(4).setCellValue("Week Change");
                objRow.createCell(5).setCellValue("Month Change");
                objRow.createCell(6).setCellValue("Page Rank");
                objRow.createCell(7).setCellValue("Rank");
                objRow.createCell(8).setCellValue("Day Change");
                objRow.createCell(9).setCellValue("Week Change");
                objRow.createCell(10).setCellValue("Month Change");
                objRow.createCell(11).setCellValue("Rank");
                objRow.createCell(12).setCellValue("Day Change");
                objRow.createCell(13).setCellValue("Week Change");
                objRow.createCell(14).setCellValue("Month Change");

                rownum++;
                a = false;
            }
            if (objKeyword.getKeyword().equals("")) {
                a = true;
                continue;
            }

            try {
                objRow = objSheet.createRow(rownum);

                //writing all the cell values
                objRow.createCell(0).setCellValue(objKeyword.getUrl());
                objRow.createCell(1).setCellValue(objKeyword.getKeyword());
                if (objKeyword.getRankGoogle() == 501) {
                    objRow.createCell(2).setCellValue("N/A");
                } else {
                    objRow.createCell(2).setCellValue(objKeyword.getRankGoogle());
                }
                objRow.createCell(3).setCellValue(objKeyword.getRankGoogleDayChange());
                objRow.createCell(4).setCellValue(objKeyword.getRankGoogleWeekChange());
                objRow.createCell(5).setCellValue(objKeyword.getRankGoogleMonthChange());
                objRow.createCell(6).setCellValue(objKeyword.getGooglePageRank());

                if (objKeyword.getRankYahoo() == 501) {
                    objRow.createCell(7).setCellValue("N/A");
                } else {
                    objRow.createCell(7).setCellValue(objKeyword.getRankYahoo());
                }
                objRow.createCell(8).setCellValue(objKeyword.getRankYahooDayChange());
                objRow.createCell(9).setCellValue(objKeyword.getRankYahooWeekChange());
                objRow.createCell(10).setCellValue(objKeyword.getRankYahooMonthChange());
                if (objKeyword.getRankBing() == 501) {
                    objRow.createCell(11).setCellValue("N/A");
                } else {
                    objRow.createCell(11).setCellValue(objKeyword.getRankBing());
                }
                objRow.createCell(12).setCellValue(objKeyword.getRankBingDayChange());
                objRow.createCell(13).setCellValue(objKeyword.getRankBingWeekChange());
                objRow.createCell(14).setCellValue(objKeyword.getRankBingMonthChange());
                objSheet.setColumnWidth(0, 7500);
                objSheet.setColumnWidth(1, 7500);

                rownum++;
            } catch (Exception e) {
                System.out.println("Exception comes in:::" + rownum);
                e.printStackTrace();
            }
        }

        objSheet = objWorkbook.createSheet("SEO Details");
        // wrap column 1 and 2

        objSheet.autoSizeColumn(0, true);
        objSheet.autoSizeColumn(1, true);
        // creating header rows

        for (Seokeyworddetails objKeyword : lstSeoDetails) {
            if (b) {
                //    rownum = rownum + 2;
                objRow = objSheet.createRow(rownumseo);
                objRow.createCell(0).setCellValue("Campaign");
                objRow.createCell(1).setCellValue(campaignname);

                //write all headers
                rownumseo++;
                objRow = objSheet.createRow(rownum);
                objRow.createCell(0).setCellValue("Url");
                objRow.createCell(1).setCellValue("Keyword");
                objRow.createCell(2).setCellValue("Search Volume");
                objRow.createCell(3).setCellValue("CPC");
                objRow.createCell(4).setCellValue("Competition");
                objRow.createCell(5).setCellValue("Number Of Results");
                objRow.createCell(6).setCellValue("Site Indexing");
                objRow.createCell(7).setCellValue("Alexa");
                objRow.createCell(8).setCellValue("Backlinks");
                objRow.createCell(9).setCellValue("Monthly Searches");
                objRow.createCell(10).setCellValue("Page Authority");
                objRow.createCell(11).setCellValue("Domain Authority");

                rownumseo++;
                b = false;
            }
            if (objKeyword.getKeyword().equals("")) {
                b = true;
                continue;
            }

            try {
                objRow = objSheet.createRow(rownumseo);

                //writing all the cell values
                objRow.createCell(0).setCellValue(objKeyword.getUrl());
                objRow.createCell(1).setCellValue(objKeyword.getKeyword());
                objRow.createCell(2).setCellValue(objKeyword.getSearchVolume());
                objRow.createCell(3).setCellValue(objKeyword.getGoogleCPC());
                objRow.createCell(4).setCellValue(objKeyword.getKeywordCompetition());
                objRow.createCell(5).setCellValue(objKeyword.getNumberofResult());
                objRow.createCell(6).setCellValue(objKeyword.getSiteIndexing());
                objRow.createCell(7).setCellValue(objKeyword.getRankAlexa());
                objRow.createCell(8).setCellValue(objKeyword.getCountBackLinks());
                objRow.createCell(9).setCellValue(objKeyword.getCountMonthlySearches());
                objRow.createCell(10).setCellValue(objKeyword.getGooglePA());
                objRow.createCell(11).setCellValue(objKeyword.getGoogleDA());

                objSheet.setColumnWidth(0, 7500);
                objSheet.setColumnWidth(1, 7500);

                rownumseo++;
            } catch (Exception e) {
                System.out.println("Exception comes in:::" + rownumseo);
                e.printStackTrace();
            }
        }

        objSheet = objWorkbook.createSheet("SocialData");
        // wrap column 1 and 2

        objSheet.autoSizeColumn(0, true);
        objSheet.autoSizeColumn(1, true);
        // creating header rows
        for (KeywordsLastUpdatedForm objUrl : lstsocialsignalupdate) {

            if (c) {
//                rownumsocial = rownumsocial + 2;
                objRow = objSheet.createRow(rownumsocial);
                objRow.createCell(0).setCellValue("Campaign");
                objRow.createCell(1).setCellValue(campaignname);

                rownumsocial = rownumsocial + 2;
                //write all headers
                objRow = objSheet.createRow(rownumsocial);
                objRow.createCell(0).setCellValue("Url");
                objRow.createCell(1).setCellValue("Facebook Likes");
                objRow.createCell(2).setCellValue("Facebook Shares");
                objRow.createCell(3).setCellValue("Twitter Tweets");
                objRow.createCell(4).setCellValue("Pinterest Pins");
                objRow.createCell(5).setCellValue("GooglePlus Likes");
                objRow.createCell(6).setCellValue("LinkedIn Shares");
                objRow.createCell(7).setCellValue("Reddit Votes");
                objRow.createCell(8).setCellValue("StumbleUpon Likes");

                rownumsocial++;
                c = false;
            }

            if (objUrl.getSocialSignalUrl().equals("")) {
                c = true;
                continue;
            }

            try {
                objRow = objSheet.createRow(rownumsocial);

                objRow.createCell(0).setCellValue(objUrl.getSocialSignalUrl());
                objRow.createCell(1).setCellValue(objUrl.getFacebookLike());
                objRow.createCell(2).setCellValue(objUrl.getFacebookShare());
                objRow.createCell(3).setCellValue(objUrl.getTweetCount());
                objRow.createCell(4).setCellValue(objUrl.getPinterestPins());
                objRow.createCell(5).setCellValue(objUrl.getGooglePlusLikes());
                objRow.createCell(6).setCellValue(objUrl.getLinkedInShares());
                objRow.createCell(7).setCellValue(objUrl.getRedittVotes());
                objRow.createCell(8).setCellValue(objUrl.getStumbleUponLikes());
                objSheet.setColumnWidth(0, 7500);
                objSheet.setColumnWidth(1, 7500);

                rownumsocial++;
            } catch (Exception e) {
                System.out.println("Exception comes in:::" + rownumsocial);
                e.printStackTrace();
            }
        }
        return objWorkbook;
    }

    /**
     * The method generates excel sheet for given keywords list
     *
     * @param row
     * @param lstvideokeywords
     * @return objWorkbook created workbook
     */
    public HSSFWorkbook createVideoExcelWorkBook(boolean row, List<Videokeywords> lstvideokeywords) {

        HSSFWorkbook objWorkbook = new HSSFWorkbook();
        HSSFSheet objSheet = null;
        HSSFRow objRow = null;

        objSheet = objWorkbook.createSheet("Videos");
        // wrap column 1 and 2

        objSheet.autoSizeColumn(0, true);
        objSheet.autoSizeColumn(1, true);
        // creating header rows
        int rownum = 0;
        boolean b = row;

        for (Videokeywords objKeyword : lstvideokeywords) {

            if (b) {
//                rownum = rownum + 2;
                Campaigns campaign = objKeyword.getCampaignID();
                objRow = objSheet.createRow(rownum);
                objRow.createCell(0).setCellValue("Campaign");
                objRow.createCell(1).setCellValue(campaign.getCampaign());

                rownum = rownum + 2;
                //write all headers
                objRow = objSheet.createRow(rownum);
                objRow.createCell(0).setCellValue("Keyword");
                objRow.createCell(1).setCellValue("Youtube Url");
                objRow.createCell(2).setCellValue("Youtube Rank");
                objRow.createCell(3).setCellValue("Metacafe Url");
                objRow.createCell(4).setCellValue("Metacafe Rank");
                objRow.createCell(5).setCellValue("Dailymotion Url");
                objRow.createCell(6).setCellValue("DailyMotion Rank");
                objRow.createCell(7).setCellValue("Vimeo Url");
                objRow.createCell(8).setCellValue("Vimeo Rank");
                rownum++;
                b = false;
            }
            if (objKeyword.getVideoKeyword().equals("")) {
                b = true;
                continue;
            }

            try {
                objRow = objSheet.createRow(rownum);

                //writing all the cell values
                objRow.createCell(0).setCellValue(objKeyword.getVideoKeyword());
                objRow.createCell(1).setCellValue(objKeyword.getYoutubeURL());
                if (objKeyword.getRankYoutube() == 501) {
                    objRow.createCell(2).setCellValue("N/A");
                } else {
                    objRow.createCell(2).setCellValue(objKeyword.getRankYoutube());
                }
                objRow.createCell(3).setCellValue(objKeyword.getMetacafeURL());
                if (objKeyword.getRankMetacafe() == 501) {
                    objRow.createCell(4).setCellValue("N/A");
                } else {
                    objRow.createCell(4).setCellValue(objKeyword.getRankMetacafe());
                }
                objRow.createCell(5).setCellValue(objKeyword.getDailymotionURL());
                if (objKeyword.getRankDailyMotion() == 501) {
                    objRow.createCell(6).setCellValue("N/A");
                } else {
                    objRow.createCell(6).setCellValue(objKeyword.getRankDailyMotion());
                }
                objRow.createCell(7).setCellValue(objKeyword.getVimeoURL());
                if (objKeyword.getRankVimeo() == 501) {
                    objRow.createCell(8).setCellValue("N/A");
                } else {
                    objRow.createCell(8).setCellValue(objKeyword.getRankVimeo());
                }
                objSheet.setColumnWidth(0, 7500);
                objSheet.setColumnWidth(1, 7500);

                rownum++;
            } catch (Exception e) {
                System.out.println("Exception comes in:::" + rownum);
                e.printStackTrace();
            }
        }
        return objWorkbook;
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
}
