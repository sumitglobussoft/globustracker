/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.dailymotion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
public class DailymotionPagenLinks {

    public Queue getOtherDailymotionPageLinksCrawl(Queue pagenlinks, String dmUrl) throws IOException, InterruptedException {
        Boolean matchfound = false;
        Queue otherlinks = new LinkedList();
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Queue<String>>> future = new ArrayList<>();
        Queue pagelist = pagenlinks;
        String lastpage = null;
        Iterator itr = pagelist.iterator();
        for (int i = 0; itr.hasNext(); i++) {
            String pl = (String) itr.next();
            otherlinks.addAll(getExtraPageLinksCrawl(pl, future, executor, i));
            lastpage = pl;
        }
        matchfound = findSingleLink(otherlinks, dmUrl);
        if (!matchfound) {
            String lastvalue = lastpage.substring(lastpage.length() - 1, lastpage.length());
            int index = Integer.parseInt(lastvalue);
            for (int i = 0; i < 22; i++) {
                index++;
                String temp = lastpage.replace(lastvalue, "");
                String newpage = temp + index;
                System.out.println("newpage = " + newpage);
                otherlinks.addAll(getExtraPageLinksCrawl(newpage, future, executor, i));
            }
        }
        executor.shutdown();
        return otherlinks;
    }

    public Queue getExtraPageLinksCrawl(String newpageurl, List<Future<Queue<String>>> future, ExecutorService executor, int i) throws IOException, InterruptedException {
        Queue newpagelinks = new LinkedList();
        HttpGet httpget = new HttpGet((String) "http://www.dailymotion.com" + newpageurl);
        future = ((List<Future<Queue<String>>>) executor.invokeAll((Arrays.asList(new GetDailymotionThread(httpget, i)))));
        Iterator itr1 = future.iterator();
        while (itr1.hasNext()) {
            try {
                Future<Queue<String>> futur = (Future<Queue<String>>) itr1.next();
                for (String futur1 : futur.get()) {
                    newpagelinks.add(futur1);
                }
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(DailymotionPagenLinks.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return newpagelinks;
    }

    public Boolean findSingleLink(Queue links, String url) {
        int count = 0;
        Boolean store = false;
        Boolean flag = false;
        Iterator itrmap = links.iterator();
        while (itrmap.hasNext()) {
            String str = itrmap.next().toString();
            count++;
            flag = findDailymotionLink(str, url);
            store = false;
            if (flag) {
                store = true;
                break;
            }
        }
        return store;
    }

    public Boolean findDailymotionLink(String link, String dmUrl) {
        Boolean fod = false;
        try {
            if (dmUrl.contains(link) || link.contains(dmUrl)) {
                fod = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fod;
    }
}
