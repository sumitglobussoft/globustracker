package ranktracker.social.stumble;

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
 * The crawler class gets Stumbleupon stumbles for a given url.
 *
 * @author Kalpana Nagle <kalpana@globussoft.com>
 */
public class StumbleSignifier extends Thread {

    static Logger l = Logger.getLogger(StumbleSignifier.class.getName());
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
    public StumbleSignifier(List<Socialsignalurls> lstUrls, ApplicationContext appContext) {
        this.lstUrls = lstUrls;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.objProxyPageSource = appContext.getBean("objProxyPageSource", ProxyPageSource.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    /**
     * This method makes an api call to Stumbleupon url, gets the response in
     * json format, parses the response to extract Stumbleupon stumbles and
     * returns extracted result to the caller. logic: uses stumbleupon api to
     * fetch publicid for the specific url,see line no 94 for stumbleupon api
     * url. now ,this publicid will use in stumbleurl to fetch number of likes
     * for particular url,see line no 107
     *
     * @param url
     * @return Integer
     */
    public Integer getSocialSignifierSignal(String url) {

        String tempUrl = url;
        Integer likes = 0;

        url = "http://www.stumbleupon.com/services/1.01/badge.getinfo?url=" + url;
        String stumbleUrl = "";

        //publicid

        try {
            String source = "";
            String temp_publicid = "";
            source = objProxyPageSource.makeRequest(url, "");
            //source = objProxyPageSource.getSource(iCount, url, objProxyDao, "", "");
            Pattern pattern = Pattern.compile("publicid(.*?),");
            Matcher matcher = pattern.matcher(source);
            if (matcher.find()) {
                temp_publicid = matcher.group(1).replace("\":", "").replace("\"", "").trim();
                stumbleUrl = "http://www.stumbleupon.com/content/" + temp_publicid;
                String objsource = objProxyPageSource.makeRequest(stumbleUrl, "");
                Pattern pattern1 = Pattern.compile("<mark class=\"nav-tertiary-count\">(.*?)</mark>");
                Matcher matcher1 = pattern1.matcher(objsource);
                if (matcher1.find()) {
                    String temp_like = matcher1.group(1);
                    if (temp_like.contains("K")) {
                        temp_like = temp_like.replace("K", "000").trim();
                    }
                    temp_like = temp_like.replace(",", "");
                    likes = Integer.parseInt(temp_like);

                }
            }
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
            e.printStackTrace();
        }
        System.out.println("URL:::" + tempUrl + " Stumble Likes:::" + likes);
        return likes;
    }

    /**
     * This method passes the url from keywords list to
     *
     * @method getSocialSignifierSignal(
     * @params) and gets the result in setResults. This result is sent to
     * database layer by calling
     * @method saveStumbleResult(
     * @params).
     */
    @Override
    public void run() {
        Map<String, Integer> setResults = new HashMap<>(0);
        try {
            for (Socialsignalurls domainName : lstUrls) {
                System.out.println("Fetching Stumble Likes for url:::" + domainName.getSocialSignalUrl());
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
                objKeywordDao.saveStumbleResult(ssUrlId, result);
                objKeywordDao.updateSocialStumbleKeywords(ssUrlId, result);
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage());
            //System.out.println("Stumble exception" + ex);
        }
        //getSocialSignifierSignal("http://www.stumbleupon.com/services/1.01/badge.getinfo?url=" + url);
    }
}
