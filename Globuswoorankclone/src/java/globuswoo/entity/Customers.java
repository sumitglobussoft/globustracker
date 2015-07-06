package globuswoo.entity;
// Generated May 23, 2013 8:20:10 PM by Hibernate Tools 3.2.1.GA

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "customers")
@XmlRootElement
public class Customers implements Serializable {
    @Basic(optional = false)
    @Column(name = "ActiveKeywordCount", nullable = false)
    private int activeKeywordCount;
    @Basic(optional = false)
    @Column(name = "ActiveVideoKeywordCount", nullable = false)
    private int activeVideoKeywordCount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
    private Collection<Alertsdata> alertsdataCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CustomerID", nullable = false)
    private Integer customerId;
    @Column(name = "ResellerId")
    private Integer resellerId;
    @Column(name = "FirstName", length = 20)
    private String firstName;
    @Column(name = "LastName", length = 20)
    private String lastName;
    @Column(name = "Phone", length = 30)
    private String phone;
    @Column(name = "Address", length = 50)
    private String address;
    @Column(name = "City", length = 20)
    private String city;
    @Column(name = "State", length = 20)
    private String state;
    @Column(name = "Country", length = 20)
    private String country;
    @Basic(optional = false)
    @Column(name = "ZipCode", nullable = false)
    private int zipCode;
    @Basic(optional = false)
    @Column(name = "AllowedUserCount", nullable = false)
    private int allowedUserCount;
    @Basic(optional = false)
    @Column(name = "ActiveUserCount", nullable = false)
    private int activeUserCount;
    @Basic(optional = false)
    @Column(name = "AllowedCampaignsCount", nullable = false)
    private int allowedCampaignsCount;
    @Basic(optional = false)
    @Column(name = "ActiveSerpCampaignsCount", nullable = false)
    private int activeSerpCampaignsCount;
    @Basic(optional = false)
    @Column(name = "ActiveVideoCampaignCount", nullable = false)
    private int activeVideoCampaignCount;
    @Basic(optional = false)
    @Column(name = "AllowedKeywordCount", nullable = false)
    private int allowedKeywordCount;
    @Column(name = "TimezoneID", length = 50)
    private String timezoneID;
    @Column(name = "TimezoneValue", length = 50)
    private String timezoneValue;
    @Column(name = "AlertEmailID", length = 50)
    private String alertEmailID;
    @Column(name = "AlertNotificationCount", length = 50)
    private String alertNotificationCount;
    @Column(name = "CompanyName", length = 120)
    private String companyName;
    @Column(name = "CompanyURLLink", length = 200)
    private String companyURLLink;
    @Column(name = "CompanyLogoLink", length = 200)
    private String companyLogoLink;
    @Column(name = "CompanyDescription", length = 500)
    private String companyDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private Set<Users> usersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private Set<Mailhistory> mailhistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private Set<Campaigns> campaignsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customers")
    private Set<Payments> paymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private Set<Displaysettings> displaysettingsCollection;

    public Customers() {
    }

    public Customers(Integer customerID) {
        this.customerId = customerID;
    }

    public Customers(Integer customerID, int zipCode, int allowedUserCount, int activeUserCount, int allowedCampaignsCount, int activeSerpCampaignsCount, int activeVideoCampaignCount, int allowedKeywordCount) {
        this.customerId = customerID;
        this.zipCode = zipCode;
        this.allowedUserCount = allowedUserCount;
        this.activeUserCount = activeUserCount;
        this.allowedCampaignsCount = allowedCampaignsCount;
        this.activeSerpCampaignsCount = activeSerpCampaignsCount;
        this.activeVideoCampaignCount = activeVideoCampaignCount;
        this.allowedKeywordCount = allowedKeywordCount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerID) {
        this.customerId = customerID;
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

    @XmlTransient
    public Set<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Set<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Set<Mailhistory> getMailhistoryCollection() {
        return mailhistoryCollection;
    }

    public void setMailhistoryCollection(Set<Mailhistory> mailhistoryCollection) {
        this.mailhistoryCollection = mailhistoryCollection;
    }

    @XmlTransient
    public Set<Campaigns> getCampaignsCollection() {
        return campaignsCollection;
    }

    public void setCampaignsCollection(Set<Campaigns> campaignsCollection) {
        this.campaignsCollection = campaignsCollection;
    }

    @XmlTransient
    public Set<Payments> getPaymentsCollection() {
        return paymentsCollection;
    }

    public void setPaymentsCollection(Set<Payments> paymentsCollection) {
        this.paymentsCollection = paymentsCollection;
    }

    @XmlTransient
    public Set<Displaysettings> getDisplaysettingsCollection() {
        return displaysettingsCollection;
    }

    public void setDisplaysettingsCollection(Set<Displaysettings> displaysettingsCollection) {
        this.displaysettingsCollection = displaysettingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customers[ customerID=" + customerId + " ]";
    }

    @XmlTransient
    public Collection<Alertsdata> getAlertsdataCollection() {
        return alertsdataCollection;
    }

    public void setAlertsdataCollection(Collection<Alertsdata> alertsdataCollection) {
        this.alertsdataCollection = alertsdataCollection;
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
    
}
