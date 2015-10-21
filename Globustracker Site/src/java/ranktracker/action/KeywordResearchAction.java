/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;
import ranktracker.keyword.research.GetRequestHandler;

/**
 *
 * @author GLB-170
 */
public class KeywordResearchAction {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;

    private HttpServletResponse objResponse;

    public void getResults() throws Exception {
        try {
            objResponse = ServletActionContext.getResponse();//getting response object

            JSONObject result = new JSONObject();// declaring & creating the JSONObject

            objRequest = ServletActionContext.getRequest();//getting request object

            if (objRequest.getSession().getAttribute("customerID") != null) {

                String site = objRequest.getParameter("site");
                String keyword = objRequest.getParameter("keyword");

                if (!site.isEmpty() && !keyword.isEmpty()) {

                    result.put("site", site);
                    result.put("keyword", keyword);

                    String newkeyword = keyword;
                    newkeyword = keyword.replace(" ", "+");
                    System.out.println(newkeyword);

                    String url = null;
                    String response = "";

                    switch (site) {
                        case "google":
                            url = "http://suggestqueries.google.com/complete/search?output=firefox&client=firefox&hl=en-US&q=" + newkeyword;
                            response = new GetRequestHandler().doGetRequest(new URL(url));
//                        System.out.println("ARES : " + response);
                            response = response.replace("[\"" + keyword + "\",[", "[").replace("]]", "]");
//                        System.out.println("res: " + response);

                            result.put("result", new JSONArray(response));

                            break;
                        case "bing":
                            url = "http://api.bing.net/osjson.aspx?FORM=OPERAS&Market=en-us&Query=" + newkeyword;
                            response = new GetRequestHandler().doGetRequest(new URL(url));
//                        System.out.println("ARES : " + response);
                            response = response.replace("[\"" + keyword + "\",[", "[").replace("]]", "]");
//                        System.out.println("res: " + response);

                            result.put("result", new JSONArray(response));
                            break;

                        case "yahoo":
                            url = "https://search.yahoo.com/sugg/gossip/gossip-us-fp/?nresults=10&queryfirst=2&appid=fp&output=json&version=&command=" + newkeyword;
                            response = new GetRequestHandler().doGetRequest(new URL(url));

                            JSONObject mainObject = (new JSONObject(response)).getJSONObject("gossip");

                            JSONArray results = mainObject.getJSONArray("results");

                            JSONArray suggestion = new JSONArray();

                            for (int i = 0; i < results.length(); i++) {
                                JSONObject object = results.getJSONObject(i);
                                System.out.println("-- " + object.getString("key"));
                                suggestion.put(object.getString("key"));
                            }
                            result.put("result", suggestion);
                            break;
                        case "amazon":
                            url = "http://completion.amazon.com/search/complete?method=completion&search-alias=aps&mkt=1&q=" + newkeyword;
                            response = new GetRequestHandler().doGetRequest(new URL(url));
                            result.put("result", new JSONArray(response).getJSONArray(1));
                            break;
                            
                        case "youtube":
                            url = "http://suggestqueries.google.com/complete/search?client=firefox&ds=yt&q=" + newkeyword;
                            response = new GetRequestHandler().doGetRequest(new URL(url));
//                        System.out.println("ARES : " + response);
                            response = response.replace("[\"" + keyword + "\",[", "[").replace("]]", "]");
//                        System.out.println("res: " + response);

                            result.put("result", new JSONArray(response));

                            break;
                         case "wikipedia":
                            url = "https://en.wikipedia.org/w/api.php?action=opensearch&format=json&search=" + newkeyword;
                            response = new GetRequestHandler().doGetRequest(new URL(url));
                            result.put("result", new JSONArray(response).getJSONArray(1));
                            break;
                             
                         case "ebay":
                            url = "http://anywhere.ebay.com/services/suggest/?s=0&q=" + newkeyword;
                            response = new GetRequestHandler().doGetRequest(new URL(url));
                            result.put("result", new JSONArray(response).getJSONArray(1));
                            break;
                            
                    }

                    objResponse.setContentType("text");
                    objResponse.setHeader("Cache-Control", "no-cache");
                    objResponse.getWriter().write(result.toString());
                }
            }
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }
}
