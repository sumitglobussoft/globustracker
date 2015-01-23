/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.youtube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.auth.AuthScope;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Videokeywords;
import ranktracker.utility.FetchPageBodySource;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.UserAgents;
import ranktracker.utility.VideoViewStatisticsThread;
import ranktracker.utility.Vimeo_search;



/**
 *
 * @Nitin kumar dwivedi(nitindwivedi@globussoft.com) The Api key is from
 * googleAPI for developer.
 * https://code.google.com/apis/console/?noredirect#project:883111139837:access
 * password->SMtf_1649 then configure APIkey for individual IP
 *
 */
public class YoutubeStatistics extends Thread {

    private ApplicationContext appContext;
    private List<Videokeywords> lstVideokeywords;
    private KeywordsDao objKeywordDao;
    String yoUrl;
    String dailyUrl;
    String vimeoUrl;
    String metacafeUrl;
    Integer yoKeywordId;
    ProxyDao objProxyDao;
    FetchPagewithClientAthentication fetchSourcewithAuthentication;

    public YoutubeStatistics(List<Videokeywords> lstVideokeywords, ApplicationContext appContext) {
        this.appContext = appContext;
        this.lstVideokeywords = lstVideokeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
          this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
          this.fetchSourcewithAuthentication = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
    }

    public YoutubeStatistics() {
    }
    
      public boolean checkForRecentUpdatedKeyword(Videokeywords keywords) {
        try {
            String currentDate[] = (new Date()).toString().split(" ");
            String endDate[] = keywords.getViewStatisticsUpdatedDate().split(" ");

            //Wed Jan 07 13:45:08 IST 2015
            //Fri Jan 02 13:40:06 IST 2015
            if (currentDate[0].equalsIgnoreCase(endDate[0])) {
                if (currentDate[1].equalsIgnoreCase(endDate[1])) {

                    if (currentDate[2].equalsIgnoreCase(endDate[2])) {

                        if (currentDate[5].equalsIgnoreCase(endDate[5])) {

                            System.out.println("SAME TIME : " + keywords.getVideoKeyword() + " [" + keywords.getVideokeywordID()+ "]");
                            return true;
                        }
                    }
                }
            }

        } catch (Exception s) {
            System.out.println("" + s);

        }
        return false;
    }

    @Override
    public void run() {
         ExecutorService executor = Executors.newFixedThreadPool(10);
             List<ProxyData> proxylist=objProxyDao.getProxyList();

        try {
            for (Videokeywords keywords : lstVideokeywords) {
                
                if (checkForRecentUpdatedKeyword(keywords)) {
                    continue;
                }
                
                executor.submit(new VideoViewStatisticsThread(appContext, lstVideokeywords, objKeywordDao, yoUrl, dailyUrl, vimeoUrl, metacafeUrl, yoKeywordId, keywords, proxylist, fetchSourcewithAuthentication));
                

//                yoUrl = keywords.getYoutubeURL();
//                dailyUrl = keywords.getDailymotionURL();
//                vimeoUrl = keywords.getVimeoURL();
//                metacafeUrl = keywords.getMetacafeURL();
//                yoKeywordId = keywords.getVideokeywordID();
//
//                System.out.println("yoKeywordId = " + yoKeywordId);
//                System.out.println("Youtube URL " + yoUrl);
//
//                int youtube_view = 0;
//                int vimeo_view = 0;
//                int metacafe_view = 0;
//                int dailymotion_view = 0;
//                short daily_view = 0;
//                int last_count = 0;
//
//                last_count = objKeywordDao.LastView(yoKeywordId);
//                System.out.println("-----------" + last_count + "----------");
//                if (yoUrl.length() < 5) {
//                } else {
//                    try {
//                        if (yoUrl.contains("youtube.com")) {
//
//                        } else {
//                            yoUrl = "youtube.com" + yoUrl;
//                        }
//                        String url = "http://www." + yoUrl;
//                        int l = 0;
//                        String input = fetchVideoPage(url);
//                        while (input.length() <= 500 && l <= 3) {
//                            input = fetchVideoPage(url);
//                            l++;
//                        }
//
//                        Document doc = Jsoup.parse(input);
//                        {
//                            Element links = doc.getElementById("watch7-views-info");
//                            String view = links.getElementsByClass("watch-view-count").text();
//
//                            if (view.contains("views")) {
//                                view = view.replaceAll(" views", "");
//                            }
//                            if (view.contains(",")) {
//                                youtube_view = Integer.parseInt(view.replaceAll(",", ""));
//                            } else {
//                                youtube_view = Integer.parseInt(view);
//                            }
//                        }
//                    } catch (IOException | NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//                }
//                if (vimeoUrl.length() < 5) {
//                } else {
//                    String url = "http://www." + vimeoUrl;
//                    int l = 0;
//                    String input = fetchVideoPage(url);
//                    while (input.length() <= 500 && l <= 3) {
//                        input = fetchVideoPage(url);
//                        l++;
//                    }
//                    try {
//                        Document doc = Jsoup.parse(input);
//                        String links = doc.getElementById("cols").toString();
//
//                        Pattern pattern = Pattern.compile("UserPlays:(.*?)/");
//                        Matcher matcher = pattern.matcher(links);
//                        if (matcher.find()) {
//                            String view = matcher.group(1).trim().replace('"', ' ').replaceAll(" ", "");
//                            if (view.contains(",")) {
//                                vimeo_view = Integer.parseInt(view.replaceAll(",", ""));
//                            } else {
//                                vimeo_view = Integer.parseInt(view);
//                            }
//                        }
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//
//                if (metacafeUrl.length() < 5) {
//                } else {
//                    String url = "http://www." + metacafeUrl;
//
//                    try {
//                        int l = 0;
//                        String input = fetchVideoPage(url);
//                        while (input.length() <= 500 && l <= 3) {
//                            input = fetchVideoPage(url);
//                            l++;
//                        }
//
//                        Document doc = Jsoup.parse(input);
//                        String[] links = doc.getElementById("Views").text().split(" ");
//                        String view = (links[0]);
//                        if (view.contains(",")) {
//                            metacafe_view = Integer.parseInt(view.replaceAll(",", ""));
//                        } else {
//                            metacafe_view = Integer.parseInt(view);
//                        }
//
//                    } catch (IOException | NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                if (dailyUrl.length() < 5) {
//                } else {
//                    try {
//                        String url = "http://www." + dailyUrl;
//                        int l = 0;
//                        String input = fetchVideoPage(url);
//                        while (input.length() <= 1000 && l <= 3) {
//                            input = fetchVideoPage(url);
//                            l++;
//                        }
//                        Document doc = Jsoup.parse(input);
//                        String[] links = doc.getElementById("video_views_count").text().split(" ");
//                        String view = links[0];
//                        if (view.contains(",")) {
//                            dailymotion_view = Integer.parseInt(view.replaceAll(",", ""));
//                        } else {
//                            dailymotion_view = Integer.parseInt(view);
//                        }
//
//                    } catch (IOException | NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println("youtube_view" + youtube_view);
//                System.out.println("vimeo_view" + vimeo_view);
//                System.out.println("metacafe_view" + metacafe_view);
//                System.out.println("dailymotion_view" + dailymotion_view);
//                System.out.println("last_count" + last_count);
//
//                int daily_view_count = youtube_view - last_count;
//                if (daily_view_count >= youtube_view || daily_view_count >= 65535) {
//                    daily_view_count = 0;
//                }
//                if (youtube_view <= last_count) {
//                    daily_view_count = 0;
//                }
//
//                daily_view = (short) (daily_view_count);
//                System.out.println("daily_view" + daily_view);
//
//                objKeywordDao.saveYoutubeStatistics(yoKeywordId, youtube_view, vimeo_view, metacafe_view, dailymotion_view, daily_view);
//                System.out.println("==============inserted================");

            }
        } catch (Exception ex) {
            Logger.getLogger(YoutubeStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }
           executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            Logger.getLogger(Vimeo_search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String fetchVideoPage(String newurl) throws IOException {
        int portNo = generateRandomPort();
        CredentialsProvider credsprovider = new BasicCredentialsProvider();
        credsprovider.setCredentials(
                new AuthScope("95.85.29.99", portNo),
                new UsernamePasswordCredentials("mongoose", "Fjh30fi"));
        HttpHost proxy = new HttpHost("95.85.29.99", portNo);
        String userAgent = UserAgents.getRandomUserAgent();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsprovider)
                .setUserAgent(userAgent)
                .setProxy(proxy)
                .build();
        String responsebody = "";
        String responsestatus = null;
        int returnresponse;
        int count = 0;
        try {
            HttpGet httpget = new HttpGet(newurl);
            httpget.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            httpget.addHeader("Accept-Encoding", "gzip, deflate");
            httpget.addHeader("Accept-Language", "en-US,en;q=0.5");
            httpget.addHeader("Connection", "keep-alive");

            System.out.println("Response status" + httpget.getRequestLine());

            CloseableHttpResponse resp = httpclient.execute(httpget);
            responsestatus = resp.getStatusLine().toString();
            if (responsestatus.contains("503") || responsestatus.contains("502") || responsestatus.contains("400")
                    || responsestatus.contains("402") || responsestatus.contains("403") || responsestatus.contains("404")
                    || responsestatus.contains("407") || responsestatus.contains("406") || responsestatus.contains("SSLHandshakeException")
                    || responsestatus.contains("999") || responsestatus.contains("504") || responsestatus.contains("505")
                    || responsestatus.contains("ClientProtocolException") || responsestatus.contains("SocketTimeoutException")
                    || responsestatus.contains("HttpHostConnectException")) {
                return "Proxy faliure";
//                do {
//                    count++;
//                    returnresponse = fetchPageSourcefromClientforYoutube2(newurl, pagename);
//                    if (returnresponse == 503) {
//                        System.out.println("PROX FAILURE");
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException ex) {
//                            java.util.logging.Logger.getLogger(FetchPagewithClientAthentication.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                    if (count > 15) {
//                        break;
//                    }
//                } while (returnresponse == 503 || returnresponse == 502);
            } else {
                HttpEntity entity = resp.getEntity();
                System.out.println(resp.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader in = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        responsebody = new StringBuilder().append(responsebody).append(inputLine).toString();
                    }
                    // writeResponseFile(responsebody, pagename);
                }
                EntityUtils.consume(entity);
            }
        } catch (IOException | IllegalStateException e) {
            System.out.println("Exception = " + e);
//            do {
//                count++;
//                returnresponse = fetchPageSourcefromClientforYoutube2(newurl);
//                if (returnresponse == 503) {
//                    System.out.println("PROX FAILURE");
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException ex) {
//                        java.util.logging.Logger.getLogger(FetchPagewithClientAthentication.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                if (count > 15) {
//                    fetchPageSourcefromClientforYoutube2(newurl);
//                }
//            } while (returnresponse == 503 || returnresponse == 502);
        } finally {
            httpclient.close();
        }
        return responsebody;
    }

    public int generateRandomPort() {

        int portNo;
        Random random = new Random();
        int[] portList = new int[98];
        int portBegin = 1601;

        for (int i = 0; i < portList.length; i++) {
            portList[i] = portBegin;
            portBegin = portBegin + 1;
        }

        int num = random.nextInt(98);
        portNo = portList[num];
        return portNo;
    }
}
