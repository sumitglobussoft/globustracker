package globuswoo.crawlers;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import globuswoo.entity.Commonseo;
import org.json.JSONObject;

public class FacebookStructure extends Thread {

    public String facebook_url = "NA";
    public String facebook_name = "NA";
    public String facebook_likes = "NA";
    public String facebook_about = "NA";
    public String facebook_image = "NA";
    public String facebook_overview = "NA";
    public String facebook_products = "NA";
    public String facebook_address = "NA";
    public String talking_about_count = "";
    public String facebook_phone = "NA";
    public String facebook_mission = "NA";
    public String facebookDescription = "NA";

    Document doc;
    String url;
    static Commonseo data;

    public void disp() {
        System.out.println("URL: " + facebook_url);
        System.out.println("NAME: " + facebook_name);
        System.out.println("LIKES: " + facebook_likes);
        System.out.println("IMAGE: " + facebook_image);
        System.out.println("ABOUT: " + facebook_about);
        System.out.println("OVERVIEW: " + facebook_overview);
        System.out.println("PRODUCTS: " + facebook_products);
        System.out.println("ADDRESS: " + facebook_address);
        System.out.println("TALKING ABOUT: " + talking_about_count);
        System.out.println("PHONE NO :" + facebook_phone);
        System.out.println("MISSION : " + facebook_mission);
        System.out.println("DESCRIPTION : " + facebookDescription);

    }

    public void getDetails(Document doc, Commonseo data, String complete_url) throws IOException {
        try {
            String temp[] = complete_url.replace(".", "#").split("#");
            // System.out.println(""+temp[1]);
            facebook_url = "https://www.facebook.com/" + temp[1];
            facebook_name = temp[1];
//            System.out.println("========================================" + facebook_name);

        } catch (Exception e) {
        }

        if (facebook_url.equals("NA")) {
            return;
        }

        try {
            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRank("http://graph.facebook.com/" + facebook_name));
            JSONObject obj = new JSONObject(doc1.text());

            try {
                facebook_products = obj.getString("products");
//                System.out.println("facebook_products  " + facebook_products);
            } catch (Exception e) {
            }

            try {
                facebookDescription = obj.getString("description");
//                System.out.println("description "+ facebookDescription);
            } catch (Exception e) {
            }

            try {
                facebook_overview = obj.getString("company_overview");
//                System.out.println("company_overview " + facebook_overview);
            } catch (Exception e) {
            }

            try {
                facebook_image = obj.getJSONObject("cover").getString("source");
//                System.out.println("facebook_image " + facebook_image);
            } catch (Exception e) {
            }

            try {
                facebook_address = obj.getJSONObject("location").getString("street") + "," + obj.getJSONObject("location").getString("city") + ", " + obj.getJSONObject("location").getString("country");
//                System.out.println("facebook_address" + facebook_address);
            } catch (Exception e) {
            }

            try {
                facebook_phone = obj.getString("phone");
//                System.out.println("facebook_phone" + facebook_phone);
            } catch (Exception e) {
            }

            try {
                facebook_mission = obj.getString("mission");
//                System.out.println("facebook_mission" + facebook_mission);
            } catch (Exception e) {
            }

            try {
                facebook_about = obj.getString("about");
//                System.out.println("facebook_about" + facebook_about);
            } catch (Exception e) {
            }

            String temp[] = doc1.text().split(",");
            try {
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].contains("likes")) {
                        String tempo[] = temp[i].split(":");
                        facebook_likes = tempo[1];
//                        System.out.println("facebook_likes" + facebook_likes);
                    }

                }
            } catch (Exception e) {
            }

            temp = doc1.text().split("\"");
            try {
                for (int i = 0; i < temp.length; i++) {
                    if (temp[i].contains("talking_about_count")) {
                        talking_about_count = talking_about_count + temp[i + 1];
                        talking_about_count = talking_about_count.replace("\\", "");
//                        System.out.println("talking_about_count" + talking_about_count);
                        break;
                    }

                }
            } catch (Exception e) {
            }
        } catch (Exception a) {
            System.out.println("" + a);
        }

        data.setFacebookUrl(facebook_url);
        data.setFacebookName(facebook_name);
        data.setFacebookLikes(facebook_likes);
        data.setFacebookAbout(facebook_about);
        data.setFacebookImage(facebook_image);
        data.setFacebookOverview(facebook_overview);
        data.setFacebookProduct(facebook_products);
        data.setFacebookAddress(facebook_address);
        data.setTakingAbout(talking_about_count);
        data.setFacebookPhone(facebook_phone);
        data.setFacebookMission(facebook_mission);
        data.setFacebookDescription(facebookDescription);

    }
}
