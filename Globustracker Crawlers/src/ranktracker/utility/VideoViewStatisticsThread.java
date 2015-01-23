/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ranktracker.utility;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Videokeywords;

/**
 *
 * @author GLB-130
 */
public class VideoViewStatisticsThread implements Callable<String>{
      private ApplicationContext appContext;
    private List<Videokeywords> lstVideokeywords;
    private KeywordsDao objKeywordDao;
    String yoUrl;
    String dailyUrl;
    String vimeoUrl;
    String metacafeUrl;
    Integer yoKeywordId;
    Videokeywords keywords;
    List<ProxyData> proxyList;
    private FetchPagewithClientAthentication fetchSourcewithAuthentication;

    public VideoViewStatisticsThread(ApplicationContext appContext, List<Videokeywords> lstVideokeywords, KeywordsDao objKeywordDao, String yoUrl, String dailyUrl, String vimeoUrl, String metacafeUrl, Integer yoKeywordId, Videokeywords keywords, List<ProxyData> proxyList, FetchPagewithClientAthentication fetchSourcewithAuthentication) {
        this.appContext = appContext;
        this.lstVideokeywords = lstVideokeywords;
        this.objKeywordDao = objKeywordDao;
        this.yoUrl = yoUrl;
        this.dailyUrl = dailyUrl;
        this.vimeoUrl = vimeoUrl;
        this.metacafeUrl = metacafeUrl;
        this.yoKeywordId = yoKeywordId;
        this.keywords = keywords;
        this.proxyList = proxyList;
        this.fetchSourcewithAuthentication = fetchSourcewithAuthentication;
    }
    
    @Override
    public String call() throws Exception {
         yoUrl = keywords.getYoutubeURL();
                dailyUrl = keywords.getDailymotionURL();
                vimeoUrl = keywords.getVimeoURL();
                metacafeUrl = keywords.getMetacafeURL();
                yoKeywordId = keywords.getVideokeywordID();

                System.out.println("yoKeywordId = " + yoKeywordId);
                System.out.println("Youtube URL " + yoUrl);

                int youtube_view = 0;
                int vimeo_view = 0;
                int metacafe_view = 0;
                int dailymotion_view = 0;
                short daily_view = 0;
                int last_count = 0;

                last_count = objKeywordDao.LastView(yoKeywordId);
                System.out.println("-----------" + last_count + "----------");
                if (yoUrl.length() < 5) {
                } else {
                    try {
                        if (yoUrl.contains("youtube.com")) {

                        } else {
                            yoUrl = "youtube.com" + yoUrl;
                        }
                        String url = "http://www." + yoUrl;
                        int l = 0;
                        String input = fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(new URI(url), "", 0, this.proxyList);
                        while (input.length() <= 500 && l <= 3) {
                            input =  fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(new URI(url), "", 0, this.proxyList);
                            l++;
                        }

                        Document doc = Jsoup.parse(input);
                        {
                            Element links = doc.getElementById("watch7-views-info");
                            String view = links.getElementsByClass("watch-view-count").text();

                            if (view.contains("views")) {
                                view = view.replaceAll(" views", "");
                            }
                            if (view.contains(",")) {
                                youtube_view = Integer.parseInt(view.replaceAll(",", ""));
                            } else {
                                youtube_view = Integer.parseInt(view);
                            }
                        }
                    } catch (IOException | NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                if (vimeoUrl.length() < 5) {
                } else {
                    String url = "http://www." + vimeoUrl;
                    int l = 0;
                    String input =  fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(new URI(url), "", 0, this.proxyList);
                    while (input.length() <= 500 && l <= 3) {
                        input =  fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(new URI(url), "", 0, this.proxyList);
                        l++;
                    }
                    try {
                        Document doc = Jsoup.parse(input);
                        String links = doc.getElementById("cols").toString();

                        Pattern pattern = Pattern.compile("UserPlays:(.*?)/");
                        Matcher matcher = pattern.matcher(links);
                        if (matcher.find()) {
                            String view = matcher.group(1).trim().replace('"', ' ').replaceAll(" ", "");
                            if (view.contains(",")) {
                                vimeo_view = Integer.parseInt(view.replaceAll(",", ""));
                            } else {
                                vimeo_view = Integer.parseInt(view);
                            }
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                }

                if (metacafeUrl.length() < 5) {
                } else {
                    String url = "http://www." + metacafeUrl;

                    try {
                        int l = 0;
                        String input = fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(new URI(url), "", 0, this.proxyList);
                        while (input.length() <= 500 && l <= 3) {
                            input =  fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(new URI(url), "", 0, this.proxyList);
                            l++;
                        }

                        Document doc = Jsoup.parse(input);
                        String[] links = doc.getElementById("Views").text().split(" ");
                        String view = (links[0]);
                        if (view.contains(",")) {
                            metacafe_view = Integer.parseInt(view.replaceAll(",", ""));
                        } else {
                            metacafe_view = Integer.parseInt(view);
                        }

                    } catch (IOException | NumberFormatException e) {
                        e.printStackTrace();
                    }
                }

                if (dailyUrl.length() < 5) {
                } else {
                    try {
                        String url = "http://www." + dailyUrl;
                        int l = 0;
                        String input =  fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(new URI(url), "", 0, this.proxyList);
                        while (input.length() <= 1000 && l <= 3) {
                            input =  fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(new URI(url), "", 0, this.proxyList);
                            l++;
                        }
                        Document doc = Jsoup.parse(input);
//                        String[] links = doc.getElementById("video_views_count").text().split(" ");
//                        String view = links[0];
//                        if (view.contains(",")) {
//                            dailymotion_view = Integer.parseInt(view.replaceAll(",", ""));
//                        } else {
//                            dailymotion_view = Integer.parseInt(view);
//                        }
                        
                        String view=doc.getElementById("video_views_count").text();//ashchange
                        view=view.replace(" ","");
                        view=view.replace("views", "");
                        
                       if (view.contains(",")) {
                            dailymotion_view = Integer.parseInt(view.replaceAll(",", ""));
                        } else {
                            dailymotion_view = Integer.parseInt(view);
                        }
                        
                       

                    } catch (IOException | NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("youtube_view" + youtube_view);
                System.out.println("vimeo_view" + vimeo_view);
                System.out.println("metacafe_view" + metacafe_view);
                System.out.println("dailymotion_view" + dailymotion_view);
                System.out.println("last_count" + last_count);

                int daily_view_count = youtube_view - last_count;
                if (daily_view_count >= youtube_view || daily_view_count >= 65535) {
                    daily_view_count = 0;
                }
                if (youtube_view <= last_count) {
                    daily_view_count = 0;
                }
                if(daily_view_count<0)
                {
                      daily_view_count = 0;
                }

                daily_view = (short) (daily_view_count);
                System.out.println("daily_view" + daily_view);

                objKeywordDao.saveYoutubeStatistics(yoKeywordId, youtube_view, vimeo_view, metacafe_view, dailymotion_view, daily_view);
                System.out.println("==============inserted================");
        
        
       return "done";
    }
    
}
