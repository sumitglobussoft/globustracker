package globuswoo.crawlers;

import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import globuswoo.dao.WoorankDaoImpl;
import globuswoo.entity.Headingcount;
import globuswoo.entity.Headingelements;

public class HeadingStructure extends Thread {

    public String h1 = "0";
    public String h2 = "0";
    public String h3 = "0";
    public String h4 = "0";
    public String h5 = "0";
    public String h1elements = "";
    public String h2elements = "";
    public String h3elements = "";
    public String h4elements = "";
    public String h5elements = "";
    public Document doc;
    public String url;
    public Headingcount objheaHeadingcount;
    public WoorankDaoImpl objwoorankdao;

    public String getAlldata(ArrayList<String> hel) {
        String temp = "";
        for (int i = 0; i < hel.size(); i++) {
            temp = temp + hel.get(i);
        }
        return temp;
    }

    public void setElements(Document doc, String url, Headingcount objheaHeadingcount, WoorankDaoImpl objwoorankdao, Headingelements objHeadingelements) {

        Elements e1 = doc.select("h1");
        int count = 0;
        for (Element e2 : e1) {
            count++;
            h1elements = h1elements + e2.text() + "#";
        }
        h1 = "" + count;

        e1 = doc.select("h2");
        count = 0;
        for (Element e2 : e1) {
            count++;
            h2elements = h2elements + e2.text() + "#";
        }
        h2 = "" + count;

        e1 = doc.select("h3");
        count = 0;
        for (Element e2 : e1) {
            count++;
            h3elements = h3elements + e2.text() + "#";
        }
        h3 = "" + count;

        e1 = doc.select("h4");
        count = 0;
        for (Element e2 : e1) {
            count++;
            h4elements = h4elements + e2.text() + "#";
        }
        h4 = "" + count;

        e1 = doc.select("h5");
        count = 0;
        for (Element e2 : e1) {
            count++;
            h5elements = h5elements + e2.text() + "#";
        }
        h5 = "" + count;

        objheaHeadingcount.setUrl(url);
        objheaHeadingcount.setHeading1(h1);
        objheaHeadingcount.setHeading2(h2);
        objheaHeadingcount.setHeading3(h3);
        objheaHeadingcount.setHeading4(h4);
        objheaHeadingcount.setHeading5(h5);

        objHeadingelements.setUrl(url);
        objHeadingelements.setH1elements(h1elements);
        objHeadingelements.setH2elements(h2elements);
        objHeadingelements.setH3elements(h3elements);
        objHeadingelements.setH4elements(h4elements);
        objHeadingelements.setH5elements(h5elements);
    }

    public WoorankDaoImpl getObjwoorankdao() {
        return objwoorankdao;
    }

    public void setObjwoorankdao(WoorankDaoImpl objwoorankdao) {
        this.objwoorankdao = objwoorankdao;
    }
}
