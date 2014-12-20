/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author user
 */

public class SessionSaverAction extends ActionSupport {
      private HttpServletRequest objRequest;
    private HttpSession objSession;
    
    
    
    @Override
    public String execute() throws Exception {
       
        //initializing http request object
        objRequest = ServletActionContext.getRequest();
        
        //initializing http session object
        objSession = objRequest.getSession();
        
        String itemName=objRequest.getParameter("itemName");
        objSession.setAttribute("itemName", itemName);
        return "success";
    }
}
