/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author GLB-214
 */
public class StructuredToolsOld {

    private HttpServletRequest objRequest;

    private HttpServletResponse objResponse;

    public void structuredValidatorTools() throws MalformedURLException, IOException, JSONException {

        objResponse = ServletActionContext.getResponse();

        objRequest = ServletActionContext.getRequest();

        String url = objRequest.getParameter("url");

        System.out.println("-----------------" + url);

        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String fulldata = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            fulldata = fulldata + inputLine + "\n";
//            System.out.println(""+inputLine);
        }
//         System.out.println(fulldata);
        JSONObject json = new JSONObject();
        json.put("inputLine", fulldata);
        in.close();

        objResponse.setContentType("text");
        objResponse.setHeader("Cache-Control", "no-cache");
        objResponse.getWriter().write(json.toString());

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
