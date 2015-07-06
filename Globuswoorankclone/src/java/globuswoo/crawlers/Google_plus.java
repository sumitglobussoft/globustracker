package globuswoo.crawlers;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Google_plus extends Thread {

    public String URL = "NA";
    public String Name = "NA";
    public String Verified = "NA";
    public String Image = "NA";
    public String Tagline = "NA";
    public String Introduction = "NA";
    public String Company_Overview = "NA";
    public String googleFollower = "NA";
    public String googleViews = "NA";
    String url;

    public void setDetails(String url) throws IOException {

        String purl = url.replace("//", "");
        purl = purl.replace(":", "");
        purl = purl.replace(".", "#");
        String temp[] = purl.split("#");

        try {
            Name = "" + temp[1];
            System.out.println("Name : " + Name);
        } catch (Exception ex) {
        }
        Verified = "Yes";

        about();

    }

    public void about() throws IOException {
        try {
            String url = "https://plus.google.com/+" + Name + "/about";
//            System.out.println("URL" + url);
            URL = "" + url;
            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRank(url));

            //**********************Code For Image*****************************************
            try {
                Elements e1 = doc1.select("div[class=xLa Wza] img");//.first();
                Element e2 = e1.select("img").first();
//             System.out.println("Image : " + e1.attr("src"));
                Image = "" + e2.attr("src");
            } catch (Exception e) {
            }

//****************************Code For Tagline**********************************
            try {
                Element e3 = doc1.select("div[class=Uia] div[class=Ohb Iqc] div[class=wna Phb] div[class=y4]").first();
//            System.out.println("Tagline : " + e3.text());
                Tagline = "" + e3.text();
            } catch (Exception e) {
            }

//*************************Code For Introduction********************************
            try {
                Element e4 = doc1.select("div[class=wna xRb] div[class=y4] div").first();
//             System.out.println("Introduction : " + e4.text());
                Introduction = "" + e4.text();
            } catch (Exception e) {
            }

//***************************Code For Company Overview**************************
            try {
                Element e6 = doc1.select("div[class=wna xRb] div[class=y4] div div").get(1);
//             System.out.println("Company Overview : " + e6.text());
                Company_Overview = "" + e6.text();
            } catch (Exception e) {
            }

            try {
                Element e7 = doc1.select("div[class=O9a s5a] div[class=Zmjtc] span[class=BOfSxb]").first();
//                System.out.println("Google Follower : " + e7.text());
                googleFollower = "" + e7.text();
            } catch (Exception e) {
            }

            try {
                Element e8 = doc1.select("div[class=O9a s5a] div[class=Zmjtc] span[class=BOfSxb]").get(1);
//                System.out.println("Google Views : " + e8.text());
                googleViews = "" + e8.text();
            } catch (Exception e) {
            }

        } catch (IOException e) {
        }
    }
}
