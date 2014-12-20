/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Queue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.dao.CustomerDao;
import ranktracker.entity.Users;
import ranktracker.service.CustomerService;

/**
 *
 * @author User
 */
public class Adminaction extends ActionSupport {

    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * objRequest The HttpServletRequest object
     */
    private HttpServletRequest objRequest;
    /**
     *
     */
    private Users objUser;
    /**
     *
     */
    private List<Users> lstUsers;
    /**
     *
     */
    private Queue<Users> queUsers;
    /**
     *
     */
    private CustomerService objCustomerService;
    /**
     *
     */
    private CustomerDao objCustomerDao;
    /**
     *
     */
    private String editUserId;
    /**
     *
     */
    private String editLoginId;
    /**
     *
     */
    private String editPassword;
    /**
     *
     */
    private String editUserType;
    /**
     *
     */
    private String customerID;

    /**
     *
     * @return
     */
    @Override
    public String execute() {

        //initializing http session object
        objRequest = ServletActionContext.getRequest();

        //initializing http session object
        objSession = objRequest.getSession();
        try {
            if (objSession.getAttribute("AdminID") != null) {
                lstUsers = objCustomerService.getAllUsersList();
                if (objSession.getAttribute("message") != null) {
                    addActionMessage(objSession.getAttribute("message").toString());
                    objSession.removeAttribute("message");
                }
            } else {
                return INPUT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String logOut() {

        //initializing http session object
        objSession = ServletActionContext.getRequest().getSession();
        objSession.removeAttribute("AdminID");
        objSession.removeAttribute("customerName");
        objSession.removeAttribute("userID");
        return SUCCESS;
    }

    public String editUserData() {
        int n = 0;
        objRequest = ServletActionContext.getRequest();
        objSession = objRequest.getSession();
        //initializing http session object
        if (objSession.getAttribute("AdminID") != null) {
            n = objCustomerService.editUser(editUserId, editLoginId, editPassword, editUserType);
        }
        if (n == 1) {
            return SUCCESS;
        }
        return LOGIN;
    }

    public String activateUser() {
        int n = 0;
        objRequest = ServletActionContext.getRequest();
        objSession = objRequest.getSession();

        System.out.println("CustomerID : " + customerID);
        n = objCustomerDao.activeUser(Integer.parseInt(customerID));

        if (n == 1) {
            objSession.setAttribute("message", "User Account Activated Successfully");
            return SUCCESS;
        }
        return LOGIN;
    }

    public String deactivateUser() {
        int n = 0;
        objRequest = ServletActionContext.getRequest();
        objSession = objRequest.getSession();

        System.out.println("CustomerID : " + customerID);
        n = objCustomerDao.deactiveUser(Integer.parseInt(customerID));

        if (n == 1) {
            objSession.setAttribute("message", "User Account Deactivated Successfully");
            return SUCCESS;
        }
        return LOGIN;
    }

    public String updateUserPlan() {
        int n = 0;
        objRequest = ServletActionContext.getRequest();
        objSession = objRequest.getSession();
        try {
            int customerId = Integer.parseInt(objRequest.getParameter("custId"));
            String plan = objRequest.getParameter("plan");
            int planId = Integer.parseInt(objRequest.getParameter("planId"));
            float amount = Float.parseFloat(objRequest.getParameter("amount"));
            int campaign = Integer.parseInt(objRequest.getParameter("campaign"));
            int keyword = Integer.parseInt(objRequest.getParameter("keyword"));
            int user = Integer.parseInt(objRequest.getParameter("user"));

            n = objCustomerDao.updatePlan(customerId, plan, planId, amount, campaign, keyword, user);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (n == 1) {
            objSession.setAttribute("message", "User price plan changed Successfully");
            return SUCCESS;
        }
        return LOGIN;
    }

    public Users getObjUser() {
        return objUser;
    }

    public void setObjUser(Users objUser) {
        this.objUser = objUser;
    }

    public List<Users> getLstUsers() {
        return lstUsers;
    }

    public void setLstUsers(List<Users> lstUsers) {
        this.lstUsers = lstUsers;
    }

    public CustomerService getObjCustomerService() {
        return objCustomerService;
    }

    public void setObjCustomerService(CustomerService objCustomerService) {
        this.objCustomerService = objCustomerService;
    }

    public String getEditUserId() {
        return editUserId;
    }

    public void setEditUserId(String editUserId) {
        this.editUserId = editUserId;
    }

    public String getEditLoginId() {
        return editLoginId;
    }

    public void setEditLoginId(String editLoginId) {
        this.editLoginId = editLoginId;
    }

    public String getEditPassword() {
        return editPassword;
    }

    public void setEditPassword(String editPassword) {
        this.editPassword = editPassword;
    }

    public String getEditUserType() {
        return editUserType;
    }

    public void setEditUserType(String editUserType) {
        this.editUserType = editUserType;
    }

    public Queue<Users> getQueUsers() {
        return queUsers;
    }

    public void setQueUsers(Queue<Users> queUsers) {
        this.queUsers = queUsers;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public CustomerDao getObjCustomerDao() {
        return objCustomerDao;
    }

    public void setObjCustomerDao(CustomerDao objCustomerDao) {
        this.objCustomerDao = objCustomerDao;
    }
}
