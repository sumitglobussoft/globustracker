/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.crawlers;

import globuswoo.entity.Commonseo;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author GLB-214
 */
public class IndexedPages extends Thread{

    public String indexedPages = "NA";
    public String IndexUrl = "";
    public String indexedPages1 = "";
    public Document doc;
    public String url;
    public Commonseo data;
    public String complete_url;

    IndexedPages() {
    }

    IndexedPages(Document doc, Commonseo data, String complete_url) {

        this.doc = doc;
        this.data = data;
        this.complete_url = complete_url;
    }

    @Override
    public void run() {
        try {
            getDetails(doc, data, complete_url);
        } catch (Exception e) {
        }
    }

    public void disp() {

        System.out.println("IndexedPages : " + indexedPages);
    }

    public void getDetails(Document doc, Commonseo data, String complete_url) throws IOException {

        try {
            String temp[] = complete_url.replace(".", "#").split("#");
            indexedPages1 = temp[1];
        } catch (Exception e) {
        }

        if (IndexUrl.equals("NA")) {
            return;
        }
        try {
            Document doc1 = Jsoup.parse(Crawler.fetchGooglePageRankWithProxy("https://www.google.co.in/search?biw=1525&bih=372&noj=1&q=" + indexedPages1 + ".com&oq=" + indexedPages1 + "&gs_l=serp.3..35i39j0l4j0i7i30j0l4.1069239.1072941.0.1073315.8.7.1.0.0.0.310.979.0j4j0j1.5.0.msedr...0...1c.1.60.serp..2.6.981.OdzKp9tAcU4"));
            Element eleindxpages = doc1.select("div[id=resultStats]").first();
            System.out.println("Indexed Pages : " + eleindxpages.text().replace("About", "").replace("results", ""));
            indexedPages = eleindxpages.text().replace("About", "").replace("results", "");

        } catch (Exception e) {
        }
        data.setIndexedPages(indexedPages);
    }
}
