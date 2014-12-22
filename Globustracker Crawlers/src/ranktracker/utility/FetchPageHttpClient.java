package ranktracker.utility;

import java.io.IOException;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.log4j.Logger;

public class FetchPageHttpClient extends Thread implements FetchPage {
   static FetchPageHttpClient fpc= new FetchPageHttpClient();

    static Logger l = Logger.getLogger(FetchPageHttpClient.class.getName());
    private String pageUrl;
    //  private static FetchPageHttpClient fetchPageInstance = null;
    private HttpState initialState;
    private Cookie cookies;
    private HttpClient httpClient;
    private HttpClientParams clientParams = null;
    private Credentials cred = null;
    private String  userAgent=null;

    public FetchPageHttpClient() {
        try {
            initialState = new HttpState();
            clientParams = new HttpClientParams();
            clientParams.setSoTimeout(10000);
            clientParams.setConnectionManagerTimeout(10000);
            httpClient = new HttpClient(clientParams);
//            httpClient.getHostConfiguration().setProxy("46.227.68.2", 3128);
//             cred = new UsernamePasswordCredentials("mmongoose", "I-PHNBV9JHW6US");
            /**proxyrack**/
            httpClient.getHostConfiguration().setProxy("198.7.62.203", 333);
            cred = new UsernamePasswordCredentials("brandzter", "brandzter1234!@#$");
            httpClient.getState().setProxyCredentials(AuthScope.ANY, cred);
            httpClient.getParams().setCookiePolicy(CookiePolicy.RFC_2109);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    public static FetchPageHttpClient getInstance() {
//        if (fetchPageInstance == null) {
//            fetchPageInstance = new FetchPageHttpClient();
//        }
//        return fetchPageInstance;
//    }
    /*
     * Fetch the page source using GetMethod
     */
    @Override
    public String fetchPageSourceString_Get(String urlToFetch, String region, int pageN0) throws IOException {
        int pageRequestCount = 1;
        region = "www." + region;
        String page = "";
        boolean b = true;
        int i = 0;
        try {
            System.out.println("fetch page source from: " + urlToFetch);
            GetMethod httpget = new GetMethod(urlToFetch);
            httpget.addRequestHeader("Host", region); 
            String userAgent = UserAgents.getRandomUserAgent();
            System.out.println("userAgent= " + userAgent); 
            this.userAgent=userAgent;
//            HttpRequest req=new HttpRequest();
//            System.out.println(req.getHeader());
            httpget.addRequestHeader("User-Agent", userAgent);
            httpget.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            boolean isblocked = false;
            while (b) {
                try {
                    if (isblocked) {
                        pageRequestCount = pageRequestCount + 1;
                        System.out.println("Attempt PageRequestCount= " + pageRequestCount);
                        System.out.println("Page source "+urlToFetch);
                        page = null;
//                        Thread.sleep(240000);
                        String temppage = getSource(urlToFetch, region, pageN0);
                        String[] tempSource = temppage.split("@@@@@@@@");
                        page = tempSource[0];
                        System.out.println("got HTTP status= " + tempSource[1]);
                        if (tempSource[1].equals("200")) {
                            i = 200;
                            isblocked = false;
                            b = false;
                            break;
                        }
                    } else {
                        i = httpClient.executeMethod(httpget);
                        System.out.println("request returned http " + i + " for pageNo= " + pageN0);
                          System.err.println("userAgent= "+userAgent);
                        page = httpget.getResponseBodyAsString();
                    }
//                    if (i / 100 == 4 || i / 5 == 5) {
////                        isblocked = true;
//                        page = "<PROXY ERROR>";
//                    } else {
//                        isblocked = false;
//                        b = false;
//                        break;
//                    }

                } catch (Exception e) {
                    isblocked = true;
                    page = "<PROXY ERROR>";
                    System.err.println("<PROXY ERROR>");
                    System.err.println("userAgent= "+userAgent);
                    e.printStackTrace();
                    b = true;
                }
                if (page == null || page.equals("")
                        || page.contains("407 Proxy Authentication Required")
                        || page.contains("<span class=\"uiButtonText\">Rejestracja</span></a><span class=\"signup_box_content\">")
                        || page.contains("<title>ERROR: The requested URL could not be retrieved</title>")
                        || page.contains("404 Not Found")
                        || page.contains("The page cannot be found")
                        || page.contains("<p>HTTP Error 404. The requested resource is not found.</p>")
                        || page.contains("Error 404: Not Found")
                        || page.contains("HTTP Status 404 -")
                        || page.contains("403 Access Denied")
                        || page.contains("<h1>ERROR</h1>")
                        || page.contains("400 Bad request")
                        || page.contains("403 Forbidden")
                        || page.contains("<title>Site not allowed - PacketIP</title>")
                        || page.contains("502 Bad Gateway")
                        || page.contains("but your computer or network may be sending automated queries")
                        || (page.contains("To continue, please type the characters below:<br>") && page.contains("id=\"captcha\""))
                        || page.contains("m.baidu.com")
                        || page.contains("<PROXY ERROR>")
                        || page.contains("Pardon the interruption")
                        || page.equals(" ")) {
                    b = true;
                    isblocked = true;
                } else {
                    b = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("userAgent= "+userAgent);
            
        }
        return page;
    }

    public String getSource(String urlToFetch, String region, int pageN0) {
        String page = "";
        int i = 0;
        try {
            GetMethod httpget = new GetMethod(urlToFetch);
            httpget.addRequestHeader("Host", region);
            String userAgent1 = UserAgents.getRandomUserAgent();
            this.userAgent=  userAgent1;
            System.out.println(userAgent1);
            httpget.addRequestHeader("User-Agent", userAgent1);
            httpget.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            i = httpClient.executeMethod(httpget);
             System.out.println("request returned http "+i+"for pageNo= "+ pageN0);
            page = httpget.getResponseBodyAsString();
        } catch (Exception e) {
            e.printStackTrace();
              System.err.println("userAgent= "+userAgent);
        }
        return page + "@@@@@@@@" + i;
    }

    public Cookie[] getCookies() {
        return httpClient.getState().getCookies();
    }
    public static FetchPageHttpClient getInstance(){
        return fpc;
    }
}
