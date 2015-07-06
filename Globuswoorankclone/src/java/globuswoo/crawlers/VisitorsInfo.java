package globuswoo.crawlers;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import globuswoo.dao.WoorankDaoImpl;
import globuswoo.entity.Visitorarray;

public class VisitorsInfo extends Thread {

    public String global_rank = "NA";
    public String country_rank = "NA";
    public String array_country = "";
    public String array_percent = "";
    public String array_Rank = "";
    public String url;
    public WoorankDaoImpl objwoorankdao;
    public Visitorarray objVisitorarray;

    public void setVisitorsDetails(String url, WoorankDaoImpl objwoorankdao, Visitorarray objVisitorarray) {

        try {

            String myurl = "http://www.alexa.com/siteinfo/" + url;
            Document doc = Jsoup.parse(Crawler.fetchGooglePageRank(myurl));

//*****************CODE FOR GLOBAL RANK*****************************************
            try {
                global_rank = doc.select("span[class=globleRank] strong[class=metrics-data align-vmiddle]").first().text();
                System.out.println("GLOBAL RANK: " + global_rank);
            } catch (Exception e) {
            }

//************************CODE FOR COUNTRY RANK*********************************
            try {
                country_rank = doc.select("span[class=countryRank] strong[class=metrics-data align-vmiddle]").first().text();
                System.out.println("COUNTRY RANK: " + country_rank);
            } catch (Exception e) {
            }

            try {
                Elements e1 = doc.select("table[id=demographics_div_country_table] tbody tr td a");
                for (Element e : e1) {
                    System.out.println("COUNTRY_NAME" + e.text());
//                    array_country.add(e.text());
                    array_country = array_country + e.text() + "#";
                }
            } catch (Exception e) {
            }

            try {
                Elements e2 = doc.select("table[id=demographics_div_country_table] td[class=text-right] span ");//.first();
                int i = 1;
                for (Element e : e2) {
                    if (i % 2 != 0) {
                        System.out.println("PERCENT" + e.text());
//                        array_percent.add(e.text());
                        array_percent = array_percent + e.text() + "#";
                    } else {
                        System.out.println("RANK" + e.text());
//                        array_Rank.add(e.text());
                        array_Rank = array_Rank + e.text() + "#";
                    }
                    i++;
                }
            } catch (Exception e) {
            }

        } catch (Exception ex) {
        }
        objVisitorarray.setUrl(url);
        objVisitorarray.setCountry(array_country);
        objVisitorarray.setPercent(array_percent);
        objVisitorarray.setRank(array_Rank);
    }
}
