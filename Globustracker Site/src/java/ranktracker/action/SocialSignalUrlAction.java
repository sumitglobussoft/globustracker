/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.service.KeywordsService;

/**
 *
 * @author GLB-115
 */
public class SocialSignalUrlAction extends ActionSupport {

    public SocialSignalUrlAction() {
    }
    /**
     * addUrl, eurlId, eurl The Json string received from ajax call containing
     * Url for social signals
     */
    private String addUrl;
    private String eurlId;
    private String eurl;
    private String delurlId;
    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * message The ajax string variable to store action message
     */
    private String message;
    /**
     * objKeywordsService The service layer object variable for KeywordsService
     * object
     */
    private KeywordsService objKeywordsService;
    /**
     * objKeywordsDao The database layer object variable for KeywordsDao object
     */
    private KeywordsDao objKeywordsDao;

    public String addSocialSignalUrl() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            Integer customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
            Integer campaignID = Integer.parseInt(objSession.getAttribute("campaignId").toString());
            //checking the remaining quota for customer
            int quota = objKeywordsService.checkKeywordQuota(customerID);
            if (quota > 0) {

                //if quota >0
                int allowedQuota = quota - 1;

                if (allowedQuota >= 0) {

                    //remove http,https,www, and end /
                    addUrl = addUrl.replace("https://", "").replace("http://", "").replace("www.", "");
                    if (addUrl.endsWith("/")) {
                        addUrl = addUrl.substring(0, addUrl.length() - 1);
                    }

                    //Now check for url emptiness and exceed size
                    if (addUrl == null || addUrl.isEmpty() || addUrl.equals("")) {
                        message = "Url Not Provided";
                        return SUCCESS;
                    } else if (addUrl.length() > 200) {
                        message = "Url Length Exceed";
                        return SUCCESS;
                    }

                    int addSSUrl = objKeywordsDao.addUrl(campaignID, addUrl);

                    if (addSSUrl == 0) {
                        message = " Please create a new campaign. You cannot add this url in this campaign.";
                    } else if (addSSUrl == 2) {
                        message = "Sorry Url already existed";
                    } else {
                        message = "Url Added. It takes sometime to add the social url details.";
                    }
                } else {
                    message = "Sorry you can add " + quota + " Keywords";
                }
            } else {
                message = "Sorry your Quota has been Completed ";
            }
        } else {
            return LOGIN;
        }
        objSession.setAttribute("message", message);
        return SUCCESS;
    }

    /**
     * The method edits/updates a given Url
     *
     * @return struts return value
     */
    public String editSocialSignalUrl() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();
        System.out.println("-------------------------");
        if (objSession.getAttribute("customerID") != null) {
            System.out.println("SSUrlID = " + eurlId);
            System.out.println("SSUrl = " + eurl);

            //remove http,https,www, and end /
            eurl = eurl.replace("https://", "").replace("http://", "").replace("www.", "");
            if (eurl.endsWith("/")) {
                eurl = eurl.substring(0, eurl.length() - 1);
            }

            //Now check for url emptiness and exceed size
            if (eurl == null || eurl.isEmpty() || eurl.equals("")) {
                message = "Url Not Provided";
                return SUCCESS;
            } else if (eurl.length() > 200) {
                message = "Url Length Exceed";
                return SUCCESS;
            }

            int n = objKeywordsDao.editUrl(Integer.parseInt(eurlId), eurl, Integer.parseInt(objSession.getAttribute("campaignId").toString()));

            if (n == 1) {
                message = "Url Edited";
            } else if (n == 2) {
                message = "Sorry! Url already existed";
            } else {
                message = "Url Not Edited";
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
     * The method deletes a given Url based on UrlId
     *
     * @return struts return value
     */
    public String deleteSocialSignalUrl() {
        System.out.println("---------Delete---------");
        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            System.out.println("ssUrlID : " + delurlId);
            //Integer urlID = Integer.parseInt(jString);
            Integer campaignID = Integer.parseInt(objSession.getAttribute("campaignId").toString());
            objKeywordsDao.deleteUrl(Integer.parseInt(delurlId), campaignID);
            message = "Url has been Deleted";
            System.out.println("message ======================= " + message);
            objSession.setAttribute("message", message);
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String getAddUrl() {
        return addUrl;
    }

    public void setAddUrl(String addUrl) {
        this.addUrl = addUrl;
    }

    public HttpServletRequest getObjRequest() {
        return objRequest;
    }

    public void setObjRequest(HttpServletRequest objRequest) {
        this.objRequest = objRequest;
    }

    public HttpSession getObjSession() {
        return objSession;
    }

    public void setObjSession(HttpSession objSession) {
        this.objSession = objSession;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public KeywordsService getObjKeywordsService() {
        return objKeywordsService;
    }

    public void setObjKeywordsService(KeywordsService objKeywordsService) {
        this.objKeywordsService = objKeywordsService;
    }

    public KeywordsDao getObjKeywordsDao() {
        return objKeywordsDao;
    }

    public void setObjKeywordsDao(KeywordsDao objKeywordsDao) {
        this.objKeywordsDao = objKeywordsDao;
    }

    public String getEurlId() {
        return eurlId;
    }

    public void setEurlId(String eurlId) {
        this.eurlId = eurlId;
    }

    public String getEurl() {
        return eurl;
    }

    public void setEurl(String eurl) {
        this.eurl = eurl;
    }

    public String getDelurlId() {
        return delurlId;
    }

    public void setDelurlId(String delurlId) {
        this.delurlId = delurlId;
    }
}
