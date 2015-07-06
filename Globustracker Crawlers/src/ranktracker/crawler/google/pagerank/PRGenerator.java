/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.google.pagerank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Serpkeywords;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.UserAgents;

/**
 *
 * @author User
 */
public class PRGenerator extends Thread {

    /*
     * @domain
     /**
     * 
     */
    private KeywordsDao objKeywordDao;

    /*
     * 
     */
    private List<Serpkeywords> lstKeywords;

    ProxyDao objProxyDao;
    FetchPagewithClientAthentication fetchclientpage;
    List<ProxyData> proxyList;

    public PRGenerator(List<Serpkeywords> lstKeywords, ApplicationContext appContext) {
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.lstKeywords = lstKeywords;
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
        this.fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
        this.proxyList = objProxyDao.getProxyList();
    }

    @Override
    public void run() {
        String result = "0";
        int count = 0;
        int keywordID;
        for (Serpkeywords k : lstKeywords) {
            keywordID = k.getKeywordID();
            if (count < 1) {
                String url = k.getUrl();
                try {
                    String PRurl = "http://tools.mercenie.com/page-rank-checker/api/?format=json&urls=http://www." + url;
                   // String input = fetchGooglePageRank(PRurl);
                    String input="";
                    try {
                        input = fetchclientpage.fetchPageSourcefromClientGoogle(new URI(PRurl), "", 0, this.proxyList);
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(PRGenerator.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PRGenerator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    // What Google returned? Example : Rank_1:1:9, PR = 9
                    String[] pr = input.split("http");
                    Pattern pattern = Pattern.compile("pagerank(.*?)}");
                    Matcher matcher = pattern.matcher(pr[1].toString());
                    if (matcher.find()) {
                        String prcount = matcher.group(1).trim();
                        result = prcount.replace('"', ' ').replace(":", "").replace(" ", "");
                    }
                } catch (IOException | NumberFormatException e) {
                    System.out.println(e.getMessage());
                    objKeywordDao.saveGooglePageRank(keywordID, 0);
                }
            }
            count = 1;
           // System.out.println("pagerank for" + keywordID + "==" + result);
            objKeywordDao.saveGooglePageRank(keywordID, Integer.parseInt(result));

        }

//     String result = "";
//       HashGenerationJE jenkinsHash = new HashGenerationJE();
//	long hash = jenkinsHash.hash(("info:" + domain).getBytes());
//        //Append a 6 in front of the hashing value.
//	String url = "http://toolbarqueries.google.com/tbr?client=navclient-auto&hl=en&"
//	   + "ch=6" + hash + "&ie=UTF-8&oe=UTF-8&features=Rank&q=info:" + domain;
// 
//	try {
//		
//		String input=fetchGooglePageRank(url);
//	        // What Google returned? Example : Rank_1:1:9, PR = 9
//		System.out.println(input);
//
//		result = input.substring(input.lastIndexOf(":") + 1);
//                objKeywordDao.saveGooglePageRank(keywordId, Integer.parseInt(result));
//	} catch (IOException | NumberFormatException e) {
//		System.out.println(e.getMessage());
//                objKeywordDao.saveGooglePageRank(keywordId, 0);
//    }
    }

    public String fetchGooglePageRank(String pageurl) throws IOException {
        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope("IP Address", 111),
                new UsernamePasswordCredentials("Username", "Password"));
        HttpHost proxy = new HttpHost("Ip Address", 111);
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        //    String responsestatus=null;
        try {
            HttpGet httpget = new HttpGet(pageurl);
            System.out.println("Response status" + httpget.getRequestLine());
            CloseableHttpResponse resp = httpclient.execute(httpget);
            //       responsestatus=resp.getStatusLine().toString();
            HttpEntity entity = resp.getEntity();
            System.out.println(resp.getStatusLine());
            if (entity != null) {
                System.out.println("Response content length: " + entity.getContentLength());
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
}
