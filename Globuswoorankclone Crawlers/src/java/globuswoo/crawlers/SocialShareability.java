/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.crawlers;

import globuswoo.entity.Commonseo;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author : Nitesh Shah Email id : niteshshah@globussoft.com
 */
public class SocialShareability {

    public String alexa_rank = "NA";
    public String facebook_share_count = "NA";
    public String facebook_like_count = "NA";
    public String facebook_comment_count = "NA";
    public String facebook_total_count = "NA";
    public String facebook_click_count = "NA";
    public String facebook_commentsbox_count = "NA";
    public String linkedin_count = "NA";
    public String pinterest_count = "NA";
    public String twitter_count = "NA";
    public String google_like = "NA";

    public void DisplaySocialShareability() {
        System.out.println("1. ALexa Rank                  : " + alexa_rank);
        System.out.println("2. Facebook Share Count        : " + facebook_share_count);
        System.out.println("3. Facebook Likes Count        : " + facebook_like_count);
        System.out.println("4. Facebook Comment Count      : " + facebook_comment_count);
        System.out.println("5. Facebook Total Count        : " + facebook_total_count);
        System.out.println("6. Facebook Click Count        : " + facebook_click_count);
        System.out.println("7. Facebook comments Box count : " + facebook_commentsbox_count);
        System.out.println("8. LinkedIn Count              : " + linkedin_count);
        System.out.println("9.Pinterest Count              : " + pinterest_count);
        System.out.println("10.Twitter Count               : " + twitter_count);
        System.out.println("11.Google Plus Like            : " + google_like);
    }

    public void getAlexaRanking(Commonseo data, String complete_url) {

        try {
            URL xmlURL = new URL("http://data.alexa.com/data?cli=10&dat=s&url=" + complete_url);
            InputStream stream = xmlURL.openStream();
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = docBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("POPULARITY");
            alexa_rank = "blank";
            if (nodeList != null && nodeList.getLength() > 0) {
                org.w3c.dom.Node currentNode = nodeList.item(0);
                Element currentElement = (Element) currentNode;
                alexa_rank = currentElement.getAttribute("TEXT");
            }
        } catch (Exception e) {

        }
        data.setALexaRank(alexa_rank);
    }

    public void getFacebookDetails(Document doc, Commonseo data, String complete_url) {

        try {

            //            String response = null;
//            response = new GetRequestHandler().doGetRequest(new URL(facebookurl));
            // System.out.println("facebook Details Response : " + response);
            String facebookurl = "http://api.facebook.com/restserver.php?format=json&method=links.getStats&urls="
                    + complete_url;

            JSONArray result = new JSONArray(new GetRequestHandler().doGetRequest(new URL(facebookurl)));
            JSONObject json = result.getJSONObject(0);

            try {
                Object facebook_click_count_no = json.get("click_count");
                facebook_click_count = json.get("click_count").toString();
                System.out.println("click_count : " + facebook_click_count);
            } catch (Exception e) {
            }

            try {
                Object facebook_comment_count_no = json.get("comment_count");
                facebook_comment_count = json.get("comment_count").toString();
                System.out.println("comment_count : " + facebook_comment_count);
            } catch (Exception e) {
            }

            try {
                Object commentsbox_count_no = json.get("commentsbox_count");
                facebook_commentsbox_count = json.get("commentsbox_count").toString();
                System.out.println("commentsbox_count : " + facebook_commentsbox_count);
            } catch (Exception e) {
            }

            try {
                Object facebook_like_count_no = json.get("like_count");
                facebook_like_count = json.get("like_count").toString();
                System.out.println("like_count : " + facebook_like_count);
            } catch (Exception e) {
            }

            try {
                Object facebook_share_count_no = json.get("share_count");
                facebook_share_count = json.get("share_count").toString();
                System.out.println("share_count : " + facebook_share_count);
            } catch (Exception e) {
            }

            try {
                Object facebook_total_count_no = json.get("total_count");
                facebook_total_count = json.get("total_count").toString();
                System.out.println("total_count : " + facebook_total_count);
            } catch (Exception e) {
            }

//            try {
//                Pattern pattern = Pattern.compile("share_count(.*?),");
//                Matcher matcher = pattern.matcher(response);
//                if (matcher.find()) {
//                    facebook_share_count = matcher.group(1).replace("\":", "").trim();
//                }
//            } catch (Exception e) {
//            }
//
//            try {
//                Pattern pattern = Pattern.compile("like_count(.*?),");
//                Matcher matcher = pattern.matcher(response);
//                if (matcher.find()) {
//                    facebook_like_count = matcher.group(1).replace("\":", "").trim();
//                }
//            } catch (Exception e) {
//            }
//
//            try {
//                Pattern pattern = Pattern.compile("comment_count(.*?),");
//                Matcher matcher = pattern.matcher(response);
//                if (matcher.find()) {
//                    facebook_comment_count = matcher.group(1).replace("\":", "").trim();
//                }
//            } catch (Exception e) {
//            }
//
//            try {
//                Pattern pattern = Pattern.compile("total_count(.*?),");
//                Matcher matcher = pattern.matcher(response);
//                if (matcher.find()) {
//                    facebook_total_count = matcher.group(1).replace("\":", "").trim();
//                }
//            } catch (Exception e) {
//            }
//
//            try {
//                Pattern pattern = Pattern.compile("click_count(.*?),");
//                Matcher matcher = pattern.matcher(response);
//                if (matcher.find()) {
//                    facebook_click_count = matcher.group(1).replace("\":", "").trim();
//                }
//            } catch (Exception e) {
//            }
//
//            try {
//                Pattern pattern = Pattern.compile("commentsbox_count(.*?)}");
//                Matcher matcher = pattern.matcher(response);
//                if (matcher.find()) {
//                    facebook_commentsbox_count = matcher.group(1).replace("\":", "");
//                }
//            } catch (Exception e) {
//                System.out.println(e);
//            }
        } catch (Exception e) {
        }

        data.setFacebookShareCount(facebook_share_count);
        data.setFacebookLikesCount(facebook_like_count);
        data.setFacebookComment(facebook_comment_count);
        data.setFacebookTotalCount(facebook_total_count);
        data.setFacebookClickCount(facebook_click_count);
        data.setFacebookCommentsBoxCount(facebook_commentsbox_count);

    }

    public void getLinkedInDetails(Document doc, Commonseo data, String complete_url) {

        try {
            String linkedinurl = "https://www.linkedin.com/countserv/count/share?url=" + complete_url + "&lang=en_US";
            String response = null;
            response = new GetRequestHandler().doGetRequest(new URL(linkedinurl));
            // System.out.println("LinkedIn Details Response : " + response);

            try {
                Pattern pattern = Pattern.compile("count(.*?),");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    linkedin_count = matcher.group(1).replace("\":", "").trim();
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        data.setLinkedInCount(linkedin_count);
    }

    /*
     * In this getPinterestDetails method we are using the PInterest API for
     * getting the PInterest Count. 
     */
    public void getPinterestDetails(Document doc, Commonseo data, String complete_url) {

        try {
            String pinteresturl = "http://api.pinterest.com/v1/urls/count.json?callback=receiveCount&url=" + complete_url;
            String response = null;
            response = new GetRequestHandler().doGetRequest(new URL(pinteresturl));
            // System.out.println("Pinterest Details Response : " + response);

            try {
                Pattern pattern = Pattern.compile("count(.*?)}");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    pinterest_count = matcher.group(1).replace("\":", "").trim();
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        data.setPinterestCount(pinterest_count);
    }

    /*
     * In this getTwitterDetails method we are using the twitter API for getting
     * the Twitter Count. 
     */
    public void getTwitterDetails(Document doc, Commonseo data, String complete_url) {

        try {
            String twitterurl = "http://urls.api.twitter.com/1/urls/count.json?url=" + complete_url;
            String response = null;
            response = new GetRequestHandler().doGetRequest(new URL(twitterurl));
            // System.out.println("Twitter Details Response : " + response);

            try {
                Pattern pattern = Pattern.compile("count(.*?),");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    twitter_count = matcher.group(1).replace("\":", "").trim();
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        data.setTwitterCounts(twitter_count);
    }

    /*
     * In this getGooglePlusDetails method we are passing the URL and we are
     * using the method for GooglePlusSource class, after that we are getting
     * the google plus like by using the predefined Pattern and Matcher class.
     */
    public void getGooglePlusDetails(Document doc, Commonseo data, String complete_url) {
//        public void getGooglePlusDetails(String complete_url){

        try {
            // System.out.println("=====>" + getPostSourceGoogle(url));
            Pattern pattern = Pattern.compile("globalCounts(.*?)}");
            Matcher matcher = pattern.matcher(getPostSourceGoogle(complete_url));
            if (matcher.find()) {
                google_like = matcher.group(1).replace("\":", "").replace("{", "").replace("\"", "").replace("count", "").trim();
            }
        } catch (Exception e) {
        }
        data.setGooglePlusLike(google_like);
    }

    public String getPostSourceGoogle(String complete_url) {

//        System.out.println("getPostSourceGoogle : " + complete_url);
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
            request.addHeader("X-ClientDetails",
                    "appVersion=5.0%20(Windows)&platform=Win32&userAgent=Mozilla%2F5.0%20(Windows%20NT%206.1%3B%20rv%3A18.0)%20Gecko%2F20100101%20Firefox%2F18.0");
            request.addHeader("Content-Type", "application/json; charset=UTF-8");
            request.addHeader("X-JavaScript-User-Agent", "google-api-javascript-client/1.0.0-alpha");
            request.addHeader("X-Origin", "https://plusone.google.com");
            request.addHeader("X-Referer", "https://plusone.google.com");
            request.addHeader("X-Goog-Encode-Response-If-Executable", "base64");
            request.addHeader(
                    "Cookie",
                    "PREF=ID=a426d8fb1e2750ee:U=6af15e4f74c74ed0:FF=0:LD=en:TM=1361159234:LM=1361169098:S=IFSJimDkqaNmvAhe; NID=67=shTVymtcFTEolwk0opYlWFkokW8qk9CqIGlSKZNTb6yJd684LQ5aJoSk5bMrQdp29SaMHo5sDCH48dxea7HgWXoPvBIdKd3xT7f3Pm9QsY3tgvscweUNp6FVTCGMJoypsV5OniwmQun0eVPUeFtauZbS; SID=DQAAAMIAAADKWgTA8SrvfpQcPBYOvtZMfeRs8gskEeTPpe4tGoK58rkzZNsIW0d0EawqI-0PmrxWF4Je7CbcWOdh0IaJtspvsAl2IaTftD28of_srBD-19rOobp9BRDsFNgro5V6NSKozVNTOl8cmFJUdBlUZ5iU5miI9X8lixN9kvjbydirkOKsb_ptkLELKHv0ZruwADrDNQm4-80T0accTOvBTT5MI_JP3kT9bjrvP3EOlE1dd71Va2VhpjPze_J5akbj3iQQA6ENor-1r9dN2G48UVGe; HSID=AJ3vWp905JFQ4Fsm4; SSID=ALbvnRrBXqNVAquz1; APISID=hJVIUcaXfkppC-OW/A6YIudTulrIg4f-HT; SAPISID=3EZqx7bM9IesGpqO/ARcqGVQeQoWyxxxnL");
            StringEntity params = new StringEntity(
                    "[{\"method\":\"pos.plusones.get\",\"id\":\"p\",\"params\":{\"nolog\":true,\"id\":\""
                    //                    + "http://www."
                    + complete_url
                    + "\",\"source\":\"widget\",\"userId\":\"@viewer\",\"groupId\":\"@self\"},\"jsonrpc\":\"2.0\",\"key\":\"p\",\"apiVersion\":\"v1\"}]");
            request.setEntity(params);

//            System.out.println("=========" + params);
            HttpResponse response = httpClient.execute(request);
//            System.out.println("---------" + response);
            org.apache.http.StatusLine statusLine = response.getStatusLine();
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                source = source + line;
//                System.out.println("----======-----" + source);
            }
        } catch (Exception ex) {

        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return source;
    }

}
