/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ranktracker.entity.Globustrackerevents;
import ranktracker.entity.Serpkeywordgoal;
import ranktracker.entity.Serpstrackhistory;
import ranktracker.entity.Socialtrackhistory;
import ranktracker.entity.Videokeywords;
import ranktracker.service.KeywordsService;

/**
 * Action layer class for actions initiated for charts module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class ChartAction extends ActionSupport {

    /**
     * dataMap The Map containing Chart data
     */
    private Map<String, String> dataMap;
    /**
     * objKeywordsService The service layer object variable for KeywordsService
     */
    private KeywordsService objKeywordsService;
    /**
     * objServletRequest The HttpServletRequest object
     */
    private HttpServletRequest objServletRequest;
    /**
     * objHttpSession The HttpSession object
     */
    private HttpSession objHttpSession;
    /**
     * jString The Json string received from ajax call
     */
    private String jString;
    /**
     * objJson The Json object created from jString
     */
    private JSONObject objJson = null;

    /**
     * The method retrieves serps data from trackhistory table for display in
     * highchart
     *
     * @return struts return value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        //initializing http request object
        objServletRequest = ServletActionContext.getRequest();

        //initializing http session object
        objHttpSession = objServletRequest.getSession();
        //if (objHttpSession.getAttribute("customerID") != null) {
        dataMap = new HashMap<>();
        objJson = (JSONObject) new JSONParser().parse(jString);
        // 30.90.180.365.lifetime
        int keywordId = Integer.parseInt(objJson.get("keywordId").toString());
        int range = Integer.parseInt(objJson.get("range").toString());

        //now invoking the getChartData() method of KeywordsServiceImpl
        List<Serpstrackhistory> lstSerpstrackHisory = objKeywordsService.getChartData(keywordId, range);

        //now invoking the getChartGoalData() method of KeywordsServiceImpl for getting goals associated for each keyword
     //   List<Serpkeywordgoal> lstGoalData = objKeywordsService.getChartGoalData(keywordId);

        //now invoking the getChartEventData() method of KeywordsServiceImpl for events of globustracker
      //  List<Globustrackerevents> lstEventData = objKeywordsService.getChartEventData();

        //variable declaration for 'sbGoogle','sbBing','sbYahoo'
        StringBuilder sbGoogle = new StringBuilder();
        StringBuilder sbBing = new StringBuilder();
        StringBuilder sbYahoo = new StringBuilder();
     //   StringBuilder sbGoal = new StringBuilder();

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy,MM - 1,dd");
        for (Serpstrackhistory objSerpstrackhistory : lstSerpstrackHisory) {
            int rank = objSerpstrackhistory.getRank();
            if (rank == 501) {
                rank = 0;
            }
            //iterating the lstTrackHisory object
            //preparing bing json object
            if (objSerpstrackhistory.getSearchEngine().equalsIgnoreCase("bing.com")) {
                int lastTrackDate = sbBing.lastIndexOf(dateformat.format(objSerpstrackhistory.getTrackDate()));

                if (lastTrackDate == -1) {
                    sbBing.append("[Date.UTC(").append(dateformat.format(objSerpstrackhistory.getTrackDate())).append("),").
                            append(rank).append(",],");
                } else {

                    int sbBingrankend = sbBing.lastIndexOf(",],");
                    int sbBingrankstart = sbBing.lastIndexOf("),");
                    String rankstring = sbBing.substring(sbBingrankstart + 2, sbBingrankend);
                    int oldrank = Integer.parseInt(rankstring);
                    int newrank = rank;
                    if (oldrank > newrank) {
                        int lastDateString = sbBing.lastIndexOf("[Date.UTC");
                        sbBing = sbBing.replace(lastDateString, sbBing.length(), "");
                        sbBing.append("[Date.UTC(").append(dateformat.format(objSerpstrackhistory.getTrackDate())).append("),").
                                append(rank).append(",],");
                    }
                }
            }

            //preparing google json object
            if (objSerpstrackhistory.getSearchEngine().contains("google.com")) {
                int lastTrackDate = sbGoogle.lastIndexOf(dateformat.format(objSerpstrackhistory.getTrackDate()));
                if (lastTrackDate == -1) {
                    sbGoogle.append("[Date.UTC(").append(dateformat.format(objSerpstrackhistory.getTrackDate())).append("),").
                            append(rank).append(",],");
                } else {
                    int sbGooglerankend = sbGoogle.lastIndexOf(",],");
                    int sbGooglerankstart = sbGoogle.lastIndexOf("),");
                    String rankstring = sbGoogle.substring(sbGooglerankstart + 2, sbGooglerankend);
                    int oldrank = Integer.parseInt(rankstring);
                    int newrank = rank;
                    if (oldrank > newrank) {

                        int lastDateString = sbGoogle.lastIndexOf("[Date.UTC");
                        sbGoogle = sbGoogle.replace(lastDateString, sbGoogle.length(), "");
                        sbGoogle.append("[Date.UTC(").append(dateformat.format(objSerpstrackhistory.getTrackDate())).append("),").
                                append(rank).append(",],");
                    }
                }

            }

            //preparing yahoo json object
            if (objSerpstrackhistory.getSearchEngine().equalsIgnoreCase("yahoo.com")) {
                int lastTrackDate = sbYahoo.lastIndexOf(dateformat.format(objSerpstrackhistory.getTrackDate()));
                if (lastTrackDate == -1) {
                    sbYahoo.append("[Date.UTC(").append(dateformat.format(objSerpstrackhistory.getTrackDate())).append("),").
                            append(rank).append(",],");
                } else {
                    int sbYahoorankend = sbYahoo.lastIndexOf(",],");
                    int sbYahoorankstart = sbYahoo.lastIndexOf("),");
                    String rankstring = sbYahoo.substring(sbYahoorankstart + 2, sbYahoorankend);
                    int oldrank = Integer.parseInt(rankstring);
                    int newrank = rank;
                    if (oldrank > newrank) {
                        int lastDateString = sbYahoo.lastIndexOf("[Date.UTC");

                        sbYahoo = sbYahoo.replace(lastDateString, sbYahoo.length(), "");
                        sbYahoo.append("[Date.UTC(").append(dateformat.format(objSerpstrackhistory.getTrackDate())).append("),").
                                append(rank).append(",],");
                    }
                }
            }
        }

//        if (lstGoalData.isEmpty()) {
//            sbGoal.append("");
//        } else {
//            for (Serpkeywordgoal objserpkeywordgoal : lstGoalData) {
//
//                String date = dateformat.format(objserpkeywordgoal.getGoalDate());
//                sbGoal.append("[Date.UTC(").append(date).append("),").append(objserpkeywordgoal.getGoalRank()).append(",],");
//            }
//
//        }

        //variable declaration to append all bing,yahoo and google
        StringBuilder sbData = new StringBuilder();
      //  StringBuilder sbEvent = new StringBuilder();

        //appending bing ,google and yahoo data into a single Json Object
        sbData.append("[{name:'Google', pointInterval: 24 * 3600 * 1000, data:[").append(sbGoogle).append("]},");
        sbData.append("{name:'Bing', pointInterval: 24 * 3600 * 1000, data:[").append(sbBing).append("]},");
        sbData.append("{name:'Yahoo', pointInterval: 24 * 3600 * 1000, data:[").append(sbYahoo).append("]}]");
//        sbData.append("{type:'scatter',"
//                + "tooltip:{ useHTML: true,shared:true, headerFormat:'{point.key}<br>' , pointFormat:'{series.name}:<b>{point.y}</b>' },"
//                + "name:'Goal', marker: {symbol: 'url(https://cdn1.iconfinder.com/data/icons/large-glossy-icons/20/Target.png)'},pointInterval: 24 * 3600 * 1000, data:[").append(sbGoal).append("]}]");
//        sbEvent.append("[");
//        for (Globustrackerevents objglobustrackerevents : lstEventData) {
//            Date eventDate = objglobustrackerevents.getEventDate();
//
//            Calendar cal1 = Calendar.getInstance();
//            cal1.setTime(eventDate);
//            cal1.add(Calendar.DAY_OF_YEAR, -1);
//
//            Date previousDate = cal1.getTime();
//
//            Calendar cal2 = Calendar.getInstance();
//            cal2.setTime(eventDate);
//            cal2.add(Calendar.DAY_OF_YEAR, 1);
//
//            Date nxtDate = cal2.getTime();
//
//            sbEvent.append("{color: 'white',from: Date.UTC(").append(dateformat.format(previousDate)).append("),to: Date.UTC(").append(dateformat.format(nxtDate)).append("), label: { y:-1, text: '--");
//            sbEvent.append(objglobustrackerevents.getEventName()).append("',rotation: 270,  textAlign: 'left',verticalAlign: 'bottom', style: { color: '#a83ff6', fontWeight: 'bold' }}, events: {  click: function (e) {  hs.htmlExpand(null, {   headingText: \"Event Details\", maincontentText: \"");
//            sbEvent.append(objglobustrackerevents.getEventDescription()).append("\",width: 100, height: 100  });}, mouseout: function (e) { hs.close();  },mouseover: function (e) { hs.close();  }, mousemove: function (e) {hs.close();  } } },");
//        }
//        sbEvent.deleteCharAt(sbEvent.length() - 1);
//        sbEvent.append("]");

        dataMap.put("title", "Chart Graph");
      //  dataMap.put("gtEvent", sbEvent.toString());
        dataMap.put("sbData", sbData.toString());
        return SUCCESS;
        //} else {
        //    return LOGIN;
        // }
    }

    /**
     * The method retrieves social signals data from trackhistory table for
     * display in highchart
     *
     * @return struts return value
     * @throws Exception
     */
    public String executeSocial() throws Exception {

        //initializing http request object
        objServletRequest = ServletActionContext.getRequest();

        //initializing http session object
        objHttpSession = objServletRequest.getSession();
        //if (objHttpSession.getAttribute("customerID") != null) {
        dataMap = new HashMap<>();
        objJson = (JSONObject) new JSONParser().parse(jString);
        // 30.90.180.365.lifetime
        int urlId = Integer.parseInt(objJson.get("urlId").toString());
        int range = Integer.parseInt(objJson.get("range").toString());

        //now invoking the getChartData() method of KeywordsServiceImpl
        List<Socialtrackhistory> lstSocialtrackHisory = objKeywordsService.getChartDataSocial(urlId, range);

        //variable declaration for all signifier object
        StringBuilder sbFBLike = new StringBuilder();
        StringBuilder sbFBShare = new StringBuilder();
        StringBuilder sbTwitterTweets = new StringBuilder();
        StringBuilder sbPinterestPins = new StringBuilder();
        StringBuilder sbGPlusLikes = new StringBuilder();
        StringBuilder sbLinkedInShares = new StringBuilder();
        StringBuilder sbRedditVotes = new StringBuilder();
        StringBuilder sbStumbleUponVotes = new StringBuilder();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy,MM - 1,dd");
        for (Socialtrackhistory objSocialtrackhistory : lstSocialtrackHisory) {

            //iterating the lstTrackHisory object 
            //preparing facebook like and share json object
            sbFBShare.append("[Date.UTC(").append(dateformat.format(objSocialtrackhistory.getTrackDate())).append("),").
                    append(objSocialtrackhistory.getFaceBookShare()).append(",],");

            sbFBLike.append("[Date.UTC(").append(dateformat.format(objSocialtrackhistory.getTrackDate())).append("),").
                    append(objSocialtrackhistory.getFaceBookLike()).append(",],");

            //preparing twitter count json object
            sbTwitterTweets.append("[Date.UTC(").append(dateformat.format(objSocialtrackhistory.getTrackDate())).append("),").
                    append(objSocialtrackhistory.getTweetCount()).append(",],");

            //preparing pinterest pins json object
            sbPinterestPins.append("[Date.UTC(").append(dateformat.format(objSocialtrackhistory.getTrackDate())).append("),").
                    append(objSocialtrackhistory.getPinterestPin()).append(",],");

            //preparing google plus likes json object
            sbGPlusLikes.append("[Date.UTC(").append(dateformat.format(objSocialtrackhistory.getTrackDate())).append("),").
                    append(objSocialtrackhistory.getGooglePlus()).append(",],");

            //preparing linkedin shares json object
            sbLinkedInShares.append("[Date.UTC(").append(dateformat.format(objSocialtrackhistory.getTrackDate())).append("),").
                    append(objSocialtrackhistory.getLinkedInShare()).append(",],");

            //preparing reddit votes json object
            sbRedditVotes.append("[Date.UTC(").append(dateformat.format(objSocialtrackhistory.getTrackDate())).append("),").
                    append(objSocialtrackhistory.getRedittVote()).append(",],");

            //preparing stumble upon json object
            sbStumbleUponVotes.append("[Date.UTC(").append(dateformat.format(objSocialtrackhistory.getTrackDate())).append("),").
                    append(objSocialtrackhistory.getStumbleUponStumble()).append(",],");
        }

        //variable declaration to append all json object into a single json object.
        StringBuilder sbData = new StringBuilder();
        //appending bing ,google and yahoo data into a single Json Object
        sbData.append("[{name:'Facebook Likes', pointInterval: 24 * 3600 * 1000, data:[").append(sbFBLike).append("]},");
//        sbData.append("{name:'Facebook Shares', pointInterval: 24 * 3600 * 1000, data:[").append(sbFBShare).append("]},");
        sbData.append("{name:'Twitter Tweets', pointInterval: 24 * 3600 * 1000, data:[").append(sbTwitterTweets).append("]},");
        sbData.append("{name:'Pinterest Pins', pointInterval: 24 * 3600 * 1000, data:[").append(sbPinterestPins).append("]},");
        sbData.append("{name:'Google Plus Likes', pointInterval: 24 * 3600 * 1000, data:[").append(sbGPlusLikes).append("]},");
        sbData.append("{name:'LinkedIn Shares', pointInterval: 24 * 3600 * 1000, data:[").append(sbLinkedInShares).append("]},");
        sbData.append("{name:'Reditt Votes', pointInterval: 24 * 3600 * 1000, data:[").append(sbRedditVotes).append("]},");
        sbData.append("{name:'StumbleUpon Votes', pointInterval: 24 * 3600 * 1000, data:[").append(sbStumbleUponVotes).append("]}]");
        dataMap.put("title", "Social Graph");
        dataMap.put("sbData", sbData.toString());
        //} else {
        //    return LOGIN;
        //}

        return SUCCESS;
    }

    public String executeCampaignChart() throws Exception {
        try {
            objServletRequest = ServletActionContext.getRequest();
            objHttpSession = objServletRequest.getSession();
            dataMap = new HashMap<>();

            objJson = (JSONObject) new JSONParser().parse(jString);
            Integer campaignId = Integer.parseInt(objJson.get("campaignId").toString());
            int range = Integer.parseInt(objJson.get("range").toString());
            String engine = objJson.get("engine").toString();

            List<Integer> lstKeywordID = objKeywordsService.getCampaignChartData(campaignId);
            StringBuilder sbData = new StringBuilder();
            sbData.append("[");
            String clickedEngine = engine + ".com";
            for (Integer keywordID : lstKeywordID) {
                List<Serpstrackhistory> lstSerpstrackHisory = objKeywordsService.getChartData(keywordID, range);
                StringBuilder sbEngine = new StringBuilder();
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy,MM - 1,dd");
                for (Serpstrackhistory objSerpstrackhistory : lstSerpstrackHisory) {
                    int rank = objSerpstrackhistory.getRank();
                    if (rank == 501) {
                        rank = 0;
                    }
                    if (objSerpstrackhistory.getSearchEngine().contains(clickedEngine)) {
                        sbEngine.append("[Date.UTC(").append(dateformat.format(objSerpstrackhistory.getTrackDate())).append("),").
                                append(rank).append(",],");
                    }

                }
                String keywordName = objKeywordsService.getKeywordName(keywordID);

                sbData.append("{name:'").append(keywordName).append("', pointInterval: 24 * 3600 * 1000, data:[").append(sbEngine).append("]},");
            }
            sbData.deleteCharAt(sbData.length() - 1);
            sbData.append("]");
            dataMap.put("title", "Keyword Comparision Graph");
            dataMap.put("sbData", sbData.toString());
        } catch (ParseException | NumberFormatException e) {
            System.out.println("e = " + e);
        }
        return SUCCESS;
        //} else {
        //    return LOGIN;
        // }

    }

    public String executeVideoChart() throws Exception {

        //initializing http request object
        objServletRequest = ServletActionContext.getRequest();

        //initializing http session object
        objHttpSession = objServletRequest.getSession();
        //if (objHttpSession.getAttribute("customerID") != null) {
        dataMap = new HashMap<>();
        objJson = (JSONObject) new JSONParser().parse(jString);
        // 30.90.180.365.lifetime
        int keywordId = Integer.parseInt(objJson.get("keywordId").toString());

        //now invoking the getChartData() method of KeywordsServiceImpl
        List<Videokeywords> lstVideokeywords = objKeywordsService.getVideoChartData(keywordId);

        StringBuilder sbData = new StringBuilder();
        StringBuilder category = new StringBuilder();
        StringBuilder sbDatalabel = new StringBuilder();

        sbDatalabel.append("dataLabels: {enabled: true,color: 'black',align: 'center',x:4,y:4, style: {fontWeight: 'bold' }}");
        for (Videokeywords obj : lstVideokeywords) {
//            if (obj.getVideoLink().equalsIgnoreCase("vimeo.com")) {
            category.append("['YouTube','Dailymotion','Vimeo','Metacafe']");
            sbData.append("[{  colorByPoint: true,data:[").append(obj.getYoutubeViewCount()).append(",").append(obj.getDailymotionViewCount()).append(",").append(obj.getVimeoViewCount()).append(",").append(obj.getMetacafeViewCount()).append("],").append(sbDatalabel).append("}]");//am1
//            }
//            if (obj.getVideoLink().equalsIgnoreCase("youtube.com")) {
//                category.append("['View Count','Like Count','DisLike Count','Daily View Count']");
//                sbData.append("[{  colorByPoint: true,data:[").append(obj.getYoutubeviewcoint()).append(",").append(obj.getYoutubeLikeCount()).append(",").append(obj.getYoutubeDislikeCount()).append(",").append(obj.getYoutubeDailyViewcount()).append("],").append(sbDatalabel).append("}]");
//            }
//            if ((obj.getVideoLink().equalsIgnoreCase("metacafe.com")) || (obj.getVideoLink().equalsIgnoreCase("dailymotion.com"))) {
//                category.append("['View Count','Daily View Count']");
//                sbData.append("[{  colorByPoint: true,data:[").append(obj.getYoutubeviewcoint()).append(",").append(obj.getYoutubeDailyViewcount()).append("],").append(sbDatalabel).append("}]");
//            }
        }

        dataMap.put("title", "Video Graph");
        dataMap.put("sbData", sbData.toString());
        dataMap.put("category", category.toString());

        //} else {
        //    return LOGIN;
        //}
        return SUCCESS;
    }

    /**
     *
     * @return dataMap
     */
    public Map<String, String> getDataMap() {
        return dataMap;
    }

    /**
     *
     * @param dataMap
     */
    public void setDataMap(Map<String, String> dataMap) {
        this.dataMap = dataMap;
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
