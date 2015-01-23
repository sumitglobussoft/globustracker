/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import ranktracker.entity.Displaysettings;
import ranktracker.entity.Seokeyworddetails;
import ranktracker.entity.Serpkeywords;
import ranktracker.form.KeywordsLastUpdatedForm;
import ranktracker.form.RankComparision;
import ranktracker.service.KeywordsService;
import ranktracker.service.SettingsService;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class SerpsKeywordsAction extends ActionSupport {

    public SerpsKeywordsAction() {
    }
    private String editkeywordId;
    private String editarrKeywords;
    private String editurl;
    private String editlinkGoogle;
    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;

    private HttpServletResponse objResponse;
    /**
     * objKeywordsService The service layer object variable for KeywordsService
     * object
     */
    private KeywordsService objKeywordsService;
    /**
     * lstkeywords The list containing Keywords objects
     */
    private List<Serpkeywords> lstkeywords;
    /**
     * lstkeywordslastupdate The list containing Keywords object
     */
    private List<KeywordsLastUpdatedForm> lstkeywordslastupdate;
    private Set<KeywordsLastUpdatedForm> setkeywordslastupdate;
    private List<KeywordsLastUpdatedForm> lstsocialsignalupdate;

    private List<Serpkeywords> lstUpdatedKeywords;
    private List<Seokeyworddetails> lstSeoDetails;
    /**
     * campaignId The tempKeywords are retrieved for the campaignid received
     * from frontend
     */
    private Integer campaignId;
    /**
     * campaignName The campaign name for given campaignid
     */
    private String campaignName;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * jString The Json string received from ajax call
     */
    private String jString;
    /**
     * message The ajax string variable to store action message
     */
    private String message;
    /**
     * arrKeywords The Json string received from ajax call containing keyword
     * strings
     */
    private String arrKeywords;
    /**
     * url The Json string received from ajax call containing url string
     */
    private String url;
    /**
     * linkGoogle The Json string received from ajax call containing google link
     * string
     */
    private String linkGoogle;
    /**
     * keywordId The Json string received from ajax call containing keywordid of
     * a keyword being edited
     */
    private String keywordId;
    /**
     * matchRank The Json string received from ajax call containing best match
     * rank of a keyword being edited
     */
    private String matchRank;
    /**
     * matchLink The Json string received from ajax call containing best match
     * link of a keyword being edited
     */
    private String matchLink;
    /**
     * engine The Json string received from ajax call containing search engine
     * name of a keyword being edited
     */
    private String engine;
    /**
     * customerId variable to get the customer id
     */
    Integer customerId;
    /**
     *
     */
    private String goalrank;
    /**
     *
     */
    private String dategoal;
    /**
     * lstDisplaysettings to get list of rows from table Displaysettings
     */
    private List<Displaysettings> lstDisplaysettings;
    /**
     * objSettingsService The service layer object variable for SettingsService
     * object
     */
    private SettingsService objSettingsService;
    /**
     * rankComparision holds the rank
     */
    private RankComparision rankComparision;

    /**
     * The method retrieves tempKeywords based on campaign id
     *
     * @return struts return value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        setkeywordslastupdate = new HashSet<>();

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        List lst = null;
        //initializing http session object
        objSession = objRequest.getSession();
        String alerts = (String) objSession.getAttribute("alerts");
        if ("on".equals(alerts)) {
            lstkeywords = (List<Serpkeywords>) objSession.getAttribute("lstkeywords");
            objSession.removeAttribute("lstkeywords");
            objSession.removeAttribute("alerts");
            return SUCCESS;
        }

        try {
            //checking for 'customerID' attribute in session
            if (objSession.getAttribute("customerID") != null) {
                if (objRequest.getParameter("campaignId") != null) {
                    campaignId = Integer.valueOf(objRequest.getParameter("campaignId"));
                } else {

                    //reading the 'campaignID' from session and type casting it to integer
                    campaignId = Integer.valueOf(objSession.getAttribute("campaignId").toString());
                }
                objSession.setAttribute("campaignId", campaignId);
                customerId = Integer.parseInt(objSession.getAttribute("customerID").toString());
                //retrieving the list of keywords object from getData method of KeywordsServiceImpl for <campaignId>
                Object[] dataObject = objKeywordsService.getSerpData(campaignId, customerId);
                lstUpdatedKeywords = (List<Serpkeywords>) dataObject[0];
                lstsocialsignalupdate = (List<KeywordsLastUpdatedForm>) dataObject[1];
                lstSeoDetails = (List<Seokeyworddetails>) dataObject[3];
                int count5 = 0;
                int count10 = 0;
                int count20 = 0;
                int count30 = 0;
                int count100 = 0;
                int keywordcount = lstUpdatedKeywords.size();
                int keyrank;
                rankComparision = new RankComparision();
                if (!lstUpdatedKeywords.isEmpty()) {
                    Iterator itr = lstUpdatedKeywords.iterator();
                    while (itr.hasNext()) {
                        Serpkeywords keys = (Serpkeywords) itr.next();
                        keyrank = keys.getRankGoogle();
                        if (keyrank <= 5 & keyrank != 0) {
                            count5++;
                        }
                        if (keyrank <= 10 & keyrank != 0) {
                            count10++;
                        }
                        if (keyrank <= 20 & keyrank != 0) {
                            count20++;
                        }
                        if (keyrank <= 30 & keyrank != 0) {
                            count30++;
                        }
                        if (keyrank <= 100 & keyrank != 0) {
                            count100++;
                        }
                    }
                    rankComparision.setKeywordsRankBelow5(count5);
                    rankComparision.setKeywordsRankBelow10(count10);
                    rankComparision.setKeywordsRankBelow20(count20);
                    rankComparision.setKeywordsRankBelow30(count30);
                    rankComparision.setKeywordsRankBelow100(count100);
                    rankComparision.setTotalkeywords(keywordcount);
                }

                campaignName = dataObject[2].toString();
                if (objSession.getAttribute("message") != null) {
                    addActionMessage(objSession.getAttribute("message").toString());
                    objSession.removeAttribute("message");
                }

                lstDisplaysettings = objKeywordsService.getCustomerSettings(customerId);
                // if the lstDisplaysettings object will become null the below code add one Displaysettings object to the lstDisplaysettings object

                if (lstDisplaysettings.isEmpty()) {
                    lstDisplaysettings = new ArrayList<>();
                    Displaysettings d = new Displaysettings(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);// making all tab active 
                    lstDisplaysettings.add(d);// adding to array list
                }

                objRequest.setAttribute("highlight", "CAMPAIGNS");
                return SUCCESS;

            }
        } catch (Exception e) {
            e.printStackTrace();
            return LOGIN;
        }
        return LOGIN;
    }

    /**
     * This method is used in a web service(limitedserpskeywords.action) that
     * returns 100 seokeywords details, 100 serpkeywords details & social signal
     * details in the JSON format by each time it is invoked
     *
     * @author rinkesh jha
     * @throws Exception
     */
    public void getLimitedSerps() throws Exception {

        objResponse = ServletActionContext.getResponse();//getting response object
        PrintWriter out = objResponse.getWriter();

        JSONObject result = new JSONObject();// declaring & creating the JSONObject

        //initializing http request object
        objRequest = ServletActionContext.getRequest();//getting request object
        //initializing http session object
        objSession = objRequest.getSession();//getting session object

        try {

            System.out.println("CUSTOMER ID : " + objSession.getAttribute("customerID"));

            //checking for initial value(It is used for the starting row number)
            if (objRequest.getParameter("initial") != null) {
                if (objSession.getAttribute("customerID") != null) { //checking for customer id
                    if (objRequest.getParameter("campaignId") != null) { //checking for campaignId

                        campaignId = Integer.parseInt(objRequest.getParameter("campaignId"));
                        customerId = Integer.parseInt(objSession.getAttribute("customerID").toString());
                        int initial = Integer.parseInt(objRequest.getParameter("initial"));

                        //retrieving the list of keywords object from getData method of KeywordsServiceImpl for <campaignId>
                        Object[] dataObject = objKeywordsService.getSerpDataLimited(campaignId, customerId, initial);//getting all the serps & seo data
                        lstUpdatedKeywords = (List<Serpkeywords>) dataObject[0];// assigning serpskeywords data
                        lstSeoDetails = (List<Seokeyworddetails>) dataObject[1];//assigning seokeywords data
                        lstDisplaysettings = objKeywordsService.getCustomerSettings(customerId);// getting display settings of that particular customerId

                        // if the lstDisplaysettings object will become null the below code add one Displaysettings object to the lstDisplaysettings object
                        if (lstDisplaysettings.isEmpty()) {
                            Displaysettings d = new Displaysettings(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
                            lstDisplaysettings.add(d);
                        }

                        // FETCHING OF DISPLAY SETTINGS & MAKING JSON
                        //making display settings json 
                        JSONObject jsonDisplaySettings = new JSONObject();

                        //putting all the display settings into the jsonDisplaySettings object
                        jsonDisplaySettings.put("Googletab", lstDisplaysettings.get(0).getGoogletab());
                        jsonDisplaySettings.put("Yahootab", lstDisplaysettings.get(0).getYahootab());
                        jsonDisplaySettings.put("Bingtab", lstDisplaysettings.get(0).getBingtab());
                        jsonDisplaySettings.put("Daychangetab", lstDisplaysettings.get(0).getDaychangetab());
                        jsonDisplaySettings.put("Weekchangetab", lstDisplaysettings.get(0).getWeekchangetab());
                        jsonDisplaySettings.put("Monthchangetab", lstDisplaysettings.get(0).getMonthchangetab());
                        jsonDisplaySettings.put("Alexatab", lstDisplaysettings.get(0).getAlexatab());
                        jsonDisplaySettings.put("Backlinkstab", lstDisplaysettings.get(0).getBacklinkstab());
                        jsonDisplaySettings.put("Monthlysearchstab", lstDisplaysettings.get(0).getMonthlysearchstab());
                        jsonDisplaySettings.put("Serpcampaigntab", lstDisplaysettings.get(0).getSerpcampaigntab());
                        jsonDisplaySettings.put("Videocampaigntab", lstDisplaysettings.get(0).getVideocampaigntab());

                        result.put("displaySettings", jsonDisplaySettings);// adding the displaySettings JSON to main result JSON

                        // FETCHING SERPS KEYWORDS & MAKING JSON
                        int i = 0;
                        try {
                            // creating JSON array of serps keywords that contain collection of different serpkeywords
                            JSONArray serpkeywordArray = new JSONArray();
                            for (Serpkeywords updatedKeywords : lstUpdatedKeywords) {

                                if (i >= initial && i <= (initial + 49)) {// cheking for initial values
                                    JSONObject keyword = new JSONObject(); // making single row JSON object for a serp keyword

                                    // putting all the attributes in keyword object
                                    keyword.put("KeywordID", updatedKeywords.getKeywordID());
                                    //keyword.put("CampaignID", updatedKeywords.getCampaignID());
                                    keyword.put("Url", updatedKeywords.getUrl());
                                    keyword.put("Keyword", updatedKeywords.getKeyword());
                                    keyword.put("LinkGoogle", updatedKeywords.getLinkGoogle());
                                    keyword.put("Region", updatedKeywords.getRegion());
                                    keyword.put("RankGoogle", updatedKeywords.getRankGoogle());
                                    keyword.put("BestMatchRankGoogle", updatedKeywords.getBestMatchRankGoogle());
                                    keyword.put("BestMatchLinkGoogle", updatedKeywords.getBestMatchLinkGoogle());
                                    keyword.put("GooglePageRank", updatedKeywords.getGooglePageRank());
                                    keyword.put("RankBing", updatedKeywords.getRankBing());
                                    keyword.put("BestMatchRankBing", updatedKeywords.getBestMatchRankBing());
                                    keyword.put("RankYahoo", updatedKeywords.getRankYahoo());
                                    keyword.put("BestMatchRankYahoo", updatedKeywords.getBestMatchRankYahoo());
                                    keyword.put("BestMatchLinkYahoo", updatedKeywords.getBestMatchLinkYahoo());
                                    keyword.put("RankGoogleDayChange", updatedKeywords.getRankGoogleDayChange());
                                    keyword.put("RankGoogleWeekChange", updatedKeywords.getRankGoogleWeekChange());
                                    keyword.put("RankGoogleMonthChange", updatedKeywords.getRankGoogleMonthChange());
                                    keyword.put("RankBingDayChange", updatedKeywords.getRankBingDayChange());
                                    keyword.put("RankBingWeekChange", updatedKeywords.getRankBingWeekChange());
                                    keyword.put("RankBingMonthChange", updatedKeywords.getRankBingMonthChange());
                                    keyword.put("RankYahooDayChange", updatedKeywords.getRankYahooDayChange());
                                    keyword.put("RankYahooWeekChange", updatedKeywords.getRankGoogleWeekChange());
                                    keyword.put("RankYahooMonthChange", updatedKeywords.getRankYahooMonthChange());
                                    keyword.put("GoogleUpdatedDate", updatedKeywords.getGoogleUpdatedDate());
                                    keyword.put("YahooUpdateDate", updatedKeywords.getYahooUpdateDate());
                                    keyword.put("BingUpdateDate", updatedKeywords.getBingUpdateDate());
                                    keyword.put("Visibility", updatedKeywords.getVisibility());

                                    //adding this single JSON object to main JSON array of serp keywords
                                    serpkeywordArray.put(keyword);
                                }
                                i++;
                            }

                            //adding the serpkeywordArray to the main result JSON object
                            result.put("serpskeywords", serpkeywordArray);

                        } catch (Exception ea) {
                        }

                        // FETCHING SEO KEYWORDS & MAKING JSON
                        i = 0;
                        try {
                            // creating JSON array of seo keywords that contain collection of different seokeywords
                            JSONArray seokeywordArray = new JSONArray();
                            for (Seokeyworddetails seoKeyword : lstSeoDetails) {

                                if (i >= initial && i <= (initial + 49)) {// cheking for initial values
                                    // making single row JSON object for a seo keyword
                                    JSONObject keyword = new JSONObject();

                                    // putting all the attributes in keyword object
                                    keyword.put("SEOKeywordId", seoKeyword.getSEOKeywordId());
                                    // keyword.put("CampaignID",seoKeyword.getCampaignID());
                                    // keyword.put("KeywordID", seoKeyword.getKeywordID());
                                    keyword.put("Url", seoKeyword.getUrl());
                                    keyword.put("Keyword", seoKeyword.getKeyword());
                                    keyword.put("SearchVolume", seoKeyword.getSearchVolume());
                                    keyword.put("GoogleCPC", seoKeyword.getGoogleCPC());
                                    keyword.put("KeywordCompetition", seoKeyword.getKeywordCompetition());
                                    keyword.put("NumberofResult", seoKeyword.getNumberofResult());
                                    keyword.put("GooglePA", seoKeyword.getGooglePA());
                                    keyword.put("GoogleDA", seoKeyword.getGoogleDA());
                                    keyword.put("SiteIndexing", seoKeyword.getSiteIndexing());
                                    keyword.put("AddedDate", seoKeyword.getAddedDate());
                                    keyword.put("RankPage", seoKeyword.getRankPage());
                                    keyword.put("RankAlexa", seoKeyword.getRankAlexa());
                                    keyword.put("CountBackLinks", seoKeyword.getCountBackLinks());
                                    keyword.put("CountMonthlySearches", seoKeyword.getCountMonthlySearches());
                                    keyword.put("Visibility", seoKeyword.getVisibility());

                                    //adding this single JSON object to main JSON array of seo keywords
                                    seokeywordArray.put(keyword);
                                }
                                i++;
                            }

                            //adding the seokeywordArray to the main result JSON object
                            result.put("seokeywords", seokeywordArray);

                        } catch (Exception ea) {
                        }

                    } else {
                        result.put("result", "No campaigns id");
                    }
                } else {
                    result.put("result", "No customer id");
                }
            } else {
                result.put("result", "No initial value");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", "invalid");
        }
        objResponse.setContentType("text");
        objResponse.setHeader("Cache-Control", "no-cache");
        out.write(result.toString());

    }

    /**
     * The method adds a new keyword to database
     *
     * @return struts return value
     */
    public String addSerpsKeyword() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            if (!arrKeywords.equals("")) {
                String[] tempKeywords = arrKeywords.split("\n");
                List lstKeywords = new ArrayList();
                for (int i = 0; i < tempKeywords.length; i++) {
                    if (tempKeywords[i] == null || tempKeywords[i].equals("") || tempKeywords[i].isEmpty() || tempKeywords[i].length() > 100) {
                        continue;
                    }
                    lstKeywords.add(tempKeywords[i].trim());
                }
//                engine = 
                Integer customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
//                System.out.println("customerID ======= " + customerID);
                Integer campaignID = Integer.parseInt(objSession.getAttribute("campaignId").toString());
//                System.out.println("campaignID ======= " + campaignID);

                //checking the remaining quota for customer
                int quota = objKeywordsService.checkKeywordQuota(customerID);
                if (quota > 0) {

                    //if quota >0
                    int allowedQuota = quota - tempKeywords.length;
                    engine = linkGoogle;

                    if (allowedQuota >= 0) {

                        //remove http,https,www, and end /
                        url = url.replace("https://", "").replace("http://", "").replace("www.", "");
                        if (url.endsWith("/")) {
                            url = url.substring(0, url.length() - 1);
                        }

                        //Now check for url emptiness and exceed size
                        if (url == null || url.isEmpty() || url.equals("")) {
                            message = "Url Not Provided";
                            return SUCCESS;
                        } else if (url.length() > 200) {
                            message = "Url Length Exceed";
                            return SUCCESS;
                        }

                        int addKeyword = 0;
                        //if adding the best match from UI then engine value may be 'google','bing' or 'yahoo'
                        if (engine != null) {
                            addKeyword = objKeywordsService.addKeyword(lstKeywords, campaignID, url, linkGoogle, matchLink, matchRank, engine);
                        } else {
                            //addKeyword = objKeywordsService.addBestMatchKeyword(lstKeywords, campaignId, url, linkGoogle, matchLink, matchRank, engine);
                        }
                        if (addKeyword == -1) {
                            objSession.setAttribute("keywordsize", "");
                            message = "Keyword Size Exceed";
                        } else if (addKeyword == -10) {
                            message = "Sorry, Keyword already exist in this Campaign";
                        } else if (addKeyword == 0) {
                            message = "You cannot add this url in the campaign. Please create a new campaign";
                        } else {
                            message = "Keywords Added. It will take sometime to refresh the rankings.";
                        }
                    } else {
                        message = "Sorry you can add " + quota + " Keywords";
                    }
                } else {
                    message = "Sorry your Quota has been Completed ";
                }
                objSession.setAttribute("campaignId", campaignID);
            } else {
                message = "Keyword Required";
            }
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
        objSession.setAttribute("message", message);
        return SUCCESS;
    }

    /**
     * The method edits/updates a given keyword
     *
     * @return struts return value
     */
    public String editSerpsKeyword() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();
        System.out.println("-------------------------");
        if (objSession.getAttribute("customerID") != null) {
            System.out.println("KeywordID = " + editkeywordId);
            System.out.println("arrKeywords = " + editarrKeywords);
            System.out.println("url = " + editurl);
            System.out.println("linkGoogle = " + editlinkGoogle);

            int n = objKeywordsService.editKeyword(Integer.parseInt(editkeywordId), editarrKeywords, editurl, editlinkGoogle,
                    Integer.parseInt(objSession.getAttribute("campaignId").toString()));

            if (n == 1) {
                message = "Keyword Edited";
            } else if (n == 2) {
                message = "You cannot add this url in the campaign. Please create a new campaign";
            } else {
                message = "Sorry, This Keyword already exist in this Campaign";
            }
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
        objSession.setAttribute("message", message);
        return SUCCESS;
    }

    /**
     * The method deletes a given keyword based on keyword id
     *
     * @return struts return value
     */
    public String deleteSerpsKeyword() {
        System.out.println("---------Delete---------");
        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            Integer keywordID = Integer.parseInt(jString);
            Integer campaignID = Integer.parseInt(objSession.getAttribute("campaignId").toString());
            objKeywordsService.deleteKeyword(keywordID, campaignID);
            message = "Keyword has been Deleted";
            System.out.println("message ======================= " + message);
            objSession.setAttribute("message", message);
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method adds better ranking keyword to database
     *
     * @return struts return value
     */
    public String addBetterRankingKeyword() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            Integer keywordId = Integer.parseInt(jString);

            //adding the better ranking keyword
            objKeywordsService.addBetterRankingKeyword(keywordId);
            message = "Keyword has been added";
            objSession.setAttribute("message", message);
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     *
     */
    public String addSerpsKeywordGoal() {

        objRequest = ServletActionContext.getRequest();

        objSession = objRequest.getSession();
        int i = 0;
        if (objSession.getAttribute("customerID") != null) {
            Integer keywordID = Integer.parseInt(keywordId);
            System.out.println("keywordID = " + keywordID);
            Integer goalRank = Integer.parseInt(goalrank);
            System.out.println("goalRank = " + goalRank);
            System.out.println("dategoal = " + dategoal);
            if (goalRank < 1 || goalRank > 502) {
                i = 2;
            } else {
                i = objKeywordsService.setSerpsKeywordGoal(keywordID, goalRank, dategoal);
            }
        }
        if (i == 1) {
            message = "Goal Added";
            objSession.setAttribute("message", message);
            return SUCCESS;
        } else if (i == 2) {
            message = "Improper Rank!! Set Valid Rank !";
            objSession.setAttribute("message", message);
            return SUCCESS;
        } else {
            message = "Goal has not been added";
            objSession.setAttribute("message", message);
            return SUCCESS;
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
     * @return arrKeywords
     */
    public String getArrKeywords() {
        return arrKeywords;
    }

    /**
     *
     * @param arrKeywords
     */
    public void setArrKeywords(String arrKeywords) {
        this.arrKeywords = arrKeywords;
    }

    /**
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return linkGoogle
     */
    public String getLinkGoogle() {
        return linkGoogle;
    }

    /**
     *
     * @param linkGoogle
     */
    public void setLinkGoogle(String linkGoogle) {
        this.linkGoogle = linkGoogle;
    }

    /**
     *
     * @return keywordId
     */
    public String getKeywordId() {
        return keywordId;
    }

    /**
     *
     * @param keywordId
     */
    public void setKeywordId(String keywordId) {
        this.keywordId = keywordId;
    }

    /**
     *
     * @return campaignName
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     *
     * @param campaignName
     */
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    /**
     *
     * @return matchLink
     */
    public String getMatchLink() {
        return matchLink;
    }

    /**
     *
     * @param matchLink
     */
    public void setMatchLink(String matchLink) {
        this.matchLink = matchLink;
    }

    /**
     *
     * @return matchRank
     */
    public String getMatchRank() {
        return matchRank;
    }

    /**
     *
     * @param matchRank
     */
    public void setMatchRank(String matchRank) {
        this.matchRank = matchRank;
    }

    /**
     *
     * @return engine
     */
    public String getEngine() {
        return engine;
    }

    /**
     *
     * @param engine
     */
    public void setEngine(String engine) {
        this.engine = engine;
    }

    public HttpServletRequest getObjRequest() {
        return objRequest;
    }

    public void setObjRequest(HttpServletRequest objRequest) {
        this.objRequest = objRequest;
    }

    public List<Serpkeywords> getLstkeywords() {
        return lstkeywords;
    }

    public void setLstkeywords(List<Serpkeywords> lstkeywords) {
        this.lstkeywords = lstkeywords;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public HttpSession getObjSession() {
        return objSession;
    }

    public void setObjSession(HttpSession objSession) {
        this.objSession = objSession;
    }

    public String getjString() {
        return jString;
    }

    public void setjString(String jString) {
        this.jString = jString;
    }

    public String getEditkeywordId() {
        return editkeywordId;
    }

    public void setEditkeywordId(String editkeywordId) {
        this.editkeywordId = editkeywordId;
    }

    public String getEditarrKeywords() {
        return editarrKeywords;
    }

    public void setEditarrKeywords(String editarrKeywords) {
        this.editarrKeywords = editarrKeywords;
    }

    public String getEditurl() {
        return editurl;
    }

    public void setEditurl(String editurl) {
        this.editurl = editurl;
    }

    public String getEditlinkGoogle() {
        return editlinkGoogle;
    }

    public void setEditlinkGoogle(String editlinkGoogle) {
        this.editlinkGoogle = editlinkGoogle;
    }

    public List<Displaysettings> getLstDisplaysettings() {
        return lstDisplaysettings;
    }

    public void setLstDisplaysettings(List<Displaysettings> lstDisplaysettings) {
        this.lstDisplaysettings = lstDisplaysettings;
    }

    public List<KeywordsLastUpdatedForm> getLstkeywordslastupdate() {
        return lstkeywordslastupdate;
    }

    public void setLstkeywordslastupdate(List<KeywordsLastUpdatedForm> lstkeywordslastupdate) {
        this.lstkeywordslastupdate = lstkeywordslastupdate;
    }

    public String getGoalrank() {
        return goalrank;
    }

    public void setGoalrank(String goalrank) {
        this.goalrank = goalrank;
    }

    public String getDategoal() {
        return dategoal;
    }

    public void setDategoal(String dategoal) {
        this.dategoal = dategoal;
    }

    public Set<KeywordsLastUpdatedForm> getSetkeywordslastupdate() {
        return setkeywordslastupdate;
    }

    public void setSetkeywordslastupdate(Set<KeywordsLastUpdatedForm> setkeywordslastupdate) {
        this.setkeywordslastupdate = setkeywordslastupdate;
    }

    public List<KeywordsLastUpdatedForm> getLstsocialsignalupdate() {
        return lstsocialsignalupdate;
    }

    public void setLstsocialsignalupdate(List<KeywordsLastUpdatedForm> lstsocialsignalupdate) {
        this.lstsocialsignalupdate = lstsocialsignalupdate;
    }

    public RankComparision getRankComparision() {
        return rankComparision;
    }

    public void setRankComparision(RankComparision rankComparision) {
        this.rankComparision = rankComparision;
    }

    public List<Serpkeywords> getLstUpdatedKeywords() {
        return lstUpdatedKeywords;
    }

    public void setLstUpdatedKeywords(List<Serpkeywords> lstUpdatedKeywords) {
        this.lstUpdatedKeywords = lstUpdatedKeywords;
    }

    public List<Seokeyworddetails> getLstSeoDetails() {
        return lstSeoDetails;
    }

    public void setLstSeoDetails(List<Seokeyworddetails> lstSeoDetails) {
        this.lstSeoDetails = lstSeoDetails;
    }

    public HttpServletResponse getObjResponse() {
        return objResponse;
    }

    public void setObjResponse(HttpServletResponse objResponse) {
        this.objResponse = objResponse;
    }

}
