package ranktracker.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Scanner;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;

/**
 * Utility Class to get page source for weburl's
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
@Service("objProxyPageSource")
public class ProxyPageSource {

    //private static int errorCounter = 0;
    static Logger l = Logger.getLogger(ProxyPageSource.class.getName());

    /**
     *
     * Method to make a GET HTTP connecton to the given url and return the
     * output
     *
     * @param urlToFetch url to be connected
     * @return the http get response
     */
    public String makeRequest(String urlToFetch, String region) throws IOException {
        String responseBody = "";
        try {
            HttpClientParams clientParams = new HttpClientParams();
            clientParams.setSoTimeout(40000);
            clientParams.setConnectionManagerTimeout(40000);
            HttpClient httpclient = new HttpClient(clientParams);
            GetMethod httpget = new GetMethod(urlToFetch);
            if (urlToFetch.contains("linkedin.com/countserv")) {
                httpget.addRequestHeader("Host", "www.linkedin.com");
                httpget.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:20.0) Gecko/20100101 Firefox/20.0");
                httpget.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                httpget.addRequestHeader("Cookie", "X-LI-IDC=C1; bcookie=\"v=2&618ed56d-275f-4dcd-86cd-6a44c8421879\"; bscookie=\"v=1&201305170926410ddaf2a1-e238-4bf6-8a0a-ce8a3df25934AQFZX82SfErJuFQKMJV49JfQTvewhfzh\"; X-LI-IDC=C1");
            }
//            httpclient.getHostConfiguration().setProxy("46.227.68.2", 3128);
//            Credentials cred = new UsernamePasswordCredentials("mmongoose", "I-PHNBV9JHW6US");
//            httpclient.getState().setProxyCredentials(AuthScope.ANY, cred);
            int i = httpclient.executeMethod(httpget);
            responseBody = httpget.getResponseBodyAsString();
        } catch (Exception e) {
            l.error(e + "  " + e.getMessage() + " url " + urlToFetch);
        }
        System.out.print("responseBodyMakeReq==");
                System.out.println(responseBody);   
                       
        return responseBody;
    }

    public static String geSourceWithoutProxy(String url, boolean followRedirects, boolean doAuthentication) {
        String pageSource = "";
        try {
            URL urlConn = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlConn.openConnection();
            if (!url.contains("checkerproxy.net")) {
                connection.setRequestProperty("Host", "www.ip-adress.com");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:19.0) Gecko/20100101 Firefox/19.0");
                connection.setRequestProperty("Accept-Language", "en-us,en;q=0.5");
                connection.setRequestProperty("Cookie", "__utma=11986028.1460854313.1364650279.1364810491.1364815784.4; __utmz=11986028.1364650279.1.1.utmccn=(organic)|utmcsr=google|utmctr=|utmcmd=organic; __atuvc=2%7C13%2C9%7C14; __utmc=11986028; __utmb=11986028");
            }
            if (url.contains("proxy.ipcn.org")) {
                connection.setRequestProperty("Host", "proxy.ipcn.org");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:20.0) Gecko/20100101 Firefox/20.0");
                connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                //httpget.addRequestHeader("Cookie", "__utma=242723930.307360402.1366432731.1366432731.1366432731.1; __utmb=242723930; __utmc=242723930; __utmz=242723930.1366432731.1.1.utmccn=(direct)|utmcsr=(direct)|utmcmd=(none)");
            }
            connection.connect();
            Scanner in = new Scanner(connection.getInputStream(), "UTF-8");
            if (url.contains("www.rmccurdy.com")) {
                while (in.hasNextLine()) {
                    pageSource = pageSource + "@" + in.nextLine();
                }
            } else {
                while (in.hasNextLine()) {
                    pageSource += in.nextLine();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return pageSource;
    }

    /**
     * The method delegates call to
     *
     * @method getPageSourceWithProxy(
     * @params), reads and parses the pagesource to verify the correctness of
     * pagesource. If a restricted phrase is found in pagesource, it recursively
     * make calls to
     * @method getPageSourceWithProxy(
     * @params) unless correct pagesource is obtained.
     *
     * @param iCount Counter variable for passing thread group information
     * @param url Url to fetch the pagesource for
     * @param objProxyDao the database layer ProxyDao object variable
     * @param region the local region of a given url
     * @return String
     */
    public String getSource( String url,  String region, String google) {

        String page = "";
        String exception = "";
        url = ReplaceAllHtmlTags.replaceUrlsFrenchCanCode(url);
        String pageSource = getPageSourceWithProxy( url, true, true, region,  false, google);
        int c = 0;
        while (true) {
            c++;
//            if (c == 10) {
//                try {
//                    c = 0;
//                    pageSource = ProxyPageSource.makeRequest(url, region);
//
//                } catch (Exception e) {
//                    l.error(e + "pagesource not come by makeRequest()");
//                }
//            }
            String[] proxyLog = pageSource.split("@@@@");
            try {
                page = proxyLog[2];
                exception = proxyLog[1];
                if (!exception.equals(" ")) {
                    page = "";
                }
            } catch (Exception e) {
                page = "";
                exception = "";
            }
            if (page == null || page.equals("")) {
//                objProxyDao.changeProxy(google);
                pageSource = getPageSourceWithProxy( url, true, true, region,  false, google);
            } else if (page.contains("407 Proxy Authentication Required")
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
                //l.error("Using Errsy" + "url:" + url + "page:");
//                objProxyDao.changeProxy(google);
                pageSource = getPageSourceWithProxy( url, true, true, region,  false, google);
            } else {
                try {
                    //objProxyDao.updateUseCount(ProxyDao.lstProxyData.get(iCount));
                    //objProxyDao.updateUseCount(ProxyDao.objProxyData);
                } catch (Exception e) {
                    l.error(e + "  " + e.getMessage() + "Here is the problem" + url);
                }
                break;
            }
        }
        return page;
    }

    /**
     * The method reads a proxy object from database, makes a GetMethod object,
     * appends required cookies to the HttpClient object. The HttpClient then
     * executes the Getmethod and returns the pagesource to the caller.
     *
     * @param iCount Counter variable for passing thread group information
     * @param url Url to fetch the pagesource for
     * @param followRedirect Boolean variable to specify GetMethod
     * followRedirect value
     * @param doAuthentication Boolean variable to specify GetMethod
     * doAuthentication value
     * @param region the local region of a given url
     * @param objProxyDao the database layer ProxyDao object variable
     * @param useErrsy Boolean variable to specify usage of Errsy as proxy
     * source
     * @return String
     */
    public String getPageSourceWithProxy( String url, boolean followRedirect, boolean doAuthentication,
            String region, Boolean useErrsy, String google) {

        String page = " ";
        String pageSource = "";
        int i = 0;
        String exception = " ";
        HttpClientParams clientParams = new HttpClientParams();
        clientParams.setSoTimeout(40000);
        clientParams.setConnectionManagerTimeout(40000);
        HttpClient httpclient = new HttpClient(clientParams);
        GetMethod getmethod = null;

        HttpState state = new HttpState();

      //  if (ProxyDao.lstProxyData.size() == 16) {
        ProxyData objProxyData = null;
       // if (!useErrsy) {
        try {
            //objProxyData = ProxyDao.lstProxyData.get(iCount);
            objProxyData = ProxyDao.objProxyData;
            if (objProxyData == null) {
//                objProxyDao.changeProxy(google);
                objProxyData = ProxyDao.objProxyData;

            }
            httpclient.getHostConfiguration().setProxy(objProxyData.getIPAddress(), objProxyData.getPortNo());
        } catch (Exception e) {
            pageSource = i + "@@@@" + exception + "@@@@" + page + "@@@@" + url;
            return pageSource;
        }
        /*} else {
         try {
         objProxyData = new ProxyData(0, "46.227.68.2", 3128, "Mongoose", "I-C5GS0FTAL61L", 0, 0);
         Credentials defaultcreds = new UsernamePasswordCredentials(objProxyData.getProxyUser(), objProxyData.getProxyPassword());
         httpclient.getState().setCredentials(AuthScope.ANY, defaultcreds);
         httpclient.getHostConfiguration().setProxy(objProxyData.getIpaddress(), objProxyData.getPortNo());
         state.setProxyCredentials(null, null, new UsernamePasswordCredentials(objProxyData.getProxyUser(), objProxyData.getProxyPassword()));
         httpclient.setState(state);
         } catch (Exception e) {
         pageSource = i + "@@@@" + exception + "@@@@" + page + "@@@@" + url;
         return pageSource;
         }
         }*/
        try {
            getmethod = new GetMethod(url);
            getmethod.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:19.0) Gecko/20100101 Firefox/19.0");
            if (url.contains("bing.com")) {

                if (region.equalsIgnoreCase("co.uk")) {
                    getmethod.addRequestHeader("Cookie", "_FP=mkt=en-GB;SRCHHPGUSR=NEWWND=0&NRSLT=50&SRCHLANG=&AS=1;");
                } else if (region.equalsIgnoreCase("com.sg")) {
                    getmethod.addRequestHeader("Cookie", "_FP=mkt=en-SG;SRCHHPGUSR=NEWWND=0&NRSLT=50&SRCHLANG=&AS=1;");
                } else if (region.equalsIgnoreCase("com.au")) {
                    getmethod.addRequestHeader("Cookie", "_FP=mkt=en-AU;SRCHHPGUSR=NEWWND=0&NRSLT=50&SRCHLANG=&AS=1;");
                } else if (region.equalsIgnoreCase("co.in")) {
                    getmethod.addRequestHeader("Cookie", "_FP=mkt=en-IN;SRCHHPGUSR=NEWWND=0&NRSLT=50&SRCHLANG=&AS=1;");
                } else if (region.equalsIgnoreCase("ca")) {
                    getmethod.addRequestHeader("Cookie", "_FP=mkt=en-CA;SRCHHPGUSR=NEWWND=0&NRSLT=50&SRCHLANG=&AS=1;");
                } else if (region.equalsIgnoreCase("com.ph")) {
                    getmethod.addRequestHeader("Cookie", "_FP=mkt=en-PH;SRCHHPGUSR=NEWWND=0&NRSLT=50&SRCHLANG=&AS=1;");
                } else if (region.equalsIgnoreCase("com.my")) {
                    getmethod.addRequestHeader("Cookie", "_FP=mkt=en-WW;SRCHHPGUSR=NEWWND=0&NRSLT=50&SRCHLANG=&AS=1;");
                } else if (region.equalsIgnoreCase("it")) {
                    getmethod.addRequestHeader("Cookie", "_FP=mkt=en-IT;SRCHHPGUSR=NEWWND=0&NRSLT=50&SRCHLANG=&AS=1;");
                } else {
                    getmethod.addRequestHeader("Cookie", "_FP=mkt=en-US;SRCHHPGUSR=NEWWND=0&NRSLT=50&SRCHLANG=&AS=1;");
                }
            }
            getmethod.setFollowRedirects(true);
            getmethod.setDoAuthentication(true);
            httpclient.getParams().setAuthenticationPreemptive(true);
            httpclient.setState(state);
            String num100Header = "";
//            if (url.contains("google")) {
//                int j = 0;
//                String url1 = "http://www.google.com/";
//                try {
//                    GetMethod objGetMethod = new GetMethod(url1);
//                    j = httpclient.executeMethod(objGetMethod);
//                    Header responseHeader = objGetMethod.getResponseHeader("Set-Cookie");
//                    String header = responseHeader.getValue();
//                    String[] headerValue = header.split(";");
//
//                    for (String head : headerValue) {
//                        if (head.contains("PREF=ID")) {
//                            header = head;
//                            break;
//                        }
//                    }
//                    String[] splitAll = header.split(":");
//                    long time = System.currentTimeMillis()+400;
//                    String sTime = "" + time;
//                    sTime = sTime.substring(0, 10);
//                    //num100Header = splitAll[0].replace("PREF=", "") + ":" + splitAll[1]  + ":LD=en:NR=100:" + splitAll[2] + ":" + splitAll[3] + ":" + splitAll[4];
//                    num100Header = splitAll[0].replace("PREF=", "") + ":" + splitAll[1] + ":LD=en:NR=100:" + "TM=" + sTime + ":LM=" + sTime + ":SG=2:" + splitAll[4];
//                    Cookie ck = new Cookie("PREF", "PREF", num100Header);
//                    httpclient.getState().clearCookies();
//                    httpclient.getState().addCookie(ck);
//                    getmethod.addRequestHeader("Host", "www.google.com");
//                    getmethod.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:19.0) Gecko/20100101 Firefox/19.0");
//                    getmethod.addRequestHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//                    getmethod.addRequestHeader("Accept-Language", "en-US,en;q=0.5");
//                    getmethod.addRequestHeader("Accept-Encoding", "gzip, deflate");
//                    getmethod.addRequestHeader("Referer", "https://www.google.com/");
//                    System.out.println(num100Header);
//                } catch (Exception ex) {
//                    exception = ex.getMessage();
//                    l.debug(ex + "  " + ex.getMessage() + "Exception occured for url" + url);
//                    pageSource = j + "@@@@" + exception + "@@@@" + page + "@@@@" + url1;
//                    return pageSource;
//                }
//            }
            i = httpclient.executeMethod(getmethod);
            if (i / 100 == 4 || i / 100 == 5) {
                page = "<PROXY ERROR>";

            } else {

                page = getmethod.getResponseBodyAsString();
            }
        } catch (SocketTimeoutException ex) {
            exception = ex.getMessage();
            l.error(ex + "  " + ex.getMessage() + "Exception occured for url" + url);
        } catch (SocketException ex) {
            exception = ex.getMessage();
            l.error(ex + "  " + ex.getMessage() + "Exception occured for url" + url);
        } catch (Exception ex) {
            exception = ex.getMessage();
            l.error(ex + "  " + ex.getMessage() + "Exception occured for url" + url);

        } finally {
            getmethod.releaseConnection();
        }
        pageSource = i + "@@@@" + exception + "@@@@" + page + "@@@@" + url;

        //}
        return pageSource;
    }

    /**
     * The method makes a GetMethod object and an HttpClient object. The
     * HttpClient then executes the Getmethod and returns the pagesource to the
     * caller.
     *
     * @param url Url to fetch the pagesource for
     * @param followRedirect Boolean variable to specify GetMethod
     * followRedirect value
     * @param doAuthentication Boolean variable to specify GetMethod
     * doAuthentication value
     * @return String
     */
    public String getPageSourceWithoutProxy(String url, boolean followRedirects, boolean doAuthentication) {

        GetMethod getMethod = null;
        String pageSouce = null;
        HttpClient httpClient = new HttpClient();
        try {
            getMethod = new GetMethod(url);
            getMethod.setFollowRedirects(followRedirects);
            getMethod.setDoAuthentication(doAuthentication);
            httpClient.executeMethod(getMethod);
            pageSouce = getMethod.getResponseBodyAsString();
        } catch (Exception e) {
            l.error(e + "  " + e.getMessage() + "exception occured for url" + url);
            try {
                getMethod = new GetMethod(url);
                getMethod.setFollowRedirects(followRedirects);
                getMethod.setDoAuthentication(doAuthentication);
                httpClient.executeMethod(getMethod);
                pageSouce = getMethod.getResponseBodyAsString();
                getMethod.releaseConnection();
            } catch (Exception ex) {
                l.error(ex + "  " + ex.getMessage() + "exception occured for url " + url);
                getMethod.releaseConnection();
            }
        } finally {
            getMethod.releaseConnection();
        }
        return pageSouce;
    }

    /**
     * This method makes a Json post to google plus weburl to read the google
     * plus likes for a given url. The json post includes a registered google
     * account developer key and 13 request headers to simulate browser
     * behaviour. The json response is returned to caller class.
     *
     * @param url to fetch the data for
     * @param objProxyDao the database layer ProxyDao object variable
     * @return String
     */
    public String getPostSourceGoogle(String url, ProxyDao objProxyDao) {
        String source = "";
        org.apache.http.client.HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost request = new HttpPost("https://clients6.google.com/rpc?key=AIzaSyCKSbrvQasunBoV16zDH9R33D88CeLr9gQ");
            request.addHeader("Host", "clients6.google.com");
            request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:18.0) Gecko/20100101 Firefox/18.0");
            request.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            request.addHeader("Accept-Language", "en-US,en;q=0.5");
            request.addHeader("X-Goog-AuthUser", "0");
            request.addHeader("Authorization", "SAPISIDHASH 8b80e6cb4f438e869e8f6cc227fca5cf8856c6ab");
            request.addHeader("X-ClientDetails", "appVersion=5.0%20(Windows)&platform=Win32&userAgent=Mozilla%2F5.0%20(Windows%20NT%206.1%3B%20rv%3A18.0)%20Gecko%2F20100101%20Firefox%2F18.0");
            request.addHeader("Content-Type", "application/json; charset=UTF-8");
            request.addHeader("X-JavaScript-User-Agent", "google-api-javascript-client/1.0.0-alpha");
            request.addHeader("X-Origin", "https://plusone.google.com");
            request.addHeader("X-Referer", "https://plusone.google.com");
            request.addHeader("X-Goog-Encode-Response-If-Executable", "base64");
            request.addHeader("Cookie", "PREF=ID=a426d8fb1e2750ee:U=6af15e4f74c74ed0:FF=0:LD=en:TM=1361159234:LM=1361169098:S=IFSJimDkqaNmvAhe; NID=67=shTVymtcFTEolwk0opYlWFkokW8qk9CqIGlSKZNTb6yJd684LQ5aJoSk5bMrQdp29SaMHo5sDCH48dxea7HgWXoPvBIdKd3xT7f3Pm9QsY3tgvscweUNp6FVTCGMJoypsV5OniwmQun0eVPUeFtauZbS; SID=DQAAAMIAAADKWgTA8SrvfpQcPBYOvtZMfeRs8gskEeTPpe4tGoK58rkzZNsIW0d0EawqI-0PmrxWF4Je7CbcWOdh0IaJtspvsAl2IaTftD28of_srBD-19rOobp9BRDsFNgro5V6NSKozVNTOl8cmFJUdBlUZ5iU5miI9X8lixN9kvjbydirkOKsb_ptkLELKHv0ZruwADrDNQm4-80T0accTOvBTT5MI_JP3kT9bjrvP3EOlE1dd71Va2VhpjPze_J5akbj3iQQA6ENor-1r9dN2G48UVGe; HSID=AJ3vWp905JFQ4Fsm4; SSID=ALbvnRrBXqNVAquz1; APISID=hJVIUcaXfkppC-OW/A6YIudTulrIg4f-HT; SAPISID=3EZqx7bM9IesGpqO/ARcqGVQeQoWyxxxnL");
            StringEntity params = new StringEntity("[{\"method\":\"pos.plusones.get\",\"id\":\"p\",\"params\":{\"nolog\":true,\"id\":\"" + url + "\",\"source\":\"widget\",\"userId\":\"@viewer\",\"groupId\":\"@self\"},\"jsonrpc\":\"2.0\",\"key\":\"p\",\"apiVersion\":\"v1\"}]");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            org.apache.http.StatusLine statusLine = response.getStatusLine();
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                source = source + line;
            }
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage() + " Exception occured for url " + url);
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return source;
    }

    public static void main(String[] args) {
        try {
            // ProxyPageSource.makeRequest("http://www.rmccurdy.com/scripts/proxy/good.txt", "");
            ProxyPageSource.geSourceWithoutProxy("http://www.rmccurdy.com/scripts/proxy/good.txt", true, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
