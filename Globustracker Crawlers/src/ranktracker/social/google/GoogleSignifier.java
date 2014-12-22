package ranktracker.social.google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.Socialsignalurls;
import ranktracker.utility.ProxyPageSource;

/**
 * The crawler class gets Google plus likes for a given url.
 *
 * @author Kalpana Nagle <kalpana@globussoft.com>
 */
public class GoogleSignifier extends Thread {

    static Logger l = Logger.getLogger(GoogleSignifier.class.getName());
    /**
     * setDomains The unique collection of domains
     */
    private Set<String> setDomains;
    /**
     * lstUrls The working list of Url objects
     */
    private List<Socialsignalurls> lstUrls;
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;
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
     * @param setDomains
     * @param lstKeywords
     * @param appContext
     * @param startTrackId
     * @param endtrackId
     *
     */
    public GoogleSignifier(List<Socialsignalurls> lstUrls, ApplicationContext appContext) {
        this.lstUrls = lstUrls;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.objProxyPageSource = appContext.getBean("objProxyPageSource", ProxyPageSource.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    /**
     * This method makes a call to google plus url, gets the response in json
     * format, parses the response to extract google plus likes, and returns
     * extracted result to the caller. logic: uses google api to fetch google
     * share for the specific url
     *
     * @param url
     * @return Integer
     */
    public Integer getSocialSignifierSignal(String url) {
        String tempUrl = url;
        Integer count = 0;
        if (!url.contains("http://")) {
            url = "http://" + url;
        }

        String source = "";
        try {
            //Google uses the post mechanism to fetch google share for url
            source = objProxyPageSource.getPostSourceGoogle(url, objProxyDao);
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
            e.printStackTrace();
        }
        //google_like
        try {
            Pattern pattern = Pattern.compile("globalCounts(.*?)}");
            Matcher matcher = pattern.matcher(source);
            if (matcher.find()) {
                String temp_google_like = matcher.group(1).replace("\":", "").replace("{", "").replace("\"", "").replace("count", "").trim();
                Float google_like = Float.parseFloat(temp_google_like);
                //System.out.println(google_like);
                count = google_like.intValue();
                if (count == 0) {
                    if (url.endsWith("/")) {
                        url = url.substring(0, url.length() - 1);
                    } else {
                        url = url + "/";
                    }
                    try {
                        source = objProxyPageSource.getPostSourceGoogle(url, objProxyDao);
                    } catch (Exception e) {
                        l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
                    }

                    try {
                        Pattern pattern1 = Pattern.compile("globalCounts(.*?)}");
                        Matcher matcher1 = pattern1.matcher(source);
                        if (matcher1.find()) {
                            temp_google_like = matcher1.group(1).replace("\":", "").replace("{", "").replace("\"", "").replace("count", "").trim();
                            google_like = Float.parseFloat(temp_google_like);
                            //System.out.println(google_like);
                            count = google_like.intValue();
                        }
                    } catch (Exception e) {
                        l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
                    }
                }
            }
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
        }
        System.out.println("URL:::" + tempUrl + " Likes:::" + count);
        //System.out.println(source);
        return count;
    }

    /**
     * This method passes the url from keywords list to
     *
     * @method getSocialSignifierSignal(
     * @params) and gets the result in setResults. This result is sent to
     * database layer by calling
     * @method saveGoogleResult(
     * @params).
     */
    @Override
    public void run() {
        Map<String, Integer> setResults = new HashMap<>(0);
        try {
            for (Socialsignalurls domainName : lstUrls) {
                setResults.put(domainName.getSocialSignalUrl().trim(), getSocialSignifierSignal(domainName.getSocialSignalUrl().trim()));
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage());
        }

        Integer ssUrlId;
        Integer result;
        String domainName;
        System.out.println("---------------Url List Size : " + lstUrls.size()+" -----------------");
        try {
            for (Socialsignalurls objUrls : lstUrls) {
                domainName = objUrls.getSocialSignalUrl().trim();
                ssUrlId = objUrls.getSocialSignalUrlID();
                result = setResults.get(domainName);
                objKeywordDao.saveGooglePlusResult(ssUrlId, result);
                objKeywordDao.updateSocialGoogleplusKeywords(ssUrlId, result);
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage() + " Exception Occurred");
            //System.out.println("Google exception" + ex);
        }
    }
}
