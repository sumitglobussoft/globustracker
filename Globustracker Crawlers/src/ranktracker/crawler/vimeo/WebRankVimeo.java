package ranktracker.crawler.vimeo;

import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;
import ranktracker.utility.FetchPage;
import ranktracker.utility.FetchPageHttpClient;
import ranktracker.utility.FetchPageHttpClientVimeo;

/**
 * The crawler class get Vimeo search web rank for a given keyword, url
 * combination.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class WebRankVimeo extends Thread {

    static Logger l = Logger.getLogger(WebRankVimeo.class.getName());
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
    public WebRankVimeo(Integer iCount, List<Serpkeywords> lstKeywords, ApplicationContext appContext,
            Integer startTrackId, Integer endtrackId) {

        this.iCount = iCount;
        this.lstKeywords = lstKeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.startTrackId = startTrackId;
        this.endtrackId = endtrackId;
        System.out.println("Thread number: " + iCount + " List of keyword size: " + lstKeywords.size() + " startTrackid: " + startTrackId + " endTrackid: " + endtrackId);
    }

    /**
     * This method makes a search query call to vimeo website, gets the
     * pagesource of results page, parses the pagesource, matches given domain
     * to extracted domain, if match is found, the result counter is returned as
     * rank.
     *
     * @param domain
     * @param keyword
     * @return Integer
     */
    public Integer getWebRankVimeo(String domain, String keyword, String linkGoogle) throws Exception {
        
         //initializing the httpclient object
        FetchPageHttpClientVimeo objClient =FetchPageHttpClientVimeo.getInstance();
        boolean b = false;
        System.out.println("keyword :" + keyword);
        int count = 0;
        
        //initializing <searchKeyword>
        String searchKeyword = URLEncoder.encode(keyword, "UTF-8");
        
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
                
                //forming the vimeo url
                url = "http://vimeo.com/search/page:" + (j + 1) + "/sort:relevant/format:thumbnail?q=" + searchKeyword;
                try {
                    String detail = null;
                    String web_page = null;
                    String scrapedUrl = null;
                    int try_count = 0;
                    try {
                        
                        //getting the pagesource for <url>
                        web_page = objClient.fetchPageSourceString_Get(url, "");
                    } catch (Exception e) {
                        l.error(e + " exception in google pagesource");
                    }

                    Pattern pattern = Pattern.compile("id=\"clip_(.*?)\"", Pattern.DOTALL);
                    Matcher matcher = pattern.matcher(web_page);

                    while (matcher.find()) {
                        detail = matcher.group(1);
                        
                        //if scrapedurl i.e <detail> is having end '/', then remove it
                        if (detail.endsWith("/")) {
                            detail = detail.substring(0, detail.length() - 1);
                        }
                        
                        //forming the complete vimeo url
                        detail = "vimeo.com/" + detail;
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
     * @method getWebRankVimeo(
     * @params) and gets the result in webRankVimeo. This result is sent to
     * database layer by calling
     * @method saveGoogleResult(
     * @params).
     */
    @Override
    public void run() {
        Integer keywordId = 0;
        Integer webRankVimeo;
        try {
            for (Serpkeywords objKeywords : lstKeywords) {
                keywordId = objKeywords.getKeywordID();
                webRankVimeo = getWebRankVimeo(objKeywords.getUrl(), objKeywords.getKeyword(), objKeywords.getLinkGoogle());
                if (webRankVimeo == null) {
                    webRankVimeo = getWebRankVimeo(objKeywords.getUrl(), objKeywords.getKeyword(), objKeywords.getLinkGoogle());
                }
                webRankVimeo = webRankVimeo == null ? 0 : webRankVimeo;
                objKeywordDao.saveGoogleResult(keywordId, webRankVimeo, 0, "", startTrackId,
                        endtrackId);
            }
        } catch (Exception ex) {
            System.out.println("Googl exception" + ex);
            l.debug(ex + "  " + ex.getMessage() + " Exception come for keyword " + keywordId);
        }
    }
}
