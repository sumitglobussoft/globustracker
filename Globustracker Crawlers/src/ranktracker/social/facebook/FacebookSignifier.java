package ranktracker.social.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.utility.ProxyPageSource;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.Socialsignalurls;

/**
 * The crawler class gets Facebook likes and Facebook shares for a given url.
 *
 * @author Kalpana Nagle <kalpana@globussoft.com>
 */
public class FacebookSignifier extends Thread {

    static Logger l = Logger.getLogger(FacebookSignifier.class.getName());
    /**
     * setDomains The unique collection of domains
     */
    private Set<String> setDomains;
    /**
     * objProxyDao The database layer ProxyDao object variable
     */
    private ProxyDao objProxyDao;
    /**
     * objProxyPageSource The utility class ProxyPageSource object variable
     */
    private ProxyPageSource objProxyPageSource;
    /**
     * lstUrls The working list of Url objects
     */
    private List<Socialsignalurls> lstUrls;
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
     * @param setDomains
     * @param lstKeywords
     * @param appContext
     * @param startTrackId
     * @param endtrackId
     *
     */
    public FacebookSignifier(List<Socialsignalurls> lstUrls, ApplicationContext appContext) {
        this.lstUrls = lstUrls;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.objProxyPageSource = appContext.getBean("objProxyPageSource", ProxyPageSource.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    /**
     * This method makes a call to facebook api url, gets the response in json
     * format, parses the response to extract facebook likes and shares, and
     * returns extracted result to the caller. logic: uses facebook api to fetch
     * likes and shares for the specific url please see line no 92 which uses
     * facebook api url.
     *
     * @param url
     * @return Integer
     */
    public Integer[] getSocialSignifierSignal(String url) {
        String tempUrl = url;
        if (!(url.startsWith("www.")) || !(url.startsWith("http://"))) { // checking for proper url forma
            url = "http://www." + url;
        }

        Integer[] result = new Integer[2];
        result[0] = 0;
        result[1] = 0;
        url = "http://api.ak.facebook.com/restserver.php?v=1.0&method=links.getStats&format=json&callback=fb_sharepro_render&urls=" + url;
        String source = "";
        try {
            source = objProxyPageSource.makeRequest(url, "");
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
            e.printStackTrace();
        }
        //share_count
        try {
            Pattern pattern = Pattern.compile("share_count(.*?),");
            Matcher matcher = pattern.matcher(source);
            if (matcher.find()) {
                String temp_share_count = matcher.group(1).replace("\":", "").trim();
                Integer share_count = Integer.parseInt(temp_share_count);
                //System.out.println(share_count);
                result[0] = share_count;
            }
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
        }

        //like_count
        try {
            Pattern pattern = Pattern.compile("like_count(.*?),");
            Matcher matcher = pattern.matcher(source);
            if (matcher.find()) {
                String temp_like_count = matcher.group(1).replace("\":", "").trim();
                Integer like_count = Integer.parseInt(temp_like_count);
                //System.out.println(like_count);
                result[1] = like_count;
            }
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
        }

        if (result[0] == 0 && result[1] == 0) {
            source = "";
            if (url.endsWith("/")) {
                url = url.substring(0, url.length() - 1);
            } else {
                url = url + "/";
            }
            try {
                source = objProxyPageSource.makeRequest(url, "");
            } catch (Exception e) {
                l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
                e.printStackTrace();
            }

            //share_count
            try {
                Pattern pattern = Pattern.compile("share_count(.*?),");
                Matcher matcher = pattern.matcher(source);
                if (matcher.find()) {
                    String temp_share_count = matcher.group(1).replace("\":", "").trim();
                    Integer share_count = Integer.parseInt(temp_share_count);
                    //System.out.println(share_count);
                    result[0] = share_count;
                }
            } catch (Exception e) {
                l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
            }

            //like_count
            try {
                Pattern pattern = Pattern.compile("like_count(.*?),");
                Matcher matcher = pattern.matcher(source);
                if (matcher.find()) {
                    String temp_like_count = matcher.group(1).replace("\":", "").trim();
                    Integer like_count = Integer.parseInt(temp_like_count);
                    //System.out.println(like_count);
                    result[1] = like_count;
                }
            } catch (Exception e) {
                l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
            }
        }
        System.out.println("URL:::" + tempUrl + " Likes:::" + result[1] + " Share:::" + result[0]);
        return result;
    }

    /**
     * This method passes the url from keywords list to
     *
     * @method getSocialSignifierSignal(
     * @params) and gets the result in setResults[]. This result is sent to
     * database layer by calling
     * @method saveFacebookResult(
     * @params).
     */
    @Override
    public void run() {
        Map<String, Integer[]> setResults = new HashMap<>(0);
        try {
            for (Socialsignalurls domainName : lstUrls) {
                try {
                    System.out.println("Fetching Facebook Like and Shares for url:::" + domainName);
                    setResults.put(domainName.getSocialSignalUrl().trim(), getSocialSignifierSignal(domainName.getSocialSignalUrl().trim()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage());
        }
        Integer ssUrlId;
        Integer result[];
        String domainName;
        System.out.println("---------------Url List Size : " + lstUrls.size() + " -----------------");
        try {
            for (Socialsignalurls objUrls : lstUrls) {
                domainName = objUrls.getSocialSignalUrl().trim();
                ssUrlId = objUrls.getSocialSignalUrlID();
                result = setResults.get(domainName);
                objKeywordDao.saveFacebookResult(ssUrlId, result);
                objKeywordDao.updateSocialFacebookKeywords(ssUrlId, result);
            }
        } catch (Exception ex) {
            //l.debug(ex + "  " + ex.getMessage());
            System.out.println("Facebook exception" + ex);
        }
    }
}
