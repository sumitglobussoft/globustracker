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
import ranktracker.entity.Campaigns;
import ranktracker.entity.Customers;
import ranktracker.entity.Seokeyworddetails;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Videokeywords;
import ranktracker.form.KeywordsLastUpdatedForm;
import ranktracker.form.RankComparision;
import ranktracker.service.CampaignsService;
import ranktracker.service.KeywordsService;

/**
 * Action layer class for validating viewkey and retrieving campaign details
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class ViewKeyAction extends ActionSupport {

    /**
     * objCampaignsService The service layer object variable for
     * CampaignsService
     */
    private CampaignsService objCampaignsService;
    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * lstkeywords The list containing Keywords objects
     */
    private List<Serpkeywords> lstkeywords = new ArrayList<>();
    /**
     * lstvideokeywords The list containing Videokeywords objects
     */
    private List<Videokeywords> lstvideokeywords = new ArrayList<>();
    /**
     * campaignName The campaign name corresponding to given viewkey
     */
    private String campaignName;
    private Set<KeywordsLastUpdatedForm> setkeywordslastupdate;
    /**
     * lstkeywordslastupdate The list containing Keywords object
     */
    private List<KeywordsLastUpdatedForm> lstkeywordslastupdate;
    private List<KeywordsLastUpdatedForm> lstsocialsignalupdate;
    private List<Serpkeywords> lstUpdatedKeywords;
    private List<Seokeyworddetails> lstSeoDetails;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * campaignId The tempKeywords are retrieved for the campaignid received
     * from frontend
     */
    private Integer campaignId;
    /**
     * objKeywordsService The service layer object variable for KeywordsService
     * object
     */
    private KeywordsService objKeywordsService;
    /**
     * rankComparision holds the rank
     */
    private RankComparision rankComparision;
    /**
     * videotrackhst The list containing Videotrackhistory objects
     */
    private List<Videokeywords> videotrackhst;

    /**
     * The method validates viewkey and retrieves keywords records for
     * corresponding campaign
     *
     * @return struts return value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        setkeywordslastupdate = new HashSet<>();

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        if (objRequest.getParameter("key") != null) {

            //retrieving the <key> parameter from request object
            //and invoking the getViewKeyDetails() of CampaignsServiceImpl class to retrieve the campaigns details
            Object[] objData = objCampaignsService.getViewKeyDetails(objRequest.getParameter("key"));
            campaignId = ((List<Campaigns>) objData[0]).get(0).getCampaignID();
            Customers customers = ((List<Campaigns>) objData[0]).get(0).getCustomerID();
            int customerId = customers.getCustomerID();
            //retrieving the list of keywords object from getData method of KeywordsServiceImpl for <campaignId>
            Object[] dataObject = objKeywordsService.getSerpData(campaignId, customerId);
            lstUpdatedKeywords = (List<Serpkeywords>) dataObject[0];
            lstsocialsignalupdate = (List<KeywordsLastUpdatedForm>) dataObject[1];
            lstSeoDetails = (List<Seokeyworddetails>) dataObject[3];
            try {
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
                objRequest.setAttribute("highlight", "SERP");
            } catch (Exception e) {
                System.out.println("Execption = " + e);
            }

            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     *
     * @return lstVideokeywords
     */
    public String executeVideo() throws Exception {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        if (objRequest.getParameter("key") != null) {
            //retrieving the <key> parameter from request object
            //and invoking the getViewKeyDetails() of CampaignsServiceImpl class to retrieve the campaigns details
            Object[] objData = objCampaignsService.getViewKeyDetails(objRequest.getParameter("key"));
            campaignId = ((List<Campaigns>) objData[0]).get(0).getCampaignID();
            Customers customers = ((List<Campaigns>) objData[0]).get(0).getCustomerID();
            int customerId = customers.getCustomerID();
            Object[] dataObject = objKeywordsService.getVideoData(campaignId, customerId);
            videotrackhst = (List<Videokeywords>) dataObject[0];
            campaignName = dataObject[1].toString();
            try {
                int count5 = 0;
                int count10 = 0;
                int count20 = 0;
                int count30 = 0;
                int count100 = 0;
                int keywordcount = videotrackhst.size();
                int keyrank;
                rankComparision = new RankComparision();
                if (!videotrackhst.isEmpty()) {
                    Iterator itr = videotrackhst.iterator();
                    while (itr.hasNext()) {
                        Videokeywords keys = (Videokeywords) itr.next();
                        keyrank = keys.getRankYoutube();
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
                if (objSession.getAttribute("message") != null) {
                    addActionMessage(objSession.getAttribute("message").toString());
                    objSession.removeAttribute("message");
                }
                objRequest.setAttribute("highlight", "VIDEO");
            } catch (Exception e) {
                System.out.println("Execption = " + e);
            }
            return SUCCESS;
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     *
     * @return lstvideokeywords
     */
    public List<Serpkeywords> getLstkeywords() {
        return lstkeywords;
    }

    /**
     *
     * @param lstkeywords
     */
    public void setLstkeywords(List<Serpkeywords> lstkeywords) {
        this.lstkeywords = lstkeywords;
    }

    /**
     *
     * @return lstvideokeywords
     */
    public List<Videokeywords> getLstvideokeywords() {
        return lstvideokeywords;
    }

    public void setLstvideokeywords(List<Videokeywords> lstvideokeywords) {
        this.lstvideokeywords = lstvideokeywords;
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

    public HttpServletRequest getObjRequest() {
        return objRequest;
    }

    public void setObjRequest(HttpServletRequest objRequest) {
        this.objRequest = objRequest;
    }

    public Set<KeywordsLastUpdatedForm> getSetkeywordslastupdate() {
        return setkeywordslastupdate;
    }

    public void setSetkeywordslastupdate(Set<KeywordsLastUpdatedForm> setkeywordslastupdate) {
        this.setkeywordslastupdate = setkeywordslastupdate;
    }

    public List<KeywordsLastUpdatedForm> getLstkeywordslastupdate() {
        return lstkeywordslastupdate;
    }

    public void setLstkeywordslastupdate(List<KeywordsLastUpdatedForm> lstkeywordslastupdate) {
        this.lstkeywordslastupdate = lstkeywordslastupdate;
    }

    public HttpSession getObjSession() {
        return objSession;
    }

    public void setObjSession(HttpSession objSession) {
        this.objSession = objSession;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public KeywordsService getObjKeywordsService() {
        return objKeywordsService;
    }

    public void setObjKeywordsService(KeywordsService objKeywordsService) {
        this.objKeywordsService = objKeywordsService;
    }

    public List<KeywordsLastUpdatedForm> getLstsocialsignalupdate() {
        return lstsocialsignalupdate;
    }

    public void setLstsocialsignalupdate(List<KeywordsLastUpdatedForm> lstsocialsignalupdate) {
        this.lstsocialsignalupdate = lstsocialsignalupdate;
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

    public RankComparision getRankComparision() {
        return rankComparision;
    }

    public void setRankComparision(RankComparision rankComparision) {
        this.rankComparision = rankComparision;
    }

    public List<Videokeywords> getVideotrackhst() {
        return videotrackhst;
    }

    public void setVideotrackhst(List<Videokeywords> videotrackhst) {
        this.videotrackhst = videotrackhst;
    }
}
