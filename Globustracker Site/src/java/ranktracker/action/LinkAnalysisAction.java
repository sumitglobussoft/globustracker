/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import ranktracker.seo.main.SeoMain;


public class LinkAnalysisAction {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;

    private HttpServletResponse objResponse;

    public void getLinkAnalysisData() throws Exception {
        try {
            objResponse = ServletActionContext.getResponse();//getting response object
            objRequest = ServletActionContext.getRequest();//getting request object

            if (objRequest.getSession().getAttribute("customerID") != null) {

                String site = objRequest.getParameter("url");
                System.out.println("    site "+site);
                if (!site.isEmpty()) {
                    JSONObject result = new SeoMain().getSeoDetails(site);
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
