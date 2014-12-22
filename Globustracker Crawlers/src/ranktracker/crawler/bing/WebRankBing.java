package ranktracker.crawler.bing;

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
 * The crawler class get Bing search web rank for a given keyword, url
 * combination.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class WebRankBing implements Runnable {

    static Logger l = Logger.getLogger(WebRankBing.class.getName());
    /**
     * lstKeywords The working list of Keywords objects
     */
    private List<Serpkeywords> lstKeywords = null;
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;
    /**
     * bestMatchLinkBing The best match link for a given keyword
     */
    private String bestMatchLinkBing = "";
    /**
     * bestMatchRankBing The best match rank for a given keyword
     */
    private Integer bestMatchRankBing = 0;
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
    
    public WebRankBing( List<Serpkeywords> lstKeywords, ApplicationContext appContext,
            Integer startTrackId, Integer endtrackId) {

     
        this.lstKeywords = lstKeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.startTrackId = startTrackId;
        this.endtrackId = endtrackId;
//        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
        this.objProxyPageSource = appContext.getBean("objProxyPageSource", ProxyPageSource.class);
        
    }

    /**
     * This method makes a search query call to bing website, gets the
     * pagesource of results page, parses the pagesource, matches given domain
     * to extracted domain, if match is found, the result counter is returned as
     * rank. If a matching domain is found prior to exact match of url, the
     * results counter is stored as best match.
     *
     * @param domain
     * @param keyword
     * @return Integer
     */
    public Integer getWebRankBing(String domain, String keyword) throws Exception {

        System.out.println("getWebRankBing handling:    "+domain+"                Keyword             "+keyword);
        boolean b = false;

        int count = 0;
        String searchKeyword = "+" + keyword.replace(" ", "+");;
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
            l.debug(e + "  " + e.getMessage() + " Exception come for keyword " + keyword + " Domain" + domain);
            //e.printStackTrace();
        }

        String region = "";
        try {
            String tempMatchHost = matchHost.replace(".", "@");
            String[] allValue = tempMatchHost.split("@");
            region = allValue[1].trim();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int c = 0;
        bestMatchLinkBing = "";
        bestMatchRankBing = 0;

        String url = "http://www.bing.com/search?q=" + searchKeyword;
        try {
            boolean flag = false;
            String detail = null;
            String web_page = null;
            String scrapedUrl = null;
            String temp_url = null;
//            int try_count = 0;
            boolean pageFound = false;
           
            do {    // pagination logic
                if (flag == true) {
                    
                    break;
                }
//                if (statusFlag) {
//                    break;
//                }

                temp_url = url + "&first=" + (c + 1) + "&ADLT=OFF";
                
                web_page = objProxyPageSource.getSource( temp_url,  region, "");
                web_page = web_page.replaceAll("\\s+", " ");

                Pattern pattern = Pattern.compile("class=\"sa_wr\"(.*?)</li>");
                Matcher matcher = pattern.matcher(web_page);
                
                while (matcher.find()) { //found a valid page source >increase the page no by one(done via for loop)
                    
                     pageFound=true;
                    if (flag) {
                        break;
                    }
                    detail = matcher.group(1);
              
                    try {
                        // Matching first url which is hyperlink
                            Pattern pattern2 = Pattern.compile("href=\"(.*?)\"");
                            Matcher matcher2 = pattern2.matcher(detail);
                            if (matcher2.find()) {
                                c++;
                                if(flag==true)break;
                                scrapedUrl = matcher2.group(1);
                                scrapedUrl = ReplaceAllHtmlTags.GetOnlyData(scrapedUrl);
                                scrapedUrl = scrapedUrl.replace(" ", "");
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

                        //remove last "/" from scrapedLink
                        try {
                            if (scrapedUrl.endsWith("/"))scrapedUrl = scrapedUrl.substring(0, scrapedUrl.length() - 1);
                            
                        } catch (Exception e) {
                            System.out.println(" Exception in keyword " + keyword + " Domain" + domain + "url " + url);
                        }
                        escapedUrl = escapedUrl.replace("www.", "").trim();
                        if (escapedUrl.endsWith("/")) {
                            try {
                                escapedUrl = escapedUrl.substring(0, escapedUrl.length() - 1).trim();
                            } catch (Exception e) {
                            System.out.println( " Exception in keyword " + keyword + " Domain" + domain + "url " + url);
                            }
                        }

                        String scrappedHost = null;
                        try {
                            scrappedHost = scrapedLink.getHost().trim();
                            scrappedHost = scrappedHost.replace("www.", "").trim();
                        } catch (Exception ex) {
                            System.out.println( " Exception come for keyword " + keyword + " Domain" + domain + "url " + url);
                        }
                        if (scrappedHost != null && !scrappedHost.isEmpty()) {
                            if (matchHost.equalsIgnoreCase(scrappedHost)) { // setting rank bing
                                 flag = true;
                                if (!matchUrl.equalsIgnoreCase(escapedUrl)) {// when not exact match is found
                                   
                                    // setting rank for best match link
                                   
                                        b = true;
                                        scrapedUrl = scrapedUrl.replace("http://", "");
                                        scrapedUrl = scrapedUrl.replace("https://", "");
                                        bestMatchLinkBing = scrapedUrl;
                                        bestMatchRankBing = c;
                                    
                                }
//                                break;
                                return c;
                            }
                        }
                        //Match first hyperlink ends
                        //Match for display link
                        if (flag == false) {
                            try {
                                Pattern pattern21 = Pattern.compile("<cite>(.*?)</cite>");
                                Matcher matcher21 = pattern2.matcher(detail);
                                if (matcher21.find()) {
                                    c=c+1;
                                    scrapedUrl = matcher2.group(1);
                                    scrapedUrl = ReplaceAllHtmlTags.GetOnlyData(scrapedUrl);
                                    scrapedUrl = scrapedUrl.replace(" ", "");
                                }
                            } catch (Exception e) {
                               System.out.println("Exception in keyword " + keyword + " Domain " + domain + " url " + url);
                            }
                            escapedUrl = scrapedUrl;
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
                                    System.out.println(" Exception come for keyword " + keyword + " Domain" + domain + " url " + url);
                                }
                            }

                            try {
                                scrappedHost = scrapedLink.getHost().trim();
                                scrappedHost = scrappedHost.replace("www.", "").trim();
                            } catch (Exception ex) {
                               System.out.println(" Exception in keyword " + keyword + " Domain" + domain + "url " + url);
                            }
                            if (scrappedHost != null && !scrappedHost.isEmpty()) {
                                if (matchHost.equalsIgnoreCase(scrappedHost)) {// rank found
                                       flag = true;                             
                                    if (!matchUrl.equalsIgnoreCase(escapedUrl)) {//  when not exact match is found
                                     
                                            b = true;
                                            scrapedUrl = scrapedUrl.replace("http://", "");
                                            scrapedUrl = scrapedUrl.replace("https://", "");
                                            bestMatchLinkBing = scrapedUrl;
                                            bestMatchRankBing = c;
                                    
                                    }
//                                    break;
                                    return c;
                                }
                            }
                        }
                        //Match for display link ends
                    } catch (Exception ex) {
                        System.out.println("Exception in keyword " + keyword + " Domain " + domain + " url " + url);
                        //ex.printStackTrace();
                    }
                }
                if (flag == true) {
                    break;
                }
            }while(c<1000);
        } catch (Exception ex) {
            System.out.println(" Exception come for keyword " + keyword + " Domain " + domain + " url " + url);
            ex.printStackTrace();
        }
//        System.out.println("RankBing= "+count+"   Keyword: "+keyword +" Url:  "+domain);
              System.out.println("RankCount: "+c+"  bestMatchLink= "+bestMatchLinkBing);
        return c;
    }

    /**
     * This method passes the url and keyword from keywords list to
     *
     * @method getWebRankBing(
     * @params) and gets the result in webRankBing. This result is sent to
     * database layer by calling
     * @method saveBingResult(
     * @params).
     */
    @Override
    public void run() {
        Integer keywordId = 0;
        Integer webRankBing;
        try {
            for (Serpkeywords objKeywords : lstKeywords) {
                keywordId = objKeywords.getKeywordID();
                webRankBing = getWebRankBing(objKeywords.getUrl(), objKeywords.getKeyword());
                webRankBing = webRankBing == null ? 0 : webRankBing;
                
                // checking for bestMatchRankBing or RankBing
                if(bestMatchRankBing!=0)webRankBing=0;
                
                objKeywordDao.saveBingResult(keywordId, webRankBing, bestMatchRankBing, bestMatchLinkBing, startTrackId,
                        endtrackId);
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage() + " Exception come for keywordID " + keywordId);
        }
    }
}
