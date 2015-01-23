/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Alertsdata;
import ranktracker.entity.Serpkeywords;
import ranktracker.form.Alertsform;
import ranktracker.service.CustomerService;
import ranktracker.service.KeywordsService;

/**
 * Action layer class for actions initiated for alerts module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class AlertsAction extends ActionSupport {

    /**
     * objCustomerService The service layer object variable for CustomerService
     */
    private CustomerService objCustomerService;
    /**
     * objServletRequest The HttpServletRequest object
     */
    private HttpServletRequest objServletRequest;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * lstAlertsdata The list containing Alertsdata objects
     */
    private List<Alertsdata> lstAlertsdata;
    /**
     * lstAlertsform The list containing Alertsform objects
     */
    private List<Alertsform> lstAlertsform;
    /**
     * lstDate The list containing 10 recent date objects
     */
    private List<Date> lstDate;
    /**
     * currentDate The current date object
     */
    private Date currentDate;
    private KeywordsService objKeywordsService;
    private List<Serpkeywords> lstkeywords;

    /**
     * The method retrieves alerts data from service layer and places it on
     * valuestack for consumption by view layer
     *
     * @return struts result value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        //change by laxmi
        //initializing http request object
        objServletRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objServletRequest.getSession();

        lstDate = new LinkedList<>();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            if (objSession.getAttribute("activationPeriod").toString().equals("0")) {                
                return "renewal";
            }
            //reading the 'customerID' from session and type casting it to integer
            Integer customerId = Integer.parseInt(objSession.getAttribute("customerID").toString());
            lstAlertsform = objCustomerService.getAlerts(customerId, null);
            String timezone = objCustomerService.getTimezoneID(customerId);
            objServletRequest.setAttribute("highlight", "ALERTS");
            for (int i = 0; i < 10; i++) {
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(timezone));
                cal.add(Calendar.DATE, -i);
                Calendar output = Calendar.getInstance();
                output.set(Calendar.YEAR, cal.get(Calendar.YEAR));
                output.set(Calendar.MONTH, cal.get(Calendar.MONTH));
                output.set(Calendar.DATE, cal.get(Calendar.DATE));
                output.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
                output.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
                output.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
                output.set(Calendar.SECOND, cal.get(Calendar.SECOND));
                output.set(Calendar.MILLISECOND, cal.get(Calendar.MILLISECOND));
                Date newDate = output.getTime();
                lstDate.add(newDate);
                if (i == 0) {
                    currentDate = newDate;

                    //set current date
                    setCurrentDate(currentDate);
                }
            }
            //setting the last 10 days date
            setLstDate(lstDate);
            return SUCCESS;
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method retrieves alerts based on campaign name
     *
     * @return struts result value
     */
    public String searchCampaign() {

        //initializing http request object
        objServletRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objServletRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //reading the 'customerID' from session and type casting it to integer
            Integer customerId = (Integer) objSession.getAttribute("customerID");
            String date = objServletRequest.getParameter("date");
            java.util.Date utilDate = new Date(date);
            
            //invoking the getAlerts() method of CustomerServiceImpl
            lstAlertsform = objCustomerService.getAlerts(customerId, utilDate);
            lstDate = new LinkedList<>();
            currentDate = new java.util.Date(date);
            String timezone = objCustomerService.getTimezoneID(customerId);

            //setting the current date
            setCurrentDate(currentDate);
            for (int i = 0; i < 10; i++) {
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(timezone));
                cal.add(Calendar.DATE, -i);
                Calendar output = Calendar.getInstance();
                output.set(Calendar.YEAR, cal.get(Calendar.YEAR));
                output.set(Calendar.MONTH, cal.get(Calendar.MONTH));
                output.set(Calendar.DATE, cal.get(Calendar.DATE));
                output.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
                output.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
                output.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
                output.set(Calendar.SECOND, cal.get(Calendar.SECOND));
                output.set(Calendar.MILLISECOND, cal.get(Calendar.MILLISECOND));
                Date newDate = output.getTime();
                lstDate.add(newDate);
            }

            //setting the last 10 days date
            setLstDate(lstDate);
            return SUCCESS;
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     * The method retrieves alerts based on customer id
     *
     * @return struts result value
     */
    public String searchAlert() {

        //initializing http request object
        objServletRequest = ServletActionContext.getRequest();

        objSession = objServletRequest.getSession();
        //initializing http session object

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //reading the 'customerID' from session and type casting it to integer
            Integer customerID = (Integer) objSession.getAttribute("customerID");
            String campaign = objServletRequest.getParameter("Campaign Name");
            //invoking the searchAlert method of CustomerServiceImpl class
            objCustomerService.searchAlert(customerID, campaign);
            lstDate.clear();
            for (int i = 0; i < 10; i++) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, -i);
                Date newDate = cal.getTime();

                //adding the date in list object
                lstDate.add(newDate);
                if (i == 0) {

                    //adding the current date
                    currentDate = newDate;
                    setCurrentDate(currentDate);
                }
            }

            //adding the last 10 days date
            setLstDate(lstDate);
            return SUCCESS;
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String getKeywords() {

        //initializing http request object
        objServletRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objServletRequest.getSession();

        //checking for 'customerID' attribute in session
        if (objSession.getAttribute("customerID") != null) {

            //reading the 'customerID' from session and type casting it to integer
            Integer customerID = (Integer) objSession.getAttribute("customerID");

            //reading the 'campaignName' from request
            String campaign = objServletRequest.getParameter("campaignName");

            //invoking the getKeywords method of KeywordsServiceImpl class
            lstkeywords = objKeywordsService.getKeywords(customerID, campaign);

            //now setting the alerts attribute and lstKeywords in session object
            objSession.setAttribute("alerts", "on");
            objSession.setAttribute("lstkeywords", lstkeywords);

            return SUCCESS;
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    /**
     *
     * @return objCustomerService
     */
    public CustomerService getObjCustomerService() {
        return objCustomerService;
    }

    /**
     *
     * @param objCustomerService
     */
    public void setObjCustomerService(CustomerService objCustomerService) {
        this.objCustomerService = objCustomerService;
    }

    /**
     *
     * @return lstAlertsdata
     */
    public List<Alertsdata> getLstAlertsdata() {
        return lstAlertsdata;
    }

    /**
     *
     * @param lstAlertsdata
     */
    public void setLstAlertsdata(List<Alertsdata> lstAlertsdata) {
        this.lstAlertsdata = lstAlertsdata;
    }

    /**
     *
     * @return lstDate
     */
    public List<Date> getLstDate() {
        return lstDate;
    }

    /**
     *
     * @param lstDate
     */
    public void setLstDate(List<Date> lstDate) {
        this.lstDate = lstDate;
    }

    /**
     *
     * @return currentDate
     */
    public Date getCurrentDate() {
        return currentDate;
    }

    /**
     *
     * @param currentDate
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public KeywordsService getObjKeywordsService() {
        return objKeywordsService;
    }

    public void setObjKeywordsService(KeywordsService objKeywordsService) {
        this.objKeywordsService = objKeywordsService;
    }

    public List<Serpkeywords> getLstkeywords() {
        return lstkeywords;
    }

    public void setLstkeywords(List<Serpkeywords> lstkeywords) {
        this.lstkeywords = lstkeywords;
    }

    public List<Alertsform> getLstAlertsform() {
        return lstAlertsform;
    }

    public void setLstAlertsform(List<Alertsform> lstAlertsform) {
        this.lstAlertsform = lstAlertsform;
    }
}
