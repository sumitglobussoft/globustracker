/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import ranktracker.crawler.metacafe.MetacafePagenLinks;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Videokeywords;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class Metacafe_search extends Thread {

    private ApplicationContext appContext;
    private List<Videokeywords> lstVideokeywords;
    private KeywordsDao objKeywordDao;
    private FetchPagewithClientAthentication fetchSourcewithAuthentication;
    String mcUrl;
    String mcKeyword;
    Integer mcKeywordId;
    private Boolean flag = false;
    int metacaferank;
    String metacafeurl;
    private boolean store = false;

    public Metacafe_search(List<Videokeywords> lstVideokeywords, ApplicationContext appContext) {
        this.appContext = appContext;
        this.lstVideokeywords = lstVideokeywords;
        this.fetchSourcewithAuthentication = appContext.getBean("fetchSourcewithAuthentication", FetchPagewithClientAthentication.class);
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
    }

    public Metacafe_search() {
    }

    public void run() {
        MetacafePagenLinks metacafepagenlinks = new MetacafePagenLinks();
        int count = 0;
        try {
            for (Videokeywords videoKeywords : lstVideokeywords) {
                store = false;
                count = 0;
                Map<String, String> mainlinks = new LinkedHashMap<>();
                Queue<String> pagenlinks = new LinkedList<>();
                Queue<String> pagenlinks2 = new LinkedList<>();

                Map<String, String> otherlinks = new LinkedHashMap<>();
                Map<String, String> pagelist = new LinkedHashMap<>();
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
                    String mainpagename = "/metacafe.txt";
                    fetchSourcewithAuthentication.fetchPageSourceFromMetacafe(uri, mainpagename);
                    String mainpagepath = fetchSourcewithAuthentication.getShowPage() + mainpagename;
                    System.out.println("mainpage = " + mainpagepath);
                    mainlinks = getMetacafePageCitationLinks(mainpagepath);
                    pagenlinks = getMetacafePaginationLinks(mainpagepath);

                    pagenlinks.poll();
                    int s = pagenlinks.size();
//                    System.out.println("s = " + s);
                    Iterator itr = pagenlinks.iterator();
                    while (itr.hasNext()) {
                        count++;
                        Object o = itr.next();
                        if (count != s) {
                            pagenlinks2.add(o.toString());
                        }
                    }
                    pagenlinks.clear();
                    otherlinks = metacafepagenlinks.getOtherMetacafePagenLinks(pagenlinks2);
                    pagelist.putAll(otherlinks);
                    Iterator itrmap = pagelist.entrySet().iterator();
                    while (itrmap.hasNext()) {
                        count++;
                        flag = false;
                        Map.Entry mapentry = (Map.Entry) itrmap.next();
                        //System.out.println("Key = "+mentry.getKey());
                        flag = findMetacafeRank(mapentry.getKey().toString(), mcUrl);
                        if (flag) {
                            metacaferank = count;
                            metacafeurl = mapentry.getValue().toString();
                            mcKeyword = mcKeyword.replace("_", " ");
                            objKeywordDao.saveMetacafeResult(mcKeywordId, mcKeyword, metacafeurl, metacaferank);
                            store = true;
                            break;
                        }
                    }
                    if (!store) {
                       
                            mcKeyword = mcKeyword.replace("_", " ");
                            objKeywordDao.saveMetacafeResult(mcKeywordId, mcKeyword, "No Link Found", 0);
                       
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getMetacafePageCitationLinks(String url) {
        Map<String, String> metacitelinks = new LinkedHashMap<>();
        try {
            File f = new File(url);
            Document doc = Jsoup.parse(f, "UTF-8");
//            Element links = doc.getElementById("Catalog1");
//            Elements links2 = links.getElementsByTag("li");
//            Elements nlinks = links2.select("article > a");
//            for (Element el2 : nlinks) {
//                String mclinks = el2.attr("href");
//                //System.out.println("Main Links "+mclinks);
//                String mctitles = el2.attr("title");
//                //System.out.println("metitles = " + mctitles);
//                metacitelinks.put(mctitles, mclinks);
//            }
//            Document doc = Jsoup.parse(pagepath);
            Elements e2 = doc.select("ul[id=Catalog1] li h1[class=ItemTitle] a");

            for (Element element : e2) {
                System.out.println("URL : " + "http://www.metacafe.com" + element.attr("href"));
                String mctitles = element.attr("href");
//                System.out.println("TITLE : " + element.text());
                String mclinks = element.text();
                metacitelinks.put(mctitles, mclinks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return metacitelinks;

    }

    public Queue<String> getMetacafePaginationLinks(String url) {
        Queue<String> othpagenlinks = new LinkedList<>();
        try {
            File f = new File(url);
            Document doc = Jsoup.parse(f, "UTF-8");
            Elements plinks = doc.select("div[id=CatalogPageSelector]");
            Elements pagenlinks = plinks.select("ul li[id=Next] a[href]");
            for (Element el1 : pagenlinks) {
                String pilinks = el1.attr("href");
                System.out.println("Pagenation Links : " + "http://www.metacafe.com" + pilinks);
                othpagenlinks.add(pilinks);
                System.out.println("====================================================================================================================================");
//                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return othpagenlinks;
    }

    public Boolean findMetacafeRank(String title, String domainurl) throws MalformedURLException {
        Boolean fod = false;
        if (domainurl.contains(title)) {
            fod = true;
        }
        return fod;
    }
}
