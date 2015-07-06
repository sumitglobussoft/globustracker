/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ranktracker.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "reseller")
public class Reseller implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ResellerId")
    private Long resellerId;
    @Basic(optional = false)
    @Column(name = "PaymentID")
    private long paymentID;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "Phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @Column(name = "Country")
    private String country;
    @Basic(optional = false)
    @Column(name = "ZipCode")
    private int zipCode;
    @Basic(optional = false)
    @Column(name = "AllowedUserCount")
    private int allowedUserCount;
    @Basic(optional = false)
    @Column(name = "ActiveUserCount")
    private int activeUserCount;
    @Basic(optional = false)
    @Column(name = "AllowedCampaignsCount")
    private int allowedCampaignsCount;
    @Basic(optional = false)
    @Column(name = "ActiveCampaignsCount")
    private int activeCampaignsCount;
    @Basic(optional = false)
    @Column(name = "AllowedKeywordCount")
    private int allowedKeywordCount;
    @Basic(optional = false)
    @Column(name = "ActiveKeywordCount")
    private int activeKeywordCount;
    @Basic(optional = false)
    @Column(name = "TimezoneID")
    private String timezoneID;
    @Basic(optional = false)
    @Column(name = "TimezoneValue")
    private String timezoneValue;
    @Basic(optional = false)
    @Column(name = "AlertEmailID")
    private String alertEmailID;
    @Basic(optional = false)
    @Column(name = "AlertNotificationCount")
    private String alertNotificationCount;
    @Basic(optional = false)
    @Column(name = "CompanyURLLink")
    private String companyURLLink;
    @Basic(optional = false)
    @Column(name = "CompanyLogoLink")
    private String companyLogoLink;
    @Basic(optional = false)
    @Column(name = "CompanyDescription")
    private String companyDescription;

    public Reseller() {
    }

    public Reseller(Long resellerId) {
        this.resellerId = resellerId;
    }

    public Reseller(Long resellerId, long paymentID, String firstName, String lastName, String phone, String address, String city, String state, String country, int zipCode, int allowedUserCount, int activeUserCount, int allowedCampaignsCount, int activeCampaignsCount, int allowedKeywordCount, int activeKeywordCount, String timezoneID, String timezoneValue, String alertEmailID, String alertNotificationCount, String companyURLLink, String companyLogoLink, String companyDescription) {
        this.resellerId = resellerId;
        this.paymentID = paymentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.allowedUserCount = allowedUserCount;
        this.activeUserCount = activeUserCount;
        this.allowedCampaignsCount = allowedCampaignsCount;
        this.activeCampaignsCount = activeCampaignsCount;
        this.allowedKeywordCount = allowedKeywordCount;
        this.activeKeywordCount = activeKeywordCount;
        this.timezoneID = timezoneID;
        this.timezoneValue = timezoneValue;
        this.alertEmailID = alertEmailID;
        this.alertNotificationCount = alertNotificationCount;
        this.companyURLLink = companyURLLink;
        this.companyLogoLink = companyLogoLink;
        this.companyDescription = companyDescription;
    }

    public Long getResellerId() {
        return resellerId;
    }

    public void setResellerId(Long resellerId) {
        this.resellerId = resellerId;
    }

    public long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(long paymentID) {
        this.paymentID = paymentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getAllowedUserCount() {
        return allowedUserCount;
    }

    public void setAllowedUserCount(int allowedUserCount) {
        this.allowedUserCount = allowedUserCount;
    }

    public int getActiveUserCount() {
        return activeUserCount;
    }

    public void setActiveUserCount(int activeUserCount) {
        this.activeUserCount = activeUserCount;
    }

    public int getAllowedCampaignsCount() {
        return allowedCampaignsCount;
    }

    public void setAllowedCampaignsCount(int allowedCampaignsCount) {
        this.allowedCampaignsCount = allowedCampaignsCount;
    }

    public int getActiveCampaignsCount() {
        return activeCampaignsCount;
    }

    public void setActiveCampaignsCount(int activeCampaignsCount) {
        this.activeCampaignsCount = activeCampaignsCount;
    }

    public int getAllowedKeywordCount() {
        return allowedKeywordCount;
    }

    public void setAllowedKeywordCount(int allowedKeywordCount) {
        this.allowedKeywordCount = allowedKeywordCount;
    }

    public int getActiveKeywordCount() {
        return activeKeywordCount;
    }

    public void setActiveKeywordCount(int activeKeywordCount) {
        this.activeKeywordCount = activeKeywordCount;
    }

    public String getTimezoneID() {
        return timezoneID;
    }

    public void setTimezoneID(String timezoneID) {
        this.timezoneID = timezoneID;
    }

    public String getTimezoneValue() {
        return timezoneValue;
    }

    public void setTimezoneValue(String timezoneValue) {
        this.timezoneValue = timezoneValue;
    }

    public String getAlertEmailID() {
        return alertEmailID;
    }

    public void setAlertEmailID(String alertEmailID) {
        this.alertEmailID = alertEmailID;
    }

    public String getAlertNotificationCount() {
        return alertNotificationCount;
    }

    public void setAlertNotificationCount(String alertNotificationCount) {
        this.alertNotificationCount = alertNotificationCount;
    }

    public String getCompanyURLLink() {
        return companyURLLink;
    }

    public void setCompanyURLLink(String companyURLLink) {
        this.companyURLLink = companyURLLink;
    }

    public String getCompanyLogoLink() {
        return companyLogoLink;
    }

    public void setCompanyLogoLink(String companyLogoLink) {
        this.companyLogoLink = companyLogoLink;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resellerId != null ? resellerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reseller)) {
            return false;
        }
        Reseller other = (Reseller) object;
        if ((this.resellerId == null && other.resellerId != null) || (this.resellerId != null && !this.resellerId.equals(other.resellerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Reseller[ resellerId=" + resellerId + " ]";
    }
    
}
