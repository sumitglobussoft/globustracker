/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Plans;
import ranktracker.service.PaymentService;

/**
 * Action layer class for generating authenticated request to paypal and
 * forwarding request to paypal
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class PaymentInfoAction extends ActionSupport {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * objResponse The HttpServletResponse object
     */
    private HttpServletResponse objResponse;
    /**
     * itemName The purchase option selected by the buyer
     */
    private String itemName;
    /**
     * amount The amount corresponding to selected plan
     */
    private String amount;
    /**
     * objPaymentService The service layer object variable for PaymentService
     * object
     */
    private PaymentService objPaymentService;

    public String redirecturl = "";

    public String getRedirecturl() {
        return this.redirecturl;
    }

    public void setRedirecturl(String url) {
        this.redirecturl = url;
    }

    /**
     * The method creates an authentication token for paypal, forwards the
     * request with purchase order description and token to paypal
     *
     * @return struts return value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        objSession = ServletActionContext.getRequest().getSession();
        objRequest = ServletActionContext.getRequest();
        objResponse = ServletActionContext.getResponse();
        itemName = (String) objSession.getAttribute("itemName");

        List<Plans> lstPlans = objPaymentService.getPlans(itemName);
        amount = lstPlans.get(0).getAmount() + "";
        objSession.setAttribute("plan", itemName);

        ////////////////////////////////////////////////////////////////////
        //     public String PayWithPayPal(String amount, String itemInfo, String name, String phone, String email, String currency, String paypalemail, String successUrl, String failUrl, String callBackUrl, String cancelurl,String notifyurl,String custom)
        //Mention URL to redirect content to paypal site
        redirecturl = redirecturl + "http://www.paypal.com/cgi-bin/webscr?cmd=_xclick-subscriptions&business=" + getText("paypal.account");
        //redirecturl = redirecturl + "https://api.sandbox.paypal.com/cgi-bin/webscr?cmd=_xclick-subscriptions&business=" + getText("paypal.apiusername") + getText("paypal.apipassword") + getText("paypal.signature");

        //First name i assign static based on login details assign this value
        String firstname = (String) objSession.getAttribute("firstname");

        String lastname = (String) objSession.getAttribute("lastname");

        redirecturl = redirecturl + "&first_name=" + firstname;
        redirecturl = redirecturl + "&last_name=" + lastname;

        redirecturl = redirecturl + "&rm=2";
        //City i assign static based on login user detail you change this value
        redirecturl = redirecturl + "&city=" + objSession.getAttribute("city");

        //State i assign static based on login user detail you change this value
        redirecturl = redirecturl + "&state=" + objSession.getAttribute("state");

        //Product Name
        redirecturl = redirecturl + "&item_name=" + "Globustracker";

        //amount
        redirecturl = redirecturl + "&a3=" + amount;

        //extra subscription details
        redirecturl = redirecturl + "&p3=1&t3=M&src=1&sra=1";

        //Phone No
        redirecturl = redirecturl + "&night_phone_a=" + objSession.getAttribute("phone");

        // item name
        redirecturl = redirecturl + "&item_name=" + itemName;

        //Address 
        String add = (String) objSession.getAttribute("address");

        if (add != null) {
            redirecturl = redirecturl + "&address1=" + add;
        } else {
            redirecturl = redirecturl + "&address1=" + "addressNotAvailable";
        }

        //Shipping charges if any
        redirecturl = redirecturl + "&no_shipping=1";

        //Handling charges if any
        redirecturl = redirecturl + "&handling=0";

        //Tax amount if any
        redirecturl = redirecturl + "&tax=0";

        //Add quatity i added one only statically 
        redirecturl = redirecturl + "&quantity=1";

        //Currency code 
        redirecturl = redirecturl + "&currency=" + "USD";

        //Success return page url
        redirecturl = redirecturl + "&return=" + "http://globustracker.com/accountCreated.action";//http://ranktracker.globustracker.com/returnAfterPayment.action";
        //redirecturl = redirecturl + "&return=" + "http://localhost:8084/accountCreated.action";//http://ranktracker.globustracker.com/returnAfterPayment.action";

        //Failed return page url
        redirecturl = redirecturl + "&cancel_return=" + "http://globustracker.com/home.action";

        redirecturl = redirecturl + "&notify_url=" + "http://globustracker.com/index.jsp";///yet to be defined//done

        redirecturl = redirecturl + "&custom=" + objSession.getAttribute("customerID");

        System.out.println("************" + redirecturl + "************");

        //objSession.removeAttribute("customerID");
//            objSession.invalidate();
//            objResponse.sendRedirect(redirecturl);
//            objSession.setAttribute("redirect",redirecturl);
        ///////////////////////////////////////////////////////////////////
        return "success";

    }

    public String upgrade() throws Exception {

        objSession = ServletActionContext.getRequest().getSession();
        objRequest = ServletActionContext.getRequest();
        objResponse = ServletActionContext.getResponse();
        itemName = (String) objSession.getAttribute("itemName");

        List<Plans> lstPlans = objPaymentService.getPlans(itemName);
        amount = lstPlans.get(0).getAmount() + "";
        objSession.setAttribute("plan", itemName);

        ////////////////////////////////////////////////////////////////////
        //     public String PayWithPayPal(String amount, String itemInfo, String name, String phone, String email, String currency, String paypalemail, String successUrl, String failUrl, String callBackUrl, String cancelurl,String notifyurl,String custom)
        //Mention URL to redirect content to paypal site
        redirecturl = redirecturl + "http://www.paypal.com/cgi-bin/webscr?cmd=_xclick-subscriptions&business=" + getText("paypal.account");
        //        redirecturl =redirecturl + "https://api.sandbox.paypal.com/cgi-bin/webscr?cmd=_xclick-subscriptions&business=" +getText("paypal.apiusername")+getText("paypal.apipassword")+getText("paypal.signature");                       

        System.out.println("=======================");
        System.out.println(objSession.getAttribute("customerName"));
        System.out.println("=======================");
        String customerName = (String) objSession.getAttribute("customerName");
        String[] name = customerName.split(" ");

        String firstname = name[0];
        String lastname = name[1];

        redirecturl = redirecturl + "&first_name=" + firstname;
        redirecturl = redirecturl + "&last_name=" + lastname;

        redirecturl = redirecturl + "&rm=2";
        //City i assign static based on login user detail you change this value
        redirecturl = redirecturl + "&city=" + objSession.getAttribute("city");

        //State i assign static based on login user detail you change this value
        redirecturl = redirecturl + "&state=" + objSession.getAttribute("state");

        //Product Name
        redirecturl = redirecturl + "&item_name=" + "Ranktracker";

        //amount
        redirecturl = redirecturl + "&a3=" + amount;

        //extra subscription details
        redirecturl = redirecturl + "&p3=1&t3=M&src=1&sra=1";

        //Phone No
        redirecturl = redirecturl + "&night_phone_a=" + objSession.getAttribute("phone");

        // item name
        redirecturl = redirecturl + "&item_name=" + itemName;

        //Address 
        String add = (String) objSession.getAttribute("address");

        if (add != null) {
            redirecturl = redirecturl + "&address1=" + add;
        } else {
            redirecturl = redirecturl + "&address1=" + "addressNotAvailable";
        }

        //Shipping charges if any
        redirecturl = redirecturl + "&no_shipping=1";

        //Handling charges if any
        redirecturl = redirecturl + "&handling=0";

        //Tax amount if any
        redirecturl = redirecturl + "&tax=0";

        //Add quatity i added one only statically 
        redirecturl = redirecturl + "&quantity=1";

        //Currency code 
        redirecturl = redirecturl + "&currency=" + "USD";

        //Success return page url
        redirecturl = redirecturl + "&return=" + "http://globustracker.com/accountUpgraded.action";//http://ranktracker.globustracker.com/returnAfterPayment.action";
        //redirecturl = redirecturl + "&return=" + "http://localhost:8084/accountUpgraded.action";//http://ranktracker.globustracker.com/returnAfterPayment.action";

        //Failed return page url
        redirecturl = redirecturl + "&cancel_return=" + "http://globustracker.com/home.action";

        redirecturl = redirecturl + "&notify_url=" + "http://globustracker.com/index.jsp";///yet to be defined//done

        redirecturl = redirecturl + "&custom=" + objSession.getAttribute("customerID");

        System.out.println("************" + redirecturl + "************");

//            objSession.invalidate();
//            objResponse.sendRedirect(redirecturl);
//            objSession.setAttribute("redirect",redirecturl);
        ///////////////////////////////////////////////////////////////////
        return "success";

    }

    /**
     *
     * @return objPaymentService
     */
    public PaymentService getObjPaymentService() {
        return objPaymentService;
    }

    /**
     *
     * @param objPaymentService
     */
    public void setObjPaymentService(PaymentService objPaymentService) {
        this.objPaymentService = objPaymentService;
    }
}
