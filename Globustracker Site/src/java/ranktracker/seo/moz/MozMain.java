/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.seo.moz;

import java.net.URISyntaxException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import ranktracker.keyword.research.GetRequestHandler;

/**
 *
 * @author GLB-170
 */
public class MozMain {

    public static final String ACCESS_ID = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

    public static final String SECRET_ID = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

    public static Authenticator auth = new Authenticator(ACCESS_ID, SECRET_ID);

    public JSONObject getMozDetails(String url) {
        try {

            JSONObject mozDetails = new JSONObject();
            mozDetails.put("url", url);
            mozDetails.put("url_metrics", getUrlMetrics(url));
            mozDetails.put("link_metrics", getLinkMetrics(url));
            //mozDetails.put("anchor_text_metrics", findAnchorText(url));
            //mozDetails.put("top_pages_metrics", findTopPagesMetric(url));

            return mozDetails;
        } catch (Exception e) {
        }
        return null;
    }

    public JSONObject getUrlMetrics(String url) {
        try {
            JSONObject urlmetrics = new JSONObject();

            Long cols = new SeoMozCols().getUrlMetricsCols();

            String urlToFetch = "http://lsapi.seomoz.com/linkscape/url-metrics/" + url + "?" + auth.getAuthenticationStr();

            if (cols > 0) {
                urlToFetch = urlToFetch + "&Cols=" + cols;
            }

//            System.out.println("\n\n\n URL :  " + urlToFetch);
            JSONObject response = new JSONObject(new GetRequestHandler().doGetRequest(new URL(urlToFetch)));

            urlmetrics.put("mozrank_subdomain", response.get("fmrp"));
            urlmetrics.put("domain_authority", response.get("pda"));
            urlmetrics.put("external_equity_links", response.get("ueid"));
            urlmetrics.put("links", response.get("uid"));
            urlmetrics.put("mozrank_url", response.get("umrp"));
            urlmetrics.put("page_authority", response.get("upa"));
            urlmetrics.put("http_status_code", response.get("us"));
            urlmetrics.put("title", response.get("ut"));
            urlmetrics.put("canonical_url", response.get("uu"));

            return urlmetrics;
        } catch (Exception e) {
            System.out.println("++++ " + e);
        }
        return null;
    }

    public JSONArray getLinkMetrics(String url) {
        try {
            JSONArray linkmetrics = new JSONArray();

            Long cols = new SeoMozCols().getLinkMetricsCols();

            String urlToFetch = "http://lsapi.seomoz.com/linkscape/links/" + url + "?" + auth.getAuthenticationStr();

            urlToFetch += "&Scope=" + LinksConstants.LINKS_SCOPE_PAGE_TO_SUBDOMAIN;
            urlToFetch += "&Filter=" + LinksConstants.LINKS_FILTER_EXTERNAL;
            urlToFetch += "&Sort=" + LinksConstants.LINKS_SORT_DOMAIN_AUTHORITY;

            if (cols > 0) {
                urlToFetch += "&SourceCols=" + cols;
            }
            urlToFetch = urlToFetch + "&Limit=25";

//            System.out.println("\n\n\n URL :  " + urlToFetch);
            JSONArray response = new JSONArray(new GetRequestHandler().doGetRequest(new URL(urlToFetch)));

            for (int i = 0; i < response.length(); i++) {
                JSONObject link = new JSONObject();

                link.put("mozrank_subdomain", response.getJSONObject(i).get("fmrp"));
                link.put("domain_authority", response.getJSONObject(i).get("pda"));
                link.put("external_equity_links", response.getJSONObject(i).get("ueid"));
                link.put("links", response.getJSONObject(i).get("uid"));
                link.put("mozrank_url", response.getJSONObject(i).get("umrp"));
                link.put("page_authority", response.getJSONObject(i).get("upa"));
                link.put("http_status_code", response.getJSONObject(i).get("us"));
                link.put("title", response.getJSONObject(i).get("ut"));
                link.put("canonical_url", response.getJSONObject(i).get("uu"));

                linkmetrics.put(link);
            }

            return linkmetrics;
        } catch (Exception e) {
            System.out.println("++++ " + e);
        }
        return null;
    }

    public JSONObject findAnchorText(String url) {
        try {
            JSONObject urlmetrics = new JSONObject();

            Long cols = new SeoMozCols().getAnchorTextCols();

            String urlToFetch = "http://lsapi.seomoz.com/linkscape/anchor-text/" + "google.com" + "?" + auth.getAuthenticationStr();

            urlToFetch += "&Scope=" + AnchorTextConstants.ANCHOR_SCOPE_PHRASE_TO_PAGE;

            if (cols > 0) {
                urlToFetch += "&Cols=" + cols;
            }

            urlToFetch += "&Limit=1";

            System.out.println("\n\n\n URL :  " + urlToFetch);
            JSONObject response = new JSONObject(new GetRequestHandler().doGetRequest(new URL(urlToFetch)));

            return urlmetrics;
        } catch (Exception e) {
            System.out.println("++++ " + e);
        }
        return null;
    }

    public JSONObject findTopPagesMetric(String url) {
        try {
            JSONObject urlmetrics = new JSONObject();

            Long cols = new SeoMozCols().getTopPagesCols();

            String urlToFetch = "http://lsapi.seomoz.com/linkscape/top-pages/" + "google.com" + "?" + auth.getAuthenticationStr();

            urlToFetch += "&Limit=5";
            urlToFetch = urlToFetch + "&Sort=page_authority";
            if (cols > 0) {
                urlToFetch = urlToFetch + "&Cols=" + cols;
            }

            System.out.println("\n\n\n URL :  " + urlToFetch);
            JSONObject response = new JSONObject(new GetRequestHandler().doGetRequest(new URL(urlToFetch)));

            return urlmetrics;
        } catch (Exception e) {
            System.out.println("++++ " + e);
        }
        return null;
    }
}
