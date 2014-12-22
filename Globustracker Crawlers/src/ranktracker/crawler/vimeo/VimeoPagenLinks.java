/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.vimeo;

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
import ranktracker.utility.FetchPagewithClientAthentication;

/**
 *
 * @author User
 */
public class VimeoPagenLinks {

    FetchPagewithClientAthentication fetchclientpage;
    String vimUrl;

    public VimeoPagenLinks(FetchPagewithClientAthentication fetchclientpage) {
        this.fetchclientpage = fetchclientpage;
    }

    public Queue<String> getOtherVimeoPageLinksCrawl(Queue<String> pagenLinks, String vimUrl) throws IOException, InterruptedException {
        Boolean matchfound = false;
        //Vimeo_search vimsearch = new Vimeo_search();
        Queue<String> otherlinks = new LinkedList<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Queue<String>>> future = new ArrayList<>();
//      /search/page:6/sort:relevant/format:thumbnail?q=superman+hero
        String firstpage = pagenLinks.element();
        String[] pageincut = firstpage.split("page:");
        String secondpageincut = pageincut[1].substring(1, pageincut[1].length());
        String stringb = null;
        for (int i = 2; i < 10; i++) {
            stringb = new StringBuilder().append(pageincut[0]).append("page:").append(i).append(secondpageincut).toString();
            otherlinks.addAll(getExtraPageLinksCrawl(stringb, future, executor, i));
        }
        matchfound = findSingleLink(otherlinks);
        if (!matchfound) {
            for (int i = 11; i < 20; i++) {
                stringb = new StringBuilder().append(pageincut[0]).append("page:").append(i).append(secondpageincut).toString();
                otherlinks.addAll(getExtraPageLinksCrawl(stringb, future, executor, i));
            }
        }
        executor.shutdown();
        return otherlinks;
    }

    public Queue<String> getExtraPageLinksCrawl(String newpageurl, List<Future<Queue<String>>> future, ExecutorService executor, int i) throws IOException, InterruptedException {
        Queue<String> newpagelinks = new LinkedList<>();
        HttpGet httpget = new HttpGet((String) "http://vimeo.com" + newpageurl);
        future = ((List<Future<Queue<String>>>) executor.invokeAll((Arrays.asList(new GetVimeoThread(httpget, i, fetchclientpage)))));
        if (future.isEmpty()) {
            return newpagelinks;
        }
        Iterator itr1 = future.iterator();
        while (itr1.hasNext()) {
            try {
                Future<Queue<String>> futur = (Future<Queue<String>>) itr1.next();
                for (String futur1 : futur.get()) {
                    newpagelinks.add(futur1);
                }
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(GetVimeoThread.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
                return newpagelinks;
            }
        }
        return newpagelinks;
    }

    public Boolean findSingleLink(Queue links) {
        int count = 0;
        Boolean store = false;
        Boolean flag = false;
        Iterator itrmap = links.iterator();
        while (itrmap.hasNext()) {
            //flag=false;
            String mentry = itrmap.next().toString();
            count++;
            flag = findVimeoLink(mentry, vimUrl);
            store = false;
            if (flag) {
                store = true;
                break;
            }
        }
        return store;
    }

    public Boolean findVimeoLink(String link, String vimUrl) {
        Boolean fod = false;
        try {
            if (vimUrl.contains(link) || link.contains(vimUrl)) {
                fod = true;
            }
        } catch (Exception e) {
        }
        return fod;
    }
}
