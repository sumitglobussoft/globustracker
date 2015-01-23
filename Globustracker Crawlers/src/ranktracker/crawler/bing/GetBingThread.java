/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.bing;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpGet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ranktracker.dao.ProxyDao;
import ranktracker.utility.Bing_search;
import ranktracker.utility.FetchPagewithClientAthentication;

/**
 *
 * @author User
 */
public class GetBingThread implements Callable<Queue<String>> {

    private final HttpGet httpget;
    private final int id;
    int count = 0;
    int newWebRankGoogle;
    int bestMatchRankGoogle;
    String bestMatchLinkGoogle;
    String bnKeyword;
    int portNo;
    ProxyDao objProxyDao;
    ApplicationContext appContext;

    public GetBingThread(HttpGet httpget, int id, String bnKeyword, int portNo) {
        this.httpget = httpget;
        this.id = id;
        this.bnKeyword = bnKeyword;
        this.portNo = portNo;
        appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    @Override
    public Queue<String> call() throws Exception {
        FetchPagewithClientAthentication fetchpagewithclient = new FetchPagewithClientAthentication();
        Bing_search bingser = new Bing_search();
        Queue<String> pagelinks = new LinkedList<>();
        try {
            System.out.println("------------------" + id + "-------------------");
            String responseBody;
            String pagename = new StringBuilder().append(Thread.currentThread().getName()).append(id) + ".txt";
            synchronized (bingser) {
                responseBody = fetchpagewithclient.fetchPageSourcefromClientBing(httpget.getURI(), pagename, portNo, objProxyDao.getProxyList());
                String mainpage = fetchpagewithclient.getShowPage() + "/" + pagename;
                pagelinks = bingser.getBingMainLinks(responseBody, bnKeyword);
//                File f = new File(mainpage);
//                f.delete();
            }
            System.out.println("----------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagelinks;
    }
}
