package ranktracker.crawler.yahoo;

import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.utility.ProxyPageSource;
import ranktracker.utility.ReplaceAllHtmlTags;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.Serpkeywords;

/**
 * The crawler class get Yahoo search web rank for a given keyword, url
 * combination.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class WebRankYahoo implements Runnable {

    static Logger l = Logger.getLogger(WebRankYahoo.class.getName());
    /**
     * lstKeywords The working list of Keywords objects
     */
    private List<Serpkeywords> lstKeywords = null;
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;
    /**
     * bestMatchLinkYahoo The best match link for a given keyword
     */
    private String bestMatchLinkYahoo = "";
    /**
     * bestMatchRankYahoo The best match rank for a given keyword
     */
    private Integer bestMatchRankYahoo = 0;
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
    public WebRankYahoo(List<Serpkeywords> lstKeywords, ApplicationContext appContext,
            Integer startTrackId, Integer endtrackId) {

        this.iCount = iCount;
        this.lstKeywords = lstKeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.startTrackId = startTrackId;
        this.endtrackId = endtrackId;
        this.objProxyPageSource = appContext.getBean("objProxyPageSource", ProxyPageSource.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    /**
     * This method makes a search query call to yahoo website, gets the
     * pagesource of results page, parses the pagesource, matches given domain
     * to extracted domain, if match is found, the result counter is returned as
     * rank. If a matching domain is found prior to exact match of url, the
     * results counter is stored as best match.
     *
     * @param domain
     * @param keyword
     * @return Integer
     */
    public Integer getWebRankYahoo(String domain, String keyword) throws Exception {
        boolean b = false;


        int c = 0;
        String searchKeyword = "+" + keyword.replace(" ", "%20");
        String matchUrl = domain;
        matchUrl = matchUrl.replace("www.", "");

        String matchHost = "";
        try {
            String tempMatchUrl = "";
            tempMatchUrl = "http://" + matchUrl;
            URL matchLink = new URL(tempMatchUrl);
            matchHost = matchLink.getHost();
            matchHost = matchHost.replace("www.", "").trim();
        } catch (Exception e) {
            System.out.println("Exception in keyword " + keyword + " Domain" + domain);
        }
        bestMatchLinkYahoo = "";
        bestMatchRankYahoo = 0;
        boolean flag = false;
        try {
            String url = "http://search.yahoo.com/search?p=" + searchKeyword + "&n=100";
            boolean statusFlag = false;
            
            String web_desc = null;
            String detail = null;
            String web_page = null;
            String scrapedUrl = null;
            String temp_url = null;
            int try_count = 0;
            for (int i = 0; i < 10 && !flag; i++) {
                if (statusFlag) {
                    break;
                }
                temp_url = url + "&b=" + (i * 100 + 1);
                web_page = objProxyPageSource.getSource(temp_url, "", "");

                Pattern pattern = Pattern.compile("<div class=\"res\">(.*?)</li>");
                Matcher matcher = pattern.matcher(web_page);

                while (matcher.find()) {



                    detail = matcher.group(1);
                    if (statusFlag) {
                        break;
                    }


                    //pattern matcher for scrapedUrl
                    try {
                        Pattern pattern1 = Pattern.compile("<span class=url>(.*?)</span>");
                        Matcher matcher1 = pattern1.matcher(detail);
                        if (matcher1.find()) {
                            c++;
                            scrapedUrl = matcher1.group(1);
                            scrapedUrl = ReplaceAllHtmlTags.GetOnlyData(scrapedUrl);
                            scrapedUrl = scrapedUrl.replace(" ", "");
                        }
                    } catch (Exception e) {
                        System.out.println(" Exception in keyword " + keyword + " Domain " + domain + " url " + url);
                    }

                    URL scrapedLink = null;
                    String escapedUrl = scrapedUrl;
                    if (scrapedUrl.contains("https://") || scrapedUrl.contains("http://")) {
                        scrapedLink = new URL(scrapedUrl);
                        escapedUrl = escapedUrl.replace("https://", "");
                        escapedUrl = escapedUrl.replace("http://", "");
                    } else {
                        scrapedLink = new URL("http://" + scrapedUrl);
                    }
                    escapedUrl = escapedUrl.replace("www.", "").trim();
                    if (escapedUrl.endsWith("/")) {
                        try {
                            escapedUrl = escapedUrl.substring(0, escapedUrl.length() - 1).trim();
                        } catch (Exception e) {
                            System.out.println(" Exception come for keyword " + keyword + " Domain" + domain + "url " + url);
                        }
                    }

                    String scrappedHost = null;
                    try {
                        scrappedHost = scrapedLink.getHost().trim();
                        scrappedHost = scrappedHost.replace("www.", "").trim();
                    } catch (Exception ex) {
                        System.out.println(" Exception come for keyword " + keyword + " Domain" + domain + "url " + url);
                    }
                    if (scrappedHost != null && !scrappedHost.isEmpty()) {
                        if (matchHost.equalsIgnoreCase(scrappedHost)) {
                            flag = true;
                            if (!matchUrl.equalsIgnoreCase(escapedUrl)) {

                                b = true;
                                scrapedUrl = scrapedUrl.replace("http://", "");
                                scrapedUrl = scrapedUrl.replace("https://", "");
                                bestMatchLinkYahoo = scrapedUrl;
                                bestMatchRankYahoo = c;
                            }
//                            break;
                            return c;
                        }
                    }
                    
                }
                if (flag == true) {
                    break;
                }

            }


        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage() + " Exception come for keyword " + keyword + " Domain" + domain);
            ex.printStackTrace();
        }
        System.out.println("RankYahoo= " + c +" bestMatchRank= "+bestMatchRankYahoo);
        return c;
    }

    /**
     * This method passes the url and keyword from keywords list to
     *
     * @method getWebRankYahoo(
     * @params) and gets the result in webRankYahoo. This result is sent to
     * database layer by calling
     * @method saveYahooResult(
     * @params).
     */
    @Override
    public void run() {
        Integer webRankYahoo;
        Integer keywordId;
        try {
            for (Serpkeywords objKeywords : lstKeywords) {
                keywordId = objKeywords.getKeywordID();
                webRankYahoo = getWebRankYahoo(objKeywords.getUrl(), objKeywords.getKeyword());
                webRankYahoo = webRankYahoo == null ? 0 : webRankYahoo;
                
                if(bestMatchRankYahoo!=0)webRankYahoo=0;
                objKeywordDao.saveYahooResult(keywordId, webRankYahoo, bestMatchRankYahoo, bestMatchLinkYahoo, startTrackId,
                        endtrackId);
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage());

        }
    }
}
