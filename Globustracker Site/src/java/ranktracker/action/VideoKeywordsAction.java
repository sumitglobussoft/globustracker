/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Videokeywords;
import ranktracker.form.RankComparision;
import ranktracker.service.KeywordsService;

/**
 *
 * @author User
 */
public class VideoKeywordsAction extends ActionSupport {

    public VideoKeywordsAction() {
    }
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
     * videotrackhst The list containing Videotrackhistory objects
     */
    private List<Videokeywords> videotrackhst;
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
     * youtubeurl The Json string received from ajax call
     */
    private String youtubeurl;
    /**
     * vimeourl The Json string received from ajax call
     */
    private String vimeourl;
    /**
     * metacafeurl The Json string received from ajax call
     */
    private String metacafeurl;
    /**
     * dailymotionurl The Json string received from ajax call
     */
    private String dailymotionurl;
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

                int customerId = Integer.parseInt(objSession.getAttribute("customerID").toString());
                //retrieving the list of keywords object from getData method of KeywordsServiceImpl for <campaignId>
                Object[] dataObject = objKeywordsService.getVideoData(campaignId, customerId);
                videotrackhst = (List<Videokeywords>) dataObject[0];
                campaignName = dataObject[1].toString();
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
                return SUCCESS;
            }
        } catch (Exception e) {
            return LOGIN;
        }

        //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
        //this result parameter is mapped in 'struts.xml'
        return LOGIN;
    }

    /**
     * The method adds a new keyword to database
     *
     * @return struts return value
     */
    public String addVideoKeyword() {

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
                Integer campaignID = Integer.parseInt(objSession.getAttribute("campaignId").toString());
                //checking the remaining quota for customer
                int quota = objKeywordsService.checkKeywordQuota(customerID);
                if (quota > 0) {
                    //if quota >0
                    int allowedQuota = quota - tempKeywords.length;
                    if (allowedQuota >= 0) {
                        //remove http,https,www, and end /
                        if (!youtubeurl.isEmpty()) {
                            youtubeurl = youtubeurl.replace("https://", "").replace("http://", "").replace("www.", "");
                            if (youtubeurl.endsWith("/")) {
                                youtubeurl = youtubeurl.substring(0, youtubeurl.length() - 1);
                            }
                        }

                        if (!vimeourl.isEmpty()) {
                            vimeourl = vimeourl.replace("https://", "").replace("http://", "").replace("www.", "");
                            if (vimeourl.endsWith("/")) {
                                vimeourl = vimeourl.substring(0, vimeourl.length() - 1);
                            }
                        }

                        if (!metacafeurl.isEmpty()) {
                            metacafeurl = metacafeurl.replace("https://", "").replace("http://", "").replace("www.", "");
                            if (metacafeurl.endsWith("/")) {
                                metacafeurl = metacafeurl.substring(0, metacafeurl.length() - 1);
                            }
                        }

                        if (!dailymotionurl.isEmpty()) {
                            dailymotionurl = dailymotionurl.replace("https://", "").replace("http://", "").replace("www.", "");
                            if (dailymotionurl.endsWith("/")) {
                                dailymotionurl = dailymotionurl.substring(0, dailymotionurl.length() - 1);
                            }
                        }

                        if (youtubeurl.length() > 250 || vimeourl.length() > 250 || metacafeurl.length() > 250 || dailymotionurl.length() > 250) {
                            message = "Url Length Exceed";
                            return SUCCESS;
                        }

                        int addKeyword = 0;
                        addKeyword = objKeywordsService.addVideoKeyword(lstKeywords, campaignID, youtubeurl, vimeourl, dailymotionurl, metacafeurl);

                        if (addKeyword == 1) {
                            message = "Keywords Added. It will take sometime to refresh the rankings.";
                        } else {
                            message = "Sorry, Keyword already exist in this Campaign";
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
    public String editVideoKeyword() {
        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        //initializing http session object
        objSession = objRequest.getSession();
        if (objSession.getAttribute("customerID") != null) {
            Integer campaignID = Integer.parseInt(objSession.getAttribute("campaignId").toString());
            if (!youtubeurl.isEmpty()) {
                youtubeurl = youtubeurl.replace("https://", "").replace("http://", "").replace("www.", "");
                if (youtubeurl.endsWith("/")) {
                    youtubeurl = youtubeurl.substring(0, youtubeurl.length() - 1);
                }
            }

            if (!vimeourl.isEmpty()) {
                vimeourl = vimeourl.replace("https://", "").replace("http://", "").replace("www.", "");
                if (vimeourl.endsWith("/")) {
                    vimeourl = vimeourl.substring(0, vimeourl.length() - 1);
                }
            }

            if (!metacafeurl.isEmpty()) {
                metacafeurl = metacafeurl.replace("https://", "").replace("http://", "").replace("www.", "");
                if (metacafeurl.endsWith("/")) {
                    metacafeurl = metacafeurl.substring(0, metacafeurl.length() - 1);
                }
            }

            if (!dailymotionurl.isEmpty()) {
                dailymotionurl = dailymotionurl.replace("https://", "").replace("http://", "").replace("www.", "");
                if (dailymotionurl.endsWith("/")) {
                    dailymotionurl = dailymotionurl.substring(0, dailymotionurl.length() - 1);
                }
            }

            if (youtubeurl.length() > 250 || vimeourl.length() > 250 || metacafeurl.length() > 250 || dailymotionurl.length() > 250) {
                message = "Url Length Exceed";
                return SUCCESS;
            }
            int editKey = 0;
            editKey = objKeywordsService.editVideoKeywords(campaignID, Integer.parseInt(keywordId), arrKeywords, youtubeurl, vimeourl, dailymotionurl, metacafeurl);
            if (editKey == 1) {
                message = "Keyword Edited";
            } else {
                message = "Sorry keyword already existed";
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
    public String deleteVideoKeyword() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            Integer keywordID = Integer.parseInt(jString);
            Integer campaignID = Integer.parseInt(objSession.getAttribute("campaignId").toString());
            objKeywordsService.deleteVideoKeyword(keywordID, campaignID);
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
     * @return lstkeywords
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

    public List<Videokeywords> getVideotrackhst() {
        return videotrackhst;
    }

    public void setVideotrackhst(List<Videokeywords> videotrackhst) {
        this.videotrackhst = videotrackhst;
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

    public String getVimeourl() {
        return vimeourl;
    }

    public void setVimeourl(String vimeourl) {
        this.vimeourl = vimeourl;
    }

    public String getMetacafeurl() {
        return metacafeurl;
    }

    public void setMetacafeurl(String metacafeurl) {
        this.metacafeurl = metacafeurl;
    }

    public String getDailymotionurl() {
        return dailymotionurl;
    }

    public void setDailymotionurl(String dailymotionurl) {
        this.dailymotionurl = dailymotionurl;
    }

    public String getYoutubeurl() {
        return youtubeurl;
    }

    public void setYoutubeurl(String youtubeurl) {
        this.youtubeurl = youtubeurl;
    }

    public RankComparision getRankComparision() {
        return rankComparision;
    }

    public void setRankComparision(RankComparision rankComparision) {
        this.rankComparision = rankComparision;
    }
}
