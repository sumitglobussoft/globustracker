package ranktracker.social.reddit;

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
 * The crawler class gets Reddit votes for a given url.
 *
 * @author Kalpana Nagle <kalpana@globussoft.com>
 */
public class RedditSignifier extends Thread {

    static Logger l = Logger.getLogger(RedditSignifier.class.getName());
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
    public RedditSignifier(List<Socialsignalurls> lstUrls, ApplicationContext appContext) {
        this.lstUrls = lstUrls;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.objProxyPageSource = appContext.getBean("objProxyPageSource", ProxyPageSource.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    /**
     * This method makes an api call to Reddit url, gets the response in json
     * format, parses the response to extract Reddit votes and returns extracted
     * result to the caller.
     * logic: uses reddit api to fetch ups for the specific url
     *        please see line no 96 which uses reddit api url.
     * @param url
     * @return Integer
     */
    public Integer getSocialSignifierSignal(String url) {

        String tempUrl=url;
        Integer ups = 0;

        if (!(url.contains("http://") || url.contains("https://"))) {
            url = "http://" + url;
        }
        url = "http://www.reddit.com/api/info.json?url=" + url;
        String source = "";
        try {
            source = objProxyPageSource.makeRequest(url, "");
            if (!source.contains("ups")) {
                if (url.endsWith("/")) {
                    try {
                        url = url.substring(0, url.length() - 1);
                    } catch (Exception e) {
                    }
                } else {
                    url = url + "/";
                }
                source = objProxyPageSource.makeRequest(url, "");
            }
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);
            e.printStackTrace();
        }
        if (source.contains("ups")) {

            //ups
            try {
                Pattern pattern = Pattern.compile("ups(.*?),");
                Matcher matcher = pattern.matcher(source);
                if (matcher.find()) {
                    String temp_ups = matcher.group(1).replace("\":", "").trim();
                    temp_ups = temp_ups.replace("}", "").replace("]", "").trim();
                    ups = Integer.parseInt(temp_ups);
                    //System.out.println(ups);
                }
            } catch (Exception e) {
                l.debug(e + "  " + e.getMessage() + " Exception come for url " + url);

            }
        }
       System.out.println("URL:::" + tempUrl + " Reddit Ups:::" + ups);
        return ups;
    }

    /**
     * This method passes the url from keywords list to
     *
     * @method getSocialSignifierSignal(
     * @params) and gets the result in setResults. This result is sent to
     * database layer by calling
     * @method saveRedditResult(
     * @params).
     */
    @Override
    public void run() {
        Map<String, Integer> setResults = new HashMap<>(0);
        try {
            for (Socialsignalurls domainName : lstUrls) {
                System.out.println("Fetching Reddit up Votes for url:::"+domainName.getSocialSignalUrl());
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
                objKeywordDao.saveRedditResult(ssUrlId, result);
                objKeywordDao.updateSocialRedditKeywords(ssUrlId, result);
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage());
            //System.out.println("Reddit exception" + ex);
        }
    }
}
