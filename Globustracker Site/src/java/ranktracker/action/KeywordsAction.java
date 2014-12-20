/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Serpkeywords;
import ranktracker.service.KeywordsService;

/**
 * Action layer class for actions initiated for tempKeywords module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class KeywordsAction extends ActionSupport {

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
     * The method retrieves tempKeywords based on campaign id
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
        String alerts = (String) objSession.getAttribute("alerts");
        if ("on".equals(alerts)) {
            lstkeywords = (List<Serpkeywords>) objSession.getAttribute("lstkeywords");
            objSession.removeAttribute("lstkeywords");
            objSession.removeAttribute("alerts");
            return SUCCESS;
        }

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            if (objRequest.getParameter("campaignId") != null) {
                campaignId = Integer.valueOf(objRequest.getParameter("campaignId"));
            } else {

                //reading the 'campaignID' from session and type casting it to integer
                campaignId = Integer.valueOf(objSession.getAttribute("campaignId").toString());
            }
            objSession.setAttribute("campaignId", campaignId);
            int customerId = Integer.parseInt(objSession.getAttribute("customerID").toString());
            //retrieving the list of keywords object from getData method of KeywordsServiceImpl for <campaignId>
            Object[] dataObject = objKeywordsService.getData(campaignId,customerId);
            lstkeywords = (List<Serpkeywords>) dataObject[0];
            campaignName = dataObject[1].toString();
            if (objSession.getAttribute("message") != null) {
                addActionMessage(objSession.getAttribute("message").toString());
                objSession.removeAttribute("message");
            }
            objRequest.setAttribute("highlight", "CAMPAIGN");
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method adds a new keyword to database
     *
     * @return struts return value
     */
    public String addKeyword() {

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
                Integer customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
                Integer campaignId = Integer.parseInt(objSession.getAttribute("campaignId").toString());

                //checking the remaining quota for customer
                int quota = objKeywordsService.checkKeywordQuota(customerID);
                if (quota > 0) {

                    //if quota >0
                    int allowedQuota = quota - tempKeywords.length;

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
                        if (engine == null) {
                            addKeyword = objKeywordsService.addKeyword(lstKeywords, campaignId, url, linkGoogle, matchLink, matchRank, engine);
                        } else {
                           // addKeyword = objKeywordsService.addBestMatchKeyword(lstKeywords, campaignId, url, linkGoogle, matchLink, matchRank, engine);
                        }
                        if (addKeyword == -1) {
                            objSession.setAttribute("keywordsize", "");
                            message = "Keyword Size Exceed";
                        } 
                        if (addKeyword == -10) {
                            message = "Sorry This Keyword and Url already exist in this Campaign";
                        } 
                        if (addKeyword == 0) {
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
                objSession.setAttribute("campaignId", campaignId);
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
    public String editKeyword() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();
        if (objSession.getAttribute("customerID") != null) {

            //invoking the deleteKeyword method to first delete the keyword 
            //means removing the old mapping from campaigns and keywords
            //and creating the new mapping for keyword and campaign
            objKeywordsService.deleteKeyword(Integer.parseInt(keywordId),
                    Integer.parseInt(objSession.getAttribute("campaignId").toString()));
//            objKeywordsService.addKeyword(new String[]{arrKeywords}, Integer.parseInt(objSession.getAttribute("campaignId").toString()),
//                    url, linkGoogle, matchLink, matchRank, engine);
            message = "Keyword Edited";
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
    public String deleteKeyword() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            Integer keywordId = Integer.parseInt(jString);
            Integer campaignId = Integer.parseInt(objSession.getAttribute("campaignId").toString());
            objKeywordsService.deleteKeyword(keywordId, campaignId);
            message = "Keyword has been Deleted";
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

    public HttpServletRequest getObjRequest() {
        return objRequest;
    }

    public void setObjRequest(HttpServletRequest objRequest) {
        this.objRequest = objRequest;
    }

    public KeywordsService getObjKeywordsService() {
        return objKeywordsService;
    }

    public void setObjKeywordsService(KeywordsService objKeywordsService) {
        this.objKeywordsService = objKeywordsService;
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

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getArrKeywords() {
        return arrKeywords;
    }

    public void setArrKeywords(String arrKeywords) {
        this.arrKeywords = arrKeywords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLinkGoogle() {
        return linkGoogle;
    }

    public void setLinkGoogle(String linkGoogle) {
        this.linkGoogle = linkGoogle;
    }

    public String getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(String keywordId) {
        this.keywordId = keywordId;
    }

    public String getMatchRank() {
        return matchRank;
    }

    public void setMatchRank(String matchRank) {
        this.matchRank = matchRank;
    }

    public String getMatchLink() {
        return matchLink;
    }

    public void setMatchLink(String matchLink) {
        this.matchLink = matchLink;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
   
  
}
