package ranktracker.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public String makeRequest(String urlToFetch) throws IOException {
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
            int i = httpclient.executeMethod(httpget);
            responseBody = httpget.getResponseBodyAsString();
        } catch (Exception e) {
            l.error(e + "  " + e.getMessage() + " url " + urlToFetch);
        }
        System.out.print("responseBodyMakeReq==");
                System.out.println(responseBody);   
                       
        return responseBody;
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
}
