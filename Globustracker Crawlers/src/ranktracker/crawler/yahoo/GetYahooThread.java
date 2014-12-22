/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.yahoo;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpGet;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.Yahoo_search;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class GetYahooThread implements Callable<Queue<String>>{
    
    private final HttpGet  httpget;
    private final int id;
    int count=0;
    int portno = 0;
    
    public GetYahooThread(HttpGet httpGet,int id,int portno) {
        this.httpget=httpGet;
        this.id=id;
        this.portno=portno;
    }
    
    @Override
    public Queue<String> call(){
        Yahoo_search yahooser=new Yahoo_search();
        FetchPagewithClientAthentication fetchsource=new FetchPagewithClientAthentication();
        Queue<String> pagelinks=new LinkedList<>();
        try{
            System.out.println(id + " about to get something from "+ httpget.getURI());
            
            System.out.println("------------------"+ id +"-------------------");
            String pagename=(Thread.currentThread().getName())+".txt";
            synchronized(yahooser){
                //fetchsource.fetchPageSourcefromClientYahoo(httpget.getURI(),pagename,portno);
                String mainpage=fetchsource.getShowPage()+"/"+pagename;
                pagelinks=yahooser.getYahooMainLinks(mainpage);
                File f=new File(mainpage);
                f.delete();
            }
            System.out.println("----------------------------------------");
        }catch(Exception e){
            e.printStackTrace();
        }
        return pagelinks;
    }

        
}
