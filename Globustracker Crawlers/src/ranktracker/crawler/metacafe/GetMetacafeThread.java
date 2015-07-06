/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.metacafe;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpGet;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.Metacafe_search;

/**
 *
 * @author User
 */
public class GetMetacafeThread implements Callable<Map<String, String>> {
    private final HttpGet  httpget;
    private final int id;

    public GetMetacafeThread(HttpGet httpget, int id) {
        this.httpget = httpget;
        this.id = id;
    }

    @Override
    public Map<String, String> call() throws Exception {
        FetchPagewithClientAthentication fetchclientpage=new FetchPagewithClientAthentication();
        Map<String,String> pagelinks=new LinkedHashMap<>();
        Metacafe_search metasearch=new Metacafe_search();
        String pagepath=null;
        try{
            System.out.println(id + " about to get something from "+ httpget.getURI());
            System.out.println("------------------"+ id +"-------------------");
            String filename=(Thread.currentThread().getName())+".txt";
            //fetchclientpage.fetchPageSourceFromMetacafe(httpget.getURI(),filename);
            synchronized(metasearch){
            pagelinks=metasearch.getMetacafePageCitationLinks(pagepath);
            File f=new File(pagepath);
            f.delete();
            }
            System.out.println("----------------------------------------");
        }catch(Exception e){
            e.printStackTrace();
        }
        return pagelinks;
    }
    
}
