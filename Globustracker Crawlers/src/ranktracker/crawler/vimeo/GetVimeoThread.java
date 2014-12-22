/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.vimeo;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpGet;
import ranktracker.utility.FetchPageBodySource;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.Vimeo_search;

/**
 *
 * @author User
 */
public class GetVimeoThread implements Callable<Queue<String>>{
    private final HttpGet  httpget;
    private final int id;
    FetchPagewithClientAthentication fetchclientpage;

    public GetVimeoThread(HttpGet httpget, int id,FetchPagewithClientAthentication fetchclientpage) {
        this.httpget = httpget;
        this.id = id;
        this.fetchclientpage = fetchclientpage;
    }
    
     @Override
    public Queue<String> call() throws Exception {
        FetchPageBodySource fetchsource=new FetchPageBodySource();
        Queue<String> pagelinks=new LinkedList<>();
        Vimeo_search yousearch=new Vimeo_search();
        Boolean flag=false;
        try{
            if(flag){
                return pagelinks;
            }
            System.out.println(id + " about to get something from "+ httpget.getURI());
//            String responsebody=fetchsource.getPageSource(httpget.getURI().toString());
            System.out.println("------------------"+ id +"-------------------");
            String filename=(Thread.currentThread().getName())+".html";
            synchronized(yousearch){
//               fetchclientpage.fetchPageSourcefromVimeo(httpget.getURI(), filename);
//              fetchsource.writeResponseFile(responsebody, filename);
                String pagepath=fetchsource.getShowPage()+"/"+filename;
                pagelinks=yousearch.getVimeoPageCitationLinks(pagepath);
                File f=new File(pagepath);
                f.delete();
            }
        }catch(Exception e){
            e.printStackTrace();
            flag = true;
            return pagelinks;
        }
        return pagelinks;
    }
}
