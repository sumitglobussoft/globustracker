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


public class PageSpeedAnalysisAction {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;

    private HttpServletResponse objResponse;
    
    public static final String API_KEY ="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

    public void getPageSpeedAnalysisResults() throws Exception {
        try {
            objResponse = ServletActionContext.getResponse();//getting response object
            objRequest = ServletActionContext.getRequest();//getting request object

            if (objRequest.getSession().getAttribute("customerID") != null) {

                String site = objRequest.getParameter("url");

                if (!site.isEmpty() ) {
                    String url = "https://www.googleapis.com/pagespeedonline/v1/runPagespeed?url="+site+"&key="+API_KEY;
                    JSONObject result = new JSONObject(new GetRequestHandler().doGetRequest(new URL(url)));
                    objResponse.setContentType("text");
                    objResponse.setHeader("Cache-Control", "no-cache");
                    objResponse.getWriter().write(result.toString());
                }
            }
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

     public void getPageMobileUsability() throws Exception {
        try {
            objResponse = ServletActionContext.getResponse();//getting response object
            objRequest = ServletActionContext.getRequest();//getting request object

            if (objRequest.getSession().getAttribute("customerID") != null) {

                String site = objRequest.getParameter("url");

                if (!site.isEmpty() ) {
                    String url = "https://www.googleapis.com/pagespeedonline/v3beta1/mobileReady?key="+API_KEY+"&screenshot=true&snapshots=true&locale=en_US&strategy=mobile&filter_third_party_resources=false&url="+site;
                    JSONObject result = new JSONObject(new GetRequestHandler().doGetRequest(new URL(url)));
                    String data=result.getJSONObject("screenshot").getString("data");
                    data=data.replace("_", "/").replace("-", "+");
                    result.getJSONObject("screenshot").put("data", data);
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
