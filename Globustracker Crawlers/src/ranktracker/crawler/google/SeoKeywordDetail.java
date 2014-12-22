/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.crawler.google;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Serpkeywords;

/**
 *
 * @author GLB-068
 */
public class SeoKeywordDetail extends Thread {

    private int clientID;
    private KeywordsDao objKeywordDao;
    private List<Serpkeywords> lstKeywords;

    public SeoKeywordDetail(List<Serpkeywords> lstKeywords, ApplicationContext appContext) {
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.lstKeywords = lstKeywords;
    }

    @Override
    public void run() {
        Iterator eachKeyword = lstKeywords.iterator();
        while (eachKeyword.hasNext()) {
            Serpkeywords k = (Serpkeywords) eachKeyword.next();

            int keywordID = k.getKeywordID();
            String keyword = k.getKeyword();
            try {
                System.out.println(keyword);
                int q = insertIntoSeoDetails(keyword, keywordID, k.getUrl(), k.getCampaignID());
                if (q == 1) {
                    System.out.println("seokeyword detail entered");
                } else {
                    System.out.println("wrong keyword");
                }

            } catch (IOException ex) {
                Logger.getLogger(SeoKeywordDetail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int insertIntoSeoDetails(String keyword, Integer keywordID, String url, Campaigns objCampaigns) throws IOException {
        String keysem = "648ec3d46dbd48fb4a469dd08a6d2c41";
        // String keyword1 = keyword.toString();
        String keyword2 = keyword.replaceAll(" ", "+");

        String url1 = "http://us.api.semrush.com/?action=report&type=phrase_this&key=" + keysem + "&export=api&export_columns=Ph,Nq,Cp,Co,Nr&phrase=" + keyword2;
        System.out.println(url1);
        //String input="Keyword;Search Volume;CPC;Competition;Number of Results search engine optimization;33100;17.41;0.92;111000000";
        String input = fetchSemrushPage(url1);
        System.out.println(input);
        if (input.contains("ERROR")) {
            //objKeywordDao.saveSeoResult(keywordID, newWebRankGoogle, bestMatchRankGoogle, bestMatchLinkGoogle, "google.com");

            return 0;
        } else {

            String[] domainsparts = input.split(";", 9);

            String search_volume = domainsparts[5];
            System.out.println("Search_Volume = " + search_volume);
            String cpc = domainsparts[6];
            System.out.println("cpc = " + cpc);
            String competitio = domainsparts[7];
            System.out.println("competitio = " + competitio);
            String number_of_results = domainsparts[8];
            System.out.println("Number_of_Results = " + number_of_results);

            objKeywordDao.saveSeoResult(keywordID, url, keyword, objCampaigns, search_volume, cpc, competitio, number_of_results);
        }
        return 1;
    }

    public static String fetchSemrushPage(String urlsrc) throws IOException {
        System.out.println("---------------Without Proxy-----------------");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String responseBody = "";
        try {
            HttpGet httpget = new HttpGet(urlsrc);

            System.out.println("executing request " + httpget.getURI());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status <= 600) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            responseBody = httpclient.execute(httpget, responseHandler);
            return responseBody;
        } catch (Exception e) {
            System.out.println("Exception in getting the sourec code from website :" + e);
        } finally {
            try {
                httpclient.close();
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }

        return responseBody;
    }
}
