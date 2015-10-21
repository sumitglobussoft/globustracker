/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;


public class RobotCheckerAction {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;

    private HttpServletResponse objResponse;

    public void getRobotFile() throws Exception {
        try {
            objResponse = ServletActionContext.getResponse();//getting response object
            objRequest = ServletActionContext.getRequest();//getting request object

            JSONObject result = new JSONObject();

            if (objRequest.getSession().getAttribute("customerID") != null) {

                String site = objRequest.getParameter("url");
//                System.out.println("    site " + site);
                if (!site.isEmpty()) {
                    List<String> lines = getLineByLineFile(new URL(site + "/robots.txt"));
                    result.put("code", (lines == null) ? 201 : 101);

                    JSONArray linesArray = new JSONArray();

                    for (int i = 0; i < lines.size(); i++) {
                        JSONObject line = new JSONObject();
                        line.put("" + i, lines.get(i));
                        linesArray.put(line);
                    }

                    result.put("lines", linesArray);

                    objResponse.setContentType("text");
                    objResponse.setHeader("Cache-Control", "no-cache");
                    objResponse.getWriter().write(result.toString());
                }
            }
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

    public void checkUrlAllowance() throws Exception {
        try {
            objResponse = ServletActionContext.getResponse();//getting response object
            objRequest = ServletActionContext.getRequest();//getting request object

            JSONObject result = new JSONObject();
            result.put("allowed", 0);

            if (objRequest.getSession().getAttribute("customerID") != null) {

                String url = objRequest.getParameter("url").replace("://", "@").replace("//", "/").replace("@", "://");
                System.out.println("    url " + url);
                if (!url.isEmpty()) {
                    result.put("allowed", isAllowed(new URL(url)));
                }

                objResponse.setContentType("text");
                objResponse.setHeader("Cache-Control", "no-cache");
                objResponse.getWriter().write(result.toString());
            }

        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }

    public boolean isAllowed(URL obj) {
        try {
            return ((HttpURLConnection) obj.openConnection()).getResponseCode() == 200;
        } catch (Exception ew) {
        }
        return false;
    }

    public List<String> getLineByLineFile(URL obj) throws Exception {
        try {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            if (con.getResponseCode() != 200) {
                return null;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            List<String> lines = new ArrayList<>();
            while ((inputLine = in.readLine()) != null) {
                lines.add(inputLine);
            }
            in.close();
            return lines;
        } catch (Exception ex) {
        }

        return null;
    }

}
