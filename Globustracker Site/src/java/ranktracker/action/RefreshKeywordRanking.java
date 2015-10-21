/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import static com.opensymphony.xwork2.Action.LOGIN;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.service.CampaignsService;
import ranktracker.service.KeywordsService;

/**
 *
 * @author GLB-214
 */
public class RefreshKeywordRanking extends ActionSupport {

    private CampaignsService objCampaignsService;

    private KeywordsService objKeywordsService;
    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;

    private String jString;

    private String message;

    /**
     * Refresh Serps Campaign
     *
     * @return
     */
    public String refreshSerpsCampaign() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            String[] data = jString.split(":");
            Integer campaignId = Integer.parseInt(data[0]);
            System.out.println("campaignId ------------------= " + campaignId);
            String campaignName = data[1];
            System.out.println("campaignName --------------= " + campaignName);

            Integer customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
            System.out.println("customerID = " + customerID);

            //now invoking the refreshCampaign() method of CampaignsServiceImpl
            int updated = objCampaignsService.refreshCampaign(campaignId, campaignName, customerID);
            if (updated == 1) {
                message = "'" + campaignName + "' - Campaign has been Refreshed";
                System.out.println("message = " + message);
            } else {
                message = "Sorry Campaign Name " + campaignName + " cannot be refreshed!! You can refresh a campaign once a day!!  Try it tomorrow";
                System.out.println("message = " + message);
                addActionError(message);
            }
            objSession.setAttribute("message", message);
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * Refresh Serps Google Keyword
     *
     * @return
     */
    public String refreshSerpsGoogleKeyword() {
        try {

            //initializing http request object
            objRequest = ServletActionContext.getRequest();

            //initializing http session object
            objSession = objRequest.getSession();
            System.out.println("" + objSession.getAttribute("customerID"));
            //checking for 'customerID' attribute in session
            if (objSession.getAttribute("customerID") != null) {
                String[] data = jString.split(":");
                Integer keywordId = Integer.parseInt(data[0]);
                System.out.println("keywordId ------------------= " + keywordId);
                String keywordName = data[1];
                System.out.println("keywordName --------------= " + keywordName);

                Integer customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
                System.out.println("customerID = " + customerID);

                //now invoking the refreshKeyword() method of KeywordServiceImpl
                try {
                    int updated = objKeywordsService.refreshGoogleKeyword(keywordId);
                    if (updated == 1) {
                        message = "'" + keywordName + "' keyword will get updated, just wait for few minutes";
                        System.out.println("message = " + message);
                    } else {
                        message = "Sorry Keyword Name '" + keywordName + "' cannot be refreshed!! You can refresh a keyword once a day!!  Try it tomorrow";
                        System.out.println("message = " + message);
                        addActionError(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                return LOGIN;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        objSession.setAttribute("message", message);
        return SUCCESS;
    }

    /**
     * Refresh Serps Yahoo Keyword
     *
     * @return
     */
    public String refreshSerpsYahooKeyword() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            String[] data = jString.split(":");
            Integer keywordId = Integer.parseInt(data[0]);
            System.out.println("keywordId ------------------= " + keywordId);
            String keywordName = data[1];
            System.out.println("keywordName --------------= " + keywordName);

            Integer customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
            System.out.println("customerID = " + customerID);

            //now invoking the refreshKeyword() method of KeywordServiceImpl
            try {
                int updated = objKeywordsService.refreshYahooKeyword(keywordId);
                if (updated == 1) {
                    message = "'" + keywordName + "' keyword will get updated, just wait for few minutes";
                    System.out.println("message = " + message);
                } else {
                    message = "Sorry Keyword Name '" + keywordName + "' cannot be refreshed!! You can refresh a keyword once a day!!  Try it tomorrow";
                    System.out.println("message = " + message);
                    addActionError(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return LOGIN;
        }
        objSession.setAttribute("message", message);
        return SUCCESS;
    }

    /**
     * Refresh Serps Bing Keyword
     *
     * @return
     */
    public String refreshSerpsBingKeyword() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            String[] data = jString.split(":");
            Integer keywordId = Integer.parseInt(data[0]);
            System.out.println("keywordId ------------------= " + keywordId);
            String keywordName = data[1];
            System.out.println("keywordName --------------= " + keywordName);

            Integer customerID = Integer.parseInt(objSession.getAttribute("customerID").toString());
            System.out.println("customerID = " + customerID);

            //now invoking the refreshKeyword() method of KeywordServiceImpl
            try {
                int updated = objKeywordsService.refreshBingKeyword(keywordId);
                if (updated == 1) {
                    message = "'" + keywordName + "' keyword will get updated, just wait for few minutes";
                    System.out.println("message = " + message);
                } else {
                    message = "Sorry Keyword Name '" + keywordName + "' cannot be refreshed!! You can refresh a keyword once a day!!  Try it tomorrow";
                    System.out.println("message = " + message);
                    addActionError(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return LOGIN;
        }
        objSession.setAttribute("message", message);
        return SUCCESS;
    }

    public CampaignsService getObjCampaignsService() {
        return objCampaignsService;
    }

    public void setObjCampaignsService(CampaignsService objCampaignsService) {
        this.objCampaignsService = objCampaignsService;
    }

    public KeywordsService getObjKeywordsService() {
        return objKeywordsService;
    }

    public void setObjKeywordsService(KeywordsService objKeywordsService) {
        this.objKeywordsService = objKeywordsService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
