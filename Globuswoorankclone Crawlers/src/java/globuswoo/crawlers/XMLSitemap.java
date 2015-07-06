package globuswoo.crawlers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import globuswoo.dao.WoorankDaoImpl;
import globuswoo.entity.Xmldata;

public class XMLSitemap extends Thread {

    public String xmlfiles = "";
    public String curl;
    public WoorankDaoImpl objwoorankdao;
    public Xmldata objXmldata;

    XMLSitemap() {
    }

    XMLSitemap(String curl, WoorankDaoImpl objwoorankdao, Xmldata objXmldata) {

        this.curl = curl;
        this.objwoorankdao = objwoorankdao;
        this.objXmldata = objXmldata;
    }

    @Override
    public void run() {
        setXmlInfo(curl, objwoorankdao, objXmldata);
    }

    public void setXmlInfo(String curl, WoorankDaoImpl objwoorankdao, Xmldata objXmldata) {

        String url = curl + "/robots.txt";
        System.out.println("" + url);

        try {
            Document doc = Jsoup.parse(Crawler.fetchGooglePageRank(url));

            String buf[] = doc.text().split(":");

            for (int i = 0; i < buf.length; i++) {

                if (buf[i].contains("Sitemap")) {
                    String t = (buf[i + 1] + buf[i + 2]).replace("Sitemap", "");
                    t = t.replace("### END FILE ###", "");
                    t = t.replace("Mobile sitemaps - SRPs", "");
                    t = t.replace("#", "");
                    xmlfiles = xmlfiles + t + "#";
                }
            }

        } catch (Exception e) {
        }
        objXmldata.setUrl(curl);
        objXmldata.setXmlfiles(xmlfiles);
    }
}
