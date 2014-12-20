/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.form;

/**
 * Form class for storing information of Contact us module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class ContactUsForm {

    private String name;
    private String email;
    private String custType;
    private String message;

    /**
     *
     */
    public ContactUsForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getCustType() {
        return custType;
    }

    /**
     *
     * @param custType
     */
    public void setCustType(String custType) {
        this.custType = custType;
    }

    /**
     *
     * @return
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

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     *
     * @Override public ActionErrors validate(ActionMapping mapping,
     * HttpServletRequest request) { ActionErrors errors = new ActionErrors();
     * if (getName() == null || getName().length() < 1 ||
     * getName().trim().equals("")) { errors.add("name", new
     * ActionMessage("name.empty")); // TODO: add 'error.name.required' key to
     * your resources }
     *
     * if (getEmail() == null || getEmail().equals("")) { errors.add("email",
     * new ActionMessage("email.empty")); } else if
     * (!getEmail().matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$"))
     * { errors.add("email", new ActionMessage("email.validity")); } if
     * (getAddress() == null || getAddress().trim().equals("")) {
     * errors.add("address", new ActionMessage("address.empty")); } if
     * (getPhone() == null || getPhone().trim().equals("")) {
     * errors.add("phoneno", new ActionMessage("phoneno.empty")); } if
     * (getCusttype() == null || getCusttype().equals("select")) {
     * errors.add("status", new ActionMessage("status.empty")); } if
     * (getMassage() == null || getMassage().equals("")) { errors.add("massage",
     * new ActionMessage("massage.empty")); } else if (getMassage().length() <
     * 20) { errors.add("massage", new ActionMessage("massage.char")); }
     *
     * return errors; }
     */
}
