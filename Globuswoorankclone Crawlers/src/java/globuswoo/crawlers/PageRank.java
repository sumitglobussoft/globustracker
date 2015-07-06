/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.crawlers;

import globuswoo.entity.Commonseo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.jsoup.nodes.Document;

/**
 * @author : Nitesh Shah 
 * Email id : niteshshah@globussoft.com
 */
public class PageRank {

    public String result = "";

    public void disp() {
        System.out.println("Page Rank : " + result);
            }
    
    public void getPageRank(Document doc, Commonseo data, String url) {

        long hash = new JenkinsHash().hash(("info:" + url).getBytes());

        String pagerankurl = "http://toolbarqueries.google.com/tbr?client=navclient-auto&hl=en&" + "ch=6" + hash
                + "&ie=UTF-8&oe=UTF-8&features=Rank&q=info:" + url;
        try {
            URLConnection conn = new URL(pagerankurl).openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String input;
            while ((input = br.readLine()) != null) {

                result = input.substring(input.lastIndexOf(":") + 1);
                System.out.println("result : " + result);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        data.setPageRank(result);
    }
}
