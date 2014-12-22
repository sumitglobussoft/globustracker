/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.dailymotion;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpGet;
import ranktracker.utility.Dailymotion_search;
import ranktracker.utility.FetchPagewithClientAthentication;

/**
 *
 * @author User
 */
public class GetDailymotionThread implements Callable<Queue<String>> {

    private final HttpGet httpget;
    private final int id;

    public GetDailymotionThread(HttpGet httpget, int id) {
        this.httpget = httpget;
        this.id = id;
    }

    @Override
    public Queue call() throws Exception {
        FetchPagewithClientAthentication fetchsource = new FetchPagewithClientAthentication();
        Queue pagelinks = new LinkedList();
        Dailymotion_search dailymotionsearch = new Dailymotion_search();
        try {
            System.out.println(id + " about to get something from " + httpget.getURI());
            String filename = (Thread.currentThread().getName()) + ".html";
            System.out.println("------------------" + id + "-------------------");
            synchronized (dailymotionsearch) {
//                fetchsource.fetchPageSourcefromDailymotion(httpget.getURI(), filename);
                String pagepath = fetchsource.getShowPage() + "/" + filename;
                pagelinks = dailymotionsearch.getDailymotionCitationLinksCrawl(pagepath);
                File f = new File(pagepath);
                f.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagelinks;
    }
}
