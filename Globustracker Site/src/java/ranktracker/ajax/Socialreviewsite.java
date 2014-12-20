/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.ajax;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *This class is responsible of giving http request to crawler server
 * to crawl the data and put the data in database of site server
 * 
 * @Laxmi Kiran Nallam
 */
public class Socialreviewsite implements Runnable {

    String websitename;
    ApplicationContext appcontext = new ClassPathXmlApplicationContext("applicationContext.xml");

    public Socialreviewsite(String websitename) {
        this.websitename = websitename;
    }

    @Override
    public void run() {
        try {
            //http://50.116.17.193:8080/Globuswooclonecrawler/Reviewsite?websitename=india.gov.in
            
            Keywordsuggestion keysuggestion = appcontext.getBean("keywordsuggestion", Keywordsuggestion.class);
            URI newuri = new URIBuilder()
                    .setScheme("http")
                    .setHost("50.116.17.193:8080")
                    .setPath("/Globuswooclonecrawler/Reviewsite")
                    .setParameter("websitename", websitename)
                    .build();
            System.out.println("newuri = " + newuri);
            keysuggestion.fetchXMLContent(newuri);
        } catch (IOException |URISyntaxException ex) {
            Logger.getLogger(Socialreviewsite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
