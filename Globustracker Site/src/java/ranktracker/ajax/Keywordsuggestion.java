/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.ajax;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository("keywordsuggestion")
public class Keywordsuggestion {

    public List<String> getMatchingforKeywords(String filter) throws URISyntaxException {
        List<String> reply = new ArrayList<>();
        System.out.println("------------------" + filter);
        if (filter.contains("\n")) {
            System.out.println("------9999--------");
            String[] m = filter.split("\n");
            int l = m.length;
            System.out.println(m);
            String n = m[(l - 1)];
            System.out.println(n);
            filter = n;
        }
        String response = null;
        try {
            URI googlesearch = new URIBuilder()
                    .setScheme("http")
                    .setHost("clients1.google.com")
                    .setPath("/complete/search")
                    .setParameter("hl", "en")
                    .setParameter("output", "toolbar")
                    .setParameter("q", filter)
                    .build();
            reply = fetchXMLContent(googlesearch);

        } catch (IOException ex) {
            Logger.getLogger(Keywordsuggestion.class.getName()).log(Level.SEVERE, null, ex);
            return reply;
        }

        return reply;
    }

    public List fetchXMLContent(URI newurl) throws IOException {
        System.out.println("---------------Without Proxy-----------------");
        List<String> reply = new ArrayList<>();
        String responsebody = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(newurl);
            System.out.println("executing request " + httpget.getURI());
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            responsebody = httpclient.execute(httpget, responseHandler);
            // System.out.println(responsebody);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document doc = Jsoup.parse(responsebody);
        Elements ele = doc.getElementsByAttribute("data");
        for (Element element : ele) {
            //  System.out.println(element.attr("data"));
            reply.add(element.attr("data"));
        }

        return reply;
    }
}
