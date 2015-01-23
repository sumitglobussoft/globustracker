/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import ranktracker.dao.CustomerDao;
import ranktracker.entity.Customers;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;
import ranktracker.entity.Users;
import ranktracker.form.SignUpForm;
import ranktracker.mail.SendMail;
import ranktracker.service.CustomerService;
import ranktracker.service.PaymentService;

/**
 * Action layer class for actions initiated for signup module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class SignUpSubmitAction extends ActionSupport implements ModelDriven<SignUpForm> {

    /**
     * objSignUpForm The SignUpForm object containing user's sign up values
     */
    private SignUpForm objSignUpForm;
    /**
     * objCustomerService The service layer object variable for CustomerService
     * object
     */
    private CustomerService objCustomerService;
    /**
     * objSession The HttpSession object
     */
    private HttpSession objSession;
    /**
     * objPaymentService The service layer object variable for PaymentService
     * object
     */
    private PaymentService objPaymentService;
    /**
     * objSendMail The SendMail object
     */
    private SendMail objSendMail;

    /**
     * Used for Customer related operations
     */
    private CustomerDao objCustomerDao;

    /**
     * The method saves new customer record to database along with users record,
     * payment record and invokes mail module to send customer welcome mail
     *
     * @return struts return value
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {

        Customers objCustomer = new Customers();
        Users objUser = new Users();
        Payments objPayment = null;
        Plans objPlan = null;
        objSession = ServletActionContext.getRequest().getSession();
        if (objSession.getAttribute("objPayment") != null) {
            objSignUpForm = (SignUpForm) objSession.getAttribute("objSignUpForm");
            objPayment = (Payments) objSession.getAttribute("objPayment");
            objPlan = objPayment.getPlanID();
            if (objSignUpForm != null) {
                BeanUtils.copyProperties(objSignUpForm, objCustomer, new String[]{"zipCode"});
            }
//            objCustomer.setZipCode(000000);
//            objCustomer.setZipCode(Integer.valueOf(objSignUpForm.getZipCode()));
            objUser.setLoginID(objSignUpForm.getEmailId());
//            objUser.setPassword(new Date().getTime() + "");
            //  String password = RandomPassword();

            //OAuth Token Generation
            String token = objCustomerDao.generateAccessToken("" + objSignUpForm.getEmailId(), "" + objSignUpForm.getPassword(), "" + objSignUpForm.getAltEmailID(), "" + objSignUpForm.getTimezone());

            objUser.setPassword(objSignUpForm.getPassword());
            objUser.setUserType(0);
            objUser.setActive(0);
            objUser.setAddeddate(new Date());
            objUser.setToken(token);
            objCustomer.setTimezoneID(objSignUpForm.getTimezone());
            objCustomer.setAlertEmailID(objSignUpForm.getAltEmailID());
            objCustomer.setAllowedUserCount(objPlan.getUsers());
            objCustomer.setAllowedCampaignsCount(objPlan.getCampaigns());
            objCustomer.setAllowedKeywordCount(objPlan.getKeywords());
            objCustomer.setActiveKeywordCount(0);
            objCustomer.setActiveVideoKeywordCount(0);
            objCustomer = objCustomerService.saveCustomer(objCustomer, objUser);
            objSession.setAttribute("customerID", objCustomer.getCustomerID());
            objPayment.setCustomerID(objCustomer);
            objSession.removeAttribute("objPayment");
            objSession.setAttribute("objPayment", objPayment);
//            objSession.invalidate();
            objSendMail.execute(1, objUser, objSession.getAttribute("itemName").toString());

            objSession.setAttribute("firstname", objSignUpForm.getFirstName());
            objSession.setAttribute("lastname", objSignUpForm.getLastName());
//       objSession.setAttribute ("phone",objSignUpForm.getPhone());
//        objSession.setAttribute("address",objSignUpForm.getAddress());
//        objSession.setAttribute("city",objSignUpForm.getCity());
//        objSession.setAttribute ("state",objSignUpForm.getState());

            // checking for freebeta, if so forward to sucess.jsp by accountCreated.action
          //  if (objSession.getAttribute("itemName").equals("FreeBeta")) {
                objPaymentService.savePayment(objPayment);
                objSession.invalidate();
           // }
            
            return "done";
            //return SUCCESS;
        } else {
            objSession.setAttribute("objSignUpForm", objSignUpForm);
            return "CONTINUE";
        }
    }

    private static String RandomPassword() {
        String password = "globus" + (new Random().nextInt(9999 - 1000) + 1000);
        return password;
    }
    
    /**
     * The method validates the form inputs
     */
    @Override
    public void validate() {

        try {
            objSession = ServletActionContext.getRequest().getSession();
            // String emailId = objSignUpForm.getEmailId().replace("Email Id", "").replace("Enter Email", "");
            //  String firstName = objSignUpForm.getFirstName().replace("First Name", "");
            //   String lastName = objSignUpForm.getLastName().replace("Last Name", "");
//        String phoneno = objSignUpForm.getPhone().replace("Phone No", "");
//        String address = objSignUpForm.getAddress().replace("Address", "");
//        String city = objSignUpForm.getCity().replace("City", "");
//        String state = objSignUpForm.getState().replace("State", "");
//        String country = objSignUpForm.getCountry().replace("Country", "");
//        String zipCode = objSignUpForm.getZipCode().replace("Zip", "");
            //   boolean b = false;
//            if (objSignUpForm.getPassword().length() <= 5) {
//                addActionError("Password Length should be greater than 6 and less than 15");
//            }
//            if (objSignUpForm.getPassword().length() >= 16) {
//                addActionError("Password Length should not be greater than 15");
//            }

//            if (emailId.equals("")) {
//                addFieldError("emailId", getText("emailId.empty"));
//                b = true;
//
//            }
//            if (!b) {
//                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
//                Matcher m = p.matcher(emailId);
//                boolean matchFound = m.matches();
//                if (!matchFound) {
//                    addActionError("Please Provide Valid Email ID");
//                }
//            }
//            if (firstName.equals("")) {
////            addFieldError("firstName", getText("firstname.empty"));
//                b = true;
//            } else {
//                //check for special characters and spaces
//                boolean matchFound = firstName.matches("[a-zA-Z]+");
//                if (!matchFound) {
////                addActionError("Please Provide Valid First Name");
//                }
//            }
//
//            if (lastName.equals("")) {
////            addFieldError("lastName", getText("lastname.empty"));
//                b = true;
//            } else {
//                //check for special characters and spaces
//                boolean matchFound = lastName.matches("[A-Z][a-zA-Z]*");
//                if (!matchFound) {
//                    b = true;
////                addActionError("Please Provide Valid Last Name");
//                }
//            }
//        if (phoneno.equals("")) {
////            addFieldError("phone", getText("phone.empty"));
//            b = true;
//        } else {
//            boolean matchFound = phoneno.matches("\\d{10}");
//            if (!matchFound) {
//                b = true;
////                addActionError("Provide valid Phone Number.");
//            }
//        }
//
//        if (address.equals("")) {
////            addFieldError("address", getText("address.empty"));
//            b = true;
//        }
//        if (city.equals("")) {
////            addFieldError("city", getText("city.empty"));
//            b = true;
//        } else {
//            //check for special characters and spaces
//            boolean matchFound = city.matches("[A-Z][a-zA-Z]*");
//            if (!matchFound) {
//                b = true;
////                addActionError("Please Provide Valid City Name");
//            }
//        }
//        if (state.equals("")) {
////            addFieldError("state", getText("state.empty"));
//            b = true;
//        } else {
//            //check for special characters and spaces
//            boolean matchFound = state.matches("[A-Z][a-zA-Z]*");
//            if (!matchFound) {
//                b = true;
////                addActionError("Please Provide Valid State Name");
//            }
//        }
//        if (country.equals("")) {
////            addFieldError("country", getText("country.empty"));
//            b = true;
//        } else {
//            //check for special characters and spaces
//            boolean matchFound = country.matches("[A-Z][a-zA-Z]*");
//            if (!matchFound) {
//                b = true;
////                addActionError("Please Provide Valid Country Name");
//            }
//        }
//        if (zipCode.equals("")) {
////            addFieldError("zipCode", getText("zip.empty"));
//            b = true;
//        }
//        if (!b) {
//            boolean matches = zipCode.matches("[/,:<>!~@#$%^&()+=?()\"|!\\[#$-]");
//            if (matches) {
////                addFieldError("zipCode", getText("zip.empty"));
//                b = true;
//            }
//        }
//        if (!b) {
            if (objSession.getAttribute("objPayment") == null) {
                boolean mailIdavailableStatus = objCustomerService.isEmailIDAvailable(objSignUpForm.getEmailId());
                if (mailIdavailableStatus == false) {
                    addActionError(getText("email.unAvlb"));
                    objSignUpForm.setEmailId("");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public SignUpForm getModel() {
        return objSignUpForm;
    }

    /**
     *
     * @return objSignUpForm
     */
    public SignUpForm getObjSignUpForm() {
        return objSignUpForm;
    }

    /**
     *
     * @param objSignUpForm
     */
    public void setObjSignUpForm(SignUpForm objSignUpForm) {
        this.objSignUpForm = objSignUpForm;
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

    /**
     *
     * @return objSendMail
     */
    public SendMail getObjSendMail() {
        return objSendMail;
    }

    /**
     *
     * @param objSendMail
     */
    public void setObjSendMail(SendMail objSendMail) {
        this.objSendMail = objSendMail;
    }

    public CustomerDao getObjCustomerDao() {
        return objCustomerDao;
    }

    public void setObjCustomerDao(CustomerDao objCustomerDao) {
        this.objCustomerDao = objCustomerDao;
    }

}
