/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ranktracker.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "customers")
public class Customers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CustomerID")
    private Integer customerID;
    @Column(name = "ResellerId")
    private Integer resellerId;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    @Column(name = "State")
    private String state;
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
    @Column(name = "ActiveSerpCampaignsCount")
    private int activeSerpCampaignsCount;
    @Basic(optional = false)
    @Column(name = "ActiveVideoCampaignCount")
    private int activeVideoCampaignCount;
    @Basic(optional = false)
    @Column(name = "AllowedKeywordCount")
    private int allowedKeywordCount;
    @Basic(optional = false)
    @Column(name = "ActiveKeywordCount")
    private int activeKeywordCount;
    @Basic(optional = false)
    @Column(name = "ActiveVideoKeywordCount")
    private int activeVideoKeywordCount;
    @Column(name = "TimezoneID")
    private String timezoneID;
    @Column(name = "TimezoneValue")
    private String timezoneValue;
    @Column(name = "AlertEmailID")
    private String alertEmailID;
    @Column(name = "AlertNotificationCount")
    private String alertNotificationCount;
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "CompanyURLLink")
    private String companyURLLink;
    @Column(name = "CompanyLogoLink")
    private String companyLogoLink;
    @Column(name = "CompanyDescription")
    private String companyDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
    private Collection<Users> usersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
    private Collection<Alertsdata> alertsdataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<Displaysettings> displaysettingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<Mailhistory> mailhistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
    private Collection<Campaigns> campaignsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Collection<Reviewsite> reviewsiteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
    private Collection<Payments> paymentsCollection;

    public Customers() {
    }

    public Customers(Integer customerID) {
        this.customerID = customerID;
    }

    public Customers(Integer customerID, int zipCode, int allowedUserCount, int activeUserCount, int allowedCampaignsCount, int activeSerpCampaignsCount, int activeVideoCampaignCount, int allowedKeywordCount, int activeKeywordCount, int activeVideoKeywordCount) {
        this.customerID = customerID;
        this.zipCode = zipCode;
        this.allowedUserCount = allowedUserCount;
        this.activeUserCount = activeUserCount;
        this.allowedCampaignsCount = allowedCampaignsCount;
        this.activeSerpCampaignsCount = activeSerpCampaignsCount;
        this.activeVideoCampaignCount = activeVideoCampaignCount;
        this.allowedKeywordCount = allowedKeywordCount;
        this.activeKeywordCount = activeKeywordCount;
        this.activeVideoKeywordCount = activeVideoKeywordCount;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getResellerId() {
        return resellerId;
    }

    public void setResellerId(Integer resellerId) {
        this.resellerId = resellerId;
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

    public int getActiveSerpCampaignsCount() {
        return activeSerpCampaignsCount;
    }

    public void setActiveSerpCampaignsCount(int activeSerpCampaignsCount) {
        this.activeSerpCampaignsCount = activeSerpCampaignsCount;
    }

    public int getActiveVideoCampaignCount() {
        return activeVideoCampaignCount;
    }

    public void setActiveVideoCampaignCount(int activeVideoCampaignCount) {
        this.activeVideoCampaignCount = activeVideoCampaignCount;
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

    public int getActiveVideoKeywordCount() {
        return activeVideoKeywordCount;
    }

    public void setActiveVideoKeywordCount(int activeVideoKeywordCount) {
        this.activeVideoKeywordCount = activeVideoKeywordCount;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Collection<Alertsdata> getAlertsdataCollection() {
        return alertsdataCollection;
    }

    public void setAlertsdataCollection(Collection<Alertsdata> alertsdataCollection) {
        this.alertsdataCollection = alertsdataCollection;
    }

    public Collection<Displaysettings> getDisplaysettingsCollection() {
        return displaysettingsCollection;
    }

    public void setDisplaysettingsCollection(Collection<Displaysettings> displaysettingsCollection) {
        this.displaysettingsCollection = displaysettingsCollection;
    }

    public Collection<Mailhistory> getMailhistoryCollection() {
        return mailhistoryCollection;
    }

    public void setMailhistoryCollection(Collection<Mailhistory> mailhistoryCollection) {
        this.mailhistoryCollection = mailhistoryCollection;
    }

    public Collection<Campaigns> getCampaignsCollection() {
        return campaignsCollection;
    }

    public void setCampaignsCollection(Collection<Campaigns> campaignsCollection) {
        this.campaignsCollection = campaignsCollection;
    }

    public Collection<Reviewsite> getReviewsiteCollection() {
        return reviewsiteCollection;
    }

    public void setReviewsiteCollection(Collection<Reviewsite> reviewsiteCollection) {
        this.reviewsiteCollection = reviewsiteCollection;
    }

    public Collection<Payments> getPaymentsCollection() {
        return paymentsCollection;
    }

    public void setPaymentsCollection(Collection<Payments> paymentsCollection) {
        this.paymentsCollection = paymentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Customers[ customerID=" + customerID + " ]";
    }

}
