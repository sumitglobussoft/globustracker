/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.google;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import org.apache.http.client.methods.HttpGet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ranktracker.dao.ProxyDao;
import ranktracker.utility.FetchPagewithClientAthentication;
import ranktracker.utility.GooglePagenLinksSearch;

/**
 *
 * @author User
 */
public class GetGoogleThread implements Callable<Queue<String>> {

    private final HttpGet httpget;
    private int id;
    private int portno;
    GooglePagenLinksSearch goser;

    ProxyDao objProxyDao;
    ApplicationContext appContext;

    public GetGoogleThread(HttpGet httpget, int id, int portno) {
        this.httpget = httpget;
        this.id = id;
        this.portno = portno;
        this.goser = new GooglePagenLinksSearch();
        appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);
    }

    @Override
    public Queue<String> call() throws Exception {
        FetchPagewithClientAthentication fetchclientpage = new FetchPagewithClientAthentication();

        String responsebody = null;
        Queue<String> pagelinks = new LinkedList<>();
        try {
            System.out.println("------------------" + id + "-------------------");
            String pagename = new StringBuilder().append(Thread.currentThread().getName()).append(id) + ".txt";
            synchronized (fetchclientpage) {
                responsebody = fetchclientpage.fetchPageSourcefromClientGoogle(httpget.getURI(), pagename, portno, objProxyDao.getProxyList());
                //String mainpage = fetchclientpage.getShowPage() + "/" + pagename;
                pagelinks = goser.getGooglePageCitationLinksFromString(responsebody);
//                File f = new File(mainpage);
//                f.delete();
            }
            System.out.println("----------------------------------------");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return pagelinks;
    }
}
