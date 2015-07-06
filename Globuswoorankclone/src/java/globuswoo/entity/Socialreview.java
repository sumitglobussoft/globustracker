/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "socialreview", catalog = "ranktracker", schema = "")
public class Socialreview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SocialreviewId", nullable = false)
    private Integer socialreviewId;
    @Basic(optional = false)
    @Column(name = "CustomerId", nullable = false)
    private int customerId;
    @Basic(optional = false)
    @Lob
    @Column(name = "Facebookcoverphoto", nullable = false)
    private byte[] facebookcoverphoto;
    @Basic(optional = false)
    @Column(name = "Facebooklikes", nullable = false)
    private int facebooklikes;
    @Basic(optional = false)
    @Column(name = "Facebooktalkingabout", nullable = false)
    private int facebooktalkingabout;
    @Basic(optional = false)
    @Column(name = "FacebookURL", nullable = false)
    private int facebookURL;
    @Basic(optional = false)
    @Column(name = "Facebookname", nullable = false)
    private int facebookname;
    @Basic(optional = false)
    @Column(name = "Facebookabout", nullable = false)
    private int facebookabout;
    @Basic(optional = false)
    @Column(name = "Visibility", nullable = false)
    private int visibility;
    @JoinColumn(name = "ReviewSiteId", referencedColumnName = "ReviewSiteId", nullable = false)
    @ManyToOne(optional = false)
    private Reviewsite reviewSiteId;

    public Socialreview() {
    }

    public Socialreview(Integer socialreviewId) {
        this.socialreviewId = socialreviewId;
    }

    public Socialreview(Integer socialreviewId, int customerId, byte[] facebookcoverphoto, int facebooklikes, int facebooktalkingabout, int facebookURL, int facebookname, int facebookabout, int visibility) {
        this.socialreviewId = socialreviewId;
        this.customerId = customerId;
        this.facebookcoverphoto = facebookcoverphoto;
        this.facebooklikes = facebooklikes;
        this.facebooktalkingabout = facebooktalkingabout;
        this.facebookURL = facebookURL;
        this.facebookname = facebookname;
        this.facebookabout = facebookabout;
        this.visibility = visibility;
    }

    public Integer getSocialreviewId() {
        return socialreviewId;
    }

    public void setSocialreviewId(Integer socialreviewId) {
        this.socialreviewId = socialreviewId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public byte[] getFacebookcoverphoto() {
        return facebookcoverphoto;
    }

    public void setFacebookcoverphoto(byte[] facebookcoverphoto) {
        this.facebookcoverphoto = facebookcoverphoto;
    }

    public int getFacebooklikes() {
        return facebooklikes;
    }

    public void setFacebooklikes(int facebooklikes) {
        this.facebooklikes = facebooklikes;
    }

    public int getFacebooktalkingabout() {
        return facebooktalkingabout;
    }

    public void setFacebooktalkingabout(int facebooktalkingabout) {
        this.facebooktalkingabout = facebooktalkingabout;
    }

    public int getFacebookURL() {
        return facebookURL;
    }

    public void setFacebookURL(int facebookURL) {
        this.facebookURL = facebookURL;
    }

    public int getFacebookname() {
        return facebookname;
    }

    public void setFacebookname(int facebookname) {
        this.facebookname = facebookname;
    }

    public int getFacebookabout() {
        return facebookabout;
    }

    public void setFacebookabout(int facebookabout) {
        this.facebookabout = facebookabout;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Reviewsite getReviewSiteId() {
        return reviewSiteId;
    }

    public void setReviewSiteId(Reviewsite reviewSiteId) {
        this.reviewSiteId = reviewSiteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (socialreviewId != null ? socialreviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socialreview)) {
            return false;
        }
        Socialreview other = (Socialreview) object;
        if ((this.socialreviewId == null && other.socialreviewId != null) || (this.socialreviewId != null && !this.socialreviewId.equals(other.socialreviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Socialreview[ socialreviewId=" + socialreviewId + " ]";
    }
    
}
