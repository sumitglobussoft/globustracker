/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Reportfrequency;
import ranktracker.service.SettingsService;

/**
 * Action layer class for actions initiated for reports module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class ReportAction extends ActionSupport {

    private String ecampaignId;
    private String ename;
    private String eurl;
    private String elogo;
    /**
     * objSettingsService The service layer object variable for SettingsService
     * object
     */
    private SettingsService objSettingsService;
    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * objHttpSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * lstCampaigns The list containing Campaigns objects
     */
    private List<Campaigns> lstCampaigns;
    /**
     * lstFrequency The list containing ReportFrequency objects
     */
    private List<Reportfrequency> lstFrequency;
    /**
     * message The string containing custom messages indicating database
     * response for an action
     */
    private String message;

    /**
     * The method retrieves campaign data for reports module
     *
     * @return struts return value
     */
    @Override
    public String execute() {

        //initializing http session object
        objSession = ServletActionContext.getRequest().getSession();

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            if (objSession.getAttribute("activationPeriod").toString().equals("0")) {                
                return "renewal";
            }
            
            //reading the 'customerID' from session and type casting it to integer
            Integer customerID = (Integer) objSession.getAttribute("customerID");

            //retrieving the list of campaigns for <customerID>
            lstCampaigns = objSettingsService.getCampaigns(customerID);

            //retrieving the list of frequency for 
            lstFrequency = objSettingsService.getFrequency();
            objRequest.setAttribute("highlight", "REPORTS");
            if (objSession.getAttribute("message") != null) {
                addActionMessage(objSession.getAttribute("message").toString());
                //objSession.removeAttribute("message");
            }
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method saves reports module data to campaigns table
     *
     * @return struts return value
     */
    public String sendReportSetting() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            //reading the 'customerID' from session and type casting it to integer
            Integer customerID = (Integer) objSession.getAttribute("customerID");
            Map<String, String[]> reportSetting = objRequest.getParameterMap();
            String[] emailto = reportSetting.get("emailTo");
            String[] frequency = reportSetting.get("frequency");
            String[] campaignId = reportSetting.get("campaignId");

            //updating the email settings
            if (campaignId != null) {
                for (String emailid : emailto) {
                    if (emailid != "") {
                        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                        Matcher m = p.matcher(emailid);
                        boolean matchFound = m.matches();
                        if (!matchFound) {
                            message = "Please enter Valid Email Id";
                            objSession.setAttribute("message", message);
                            return SUCCESS;
                        }
                    }
                }
                objSettingsService.updateEmailSettings(customerID, campaignId, emailto, frequency);
                message = "Report Frequency Saved";
                objSession.setAttribute("message", message);
            }
            return SUCCESS;
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }

    }

    /**
     * The method updates pdf options for a customer
     *
     * @return struts return value
     */
    public String updatePdfOptions() {

        //initializing http request object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {
            System.out.println("-------------------------");
            System.out.println("CampaignID = " + ecampaignId);
            System.out.println("CompanyName = " + ename);
            System.out.println("CompanyUrl = " + eurl);
            System.out.println("CompanyLogo = " + elogo);

            //updating the pdf options
            objSettingsService.updatePdfOptions(Integer.parseInt(ecampaignId), ename, eurl, elogo);
            message = "PDF Options Updated Successfully";
            objSession.setAttribute("message", message);
            return SUCCESS;
        } else {

            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     *
     * @return objSettingsService
     */
    public SettingsService getObjSettingsService() {
        return objSettingsService;
    }

    /**
     *
     * @param objSettingsService
     */
    public void setObjSettingsService(SettingsService objSettingsService) {
        this.objSettingsService = objSettingsService;
    }

    /**
     *
     * @return lstCampaigns
     */
    public List<Campaigns> getLstCampaigns() {
        return lstCampaigns;
    }

    /**
     *
     * @param lstCampaigns
     */
    public void setLstCampaigns(List<Campaigns> lstCampaigns) {
        this.lstCampaigns = lstCampaigns;
    }

    /**
     *
     * @return lstFrequency
     */
    public List<Reportfrequency> getLstFrequency() {
        return lstFrequency;
    }

    /**
     *
     * @param lstFrequency
     */
    public void setLstFrequency(List<Reportfrequency> lstFrequency) {
        this.lstFrequency = lstFrequency;
    }

    /**
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public String getEcampaignId() {
        return ecampaignId;
    }

    public void setEcampaignId(String ecampaignId) {
        this.ecampaignId = ecampaignId;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEurl() {
        return eurl;
    }

    public void setEurl(String eurl) {
        this.eurl = eurl;
    }

    public String getElogo() {
        return elogo;
    }

    public void setElogo(String elogo) {
        this.elogo = elogo;
    }
}
