/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.utility;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import ranktracker.entity.Serpkeywords;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
@Repository("googleSearch")
public class Google_search implements Runnable {

    private List<Serpkeywords> lstKeywords;
    ApplicationContext appContext;
    String goUrl;
    String goKeyword;
    String goLinkGoogle;
    int goKeywordID;
    Boolean found = false;
    String bestMatchLinkGoogle = null;

    public Google_search() {
    }

    public Google_search(ApplicationContext appContext, List<Serpkeywords> lstKeywords) {
        this.appContext = appContext;
        this.lstKeywords = lstKeywords;
    }

    @Override
    public void run() {
        //int keywordcount = lstKeywords.size();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //This loop selects one keyword at a moment

//        Stack<Serpkeywords> lstKeywordsStack = new Stack<>();
//        for (Serpkeywords serpkeywords : lstKeywords) {
//            lstKeywordsStack.push(serpkeywords);
//        }
        
        Iterator googleitr = lstKeywords.iterator();
        while(googleitr.hasNext()){
        //while (!lstKeywordsStack.empty()) {
            try {
                Serpkeywords k =(Serpkeywords) googleitr.next();
                goUrl = k.getUrl();
                goKeyword = k.getKeyword();
                goLinkGoogle = "www." + k.getLinkGoogle();
                goKeywordID = k.getKeywordID();
                Runnable worker = new GooglePagenLinksSearch(goUrl, goKeyword, goLinkGoogle, goKeywordID, appContext);
//                Thread worker = new Thread(new GooglePagenLinksSearch(goUrl, goKeyword, goLinkGoogle, goKeywordID, appContext));
//                worker.start();
//                worker.join();

                executor.execute(worker);
            } 
            // catch (InterruptedException ex) {
            catch (Exception ex) {
                Logger.getLogger(Google_search.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            
        }
         executor.shutdown();
            try {
                executor.awaitTermination(10, TimeUnit.MINUTES);
            } catch (InterruptedException ex) {
                Logger.getLogger(Google_search.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public Queue<String> getGooglePageCitationLinks(String url) {
        Queue<String> mainlinks = new LinkedList<>();
        try {
            File f = new File(url);
            Document doc = Jsoup.parse(f, "UTF-8");
            Element links = doc.getElementById("ires");
            Elements links2 = links.getElementsByTag("li");
            Elements nlinks = links2.select("h3.r > a");
            for (Element el2 : nlinks) {
                String golinks = el2.attr("href");
                //System.out.println("Main Links "+golinks);
                mainlinks.add(golinks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mainlinks;
    }
    
    public Queue<String> getGooglePagenationLinks(String url) {
        Queue<String> othpagenlinks = new LinkedList<>();
        try {
            File f = new File(url);
            Document doc = Jsoup.parse(f, "UTF-8");
            Element plinks = doc.getElementById("foot");
            Elements pagenlinks = plinks.select("a[href]");
            for (Element el1 : pagenlinks) {
                String pilinks = el1.attr("href");
                if (pilinks.contains("/search?")) {
                    //       System.out.println("Pagenation Links" + pilinks);
                    othpagenlinks.add(pilinks);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return othpagenlinks;
    }
   
}
