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
public class Pinterest extends Thread {

    public String pInterestBoards = "NA";
    public String pInterestPins = "NA";
    public String pInterestLikes = "NA";
    public String pInterestFollower = "NA";
    public String pInterestFollowing = "NA";
    public String pInterestImage = "NA";
    public String pInterestName = "NA";
    public String pInterestDescription = "NA";
    public Commonseo data;
    public String complete_url;

    Pinterest() {
    }

    Pinterest(Commonseo data, String complete_url) {

        this.data = data;
        this.complete_url = complete_url;
    }

    @Override
    public void run() {
        try {
            setBusinessUrl(data, complete_url);
        } catch (Exception e) {
        }
    }

    public void setBusinessUrl(Commonseo data, String complete_url) throws IOException {

        try {
            System.out.println("   " + complete_url.replace(".com", ""));
            String url = complete_url.replace("http://www.", "").replace(".com", "");
            String googlestring = "https://www.google.com/search?q=" + url + "pinterest";
            System.out.println("    -- Google review Url: " + googlestring);
            Document doc = Jsoup.parse(Crawler.fetchGooglePageRank(googlestring));
            Element e1 = doc.select("div[class=s] div[class=kv] cite").first();
            System.out.println(" pinteresturl : " + e1.text());
            String pinteresturl = e1.text();
            getDetails(pinteresturl, data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getDetails(String pinteresturl, Commonseo data) throws IOException {
        try {
            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy(pinteresturl));

            try {
                Element eboard = doc1.select("div[class=tabs] ul li div[class=Module BoardCount] span[class=value]").first();
                pInterestBoards = eboard.text();
                System.out.println("1. Pinterest Boards : " + pInterestBoards);
            } catch (Exception e) {
            }

            try {
                Element epins = doc1.select("li span[class=value]").get(1);
                pInterestPins = epins.text();
                System.out.println("2. Pinterest Pins : " + pInterestPins);
            } catch (Exception e) {
            }

            try {
                Element elikes = doc1.select("li span[class=value]").get(2);
                pInterestLikes = elikes.text();
                System.out.println("3. Pinterest Likes : " + pInterestLikes);
            } catch (Exception e) {
            }

            try {
                Element efollower = doc1.select("li span[class=value]").get(3);
                pInterestFollower = efollower.text();
                System.out.println("4. Pinterest Follower : " + pInterestFollower);
            } catch (Exception e) {
            }

            try {
                Element efollowing = doc1.select("li span[class=value]").get(4);
                pInterestFollowing = efollowing.text();
                System.out.println("5. Pinterest Following : " + pInterestFollowing);
            } catch (Exception e) {
            }

            try {
                Element eprofile = doc1.select("div[class=profileImage] img").first();
                pInterestImage = eprofile.attr("src");
                System.out.println("6. Pinterest Image : " + pInterestImage);
            } catch (Exception e) {
            }

            try {
                Element ename = doc1.select("div[class=name]").first();
                pInterestName = ename.text();
                System.out.println("7. Pinterest Name : " + pInterestName);
            } catch (Exception e) {
            }

            try {
                Element edescription = doc1.select("div[class=about] p[class=aboutText]").first();
                pInterestDescription = edescription.text();
                System.out.println("8. Pinterest Description : " + pInterestDescription);
            } catch (Exception e) {
            }
            data.setPInterestBoards(pInterestBoards);
            data.setPInterestPins(pInterestPins);
            data.setPInterestLikes(pInterestLikes);
            data.setPInterestFollower(pInterestFollower);
            data.setPInterestFollowing(pInterestFollowing);
            data.setPInterestName(pInterestName);
            data.setPInterestImage(pInterestImage);
            data.setPInterestDescription(pInterestDescription);

        } catch (Exception e) {
        }
    }
}
