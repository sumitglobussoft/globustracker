package ranktracker.crawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ranktracker.crawler.alexa.WebRankAlexa;
import ranktracker.crawler.google.GoogleSiteIndexing;
import ranktracker.crawler.google.SeoKeywordDetail;
import ranktracker.crawler.google.pagerank.PRGenerator;
import ranktracker.crawler.seomoz.BacklinksCounter;
import ranktracker.crawler.youtube.YoutubeStatistics;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Socialsignalurls;
import ranktracker.entity.Videokeywords;
import ranktracker.utility.Bing_search;
import ranktracker.utility.Dailymotion_search;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.Google_search;
import ranktracker.utility.Metacafe_search;
import ranktracker.utility.ThreadCreator_signifier;
import ranktracker.utility.Vimeo_search;
import ranktracker.utility.Yahoo_search;
import ranktracker.utility.Youtube_search;

/**
 * Main Class of the package which initiates crawling.
 *
 * @author Anshuman
 */
public class StartCrawler {

    static Logger l = Logger.getLogger(StartCrawler.class.getName());

    /**
     * This method initiates crawling subject to commands from console.
     *
     * @param args
     * @throws java.lang.InterruptedException
     * @throws java.io.IOException
     * @see args[0] values CRA: Crawling every keyword in database GMS: Initiate
     * google monthly searches crawl UPD: Crawler to update keywords table
     * SMALL: (with three arguement )Test crawl similar to CRA but limited to
     * keywordids read from console PROXYTEST: Crawler to test response time of
     * proxies PROXYINSERT: Crawler to insert fresh proxies to database SMALL
     * (with one arguement) : read start keyword id ,end keyword id, start track
     * id and end track id from properties file
     */
    public static void main(String args[]) throws InterruptedException, IOException {

        /**
         * code for command line arguments; Ex java StartCrawler crawler:google
         * client:312 below code identifies the customer and crawler
         *
         * command line arguments are 2 types 1. java StartCrawler
         * crawler:google client:312 2. java StartCrawler all
         *
         * java -jar Crawler.jar crawler:google client:312 java -jar Crawler.jar
         * all
         */
        int clientid;
        String crawlername;
        String tempclient, tempcrawler, temp1[], temp2[];
        //creating application context object,this application context contains all the beans
        //beans are the objects,see line no. 56 and 60 of applicationContext.xml
        ApplicationContext appContext;
        KeywordsDao objKeywordDao;
        List<Serpkeywords> lstKeywords = null;
        List<Videokeywords> lstVideokeywords = new ArrayList<>();
        Set<String> setDomains = new LinkedHashSet<>(0);

        if (args.length > 1) {
            temp1 = args[0].split(":");
            tempcrawler = temp1[0];
            temp2 = args[1].split(":");
            tempclient = temp2[0];
            if (tempcrawler.equalsIgnoreCase("crawler")) {
                crawlername = temp1[1];
                clientid = Integer.parseInt(temp2[1]);
            } else {
                crawlername = temp2[1];
                clientid = Integer.parseInt(temp1[1]);
            }
            System.out.println("Clientid = " + clientid);
            System.out.println("Crawler = " + crawlername);

            appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
            FetchPagewithClientAthentication fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);

            //for checking site is down or not for paricular client id as given
            List<String> urlList = objKeywordDao.getUrlList(clientid);
//            ---------*b
//            for (String checkUrl : urlList) {
//                try {
//                    String str = "http://www." + checkUrl;
//                    URL url = new URL(str);
//                    System.out.println("url = " + url);
//
//                    String host = url.getHost();
//                    System.out.println("host = " + host);
//
//                    String clientemail = objKeywordDao.getClientEmailId(clientid);
//                    System.out.println("clientemail = " + clientemail);
//
//                    fetchclientpage.fetchPageForCheckingIfSiteDown(host, clientemail);
//                } catch (Exception ex) {
//                    java.util.logging.Logger.getLogger(StartCrawler.class.getName()).log(Level.SEVERE, null, ex);
//                    ex.printStackTrace();
//                }
//            }
//             ---------*b

            //loading the log4j.properties file for logging 
//            InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
//            Properties props = new Properties();
//            props.load(inStream);
//            PropertyConfigurator.configure(props);
            //test cgnage
            Integer sKeywordID = null;
            Integer eKeywordID = null;
            //List<Keywords> lstKeywords = null;
            try {
                // this code is used by signifier crawler

                int c = 0;
                System.out.println("------------------------------------");
                if (crawlername.equalsIgnoreCase("youtube") || crawlername.equalsIgnoreCase("vimeo") || crawlername.equalsIgnoreCase("dailymotion") || crawlername.equalsIgnoreCase("metacafe") || crawlername.equalsIgnoreCase("youtubecounts")) {
                    lstVideokeywords = objKeywordDao.getCustomerVideoKeywords(clientid);
                } else {
                    lstKeywords = objKeywordDao.getCustomerKeywords(clientid);
                    Iterator itr = lstKeywords.iterator();
                    while (itr.hasNext()) {
                        Serpkeywords keywrds = (Serpkeywords) itr.next();
                        //set of all the url; url for the specified keyword
                        //System.out.println("KeywordId : "+keywrds.getKeywordId());
                        setDomains.add(keywrds.getUrl().trim());
                    }
                }

                // signifier crawler code starts
                if (crawlername.equalsIgnoreCase("facebook") || crawlername.equalsIgnoreCase("google+")
                        || crawlername.equalsIgnoreCase("linkedin") || crawlername.equalsIgnoreCase("pinterest")
                        || crawlername.equalsIgnoreCase("reddit") || crawlername.equalsIgnoreCase("stumble")
                        || crawlername.equalsIgnoreCase("twitter")) {
                    System.out.println("-------------Social---------------");
//                    Thread tsignifier = new Thread(new ThreadCreator_signifier(crawlername, setDomains, lstKeywords, appContext));
//                    tsignifier.start();
//                    tsignifier.join();
                    // signifier crawler code ends
                }
                if (crawlername.equalsIgnoreCase("seomoz")) {
                    System.out.println("---------------moz----------------");
                    Thread tBacklinksCounter = new Thread(new BacklinksCounter(setDomains, lstKeywords, appContext));
                    tBacklinksCounter.start();
                    tBacklinksCounter.join();
                }

                if (crawlername.equalsIgnoreCase("alexa")) {
                    Thread tWebRankAlexa = new Thread(new WebRankAlexa(setDomains, lstKeywords, appContext));
                    tWebRankAlexa.start();
                    tWebRankAlexa.join();
                }

                if (crawlername.equalsIgnoreCase("siteindex")) {
                    Thread tGoogleSiteIndex = new Thread(new GoogleSiteIndexing(lstKeywords, appContext));
                    tGoogleSiteIndex.start();
                    tGoogleSiteIndex.join();
                }

                if (crawlername.equalsIgnoreCase("seodetail")) {
                    Thread SeoKeywordDetail = new Thread(new SeoKeywordDetail(lstKeywords, appContext));
                    SeoKeywordDetail.start();
                    SeoKeywordDetail.join();
                }
                // this code is used by yahoo/bing/ GMS Backlinks and misc crawlers
                if (crawlername.equalsIgnoreCase("yahoo")) {
                    Thread yahoosearch = new Thread(new Yahoo_search(appContext, lstKeywords));
                    yahoosearch.start();
                    yahoosearch.join();
                    // new Thread(new ThreadCreator_yahoobing(sKeywordID, eKeywordID, setDomains, lstKeywords, appContext)).start();crawlername.equalsIgnoreCase("bing")
                }
                if (crawlername.equalsIgnoreCase("bing")) {
                    Thread bingsearch = new Thread(new Bing_search(appContext, lstKeywords));
                    bingsearch.start();
                    bingsearch.join();
                }
                // yahoo/bing/ GMS Backlinks and misc crawlers code ends

                if (crawlername.equalsIgnoreCase("google")) {
                    // this code is used by google crawler  
                    Thread searchgoogle = new Thread(new Google_search(appContext, lstKeywords));
                    searchgoogle.start();
                    searchgoogle.join();

                    // google crawler code ends     
                } else if (crawlername.equalsIgnoreCase("youtube")) {

                    // This code is used by youtube crawler
                    Thread youtubesearch = new Thread(new Youtube_search(lstVideokeywords, appContext));
                    youtubesearch.start();
                    youtubesearch.join();

                    // youtube crawler ends
                } else if (crawlername.equalsIgnoreCase("youtubecounts")) {

                    // This code is used by youtube statistics crawler
                    Thread countsearch = new Thread(new YoutubeStatistics(lstVideokeywords, appContext));
                    countsearch.start();
                    countsearch.join();
//            Thread ThreadCreator_Video = new Thread(new ThreadCreator_Youtube(  setDomains, lstKeywords, appContext));
//            ThreadCreator_Video.start();
//            ThreadCreator_Video.join();
                    // youtube statistics crawler ends
                } else if (crawlername.equalsIgnoreCase("vimeo")) {
                    // This code is used by Vimeo crawler
                    Thread vimeosearch = new Thread(new Vimeo_search(lstVideokeywords, appContext));
                    vimeosearch.start();
                    vimeosearch.join();

                    // Vimeo crawler ends
                } else if (crawlername.equalsIgnoreCase("metacafe")) {
                    //This code is used by Metacafe crawler
                    Thread metacafesearch = new Thread(new Metacafe_search(lstVideokeywords, appContext));
                    metacafesearch.start();
                    metacafesearch.join();

                    //Metacafe crawler ends
                } else if (crawlername.equalsIgnoreCase("dailymotion")) {
                    //This code is used by DailyMotion crawler
                    Thread dailymotionsearch = new Thread(new Dailymotion_search(lstVideokeywords, appContext));
                    dailymotionsearch.start();
                    dailymotionsearch.join();

                    //DailyMotion crawler ends 
                }
            } catch (Exception e) {
                e.printStackTrace();
                l.debug(e.getMessage() + "  " + e.getMessage());
                showOption();
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("all")) {

            appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
            FetchPagewithClientAthentication fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);

            InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
            Properties props = new Properties();
            props.load(inStream);
            PropertyConfigurator.configure(props);

            List<Campaigns> lstCampaigns = objKeywordDao.getCampaignsList();
            Iterator campitr = lstCampaigns.iterator();
            while (campitr.hasNext()) {
                Campaigns campaigns = (Campaigns) campitr.next();
                Integer customerid = campaigns.getCustomerID().getCustomerID().intValue();
                System.out.println("--------------------");
                System.out.println("customerid = " + customerid);

                //for checking site is down or not ,each time,for  paricular customer id enlisted from all
                List<String> urlList = objKeywordDao.getUrlList(customerid);
                for (String checkUrl : urlList) {
                    String str = "http://www." + checkUrl;
                    URL url = new URL(str);
                    String host = url.getHost();
                    try {
                        String clientemail = objKeywordDao.getClientEmailId(customerid);
                        fetchclientpage.fetchPageForCheckingIfSiteDown(host, clientemail);
                    } catch (Exception ex) {
                        java.util.logging.Logger.getLogger(StartCrawler.class.getName()).log(Level.SEVERE, null, ex);
                        ex.printStackTrace();
                    }
                }

                lstKeywords = objKeywordDao.getCustomerKeywords(customerid);
                Iterator ittr = lstKeywords.iterator();
                while (ittr.hasNext()) {
                    Serpkeywords keywrds = (Serpkeywords) ittr.next();
                    //set of all the url; url for the specified keyword
                    setDomains.add(keywrds.getUrl().trim());
                }

                if (!lstKeywords.isEmpty()) {

//                    Thread tsignifier = new Thread(new ThreadCreator_signifier("all", setDomains, lstKeywords, appContext));
//                    tsignifier.start();
//                    tsignifier.join();
                    Thread.sleep(500);

                    Thread searchgoogle = new Thread(new Google_search(appContext, lstKeywords));
                    searchgoogle.start();
                    searchgoogle.join();

                    Thread yahoosearch = new Thread(new Yahoo_search(appContext, lstKeywords));
                    yahoosearch.start();
                    yahoosearch.join();

                    Thread bingsearch = new Thread(new Bing_search(appContext, lstKeywords));
                    bingsearch.start();
                    bingsearch.join();

                    Thread tBacklinksCounter = new Thread(new BacklinksCounter(setDomains, lstKeywords, appContext));
                    tBacklinksCounter.start();
                    tBacklinksCounter.join();

                    Thread tWebRankAlexa = new Thread(new WebRankAlexa(setDomains, lstKeywords, appContext));
                    tWebRankAlexa.start();
                    tWebRankAlexa.join();

                    Thread tGoogleSiteIndex = new Thread(new GoogleSiteIndexing(lstKeywords, appContext));
                    tGoogleSiteIndex.start();
                    tGoogleSiteIndex.join();

                }
                lstVideokeywords = objKeywordDao.getCustomerVideoKeywords(campaigns.getCustomerID().getCustomerID());
                Iterator itr = lstVideokeywords.iterator();
                while (itr.hasNext()) {
                    Videokeywords vk = (Videokeywords) itr.next();
                    System.out.println("keys : " + vk.getVideoKeyword());
                }
                if (!(lstVideokeywords.isEmpty())) {

                    Thread youtubesearch = new Thread(new Youtube_search(lstVideokeywords, appContext));
                    youtubesearch.start();
                    youtubesearch.join();
//
                    Thread dailymotionsearch = new Thread(new Dailymotion_search(lstVideokeywords, appContext));
                    dailymotionsearch.start();
                    dailymotionsearch.join();

                    Thread metacafesearch = new Thread(new Metacafe_search(lstVideokeywords, appContext));
                    metacafesearch.start();
                    metacafesearch.join();
//
                    Thread vimeosearch = new Thread(new Vimeo_search(lstVideokeywords, appContext));
                    vimeosearch.start();
                    vimeosearch.join();
                }

            }

        } else if (args.length == 1 && args[0].equalsIgnoreCase("google")) {
            System.out.println("-------------Google CRAWLER START-------------");

            appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);

            InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
            Properties props = new Properties();
            props.load(inStream);
            PropertyConfigurator.configure(props);

            List<Campaigns> lstCampaigns = objKeywordDao.getCampaignsList();
            Stack<Campaigns> lstCampaignsStack = new Stack<>();
            for (Campaigns campaignslst : lstCampaigns) {
                lstCampaignsStack.push(campaignslst);
            }

//          Iterator campitr = lstCampaigns.iterator();
            int campcount = lstCampaigns.size() / 2;
            int ccount = 0;
//           Iterator campitr = lstCampaigns.iterator();
            while (!lstCampaignsStack.empty()) {
//            while(campitr.hasNext()){               
                Campaigns campaigns = lstCampaignsStack.pop();
//                Campaigns campaigns = (Campaigns) campitr.next();

//                if (ccount > campcount) {
//                    break;
//                }
                ccount++;
//                Campaigns campaigns = (Campaigns)campitr.next();
                List<Serpkeywords> lstkeywordses = new ArrayList<>();
                int campaignid = campaigns.getCampaignID();
                lstkeywordses = objKeywordDao.getCampaignKeywords(campaignid);  //1
                System.out.println("total keywords" + lstkeywordses.size());
                System.out.println("---> " + campaigns.getCampaign());
//                Iterator lstitr = lstkeywordses.iterator();                   //Bala Changes 1
//                while (lstitr.hasNext()) {                                    //Bala Changes 2 
//                    Serpkeywords serpkeys = (Serpkeywords) lstitr.next();     //Bala Changes 3 
//                    System.out.println("--------" + serpkeys.getKeyword());   //Bala Changes 4
//                }                                                             //Bala Changes 5
                Integer customerid = campaigns.getCustomerID().getCustomerID();
                System.out.println("-------------> customerid = " + customerid);

                if (!lstkeywordses.isEmpty()) {
                    Thread searchgoogle = new Thread(new Google_search(appContext, lstkeywordses));
                    searchgoogle.start();
                    searchgoogle.join();

                    Thread searchgooglepr = new Thread(new PRGenerator(lstkeywordses, appContext));
                    searchgooglepr.start();
                    searchgooglepr.join();

                }
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("yahoo")) {
            System.out.println("-------YAHOO CRAWLER START-------------");
            appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
            //FetchPagewithClientAthentication fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);

            InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
            Properties props = new Properties();
            props.load(inStream);
            PropertyConfigurator.configure(props);

            List<Campaigns> lstCampaigns = objKeywordDao.getCampaignsList();
            Stack<Campaigns> lstCampaignsStack = new Stack<>();
            for (Campaigns campaignslst : lstCampaigns) {
                lstCampaignsStack.push(campaignslst);
            }
            System.out.println("no of campaign" + lstCampaignsStack.size());
//                      Iterator campitr = lstCampaigns.iterator();
//
            while (!lstCampaignsStack.empty()) {
//               while (campitr.hasNext()) {
                Campaigns campaigns = lstCampaignsStack.pop();
//                Campaigns campaigns = (Campaigns) campitr.next();
                List<Serpkeywords> lstkeywordses = new ArrayList<>();
                int campaignid = campaigns.getCampaignID();
                System.out.println(campaignid + campaigns.getCampaign());
//                int i=0;  //1
//                while(i>=0){ //2
                lstkeywordses = objKeywordDao.getCampaignKeywords(campaignid);

                if (!lstkeywordses.isEmpty()) {

                    Thread yahoosearch = new Thread(new Yahoo_search(appContext, lstkeywordses));
                    yahoosearch.start();
                    yahoosearch.join();
//                    i=i+5; //3
                }
//                else{i=-1;}  //4
//                if(lstkeywordses.size()<=100){i=-1;}  //5
//                
//                }  //6
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("bing")) {
            System.out.println("~~~~~~BING CRAWLER~~~~~~");
            appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
            //     FetchPagewithClientAthentication fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);

            InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
            Properties props = new Properties();
            props.load(inStream);
            PropertyConfigurator.configure(props);

            List<Campaigns> lstCampaigns = objKeywordDao.getCampaignsList();

            Stack<Campaigns> lstCampaignsStack = new Stack<>();
            for (Campaigns campaignslst : lstCampaigns) {
                lstCampaignsStack.push(campaignslst);
            }
//            Iterator campitr = lstCampaigns.iterator();

            while (!lstCampaignsStack.empty()) {
//            while (campitr.hasNext()) {
                Campaigns campaigns = lstCampaignsStack.pop();
//                Campaigns campaigns = (Campaigns) campitr.next();
                List<Serpkeywords> lstkeywordses = new ArrayList<>();
                int campaignid = campaigns.getCampaignID();
                lstkeywordses = objKeywordDao.getCampaignKeywords(campaignid); //2
                Iterator lstitr = lstkeywordses.iterator();
                while (lstitr.hasNext()) {
                    Serpkeywords serpkeys = (Serpkeywords) lstitr.next();
                    System.out.println("--------" + serpkeys.getKeyword());
                }
                Integer customerid = campaigns.getCustomerID().getCustomerID().intValue();
                System.out.println("-------------customerid = " + customerid);

                //for checking site is down or not ,each time,for  paricular customer id enlisted from all
//                List<String> urlList = objKeywordDao.getUrlList(customerid);
//                for (String checkUrl : urlList) {
//                    String str = "http://www." + checkUrl;
//                    URL url = new URL(str);
//                    String host = url.getHost();
//                    try {
//                        String clientemail = objKeywordDao.getClientEmailId(customerid);
//                        fetchclientpage.fetchPageForCheckingIfSiteDown(host, clientemail);
//                    } catch (Exception ex) {
//                        java.util.logging.Logger.getLogger(StartCrawler.class.getName()).log(Level.SEVERE, null, ex);
//                        ex.printStackTrace();
//                    }
//                }
                if (!lstkeywordses.isEmpty()) {
                    Thread bingsearch = new Thread(new Bing_search(appContext, lstkeywordses));
                    bingsearch.start();
                    bingsearch.join();

                }
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("seo")) {
            System.out.println("------------seo start---------------------");
            appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
            FetchPagewithClientAthentication fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);

            InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
            Properties props = new Properties();
            props.load(inStream);
            PropertyConfigurator.configure(props);

            List<Campaigns> lstCampaigns = objKeywordDao.getCampaignsList();
            Stack<Campaigns> lstCampaignsStack = new Stack<>();
            for (Campaigns campaignslst : lstCampaigns) {
                lstCampaignsStack.push(campaignslst);
            }
            while (!lstCampaignsStack.empty()) {
                Campaigns campaigns = lstCampaignsStack.pop();
                List<Serpkeywords> lstkeywordses = new ArrayList<>();
                int campaignid = campaigns.getCampaignID();
                lstkeywordses = objKeywordDao.getCampaignKeywords(campaignid);  //3
                Integer customerid = campaigns.getCustomerID().getCustomerID().intValue();
                System.out.println("customerid = " + customerid);

                // for checking site is down or not ,each time,for  paricular customer id enlisted from all
                Iterator itr = lstkeywordses.iterator();
                while (itr.hasNext()) {
                    Serpkeywords keywrds = (Serpkeywords) itr.next();
                    //set of all the url; url for the specified keyword
                    //System.out.println("KeywordId : "+keywrds.getKeywordId());
                    setDomains.add(keywrds.getUrl().trim());
                }

                if (!lstkeywordses.isEmpty()) {
//                    Thread tsignifier = new Thread(new ThreadCreator_signifier("all", setDomains, lstkeywordses, appContext));
//                    tsignifier.start();
//                    tsignifier.join();

                    Thread SeoKeywordDetail = new Thread(new SeoKeywordDetail(lstkeywordses, appContext));
                    SeoKeywordDetail.start();
                    SeoKeywordDetail.join();

                    Thread tBacklinksCounter = new Thread(new BacklinksCounter(setDomains, lstkeywordses, appContext));
                    tBacklinksCounter.start();
                    tBacklinksCounter.join();

                    Thread tWebRankAlexa = new Thread(new WebRankAlexa(setDomains, lstkeywordses, appContext));
                    tWebRankAlexa.start();
                    tWebRankAlexa.join();

                    Thread tGoogleSiteIndex = new Thread(new GoogleSiteIndexing(lstkeywordses, appContext));
                    tGoogleSiteIndex.start();
                    tGoogleSiteIndex.join();

                }
//      <**** Commented B ****>
//                List<String> urlList = objKeywordDao.getUrlList(customerid);
//                for (String checkUrl : urlList) {
//                    String str = "http://www." + checkUrl;
//                    URL url = new URL(str);
//                    String host = url.getHost();
//                    try {
//                        String clientemail = objKeywordDao.getClientEmailId(customerid);
//                        fetchclientpage.fetchPageForCheckingIfSiteDown(host, clientemail);
//                    } catch (Exception ex) {
//                        java.util.logging.Logger.getLogger(StartCrawler.class.getName()).log(Level.SEVERE, null, ex);
//                        ex.printStackTrace();
//                    }
//                }

            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("videocrawlers")) {
            System.out.println("---------------Video Crawler Start------------");

            appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);

            List<Campaigns> lstCampaigns = objKeywordDao.getCampaignsList();
            Stack<Campaigns> lstCampaignsStack = new Stack<>();
            for (Campaigns campaignslst : lstCampaigns) {
                if (campaignslst.getCampaignType().equalsIgnoreCase("video")) {
                    lstCampaignsStack.push(campaignslst);
                }
            }
            ExecutorService executor = Executors.newFixedThreadPool(4);
            while (!lstCampaignsStack.empty()) {
                Campaigns campaign = lstCampaignsStack.pop();
                List<Videokeywords> lstVideokey = new ArrayList<>();
                Integer campaignid = campaign.getCampaignID().intValue();
                System.out.println("campaignid =============== " + campaignid);
                lstVideokey = objKeywordDao.getVideoKeywords(campaignid);
                Iterator lstitr = lstVideokey.iterator();
                while (lstitr.hasNext()) {
                    Videokeywords keys = (Videokeywords) lstitr.next();
                    System.out.println("--------" + keys.getVideoKeyword());
                }

                Runnable worker1 = new Youtube_search(lstVideokey, appContext);
                executor.execute(worker1);

                Runnable worker2 = new YoutubeStatistics(lstVideokey, appContext);
                executor.execute(worker2);

                Runnable worker3 = new Dailymotion_search(lstVideokey, appContext);
                executor.execute(worker3);

                Runnable worker4 = new Vimeo_search(lstVideokey, appContext);
                executor.execute(worker4);

                Runnable worker5 = new Metacafe_search(lstVideokey, appContext);
                executor.execute(worker5);

//                Thread youtubes = new Thread(new Youtube_search(lstVideokey, appContext));
//                youtubes.start();
//                youtubes.join();
//                System.out.println("-------------------------------------");
//
//                Thread countsearch = new Thread(new YoutubeStatistics(lstVideokey, appContext));
//                countsearch.start();
//                countsearch.join();
//
//                Thread dailymotionsearch = new Thread(new Dailymotion_search(lstVideokey, appContext));
//                dailymotionsearch.start();
//                dailymotionsearch.join();
//
//                Thread vimeosearch = new Thread(new Vimeo_search(lstVideokey, appContext));
//                vimeosearch.start();
//                vimeosearch.join();
            }
            executor.shutdown();
            try {
                executor.awaitTermination(10, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(Google_search.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("social")) {
            System.out.println("---------------Social Crawler Start------------");
            appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
            //     FetchPagewithClientAthentication fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);

            InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
            Properties props = new Properties();
            props.load(inStream);
            PropertyConfigurator.configure(props);

            List<Campaigns> lstCampaigns = objKeywordDao.getCampaignsList();

            Stack<Campaigns> lstCampaignsStack = new Stack<>();
            for (Campaigns campaignslst : lstCampaigns) {
                lstCampaignsStack.push(campaignslst);
            }
            Iterator campitr = lstCampaigns.iterator();
            int campaigncount = lstCampaignsStack.size() / 2;
            int cnt = 0;
            while (!lstCampaignsStack.empty()) {
//           while (campitr.hasNext()) {
                Campaigns campaigns = lstCampaignsStack.pop();
//                Campaigns campaigns = (Campaigns) campitr.next();
//                if (cnt > campaigncount) {
//                    break;
//                }
                cnt++;
                List<Socialsignalurls> lstsocialsignalurls = new ArrayList<>();
                lstsocialsignalurls.addAll(campaigns.getSocialsignalurlsCollection());
                Iterator lstitr = lstsocialsignalurls.iterator();

                while (lstitr.hasNext()) {
                    Socialsignalurls ssurls = (Socialsignalurls) lstitr.next();
                    System.out.println("--------" + ssurls.getSocialSignalUrl());
                }
                Integer customerid = campaigns.getCustomerID().getCustomerID().intValue();
                System.out.println("-------------customerid = " + customerid);

                if (!lstsocialsignalurls.isEmpty()) {
                    Thread tsignifier = new Thread(new ThreadCreator_signifier("all", lstsocialsignalurls, appContext));
                    tsignifier.start();
                    tsignifier.join();

                }
            }
        } else if (args.length == 1 && args[0].equalsIgnoreCase("newkeywords")) {
            System.out.println("---------------Latest entry crawler Start------------");
            appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
            objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
            //     FetchPagewithClientAthentication fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
            List<Serpkeywords> lstnewserpkeywords = new ArrayList<>();
            List<Videokeywords> lstnewvideokeywords = new ArrayList<>();

            InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
            Properties props = new Properties();
            props.load(inStream);
            PropertyConfigurator.configure(props);

            List<Serpkeywords> newserplst = objKeywordDao.getNewSerpList();

            List<Videokeywords> newvideolst = objKeywordDao.getNewVideoList();

            Iterator lstitr = newserplst.iterator();
            while (lstitr.hasNext()) {
                Serpkeywords newone = (Serpkeywords) lstitr.next();
                if (newone.getVisibility() == 1) {
                    lstnewserpkeywords.add(newone);
                }

            }
            System.out.println("---------------new serp keywords------------" + lstnewserpkeywords.size());
//            Iterator lstitr2 = newvideolst.iterator();
//            while (lstitr.hasNext()) {
//                Videokeywords newone = (Videokeywords) lstitr.next();
//                if (newone.getVisibility() == 1) {
//                    lstnewvideokeywords.add(newone);
//                }
//
//            }
            ExecutorService executor = Executors.newFixedThreadPool(4);
            System.out.println("---------------new Video keywords------------" + lstnewvideokeywords.size());
            if (!lstnewserpkeywords.isEmpty()) {

                Thread searchgoogle = new Thread(new Google_search(appContext, lstnewserpkeywords));
                searchgoogle.start();
                searchgoogle.join();

                Thread yahoosearch = new Thread(new Yahoo_search(appContext, lstnewserpkeywords));
                yahoosearch.start();
                yahoosearch.join();

                Thread bingsearch = new Thread(new Bing_search(appContext, lstnewserpkeywords));
                bingsearch.start();
                bingsearch.join();
            }

//            if (!lstnewvideokeywords.isEmpty()) {
//
//                Runnable worker1 = new Youtube_search(lstnewvideokeywords, appContext);
//                executor.execute(worker1);
//
//                Runnable worker2 = new YoutubeStatistics(lstnewvideokeywords, appContext);
//                executor.execute(worker2);
//
//                Runnable worker3 = new Dailymotion_search(lstnewvideokeywords, appContext);
//                executor.execute(worker3);
//
//                Runnable worker4 = new Vimeo_search(lstnewvideokeywords, appContext);
//                executor.execute(worker4);
//            }
        } else {
            showOption();
        }
    }

    public static void showOption() {
        System.out.println("Please follow the following command:\njava -jar [jarfile] client:[option1] crawler:[option2] \n");
        System.out.println("where [option1] may:");
        System.out.println("\t 1.  For Client               Client  ID only(Integer Only)");
        System.out.println("where [option2] may:");
        System.out.println("\t 2.  Crawler                  Name of crawler (String Only) ");
        System.out.println("\t 3.  All                      Calls all the clients for all the crawlers ");
//        System.out.println("\t                              (Bing,Yahoo/Yahooca,Yelp/yelpca,Yellowpages/yellowpagesca,");
//        System.out.println("\t                              Google,Yellowbook,GoogleBlog,Citysearch,FourSquare,");
//        System.out.println("\t                              Insiderpages,Twitter,Facebook,SuperPages,TripAdvisor)");

    }
}
