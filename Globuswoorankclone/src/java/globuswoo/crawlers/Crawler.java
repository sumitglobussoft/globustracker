package globuswoo.crawlers;

import com.dropbox.core.DbxException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import globuswoo.dao.WoorankDaoImpl;
import globuswoo.entity.Commonseo;
import globuswoo.entity.Headingcount;
import globuswoo.entity.Headingelements;
import globuswoo.entity.Image;
import globuswoo.entity.Pagelinks;
import globuswoo.entity.Relatedwebsite;
import globuswoo.entity.Technology;
import globuswoo.entity.Visitorarray;
import globuswoo.entity.Xmldata;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.NodeList;

public class Crawler {

    public static String fetchGooglePageRank(String url) throws IOException {
        {
            try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
                HttpGet httpget = new HttpGet(url);
                //System.out.println("Executing request " + httpget.getRequestLine());
                // Create a custom response handler
                ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                    @Override
                    public String handleResponse(
                            final HttpResponse response) throws ClientProtocolException, IOException {
                        int status = response.getStatusLine().getStatusCode();
                        if (status >= 200 && status < 300) {
                            HttpEntity entity = response.getEntity();
                            return entity != null ? EntityUtils.toString(entity) : null;
                        } else {
                            throw new ClientProtocolException("Unexpected response status: " + status);
                        }
                    }
                };
                String respBody = httpclient.execute(httpget, responseHandler);
                //System.out.println(httpclient.execute(httpget, responseHandler).getBytes());
                return respBody;
            }
        }

    }
   
    public static String fetchGooglePageRankWithProxy(String pageurl) throws IOException {
        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        int portNo = generateRandomPort();
        credsprovider.setCredentials(
                new AuthScope("Ip Address", portNo),
                new UsernamePasswordCredentials("Username", "Password"));
        HttpHost proxy = new HttpHost("Ip Address", portNo);
        // String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                // .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
//            String responsestatus=null;
        try {
            HttpGet httpget = new HttpGet(pageurl);
            //System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
//                   responsestatus=resp.getStatusLine().toString();
            HttpEntity entity = resp.getEntity();
            //System.out.println(resp.getStatusLine());
            if (entity != null) {
                //System.out.println("Response content length: " + entity.getContentLength());
                BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                }
            }
            EntityUtils.consume(entity);
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public static int generateRandomPort() {

        int portNo;
        Random random = new Random();
        int[] portList = new int[98];
        int portBegin = 1601;   //1601

        for (int k = 0; k < portList.length; k++) {
            portList[k] = portBegin;
            portBegin = portBegin + 1;
        }

        int num = random.nextInt(98);
        portNo = portList[num];
        return portNo;
    }

    //**********************SEO ELEMENT STRUCTURE***********************************
    public String complete_url = "";
    public String url_Domain = "";
    public String page_rank = "NA";
    public String title = "NA";
    public String title_length = "NA";
    public String description = "NA";
    public String descriptionLength = "NA";
    public HeadingStructure hs = new HeadingStructure();
    public ArrayList<String> keywords = new ArrayList<>();
    public ImageStructure is = new ImageStructure();
    public String www_resolve = "NA";
    public String ipcanonicalization = "NA";
    public String ipaddress = "NA";
    public String robots = "NA";
    public GooglePreviewStructure gps = new GooglePreviewStructure();
    public String flash_content = "NA";
    public String texttohtmlratio = "NA";
    public String frames = "NA";
    public String underscores_in_url;
    public DomainInformation di = new DomainInformation();
    public XMLSitemap xmls = new XMLSitemap();
    public InPageLinks ipl = new InPageLinks();
    public String google_publisher = "NA";
    public KeywordsConsistency ks = new KeywordsConsistency();
    public RelatedWebsites objRelatedWebsites = new RelatedWebsites();
    public HtmlValidator objHtmlvalidator = new HtmlValidator();
    public IndexedPages objIndexedPages = new IndexedPages();
    public BacklinksCounter objBacklinksCounter = new BacklinksCounter();
    public ScoreValue objScoreValue = new ScoreValue();

    public PageRank objPageRank = new PageRank();

//***********************************SOCIAL DETAILS*****************************
    public FacebookStructure objFacebookStructure = new FacebookStructure();
    public Google_plus objGoogleplus = new Google_plus();
    public TwitterDetalis objTwitterDetalis = new TwitterDetalis();
    public Pinterest objPinterest = new Pinterest();
    public Linkedin objLinkedin = new Linkedin();
    public SocialShareability objSocialShareability = new SocialShareability();
//****************************VISITOR INFORMATION*******************************
    public VisitorsInfo objVisitorsInfo = new VisitorsInfo();

//**************************TECHNOLOGIES****************************************
    //public IP_Address id = new IP_Address();
    public TechUsedAndAnlytics objTechUsedAndAnlytics = new TechUsedAndAnlytics();
    public W3cDoctypeEncoding objw3cDoctypeEncoding = new W3cDoctypeEncoding();
    public ServerIPLocation objServerIPLocation = new ServerIPLocation();

//*****************************MOBILE*******************************************
    public MobileRendering objmobilerenderingo = new MobileRendering();
    public WoorankDropbox objWoorankDropbox = new WoorankDropbox();

//***************************DAO Object***************************************//
    public WoorankDaoImpl objwoorankdao = new WoorankDaoImpl();

//****************************Entity class objects****************************//
    public Commonseo objcommonseo = new Commonseo();
    public Headingcount objheadingcount = new Headingcount();
    public Headingelements objheadingelements = new Headingelements();
    public Pagelinks objPagelinks = new Pagelinks();
    public Image objImage = new Image();
    public Relatedwebsite objRelatedwebsite = new Relatedwebsite();
    public Technology objTechnology = new Technology();
    public Visitorarray objVisitorarray = new Visitorarray();
    public Xmldata objXmldata = new Xmldata();

    public int id;

    public static void main(String[] args) throws Exception {

        Crawler rp = new Crawler();
        rp.getDetails("linkedin.com");

    }

    public void getDetails(String url) throws Exception {

        if (url.contains("http://") || url.contains("https://")) {
        } else if (url.contains("www.")) {
            complete_url = "http://" + url;
        } else if (!url.contains("www.")) {
            complete_url = "http://www." + url;
        } else {
            complete_url = url;
        }
        System.out.println("URL: " + complete_url);

        try {

            Commonseo objCommonseo = new Commonseo();
            objCommonseo = objwoorankdao.getCommonSeoDetails(complete_url);
            title = objCommonseo.getTitle();
            id = objCommonseo.getId();
            System.out.println("" + id);
            if (title.length() > 0) {
                try {
                    updateDetails(complete_url);
                } catch (Exception e) {
                }
            }
        } catch (Exception ex) {
            System.out.println("URL " + complete_url + " NOT EXIST SO START CRAWLING! ");
            objcommonseo.setUrl(complete_url);
            getDataUsingCrawling(complete_url);
            objwoorankdao.insertCommonseo(objcommonseo);
            objwoorankdao.insertHeading(objheadingcount);
            objwoorankdao.insertHeadingElement(objheadingelements);
            objwoorankdao.insertPageLinks(objPagelinks);
            objwoorankdao.insertImage(objImage);
            objwoorankdao.insertRelatedWebsite(objRelatedwebsite);
            objwoorankdao.insertTechnology(objTechnology);
            objwoorankdao.insertVisitor(objVisitorarray);
            objwoorankdao.insertXmlData(objXmldata);
        }
    }

    public void updateDetails(String complete_url) throws IOException {

        commonSeoUpdate(complete_url);
        headingCountUpdate(complete_url);
        imageUpdate(complete_url);
        pagelinksUpdate(complete_url);
        relatedWebsiteUpdate(complete_url);
        technologyUpdate(complete_url);
        visitorInfoUpdate(complete_url);
        xmlSiteMapUpdate(complete_url);
    }

    public void commonSeoUpdate(String complete_url) throws IOException {

        String result = "0";
        String pageRank = "NA";
        String titleLength = "NA";
        String title = "NA";
        String description = "NA";
        String descriptionLength = "NA";
        String flash = "NA";
        String frames = "NA";
        String htmlRatio = "NA";
        String facebookLikes = "NA";
        String facebook_about = "NA";
        String facebookImage = "NA";
        String talking_about_count = "";
        String googleImage = "NA";
        String googleViews = "NA";
        String googleFollower = "NA";
        String keyword = "NA";
        String global_rank = "NA";
        String country_rank = "NA";
        String w3cvalidity = "NA";
        String encoding = "NA";
        String doctype = "NA";
        String facebook_url = "NA";
        String facebook_name = "NA";
        String twittercount = "NA";
        String twitterdate = "NA";
        String twitterdescrip = "NA";
        String twitterfolowing = "NA";
        String twitterfavorites = "NA";
        String twitterfolowrs = "NA";
        String twitterimage = "NA";
        String twittername = "NA";
        String twitterList = "NA";
        int passedpercentage = 0;
        int toimprovepercentage = 0;
        int errorpercentage = 0;
        String indexedPages = "NA";
        String IndexUrl = "";
        String indexedPages1 = "";
        String backlinksCounter = "NA";
        String backlinkUrl = "";
        String backlink = "";
        String mobileLoadTime = "NA";
        String trafficEstimation = "NA";
        String PinterestBoards = "NA";
        String PinterestPins = "NA";
        String PinterestLikes = "NA";
        String PinterestFollower = "NA";
        String PinterestFollowing = "NA";
        String PinterestImage = "NA";
        String PinterestName = "NA";
        String PinterestDescription = "NA";
        String twitterUrl = "";
        String linkedFollower = "NA";
        String linkedImage = "NA";
        String linkedDescription = "NA";
        String linkedSpecialties = "NA";
        String linkedWebsite = "NA";
        String linkedIndustry = "NA";
        String linkedType = "NA";
        String linkedHeadquater = "NA";
        String linkedCompany = "NA";
        String linkedFounded = "NA";
        String linkedEmployee = "NA";
        String aLexaRank = "NA";
        String facebookShareCount = "NA";
        String facebookLikesCount = "NA";
        String facebookComment = "NA";
        String facebookTotalCount = "NA";
        String facebookClickCount = "NA";
        String facebookCommentsBoxCount = "NA";
        String linkedInCount = "NA";
        String pinterestCount = "NA";
        String twitterCounts = "NA";

        Document doc;
        try {
            doc = Jsoup.parse(fetchGooglePageRank(complete_url));
        } catch (Exception e) {
            System.out.println("COULD NOT FETCH WEB PAGE: \n" + e);
            return;
        }

        //Code for Page Rank
        String pagerankresult = "";

        long hash = new JenkinsHash().hash(("info:" + complete_url).getBytes());

        // Append a 6 in front of the hashing value.
        String pagerankurl = "http://toolbarqueries.google.com/tbr?client=navclient-auto&hl=en&" + "ch=6" + hash
                + "&ie=UTF-8&oe=UTF-8&features=Rank&q=info:" + complete_url;

        // System.out.println("Sending request to : " + pagerankurl);
        try {
            URLConnection conn = new URL(pagerankurl).openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String input;
            while ((input = br.readLine()) != null) {

                pagerankresult = input.substring(input.lastIndexOf(":") + 1);
//                System.out.println("result : " + pagerankresult);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("__________________PAGE RANK________________");
        System.out.println("1. Page_rank : " + pagerankresult);
        pageRank = pagerankresult;

        //   Code for Tilte and title_length   
        try {
            title = "" + doc.title() + "";
            titleLength = title.length() + "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("__________________TITLE________________");
        System.out.println("2. TITLE : " + title);

        try {

            System.out.println("__________________TITLE LENGTH________________");
            System.out.println("3. TITLE LENGTH : " + title.length());

        } catch (Exception e) {
            e.printStackTrace();
        }

        //     Code for Description
        try {
            description = doc.select("meta[name=description]").attr("content");
            descriptionLength = description.length() + "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("__________________DESCRIPTION________________");
        System.out.println("4. DESCRIPTION : " + description);
        System.out.println("5. DESCRIPTION LENGTH : " + description.length());

        //Code for flash content
        String temp2 = null;
        temp2 = doc + "";
        if (temp2.contains(".swf")) {
            flash = "Yes";
        } else {
            flash = "No";
        }
        System.out.println("__________________FLASH CONTENT________________");
        System.out.println("6. Flash Content : " + flash);

        //Code for frames
        temp2 = doc + "";

        if (temp2.contains("<frame") || temp2.contains("<iframe")) {
            frames = "Yes The Webpage Contains frames";
        } else {
            frames = "No";
        }
        System.out.println("__________________FRAMES________________");
        System.out.println("7. Frames: " + frames);

        //Code for text html ratio
        float ratioB = 0;
        try {
            String html, txt;
            html = doc + "";

            txt = doc.text();
            ratioB = (float) (((float) (txt.getBytes().length) / (float) (html.getBytes().length)) * (float) 100);
            htmlRatio = "" + ratioB;
        } catch (Exception e) {
            System.out.println("Exception in TextHtmlRatio ");
        }
        System.out.println("__________________TEXT HTML RATIO________________");
        System.out.println("8. Text to html Ratio: " + texttohtmlratio);

        // Code for facebookLikes
        try {
            String temp[] = complete_url.replace(".", "#").split("#");
            facebook_url = "https://www.facebook.com/" + temp[1];
            facebook_name = temp[1];
        } catch (Exception e) {
        }
        if (facebook_url.equals("NA")) {
            return;
        }

        try {
            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy("http://graph.facebook.com/" + facebook_name));

            JSONObject obj = new JSONObject(doc1.text());

            try {
                facebookImage = obj.getJSONObject("cover").getString("source");
                System.out.println("9. Facebookimage : " + facebookImage);
            } catch (Exception e) {
            }

            try {
                facebook_about = obj.getString("about");
                System.out.println("10. About : " + facebook_about);
            } catch (Exception e) {
            }

            String temp[] = doc1.text().split(",");
            try {
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].contains("likes")) {
                        String tempo[] = temp[i].split(":");
                        facebookLikes = tempo[1];
                        System.out.println("11. Facebooklikes " + facebookLikes);
                    }

                }
            } catch (Exception e) {
            }

            temp = doc1.text().split("\"");
            try {
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].contains("talking_about_count")) {
                        talking_about_count = talking_about_count + temp[i + 1];
                        talking_about_count = talking_about_count.replace("\\", "");
                        System.out.println("12. Takingabout " + talking_about_count);
                        break;
                    }

                }
            } catch (Exception e) {
            }
        } catch (Exception a) {
            System.out.println("" + a);
        }
        //****************************Twitter Details********************************

        try {
            String temp[] = complete_url.replace(".", "#").split("#");
            twitterUrl = "https://www.twitter.com/" + temp[1];
            twittername = temp[1];
        } catch (Exception e) {
        }
        if (twitterUrl.equals("NA")) {
            return;
        }

        try {
            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy("https://www.twitter.com/" + twittername));

            try {
                Element twtimg = doc1.select("div[class=ProfileCanopy-inner] img").first();
                System.out.println("13. Twitter Image : " + twtimg.attr("src"));
                twitterimage = twtimg.attr("src");
            } catch (Exception e) {
            }

            try {
                Element twtcount = doc1.select("div[class=ProfileCanopy-nav] span[class=ProfileNav-value]").first();
                System.out.println("14. Twitter Count : " + twtcount.text());
                twittercount = twtcount.text();
            } catch (Exception e) {
            }

            try {
                Element twtfollow = doc1.select("li[class=ProfileNav-item ProfileNav-item--following] span[class=ProfileNav-value]").first();
                System.out.println("15. Twitter Following : " + twtfollow.text());
                twitterfolowing = twtfollow.text();
            } catch (Exception e) {
            }

            try {
                Element twtfoller = doc1.select("li[class=ProfileNav-item ProfileNav-item--followers] span[class=ProfileNav-value]").first();
                System.out.println("16. Twitter Followers : " + twtfoller.text());
                twitterfolowrs = twtfoller.text();
            } catch (Exception e) {
            }

            try {
                Element twtdescp = doc1.select("p[class=ProfileHeaderCard-bio u-dir]").first();
                System.out.println("17. Twitter Description : " + twtdescp.text());
                twitterdescrip = twtdescp.text();
            } catch (Exception e) {
            }

            try {
                Elements twtweburl = doc1.select("li[class=ProfileNav-item ProfileNav-item--lists] span[class=ProfileNav-value]");
                System.out.println("18. Twitter Lists : " + twtweburl.text());
                twitterList = twtweburl.text();
            } catch (Exception e) {
            }

            try {
                Elements twtfavorit = doc1.select("li[class=ProfileNav-item ProfileNav-item--favorites] span[class=ProfileNav-value]");
                System.out.println("19. Twitter Favorities : " + twtfavorit.text());
                twitterfavorites = twtfavorit.text();
            } catch (Exception e) {
            }

            try {
                Elements twtdate = doc1.select("div[class=ProfileHeaderCard-joinDate] span[class=ProfileHeaderCard-joinDateText js-tooltip u-dir]");
                System.out.println("20. Twitter Joineddate : " + twtdate.text());
                twitterdate = twtdate.text();
            } catch (Exception e) {
            }

        } catch (Exception e) {
        }
//****************************CODE FOR HTML VALIDATOR***************************

//   Code for visitors information
        try {

            String myurl = "http://www.alexa.com/siteinfo/" + complete_url;
            Document doc2 = Jsoup.parse(Crawler.fetchGooglePageRank(myurl));

//*****************CODE FOR GLOBAL RANK*****************************************
            try {
                global_rank = doc2.select("span[class=globleRank] strong[class=metrics-data align-vmiddle]").first().text();
                System.out.println("21. GLOBAL RANK : " + global_rank);
            } catch (Exception e) {
            }

//************************CODE FOR COUNTRY RANK*********************************
            try {
                country_rank = doc2.select("span[class=countryRank] strong[class=metrics-data align-vmiddle]").first().text();
                System.out.println("22. COUNTRY RANK : " + country_rank);
            } catch (Exception e) {
            }

        } catch (Exception ex) {
        }

        // Code for Keywords
        try {
            String temp[] = doc.select("meta[name=keywords]").attr("content").split(",");
            for (int i = 0; i < temp.length; i++) {
                keywords.add("" + temp[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("__________________KEYWORDS CLOUD________________");
            System.out.println("23. Keywords: " + keywords);
            String key = "";
            keyword = "" + keywords;
            for (int i = 0; i < keywords.size(); i++) {

                key = key + keywords.get(i) + ":";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Code for w3validity, encoding and doctype
        ArrayList<String> wDE = new ArrayList<>();
        String urlTemp;
        urlTemp = "http://validator.w3.org/check?uri=" + complete_url;
        try {
            Document doc3 = Jsoup.parse(Crawler.fetchGooglePageRank(urlTemp));
            Elements el1 = doc3.select("form tbody tr");
            urlTemp = el1.first().text();
            wDE.add(urlTemp.replace("Result: Passed,", "Valid:").replace("Result:", "Invalid:"));
            System.out.println("24. W3CValidity : " + urlTemp);
            w3cvalidity = "" + urlTemp;

//************************** W3CValid ends *************************************           
            Element el2 = el1.get(2).select("td").first();
            wDE.add(el2.text());
            System.out.println("25. Encoding  : " + el2.text());
            encoding = "" + el2.text();

// ************************* Doctype ends  *************************************          
            el2 = el1.get(3).select("td").first();
            wDE.add(el2.text());
            System.out.println("26. Doctype  : " + el2.text());
            doctype = "" + el2.text();

// ************************* Encoding ends *************************************               
        } catch (IOException e) {
            System.out.println("Exception in W3cValidity " + e);
        }

        // code for google plus image
        String purl = complete_url.replace("//", "");
        purl = purl.replace(":", "");
        purl = purl.replace(".", "#");
        String temp[] = purl.split("#");

        try {
            String Name = "" + temp[1];
            String url = "https://plus.google.com/+" + Name + "/about";
            String URL = "" + url;
            Document doc4 = Jsoup.parse(Crawler.fetchGooglePageRank(URL));

//**********************Code For Image*****************************************
            try {
                Elements e1 = doc4.select("div[class=xLa Wza] img");//.first();
                Element e2 = e1.select("img").first();
                String Image = "" + e2.attr("src");
                googleImage = "" + Image;
                System.out.println("27. Image " + googleImage);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Element e7 = doc4.select("div[class=O9a s5a] div[class=Zmjtc] span[class=BOfSxb]").first();
                googleFollower = "" + e7.text();
                System.out.println("28. Google Follower : " + googleFollower);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Element e8 = doc4.select("div[class=O9a s5a] div[class=Zmjtc] span[class=BOfSxb]").get(1);
                googleViews = "" + e8.text();
                System.out.println("29. Google Views : " + googleViews);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//***********************code for INDEXED PAGES*********************************
        try {
            String temp1[] = complete_url.replace(".", "#").split("#");
            indexedPages1 = temp1[1];
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (IndexUrl.equals("NA")) {
            return;
        }
        try {
            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy("https://www.google.co.in/search?biw=1525&bih=372&noj=1&q=" + indexedPages1 + ".com&oq=" + indexedPages1 + "&gs_l=serp.3..35i39j0l4j0i7i30j0l4.1069239.1072941.0.1073315.8.7.1.0.0.0.310.979.0j4j0j1.5.0.msedr...0...1c.1.60.serp..2.6.981.OdzKp9tAcU4"));
            Element eleindxpages = doc1.select("div[id=resultStats]").first();
            System.out.println("30. Indexed Pages : " + eleindxpages.text().replace("About", "").replace("results", ""));
            indexedPages = eleindxpages.text().replace("About", "").replace("results", "");

        } catch (Exception e) {
            e.printStackTrace();
        }

//***********************code for backlinks counter*****************************
        try {
            String temp3[] = complete_url.replace(".", "#").split("#");
            backlinkUrl = "http://www.woorank.com/en/review/" + temp3[1];
            backlink = temp3[1];
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (backlinkUrl.equals("NA")) {
            return;
        }
        try {

            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy("http://www.woorank.com/en/review/" + backlink + ".com"));
//            Element elebacklinks = doc1.select("div[id=criterium-backlinks_counter] div[class=criterium-content] span[class=bar] span[class=value]").first();
//            backlinksCounter = elebacklinks.text();
//            System.out.println("2. BACKLINKS COUNTER : " + backlinksCounter);

            //******************Code for Mobile Load Time***********************
            try {
                Element eleMobiletime = doc1.select("div[id=criterium-mobile_load_time] div[class=criterium-content] span[class=bar] span[class=value]").first();
                mobileLoadTime = eleMobiletime.text();
                System.out.println("31. MOBILE LOAD TIME : " + mobileLoadTime);
            } catch (Exception e) {
            }
            //******************Code for Traffic Estimation*********************
            try {
                Element eletraffic = doc1.select("div[id=criterium-alexa] div[class=criterium-content] span[class=bar] span[class=value]").first();
                trafficEstimation = eletraffic.text();
                System.out.println("32. TRAFFIC ESTIMATION : " + trafficEstimation);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//-- -- -- -- -- -- -- -- -- -- -- -- --code for interest- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

        try {
            Document doc5;
            String pinteresturl;
            Document doc6;
            String url1 = complete_url.replace("http://www.", "").replace(".com", "");
            String googlestring = "https://www.google.com/search?q=" + url1 + "pinterest";
            System.out.println("------------GoogleString Pinterest--------------" + googlestring);
            try {
                doc5 = Jsoup.parse(fetchGooglePageRankWithProxy(googlestring));
                Element e1 = doc5.select("div[class=s] div[class=kv] cite").first();
                System.out.println(" pinteresturl : " + e1.text());
                pinteresturl = e1.text();
                doc6 = Jsoup.parse(fetchGooglePageRankWithProxy(pinteresturl));

                try {
                    Element eboard = doc6.select("div[class=tabs] ul li div[class=Module BoardCount] span[class=value]").first();
                    PinterestBoards = eboard.text();
                    System.out.println("34 PinterestBoards : " + PinterestBoards);
                } catch (Exception e) {
                }

                try {
                    Element epins = doc6.select("li span[class=value]").get(1);
                    PinterestPins = epins.text();
                    System.out.println("35 PinterestPins : " + PinterestPins);
                } catch (Exception e) {
                }

                try {
                    Element elikes = doc6.select("li span[class=value]").get(2);
                    PinterestLikes = elikes.text();
                    System.out.println("36 PinterestLikes : " + PinterestLikes);
                } catch (Exception e) {
                }

                try {
                    Element efollower = doc6.select("li span[class=value]").get(3);
                    PinterestFollower = efollower.text();
                    System.out.println("37 PinterestFollower : " + PinterestFollower);
                } catch (Exception e) {
                }

                try {
                    Element efollowing = doc6.select("li span[class=value]").get(4);
                    PinterestFollowing = efollowing.text();
                    System.out.println("38 PinterestFollowing : " + PinterestFollowing);
                } catch (Exception e) {
                }

                try {
                    Element eprofile = doc6.select("div[class=profileImage] img").first();
                    PinterestImage = eprofile.attr("src");
                    System.out.println("39 PinterestImage : " + PinterestImage);
                } catch (Exception e) {
                }

                try {
                    Element ename = doc6.select("div[class=name]").first();
                    PinterestName = ename.text();
                    System.out.println("40 PinterestName : " + PinterestName);
                } catch (Exception e) {
                }

                try {
                    Element edescription = doc6.select("div[class=about] p[class=aboutText]").first();
                    PinterestDescription = edescription.text();
                    System.out.println("41 PinterestDescription : " + PinterestDescription);
                } catch (Exception e) {
                }

            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

        //**********************************code for Linkedin**********************************************
        try {
            String url2 = complete_url.replace("http://www.", "").replace(".com", "");
            String googlestring1 = "https://www.google.com/search?q=" + url2 + "linkedin";
            System.out.println("    -- Google review Linked Url: " + googlestring1);
            try {
                Document doc7 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy(googlestring1));

                Element e2 = doc7.select("div[class=s] div[class=kv] cite").first();
                System.out.println(" Linked Url : " + e2.text());
                String linkedinurl = e2.text();

                try {

                    Document doc8 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy(linkedinurl));
                    try {
                        Element efollower = doc8.select("div[class=follow-content] p[class=followers-count] strong").first();
                        System.out.println("42. Linkedin Follower : " + efollower.text());
                        linkedFollower = efollower.text();
                    } catch (Exception e) {
                    }

                    try {
                        Element eimage = doc8.select("div[id=content] img").first();
                        System.out.println("43. Linkedin Image : " + eimage.attr("src"));
                        linkedImage = eimage.attr("src");
                    } catch (Exception e) {
                    }

                    try {
                        Element ediscription = doc8.select("dd[class=basic-info-description] p").first();
                        System.out.println("44. Linkedin Description : " + ediscription.text());
                        linkedDescription = ediscription.text();
                    } catch (Exception e) {
                    }

                    try {
                        Element especialties = doc8.select("div[class=specialties] p").first();
                        System.out.println("45. Linkedin Specialties : " + especialties.text());
                        linkedSpecialties = especialties.text();
                    } catch (Exception e) {
                    }

                    try {
                        Element ewebsite = doc8.select("dd[class=basic-info-about] li[class=website] p a").first();
                        System.out.println("46. Linkedin Website : " + ewebsite.text());
                        linkedWebsite = ewebsite.text();
                    } catch (Exception e) {
                    }

                    try {
                        Element eindustry = doc8.select("dd[class=basic-info-about] li[class=industry] p").first();
                        System.out.println("47. Linkedin Industry : " + eindustry.text());
                        linkedIndustry = eindustry.text();
                    } catch (Exception e) {
                    }

                    try {
                        Element etype = doc8.select("dd[class=basic-info-about] li[class=type] p").first();
                        System.out.println("48. Linkedin Type : " + etype.text());
                        linkedType = etype.text();
                    } catch (Exception e) {
                    }

                    try {
                        Element eheadquater = doc8.select("dd[class=basic-info-about] li[class=vcard hq] p").first();
                        System.out.println("49. Linkedin headquater : " + eheadquater.text());
                        linkedHeadquater = eheadquater.text();
                    } catch (Exception e) {
                    }

                    try {
                        Element ecompanysize = doc8.select("dd[class=basic-info-about] li[class=company-size] p").first();
                        System.out.println("50. Linkedin Company Size : " + ecompanysize.text());
                        linkedCompany = ecompanysize.text();
                    } catch (Exception e) {
                    }

                    try {
                        Element efounded = doc8.select("dd[class=basic-info-about] li[class=founded] p").first();
                        System.out.println("51. Linkedin Founded : " + efounded.text());
                        linkedFounded = efounded.text();
                    } catch (Exception e) {
                    }

                    try {
                        Element employe = doc8.select("div[class=company-employees module] a[class=employee-count]").first();
                        System.out.println("52. Linkedin Employee : " + employe.text());
                        linkedEmployee = employe.text();
                    } catch (Exception e) {
                    }

                } catch (Exception e) {
                }

            } catch (Exception e) {
            }

        } catch (Exception e) {
        }
//*********************************Social Shareability**************************        
        try {
            URL xmlURL = new URL("http://data.alexa.com/data?cli=10&dat=s&url=" + complete_url);
            InputStream stream = xmlURL.openStream();
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            org.w3c.dom.Document doc1 = docBuilder.parse(stream);
            doc1.getDocumentElement().normalize();
            NodeList nodeList = doc1.getElementsByTagName("POPULARITY");
            aLexaRank = "blank";
            if (nodeList != null && nodeList.getLength() > 0) {
                org.w3c.dom.Node currentNode = nodeList.item(0);
                org.w3c.dom.Element currentElement = (org.w3c.dom.Element) currentNode;
                aLexaRank = currentElement.getAttribute("TEXT");
                System.out.println("53. ALexa Rank                  : " + aLexaRank);
            }
        } catch (Exception e) {

        }

        try {

            String facebookurl = "http://api.ak.facebook.com/restserver.php?v=1.0&method=links.getStats&format=json&callback=fb_sharepro_render&urls="
                    + complete_url;
            String response = null;
            response = new GetRequestHandler().doGetRequest(new URL(facebookurl));
            // System.out.println("facebook Details Response : " + response);
            try {
                Pattern pattern = Pattern.compile("share_count(.*?),");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    facebookShareCount = matcher.group(1).replace("\":", "").trim();
                    System.out.println("54. Facebook Share Count        : " + facebookShareCount);
                }
            } catch (Exception e) {
            }

            try {
                Pattern pattern = Pattern.compile("like_count(.*?),");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    facebookLikesCount = matcher.group(1).replace("\":", "").trim();
                    System.out.println("55. Facebook Likes Count        : " + facebookLikesCount);
                }
            } catch (Exception e) {
            }

            try {
                Pattern pattern = Pattern.compile("comment_count(.*?),");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    facebookComment = matcher.group(1).replace("\":", "").trim();
                    System.out.println("56. Facebook Comment Count      : " + facebookComment);
                }
            } catch (Exception e) {
            }

            try {
                Pattern pattern = Pattern.compile("total_count(.*?),");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    facebookTotalCount = matcher.group(1).replace("\":", "").trim();
                    System.out.println("57. Facebook Total Count        : " + facebookTotalCount);
                }
            } catch (Exception e) {
            }

            try {
                Pattern pattern = Pattern.compile("click_count(.*?),");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    facebookClickCount = matcher.group(1).replace("\":", "").trim();
                    System.out.println("58. Facebook Click Count        : " + facebookClickCount);
                }
            } catch (Exception e) {
            }

            try {
                Pattern pattern = Pattern.compile("commentsbox_count(.*?)}");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    facebookCommentsBoxCount = matcher.group(1).replace("\":", "");
                    System.out.println("59. Facebook comments Box count : " + facebookCommentsBoxCount);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } catch (Exception e) {

        }

        try {
            String linkedinurl = "https://www.linkedin.com/countserv/count/share?url=" + complete_url + "&lang=en_US";
            String response = null;
            response = new GetRequestHandler().doGetRequest(new URL(linkedinurl));
            // System.out.println("LinkedIn Details Response : " + response);

            try {
                Pattern pattern = Pattern.compile("count(.*?),");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    linkedInCount = matcher.group(1).replace("\":", "").trim();
                    System.out.println("60. LinkedIn Count              : " + linkedInCount);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

        try {
            String pinteresturl1 = "http://api.pinterest.com/v1/urls/count.json?callback=receiveCount&url=" + complete_url;
            String response = null;
            response = new GetRequestHandler().doGetRequest(new URL(pinteresturl1));
//            System.out.println("Pinterest Details Response : " + response);

            try {
                Pattern pattern = Pattern.compile("count(.*?)}");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    pinterestCount = matcher.group(1).replace("\":", "").trim();
                    System.out.println("61.Pinterest Count              : " + pinterestCount);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

        try {
            String twitterurl = "http://urls.api.twitter.com/1/urls/count.json?url=" + complete_url;
            String response = null;
            response = new GetRequestHandler().doGetRequest(new URL(twitterurl));
            // System.out.println("Twitter Details Response : " + response);

            try {
                Pattern pattern = Pattern.compile("count(.*?),");
                Matcher matcher = pattern.matcher(response);
                if (matcher.find()) {
                    twitterCounts = matcher.group(1).replace("\":", "").trim();
                    System.out.println("62.Twitter Count                : " + twitterCounts);
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }

        objwoorankdao.updateCommonseo(id, complete_url, pageRank, titleLength, title, description, descriptionLength, flash, frames, htmlRatio, facebookLikes, facebook_about, facebookImage, talking_about_count, googleImage, googleFollower, googleViews, keyword, global_rank, country_rank, w3cvalidity, encoding, doctype, twitterimage, twittercount, twitterfolowing, twitterfolowrs, twitterdescrip, twitterfavorites, twitterdate, twitterList, indexedPages, backlinksCounter, mobileLoadTime, trafficEstimation, PinterestBoards, PinterestPins, PinterestLikes, PinterestFollower, PinterestFollowing, PinterestImage, PinterestName, PinterestDescription, linkedFollower, linkedImage, linkedDescription, linkedSpecialties, linkedWebsite, linkedIndustry, linkedType, linkedHeadquater, linkedCompany, linkedFounded, linkedEmployee, aLexaRank, facebookShareCount, facebookLikesCount, facebookComment, facebookTotalCount, facebookClickCount, facebookCommentsBoxCount, linkedInCount, pinterestCount, twitterCounts);
    }

    public void headingCountUpdate(String complete_url) {
        String h1 = "0";
        String h2 = "0";
        String h3 = "0";
        String h4 = "0";
        String h5 = "0";

        String h1elements = "";
        String h2elements = "";
        String h3elements = "";
        String h4elements = "";
        String h5elements = "";

        Document doc;
        try {
            doc = Jsoup.parse(fetchGooglePageRank(complete_url));
        } catch (Exception e) {
            System.out.println("COULD NOT FETCH WEB PAGE: \n" + e);
            return;
        }

        Elements e1 = doc.select("h1");
        int count = 0;
        for (Element e2 : e1) {
            count++;
            h1elements = h1elements + e2.text() + "#";
        }
        h1 = "" + count;

        e1 = doc.select("h2");
        count = 0;
        for (Element e2 : e1) {
            count++;
            h2elements = h2elements + e2.text() + "#";
        }
        h2 = "" + count;

        e1 = doc.select("h3");
        count = 0;
        for (Element e2 : e1) {
            count++;
            h3elements = h3elements + e2.text() + "#";
        }
        h3 = "" + count;

        e1 = doc.select("h4");
        count = 0;
        for (Element e2 : e1) {
            count++;
            h4elements = h4elements + e2.text() + "#";
        }
        h4 = "" + count;

        e1 = doc.select("h5");
        count = 0;
        for (Element e2 : e1) {
            count++;
            h5elements = h5elements + e2.text() + "#";
        }
        h5 = "" + count;

        objwoorankdao.updateHeadingcount(complete_url, h1, h2, h3, h4, h5);
        objwoorankdao.updateHeadingelements(complete_url, h1elements, h2elements, h3elements, h4elements, h5elements);
    }

    public void imageUpdate(String complete_url) {

        String image_count = "0";
        String imagesrc = "";
        Document doc;
        try {
            doc = Jsoup.parse(fetchGooglePageRank(complete_url));
        } catch (Exception e) {
            System.out.println("COULD NOT FETCH WEB PAGE: \n" + e);
            return;
        }

        int counter = 0;
        Elements e1 = doc.getElementsByTag("img");
        for (Element element : e1) {

            if (element.attr("src").length() > 5) {
                imagesrc = imagesrc + element.attr("src") + "#";
                counter++;
            }
        }
        image_count = "" + counter;
        objImage.setSrc(imagesrc);
        objwoorankdao.updateImage(complete_url, imagesrc);
    }

    public void pagelinksUpdate(String complete_url) {
        String links = "";
        String title = "";
        String type = "";

        Document doc;

        try {
            doc = Jsoup.parse(fetchGooglePageRank(complete_url));
        } catch (Exception e) {
            System.out.println("COULD NOT FETCH WEB PAGE: \n" + e);
            return;
        }

        String temp = "";
        String templink = "";
        Elements e1 = doc.select("a");
        for (Element e2 : e1) {
            temp = e2.attr("href");

            if (temp.length() < 3) {
                continue;
            }

            if (temp.contains("http://") || temp.contains("https://")) {
                type = type + "External" + "#";
                links = links + (temp) + "#";

            } else {
                type = type + "Internal" + "#";
                temp = "" + complete_url + temp;
                links = links + temp + "#";
            }

            if (e2.text().length() > 3) {
                title = title + e2.text() + "#";
            } else {
                title = title + temp + "#";
            }
        }

        objwoorankdao.updatePagelinks(complete_url, links, title, type);
    }

    public void relatedWebsiteUpdate(String complete_url) {
        String relatedLinks = "";

        try {
            String links;
            String urlKeyword = "https://www.google.com/search?q=related:" + complete_url + "/%20" + (complete_url.replace("www.", "")).replace("https://", "").replace("http://", "");
            System.out.println("KEYWORD: " + urlKeyword);
            Document doc = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy(urlKeyword));
            Elements el1 = doc.select("div[id=ires] li[class=g]");
            for (Element itr : el1) {
                Elements el2 = itr.select("h3[class=r]");
                links = el2.select("a").attr("href") + "";
                links = links.substring(links.indexOf("http"), links.indexOf("&"));
                relatedLinks = relatedLinks + links + "#";
            }
            objRelatedwebsite.setRelatedLinks(relatedLinks);
            objwoorankdao.updateRelatedwebsite(complete_url, relatedLinks);
        } catch (IOException e) {
            System.out.println("Exception in RelatedPages " + e);
        }

    }

    public void technologyUpdate(String complete_url) {
        String techUsed = "";
        String analytics = "";

        try {

            int frmIndex = 0, tmp = 0, scriptStopper = 0;
            Document Doc = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy("http://builtwith.com/" + complete_url.replace("http://", "").replace("https://", "").replace("www.", "")));
            Elements el1 = Doc.select("div[class=span8] div");
            Elements elExtrated = new Elements();
            for (Element itr : el1) {
                if (frmIndex != 0) {
                    if (itr.hasClass("titleBox")) {
                        break;
                    } else {
                        elExtrated.add(itr);
                    }
                }
                if (itr.select("span").text().equalsIgnoreCase("Frameworks")) {
                    frmIndex = tmp;
                }
                ++tmp;
            }
            for (Element itr : elExtrated) {
                techUsed = techUsed + itr.select("h3 a").text() + "#";

            }

            //* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *           
            elExtrated = new Elements();
            for (Element itr : el1) {
                if (frmIndex != 0) {
                    if (itr.hasClass("titleBox")) {
                        break;
                    } else {
                        elExtrated.add(itr);
                    }
                }
                if (itr.select("span").text().equalsIgnoreCase("JavaScript Libraries")) {
                    frmIndex = tmp;
                }
                ++tmp;
            }
            for (Element itr : elExtrated) {
                techUsed = techUsed + itr.select("h3 a").text() + "#";
                ++scriptStopper;

            }

            //* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *           
        } catch (Exception e) {
            System.out.println("Exceeption in TechUsedAndAnlytics " + e);
        }

        try {

            int scriptStopper = 0, frmIndex = 0, tmp = 0;
            Document doc = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy("http://builtwith.com/" + complete_url.replace("http://", "").replace("https://", "").replace("www.", "")));
            Elements el1 = doc.select("div[class=span8] div");
            Elements elExtrated = new Elements();
            for (Element itr : el1) {
                if (frmIndex != 0) {
                    if (itr.hasClass("titleBox")) {
                        break;
                    } else {
                        elExtrated.add(itr);
                    }
                }
                if (itr.select("span").text().equalsIgnoreCase("Analytics and Tracking")) {
                    frmIndex = tmp;
                }
                ++tmp;
            }
            for (Element itr : elExtrated) {
                analytics = analytics + itr.select("h3 a").text() + "#";
                ++scriptStopper;
            }

        } catch (Exception e) {
            System.out.println("Exceeption in TechUsedAndAnlytics " + e);
        }

        objwoorankdao.updateTechnology(complete_url, techUsed, analytics);
    }

    public void visitorInfoUpdate(String complete_url) {

        String global_rank = "NA";
        String country_rank = "NA";
        String country = "";
        String percent = "";
        String rank = "";

        try {

            String myurl = "http://www.alexa.com/siteinfo/" + complete_url;
            Document doc = Jsoup.parse(Crawler.fetchGooglePageRank(myurl));

//*****************CODE FOR GLOBAL RANK*****************************************
            try {
                global_rank = doc.select("span[class=globleRank] strong[class=metrics-data align-vmiddle]").first().text();

            } catch (Exception e) {
            }

//************************CODE FOR COUNTRY RANK*********************************
            try {
                country_rank = doc.select("span[class=countryRank] strong[class=metrics-data align-vmiddle]").first().text();

            } catch (Exception e) {
            }

            try {
                Elements e1 = doc.select("table[id=demographics_div_country_table] tbody tr td a");
                for (Element e : e1) {
                    country = country + e.text() + "#";
                }
            } catch (Exception e) {
            }

            try {
                Elements e2 = doc.select("table[id=demographics_div_country_table] td[class=text-right] span ");//.first();
                int i = 1;
                for (Element e : e2) {
                    if (i % 2 != 0) {
                        percent = percent + e.text() + "#";
                    } else {
                        rank = rank + e.text() + "#";
                    }
                    i++;
                }
            } catch (Exception e) {
            }

        } catch (Exception ex) {
        }
        objwoorankdao.upadteVisitorarray(complete_url, country, percent, rank);
    }

    public void xmlSiteMapUpdate(String complete_url) {
        String xmlfiles = "";
        String curl;

        String url = complete_url + "/robots.txt";
        System.out.println("" + url);

        try {
            Document doc = Jsoup.parse(Crawler.fetchGooglePageRank(url));

            String buf[] = doc.text().split(":");

            for (int i = 0; i < buf.length; i++) {

                if (buf[i].contains("Sitemap")) {
                    String t = (buf[i + 1] + buf[i + 2]).replace("Sitemap", "");
                    t = t.replace("### END FILE ###", "");
                    t = t.replace("Mobile sitemaps - SRPs", "");
                    t = t.replace("#", "");
//                    xmlfiles.add("" + t);
                    xmlfiles = xmlfiles + t + "#";
                }
            }

        } catch (Exception e) {
        }
//        objXmldata.setUrl(curl);
        objXmldata.setXmlfiles(xmlfiles);
        objwoorankdao.updateXmldata(complete_url, xmlfiles);

    }

    public void getDetailsFromDatabase(String url, Commonseo objCommonseo) {

        Headingcount objHeadingcount = new Headingcount();
        Headingelements objHeadingelements = new Headingelements();
        Image objImage = new Image();
        Pagelinks objPagelinks = new Pagelinks();
        Relatedwebsite objRelatedwebsite = new Relatedwebsite();
        Technology objTechnology = new Technology();
        Visitorarray objVisitorarray = new Visitorarray();
        Xmldata objXmldata = new Xmldata();
        HtmlValidator objHtmlValidator = new HtmlValidator();

        System.out.println("***********************************FETCHING VALUES FROM DATABASE*****************************************");
        try {

//            objCommonseo = objwoorankdao.getCommonSeoDetails(url);
            objHeadingcount = objwoorankdao.getHeadingCountDetails(url);
            objHeadingelements = objwoorankdao.getHeadingelementsDetails(url);
            objImage = objwoorankdao.getImageDetails(url);
            objPagelinks = objwoorankdao.getPagelinksDetails(url);
            objRelatedwebsite = objwoorankdao.getRelatedwebsiteDetails(url);
            objTechnology = objwoorankdao.getTechnologyDetails(url);
            objVisitorarray = objwoorankdao.getVisitorarrayDetails(url);
            objXmldata = objwoorankdao.getXmldataDetails(url);

            page_rank = objCommonseo.getPageRank();
            System.out.println("1.PAGE_RANK DATABASE: " + objCommonseo.getPageRank());

            title = objCommonseo.getTitle();
            System.out.println("2.TITLE DATABASE: " + objCommonseo.getTitle());

            title_length = objCommonseo.getTitleLength();
            System.out.println("3.TILTE_LENGTH DATABASE: " + objCommonseo.getTitleLength());

            description = objCommonseo.getDescription();
            System.out.println("4.DESCRIPTION DATABASE: " + objCommonseo.getDescription());

            descriptionLength = objCommonseo.getDescriptionLength();
            System.out.println("5.DESCRIPTION LENGTH DATABASE: " + objCommonseo.getDescriptionLength());

            www_resolve = objCommonseo.getWwwResolve();
            System.out.println("6.WWWRESOLVE DATABASE: " + objCommonseo.getWwwResolve());

            ipcanonicalization = objCommonseo.getIpCanonicalization();
            System.out.println("7.IP_CANONICALIZATION DATABASE: " + objCommonseo.getIpCanonicalization());

            ipaddress = objCommonseo.getIpaddress();
            System.out.println("8.IP_ADDRESS DATABASE: " + objCommonseo.getIpaddress());

            robots = objCommonseo.getRobots();
            System.out.println("9.ROBOTS DATABASE: " + objCommonseo.getRobots());

            flash_content = objCommonseo.getFlash();
            System.out.println("10.FLASH DATABASE: " + objCommonseo.getFlash());

            frames = objCommonseo.getFrames();
            System.out.println("11.FRAMES DATABASE: " + objCommonseo.getFrames());

            underscores_in_url = objCommonseo.getUnderscores();
            System.out.println("12.UNDERSCORES DATABASE: " + objCommonseo.getUnderscores());

            di.created_date = objCommonseo.getDomainCreated();
            System.out.println("13.DOMAIN_CREATED DATABASE: " + objCommonseo.getDomainCreated());

            di.updated_date = objCommonseo.getDomainUpdated();
            System.out.println("14.DOMAIN_UPDATED DATABASE: " + objCommonseo.getDomainUpdated());

            di.expited_date = objCommonseo.getDomainExpired();
            System.out.println("15.DOMAIN_EXPIRED DATABASE: " + objCommonseo.getDomainExpired());

            google_publisher = objCommonseo.getGooglePublisher();
            System.out.println("16.GOOGLE_PUBLISHER DATABASE: " + objCommonseo.getGooglePublisher());

            texttohtmlratio = objCommonseo.getHtmlRatio();
            System.out.println("17.HTML_RATO DATABASE: " + objCommonseo.getHtmlRatio());

            ipaddress = objCommonseo.getIpaddress();
            System.out.println("18.IP_ADDRESS DATABASE: " + objCommonseo.getIpaddress());

            objFacebookStructure.facebook_url = objCommonseo.getFacebookUrl();
            System.out.println("19.FACEBOOK_URL DATABASE: " + objCommonseo.getFacebookUrl());

            objFacebookStructure.facebook_name = objCommonseo.getFacebookName();
            System.out.println("20.FACEBOOK_NAME DATABASE: " + objCommonseo.getFacebookName());

            objFacebookStructure.facebook_likes = objCommonseo.getFacebookLikes();
            System.out.println("21.FACEBOOK_LIKES DATABASE: " + objCommonseo.getFacebookLikes());

            objFacebookStructure.facebook_about = objCommonseo.getFacebookAbout();
            System.out.println("22.FACEBOOK_ABOUT DATABASE: " + objCommonseo.getFacebookAbout());

            objFacebookStructure.facebook_image = objCommonseo.getFacebookImage();
            System.out.println("23.FACEBOOK_IMAGES DATABASE: " + objCommonseo.getFacebookImage());

            objFacebookStructure.facebook_products = objCommonseo.getFacebookProduct();
            System.out.println("24.FACEBOOK_PRODUCT DATABASE: " + objCommonseo.getFacebookProduct());

            objFacebookStructure.facebook_overview = objCommonseo.getFacebookOverview();
            System.out.println("25.FACEBOOK_OVERVIEW DATABASE: " + objCommonseo.getFacebookOverview());

            objFacebookStructure.facebook_address = objCommonseo.getFacebookAddress();
            System.out.println("26.FACEBOOK_ADDRESS DATABASE: " + objCommonseo.getFacebookAddress());

            objFacebookStructure.facebook_phone = objCommonseo.getFacebookPhone();
            System.out.println("27.FACEBOOK_PHONE DATABASE: " + objCommonseo.getFacebookPhone());

            objFacebookStructure.facebook_mission = objCommonseo.getFacebookMission();
            System.out.println("28.FACEBOOK_MISSION DATABASE: " + objCommonseo.getFacebookMission());

            objFacebookStructure.facebookDescription = objCommonseo.getFacebookDescription();
            System.out.println("29.FACEBOOK_DESCRPTION DATABASE: " + objCommonseo.getFacebookDescription());

            objFacebookStructure.talking_about_count = objCommonseo.getTakingAbout();
            System.out.println("30.TAKING_ABOUT DATABASE: " + objCommonseo.getTakingAbout());

            objTwitterDetalis.twitterUrl = objCommonseo.getTwitterUrl();
            System.out.println("31.TWITTER URL DATABASE: " + objCommonseo.getTwitterUrl());

            objTwitterDetalis.twittername = objCommonseo.getTwitterName();
            System.out.println("32.TWITTER NAME DATABASE: " + objCommonseo.getTwitterName());

            objTwitterDetalis.twitterimage = objCommonseo.getTwitterImage();
            System.out.println("33.TWITTER IMAGE DATABASE: " + objCommonseo.getTwitterImage());

            objTwitterDetalis.twittercount = objCommonseo.getTwitterCount();
            System.out.println("34.TWITTER COUNT DATABASE: " + objCommonseo.getTwitterCount());

            objTwitterDetalis.twitterfolowing = objCommonseo.getTwitterFollowing();
            System.out.println("35.TWITTER FOLLOWING DATABASE: " + objCommonseo.getTwitterFollowing());

            objTwitterDetalis.twitterfolowrs = objCommonseo.getTwitterFollower();
            System.out.println("36.TWITTER FOLLOWERS DATABASE: " + objCommonseo.getTwitterFollower());

            objTwitterDetalis.twitterdescrip = objCommonseo.getTwitterDescription();
            System.out.println("37.TWITTER DESCRIPTION DATABASE: " + objCommonseo.getTwitterDescription());

            objTwitterDetalis.twitterlocation = objCommonseo.getTwitterLocation();
            System.out.println("38.TWITTER LOCATION DATABASE: " + objCommonseo.getTwitterLocation());

            objTwitterDetalis.twitterList = objCommonseo.getTwitterList();
            System.out.println("39.TWITTER LIST DATABASE: " + objCommonseo.getTwitterList());

            objTwitterDetalis.twitterfavorites = objCommonseo.getTwitterFavourites();
            System.out.println("40.TWITTER FAVORITES DATABASE: " + objCommonseo.getTwitterFavourites());

            objTwitterDetalis.twitterdate = objCommonseo.getTwitterDate();
            System.out.println("41.TWITTER DATE DATABASE: " + objCommonseo.getTwitterDate());

            objGoogleplus.URL = objCommonseo.getGoogleUrl();
            System.out.println("42.GOOGLE_URL DATABASE: " + objCommonseo.getGoogleUrl());

            objGoogleplus.Name = objCommonseo.getGoogleName();
            System.out.println("43.GOOGLE_NAME DATABASE: " + objCommonseo.getGoogleName());

            objGoogleplus.Verified = objCommonseo.getGoogleVerified();
            System.out.println("44.GOOGLE_VERIFIED DATABASE: " + objCommonseo.getGoogleVerified());

            objGoogleplus.Tagline = objCommonseo.getGoogleTagline();
            System.out.println("45.GOOGLE_TAGLINE DATABASE: " + objCommonseo.getGoogleTagline());

            objGoogleplus.Introduction = objCommonseo.getGoogleIntroduction();
            System.out.println("46.GOOGLE_INTRODUCTION DATABASE: " + objCommonseo.getGoogleIntroduction());

            objGoogleplus.Company_Overview = objCommonseo.getGoogleOverview();
            System.out.println("47.GOOGLE_OVERVIEW DATABASE: " + objCommonseo.getGoogleOverview());

            objGoogleplus.Image = objCommonseo.getGoogleImage();
            System.out.println("48.GOOGLE_IMAGE DATABASE: " + objCommonseo.getGoogleImage());

            gps.line1 = objCommonseo.getReviewGoogleTitle();
            System.out.println("49.GOOGLE_TITLE DATABASE: " + objCommonseo.getReviewGoogleTitle());

            gps.line2 = objCommonseo.getReviewGoogleUrl();
            System.out.println("50.REVIEW_GOOGLE_URL DATABASE: " + objCommonseo.getReviewGoogleUrl());

            gps.line3 = objCommonseo.getReviewGoogleDesc();
            System.out.println("51.REVIEW_GOOGLE_DESC DATABASE: " + objCommonseo.getReviewGoogleDesc());

            objCommonseo.getKeyword();
            String temp[] = objCommonseo.getKeyword().split(":");
            for (int i = 0; i < (temp.length - 1); i++) {
                keywords.add("" + temp[i]);

            }
            System.out.println("52.KEYWORDS DATABASE: " + objCommonseo.getKeyword());

            objServerIPLocation.flagCode = objCommonseo.getFlagCode();
            System.out.println("53.FLAG_CODE DATABASE: " + objCommonseo.getFlagCode());

            objServerIPLocation.location = objCommonseo.getLocat();
            System.out.println("54.LOCATION DATABASE: " + objCommonseo.getLocat());

            objServerIPLocation.latitude = objCommonseo.getLatitude();
            System.out.println("Latitude : " + objCommonseo.getLatitude());
            objServerIPLocation.longitude = objCommonseo.getLongitude();
            System.out.println("Longitude : " + objCommonseo.getLongitude());
            url_Domain = objCommonseo.getUrlDomain();
            System.out.println("55.URL_DOMAIN DATABASE: " + objCommonseo.getUrlDomain());;;

            objVisitorsInfo.global_rank = objCommonseo.getGlobalRank();
            System.out.println("60.GLOBAL_RANK DATABASE: " + objCommonseo.getGlobalRank());

            objVisitorsInfo.country_rank = objCommonseo.getCountryRank();
            System.out.println("61.COUNTRY_RANK DATABASE: " + objCommonseo.getCountryRank());

            objw3cDoctypeEncoding.W3CValidity = objCommonseo.getW3cvalidity();
            System.out.println("62.W3C_VALIDITY DATABASE: " + objCommonseo.getW3cvalidity());

            objw3cDoctypeEncoding.Encoding = objCommonseo.getEncoding();
            System.out.println("63.ENCODING DATABASE: " + objCommonseo.getEncoding());

            objw3cDoctypeEncoding.Doctype = objCommonseo.getDoctype();
            System.out.println("64.DOCTYPE DATABASE: " + objCommonseo.getDoctype());

            objHtmlValidator.passedpercentage = objCommonseo.getPassedPercent();
            System.out.println("65.PASSED PERCENT DATABASE: " + objCommonseo.getPassedPercent());

            objHtmlValidator.errorpercentage = objCommonseo.getErrorPercent();
            System.out.println("66.ERROR PERCENT DATABASE: " + objCommonseo.getErrorPercent());

            objHtmlValidator.toimprovepercentage = objCommonseo.getImprovePercent();
            System.out.println("67.IMPROVE PERCENT DATABASE: " + objCommonseo.getImprovePercent());

            objIndexedPages.indexedPages = objCommonseo.getIndexedPages();
            System.out.println("68.INDEXED PAGES DATABASE: " + objCommonseo.getIndexedPages());

//            objBacklinksCounter.backlinksCounter = objCommonseo.getBacklinksCounter();
//            System.out.println("69.BACKLINKS COUNTER DATABASE " + objCommonseo.getBacklinksCounter());
            objBacklinksCounter.mobileLoadTime = objCommonseo.getMobileLoadTime();
            System.out.println("70.MOBILE LOAD TIME DATABASE: " + objCommonseo.getMobileLoadTime());

            objBacklinksCounter.trafficEstimation = objCommonseo.getTrafficEstimation();
            System.out.println("71.TRAFFIC ESTIMATION DATABASE: " + objCommonseo.getTrafficEstimation());

//            objScoreValue.scoreValue = objCommonseo.getScoreValue();
//            System.out.println("72.SCORE VALUE : " + objCommonseo.getScoreValue());
            //******************************HEADING_COUNT,HEADING_ELEMENTS FROM TABLE***********************
            System.out.println("__________________HEADINGS________________");
            //hs.getInfoFromDatabase(complete_url);
            hs.h1 = objHeadingcount.getHeading1();
            hs.h2 = objHeadingcount.getHeading2();
            hs.h3 = objHeadingcount.getHeading3();
            hs.h4 = objHeadingcount.getHeading4();
            hs.h5 = objHeadingcount.getHeading5();

            hs.h1elements = objHeadingelements.getH1elements();
            hs.h2elements = objHeadingelements.getH2elements();
            hs.h3elements = objHeadingelements.getH3elements();
            hs.h4elements = objHeadingelements.getH4elements();
            hs.h5elements = objHeadingelements.getH5elements();

            System.out.println("72.h1 DATABASE: " + hs.h1 + "\n " + hs.h1elements + "");
            System.out.println("73.h2 DATABASE: " + hs.h2 + "\n " + hs.h2elements + "");
            System.out.println("74.h3 DATABASE: " + hs.h3 + "\n " + hs.h3elements + "");
            System.out.println("75.h4 DATABASE: " + hs.h4 + "\n " + hs.h4elements + "");
            System.out.println("76.h5 DATABASE: " + hs.h5 + "\n " + hs.h5elements + "");

            //******************************IMAGES FROM TABLE***********************
            System.out.println("__________________IMAGES DATABASE________________");
            System.out.println("[7] Image Details");
            is.imagesrc = objImage.getSrc();

            System.out.println("77.No of images DATABASE: " + is.image_count);
            System.out.println("78.images path DATABASE: " + is.imagesrc);

            //******************************PAGE_LINKS FROM TABLE***********************
            System.out.println("[21]In-Page Links");
            System.out.println("__________________IN PAGE LINKS DATABASE________________");

            ipl.title = objPagelinks.getTitle();
            ipl.links = objPagelinks.getLinks();
            ipl.type = objPagelinks.getType();

            System.out.println("79.TITLE DATABASE: " + ipl.title);
            System.out.println("80.LINK DATABASE: " + ipl.links);
            System.out.println("81.TYPE DATABASE: " + ipl.type);

            //******************************RELATED_LINKS FROM TABLE***********************
            System.out.println("__________________RELATED WEBSITES DATABASE________________");

            objRelatedWebsites.relatedLinks = objRelatedwebsite.getRelatedLinks();
            System.out.println("82.Related websites DATABASE: " + objRelatedWebsites.relatedLinks);

            //******************************TECHNOLOGY FROM TABLE***********************
            objTechUsedAndAnlytics.techUsed = objTechnology.getTechUsed();
            objTechUsedAndAnlytics.analytics = objTechnology.getAnalytics();
            objTechUsedAndAnlytics.print();

            //******************************Visitor rank,visitor array FROM TABLE***********************
            System.out.println("[27 Visitors Information");
            System.out.println("___________________VISITOR INFORMATION DATABASE__________________");

            objVisitorsInfo.array_country = objVisitorarray.getCountry();
            objVisitorsInfo.array_percent = objVisitorarray.getPercent();
            objVisitorsInfo.array_Rank = objVisitorarray.getRank();
            System.out.println("83.COUNTRY NAME DATABASE: " + objVisitorsInfo.array_country);
            System.out.println("84.PERCENTAGE DATABASE: " + objVisitorsInfo.array_percent);
            System.out.println("85.RANK DATABASE: " + objVisitorsInfo.array_Rank);

            //******************************W3CDOC FROM TABLE***********************
            //******************************XML FROM TABLE***********************
            System.out.println("__________________XML SITEMAP DATABASE________________");

            xmls.xmlfiles = objXmldata.getXmlfiles();
            System.out.println("86.Xml_Sitemap DATABASE: " + xmls.xmlfiles);

            objPinterest.pInterestBoards = objCommonseo.getPInterestBoards();
            System.out.println("87. PINTEREST BOARDS DATABASE : " + objCommonseo.getPInterestBoards());

            objPinterest.pInterestPins = objCommonseo.getPInterestPins();
            System.out.println("88. PINTEREST PINS DATABASE : " + objCommonseo.getPInterestPins());

            objPinterest.pInterestLikes = objCommonseo.getPInterestLikes();
            System.out.println("89. PINTEREST LIKES DATABASE : " + objCommonseo.getPInterestLikes());

            objPinterest.pInterestFollower = objCommonseo.getPInterestFollower();
            System.out.println("90. PINTEREST FOLLOWER DATABASE : " + objCommonseo.getPInterestFollower());

            objPinterest.pInterestFollowing = objCommonseo.getPInterestFollowing();
            System.out.println("91. PINTEREST FOLLOWING DATABASE : " + objCommonseo.getPInterestFollowing());

            objPinterest.pInterestImage = objCommonseo.getPInterestImage();
            System.out.println("92. PINTEREST IMAGE DATABASE : " + objCommonseo.getPInterestImage());

            objPinterest.pInterestName = objCommonseo.getPInterestName();
            System.out.println("93. PINTEREST NAME DATABASE : " + objCommonseo.getPInterestName());

            objPinterest.pInterestDescription = objCommonseo.getPInterestDescription();
            System.out.println("94. PINTEREST DESCRIPTION DATABASE : " + objCommonseo.getPInterestDescription());

            objLinkedin.linkedFollower = objCommonseo.getLinkedFollower();
            System.out.println("95. LINKEDIN FOLLOWER : " + objCommonseo.getLinkedFollower());

            objLinkedin.linkedImage = objCommonseo.getLinkedImage();
            System.out.println("96. LINKEDIN IMAGE : " + objCommonseo.getLinkedImage());

            objLinkedin.linkedDescription = objCommonseo.getLinkedDescription();
            System.out.println("97. LINKEDIN DESCRIPTION : " + objCommonseo.getLinkedDescription());

            objLinkedin.linkedSpecialties = objCommonseo.getLinkedSpecialties();
            System.out.println("98. LINKEDIN SPECIALISTIES : " + objCommonseo.getLinkedSpecialties());

            objLinkedin.linkedWebsite = objCommonseo.getLinkedWebsite();
            System.out.println("99. LINKEDIN WEBSITE : " + objCommonseo.getLinkedWebsite());

            objLinkedin.linkedIndustry = objCommonseo.getLinkedIndustry();
            System.out.println("100. LINKEDIN INDUSTRY : " + objCommonseo.getLinkedIndustry());

            objLinkedin.linkedType = objCommonseo.getLinkedType();
            System.out.println("101. LINKEDIN TYPE : " + objCommonseo.getLinkedType());

            objLinkedin.linkedHeadquater = objCommonseo.getLinkedHeadquater();
            System.out.println("102. LINKEDIN HEADQUATER : " + objCommonseo.getLinkedHeadquater());

            objLinkedin.linkedCompany = objCommonseo.getLinkedCompany();
            System.out.println("103. LINKEDIN COMPANY SIZE : " + objCommonseo.getLinkedFollower());

            objLinkedin.linkedFollower = objCommonseo.getLinkedFollower();
            System.out.println("104. LINKEDIN FOUNDED : " + objCommonseo.getLinkedCompany());

            objLinkedin.linkedEmployee = objCommonseo.getLinkedEmployee();
            System.out.println("105. LINKEDIN EMPLOYEE : " + objCommonseo.getLinkedEmployee());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getDataUsingCrawling(String url) throws IOException, JSONException, DbxException {

        //***********************************SEO DETAILS*******************************
//        String result = "0";
        //   objcommonseo.setUrl(complete_url);
        Document doc;
        try {
            doc = Jsoup.parse(fetchGooglePageRank(complete_url));

        } catch (Exception e) {
            System.out.println("COULD NOT FETCH WEB PAGE: \n" + e);
            return;
        }

        //System.out.println(""+doc);
        System.out.println("__________Fetching SEO Details of " + url);

        //*******************************RELATED WEBSITES*******************************
        try {
//            objwoorankdao.deletRelatedwebsite(complete_url);// 2 changes
            objRelatedWebsites = new RelatedWebsites(complete_url, objwoorankdao, objRelatedwebsite);
            objRelatedWebsites.start();
//            objRelatedWebsites.RelatedPages(complete_url, objwoorankdao);

            System.out.println("__________________RELATED WEBSITES________________");
            System.out.println("[1]Related websites: " + objRelatedWebsites.relatedLinks);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //*********************************PAGE RANK************************************
        System.out.println("__________________PAGE RANK________________");
        objPageRank.getPageRank(doc, objcommonseo, complete_url);
        objPageRank.disp();

        //***********************************TITLE**************************************
        try {
            title = doc.title() + "";
            title_length = title.length() + "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("__________________TITLE________________");
        System.out.println("[3a]TITLE : " + title);

        try {
            objcommonseo.setTitle(title);
            System.out.println("__________________TITLE LENGTH________________");
            System.out.println("[3b]TITLE LENGT : " + title.length());
            objcommonseo.setTitleLength("" + title.length());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //*******************************DESCRIPTION************************************
        try {
            description = doc.select("meta[name=description]").attr("content");
            descriptionLength = description.length() + "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("__________________DESCRIPTION________________");
        System.out.println("[4]DESCRIPTION : " + description);
        System.out.println("DESCRIPTION LENGTH : " + descriptionLength);

        objcommonseo.setDescription(description);
        objcommonseo.setDescriptionLength("" + description.length());
        //***********************************HEADINGS***********************************
        try {
//            objwoorankdao.deleteHeadingElements(complete_url);// 3 changes
            hs.setElements(doc, complete_url, objheadingcount, objwoorankdao, objheadingelements);
//            hs = new HeadingStructure(doc, complete_url, objheadingcount, objwoorankdao);
//            hs.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("__________________HEADINGS________________");
            System.out.println("[5]Heading details");
            System.out.println("h1: " + hs.h1 + "\n " + hs.h1elements + "");
            System.out.println("h2: " + hs.h2 + "\n " + hs.h2elements + "");
            System.out.println("h3: " + hs.h3 + "\n " + hs.h3elements + "");
            System.out.println("h4: " + hs.h4 + "\n " + hs.h4elements + "");
            System.out.println("h5: " + hs.h5 + "\n " + hs.h5elements + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //******************************KEYWORDS CLOUD**********************************
        try {
            String temp[] = doc.select("meta[name=keywords]").attr("content").split(",");
            for (int i = 0; i < temp.length; i++) {
                keywords.add("" + temp[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("__________________KEYWORDS CLOUD________________");
            System.out.println("[6]Keywords: " + keywords);
            String key = "";
            for (int i = 0; i < keywords.size(); i++) {

                key = key + keywords.get(i) + ":";
            }
            objcommonseo.setKeyword("" + key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //*************************************IMAGES***********************************
        try {
//            objwoorankdao.deleteImage(complete_url);// 4 changes
//            is.setImageDetails(doc, complete_url, objwoorankdao);
            is = new ImageStructure(doc, complete_url, objwoorankdao, objImage);
            is.start();
        } catch (Exception e) {
        }

        try {
            System.out.println("__________________IMAGES________________");
            System.out.println("[7] Image Details");
            System.out.println("No of images : " + is.image_count);
            System.out.println("images path : " + is.imagesrc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //***********************************WWW RESOLVE********************************
        String temp = null;
        try {
            String myurl = complete_url.replace("www.", "");
            Document doc1 = Jsoup.connect(myurl).get();
            temp = "" + doc1;
            if (temp != null) {
                www_resolve = "This website with and without www redirects to the same page.";
            }

        } catch (Exception qw) {
            www_resolve = "This website without www does not redirects to the same page.";
        }
        System.out.println("__________________WWW RESOLVE________________");
        System.out.println("[8]www resolve : \n" + www_resolve);
        objcommonseo.setWwwResolve(www_resolve);
        //*************************IP CANONICALIZATION**********************************
        try {
            InetAddress address = InetAddress.getByName(new URL(complete_url).getHost());
            ipaddress = address.getHostAddress();
            System.out.println("SERVER IP ADDRESS : " + ipaddress);
            objcommonseo.setIpaddress(ipaddress);

            Document doc1 = Jsoup.connect("http://" + ipaddress).get();
            String title2 = doc1.title();

            if (title.equalsIgnoreCase(title2)) {
                ipcanonicalization = "Yes";
            } else {
                ipcanonicalization = "No";
            }
        } catch (Exception qq) {
            ipcanonicalization = "No";
        }
        System.out.println("__________________IP CANONICALIZATION________________");
        System.out.println("[9]Ip Canonicalization : " + ipcanonicalization);
        objcommonseo.setIpCanonicalization(ipcanonicalization);
        //**********************************ROBOT.TXT***********************************
        try {
            Document doc2 = Jsoup.parse(fetchGooglePageRank(complete_url + "/robots.txt"));

            temp = "" + doc2.html();

            //System.out.println(""+temp);
            if (temp.contains("Disallow")) {
                robots = complete_url + "/robots.txt";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("__________________ROBOT.TXT________________");
        System.out.println("[10]ROBOT : " + robots);
        objcommonseo.setRobots(robots);

        //*****************************GOOGLE PREVIEW***********************************
        System.out.println("[11]Google preview ");
        System.out.println("__________________GOOGLE PREVIEW________________");

        try {

            Document doc1 = Jsoup.parse(fetchGooglePageRank("https://www.google.com/search?q=" + complete_url + ""));

            Element el1 = doc1.select("div[id=ires] li[class=g]").first();

            Element el2 = el1.select("h3[class=r]").first();       // title
            gps.line1 = el2.text();

            Element el3 = el1.select("div[class=s]").first();      // Green URl
            Elements el4 = el3.select("div[class=kv] cite");
            System.out.println(el4.text());
            gps.line2 = el4.text();

            Elements el5 = el3.select("span[class=st]");
            gps.line3 = el5.text();

            System.out.println("LINE1 : " + gps.line1);
            objcommonseo.setReviewGoogleTitle("" + gps.line1);

            System.out.println("LINE2 : " + gps.line2);
            objcommonseo.setReviewGoogleUrl("" + gps.line2);

            System.out.println("LINE3 : " + gps.line3);
            objcommonseo.setReviewGoogleDesc("" + gps.line3);

        } catch (Exception e) {
            System.out.println("Exception in GooglePreveiw " + e);
        }

        //*****************************FLASH CONTENT************************************
        temp = doc + "";
        if (temp.contains(".swf")) {
            flash_content = "Yes";
        } else {
            flash_content = "No";
        }
        System.out.println("__________________FLASH CONTENT________________");
        System.out.println("[12]Flash Content : " + flash_content);
        objcommonseo.setFlash(flash_content);

        //****************************TEXT HTML RATIO***********************************
        float ratioB = 0;
        try {
            String html, txt;
            html = doc + "";

            txt = doc.text();
            ratioB = (float) (((float) (txt.getBytes().length) / (float) (html.getBytes().length)) * (float) 100);
            texttohtmlratio = "" + ratioB;
        } catch (Exception e) {
            System.out.println("Exception in TextHtmlRatio ");
        }
        System.out.println("__________________TEXT HTML RATIO________________");
        System.out.println("[13]Text to html Ratio: " + texttohtmlratio);

        objcommonseo.setHtmlRatio("" + texttohtmlratio);

        //********************************FRAMES****************************************
        temp = doc + "";

        if (temp.contains("<frame") || temp.contains("<iframe")) {
            frames = "Yes The Webpage Contains frames";
        } else {
            frames = "No";
        }
        System.out.println("__________________FRAMES________________");
        System.out.println("[14]Frames: " + frames);
        objcommonseo.setFrames(frames);

        //********************************UNDERSCORES IN URL****************************
        if (complete_url.contains("_")) {
            underscores_in_url = "Yes";
        } else {
            underscores_in_url = "No";
        }
        System.out.println("__________________UNDERSCORES IN URL________________");

        System.out.println("[15]Underscores in The Url: " + underscores_in_url);
        objcommonseo.setUnderscores(underscores_in_url);

        //******************************DOMAIN INFORMATION******************************
        System.out.println("[16] Domain Information");
        System.out.println("__________________DOMAIN INFORMATION________________");
        di.setInfo(complete_url);

        System.out.println("[17]Domain Created: " + di.created_date);
        objcommonseo.setDomainCreated(di.created_date);

        System.out.println("[18]Domain Updated: " + di.updated_date);
        objcommonseo.setDomainUpdated(di.updated_date);

        System.out.println("[19]Domain Expiration: " + di.expited_date);
        objcommonseo.setDomainExpired(di.expited_date);

        //****************************XML SITEMAP***************************************
        System.out.println("[20] XML Sitemap");
        System.out.println("__________________XML SITEMAP________________");
//        objwoorankdao.deleteXmldata(complete_url);// 1 changes
//        xmls.setXmlInfo(complete_url, objwoorankdao);
        xmls = new XMLSitemap(complete_url, objwoorankdao, objXmldata);
        xmls.start();
        System.out.println("[20]Xml Sitemap" + xmls.xmlfiles);

        //*****************************IN PAGE LINKS************************************
        System.out.println("[21]In-Page Links");
        System.out.println("__________________IN PAGE LINKS________________");
//        objwoorankdao.deletePagelinks(complete_url);// 5 changes
        ipl = new InPageLinks(doc, url, objwoorankdao, objPagelinks);
        ipl.start();
        // ipl.setPageLinks(doc, complete_url, objwoorankdao);
        System.out.println("TITLE:" + ipl.title);
        System.out.println("LINK:" + ipl.links);
        System.out.println("TYPE:" + ipl.type);

        //***************************GOOGLE PUBLISHER***********************************
        System.out.println("[22] Google Publisher");
        System.out.println("__________________GOOGLE PUBLISHER________________");
        String docStr = doc.toString();
        docStr = (docStr.contains("rel=\"publisher\"") ? "Yes" : "No");
        google_publisher = docStr;
        System.out.println("[23]Google Publisher: " + google_publisher);
        objcommonseo.setGooglePublisher(google_publisher);

        //************************KEYWORD CONSISTENCY***********************************
        //        System.out.println("[24]Keywords Consistency");
        //        System.out.println("__________________KEYWORD CONSISTENCY________________");
        //        temp = hs.getAllHeadings();
        //        ks.setKeywordConsistency(keywords, description, title, temp, doc);
        //        ks.disp();
        //*************************SOCIAL DETAILS***************************************
        //****************************FACEBOOK DETAILS**********************************
        System.out.println("[25]facebook Details ");
        System.out.println("__________________FETCHING SOCIAL DETAILS________________");
        objFacebookStructure.getDetails(doc, objcommonseo, complete_url);
        objFacebookStructure.disp();

        objSocialShareability.getAlexaRanking(objcommonseo, complete_url);
        objSocialShareability.getFacebookDetails(doc, objcommonseo, complete_url);
        objSocialShareability.getGooglePlusDetails(doc, objcommonseo, complete_url);
        objSocialShareability.getPostSourceGoogle(complete_url);
        objSocialShareability.getLinkedInDetails(doc, objcommonseo, complete_url);
        objSocialShareability.getPinterestDetails(doc, objcommonseo, complete_url);
        objSocialShareability.getTwitterDetails(doc, objcommonseo, complete_url);
        objSocialShareability.DisplaySocialShareability();
//****************************HTML VALIDATOR DETAILS**********************************
        System.out.println("  HTML VALIDATOR  ");
        System.out.println("__________________HTML VALIDATOR DETAILS________________");
        objHtmlvalidator.getDetails(doc, objcommonseo, complete_url);
        objHtmlvalidator.disp();

//****************************INDEXED PAGES DETAILS**********************************
        System.out.println("   INDEXED PAGES    ");
        System.out.println("_________________INDEXED PAGES___________________________");
//        objIndexedPages.getDetails(doc, objcommonseo, complete_url);
        objIndexedPages = new IndexedPages(doc, objcommonseo, complete_url);
        objIndexedPages.start();
//        objIndexedPages.disp();

//****************************INDEXED PAGES DETAILS**********************************
//        System.out.println("   BACKLINKS COUNTER    ");
//        System.out.println("_________________BACKLINKS COUNTER___________________________");
//        objBacklinksCounter.getDetails(doc, objcommonseo, complete_url);
        objBacklinksCounter = new BacklinksCounter(doc, objcommonseo, complete_url);
        objBacklinksCounter.start();
        objBacklinksCounter.disp();
        //**************************Twitter Details************************************
        System.out.println("  Twitter Details ");
        System.out.println("__________________TWITTER DETAILS________________");
        objTwitterDetalis = new TwitterDetalis(doc, objcommonseo, complete_url);
        objTwitterDetalis.start();
//        objTwitterDetalis.getDetails(doc, objcommonseo, complete_url);
//        objTwitterDetalis.displaytwt();
        //**************************Pinterest Details************************************
        System.out.println("__________________PINTEREST DETAILS________________");
//        objPinterest = new Pinterest(objcommonseo, complete_url);
//        objPinterest.start();
        objPinterest.setBusinessUrl(objcommonseo, complete_url);

        //**************************Linkedin Details************************************
//        objLinkedin = new Linkedin(objcommonseo, complete_url);
//        objLinkedin.start();
        objLinkedin.setBusinessUrl(objcommonseo, complete_url);

        //**************************Score Value Details************************************
        System.out.println("   SCORE VALUE    ");
        System.out.println("__________________SCORE VALUE________________");
//        objScoreValue.getDetails(doc, objcommonseo, complete_url);
//        objScoreValue.Display();

        //**************************GOOGLE PLUS DETAILS*********************************
        objGoogleplus.setDetails(complete_url);
//        objGoogleplus = new Google_plus(complete_url);
//        objGoogleplus.start();

        System.out.println("[26] Google plus details");
        System.out.println("___________________GOOGLE PLUS DETAILS__________________");

        System.out.println("Google URL : " + objGoogleplus.URL);
        objcommonseo.setGoogleUrl(objGoogleplus.URL);

        System.out.println("Google Name : " + objGoogleplus.Name);
        objcommonseo.setGoogleName(objGoogleplus.Name);

        System.out.println("Google Company_Overview : " + objGoogleplus.Company_Overview);
        objcommonseo.setGoogleOverview(objGoogleplus.Company_Overview);

        System.out.println("Google Image : " + objGoogleplus.Image);
        objcommonseo.setGoogleImage(objGoogleplus.Image);

        System.out.println("Google Follower : " + objGoogleplus.googleFollower);
        objcommonseo.setGoogleFollower(objGoogleplus.googleFollower);

        System.out.println("Google Views : " + objGoogleplus.googleViews);
        objcommonseo.setGoogleViews(objGoogleplus.googleViews);

        System.out.println("Google Introduction : " + objGoogleplus.Introduction);
        objcommonseo.setGoogleIntroduction(objGoogleplus.Introduction);

        System.out.println("Google Verified : " + objGoogleplus.Verified);
        objcommonseo.setGoogleVerified(objGoogleplus.Verified);

        System.out.println("Google Tagline : " + objGoogleplus.Tagline);
        objcommonseo.setGoogleTagline(objGoogleplus.Tagline);

        //*********************VISITOR INFORMATION**************************************
        objVisitorsInfo.setVisitorsDetails(complete_url, objwoorankdao, objVisitorarray);
//        objVisitorsInfo = new VisitorsInfo(complete_url, objwoorankdao);
//        objVisitorsInfo.start();
        System.out.println("[27] Visitors Information");
        System.out.println("___________________VISITOR INFORMATION__________________");

        System.out.println("Global Rank : " + objVisitorsInfo.global_rank);
        objcommonseo.setGlobalRank(objVisitorsInfo.global_rank);

        System.out.println("Country Rank : " + objVisitorsInfo.country_rank);
        objcommonseo.setCountryRank(objVisitorsInfo.country_rank);

        System.out.println("COUNTRY NAME: " + objVisitorsInfo.array_country);
        System.out.println("PERCENTAGE: " + objVisitorsInfo.array_percent);
        System.out.println("RANK: " + objVisitorsInfo.array_Rank);

        //********************************TECHNOLOGIES**********************************
        url_Domain = complete_url.replace("http://", "").replace("https://", "").replace("www.", "");
        System.out.println("URL_Domain :: " + url_Domain);
        objcommonseo.setUrlDomain(url_Domain);

//        objTechUsedAndAnlytics = new TechUsedAndAnlytics(url_Domain, complete_url, objwoorankdao, objTechnology);
//        objTechUsedAndAnlytics.start();
        objTechUsedAndAnlytics.setTechUsed(url_Domain);
        objTechUsedAndAnlytics.setAnalytics(complete_url, objwoorankdao, objTechnology);
        objTechUsedAndAnlytics.print();

        //************************W3CDENCODING CHECKER OF WEBSITE***********************
        objw3cDoctypeEncoding.w3setDetails(complete_url);
//        objw3cDoctypeEncoding = new W3cDoctypeEncoding(complete_url);
//        objw3cDoctypeEncoding.start();

        System.out.println("[29] W3encoding Checker");
        System.out.println("___________________W3CDENCODING CHECKER OF WEBSITE____________________");

        System.out.println("W3CValidity : " + objw3cDoctypeEncoding.W3CValidity);
        objcommonseo.setW3cvalidity(objw3cDoctypeEncoding.W3CValidity);

        System.out.println("Encoding : " + objw3cDoctypeEncoding.Encoding);
        objcommonseo.setEncoding(objw3cDoctypeEncoding.Encoding);

        System.out.println("Doctype : " + objw3cDoctypeEncoding.Doctype);
        objcommonseo.setDoctype(objw3cDoctypeEncoding.Doctype);

        //**********************************SERVERIPLOCATION****************************
        objServerIPLocation.setServerIPLocation(ipaddress, complete_url);

        System.out.println("[30] ServerIplocation");
        System.out.println("___________________SERVER IP LOCATION____________________");

        System.out.println("Flagcode : " + objServerIPLocation.flagCode);
        objcommonseo.setFlagCode(objServerIPLocation.flagCode);

        System.out.println("Location : " + objServerIPLocation.location);
        objcommonseo.setLocat(objServerIPLocation.location);

        System.out.println("Latitude : " + objServerIPLocation.latitude);
        objcommonseo.setLatitude(objServerIPLocation.latitude);
        System.out.println("Longitude : " + objServerIPLocation.longitude);
        objcommonseo.setLongitude(objServerIPLocation.longitude);
        //**************************** Mobile ******************************************

        objmobilerenderingo.saveImage(complete_url);

        objWoorankDropbox.woorankImages(url_Domain, complete_url);

        objcommonseo.setIphoneView(objWoorankDropbox.iphoneView);
        System.out.println("Iphone : " + objWoorankDropbox.iphoneView);

        objcommonseo.setIpadView(objWoorankDropbox.ipadView);
        System.out.println("Ipad : " + objWoorankDropbox.ipadView);

        objcommonseo.setDashboardImage(objWoorankDropbox.dashboardImage);
        System.out.println("Dasboard : " + objWoorankDropbox.dashboardImage);

        objcommonseo.setUsabilityImage(objWoorankDropbox.usabilityImage);
        System.out.println("Usability : " + objWoorankDropbox.usabilityImage);
    }
}
