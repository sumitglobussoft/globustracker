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

public class FetchPageHttpClientDailymotion extends Thread  {

    static Logger l = Logger.getLogger(FetchPageHttpClientDailymotion.class.getName());
    private String pageUrl;
    private static FetchPageHttpClientDailymotion fetchPageInstance = null;
    private HttpState initialState;
    private Cookie cookies;
    private HttpClient httpClient;
    private HttpClientParams clientParams = null;

    private FetchPageHttpClientDailymotion() {
        try {
            initialState = new HttpState();
            clientParams = new HttpClientParams();
            clientParams.setSoTimeout(60000);
            clientParams.setConnectionManagerTimeout(60000);
            httpClient = new HttpClient(clientParams);
            httpClient.getHostConfiguration().setProxy("46.227.68.2", 3128);
            Credentials cred = new UsernamePasswordCredentials("mmongoose", "I-PHNBV9JHW6US");
            httpClient.getState().setProxyCredentials(AuthScope.ANY, cred);
            httpClient.getParams().setCookiePolicy(CookiePolicy.RFC_2109);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static FetchPageHttpClientDailymotion getInstance() {
        if (fetchPageInstance == null) {
            fetchPageInstance = new FetchPageHttpClientDailymotion();
        }
        return fetchPageInstance;
    }


    /*
     * Fetch the page source using GetMethod
     */
   
    public String fetchPageSourceString_Get(String urlToFetch, String referer) throws IOException {
        
        String page = "";
        boolean b = true;
        int i = 0;
        try {
            GetMethod httpget = new GetMethod(urlToFetch);
            httpget.addRequestHeader("Host", "www.dailymotion.com");
            httpget.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:21.0) Gecko/20100101 Firefox/21.0");
            httpget.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addRequestHeader("Referer", referer);
            boolean isblocked = false;
            while (b) {
                try {
                    if (isblocked) {
                        page = null;
                        Thread.sleep(240000);
                        String temppage = getSource(urlToFetch, "www.dailymotion.com");
                        String[] tempSource = temppage.split("@@@@@@@@");
                        page = tempSource[0];
                        if (tempSource[1].equals("200")) {
                            i = 200;
                            isblocked = false;
                            b = false;
                            break;
                        }
                    } else {
                        i = httpClient.executeMethod(httpget);
                        System.out.println("HTTP STATUS CODE:::" + i);
                        page = httpget.getResponseBodyAsString();
                    }
                    if (i / 100 == 4 || i / 5 == 5) {
                        isblocked = true;
                        page = "<PROXY ERROR>";
                    } else {
                        isblocked = false;
                        b = false;
                        break;
                    }

                } catch (Exception e) {
                    isblocked = true;
                    page = "<PROXY ERROR>";
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
                    isblocked = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    public String getSource(String urlToFetch, String region) {
        String page = "";
        int i = 0;
        try {
            GetMethod httpget = new GetMethod(urlToFetch);
            httpget.addRequestHeader("Host", region);
            httpget.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:21.0) Gecko/20100101 Firefox/21.0");
            httpget.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            i = httpClient.executeMethod(httpget);
            System.out.println("HTTP STATUS CODE:::" + i);
            page = httpget.getResponseBodyAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page + "@@@@@@@@" + i;
    }

    public Cookie[] getCookies() {
        return httpClient.getState().getCookies();
    }
}
