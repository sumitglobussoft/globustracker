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

/**
 *
 * @author GLB-214
 */
public class StructuredData {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;

    private HttpServletResponse objResponse;

    public void getStructuredDataResults() throws Exception {

        try {
            objResponse = ServletActionContext.getResponse();//getting response object
            objRequest = ServletActionContext.getRequest();//getting request object

            if (objRequest.getSession().getAttribute("customerID") != null) {

                 String site = new URL(objRequest.getParameter("url")).getHost();
                System.out.println("------"+ site);
                if (!site.isEmpty()) {
                    String url = "https://api.diffbot.com/v3/article?token=testdrivekkibtnxmpdkm&url=http%3A%2F%2F" + site + "&format=json&_=1440486570404";
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
}
