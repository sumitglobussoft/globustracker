/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;
import ranktracker.form.SignUpForm;
import ranktracker.service.PaymentService;

/**
 * Action layer class for actions initiated for free user account module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class PaymentCouponAction extends ActionSupport {

    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * objSignUpForm The SignUpForm object
     */
    private SignUpForm objSignUpForm;
    /**
     * objPaymentService The service layer object variable for PaymentService
     * object
     */
    private PaymentService objPaymentService;
    /**
     * lstPlans The list containing Plan objects
     */
    private List<Plans> lstPlans;

    /**
     * The method validates coupon code and sets payment object in session
     *
     * @return struts return value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        //initializing http session object
        objSession = ServletActionContext.getRequest().getSession();

        //initializing http request object
        objRequest = ServletActionContext.getRequest();
//        if (objRequest.getParameter("coupon").equalsIgnoreCase("freebeta")) {
        objSignUpForm = (SignUpForm) objSession.getAttribute("objSignUpForm");

        //retrieving the plan details from PaymentServiceImpl
        lstPlans = objPaymentService.getPlans("FreeBeta");
        //lstPlans = objPaymentService.getPlans(objSession.getAttribute("itemName").toString());

        Payments objPayment = new Payments();

        //setting parameter in <objPayment> object
        objPayment.setBeginDate(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        objPayment.setAmount(lstPlans.get(0).getAmount());
        objPayment.setEndDate(calendar.getTime());
        objPayment.setPaymentDate(new Date());
        if (objSignUpForm != null) {
            objPayment.setPayerID(objSignUpForm.getEmailId());
        }
        objPayment.setPlanID(lstPlans.get(0));
        objPayment.setEbayTransactionID("freebeta");
       // objPayment.setPlan(objSession.getAttribute("itemName").toString());
        objPayment.setPlan("");

        //setting the <objPayment> object in session
        if (objSignUpForm != null) {
            objSession.setAttribute("objPayment", objPayment);
        }

        return SUCCESS;
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
