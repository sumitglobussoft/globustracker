package globuswoo.crawlers;

import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import globuswoo.dao.WoorankDaoImpl;
import globuswoo.entity.Image;

public class ImageStructure extends Thread {

    public String image_count = "0";
    public String imagesrc = "";
    public Document doc;
    public String url;
    public WoorankDaoImpl objwoorankdao;
    public Image objImage;

    ImageStructure() {
    }

    ImageStructure(Document doc, String url, WoorankDaoImpl objwoorankdao, Image objImage) {
        this.doc = doc;
        this.url = url;
        this.objwoorankdao = objwoorankdao;
        this.objImage = objImage;
    }

    @Override
    public void run() {
        try {
            setImageDetails(doc, url, objwoorankdao, objImage);
        } catch (Exception e) {
        }
    }

    public void setImageDetails(Document doc, String url, WoorankDaoImpl objwoorankdao, Image objImage) {

        int counter = 0;
        Elements e1 = doc.getElementsByTag("img");
        for (Element element : e1) {

            if (element.attr("src").length() > 5) {
                imagesrc = imagesrc + element.attr("src") + "#";
                counter++;
            }
        }
        image_count = "" + counter;
        objImage.setUrl(url);
        objImage.setSrc(imagesrc);
    }
}
