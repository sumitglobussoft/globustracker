package globuswoo.crawlers;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ServerIPLocation {

    public String location = "NA";
    public String flagCode = "NA";
    public String latitude = "NA";
    public String longitude = "NA";

    public String myJson(String getJson, String valueId) {

        String value;
        int indexofId, fIndexOfVal, lIndexOfVal;
        indexofId = getJson.indexOf(valueId);
        fIndexOfVal = indexofId + (valueId.length() + 3);
        lIndexOfVal = getJson.substring(fIndexOfVal).indexOf('"') + fIndexOfVal;
        value = getJson.substring(fIndexOfVal, lIndexOfVal);
        return value;
    }

//    public void setServerIPLocation(String ipThenJson, String url) throws JSONException {
    public void setServerIPLocation(String ipThenJson, String url) throws JSONException {
        try {

            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRank("http://ip-api.com/json/" + ipThenJson));
            JSONObject obj = new JSONObject(doc1.text());
            System.out.println(obj);
            location = obj.getString("regionName");
            System.out.println("Location Name : " + location);

            flagCode = obj.getString("countryCode");
            System.out.println("Flag Code : " + flagCode);

            latitude = obj.get("lat") + "";
            System.out.println("Latitude :" + latitude);
            
            longitude = obj.get("lon") + "";
            System.out.println("Longitude : " + longitude);

        } catch (IOException e) {
            System.out.println("Exceeption in ServerIPLocation " + e);
        }
    }
}
