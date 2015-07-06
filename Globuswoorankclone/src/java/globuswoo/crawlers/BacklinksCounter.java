/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.crawlers;

import globuswoo.entity.Commonseo;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author GLB-214
 */
public class BacklinksCounter extends Thread{

    public String backlinksCounter = "NA";
    public String backlinkUrl = "";
    public String backlink = "";
    public String mobileLoadTime = "NA";
    public String trafficEstimation = "NA";
    public Document doc;
    public String url;
    public Commonseo data;
    public String complete_url;

    BacklinksCounter() {
    }

    BacklinksCounter(Document doc, Commonseo data, String complete_url) {
        this.doc = doc;
        this.data = data;
        this.complete_url = complete_url;
    }

    @Override
    public void run() {
        try {
            getDetails(doc, data, complete_url);
        } catch (Exception e) {
        }
    }

    public void disp() {

        System.out.println("Backlinks Counter : " + backlinksCounter);
        System.out.println("Mobile Load Time : " + mobileLoadTime);
        System.out.println("Traffic Estimation : " + trafficEstimation);
    }

    public void getDetails(Document doc, Commonseo data, String complete_url) throws IOException {

        try {
            String temp[] = complete_url.replace(".", "#").split("#");
            backlinkUrl = "http://www.woorank.com/en/review/" + temp[1];
            backlink = temp[1];
        } catch (Exception e) {
        }

        if (backlinkUrl.equals("NA")) {
            return;
        }
        try {

            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy("http://www.woorank.com/en/review/" + backlink + ".com"));

            //******************Code for Backlinks Counter**********************
//            Element elebacklinks = doc1.select("div[id=criterium-backlinks_counter] div[class=criterium-content] span[class=bar] span[class=value]").first();
//            backlinksCounter = elebacklinks.text();
            //******************Code for Mobile Load Time***********************
            Element eleMobiletime = doc1.select("div[id=criterium-mobile_load_time] div[class=criterium-content] span[class=bar] span[class=value]").first();
            //System.out.println("Mobile load Time : " + eleMobiletime.text());
            mobileLoadTime = eleMobiletime.text();

            //******************Code for Traffic Estimation*********************
            Element eletraffic = doc1.select("div[id=criterium-alexa] div[class=criterium-content] span[class=bar] span[class=value]").first();
            //System.out.println("Traffic Estimation : " + eletraffic.text());
            trafficEstimation = eletraffic.text();

        } catch (Exception e) {
        }
//        data.setBacklinksCounter(backlinksCounter);
        data.setMobileLoadTime(mobileLoadTime);
        data.setTrafficEstimation(trafficEstimation);
    }

}
