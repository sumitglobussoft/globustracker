/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.metacafe;

import java.util.ArrayList;
import java.util.Arrays;
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
 * @author User
 */
public class MetacafePagenLinks {
        public Map getOtherMetacafePagenLinks(Queue pagenLinks) throws InterruptedException{
        Map<String,String> otherlinks=new LinkedHashMap<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Map<String, String>>> future=new ArrayList<>();
        Queue pagelist=pagenLinks;
        String lastpage=null;
          Iterator itr=pagelist.iterator();
          for(int i=0;itr.hasNext();i++){
              String pl=(String) itr.next();
              otherlinks.putAll(getExtraPageLinksCrawl(pl, future, executor, i));
              lastpage=pl;
          }
        try{
//          String lastvalue=lastpage.substring(lastpage.length()-2, lastpage.length()-1);
            String lastvalue=lastpage.substring(lastpage.length()-1, lastpage.length());
            System.out.println("~~~~~~~~"+lastvalue);
          int index=Integer.parseInt(lastvalue);
          for(int i=0;i<20;i++){
              index++;
//              String temp=lastpage.replace(lastpage.substring(lastpage.length()-2, lastpage.length()), "");
//              String newpage=new StringBuilder().append(temp).append(index).append("/").toString();
              String temp=lastpage.replace(lastvalue, "");
              String newpage=temp+index;
              otherlinks.putAll(getExtraPageLinksCrawl(newpage, future, executor, i));
          }
        }catch(Exception ex){}
         executor.shutdown();
         return otherlinks;
    }
    
    public Map getExtraPageLinksCrawl(String newpageurl,List<Future<Map<String, String>>> future,ExecutorService executor,int i) throws InterruptedException{
         Map<String,String> newpagelinks=new LinkedHashMap<>();
         HttpGet httpget=new HttpGet((String)"http://www.metacafe.com"+newpageurl);
              future=((List<Future<Map<String,String>>>) executor.invokeAll((Arrays.asList(new GetMetacafeThread(httpget, i)))));         
              Iterator itr1=future.iterator();
              while(itr1.hasNext()){
                  try {
                      Future<Map<String,String>> futur=(Future<Map<String,String>>) itr1.next();
                      for(Map.Entry futur1:futur.get().entrySet()){   
                            newpagelinks.put(futur1.getKey().toString(), futur1.getValue().toString());
                   }
                  } catch (InterruptedException | ExecutionException ex) {
                      Logger.getLogger(MetacafePagenLinks.class.getName()).log(Level.SEVERE, null, ex);
                      ex.printStackTrace();
                  }
              }
        return newpagelinks;
    }
}
