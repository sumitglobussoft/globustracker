/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import ranktracker.entity.Payments;

/**
 * This class responsible for getting different mail content available in
 * mailbody jsp page
 *
 * @author rinkesh jha
 */
public class MailBodyAction extends ActionSupport {

    /**
     * objRequest The HttpRequest object
     */
    private HttpServletRequest objRequest;
    // declaring the map variable to store the data & access in mailbody jsp page
    private Map<String, String> data;
    // It is used in mailbody jsp page to differentiate the mail types
    private int mailType = 0;

    @Override
    public String execute() throws Exception {

        //initializing http session object
        objRequest = ServletActionContext.getRequest();

        return SUCCESS;
    }

    /**
     * This method is used to get sign up mail content from the mail body jsp
     * page
     *
     * @return
     * @throws Exception
     * @author rinkesh jha
     */
    public String getSignUpMailContent() throws Exception {

        //getting request object
        objRequest = ServletActionContext.getRequest();

        if (objRequest.getParameter("username") != null) {

            if (objRequest.getParameter("password") != null) {

                if (objRequest.getParameter("token") != null) {
                    if (objRequest.getParameter("name") != null) {

                        if (objRequest.getParameter("itemName") != null) {

                            mailType = 1; // It is for sign up mail confirmation 
                            data = new HashMap<>();
                            //setting the values in the map data
                            data.put("username", objRequest.getParameter("username"));
                            data.put("password", objRequest.getParameter("password"));
                            data.put("token", objRequest.getParameter("token"));
                            data.put("name", objRequest.getParameter("name"));
                            data.put("itemName", objRequest.getParameter("itemName"));

                        } else {
                            return "error";
                        }
                    } else {
                        return "error";
                    }

                } else {
                    return "error";
                }

            } else {
                return "error";
            }

        } else {
            return "error";
        }

        return SUCCESS;
    }

    /**
     * This method is used to get forgot password mail content from the mail
     * body jsp page
     *
     * @return
     * @throws Exception
     * @author rinkesh jha
     */
    public String getForgotPassContent() throws Exception {

        //getting request object
        objRequest = ServletActionContext.getRequest();

        if (objRequest.getParameter("username") != null) {

            if (objRequest.getParameter("password") != null) {

                if (objRequest.getParameter("name") != null) {

                    mailType = 2; // It is for forgot password option
                    data = new HashMap<>();
                    //setting the values in the map data
                    data.put("username", objRequest.getParameter("username"));
                    data.put("password", objRequest.getParameter("password"));
                    data.put("name", objRequest.getParameter("name"));

                } else {
                    return "error";
                }

            } else {
                return "error";
            }

        } else {
            return "error";
        }

        return SUCCESS;
    }

    /**
     * This method is used to get change password mail content from the mail
     * body jsp page
     *
     * @return
     * @throws Exception
     * @author rinkesh jha
     */
    public String getChangePassContent() throws Exception {

        //getting request object
        objRequest = ServletActionContext.getRequest();

        if (objRequest.getParameter("username") != null) {

            if (objRequest.getParameter("name") != null) {

                if (objRequest.getParameter("password") != null) {

                    mailType = 3; // It is for password changed option
                    data = new HashMap<>();
                    //setting the values in the map data
                    data.put("username", objRequest.getParameter("username"));
                    data.put("name", objRequest.getParameter("name"));
                    data.put("password", objRequest.getParameter("password"));

                } else {
                    return "error";
                }

            } else {
                return "error";
            }

        } else {
            return "error";
        }

        return SUCCESS;
    }

    /**
     * This method is used to get contact us mail content from the mail body jsp
     * page
     *
     * @return
     * @throws Exception
     * @author rinkesh jha
     */
    public String getContactUsContent() throws Exception {

        objRequest = ServletActionContext.getRequest();

        if (objRequest.getParameter("name") != null) {

            if (objRequest.getParameter("email") != null) {

                if (objRequest.getParameter("message") != null) {

                    mailType = 4; // It is for contact us mail
                    data = new HashMap<>();
                    //setting the values in the map data
                    data.put("name", objRequest.getParameter("name"));
                    data.put("email", objRequest.getParameter("email"));
                    data.put("member", objRequest.getParameter("member"));
                    data.put("message", objRequest.getParameter("message"));

                } else {
                    return "error";
                }

            } else {
                return "error";
            }

        } else {
            return "error";
        }
        return SUCCESS;
    }

    /**
     * This method is used to get report mail content from the mail body jsp
     * page
     *
     * @return
     * @throws Exception
     * @author rinkesh jha
     */
    public String getEmailReportContent() throws Exception {

        mailType = 5; // It is for report generation
        data = new HashMap<>();
        return SUCCESS;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public int getMailType() {
        return mailType;
    }

    public void setMailType(int mailType) {
        this.mailType = mailType;
    }
}
