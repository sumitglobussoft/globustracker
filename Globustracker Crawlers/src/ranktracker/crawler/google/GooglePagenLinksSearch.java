/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.google;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Serpkeywords;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.Google_search;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class GooglePagenLinksSearch implements Callable<String> {

	Serpkeywords objSerpsKeywords;
	ApplicationContext appContext;
	KeywordsDao objKeywordDao;
	FetchPagewithClientAthentication fetchclientpage;	
	int keywordNumber = 0;
	List<ProxyData> proxyList;
	int counter = 0;
	boolean bestMatchRankFound = false;
	boolean rankFound = false;

	public GooglePagenLinksSearch(Serpkeywords objSerpsKeywords, ApplicationContext applicationContext, int keywordNumber, List<ProxyData> proxyList) {
		this.objSerpsKeywords = objSerpsKeywords;
		this.appContext = applicationContext;
		this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
		this.fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);	
		this.keywordNumber = keywordNumber;
		this.proxyList = proxyList;
	}

	public boolean getRank(String url, String domain) throws MalformedURLException {

		// System.out.println("getRank");
		// System.out.println("url: " + url);
		// System.out.println("domain: " + domain);
		String tempurl = url.replace("https://", "").replace("http://", "").replace("www.", "");
		tempurl = tempurl.replace("/", "");

		String tempdomain = domain.replace("/", "");

		if (tempurl.equalsIgnoreCase(tempdomain)) {
			// System.out.println("one");
			return true;
		} else if (!domain.contains("/")) {
			if (new URL("http://" + url.replace("http://", "").replace("https://", "").replace("www.", "")).getHost().equalsIgnoreCase(new URL("http://" + domain).getHost())) {
				//System.out.println("two");
				return true;
			}
		}
		return false;
	}

	public boolean findRanks(Document doc, int page) throws MalformedURLException {
		Elements results = doc.select("div[id=ires] div[class=g]");

		System.out.println("-- PAGE : " + page);
		for (Element result : results) {
			try {
				counter++;
				String url = result.select("a").first().attr("href").replace("/url?q=", "");
				//String url = result.select("cite").first().text();
				System.out.println("        -- RESULT : " + counter + " --- ---- ---- ---- ---- ---- ");
				System.out.println("        -- URL : " + url);

				if (!bestMatchRankFound) {
					if (new URL("http://" + url.replace("http://", "").replace("https://", "").replace("www.", "")).getHost().equalsIgnoreCase(new URL("http://" + objSerpsKeywords.getUrl()).getHost())) {
						objSerpsKeywords.setBestMatchRankGoogle(counter);
						bestMatchRankFound = true;
						objSerpsKeywords.setBestMatchLinkGoogle(url);
						System.out.println("        -- Best Match Link : " + objSerpsKeywords.getBestMatchLinkGoogle());
						System.out.println("        -- Best Match Rank : " + objSerpsKeywords.getBestMatchRankGoogle());

					}
				}

				if (!rankFound) {
					url = result.select("cite").first().text();
					if (getRank(url, objSerpsKeywords.getUrl())) {
						objSerpsKeywords.setRankGoogle(counter);
						rankFound = true;
						System.out.println("        -- Rank Found : " + objSerpsKeywords.getRankGoogle());
						return true;

					}
				}
			} catch (Exception ew) {
			}
		}
		return false;
	}

	@Override
	public String call() throws InterruptedException {
		try {
			System.out.println("== [ " + this.keywordNumber + " ] =======================================================================================================");
			System.out.println("------ GooglePagenLinksSearch");
			System.out.println("    -- goKeyword = " + objSerpsKeywords.getKeyword());
			System.out.println("    -- goKeywordID = " + objSerpsKeywords.getKeywordID());
			System.out.println("    -- goLinkGoogle = " + objSerpsKeywords.getLinkGoogle());
			System.out.println("    -- goUrl = " + objSerpsKeywords.getUrl());

			String googlestring = "https://www." + objSerpsKeywords.getLinkGoogle() + "/search?q=" + objSerpsKeywords.getKeyword().replace(" ", "+");
			System.out.println("    -- Google Url: " + googlestring);

			Document doc = Jsoup.parse(fetchclientpage.fetchPageSourcefromClientGoogle(new URI(googlestring), "", 0, this.proxyList));

			findRanks(doc, 1);
			//  System.out.println("" + doc);

			if (!rankFound) {
				String nextLink;
				for (int i = 2; i < 26; i++) {
					try {
						nextLink = "https://" + objSerpsKeywords.getLinkGoogle() + doc.select("table[id=nav] a").last().attr("href");
						System.out.println("nextLink : " + nextLink);
						doc = Jsoup.parse(fetchclientpage.fetchPageSourcefromClientGoogle(new URI(nextLink), "", 0, this.proxyList));
						if (findRanks(doc, i)) {
							break;
						}
					} catch (Exception ex) {
						System.out.println("EXCEPTION IN PAGINATION : " + ex);
					}
				}
			}
			System.out.println("bestMatchRankGoogle : " + objSerpsKeywords.getBestMatchRankGoogle());
			System.out.println("bestMatchLinkGoogle : " + objSerpsKeywords.getBestMatchLinkGoogle());
			System.out.println("rankGoogle : " + objSerpsKeywords.getRankGoogle());

			Integer startGoogle = objSerpsKeywords.getStartGoogle() == 0 ? objSerpsKeywords.getRankGoogle() : objSerpsKeywords.getStartGoogle();

			objKeywordDao.saveResult(objSerpsKeywords.getKeywordID(), startGoogle, objSerpsKeywords.getRankGoogle(), objSerpsKeywords.getBestMatchRankGoogle(), objSerpsKeywords.getBestMatchLinkGoogle(), "google.com", objSerpsKeywords.getKeyword(), objSerpsKeywords.getUrl());
			return "success";
		} catch (Exception run1) {
			Logger.getLogger(Google_search.class.getName()).log(Level.SEVERE, null, run1);
			run1.printStackTrace();
			return "failed";
		}
	}

	public Queue<String> getGooglePageCitationLinksFromString(String responsebody) {
		Queue<String> mainlinks = new LinkedList<>();
		try {
			Document doc = Jsoup.parse(responsebody);
			Elements nlinks = doc.select("div[class=srg] li h3[class=r] a");
			for (Element el2 : nlinks) {
				String golinks = el2.attr("href");
				System.out.println("Main Links " + golinks);
				mainlinks.add(golinks);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mainlinks;
	}
}
