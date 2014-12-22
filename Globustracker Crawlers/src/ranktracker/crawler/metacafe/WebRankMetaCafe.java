package ranktracker.crawler.metacafe;

import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;
import ranktracker.utility.FetchPage;
import ranktracker.utility.FetchPageHttpClientVimeo;

/**
 * The crawler class get Metacafe search web rank for a given keyword, url
 * combination.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class WebRankMetaCafe extends Thread {

    static Logger l = Logger.getLogger(WebRankMetaCafe.class.getName());
    /**
     * lstKeywords The working list of Keywords objects
     */
    private List<Serpkeywords> lstKeywords = null;
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;
    /**
     * startTrackId The first trackid for a given crawl thread
     */
    private Integer startTrackId;
    /**
     * endtrackId The last trackid for a given crawl thread
     */
    private Integer endtrackId;
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
    public WebRankMetaCafe(Integer iCount, List<Serpkeywords> lstKeywords, ApplicationContext appContext,
            Integer startTrackId, Integer endtrackId) {

        this.iCount = iCount;
        this.lstKeywords = lstKeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.startTrackId = startTrackId;
        this.endtrackId = endtrackId;
        System.out.println("Thread number: " + iCount + " List of keyword size: " + lstKeywords.size() + " startTrackid: " + startTrackId + " endTrackid: " + endtrackId);
        //System.out.println("I am in constructor Active Thread:::" + Thread.activeCount());
    }

    /**
     * This method makes a search query call to metacafe website, gets the
     * pagesource of results page, parses the pagesource, matches given domain
     * to extracted domain, if match is found, the result counter is returned as
     * rank.
     *
     * @param domain
     * @param keyword
     * @return Integer
     */
    public Integer getWebRankMetaCafe(String domain, String keyword, String linkGoogle) throws Exception {

        //initializing the httpclient object
        FetchPageHttpClientVimeo objClient = FetchPageHttpClientVimeo.getInstance();
        boolean b = false;
        System.out.println("keyword :" + keyword);
        int count = 0;

        //initializing <searchKeyword>
        String searchKeyword = URLEncoder.encode(keyword, "UTF-8").replace("+", "_").replace("%20", "_");

        //initializing <matchUrl>
        String matchUrl = domain;

        //removing end '/' from <matchUrl>
        if (matchUrl.endsWith("/")) {
            matchUrl = matchUrl.substring(0, matchUrl.length() - 1);
        }

        //replacing 'www.' from <matchUrl>
        matchUrl = matchUrl.replace("www.", "").trim();

        //replacing 'http://' and 'https://' from <matchUrl>
        matchUrl = matchUrl.replace("http://", "").replace("https://", "");

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
                String url = "";

                //forming the metacafe url
                url = "http://www.metacafe.com/topics/" + searchKeyword + "/page-" + (j + 1) + "/";
                String referer = "";
                if (j == 0) {
                    referer = "http://www.metacafe.com/";
                } else {
                    referer = url;
                }
                try {
                    String detail = null;
                    String web_page = null;
                    String scrapedUrl = null;
                    int try_count = 0;
                    try {

                        //getting the pagesource for <url>
                        web_page = objClient.fetchPageSourceString_Get(url, referer);
                    } catch (Exception e) {
                        l.error(e + " exception in google pagesource");
                    }

                    //scrape only the source where the urls are listed
                    try {
                        Pattern pattern = Pattern.compile("id=\"Catalog1\">(.*?)<ul class=\"PageSelector\">", Pattern.DOTALL);
                        Matcher matcher = pattern.matcher(web_page);
                        if (matcher.find()) {
                            web_page = matcher.group(1);
                        }
                    } catch (Exception e) {
                        l.error(e);
                    }

                    Pattern pattern = Pattern.compile("<h1 class=\"ItemTitle\">(.*?) href=\"(.*?)\" title=\"", Pattern.DOTALL);
                    Matcher matcher = pattern.matcher(web_page);

                    while (matcher.find()) {
                        detail = matcher.group(2);
                        //if scrapedurl i.e <detail> is having end '/', then remove it
                        if (detail.endsWith("/")) {
                            detail = detail.substring(0, detail.length() - 1);
                        }

                        //forming the complete metacafe url
                        detail = "metacafe.com" + detail;
                        try {
                            if (statusFlag) {
                                break;
                            }
                            try_count++;
                            count++;
                            c++;
                            //pattern matcher for scrapedUrl
                            scrapedUrl = detail;
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
        System.out.println("Thread number " + iCount + "Google Rank for Keyword:::" + keyword + " Url:::" + domain);
        return count;
    }

    /**
     * This method passes the url and keyword from keywords list to
     *
     * @method getWebRankMetaCafe(
     * @params) and gets the result in webRankMetaCafe. This result is sent to
     * database layer by calling
     * @method saveGoogleResult(
     * @params).
     */
    @Override
    public void run() {
        Integer keywordId = 0;
        Integer webRankMetaCafe;
        try {
            for (Serpkeywords objKeywords : lstKeywords) {

                //iterating for each loop for <lstKeywords>
                keywordId = objKeywords.getKeywordID();

                //calling getWebRankMetaCafe() for keyword and url
                webRankMetaCafe = getWebRankMetaCafe(objKeywords.getUrl(), objKeywords.getKeyword(), objKeywords.getLinkGoogle());
                if (webRankMetaCafe == null) {
                    webRankMetaCafe = getWebRankMetaCafe(objKeywords.getUrl(), objKeywords.getKeyword(), objKeywords.getLinkGoogle());
                }
                webRankMetaCafe = webRankMetaCafe == null ? 0 : webRankMetaCafe;
                objKeywordDao.saveGoogleResult(keywordId, webRankMetaCafe, 0, "", startTrackId,
                        endtrackId);
            }
        } catch (Exception ex) {
            System.out.println("Googl exception" + ex);
            l.debug(ex + "  " + ex.getMessage() + " Exception come for keyword " + keywordId);
        }
    }
}
