package globuswoo.crawlers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import globuswoo.dao.WoorankDaoImpl;
import globuswoo.entity.Technology;

public class TechUsedAndAnlytics extends Thread {

    private Document thisDoc;
    public String techUsed = "";
    public String analytics = "";
    public String url;
    public WoorankDaoImpl objwoorankdao;
    public String urlDomainOnly;
    public Technology objTechnology;

    public void setTechUsed(String urlDomainOnly) {

        try {

            int frmIndex = 0, tmp = 0, scriptStopper = 0;
            thisDoc = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy("http://builtwith.com/" + urlDomainOnly));
            Elements el1 = thisDoc.select("div[class=span8] div");
            Elements elExtrated = new Elements();
            for (Element itr : el1) {
                if (frmIndex != 0) {
                    if (itr.hasClass("titleBox")) {
                        break;
                    } else {
                        elExtrated.add(itr);
                    }
                }
                if (itr.select("span").text().equalsIgnoreCase("Frameworks")) {
                    frmIndex = tmp;
                }
                ++tmp;
            }
//            System.out.println("  ::  Technologies FrameWork  ::  ");
            for (Element itr : elExtrated) {
//                techUsed.add(itr.select("h3 a").text());
                techUsed = techUsed + itr.select("h3 a").text() + "#";
            }

//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *           
            elExtrated = new Elements();
            for (Element itr : el1) {
                if (frmIndex != 0) {
                    if (itr.hasClass("titleBox")) {
                        break;
                    } else {
                        elExtrated.add(itr);
                    }
                }
                if (itr.select("span").text().equalsIgnoreCase("JavaScript Libraries")) {
                    frmIndex = tmp;
                }
                ++tmp;
            }
            for (Element itr : elExtrated) {
//                techUsed.add(itr.select("h3 a").text());
                techUsed = techUsed + itr.select("h3 a").text() + "#";
                ++scriptStopper;

            }
            System.out.println("  TechUsed " + techUsed);

//* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *           
        } catch (Exception e) {
            System.out.println("Exceeption in TechUsedAndAnlytics " + e);
        }
    }

    public void setAnalytics(String url, WoorankDaoImpl objwoorankdao, Technology objTechnology) {
        objTechnology.setUrl(url);

        try {

            int scriptStopper = 0, frmIndex = 0, tmp = 0;
            Elements el1 = thisDoc.select("div[class=span8] div");
            Elements elExtrated = new Elements();
            for (Element itr : el1) {
                if (frmIndex != 0) {
                    if (itr.hasClass("titleBox")) {
                        break;
                    } else {
                        elExtrated.add(itr);
                    }
                }
                if (itr.select("span").text().equalsIgnoreCase("Analytics and Tracking")) {
                    frmIndex = tmp;
                }
                ++tmp;
            }
//            System.out.println(" ::  Analytics Used  ::  ");
            for (Element itr : elExtrated) {
//                analytics.add(itr.select("h3 a").text());
                analytics = analytics + itr.select("h3 a").text() + "#";
                ++scriptStopper;
            }
            objTechnology.setTechUsed(techUsed);
            objTechnology.setAnalytics(analytics);
            System.out.println("Analytics : " + analytics);

        } catch (Exception e) {
            System.out.println("Exceeption in TechUsedAndAnlytics " + e);
        }

    }

    public void print() {
        System.out.println("TechnologyUsed " + techUsed);
        System.out.println("Analytics " + analytics);
    }
}
