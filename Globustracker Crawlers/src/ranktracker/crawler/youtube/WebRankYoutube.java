package ranktracker.crawler.youtube;

import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.Serpkeywords;
import ranktracker.utility.FetchPage;
import ranktracker.utility.FetchPageHttpClient;
import ranktracker.utility.ProxyPageSource;
import ranktracker.utility.FetchPageHttpClientYoutube;

/**
 * The crawler class get youtube search web rank for a given keyword, url
 * combination.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class WebRankYoutube extends Thread {

    static Logger l = Logger.getLogger(WebRankYoutube.class.getName());
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
    public WebRankYoutube(Integer iCount, List<Serpkeywords> lstKeywords, ApplicationContext appContext) {

        this.iCount = iCount;
        this.lstKeywords = lstKeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.objProxyPageSource = appContext.getBean("objProxyPageSource", ProxyPageSource.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
        System.out.println("Thread number: " + iCount + " List of keyword size: " + lstKeywords.size() + " startTrackid: " + startTrackId + " endTrackid: " + endtrackId);
    }

    /**
     * This method makes a search query call to youtube website, gets the
     * pagesource of results page, parses the pagesource, matches given domain
     * to extracted domain, if match is found, the result counter is returned as
     * rank.
     *
     * @param domain
     * @param keyword
     * @return Integer
     */
    public Integer getyahooRankGoogle(String domain, String keyword, String linkGoogle) throws Exception {

        //initializing the httpclient object
        FetchPageHttpClientYoutube objFetchPage =new FetchPageHttpClientYoutube();
        System.out.println("keyword :" + keyword);
        int count = 0;
        String searchKeyword = "";

        //initializing <searchKeyword>
        searchKeyword = URLEncoder.encode(keyword, "UTF-8");

        //initializing <matchUrl>
        String matchUrl = domain;

        //replacing 'www.','http://' and 'https://' from <matchUrl>
        matchUrl = matchUrl.replace("http://", "").replace("https://", "").replace("www.", "").trim();
        System.out.println("matchUrl = " + matchUrl);
        /*
         * @Author: Kalpana Nagle @Integer : 2 Feb 2013 @Comment : update code
         * to avoid NullPointerException
         */

        boolean statusFlag = false;
        int c = 0;
        try {
            for (int j = 0; j < 100; j++) {
                if (statusFlag) {
                    break;
                }

                //forming the youtube url
                String url = "http://www.youtube.com/results?search_query=" + searchKeyword + "&oq=" + searchKeyword + "&page=" + (j + 1);
                try {
                    String web_page = null;
                    String scrapedUrl = null;
                    int try_count = 0; 

                    try {

                        //getting the pagesource for <url>
                        web_page = objFetchPage.fetchPageSourceString_Get(url, "youtube.com");
                    } catch (Exception e) {
                        l.error(e + " exception in google pagesource");
                    }
                    Pattern pattern = Pattern.compile("<h3 class=\"yt-lockup2-title\">(.*?)</h3>");
                    Matcher matcher = pattern.matcher(web_page);
                    String data = "";
                    while (matcher.find()) {
                        try {
                            if (statusFlag) {
                                break;
                            }
                            data = matcher.group(1);

                            //now replacing the multiple spaces by a single space
                            data = data.replaceAll("\\s+", "");


                            if (!data.contains("/watch?v=")) {
                                //this is not youtube video url
                                continue;
                            }


                            //pattern matcher for scrapedUrl
                            try {

                                //retrieving the index for youtube video url
                                int startIndex = data.indexOf("href=\"", 0);
                                int endIndex = data.indexOf("\"", startIndex + 7);
                                scrapedUrl = data.substring(startIndex, endIndex).replace("href=\"", "");
                                System.out.println("Youtube url "+scrapedUrl);
                                //now forming the complete youtube video url
                                scrapedUrl = "youtube.com" + scrapedUrl;
                                System.out.println("New url "+scrapedUrl);
                            } catch (Exception e) {
                                l.debug(e + "  " + e.getMessage() + " Exception come for keyword " + keyword + " Domain" + domain + "url " + url);
                            }

                            try_count++;
                            count++;
                            c++;

                            //remove last "/" from scrapedUrl
                            try {
                                if (scrapedUrl.endsWith("/")) {
                                    scrapedUrl = scrapedUrl.substring(0, scrapedUrl.length() - 1);
                                    System.out.println("Changed url "+scrapedUrl);
                                }
                            } catch (Exception e) {
                                l.debug(e + "  " + e.getMessage() + " Exception come for keyword " + keyword + " Domain" + domain + "url " + url);
                            }

                            //matching url for rank
                            if (matchUrl.equalsIgnoreCase(scrapedUrl)) {

                                //if url matches then exact match found
                                //make the statusFlag as 'true'
                                //statusFlag terminate the loop and return the count
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
        System.out.println("Google Rank for Keyword:::" + keyword + " Url:::" + domain);
        return count;
    }

    /**
     * This method passes the url and keyword from keywords list to
     *
     * @method getyahooRankGoogle(
     * @params) and gets the result in webRankYahoo. This result is sent to
     * database layer by calling
     * @method saveGoogleResult(
     * @params).
     */
    @Override
    public void run() {
        Integer keywordId = 0;
        Integer webRankYahoo;
        String keyword;
        try {
            for (Serpkeywords objKeywords : lstKeywords) {
                keywordId = objKeywords.getKeywordID();
                webRankYahoo = getyahooRankGoogle(objKeywords.getUrl(), objKeywords.getKeyword(), objKeywords.getLinkGoogle());
                if (webRankYahoo == null) {
                    webRankYahoo = getyahooRankGoogle(objKeywords.getUrl(), objKeywords.getKeyword(), objKeywords.getLinkGoogle());
                }
                webRankYahoo = webRankYahoo == null ? 0 : webRankYahoo;
                keyword=objKeywords.getKeyword();
                //objKeywordDao.saveYoutubeResult(keywordId,keyword);
            }
        } catch (Exception ex) {
            System.out.println("Googl exception" + ex);
            l.debug(ex + "  " + ex.getMessage() + " Exception come for keyword " + keywordId);
        }
    }
}
