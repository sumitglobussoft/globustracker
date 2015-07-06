/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "seokeyworddetails")
@XmlRootElement
public class Seokeyworddetails implements Serializable {
    @Basic(optional = false)
    @Column(name = "GooglePA", nullable = false)
    private short googlePA;
    @Basic(optional = false)
    @Column(name = "GoogleDA", nullable = false)
    private short googleDA;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SEOKeywordId", nullable = false)
    private Integer sEOKeywordId;
    @Basic(optional = false)
    @Column(name = "CustomerId", nullable = false)
    private int customerId;
    @Basic(optional = false)
    @Column(name = "CampaignId", nullable = false)
    private int campaignId;
    @Basic(optional = false)
    @Column(name = "SearchVolume", nullable = false)
    private int searchVolume;
    @Basic(optional = false)
    @Column(name = "GoogleCPC", nullable = false)
    private float googleCPC;
    @Basic(optional = false)
    @Column(name = "KeywordCompetition", nullable = false)
    private float keywordCompetition;
    @Basic(optional = false)
    @Column(name = "NumberofResult", nullable = false)
    private long numberofResult;
    @Basic(optional = false)
    @Column(name = "AddedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @JoinColumn(name = "KeywordId", referencedColumnName = "KeywordID", nullable = false)
    @ManyToOne(optional = false)
    private Serpkeywords keywordId;

    public Seokeyworddetails() {
    }

    public Seokeyworddetails(Integer sEOKeywordId) {
        this.sEOKeywordId = sEOKeywordId;
    }

    public Seokeyworddetails(Integer sEOKeywordId, int customerId, int campaignId, int searchVolume, float googleCPC, float keywordCompetition, long numberofResult, short googlePA, short googleDA, Date addedDate) {
        this.sEOKeywordId = sEOKeywordId;
        this.customerId = customerId;
        this.campaignId = campaignId;
        this.searchVolume = searchVolume;
        this.googleCPC = googleCPC;
        this.keywordCompetition = keywordCompetition;
        this.numberofResult = numberofResult;
        this.googlePA = googlePA;
        this.googleDA = googleDA;
        this.addedDate = addedDate;
    }

    public Integer getSEOKeywordId() {
        return sEOKeywordId;
    }

    public void setSEOKeywordId(Integer sEOKeywordId) {
        this.sEOKeywordId = sEOKeywordId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getSearchVolume() {
        return searchVolume;
    }

    public void setSearchVolume(int searchVolume) {
        this.searchVolume = searchVolume;
    }

    public float getGoogleCPC() {
        return googleCPC;
    }

    public void setGoogleCPC(float googleCPC) {
        this.googleCPC = googleCPC;
    }

    public float getKeywordCompetition() {
        return keywordCompetition;
    }

    public void setKeywordCompetition(float keywordCompetition) {
        this.keywordCompetition = keywordCompetition;
    }

    public long getNumberofResult() {
        return numberofResult;
    }

    public void setNumberofResult(long numberofResult) {
        this.numberofResult = numberofResult;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Serpkeywords getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Serpkeywords keywordId) {
        this.keywordId = keywordId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sEOKeywordId != null ? sEOKeywordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seokeyworddetails)) {
            return false;
        }
        Seokeyworddetails other = (Seokeyworddetails) object;
        if ((this.sEOKeywordId == null && other.sEOKeywordId != null) || (this.sEOKeywordId != null && !this.sEOKeywordId.equals(other.sEOKeywordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Seokeyworddetails[ sEOKeywordId=" + sEOKeywordId + " ]";
    }

    public short getGooglePA() {
        return googlePA;
    }

    public void setGooglePA(short googlePA) {
        this.googlePA = googlePA;
    }

    public short getGoogleDA() {
        return googleDA;
    }

    public void setGoogleDA(short googleDA) {
        this.googleDA = googleDA;
    }
    
}
