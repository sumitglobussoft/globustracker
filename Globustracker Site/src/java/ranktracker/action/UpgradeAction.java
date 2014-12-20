/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Customers;

/**
 *
 * @author user
 */
public class UpgradeAction extends ActionSupport{
    HttpServletRequest objRequest;
    HttpSession objSession;
    Customers objCustomer;
    
    @Override
    public String execute() throws Exception{
        objRequest = ServletActionContext.getRequest();
        objSession = objRequest.getSession();
        
       objSession.setAttribute("itemName",objRequest.getParameter("itemName"));
       objSession.setAttribute("customerID", objSession.getAttribute("customerID"));
       objSession.setAttribute("name",(String)objSession.getAttribute("customerName"));
                
        return"success";
    }
    
    public String upgradeLinkOption(){
        return "success";
    }
}
