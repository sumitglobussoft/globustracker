package globuswoo.crawlers;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class W3cDoctypeEncoding extends Thread {

    public ArrayList<String> wDE = new ArrayList<>();
    public String W3CValidity = "NA";
    public String Encoding = "NA";
    public String Doctype = "NA";
    public String urlTemp;

    public void w3setDetails(String urlTemp) {
        String url = urlTemp;
        urlTemp = "http://validator.w3.org/check?uri=" + urlTemp;
        try {
            Document doc = Jsoup.parse(Crawler.fetchGooglePageRank(urlTemp));
            Elements el1 = doc.select("form tbody tr");
            urlTemp = el1.first().text();
            wDE.add(urlTemp.replace("Result: Passed,", "Valid:").replace("Result:", "Invalid:"));
            System.out.println("W3CValidity : " + urlTemp);
            W3CValidity = "" + urlTemp;

//************************** W3CValid ends *************************************           
            Element el2 = el1.get(2).select("td").first();
            wDE.add(el2.text());
            System.out.println("Encoding  : " + el2.text());
            Encoding = "" + el2.text();

// ************************* Doctype ends  *************************************          
            el2 = el1.get(3).select("td").first();
            wDE.add(el2.text());
            System.out.println("Doctype  : " + el2.text());
            Doctype = "" + el2.text();

// ************************* Encoding ends *************************************               
        } catch (IOException e) {
            System.out.println("Exception in W3cValidity " + e);
        }
    }
}
