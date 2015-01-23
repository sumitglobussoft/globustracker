/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.youtube;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Videokeywords;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.Youtube_search;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class YoutubePagenLinks implements Callable<String> {

    private KeywordsDao objKeywordDao;
    private FetchPagewithClientAthentication fetchSourcewithAuthentication;
    String yoUrl;
    String yoKeyword;
    Integer yoKeywordId;
    private Boolean flag = false;
    int youtuberank;
    String youtubeurl;
    Videokeywords keywords;
    List<ProxyData> proxyList;
    
    public YoutubePagenLinks() {
    }

   public YoutubePagenLinks(KeywordsDao objKeywordDao, FetchPagewithClientAthentication fetchSourcewithAuthentication, String yoUrl, String yoKeyword, Integer yoKeywordId, int youtuberank, String youtubeurl, Videokeywords keywords,List<ProxyData> proxyList) {
        this.objKeywordDao = objKeywordDao;
        this.fetchSourcewithAuthentication = fetchSourcewithAuthentication;
        this.yoUrl = yoUrl;
        this.yoKeyword = yoKeyword;
        this.yoKeywordId = yoKeywordId;
        this.youtuberank = youtuberank;
        this.youtubeurl = youtubeurl;
        this.keywords = keywords;
         this.proxyList = proxyList;
    }

    @Override
    public String call() throws Exception {
      
        if (!keywords.getYoutubeURL().isEmpty()) {
            Boolean rankcheck = false;
            Map<String, String> mainlinks = new LinkedHashMap<>();

            youtuberank = 0;
            yoUrl = keywords.getYoutubeURL();
            yoKeyword = keywords.getVideoKeyword();
            yoKeywordId = keywords.getVideokeywordID();
            //yoKeyword=yoKeyword.replaceAll(" ", "+");
            System.out.println("yoKeywordId = " + yoKeywordId);
            System.out.println("searchurl = " + yoUrl);
            //http://www.youtube.com/results?search_query=best+self+help+book&oq=best+self+help+book
            try {
//                       
                int count = 0;

                for (int k = 1; k <= 10; k++) {
                    int l = 0;
                    String num = Integer.toString(k);
                    URI newuri = new URIBuilder()
                            .setScheme("http")
                            .setHost("www.youtube.com")
                            .setPath("/results")
                            .setParameter("search_query", yoKeyword)
                            .setParameter("page", num)
                            .build();
                        //String newuri="http://www.youtube.com/results?search_query="+yoKeyword+"&page="+k;

                    System.out.println("searchurl = " + newuri);
                    String pagesource = fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(newuri, "", 0, this.proxyList);
                    while (pagesource.length() < 1000 && l <= 3) {
                        System.out.println("second attempt searchurl = " + newuri);
                        pagesource = fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(newuri, "", 0, this.proxyList);
                        l++;
                    }
                    System.out.println("pagelsource lenth " + pagesource.length());
                    mainlinks = getYoutubePageCitationLinks(pagesource);
                    rankcheck = findRankforyoutubeMap(mainlinks, yoUrl, count);
                    count = count + 20;
                    if (rankcheck) {
                        break;
                    }
                }
                if (!rankcheck) {
                    objKeywordDao.saveYoutubeResult(yoKeywordId, yoKeyword, "No Link Found", 501);
                }

            } catch (Exception ex) {
                Logger.getLogger(Youtube_search.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }

        }
        return "done";
    }
    public Boolean findRankforyoutubeMap(Map pagelist, String yoURL,int count) throws MalformedURLException {
        Boolean store = false;
        Iterator itrmap = pagelist.entrySet().iterator();
        while (itrmap.hasNext()) {
            flag = false;
            Map.Entry mentry = (Map.Entry) itrmap.next();
            count++;
            flag = findYoutubeRank(mentry.getValue().toString(), yoURL);
            if (flag) {
                youtuberank = count;
                System.out.println("youtuberank = " + youtuberank);
                youtubeurl = mentry.getValue().toString();
                objKeywordDao.saveYoutubeResult(yoKeywordId, yoKeyword, youtubeurl, youtuberank);
                store = true;
                break;
            }
        }
        return store;
    }

    public Map<String, String> getYoutubePageCitationLinks(String pagesource) {
        Map<String, String> youcitelinks = new LinkedHashMap<>();
        try {
            Document doc = Jsoup.parse(pagesource);
            Element links = doc.getElementById("results");
            Elements links2 = links.getElementsByTag("li");
            Elements nlinks = links2.select("h3.yt-lockup-title > a");
            for (Element el2 : nlinks) {
             String youlinks = el2.attr("href");
             System.out.println("Main Links "+youlinks);
             String youtitles = el2.attr("title");
             System.out.println("youtitles = " + youtitles+"  "+" youlink : "+youlinks);
             youcitelinks.put(youtitles, youlinks);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return youcitelinks;
    }
     public Boolean findYoutubeRank(String title, String domainurl) throws MalformedURLException {
        Boolean fod = false;
        if (domainurl.contains(title)) {
            fod = true;
        }
        return fod;
    }

    
    
//    public  Map getOtherYoutubePageLinksCrawl(Queue pagenLinks)throws IOException, InterruptedException{
//        Map<String,String> otherlinks=new LinkedHashMap<>();
//        ExecutorService executor=Executors.newCachedThreadPool();
//        List<Future<Map<String, String>>> future=new ArrayList<>();
//        Queue pagelist=pagenLinks;
//        String lastpage=null;
//          Iterator itr=pagelist.iterator();
//          for(int i=0;itr.hasNext();i++){
//              String pl=(String) itr.next();
//              otherlinks.putAll(getExtraPageLinksCrawl(pl, future, executor, i));
//              lastpage=pl;
//          }
//          
//          String lastvalue=lastpage.substring(lastpage.length()-1, lastpage.length());
//          int index=Integer.parseInt(lastvalue);
//          for(int i=0;i<10;i++){
//              index++;
//              String temp=lastpage.replace(lastvalue, "");
//              String newpage=temp+index;
//              //System.out.println("newpage = " + newpage);
//              otherlinks.putAll(getExtraPageLinksCrawl(newpage, future, executor, i));
//          }
//        executor.shutdown();
//        return otherlinks;
//    }
//    public  Map getExtraPageLinksCrawl(String newpageurl,List<Future<Map<String, String>>> future,ExecutorService executor,int i)throws IOException, InterruptedException{
//        Map<String,String> newpagelinks=new LinkedHashMap<>();
//        HttpGet httpget=new HttpGet((String)"http://www.youtube.com"+newpageurl);
//              future=((List<Future<Map<String,String>>>) executor.invokeAll((Arrays.asList(new GetYoutubeThread(httpget, i)))));         
//              Iterator itr1=future.iterator();
//              while(itr1.hasNext()){
//                  try {
//                      Future<Map<String,String>> futur=(Future<Map<String,String>>) itr1.next();
//                      for(Map.Entry futur1:futur.get().entrySet()){   
//                            newpagelinks.put(futur1.getKey().toString(), futur1.getValue().toString());
//                   }
//                  } catch (InterruptedException | ExecutionException ex) {
//                      Logger.getLogger(YoutubePagenLinks.class.getName()).log(Level.SEVERE, null, ex);
//                      ex.printStackTrace();
//                  }
//              }
//        return newpagelinks;
//    }
}
