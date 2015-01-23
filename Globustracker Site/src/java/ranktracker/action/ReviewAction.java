/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;
import ranktracker.entity.Commonseo;
import ranktracker.service.WebsiteReviewService;

/**
 *
 * @author User
 */
public class ReviewAction extends ActionSupport {

    /**
     * websearchurl is search url string
     */
    private String websearchurl;
    /**
     * 
     */
    private String jmessage;
    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * 
     */
    private HttpServletResponse objResponse;
    /**
     * objcommonseo is Commonseo object
     */
    private Commonseo objcommonseo;
    /**
     * objSession session object
     */
    private HttpSession objSession;
    /**
     * 
     */
    private Map<String,String> visitmap;
    /**
     * 
     */
    private WebsiteReviewService objWebsiteReview;
    /**
     * 
     * @return
     * @throws Exception 
     */
//    @Override
//    public String execute() throws Exception {
//
//        objRequest = ServletActionContext.getRequest();
//
//        //initializing http session object
//        objSession = objRequest.getSession();
//
//        websearchurl = objRequest.getParameter("websearchurl");
//        System.out.println("----------------websearchurl = " + websearchurl);
//        objSession.setAttribute("websearchurl", websearchurl);
//        //http:// 54.183.182.139:8080/Globuswooclonecrawler/Reviewsite?websitename=india.gov.in
////        Thread social_thread = new Thread(new Socialreviewsite(websearchurl));
////        social_thread.start();
//        return SUCCESS;
//
//    }

//    @Action("getreviewhome/{websearchurl}")
//    public String homereview() throws Exception {
//        
//        objRequest = ServletActionContext.getRequest();
//
//        //initializing http session object
//        objSession = objRequest.getSession();
//        websearchurl = objRequest.getParameter("websearchurl");
//        System.out.println("----------------websearchurl = " + websearchurl);
//        objSession.setAttribute("websearchurl", websearchurl);
//        //http:// 54.183.182.139:8080/Globuswooclonecrawler/Reviewsite?websitename=india.gov.in
////        Thread social_thread = new Thread(new Socialreviewsite(websearchurl));
////        social_thread.start();
//        return SUCCESS;
//    }

//    @Override
//    public String execute() throws Exception{
//        
//        JSONObject json = new JSONObject();
//        objRequest = ServletActionContext.getRequest();
//        objResponse = ServletActionContext.getResponse();
//        PrintWriter out = objResponse.getWriter();
//        //initializing http session object
////        objSession = objRequest.getSession();
//        websearchurl = objRequest.getParameter("websearchurl");
//         System.out.println("***********************websearchurl = " + websearchurl);
//        visitmap = objWebsiteReview.getCommonsDetails(websearchurl);
//        
//        jmessage = "Ajax action";
//        try {
//            json.put("jmessage", "Ajax action");
//            json.put("visitmap", visitmap);
//        } catch (JSONException ex) {
//            ex.printStackTrace();
//            Logger.getLogger(ReviewAction.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("++++++++++++++++++++++++++++");
//        
//        objResponse.setContentType("application/json");
//        out.print(json);
//        out.flush();        
//        return SUCCESS;
//    }
    
//    public String getVisitorLocalization() throws IOException{
//        
//        JSONObject json = new JSONObject();
//        objRequest = ServletActionContext.getRequest();
//        objResponse = ServletActionContext.getResponse();
//        
//        //initializing http session object
//        objSession = objRequest.getSession();
//        websearchurl = objRequest.getParameter("websearchurl");
//         System.out.println("***********************websearchurl = " + websearchurl);
//         
//        return SUCCESS;
//    }
            
            
            
    public String getWebsearchurl() {
        return websearchurl;
    }

    public void setWebsearchurl(String websearchurl) {
        this.websearchurl = websearchurl;
    }

    public HttpServletRequest getObjRequest() {
        return objRequest;
    }

    public void setObjRequest(HttpServletRequest objRequest) {
        this.objRequest = objRequest;
    }

    public HttpSession getObjSession() {
        return objSession;
    }

    public void setObjSession(HttpSession objSession) {
        this.objSession = objSession;
    }

    public Map<String,String> getVisitmap() {
        return visitmap;
    }

    public void setVisitmap(Map<String,String> visitmap) {
        this.visitmap = visitmap;
    }

    public Commonseo getObjcommonseo() {
        return objcommonseo;
    }

    public void setObjcommonseo(Commonseo objcommonseo) {
        this.objcommonseo = objcommonseo;
    }

    public WebsiteReviewService getObjWebsiteReview() {
        return objWebsiteReview;
    }

    public void setObjWebsiteReview(WebsiteReviewService objWebsiteReview) {
        this.objWebsiteReview = objWebsiteReview;
    }

    public String getJmessage() {
        return jmessage;
    }

    public void setJmessage(String jmessage) {
        this.jmessage = jmessage;
    }

   
}
