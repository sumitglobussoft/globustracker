package globuswoo.entity;
// Generated May 23, 2013 8:20:10 PM by Hibernate Tools 3.2.1.GA

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "campaigns")
@XmlRootElement
public class Campaigns implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campaignID")
    private Set<Socialsignalurls> socialsignalurls;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CampaignID", nullable = false)
    private Integer campaignID;
    @Basic(optional = false)
    @Column(name = "Campaign", nullable = false, length = 50)
    private String campaign;
    @Basic(optional = false)
    @Column(name = "CampaignType", nullable = false, length = 6)
    private String campaignType;
    @Column(name = "ResellerId")
    private Integer resellerId;
    @Column(name = "Visibility")
    private Integer visibility;
    @Basic(optional = false)
    @Column(name = "ViewKey", nullable = false, length = 100)
    private String viewKey;
    @Column(name = "ReportEmailID", length = 60)
    private String reportEmailId;
    @Column(name = "ReportFrequency")
    private Integer reportFrequency;
    @Column(name = "MailSentOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mailSentOn;
    @JoinTable(name = "campaignkeywords", joinColumns = {
        @JoinColumn(name = "CampaignId", referencedColumnName = "CampaignID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "KeywordID", referencedColumnName = "KeywordID", nullable = false)})
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Serpkeywords> keywordses = new HashSet<>(0);
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID", nullable = false)
    @ManyToOne(optional = false)
    private Customers customers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campaignID")
    private Set<Videokeywords> videokeywordses = new HashSet<>(0);
    @Column(name = "RankRefresher")
    @Temporal(TemporalType.DATE)
    private Date rankRefresher;
    @Column(name = "RankRefresherStatus")
    private Integer rankRefresherStatus;
    @Column(name = "CompanyName", length = 255)
    private String companyName;
    @Column(name = "CompanyURLLink", length = 255)
    private String companyURLLink;
    @Column(name = "CompanyLogoLink", length = 255)
    private String companyLogoLink;

    public Campaigns() {
    }

    public Campaigns(Integer campaignID) {
        this.campaignID = campaignID;
    }

    public Campaigns(Integer campaignID, String campaign, String campaignType, String viewKey) {
        this.campaignID = campaignID;
        this.campaign = campaign;
        this.campaignType = campaignType;
        this.viewKey = viewKey;
    }

    public Integer getCampaignId() {
        return campaignID;
    }

    public void setCampaignId(Integer campaignID) {
        this.campaignID = campaignID;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getCampaignType() {
        return campaignType;
    }

    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    public Integer getResellerId() {
        return resellerId;
    }

    public void setResellerId(Integer resellerId) {
        this.resellerId = resellerId;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getViewKey() {
        return viewKey;
    }

    public void setViewKey(String viewKey) {
        this.viewKey = viewKey;
    }

    public String getReportEmailId() {
        return reportEmailId;
    }

    public void setReportEmailId(String reportEmailID) {
        this.reportEmailId = reportEmailID;
    }

    public Integer getReportFrequency() {
        return reportFrequency;
    }

    public void setReportFrequency(Integer reportFrequency) {
        this.reportFrequency = reportFrequency;
    }

    public Date getMailSentOn() {
        return mailSentOn;
    }

    public void setMailSentOn(Date mailSentOn) {
        this.mailSentOn = mailSentOn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campaignID != null ? campaignID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campaigns)) {
            return false;
        }
        Campaigns other = (Campaigns) object;
        if ((this.campaignID == null && other.campaignID != null) || (this.campaignID != null && !this.campaignID.equals(other.campaignID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Campaigns[ campaignID=" + campaignID + " ]";
    }

    public Set<Serpkeywords> getKeywordses() {
        return keywordses;
    }

    public void setKeywordses(Set<Serpkeywords> keywordses) {
        this.keywordses = keywordses;
    }

    public Set<Videokeywords> getVideoKeywordses() {
        return videokeywordses;
    }

    public void setVideoKeywordses(Set<Videokeywords> videokeywordses) {
        this.videokeywordses = videokeywordses;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Date getRankRefresher() {
        return rankRefresher;
    }

    public void setRankRefresher(Date rankRefresher) {
        this.rankRefresher = rankRefresher;
    }

    public Integer getRankRefresherStatus() {
        return rankRefresherStatus;
    }

    public void setRankRefresherStatus(Integer rankRefresherStatus) {
        this.rankRefresherStatus = rankRefresherStatus;
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

    public Set<Socialsignalurls> getSocialsignalurls() {
        return socialsignalurls;
    }

    public void setSocialsignalurlsCollection(Set<Socialsignalurls> socialsignalurls) {
        this.socialsignalurls = socialsignalurls;
    }
}
