/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.crawlers;

import globuswoo.entity.Commonseo;
import java.io.IOException;
import org.jsoup.nodes.Document;

/**
 *
 * @author GLB-214
 */
public class ScoreValue {

    public String scoreValue = "NA";

    public void Display() {
        System.out.println("SCORE VALUE :  " + scoreValue);
    }

    public void getDetails(Document doc, Commonseo data, String complete_url) throws IOException {

        try {
            String s = "" + complete_url.replace("http://www.", "");
            System.out.println("-------------------------------------"+s);
            String url = "http://www.woorank.com/en/review/" + s;
            System.out.println("----------------------------+"+url);
//            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy(url));
//            Element score = doc1.select("div[id=score-regular] span[id=score-value]").first();
//            System.out.println("Score Value : " + score.text());
//            scoreValue = score.text();
        } catch (Exception e) {
        }
        
//        data.setScoreValue(scoreValue);
    }

}
