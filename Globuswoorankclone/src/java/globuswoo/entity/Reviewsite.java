/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "reviewsite", catalog = "ranktracker", schema = "")
public class Reviewsite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ReviewSiteId", nullable = false)
    private Integer reviewSiteId;
    @Basic(optional = false)
    @Column(name = "ReviewSiteURL", nullable = false, length = 255)
    private String reviewSiteURL;
    @Basic(optional = false)
    @Column(name = "AddedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Basic(optional = false)
    @Column(name = "Visibility", nullable = false)
    private short visibility;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerID", nullable = false)
    @ManyToOne(optional = false)
    private Alertsdata customerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewSiteId")
    private Collection<Socialreview> socialreviewCollection;

    public Reviewsite() {
    }

    public Reviewsite(Integer reviewSiteId) {
        this.reviewSiteId = reviewSiteId;
    }

    public Reviewsite(Integer reviewSiteId, String reviewSiteURL, Date addedDate, short visibility) {
        this.reviewSiteId = reviewSiteId;
        this.reviewSiteURL = reviewSiteURL;
        this.addedDate = addedDate;
        this.visibility = visibility;
    }

    public Integer getReviewSiteId() {
        return reviewSiteId;
    }

    public void setReviewSiteId(Integer reviewSiteId) {
        this.reviewSiteId = reviewSiteId;
    }

    public String getReviewSiteURL() {
        return reviewSiteURL;
    }

    public void setReviewSiteURL(String reviewSiteURL) {
        this.reviewSiteURL = reviewSiteURL;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public short getVisibility() {
        return visibility;
    }

    public void setVisibility(short visibility) {
        this.visibility = visibility;
    }

    public Alertsdata getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Alertsdata customerId) {
        this.customerId = customerId;
    }

    @XmlTransient
    public Collection<Socialreview> getSocialreviewCollection() {
        return socialreviewCollection;
    }

    public void setSocialreviewCollection(Collection<Socialreview> socialreviewCollection) {
        this.socialreviewCollection = socialreviewCollection;
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
