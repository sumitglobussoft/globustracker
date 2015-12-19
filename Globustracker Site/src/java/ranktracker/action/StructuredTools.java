/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import java.io.IOException;
import java.net.MalformedURLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;
import ranktracker.get.post.request.FetchSource;

/**
 *
 * @author Nitesh Shah
 */
public class StructuredTools {

    private HttpServletRequest objRequest;

    private HttpServletResponse objResponse;

    public void structuredValidatorTools() throws MalformedURLException, IOException, JSONException {
        try {

            objResponse = ServletActionContext.getResponse();

            objRequest = ServletActionContext.getRequest();

            String url = objRequest.getParameter("url");

            System.out.println("-----------------" + url);

            FetchSource obj = new FetchSource();

//            fetchPageSourceWithoutProxyGET(String newurl, String referer, String Host)
            obj.fetchPageSourceWithoutProxyGET("https://developers.google.com/structured-data/testing-tool/", "https://developers.google.com/structured-data/testing-tool/", "developers.google.com");

            //(String newurl, String urlParameter, String referer, String host)
            String postdate = "url=" + url;

            String response = obj.fetchPageSourceWithoutProxyPOST("https://structured-data-testing-tool.developers.google.com/sdtt/web/validate", postdate, "https://structured-data-testing-tool.developers.google.com/sdtt/web?", "structured-data-testing-tool.developers.google.com");

            response = response.replace(")]}'", "");

            System.out.println("response::::\n" + response);

            JSONObject json = new JSONObject();

            json.put("inputLine", response);

            objResponse.setContentType("text");

            objResponse.setHeader("Cache-Control", "no-cache");

            objResponse.getWriter().write(json.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public HttpServletRequest getObjRequest() {
        return objRequest;
    }

    public void setObjRequest(HttpServletRequest objRequest) {
        this.objRequest = objRequest;
    }

    public HttpServletResponse getObjResponse() {
        return objResponse;
    }

    public void setObjResponse(HttpServletResponse objResponse) {
        this.objResponse = objResponse;
    }
}
