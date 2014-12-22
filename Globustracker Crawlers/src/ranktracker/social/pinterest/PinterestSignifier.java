package ranktracker.social.pinterest;

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
 * The crawler class gets Pinterest Pins for a given url.
 *
 * @author Kalpana Nagle <kalpana@globussoft.com>
 */
public class PinterestSignifier extends Thread {

    static Logger l = Logger.getLogger(PinterestSignifier.class.getName());
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
    public PinterestSignifier(List<Socialsignalurls> lstUrls, ApplicationContext appContext) {
        this.lstUrls = lstUrls;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.objProxyPageSource = appContext.getBean("objProxyPageSource", ProxyPageSource.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    /**
     * This method makes an api call to pinterest url, gets the response in json
     * format, parses the response to extract Pinterest Pins, and returns
     * extracted result to the caller. logic: uses pinterest api to fetch count
     * for the specific url please see line no 96 which uses pinterest api url.
     *
     * @param url
     * @return Integer
     */
    public Integer getSocialSignifierSignal(String url) {
        String tempUrl = url;
        Integer count = 0;

        if (tempUrl.endsWith("/")) {
            tempUrl = tempUrl.substring(0, tempUrl.length() - 1);
        }

        if (tempUrl.contains("www")) {
            tempUrl = tempUrl.replace("www.", "");
        }
        if (!tempUrl.contains("http://")) {
            tempUrl = "http://" + tempUrl;
        }

        url = "http://api.pinterest.com/v1/urls/count.json?callback=receiveCount&url=" + tempUrl;
        String source = "";
        try {
            source = objProxyPageSource.makeRequest(url, "");
        } catch (Exception e) {
            l.error(e + "  " + e.getMessage() + " Exception come for url " + url);
            e.printStackTrace();
        }
        //Count
        try {
            Pattern pattern = Pattern.compile("count(.*?),");
            Matcher matcher = pattern.matcher(source);
            if (matcher.find()) {
                String temp_count = matcher.group(1).replace("\":", "").trim();
                count = Integer.parseInt(temp_count);
                //System.out.println(count);
            }
        } catch (Exception e) {
            l.error(e + "  " + e.getMessage() + " Exception come for url " + url);
        }

        //if count is 0 then concatenate end / in tempUrl
        if (count == 0) {
            tempUrl = tempUrl + "/";
            url = "http://api.pinterest.com/v1/urls/count.json?callback=receiveCount&url=" + tempUrl;
            try {
                source = objProxyPageSource.makeRequest(url, "");
            } catch (Exception e) {
                l.error(e + "  " + e.getMessage() + " Exception come for url " + url);
            }
            try {
                Pattern pattern = Pattern.compile("count(.*?),");
                Matcher matcher = pattern.matcher(source);
                if (matcher.find()) {
                    String temp_count = matcher.group(1).replace("\":", "").trim();
                    count = Integer.parseInt(temp_count);
                    //System.out.println(count);
                }
            } catch (Exception e) {
                l.error(e + "  " + e.getMessage() + " Exception come for url " + url);
            }
        }

        //if count is 0 then concatenate www in tempUrl
        if (count == 0) {
            tempUrl = tempUrl.replace("http://", "http://www.");
            url = "http://api.pinterest.com/v1/urls/count.json?callback=receiveCount&url=" + tempUrl;
            try {
                source = objProxyPageSource.makeRequest(url, "");
            } catch (Exception e) {
                l.error(e + "  " + e.getMessage() + " Exception come for url " + url);
            }
            try {
                Pattern pattern = Pattern.compile("count(.*?),");
                Matcher matcher = pattern.matcher(source);
                if (matcher.find()) {
                    String temp_count = matcher.group(1).replace("\":", "").trim();
                    count = Integer.parseInt(temp_count);
                }
            } catch (Exception e) {
                l.error(e + "  " + e.getMessage() + " Exception come for url " + url);
            }
        }
        System.out.println("URL:::" + tempUrl + " Pins:::" + count);
        return count;
    }

    /**
     * This method passes the url from keywords list to
     *
     * @method getSocialSignifierSignal(
     * @params) and gets the result in setResults. This result is sent to
     * database layer by calling
     * @method savePinterestResult(
     * @params).
     */
    @Override
    public void run() {
        Map<String, Integer> setResults = new HashMap<>(0);
        try {
            for (Socialsignalurls domainName : lstUrls) {
                System.out.println("Fetching Pinterest Pins for url:::" + domainName.getSocialSignalUrl());
                setResults.put(domainName.getSocialSignalUrl().trim(), getSocialSignifierSignal(domainName.getSocialSignalUrl().trim()));
            }
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
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
                objKeywordDao.savePinterestResult(ssUrlId, result);
                objKeywordDao.updateSocialPinterestKeywords(ssUrlId, result);
            }
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage() + " Exception occurred");
            //System.out.println("Pinterest exception" + ex);
        }
    }
}
