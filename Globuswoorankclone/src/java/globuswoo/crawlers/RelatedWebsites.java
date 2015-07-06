package globuswoo.crawlers;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import globuswoo.dao.WoorankDaoImpl;
import globuswoo.entity.Relatedwebsite;

public class RelatedWebsites extends Thread {

    public String relatedLinks = "";
    public String url;
    public WoorankDaoImpl objwoorankdao;
    public Relatedwebsite objRelatedwebsite;

    RelatedWebsites() {
    }

    RelatedWebsites(String url, WoorankDaoImpl objwoorankdao, Relatedwebsite objRelatedwebsite) {

        this.url = url;
        this.objwoorankdao = objwoorankdao;
        this.objRelatedwebsite = objRelatedwebsite;
    }

    @Override
    public void run() {

        try {
            RelatedPages(url, objwoorankdao, objRelatedwebsite);
        } catch (Exception e) {
        }
    }

    public void RelatedPages(String url, WoorankDaoImpl objwoorankdao, Relatedwebsite objRelatedwebsite) {

        //*********************************Object for fetchSource();*******************     
        //*********************************Output String Array*************************          
        try {
            String links;
            String urlKeyword = "https://www.google.com/search?q=related:" + url + "/%20" + (url.replace("www.", "")).replace("https://", "").replace("http://", "");
            System.out.println("KEYWORD: " + urlKeyword);
            Document doc = Jsoup.parse(Crawler.fetchGooglePageRank(urlKeyword));
            //System.out.println(""+doc);
            Elements el1 = doc.select("div[id=ires] li[class=g]");
            for (Element itr : el1) {
                Elements el2 = itr.select("h3[class=r]");
                links = el2.select("a").attr("href") + "";
                relatedLinks = relatedLinks + links + "#";
            }
            objRelatedwebsite.setUrl(url);
            objRelatedwebsite.setRelatedLinks(relatedLinks);

        } catch (IOException e) {
            System.out.println("Exception in RelatedPages " + e);
        }

    }
}
