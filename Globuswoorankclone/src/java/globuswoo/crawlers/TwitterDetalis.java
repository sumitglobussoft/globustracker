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
import org.jsoup.select.Elements;

/**
 *
 * @author GLB-214
 */
public class TwitterDetalis extends Thread{

    public String twittername = "NA";
    public String twitterimage = "NA";
    public String twittercount = "NA";
    public String twitterfolowing = "NA";
    public String twitterfolowrs = "NA";
    public String twitterdescrip = "NA";
    public String twitterlocation = "NA";
    public String twitterList = "NA";
    public String twitterfavorites = "NA";
    public String twitterdate = "NA";
    public String twitterUrl = "NA";

    public Document doc;
    public String url;
    public Commonseo data;
    public String complete_url;

    TwitterDetalis() {
    }

    TwitterDetalis(Document doc, Commonseo data, String complete_url) {
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

    public void displaytwt() {
        System.out.println("TWITTER NAME : " + twittername);
        System.out.println("TWITTER IMAGE : " + twitterimage);
        System.out.println("TWITTER COUNT : " + twittercount);
        System.out.println("TWITTER FOLLOWING : " + twitterfolowing);
        System.out.println("TWITTER FOLLOWERS : " + twitterfolowrs);
        System.out.println("TWITTER DESCRIPTION : " + twitterdescrip);
        System.out.println("TWITTER LOCATION : " + twitterlocation);
        System.out.println("TWITTER List : " + twitterList);
        System.out.println("TWITTER FAVORITES : " + twitterfavorites);
        System.out.println("TWITTER DATE :" + twitterdate);

    }

    public void getDetails(Document doc, Commonseo data, String complete_url) throws IOException {
//    public void getDetails(String complete_url) throws IOException {

        try {
            String temp[] = complete_url.replace(".", "#").split("#");
            twitterUrl = "https://www.twitter.com/" + temp[1];
            twittername = temp[1];

        } catch (Exception e) {
        }

        if (twitterUrl.equals("NA")) {
            return;
        }

        try {
//            String url = "https://twitter.com/amazon";
            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRank("https://www.twitter.com/" + twittername));
//        System.out.println(doc);

            try {
                Element twtname = doc1.select("div[class=ProfileHeaderCard] a").first();
                System.out.println("1. Twitter Name : " + twtname.text());
                twittername = twtname.text();
            } catch (Exception e) {
            }

            try {
                Element twtimg = doc1.select("div[class=ProfileCanopy-inner] img").first();
                System.out.println("2. Twitter Image : " + twtimg.attr("src"));
                twitterimage = twtimg.attr("src");
            } catch (Exception e) {
            }

            try {
                Element twtcount = doc1.select("div[class=ProfileCanopy-nav] span[class=ProfileNav-value]").first();
                System.out.println("3. Twitter Count : " + twtcount.text());
                twittercount = twtcount.text();
            } catch (Exception e) {
            }

            try {
                Element twtfollow = doc1.select("li[class=ProfileNav-item ProfileNav-item--following] span[class=ProfileNav-value]").first();
                System.out.println("4. Twitter Following : " + twtfollow.text());
                twitterfolowing = twtfollow.text();
            } catch (Exception e) {
            }

            try {
                Element twtfoller = doc1.select("li[class=ProfileNav-item ProfileNav-item--followers] span[class=ProfileNav-value]").first();
                System.out.println("5. Twitter Followers : " + twtfoller.text());
                twitterfolowrs = twtfoller.text();
            } catch (Exception e) {
            }

            try {
                Element twtdescp = doc1.select("p[class=ProfileHeaderCard-bio u-dir]").first();
                System.out.println("6. Twitter Description : " + twtdescp.text());
                twitterdescrip = twtdescp.text();
            } catch (Exception e) {
            }

            try {
                Elements twtloc = doc1.select("div[class=ProfileHeaderCard-location] span[class=ProfileHeaderCard-locationText u-dir]");
                System.out.println("7. Twitter Location : " + twtloc.text());
                twitterlocation = twtloc.text();
            } catch (Exception e) {
            }

            try {
                Elements twtweburl = doc1.select("li[class=ProfileNav-item ProfileNav-item--lists] span[class=ProfileNav-value]");
                System.out.println("8. Twitter Lists : " + twtweburl.text());
                twitterList = twtweburl.text();
            } catch (Exception e) {
            }

            try {
                Elements twtfavorit = doc1.select("li[class=ProfileNav-item ProfileNav-item--favorites] span[class=ProfileNav-value]");
                System.out.println("9. Twitter Favorities : " + twtfavorit.text());
                twitterfavorites = twtfavorit.text();
            } catch (Exception e) {
            }

            try {
                Elements twtdate = doc1.select("div[class=ProfileHeaderCard-joinDate] span[class=ProfileHeaderCard-joinDateText js-tooltip u-dir]");
                System.out.println("10. Twitter Joineddate : " + twtdate.text());
                twitterdate = twtdate.text();
            } catch (Exception e) {
            }
            data.setTwitterUrl(twitterUrl);
            data.setTwitterName(twittername);
            data.setTwitterImage(twitterimage);
            data.setTwitterCount(twittercount);
            data.setTwitterFollowing(twitterfolowing);
            data.setTwitterFollower(twitterfolowrs);
            data.setTwitterDescription(twitterdescrip);
            data.setTwitterLocation(twitterlocation);
            data.setTwitterList(twitterList);
            data.setTwitterFavourites(twitterfavorites);
            data.setTwitterDate(twitterdate);

        } catch (Exception e) {
        }
    }
}
