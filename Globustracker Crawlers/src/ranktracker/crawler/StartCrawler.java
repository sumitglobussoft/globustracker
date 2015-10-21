package ranktracker.crawler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.apache.http.client.utils.URIBuilder;
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
import ranktracker.dao.WoorankDao;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Commonseo;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Socialsignalurls;
import ranktracker.entity.Videokeywords;
import ranktracker.utility.Bing_search;
import ranktracker.utility.Dailymotion_search;
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
	 * @see args[0] values CRA: Crawling every keyword in database GMS: Initiate google monthly searches crawl UPD:
	 * Crawler to update keywords table SMALL: (with three arguement )Test crawl similar to CRA but limited to
	 * keywordids read from console PROXYTEST: Crawler to test response time of proxies PROXYINSERT: Crawler to insert
	 * fresh proxies to database SMALL (with one arguement) : read start keyword id ,end keyword id, start track id and
	 * end track id from properties file
	 */
	public static void main(String args[]) throws InterruptedException, IOException {

		/**
		 * code for command line arguments; Ex: java StartCrawler crawler:google client:312 below code identifies the
		 * customer and crawler
		 *
		 * command line arguments are 2 types 1. java StartCrawler crawler:google client:312 2. java StartCrawler
		 * crawlername
		 *
		 * java -jar Crawler.jar crawler:google client:312 java -jar Crawler.jar google
		 */
		int clientid;
		String crawlername;
		String tempcrawler, temp1[], temp2[];
		//creating application context object,this application context contains all the beans
		//beans are the objects,see line no. 56 and 60 of applicationContext.xml
		ApplicationContext appContext;
		KeywordsDao objKeywordDao;
		WoorankDao objWoorankDao;
		List<Serpkeywords> lstKeywords = null;
		List<Videokeywords> lstVideokeywords = new ArrayList<>();
		Set<String> setDomains = new LinkedHashSet<>(0);

		if (args.length == 2) {
			temp1 = args[0].split(":");
			tempcrawler = temp1[0];
			temp2 = args[1].split(":");
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

			try {
				// this code is used by signifier crawler

				System.out.println("------------------------------------");
				if (crawlername.equalsIgnoreCase("youtube") || crawlername.equalsIgnoreCase("vimeo") || crawlername.equalsIgnoreCase("dailymotion") || crawlername.equalsIgnoreCase("metacafe") || crawlername.equalsIgnoreCase("youtubecounts")) {
					lstVideokeywords = objKeywordDao.getCustomerVideoKeywords(clientid);
				} else if (crawlername.equalsIgnoreCase("google")) {
					lstKeywords = objKeywordDao.getCustomerKeywords(clientid);
					Iterator itr = lstKeywords.iterator();
					while (itr.hasNext()) {
						Serpkeywords keywrds = (Serpkeywords) itr.next();
						//set of all the url; url for the specified keyword
						//System.out.println("KeywordId : "+keywrds.getKeywordId());
						setDomains.add(keywrds.getUrl().trim());
					}
				} else {
					lstKeywords = objKeywordDao.getCustomerKeywordsForAll(clientid);
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
				if (crawlername.equalsIgnoreCase("yahoo")) {
					Thread yahoosearch = new Thread(new Yahoo_search(appContext, lstKeywords));
					yahoosearch.start();
					yahoosearch.join();
				}
				if (crawlername.equalsIgnoreCase("bing")) {
					Thread bingsearch = new Thread(new Bing_search(appContext, lstKeywords));
					bingsearch.start();
					bingsearch.join();
				}
				if (crawlername.equalsIgnoreCase("google")) {
					Thread searchgoogle = new Thread(new Google_search(appContext, lstKeywords));
					searchgoogle.start();
					searchgoogle.join();   
				} else if (crawlername.equalsIgnoreCase("youtube")) {
					Thread youtubesearch = new Thread(new Youtube_search(lstVideokeywords, appContext));
					youtubesearch.start();
					youtubesearch.join();
				} else if (crawlername.equalsIgnoreCase("youtubecounts")) {
					Thread countsearch = new Thread(new YoutubeStatistics(lstVideokeywords, appContext));
					countsearch.start();
					countsearch.join();
				} else if (crawlername.equalsIgnoreCase("vimeo")) {				
					Thread vimeosearch = new Thread(new Vimeo_search(lstVideokeywords, appContext));
					vimeosearch.start();
					vimeosearch.join();
				} else if (crawlername.equalsIgnoreCase("metacafe")) {					
					Thread metacafesearch = new Thread(new Metacafe_search(lstVideokeywords, appContext));
					metacafesearch.start();
					metacafesearch.join();
				} else if (crawlername.equalsIgnoreCase("dailymotion")) {
					Thread dailymotionsearch = new Thread(new Dailymotion_search(lstVideokeywords, appContext));
					dailymotionsearch.start();
					dailymotionsearch.join();
				}
			} catch (Exception e) {
				e.printStackTrace();
				l.debug(e.getMessage() + "  " + e.getMessage());
				showOption();
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

			while (!lstCampaignsStack.empty()) {
				Campaigns campaigns = lstCampaignsStack.pop();
				List<Serpkeywords> lstkeywordses = new ArrayList<>();
				int campaignid = campaigns.getCampaignID();
				lstkeywordses = objKeywordDao.getCampaignKeywords(campaignid);
				System.out.println("total keywords" + lstkeywordses.size());
				System.out.println("---> " + campaigns.getCampaign());
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
		} else if (args.length == 1 && args[0].equalsIgnoreCase("woorank")) {
			System.out.println("------------WOORANK CRAWLER SYSTEM------------------");
			appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
			objWoorankDao = appContext.getBean("objWoorankDao", WoorankDao.class);

			InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
			Properties props = new Properties();
			props.load(inStream);
			PropertyConfigurator.configure(props);

			List<Commonseo> lstCommonseo = new ArrayList<>();
			lstCommonseo = objKeywordDao.getAllCommonseoUrls();
			for (Commonseo commonseo : lstCommonseo) {
				System.out.println("    -- newuri = " + commonseo.getUrlDomain());
				try {
					URI newuri = new URIBuilder()
							.setScheme("http")
							.setHost("IPAddress")
							.setPath("/Globuswooclonecrawler/Reviewsite")
							.setParameter("websitename", commonseo.getUrlDomain())
							.build();
					objWoorankDao.fetchXMLContent(newuri);
				} catch (URISyntaxException ex) {
					java.util.logging.Logger.getLogger(StartCrawler.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

		} else if (args.length == 1 && args[0].equalsIgnoreCase("yahoo")) {
			System.out.println("-------YAHOO CRAWLER START-------------");
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
			System.out.println("no of campaign" + lstCampaignsStack.size());
            
			while (!lstCampaignsStack.empty()) {
				Campaigns campaigns = lstCampaignsStack.pop();
				List<Serpkeywords> lstkeywordses = new ArrayList<>();
				int campaignid = campaigns.getCampaignID();
				System.out.println(campaignid + campaigns.getCampaign());
				lstkeywordses = objKeywordDao.getCampaignKeywordsForAll(campaignid);

				if (!lstkeywordses.isEmpty()) {
					Thread yahoosearch = new Thread(new Yahoo_search(appContext, lstkeywordses));
					yahoosearch.start();
					yahoosearch.join();
				}
			}
		} else if (args.length == 1 && args[0].equalsIgnoreCase("bing")) {
			System.out.println("~~~~~~BING CRAWLER~~~~~~");
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

			while (!lstCampaignsStack.empty()) {
				Campaigns campaigns = lstCampaignsStack.pop();
				List<Serpkeywords> lstkeywordses = new ArrayList<>();
				int campaignid = campaigns.getCampaignID();
				lstkeywordses = objKeywordDao.getCampaignKeywordsForAll(campaignid); 
				for (Serpkeywords serpkeys : lstkeywordses) {
					System.out.println("--------" + serpkeys.getKeyword());
				}
				Integer customerid = campaigns.getCustomerID().getCustomerID();
				System.out.println("-------------customerid = " + customerid);

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
				lstkeywordses = objKeywordDao.getCampaignKeywordsForAll(campaignid);  //3
				Integer customerid = campaigns.getCustomerID().getCustomerID();
				System.out.println("customerid = " + customerid);

				for (Serpkeywords keywrds : lstkeywordses) {					
					setDomains.add(keywrds.getUrl().trim());
				}

				if (!lstkeywordses.isEmpty()) {
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
				Integer campaignid = campaign.getCampaignID();
				System.out.println("campaignid =============== " + campaignid);
				lstVideokey = objKeywordDao.getVideoKeywords(campaignid);
				for (Videokeywords keys : lstVideokey) {
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
				List<Socialsignalurls> lstsocialsignalurls = new ArrayList<>();
				lstsocialsignalurls.addAll(campaigns.getSocialsignalurlsCollection());
				for (Socialsignalurls ssurls : lstsocialsignalurls) {
					System.out.println("--------" + ssurls.getSocialSignalUrl());
				}
				Integer customerid = campaigns.getCustomerID().getCustomerID();
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

			InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
			Properties props = new Properties();
			props.load(inStream);
			PropertyConfigurator.configure(props);

			List<Serpkeywords> newserplst = objKeywordDao.getNewSerpList();

			List<Videokeywords> newvideolst = objKeywordDao.getNewVideoList();
			
			System.out.println("---------------new serp keywords------------" + newserplst.size());
			System.out.println("---------------new Video keywords------------" + newvideolst.size());

			if (!newserplst.isEmpty()) {
				Thread searchgoogle = new Thread(new Google_search(appContext, newserplst));
				searchgoogle.start();
				searchgoogle.join();
			}

			newserplst.clear();
			newserplst = objKeywordDao.getNewSerpListForAll();
           
			if (!newserplst.isEmpty()) {
				Thread yahoosearch = new Thread(new Yahoo_search(appContext, newserplst));
				yahoosearch.start();
				yahoosearch.join();

				Thread bingsearch = new Thread(new Bing_search(appContext, newserplst));
				bingsearch.start();
				bingsearch.join();
			}  
			System.out.println("---------------new Video keywords------------" + newvideolst.size());

			ExecutorService executor = Executors.newFixedThreadPool(5);
			if (!newvideolst.isEmpty()) {

				Runnable worker1 = new Youtube_search(newvideolst, appContext);
				executor.execute(worker1);

				Runnable worker2 = new YoutubeStatistics(newvideolst, appContext);
				executor.execute(worker2);

				Runnable worker3 = new Dailymotion_search(newvideolst, appContext);
				executor.execute(worker3);

				Runnable worker4 = new Vimeo_search(newvideolst, appContext);
				executor.execute(worker4);

				Runnable worker5 = new Metacafe_search(newvideolst, appContext);
				executor.execute(worker5);
			}
			executor.shutdown();
			try {
				executor.awaitTermination(10, TimeUnit.MINUTES);
			} catch (InterruptedException ex) {
				java.util.logging.Logger.getLogger(Google_search.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else if (args.length == 1 && args[0].contains("distribute")) {

			System.out.println("--- Keywords Distribution mechanism starts ---");

			String crawlerName = args[0];

			if (crawlerName.equalsIgnoreCase("distribute-google")) {
				crawlerName = "google";
			} else if (crawlerName.equalsIgnoreCase("distribute-yahoo")) {
				crawlerName = "yahoo";
			} else if (crawlerName.equalsIgnoreCase("distribute-bing")) {
				crawlerName = "bing";
			} else {
				System.out.println("invalid args ");
				showOption();
				return;
			}
			System.out.println("    -- crawlerName : " + crawlerName);

			appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);

			InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
			Properties props = new Properties();
			props.load(inStream);
			PropertyConfigurator.configure(props);
			int countKeyword = objKeywordDao.countKeywordRows();
			int keywordsAmount = countKeyword / 5;
			System.out.println("    -- Total keywords available : " + countKeyword);
			System.out.println("    -- No of keywords/Instance : " + keywordsAmount);
			int initial = 1;
			for (int i = 1; i <= 5; i++) {

				// Runtime.getRuntime().exec("java BrandzterRankTrackerCrawler "+crawlerName+" "+initial+" "+(initial+keywordsAmount-1));
				if (i == 5) {
					System.out.println("java -jar BrandzterRankTrackerCrawler.jar " + crawlerName + " " + initial + " " + (countKeyword));
					Runtime.getRuntime().exec("java -jar BrandzterRankTrackerCrawler.jar " + crawlerName + " " + initial + " " + (countKeyword));

				} else {
					System.out.println("java -jar BrandzterRankTrackerCrawler.jar " + crawlerName + " " + initial + " " + (initial + keywordsAmount - 1));
					Runtime.getRuntime().exec("java -jar BrandzterRankTrackerCrawler.jar " + crawlerName + " " + initial + " " + (initial + keywordsAmount - 1));

				}
				initial += keywordsAmount;
			}

		} else if (args.length == 3) {
			System.out.println("--- Instance mechanism starts for crawlerName---");

			String crawlerName = args[0];
			System.out.println("    -- crawlerName : " + crawlerName);
			int startLimit = Integer.parseInt(args[1]);
			System.out.println("    -- startLimit : " + startLimit);
			int endLimit = Integer.parseInt(args[2]);
			System.out.println("    -- endLimit : " + endLimit);

			appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);

			InputStream inStream = new StartCrawler().getClass().getClassLoader().getResourceAsStream("log4j.properties");
			Properties props = new Properties();
			props.load(inStream);
			PropertyConfigurator.configure(props);

			List<Serpkeywords> newserplst = objKeywordDao.getKeywords(startLimit, endLimit);

			System.out.println("---------------serp keywords------------" + newserplst.size());

			if (!newserplst.isEmpty()) {

				if (crawlerName.equalsIgnoreCase("google")) {
					Thread searchgoogle = new Thread(new Google_search(appContext, newserplst));
					searchgoogle.start();
				}

				if (crawlerName.equalsIgnoreCase("yahoo")) {
					Thread yahoosearch = new Thread(new Yahoo_search(appContext, newserplst));
					yahoosearch.start();
				}
				if (crawlerName.equalsIgnoreCase("bing")) {
					Thread bingsearch = new Thread(new Bing_search(appContext, newserplst));
					bingsearch.start();
				}
			}
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
	}
}
