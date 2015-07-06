package globuswoo.crawlers;

import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import globuswoo.dao.WoorankDaoImpl;
import globuswoo.entity.Pagelinks;

public class InPageLinks extends Thread {

    public String links = "";
    public String title = "";
    public String type = "";
    public Document doc;
    public String url;
    public WoorankDaoImpl objwoorankdao;
    public Pagelinks objPagelinks;

    InPageLinks() {
    }

    InPageLinks(Document doc, String url, WoorankDaoImpl objwoorankdao, Pagelinks objPagelinks) {

        this.doc = doc;
        this.url = url;
        this.objwoorankdao = objwoorankdao;
        this.objPagelinks = objPagelinks;
    }

    @Override
    public void run() {
        try {
            setPageLinks(doc, url, objwoorankdao, objPagelinks);
        } catch (Exception eq) {
        }
    }

    public void disp() {

        System.out.println("______________________________");
        System.out.println("LINK: " + links);
        System.out.println("TITLE: " + title);
        System.out.println("TYPE: " + type);

    }

    public void setPageLinks(Document doc, String url, WoorankDaoImpl objwoorankdao, Pagelinks objPagelinks) {

        String temp = "";
        String templink = "";
        Elements e1 = doc.select("a");
        for (Element e2 : e1) {
            temp = e2.attr("href");

            if (temp.length() < 3) {
                continue;
            }

            if (temp.contains("http://") || temp.contains("https://")) {
                type = type + "External" + "#";
                links = links + (temp) + "#";

            } else {
                type = type + "Internal" + "#";
                temp = "" + url + temp;
                links = links + temp + "#";
            }

            if (e2.text().length() > 3) {
                title = title + e2.text() + "#";
            } else {
                title = title + temp + "#";
            }
        }

        System.out.println("INPAGE LINK: " + links);
        objPagelinks.setUrl(url);
        objPagelinks.setLinks(links);
        objPagelinks.setTitle(title);
        objPagelinks.setType(type);
    }
}
