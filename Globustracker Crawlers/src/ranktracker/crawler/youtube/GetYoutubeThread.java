/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.youtube;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpGet;
import ranktracker.utility.FetchPageBodySource;
import ranktracker.utility.Youtube_search;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class GetYoutubeThread implements Callable<Map<String, String>> {
    private final HttpGet  httpget;
    private final int id;

    public GetYoutubeThread(HttpGet httpget, int id) {
        this.httpget = httpget;
        this.id = id;
    }
    
    @Override
    public Map<String, String> call() throws Exception {
        FetchPageBodySource fetchsource=new FetchPageBodySource();
        Map<String,String> pagelinks=new LinkedHashMap<>();
        Youtube_search yousearch=new Youtube_search();
        try{
            System.out.println(id + " about to get something from "+ httpget.getURI());
            String responsebody=fetchsource.getPageSource(httpget.getURI().toString());
            System.out.println("------------------"+ id +"-------------------");
            String filename=(Thread.currentThread().getName())+".txt";
            synchronized(yousearch){
            fetchsource.writeResponseFile(responsebody, filename);
            String pagepath=fetchsource.getShowPage()+"/"+filename;
            pagelinks=yousearch.getYoutubePageCitationLinks(pagepath);
            File f=new File(pagepath);
            f.delete();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return pagelinks;
    }
    
}
