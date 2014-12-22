package ranktracker.crawler.dailymotion;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.Serpkeywords;
import ranktracker.utility.FetchPage;
import ranktracker.utility.FetchPageHttpClientDailymotion;
import ranktracker.utility.ProxyPageSource;

/**
 * The crawler class get DailyMotion search web rank for a given keyword, url
 * combination.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class WebRankDailyMotion extends Thread {

    static Logger l = Logger.getLogger(WebRankDailyMotion.class.getName());
    /**
     * lstKeywords The working list of Keywords objects
     */
    private List<Serpkeywords> lstKeywords = null;
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;
    /**
     * bestMatchLinkGoogle The best match link for a given keyword
     */
    private String bestMatchLinkGoogle = "";
    /**
     * bestMatchRankGoogle The best match rank for a given keyword
     */
    private Integer bestMatchRankGoogle = 0;
    /**
     * startTrackId The first trackid for a given crawl thread
     */
    private Integer startTrackId;
    /**
     * endtrackId The last trackid for a given crawl thread
     */
    private Integer endtrackId;
    /**
     * objProxyDao The database layer ProxyDao object variable
     */
    private ProxyDao objProxyDao;
    /**
     * objProxyPageSource The utility class ProxyPageSource object variable
     */
    private ProxyPageSource objProxyPageSource;
    /**
     * iCount Counter variable for passing thread group information
     */
    private Integer iCount;

    /**
     * Constructor to set all the variables
     *
     * @param iCount
     * @param lstKeywords
     * @param appContext
     * @param startTrackId
     * @param endtrackId
     *
     */
    public WebRankDailyMotion(Integer iCount, List<Serpkeywords> lstKeywords, ApplicationContext appContext,
            Integer startTrackId, Integer endtrackId) {

        this.iCount = iCount;
        this.lstKeywords = lstKeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.startTrackId = startTrackId;
        this.endtrackId = endtrackId;
        this.objProxyPageSource = appContext.getBean("objProxyPageSource", ProxyPageSource.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
        System.out.println("Thread number: " + iCount + " List of keyword size: " + lstKeywords.size() + " startTrackid: " + startTrackId + " endTrackid: " + endtrackId);
    }

    /**
     * This method makes a search query call to dailymotion website, gets the
     * pagesource of results page, parses the pagesource, matches given domain
     * to extracted domain, if match is found, the result counter is returned as
     * rank.
     *
     * @param domain
     * @param keyword
     * @return Integer
     */
    public Integer getWebRankDailyMotion(String domain, String keyword, String linkGoogle) throws Exception {
        FetchPageHttpClientDailymotion objClient = FetchPageHttpClientDailymotion.getInstance();
        boolean b = false;
        System.out.println("keyword :" + keyword);
        int count = 0;
        String searchKeyword = keyword.replace(" ", "+");
        String matchUrl = domain;
        if (matchUrl.contains("#")) {
            matchUrl = matchUrl.substring(0, matchUrl.indexOf("#"));
        }
        matchUrl = matchUrl.replace("www.", "").trim();
        matchUrl = matchUrl.replace("http://", "").replace("https://", "");
        /*
         * @Author: Kalpana Nagle @Integer : 2 Feb 2013 @Comment : update code
         * to avoid NullPointerException
         */

        if (linkGoogle.isEmpty()) {
            linkGoogle = "google.com";
        }
        boolean statusFlag = false;
        int c = 0;
        try {
            for (int j = 0; j < 50; j++) {
                if (statusFlag) {
                    break;
                }
                String url = "";
                url = "http://www.dailymotion.com/en/relevance/universal/search/" + searchKeyword + "/" + (j + 1);
                String referer = "";
                if (j == 0) {
                    referer = "http://www.dailymotion.com/in/browse";
                } else {
                    referer = url;
                }
                try {
                    String detail = null;
                    String web_page = null;
                    String scrapedUrl = null;
                    int try_count = 0;
                    try {
                        web_page = objClient.fetchPageSourceString_Get(url, referer);
                    } catch (Exception e) {
                        l.error(e + " exception in google pagesource");
                    }
                    Pattern pattern = Pattern.compile("<h3 class=\"sd_video_wv3title dmco_title dmpi_video_title short_title\">(.*?)</h3>", Pattern.DOTALL);
                    Matcher matcher = pattern.matcher(web_page);

                    while (matcher.find()) {
                        detail = matcher.group(1);

                        try {
                            if (statusFlag) {
                                break;
                            }
                            try_count++;
                            count++;
                            c++;
                            //pattern matcher for scrapedUrl
                            try {
                                Pattern p = Pattern.compile("href=\"(.*?)\" class=\"", Pattern.DOTALL);
                                Matcher m = p.matcher(detail);
                                if (m.find()) {
                                    scrapedUrl = m.group(1);
                                }
                                scrapedUrl = "dailymotion.com" + scrapedUrl;
                            } catch (Exception e) {
                                l.error(e + "  " + e.getMessage() + " Exception come for keyword " + keyword + " Domain" + domain + "url " + url);
                            }


                            if (matchUrl.equalsIgnoreCase(scrapedUrl)) {
                                statusFlag = true;
                            }

                        } catch (Exception ex) {
                            l.debug(ex + "  " + ex.getMessage() + " Exception come for keyword " + keyword + " Domain" + domain + "url " + url);
                        }
                    }
                    if (statusFlag != true) {
                        if (c < 10) {
                            count = 1000;
                            statusFlag = true;
                            break;
                        }
                    }
                } catch (Exception ex) {
                    l.debug(ex + "  " + ex.getMessage() + " Exception come for keyword " + keyword + " Domain" + domain + "url " + url);
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage() + " Exception come for keyword " + keyword + " Domain" + domain);
        }
        if (count > 1000) {
            count = 1000;
        }
        System.out.println("Thread number " + iCount + "Google Rank for Keyword:::" + keyword + " Url:::" + domain);
        return count;
    }

    /**
     * This method passes the url and keyword from keywords list to
     *
     * @method getWebRankDailyMotion(
     * @params) and gets the result in webRankGoogle. This result is sent to
     * database layer by calling
     * @method saveGoogleResult(
     * @params).
     */
    @Override
    public void run() {
        Integer keywordId = 0;
        Integer webRankGoogle;
        try {
            for (Serpkeywords objKeywords : lstKeywords) {
                keywordId = objKeywords.getKeywordID();
                webRankGoogle = getWebRankDailyMotion(objKeywords.getUrl(), objKeywords.getKeyword(), objKeywords.getLinkGoogle());
                if (webRankGoogle == null) {
                    webRankGoogle = getWebRankDailyMotion(objKeywords.getUrl(), objKeywords.getKeyword(), objKeywords.getLinkGoogle());
                }
                webRankGoogle = webRankGoogle == null ? 0 : webRankGoogle;
                objKeywordDao.saveGoogleResult(keywordId, webRankGoogle, bestMatchRankGoogle, bestMatchLinkGoogle, startTrackId,
                        endtrackId);
            }
        } catch (Exception ex) {
            System.out.println("Googl exception" + ex);
            l.debug(ex + "  " + ex.getMessage() + " Exception come for keyword " + keywordId);
        }
    }
}
