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
@Table(name = "reviewsite")
public class Reviewsite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReviewSiteId")
    private Integer reviewSiteId;
    @Basic(optional = false)
    @Column(name = "AddedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Basic(optional = false)
    @Column(name = "ReviewSiteURL")
    private String reviewSiteURL;
    @Basic(optional = false)
    @Column(name = "Visibility")
    private short visibility;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewSiteId")
    private Collection<Socialreview> socialreviewCollection;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerId;

    public Reviewsite() {
    }

    public Reviewsite(Integer reviewSiteId) {
        this.reviewSiteId = reviewSiteId;
    }

    public Reviewsite(Integer reviewSiteId, Date addedDate, String reviewSiteURL, short visibility) {
        this.reviewSiteId = reviewSiteId;
        this.addedDate = addedDate;
        this.reviewSiteURL = reviewSiteURL;
        this.visibility = visibility;
    }

    public Integer getReviewSiteId() {
        return reviewSiteId;
    }

    public void setReviewSiteId(Integer reviewSiteId) {
        this.reviewSiteId = reviewSiteId;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getReviewSiteURL() {
        return reviewSiteURL;
    }

    public void setReviewSiteURL(String reviewSiteURL) {
        this.reviewSiteURL = reviewSiteURL;
    }

    public short getVisibility() {
        return visibility;
    }

    public void setVisibility(short visibility) {
        this.visibility = visibility;
    }

    public Collection<Socialreview> getSocialreviewCollection() {
        return socialreviewCollection;
    }

    public void setSocialreviewCollection(Collection<Socialreview> socialreviewCollection) {
        this.socialreviewCollection = socialreviewCollection;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewSiteId != null ? reviewSiteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reviewsite)) {
            return false;
        }
        Reviewsite other = (Reviewsite) object;
        if ((this.reviewSiteId == null && other.reviewSiteId != null) || (this.reviewSiteId != null && !this.reviewSiteId.equals(other.reviewSiteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Reviewsite[ reviewSiteId=" + reviewSiteId + " ]";
    }
    
}
