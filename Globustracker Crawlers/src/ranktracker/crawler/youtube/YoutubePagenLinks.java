/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.youtube;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpGet;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
public class YoutubePagenLinks {

    public YoutubePagenLinks() {
    }
    
    public  Map getOtherYoutubePageLinksCrawl(Queue pagenLinks)throws IOException, InterruptedException{
        Map<String,String> otherlinks=new LinkedHashMap<>();
        ExecutorService executor=Executors.newCachedThreadPool();
        List<Future<Map<String, String>>> future=new ArrayList<>();
        Queue pagelist=pagenLinks;
        String lastpage=null;
          Iterator itr=pagelist.iterator();
          for(int i=0;itr.hasNext();i++){
              String pl=(String) itr.next();
              otherlinks.putAll(getExtraPageLinksCrawl(pl, future, executor, i));
              lastpage=pl;
          }
          
          String lastvalue=lastpage.substring(lastpage.length()-1, lastpage.length());
          int index=Integer.parseInt(lastvalue);
          for(int i=0;i<10;i++){
              index++;
              String temp=lastpage.replace(lastvalue, "");
              String newpage=temp+index;
              //System.out.println("newpage = " + newpage);
              otherlinks.putAll(getExtraPageLinksCrawl(newpage, future, executor, i));
          }
        executor.shutdown();
        return otherlinks;
    }
    public  Map getExtraPageLinksCrawl(String newpageurl,List<Future<Map<String, String>>> future,ExecutorService executor,int i)throws IOException, InterruptedException{
        Map<String,String> newpagelinks=new LinkedHashMap<>();
        HttpGet httpget=new HttpGet((String)"http://www.youtube.com"+newpageurl);
              future=((List<Future<Map<String,String>>>) executor.invokeAll((Arrays.asList(new GetYoutubeThread(httpget, i)))));         
              Iterator itr1=future.iterator();
              while(itr1.hasNext()){
                  try {
                      Future<Map<String,String>> futur=(Future<Map<String,String>>) itr1.next();
                      for(Map.Entry futur1:futur.get().entrySet()){   
                            newpagelinks.put(futur1.getKey().toString(), futur1.getValue().toString());
                   }
                  } catch (InterruptedException | ExecutionException ex) {
                      Logger.getLogger(YoutubePagenLinks.class.getName()).log(Level.SEVERE, null, ex);
                      ex.printStackTrace();
                  }
              }
        return newpagelinks;
    }
}
