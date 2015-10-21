/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ranktracker.keyword.research.GetRequestHandler;

/**
 *
 * @author Nitesh Shah This Structured Data class code we are not using
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
                System.out.println("------" + site);
                if (!site.isEmpty()) {
                    String url = "https://api.diffbot.com/v3/article?token=testdrivekkibtnxmpdkm&url=http%3A%2F%2F" + site + "&format=json&_=1440486570404";
                    JSONObject result = new JSONObject(new GetRequestHandler().doGetRequest(new URL(url)));

                    URL oracle = new URL("http://" + site);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(oracle.openStream()));
                    String inputLine;

                    JSONObject result1 = new JSONObject();
                    JSONArray linesArray = new JSONArray();

                    while ((inputLine = in.readLine()) != null) {
                        JSONObject line = new JSONObject();
                        System.out.println(inputLine);
                        String demohtml = inputLine;
                        linesArray.put(demohtml);

                    }
                    try {
                        result1.put("HtmlPage", linesArray);
                        result1.put("Structured", result);
                    } catch (JSONException ex) {

                    }
                    in.close();
//                    response.setContentType("text");
//                    response.setHeader("Cache-Control", "no-cache");
//                    response.getWriter().write(result.toString());

                    objResponse.setContentType("text");
                    objResponse.setHeader("Cache-Control", "no-cache");
                    objResponse.getWriter().write(result1.toString());
                }
            }
        } catch (Exception ex) {
            System.out.println("" + ex);
        }

    }
}
