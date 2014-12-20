/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.form;

/**
 * Form class for storing information of Sign up module
 *
 * @author 
 */
public class NewSignUpForm {

    private String emailId;
    private String firstName;
    private String lastName;
    private String password;
    
    /**
     *
     * @return
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     *
     * @param emailId
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param phone
     */
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "SignUpForm{" + "emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + "'}'";
    }
}
