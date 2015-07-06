/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ranktracker.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "alertsdata")
public class Alertsdata implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AlertID")
    private Integer alertID;
    @Column(name = "ResellerId")
    private Integer resellerId;
    @Basic(optional = false)
    @Column(name = "Campaign")
    private String campaign;
    @Basic(optional = false)
    @Column(name = "Url")
    private String url;
    @Basic(optional = false)
    @Column(name = "Keyword")
    private String keyword;
    @Basic(optional = false)
    @Column(name = "Engine")
    private String engine;
    @Basic(optional = false)
    @Column(name = "PreviousRank")
    private int previousRank;
    @Basic(optional = false)
    @Column(name = "CurrentRank")
    private int currentRank;
    @Basic(optional = false)
    @Column(name = "TrackDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trackDate;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerID;

    public Alertsdata() {
    }

    public Alertsdata(Integer alertID) {
        this.alertID = alertID;
    }

    public Alertsdata(Integer alertID, String campaign, String url, String keyword, String engine, int previousRank, int currentRank, Date trackDate) {
        this.alertID = alertID;
        this.campaign = campaign;
        this.url = url;
        this.keyword = keyword;
        this.engine = engine;
        this.previousRank = previousRank;
        this.currentRank = currentRank;
        this.trackDate = trackDate;
    }

    public Integer getAlertID() {
        return alertID;
    }

    public void setAlertID(Integer alertID) {
        this.alertID = alertID;
    }

    public Integer getResellerId() {
        return resellerId;
    }

    public void setResellerId(Integer resellerId) {
        this.resellerId = resellerId;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getPreviousRank() {
        return previousRank;
    }

    public void setPreviousRank(int previousRank) {
        this.previousRank = previousRank;
    }

    public int getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(int currentRank) {
        this.currentRank = currentRank;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
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
        hash += (alertID != null ? alertID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alertsdata)) {
            return false;
        }
        Alertsdata other = (Alertsdata) object;
        if ((this.alertID == null && other.alertID != null) || (this.alertID != null && !this.alertID.equals(other.alertID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Alertsdata[ alertID=" + alertID + " ]";
    }
    
}
