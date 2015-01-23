/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.URL;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ranktracker.ajax.Socialreviewsite;
//import ranktracker.action.ReviewAction;
import ranktracker.entity.Pagelinks;
import ranktracker.entity.Visitorarray;
import ranktracker.service.WebsiteReviewService;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/reviews")
public class WebsiteReview {

    /**
     *
     */
    private WebsiteReviewService objWebsiteReview;
    /**
     *
     */
    private Map<String, String> visitmap;
    /**
     *
     */
    private Map<String, String> headingcount;
    /**
     *
     */
    private Map<String, String> headingelements;
    /**
     *
     */
    private Map<String, String> imagedata;
    /**
     *
     */
    private Map<Integer, Pagelinks> pagelinksdata;
    /**
     *
     */
    private Map<String, String> relatedwebsite;
    /**
     *
     */
    private Map<String, String> technologydata;
    /**
     *
     */
    private Map<Integer, Visitorarray> visitorarray;
    /**
     *
     */
    private Map<String, String> xmldata;

    /**
     *
     * @param sitename
     * @param model
     * @param request
     * @param session
     * @return
     */
    String website = "";

    @RequestMapping(value = "/site/{sitename}", method = RequestMethod.GET)
    public ModelAndView homereview(@PathVariable String sitename, ModelMap model, HttpServletRequest request, HttpSession session) {

        System.out.println("name = " + sitename);
        model.addAttribute("website", sitename);

        String ipaddress = null;
        try {
            InetAddress address = InetAddress.getByName(new URL("http://www." + sitename).getHost());
            ipaddress = address.getHostAddress();
        } catch (Exception ex) {
            try{
            InetAddress address = InetAddress.getByName(new URL("https://www." + sitename).getHost());
            ipaddress = address.getHostAddress();
            }catch(Exception q){
                
            }
        }
        if (ipaddress == null) {
            return new ModelAndView("errormessage");
        }

        if (!website.equals(sitename)) {
//            Thread social_thread = new Thread(new Socialreviewsite(sitename));
//            social_thread.start();

            website = sitename;
        }

        return new ModelAndView("review");

            }

    /*
     @RequestMapping(value = "/site/{sitename}", method = RequestMethod.GET)
     public ModelAndView homereview(@PathVariable String sitename, ModelMap model, HttpServletRequest request, HttpSession session) {

     System.out.println("+++++++++++++++++++++++++++++++  ");
     System.out.println("name = " + sitename);
     model.addAttribute("website", sitename);
     try {

     //            Commonseo objcommonseo = (new WoorankDaoImpl().getCommonSeoDetails("http://www." + sitename));
     //            if (objcommonseo.getUrl().length() < 2) {
     //                return new ModelAndView("errormessage");
     //            } else {
     Thread social_thread = new Thread(new Socialreviewsite(sitename));
     synchronized (this) { //changes
     social_thread.start();
     }
     return new ModelAndView("review");
     //            }

     } catch (Exception e) {
     return new ModelAndView("errormessage");
     }

   
     //        Thread social_thread = new Thread(new Socialreviewsite(sitename));
     //        social_thread.start();
     //        return new ModelAndView("review");
     }
     */
    @RequestMapping(value = "/visitors/{sitename}", method = RequestMethod.POST)
    @ResponseBody
    public String getCommonsdata(@PathVariable String sitename, HttpServletResponse objResponse) throws IOException {

        System.out.println("sitename = " + sitename);
        JSONObject json = new JSONObject();
//        ModelAndView model = new ModelAndView("/WEB-INF/jsp_ranktracker_view/review.jsp");
        visitmap = objWebsiteReview.getCommonsDetails(sitename);
        headingcount = objWebsiteReview.getHeadingcount(sitename);
        headingelements = objWebsiteReview.getHeadingelement(sitename);
        imagedata = objWebsiteReview.getImagedata(sitename);
        pagelinksdata = objWebsiteReview.getPagelinksdata(sitename);
        relatedwebsite = objWebsiteReview.getRelatedwebsite(sitename);
        technologydata = objWebsiteReview.getTechnologydata(sitename);
        visitorarray = objWebsiteReview.getVisitorarray(sitename);
        xmldata = objWebsiteReview.getXmldata(sitename);

//        model.addObject("jmessage", "Received");
//        model.addObject("visitmap", visitmap);
//        MappingJacksonHttpMessageConverter jsonConverter = new MappingJacksonHttpMessageConverter();
//        MediaType jsonMimeType = MediaType.APPLICATION_JSON;
        try {

            PrintWriter pw = objResponse.getWriter();
            objResponse.setContentType("application/json");
            objResponse.setHeader("Cache-Control", "no-cache");
            json.put("jmessage", "Ajax action");
            json.put("visitmap", visitmap);
            json.put("headingcount", headingcount);
            json.put("headingelements", headingelements);
            json.put("imagedata", imagedata);
            json.put("pagelinksdata", pagelinksdata);
            json.put("relatedwebsite", relatedwebsite);
            json.put("technologydata", technologydata);
            json.put("visitorarray", visitorarray);
            json.put("xmldata", xmldata);
            pw.print(json);
            pw.flush();
//            jsonConverter.write(json, jsonMimeType, new ServletServerHttpResponse(objResponse));
        } catch (JSONException ex) {
            ex.printStackTrace();
//            Logger.getLogger(ReviewAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("++++++++++++++++++++++++++++");

        return "review";
    }

    /**
     *
     * @return
     */
    public WebsiteReviewService getObjWebsiteReview() {
        return objWebsiteReview;
    }

    /**
     *
     * @param objWebsiteReview
     */
    public void setObjWebsiteReview(WebsiteReviewService objWebsiteReview) {
        this.objWebsiteReview = objWebsiteReview;
    }

    public Map<String, String> getVisitmap() {
        return visitmap;
    }

    public void setVisitmap(Map<String, String> visitmap) {
        this.visitmap = visitmap;
    }

    public Map<String, String> getHeadingcount() {
        return headingcount;
    }

    public void setHeadingcount(Map<String, String> headingcount) {
        this.headingcount = headingcount;
    }

    public Map<String, String> getHeadingelements() {
        return headingelements;
    }

    public void setHeadingelements(Map<String, String> headingelements) {
        this.headingelements = headingelements;
    }

    public Map<String, String> getImagedata() {
        return imagedata;
    }

    public void setImagedata(Map<String, String> imagedata) {
        this.imagedata = imagedata;
    }

    public Map<Integer, Pagelinks> getPagelinksdata() {
        return pagelinksdata;
    }

    public void setPagelinksdata(Map<Integer, Pagelinks> pagelinksdata) {
        this.pagelinksdata = pagelinksdata;
    }

    public Map<String, String> getRelatedwebsite() {
        return relatedwebsite;
    }

    public void setRelatedwebsite(Map<String, String> relatedwebsite) {
        this.relatedwebsite = relatedwebsite;
    }

    public Map<String, String> getTechnologydata() {
        return technologydata;
    }

    public void setTechnologydata(Map<String, String> technologydata) {
        this.technologydata = technologydata;
    }

    public Map<Integer, Visitorarray> getVisitorarray() {
        return visitorarray;
    }

    public void setVisitorarray(Map<Integer, Visitorarray> visitorarray) {
        this.visitorarray = visitorarray;
    }

    public Map<String, String> getXmldata() {
        return xmldata;
    }

    public void setXmldata(Map<String, String> xmldata) {
        this.xmldata = xmldata;
    }
}
