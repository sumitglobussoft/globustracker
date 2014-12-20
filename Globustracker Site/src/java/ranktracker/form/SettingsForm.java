/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.form;

/**
 * Form class for storing information of Settings module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class SettingsForm {

    private String timezone;
    private String oldpassword;
    private String newpassword;
    private String companyName;
    private String companyUrl;
    private String companyLogo;
    private String companyDesc;
    private String alertEmail;
    private String alertMeAt;

    /**
     *
     * @return
     */
    public String getCompanyUrl() {
        return companyUrl;
    }

    /**
     *
     * @param companyUrl
     */
    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    /**
     *
     * @return
     */
    public String getCompanyLogo() {
        return companyLogo;
    }

    /**
     *
     * @param companyLogo
     */
    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    /**
     *
     * @return
     */
    public String getCompanyDesc() {
        return companyDesc;
    }

    /**
     *
     * @param companyDesc
     */
    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    /**
     *
     * @return
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     *
     * @param timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    /**
     *
     * @return
     */
    public String getOldpassword() {
        return oldpassword;
    }

    /**
     *
     * @param oldpassword
     */
    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    /**
     *
     * @return
     */
    public String getNewpassword() {
        return newpassword;
    }

    /**
     *
     * @param newpassword
     */
    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    /**
     *
     * @return
     */
    public String getAlertEmail() {
        return alertEmail;
    }

    /**
     *
     * @param alertEmail
     */
    public void setAlertEmail(String alertEmail) {
        this.alertEmail = alertEmail;
    }

    /**
     *
     * @return
     */
    public String getAlertMeAt() {
        return alertMeAt;
    }

    /**
     *
     * @param alertMeAt
     */
    public void setAlertMeAt(String alertMeAt) {
        this.alertMeAt = alertMeAt;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
