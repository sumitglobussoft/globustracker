package ranktracker.crawler.seomoz;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;

/**
 * The crawler class gets Backlinks count for a given url.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class BacklinksCounter implements Runnable {

    static Logger l = Logger.getLogger(BacklinksCounter.class.getName());
    /**
     * setDomains The unique collection of domains
     */
    private Set<String> setDomains;
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
    ApplicationContext appContext;

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
    public BacklinksCounter(Set<String> setDomains, List<Serpkeywords> lstKeywords,
            ApplicationContext appContext) {

        this.setDomains = setDomains;
        this.lstKeywords = lstKeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.appContext = appContext;
    }

    /**
     * This method delegates credential authenticated call to URLMetricsService
     * class to retieve back links count for a given url.
     *
     * @param domain
     * @return Integer
     */
    public Integer getBackLinksCount(String domain) {

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage());
            e.printStackTrace();
        }
        String accessID = "member-8d27ee524f";
        String secretKey = "ad366140095f3318e8e0ebad56b601b7";
        Authenticator authenticator = new Authenticator();
        authenticator.setAccessID(accessID);
        authenticator.setSecretKey(secretKey);

        URLMetricsService urlMetricsService = new URLMetricsService(authenticator, appContext);
        // URLMetricsService urlMetricsService = new URLMetricsService(authenticator);
        String response = urlMetricsService.getUrlMetrics(domain);
        Gson gson = new Gson();
        UrlResponse res = gson.fromJson(response, UrlResponse.class);
        String x = res.getUeid();
        //System.out.println("domain" + domain + "cOUNT" + res.getUeid());
        if (x == null || x.equalsIgnoreCase("") || x.equalsIgnoreCase("blank") || x.equalsIgnoreCase("null")) {
            return 0;
        } else {
            return Integer.valueOf(x);
        }
    }

    /**
     * This method passes the domains from setDomains set to
     *
     * @method getBackLinksCount(
     * @params) and gets the result in Map<String, Integer> setBackLinksCounter.
     * Then iterates over lstKeywords, gets countBackLinks value from
     * setBackLinksCounter and sends data to database layer by calling
     * @method saveBackLinksResult(
     * @params).
     */
    @Override
    public void run() {
        int flagcount = 0;
        Map<String, Integer> setBackLinksCounter = new HashMap<>(0);
        Map<String, Integer[]> setPaDaCounter = new HashMap<>(0);
        try {
            for (String domainName : setDomains) {
                setBackLinksCounter.put(domainName.trim(), getBackLinksCount(domainName.trim()));
                setPaDaCounter.put(domainName.trim(), getPaDaCounts(domainName.trim()));
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage());
        }

        Integer countBackLinks;
        Integer[] countPaDa;
        String domainName;
        Integer keywordId;
        try {
            for (Serpkeywords objKeywords : lstKeywords) {
                domainName = objKeywords.getUrl().trim();
                keywordId = objKeywords.getKeywordID();
                countBackLinks = setBackLinksCounter.get(domainName);
                countPaDa = setPaDaCounter.get(domainName);
                int pacount = countPaDa[0];
                int dacount = countPaDa[1];
                if (countPaDa[1] == -1) {
                    dacount = getDAvalue(domainName);
                }
                System.out.println("keywordis:::: " + keywordId);
                System.out.println("Domain:::::: " + domainName);
                System.out.println("da:::: " + dacount);
                System.out.println("pa:::: " + pacount);

                objKeywordDao.saveBackLinksResult(keywordId, domainName, objKeywords.getKeyword(), objKeywords.getCampaignID(), countBackLinks, startTrackId, endtrackId);
                objKeywordDao.savePaDaResult(keywordId, domainName, objKeywords.getKeyword(), objKeywords.getCampaignID(), pacount, dacount);
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage());
        }
    }

    public Integer[] getPaDaCounts(String domain) {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage());
            e.printStackTrace();
        }
        String accessID = "member-8d27ee524f";
        String secretKey = "ad366140095f3318e8e0ebad56b601b7";
        Authenticator authenticator = new Authenticator();
        authenticator.setAccessID(accessID);
        authenticator.setSecretKey(secretKey);

        //    URLMetricsService urlMetricsService = new URLMetricsService(authenticator);
        URLMetricsService urlMetricsService = new URLMetricsService(authenticator, appContext);
        String response = urlMetricsService.getLinkMetrics(domain);
        // String response = "[{\"lrid\":222611339279,\"lsrc\":55993394502,\"ltgt\":39939800377,\"lupda\":30.650807995815843,\"luupa\":32.70532059710223,\"pda\":89.01307048032706,\"upa\":44.339372918753135}]";
        System.out.println("response = " + response);
        String[] splitResponse = response.split(",");
        String pa = null;
        String da = null;
        for (String eachrank : splitResponse) {
            if (eachrank.contains("lupda")) {
                eachrank = (eachrank.replace("}", "")).replace("]", "");
                eachrank = eachrank.substring(eachrank.indexOf(":")).replace(":", "").trim();
                da = eachrank;
            }
            if (eachrank.contains("luupa")) {
                eachrank = (eachrank.replace("}", "")).replace("]", "");
                eachrank = eachrank.substring(eachrank.indexOf(":")).replace(":", "").trim();
                //   int rank = (int) (Math.round(Double.parseDouble(eachrank)));
                //   pa = rank;
                pa = eachrank;
            }
        }
        Integer rank[] = new Integer[2];
        if (pa == null || pa.equalsIgnoreCase("") || pa.equalsIgnoreCase("blank") || pa.equalsIgnoreCase("null")) {
            rank[0] = 1;
        } else {
            rank[0] = (int) (Math.round(Double.parseDouble(pa)));
        }
        if (da == null || da.equalsIgnoreCase("") || da.equalsIgnoreCase("blank") || da.equalsIgnoreCase("null")) {
            rank[1] = -1;
        } else {
            rank[1] = (int) (Math.round(Double.parseDouble(da)));
        }
        return rank;
    }

    private int getDAvalue(String domainName) {
        domainName = domainName.substring(0, domainName.indexOf("/"));
        String accessID = "member-8d27ee524f";
        String secretKey = "ad366140095f3318e8e0ebad56b601b7";
        Authenticator authenticator = new Authenticator();
        authenticator.setAccessID(accessID);
        authenticator.setSecretKey(secretKey);

        URLMetricsService urlMetricsService = new URLMetricsService(authenticator, appContext);
        //   URLMetricsService urlMetricsService = new URLMetricsService(authenticator);
        String response = urlMetricsService.getLinkMetrics(domainName);
        String[] splitResponse = response.split(",");
        String da = null;
        for (String eachrank : splitResponse) {
            if (eachrank.contains("lupda")) {
                eachrank = (eachrank.replace("}", "")).replace("]", "");
                eachrank = eachrank.substring(eachrank.indexOf(":")).replace(":", "").trim();
                da = eachrank;
            }
        }
        int newda = (int) (Math.round(Double.parseDouble(da)));
        return newda;
    }
}
