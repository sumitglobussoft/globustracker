/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.form;

/**
 * Form class for storing information of Sign up module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class SignUpForm {

    private String emailId;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private String timezone;
    private String zipCode;
    private String altEmailID;
    private String planCode;
    private String planName;
    private String planAmount;

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
     * @param lastName
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
//
//    /**
//     *
//     * @return
//     */
//    public String getAddress() {
//        return address;
//    }
//
//    /**
//     *
//     * @param address
//     */
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public String getCity() {
//        return city;
//    }
//
//    /**
//     *
//     * @param city
//     */
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public String getState() {
//        return state;
//    }
//
//    /**
//     *
//     * @param state
//     */
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public String getCountry() {
//        return country;
//    }
//
//    /**
//     *
//     * @param country
//     */
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    /**
//     *
//     * @param zipCode
//     */
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
    @Override
    public String toString() {
        return "SignUpForm{" + "emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", phone=" + phone + ",timezone=" + timezone + ", address=" + address + ", city=" + city + ", state=" + state + ", country=" + country + ", zipCode=" + zipCode +  ", altEmailID=" + altEmailID +'}';
    }

    public String getAltEmailID() {
        return altEmailID;
    }

    public void setAltEmailID(String altEmailID) {
        this.altEmailID = altEmailID;
    }
}
