/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ranktracker.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "campaigns")
public class Campaigns implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CampaignID")
    private Integer campaignID;
    @Basic(optional = false)
    @Column(name = "Campaign")
    private String campaign;
    @Basic(optional = false)
    @Column(name = "CampaignType")
    private String campaignType;
    @Column(name = "ResellerId")
    private Integer resellerId;
    @Column(name = "Visibility")
    private Integer visibility;
    @Basic(optional = false)
    @Column(name = "ViewKey")
    private String viewKey;
    @Column(name = "ReportEmailID")
    private String reportEmailID;
    @Column(name = "ReportFrequency")
    private Integer reportFrequency;
    @Column(name = "MailSentOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date mailSentOn;
    @Column(name = "RankRefresher")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rankRefresher;
    @Column(name = "RankRefresherStatus")
    private Integer rankRefresherStatus;
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "CompanyURLLink")
    private String companyURLLink;
    @Column(name = "CompanyLogoLink")
    private String companyLogoLink;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campaignID")
    private Collection<Seokeyworddetails> seokeyworddetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campaigns")
    private Collection<Campaignkeywords> campaignkeywordsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campaignID")
    private Collection<Videokeywords> videokeywordsCollection;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "campaignID")
    private Collection<Socialsignalurls> socialsignalurlsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campaignID")
    private Collection<Serpkeywords> serpkeywordsCollection;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerID;

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

    public Integer getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Integer campaignID) {
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

    public String getReportEmailID() {
        return reportEmailID;
    }

    public void setReportEmailID(String reportEmailID) {
        this.reportEmailID = reportEmailID;
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

    public Collection<Seokeyworddetails> getSeokeyworddetailsCollection() {
        return seokeyworddetailsCollection;
    }

    public void setSeokeyworddetailsCollection(Collection<Seokeyworddetails> seokeyworddetailsCollection) {
        this.seokeyworddetailsCollection = seokeyworddetailsCollection;
    }

    public Collection<Campaignkeywords> getCampaignkeywordsCollection() {
        return campaignkeywordsCollection;
    }

    public void setCampaignkeywordsCollection(Collection<Campaignkeywords> campaignkeywordsCollection) {
        this.campaignkeywordsCollection = campaignkeywordsCollection;
    }

    public Collection<Videokeywords> getVideokeywordsCollection() {
        return videokeywordsCollection;
    }

    public void setVideokeywordsCollection(Collection<Videokeywords> videokeywordsCollection) {
        this.videokeywordsCollection = videokeywordsCollection;
    }

    public Collection<Socialsignalurls> getSocialsignalurlsCollection() {
        return socialsignalurlsCollection;
    }

    public void setSocialsignalurlsCollection(Collection<Socialsignalurls> socialsignalurlsCollection) {
        this.socialsignalurlsCollection = socialsignalurlsCollection;
    }

    public Collection<Serpkeywords> getSerpkeywordsCollection() {
        return serpkeywordsCollection;
    }

    public void setSerpkeywordsCollection(Collection<Serpkeywords> serpkeywordsCollection) {
        this.serpkeywordsCollection = serpkeywordsCollection;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
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
        return "ranktracker.entity.Campaigns[ campaignID=" + campaignID + " ]";
    }
    
}
