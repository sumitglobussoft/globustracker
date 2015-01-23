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
import ranktracker.dao.PaymentDAO;
import ranktracker.entity.Customers;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;

/**
 *
 * @author user
 */
public class UpgradeAction extends ActionSupport {

    HttpServletRequest objRequest;
    HttpSession objSession;

    private PaymentDAO objPaymentDAO;

    @Override
    public String execute() throws Exception {
        objRequest = ServletActionContext.getRequest();
        objSession = objRequest.getSession();

        if (objSession.getAttribute("customerID") != null) {
            objSession.setAttribute("itemName", objRequest.getParameter("itemName"));
            objSession.setAttribute("customerID", objSession.getAttribute("customerID"));
            objSession.setAttribute("name", (String) objSession.getAttribute("customerName"));

            return "success";
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String upgradeLinkOption() {
        objRequest = ServletActionContext.getRequest();
        objSession = objRequest.getSession();

        if (objSession.getAttribute("customerID") != null) {
            if (objSession.getAttribute("activationPeriod").toString().equals("0")) {
                return "renewal";
            }
            return "success";
        } else {
            //if session attribute 'customerID' is null then return result parameter as 'LOGIN'
            //this result parameter is mapped in 'struts.xml'
            return LOGIN;
        }
    }

    public String accountUpgraded() {

        try {

            List<Plans> lstPlans;
            objRequest = ServletActionContext.getRequest();
            objSession = objRequest.getSession();

            Integer customerId = Integer.parseInt(objSession.getAttribute("customerID").toString());
            lstPlans = objPaymentDAO.getPlans(objSession.getAttribute("itemName").toString());

            System.out.println("customerId : " + customerId);
            System.out.println("lstPlans : " + lstPlans.get(0).getName());

            Payments objPayment = new Payments();

            objPayment.setBeginDate(new Date());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_YEAR, 30);
            objPayment.setAmount(lstPlans.get(0).getAmount());
            objPayment.setEndDate(calendar.getTime());
            objPayment.setPaymentDate(new Date());
            objPayment.setPlanID(lstPlans.get(0));
            objPayment.setPlan(objSession.getAttribute("itemName").toString());

            Customers objCustomers = new Customers();

            objCustomers.setAllowedUserCount(lstPlans.get(0).getUsers());
            objCustomers.setAllowedCampaignsCount(lstPlans.get(0).getCampaigns());
            objCustomers.setAllowedKeywordCount(lstPlans.get(0).getKeywords());

            objPaymentDAO.editPaymentDetails(objPayment, objCustomers, customerId);
            String message = " Your Account Has been Upgraded to " + objSession.getAttribute("itemName").toString() + "";
            objSession.setAttribute("message", message);

            objSession.setAttribute("allowedKeywordCount", objCustomers.getAllowedKeywordCount());
            objSession.setAttribute("allowedCampaignCount", objCustomers.getAllowedCampaignsCount());

            return "success";

        } catch (Exception ex) {
        }

        return "error";
    }

    public PaymentDAO getObjPaymentDAO() {
        return objPaymentDAO;
    }

    public void setObjPaymentDAO(PaymentDAO objPaymentDAO) {
        this.objPaymentDAO = objPaymentDAO;
    }

}
