/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
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
}
