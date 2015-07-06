package ranktracker.crawler.seomoz;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.ProxyPageSource;

/**
 * Service class to call the various methods to URL Metrics
 *
 * URL Metrics is a paid API that returns the metrics about a URL or set of
 * URLs.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class URLMetricsService {

    static org.apache.log4j.Logger l = org.apache.log4j.Logger.getLogger(URLMetricsService.class.getName());
    private Authenticator authenticator;
    ApplicationContext appContext;
    FetchPagewithClientAthentication fetchSourcewithProx;
    ProxyDao objProxyDao;

    public URLMetricsService() {
    }

    /**
     *
     * @param authenticator
     * @param appContext
     */
    // public URLMetricsService(Authenticator authenticator) {
    public URLMetricsService(Authenticator authenticator, ApplicationContext appContext) {
        this.setAuthenticator(authenticator);
        this.appContext = appContext;
        fetchSourcewithProx = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);

    }

    ProxyPageSource objProxyPageSource = new ProxyPageSource();

    /**
     *
     * This method returns the metrics about a URL or set of URLs.
     *
     * @param objectURL
     * @param col This field filters the data to get only specific columns col =
     * 0 fetches all the data
     * @return
     */
    public String getUrlMetrics(String objectURL, BigInteger col) throws IOException {
        System.out.println("getUrlMetrics");
        String urlToFetch = "http://lsapi.seomoz.com/linkscape/url-metrics/" + URLEncoder.encode(objectURL) + "?" + authenticator.getAuthenticationStr();
        //   System.out.println("urlToFetch = " + urlToFetch);
        if (col.signum() == 1) {
            urlToFetch = urlToFetch + "&Cols=" + col;
        }
        // String response = objProxyPageSource.makeRequest(urlToFetch, "");
        String response = "";
        try {
            response = fetchSourcewithProx.fetchPageSourceWithoutPROXY(new URI(urlToFetch));

        } catch (URISyntaxException ex) {
            Logger.getLogger(URLMetricsService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(URLMetricsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");

        return response;
    }

    public String getUrlMetrics(String objectURL, long col) throws IOException {
        return getUrlMetrics(objectURL, BigInteger.valueOf(col));
    }

    /**
     *
     * Fetch all the Url Metrics for the objectURL
     *
     * @param objectURL
     * @return
     *
     * @see URLMetricsService#getUrlMetrics(String, int)
     */
    public String getUrlMetrics(String objectURL) {
        try {
            return getUrlMetrics(objectURL, URLMetricsConstants.URLMETRICS_COL_EXTERNAL_LINKS);
        } catch (IOException ex) {
            l.debug(ex + "  " + ex.getMessage());
            Logger.getLogger(URLMetricsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @param authenticator the authenticator to set
     */
    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    /**
     * @return the authenticator
     */
    public Authenticator getAuthenticator() {
        return authenticator;
    }

    /**
     * getLinkMetrics will build the url and will fetch that page
     *
     * @param objectURL
     * @param col
     * @return response string of the requested page
     * @throws IOException
     */
    //urlto fetch: http://lsapi.seomoz.com/linkscape/links/ipagereviewtraining.com?Scope=page_to_page&Sort=page_authority&Limit=1&SourceCols=103079215104%2834359738368+68719476736%29&TargetCols=103079215104%2834359738368+68719476736%29&AccessID=member-8d27ee524f&Expires=1389945770&Signature=yTporLjzVcdQ6a%2BKGJ1J3gv9Zvw%3D
    //response: [{"lrid":222611339279,"lsrc":55993394502,"ltgt":39939800377,"lupda":30.650807995815843,"luupa":32.70532059710223,"pda":89.01307048032706,"upa":44.339372918753135}]
    public String getLinkMetrics(String objectURL, BigInteger col) throws IOException {
        System.out.println("getLinkMetrics");

        String colValue = "103079215104(34359738368+68719476736)";
        //34359738368 for PA(upa)         68719476736 for DA(pda)
        String urlToFetch = "http://lsapi.seomoz.com/linkscape/links/" + URLEncoder.encode(objectURL) + "?Scope=page_to_page&Sort=page_authority&Limit=1&SourceCols=" + colValue + "&TargetCols=" + colValue + "&" + authenticator.getAuthenticationStr();
        //    String response = objProxyPageSource.makeRequest(urlToFetch, "");
        String response = "";
        try {
            try {
                response = fetchSourcewithProx.fetchPageSourceWithoutPROXY(new URI(urlToFetch));
            } catch (InterruptedException ex) {
                Logger.getLogger(URLMetricsService.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (URISyntaxException ex) {
            Logger.getLogger(URLMetricsService.class.getName()).log(Level.SEVERE, null, ex);
        }

//        if (response.contains("\"status\" : \"503\","));
//        {
//            String response = fetchSourcewithProx.fetchPageSourcewithProxywithoutFile(urlToFetch);
//        }
        if (response.isEmpty()) {
            System.out.println("Empty response");
        }
        System.out.println("");

        return response;
    }

    public String getLinkMetrics(String objectURL, long col) throws IOException {
        return getLinkMetrics(objectURL, BigInteger.valueOf(col));
    }

    /**
     *
     * Fetch all the Link Metrics for the objectURL
     *
     * @param objectURL
     * @return
     *
     * @see URLMetricsService#getUrlMetrics(String, int)
     */
    public String getLinkMetrics(String objectURL) {
        try {
            return getLinkMetrics(objectURL, URLMetricsConstants.URLMETRICS_COL_EXTERNAL_LINKS);
        } catch (IOException ex) {
            l.debug(ex + "  " + ex.getMessage());
            Logger.getLogger(URLMetricsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
