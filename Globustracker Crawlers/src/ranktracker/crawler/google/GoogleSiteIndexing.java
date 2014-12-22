/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.google;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;
import ranktracker.utility.FetchPagewithClientAthentication;

/**
 *
 * @author GLB-068
 */
public class GoogleSiteIndexing extends Thread {

    private KeywordsDao objKeywordDao;
    private List<Serpkeywords> lstKeywords;
    FetchPagewithClientAthentication fetchclientpage;

    public GoogleSiteIndexing(List<Serpkeywords> lstKeywords, ApplicationContext appContext) {
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.lstKeywords = lstKeywords;
        this.fetchclientpage = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
    }

    @Override
    public void run() {
        Boolean index = false;
        int count = 0;
        String result = "";

        try {
            for (Serpkeywords k : lstKeywords) {
                int keywordID = k.getKeywordID();
                if (count < 1) {
                    String link = k.getUrl();
                    String str = "http://www." + link;
                    URL url = new URL(str);
                    String host = url.getHost();
                    System.out.println(host);
                    String domainUrl = host.replace("www.", "");
                    String searchUrl = "https://www.google.com/search?q=site:" + domainUrl;
                    try {
                        String input = fetchclientpage.fetchPageSourcewithProxywithoutFile(searchUrl);
                        index = getMainPageLinks(domainUrl, input);
                        if (index == true) {
                            result = "Yes";
                        } else {
                            result = "No";
                        }
                        System.out.println("Site indexing google for " + domainUrl + " : " + result);
                        count = 1;
                    } catch (IOException ex) {
                        Logger.getLogger(GoogleSiteIndexing.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    break;
                }
                // System.out.println(siteUrl);
                // System.out.println(domainUrl);
            }
            for (Serpkeywords k : lstKeywords) {
                int keywordID = k.getKeywordID();
                objKeywordDao.saveSiteIndex(keywordID, result);
                break;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(GoogleSiteIndexing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Boolean getMainPageLinks(String url, String input) {
        Boolean fod = false;
        try {
            Document doc = Jsoup.parse(input);
            Element links = doc.getElementById("ires");
            Elements links2 = links.getElementsByTag("li");
            Elements nlinks = links2.select("h3.r > a");

            for (Element el2 : nlinks) {
                String golinks = el2.attr("href");
                String[] domainsparts = new String[5];
                String spliturl;

                if (golinks.contains("//")) {
                    domainsparts = golinks.split("//");
                } else {
                    domainsparts[0] = golinks;
                }

                if (domainsparts[1].contains("/")) {
                    domainsparts = domainsparts[1].split("/");
                } else {
                    domainsparts[0] = domainsparts[1];
                }

                if (domainsparts[0].contains("www.")) {
                    spliturl = domainsparts[0].replace("www.", "");
                } else {
                    spliturl = domainsparts[0];
                }

                if (url.contains(spliturl)) {
                    fod = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fod;
    }

//    public String fetchGoogleIndex(String pageurl) throws IOException {
//        CredentialsProvider credsprovider = new BasicCredentialsProvider();
//        credsprovider.setCredentials(
//                new AuthScope("95.85.29.99", 2821),
//                new UsernamePasswordCredentials("mongoose", "Fjh30fi"));
//        HttpHost proxy = new HttpHost("95.85.29.99", 2821);
//        String userAgent = UserAgents.getRandomUserAgent();
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setDefaultCredentialsProvider(credsprovider)
//                .setUserAgent(userAgent)
//                .setProxy(proxy)
//                .build();
//        String responsebody = "";
//        String responsestatus = null;
//        int returnresponse;
//        int count = 0;
//        try {
//            HttpGet httpget = new HttpGet(pageurl);
//            System.out.println("Response status" + httpget.getRequestLine());
//            CloseableHttpResponse resp = httpclient.execute(httpget);
//            responsestatus = resp.getStatusLine().toString();
//            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
//                    || responsestatus.contains("402") || responsestatus.contains("403") || responsestatus.contains("404")
//                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")) {
//                do {
//                    count++;
//                    returnresponse = fetchPageSource(pageurl);
//                    if (returnresponse == 503) {
//                        System.out.println("PROX FAILURE");
//                    }
//                    if (count > 15) {
//                        responsebody = fetchPageSourceWithoutProxy(pageurl);
//                    }
//                } while (returnresponse == 503 || returnresponse == 502);
//            } else {
//                HttpEntity entity = resp.getEntity();
//                System.out.println(resp.getStatusLine());
//                if (entity != null) {
//                    System.out.println("Response content length: " + entity.getContentLength());
//                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
//                    String inputLine;
//                    while ((inputLine = in.readLine()) != null) {
//                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
//                    }
//
//                }
//                EntityUtils.consume(entity);
//            }
//        } catch (IOException | IllegalStateException e) {
//            System.out.println("Exception = " + e);
//            do {
//                count++;
//                returnresponse = fetchPageSource(pageurl);
//                if (returnresponse == 503) {
//                    System.out.println("PROX FAILURE");
//                }
//                if (count > 15) {
//                    responsebody = fetchPageSourceWithoutProxy(pageurl);
//                }
//            } while (returnresponse == 503 || returnresponse == 502);
//        } finally {
//            httpclient.close();
//        }
//        return responsebody;
//    }
//    public int fetchPageSource(String newurl) throws IOException {
//        // portNo = generateRandomPort();
//        CredentialsProvider credsprovider = new BasicCredentialsProvider();
//        credsprovider.setCredentials(
//                new AuthScope("95.85.29.99", 2801),
//                new UsernamePasswordCredentials("mongoose", "Fjh30fi"));
//        HttpHost proxy = new HttpHost("95.85.29.99", 2801);
//        String userAgent = UserAgents.getRandomUserAgent();
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setDefaultCredentialsProvider(credsprovider)
//                .setUserAgent(userAgent)
//                .setProxy(proxy)
//                .build();
//        String responsebody = "";
//        String responsestatus = null;
//        try {
//            HttpGet httpget = new HttpGet(newurl);
//            System.out.println("Response status" + httpget.getRequestLine());
//            CloseableHttpResponse resp = httpclient.execute(httpget);
//            responsestatus = resp.getStatusLine().toString();
//            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
//                    || responsestatus.contains("401") || responsestatus.contains("402") || responsestatus.contains("403")
//                    || responsestatus.contains("SSLHandshakeException") || responsestatus.contains("999")) {
//                return 503;
//            } else {
//                HttpEntity entity = resp.getEntity();
//                System.out.println(resp.getStatusLine());
//                if (entity != null) {
//                    System.out.println("Response content length: " + entity.getContentLength());
//                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
//                    String inputLine;
//                    while ((inputLine = in.readLine()) != null) {
//                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
//                    }
//
//                }
//                EntityUtils.consume(entity);
//            }
//        } catch (IOException | IllegalStateException e) {
//            return 503;
//        } finally {
//            httpclient.close();
//        }
//        return 0;
//    }
//    public String fetchPageSourceWithoutProxy(String newurl) throws IOException {
//        System.out.println("---------------Without Proxy-----------------");
//        String responsebody;
//        String userAgent = UserAgents.getRandomUserAgent();
//        try (CloseableHttpClient httpclient = HttpClients.custom()
//                        .setUserAgent(userAgent)
//                        .build()) {
//            HttpGet httpget = new HttpGet(newurl);
//            System.out.println("executing request " + httpget.getURI());
//            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//                @Override
//                public String handleResponse(
//                        final HttpResponse response) throws ClientProtocolException, IOException {
//                    int status = response.getStatusLine().getStatusCode();
//                    if (status >= 200 && status < 300) {
//                        HttpEntity entity = response.getEntity();
//                        return entity != null ? EntityUtils.toString(entity) : null;
//                    } else {
//                        throw new ClientProtocolException("Unexpected response status: " + status);
//                    }
//                }
//            };
//            responsebody = httpclient.execute(httpget, responseHandler);
//        }
//        return responsebody;
//    }
}
