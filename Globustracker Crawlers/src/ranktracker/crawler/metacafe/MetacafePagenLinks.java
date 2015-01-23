/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.metacafe;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.ProxyData;
import ranktracker.entity.Videokeywords;
import ranktracker.utility.FetchPagewithClientAthentication;

/**
 *
 * @author User
 */
public class MetacafePagenLinks implements Callable<String> {

    private ApplicationContext appContext;
    private KeywordsDao objKeywordDao;
    private FetchPagewithClientAthentication fetchSourcewithAuthentication;
    int count = 0;
    String mcUrl;
    String mcKeyword;
    Integer mcKeywordId;
    Videokeywords videoKeywords;
    boolean matchfound = false;
    int metacaferank;
     List<ProxyData> proxyList;

    public MetacafePagenLinks(ApplicationContext appContext, KeywordsDao objKeywordDao, FetchPagewithClientAthentication fetchSourcewithAuthentication, String mcUrl, String mcKeyword, Integer mcKeywordId, Videokeywords videoKeywords,List<ProxyData> proxyList) {
        this.appContext = appContext;
        this.objKeywordDao = objKeywordDao;
        this.fetchSourcewithAuthentication = fetchSourcewithAuthentication;
        this.mcUrl = mcUrl;
        this.mcKeyword = mcKeyword;
        this.mcKeywordId = mcKeywordId;
        this.videoKeywords = videoKeywords;
        this.proxyList = proxyList;
    }
    


    @Override
    public String call() throws Exception {
        count = 0;
        List<String> mainlinks = new ArrayList<>();
        String pagenlinks = "";

        mcUrl = videoKeywords.getMetacafeURL();
        mcKeyword = videoKeywords.getVideoKeyword();
        mcKeywordId = videoKeywords.getVideokeywordID();

        if (!videoKeywords.getMetacafeURL().isEmpty()) {

            mcKeyword = mcKeyword.replace(" ", "_");
            System.out.println("Metacafe Keyword = " + mcKeyword);
            URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("metacafe.com")
                    .setPath("/topics/" + mcKeyword)
                    .build();
            do {
               
                String mainpagepath = fetchSourcewithAuthentication.fetchPageSourcefromClientGoogle(uri, "",0,this.proxyList);//common fetch source method
                mainlinks = getMetacafePageCitationLinks1(mainpagepath);
                //System.out.println("mainlinks"+mainlinks);
                matchfound = findSingleLink(mainlinks, mcUrl, count);
                if (matchfound) {
                    break;
                }
                count = count + mainlinks.size();
                System.out.println("count==" + count);
                pagenlinks = getMetacafePaginationLinks(mainpagepath);
                System.out.println("pagenlinks" + pagenlinks);
                // uri = "http://www.metacafe.com" + pagenlinks;
                uri = new URIBuilder()
                        .setScheme("http")
                        .setHost("metacafe.com")
                        .setPath(pagenlinks)
                        .build();
                System.out.println("uri==" + uri);
            } while (mainlinks.size() != 0);

            if (!matchfound) {

                mcKeyword = mcKeyword.replace("_", " ");
                objKeywordDao.saveMetacafeResult(mcKeywordId, mcKeyword, "No Link Found", 0);

            }
        }
        return "sone";
    }

    public List<String> getMetacafePageCitationLinks1(String metacafeResponse) {
        List<String> metacitelinks = new ArrayList<>();
        try {

            Document doc = Jsoup.parse(metacafeResponse);
            Elements e2 = doc.select("ul[id=Catalog1] li h1[class=ItemTitle] a");

            for (Element element : e2) {
                //   System.out.println("URL:- " + "http://www.metacafe.com" + element.attr("href"));
                String mclinks = element.attr("href");
//                System.out.println("TITLE : " + element.text());
                metacitelinks.add(mclinks);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metacitelinks;
    }

    public String getMetacafePaginationLinks(String metacafeResponse) {
        String othpagenlinks = "";
        try {

            Document doc = Jsoup.parse(metacafeResponse);
            Elements plinks = doc.select("div[id=CatalogPageSelector]");
            Elements pagenlinks = plinks.select("ul li[id=Next] a[href]");
            for (Element el1 : pagenlinks) {
                String pilinks = el1.attr("href");
                System.out.println("Pagenation Links : " + "http://www.metacafe.com" + pilinks);
                othpagenlinks = pilinks;
                System.out.println("====================================================================================================================================");
//                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return othpagenlinks;
    }

    public Boolean findSingleLink(List links, String mcUrl, int count) {
        Boolean store = false;

        Iterator itrmap = links.iterator();
        while (itrmap.hasNext()) {
            boolean flag = false;
            String mentry = itrmap.next().toString();
            count++;
            flag = findMetacafeLink(mentry, mcUrl);
            store = false;
            if (flag) {
                metacaferank = count;
                System.out.println("metarank = " + metacaferank);
                //inserting values into DB
                objKeywordDao.saveMetacafeResult(mcKeywordId, mcKeyword, mcUrl, metacaferank);
                store = true;
                break;
            }
        }
        return store;
    }

    public Boolean findMetacafeLink(String link, String mcUrl) {

        mcUrl = mcUrl + "/";
        System.out.println("link" + link);
        System.out.println("mcUrl" + mcUrl);
        Boolean fod = false;
        if (mcUrl.contains(link) || link.contains(mcUrl)) {
            System.out.println("match found");
            fod = true;
        }
        return fod;
    }
//        public Map getOtherMetacafePagenLinks(Queue pagenLinks) throws InterruptedException{
//        Map<String,String> otherlinks=new LinkedHashMap<>();
//        ExecutorService executor = Executors.newCachedThreadPool();
//        List<Future<Map<String, String>>> future=new ArrayList<>();
//        Queue pagelist=pagenLinks;
//        String lastpage=null;
//          Iterator itr=pagelist.iterator();
//          for(int i=0;itr.hasNext();i++){
//              String pl=(String) itr.next();
//              otherlinks.putAll(getExtraPageLinksCrawl(pl, future, executor, i));
//              lastpage=pl;
//          }
//        try{
////          String lastvalue=lastpage.substring(lastpage.length()-2, lastpage.length()-1);
//            String lastvalue=lastpage.substring(lastpage.length()-1, lastpage.length());
//            System.out.println("~~~~~~~~"+lastvalue);
//          int index=Integer.parseInt(lastvalue);
//          for(int i=0;i<20;i++){
//              index++;
////              String temp=lastpage.replace(lastpage.substring(lastpage.length()-2, lastpage.length()), "");
////              String newpage=new StringBuilder().append(temp).append(index).append("/").toString();
//              String temp=lastpage.replace(lastvalue, "");
//              String newpage=temp+index;
//              otherlinks.putAll(getExtraPageLinksCrawl(newpage, future, executor, i));
//          }
//        }catch(Exception ex){}
//         executor.shutdown();
//         return otherlinks;
//    }
//    
//    public Map getExtraPageLinksCrawl(String newpageurl,List<Future<Map<String, String>>> future,ExecutorService executor,int i) throws InterruptedException{
//         Map<String,String> newpagelinks=new LinkedHashMap<>();
//         HttpGet httpget=new HttpGet((String)"http://www.metacafe.com"+newpageurl);
//              future=((List<Future<Map<String,String>>>) executor.invokeAll((Arrays.asList(new GetMetacafeThread(httpget, i)))));         
//              Iterator itr1=future.iterator();
//              while(itr1.hasNext()){
//                  try {
//                      Future<Map<String,String>> futur=(Future<Map<String,String>>) itr1.next();
//                      for(Map.Entry futur1:futur.get().entrySet()){   
//                            newpagelinks.put(futur1.getKey().toString(), futur1.getValue().toString());
//                   }
//                  } catch (InterruptedException | ExecutionException ex) {
//                      Logger.getLogger(MetacafePagenLinks.class.getName()).log(Level.SEVERE, null, ex);
//                      ex.printStackTrace();
//                  }
//              }
//        return newpagelinks;
//    }
}
