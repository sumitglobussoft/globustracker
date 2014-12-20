/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.form;

/**
 * Form class for storing information of Sign In module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class SignInForm {

    private String userName;
    private String password;

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
