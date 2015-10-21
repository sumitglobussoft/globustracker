/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import ranktracker.keyword.research.GetRequestHandler;


public class AccurateLocalRankingAction {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;

    private HttpServletResponse objResponse;

    public static final String API_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

    public void getPlacesList() throws Exception {
        try {
            objResponse = ServletActionContext.getResponse();//getting response object
            objRequest = ServletActionContext.getRequest();//getting request object

            if (objRequest.getSession().getAttribute("customerID") != null) {

                String site = new URL(objRequest.getParameter("url")).getHost();
                System.out.println("    site "+site);
                if (!site.isEmpty()) {
                    
                    //Getting latitude and longitude
                    JSONObject result = new JSONObject(new GetRequestHandler().doGetRequest(new URL("http://ip-api.com/json/" + site)));

                    String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + result.getDouble("lat")+ "," + result.getDouble("lon") + "&radius=500&key=" + API_KEY;
                    
                    result = new JSONObject(new GetRequestHandler().doGetRequest(new URL(url)));

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
