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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "socialreview")
public class Socialreview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SocialreviewId")
    private Integer socialreviewId;
    @Basic(optional = false)
    @Column(name = "CustomerId")
    private int customerId;
    @Basic(optional = false)
    @Column(name = "FacebookURL")
    private int facebookURL;
    @Basic(optional = false)
    @Column(name = "Facebookabout")
    private int facebookabout;
    @Basic(optional = false)
    @Lob
    @Column(name = "Facebookcoverphoto")
    private byte[] facebookcoverphoto;
    @Basic(optional = false)
    @Column(name = "Facebooklikes")
    private int facebooklikes;
    @Basic(optional = false)
    @Column(name = "Facebookname")
    private int facebookname;
    @Basic(optional = false)
    @Column(name = "Facebooktalkingabout")
    private int facebooktalkingabout;
    @Basic(optional = false)
    @Column(name = "Visibility")
    private int visibility;
    @JoinColumn(name = "ReviewSiteId", referencedColumnName = "ReviewSiteId")
    @ManyToOne(optional = false)
    private Reviewsite reviewSiteId;

    public Socialreview() {
    }

    public Socialreview(Integer socialreviewId) {
        this.socialreviewId = socialreviewId;
    }

    public Socialreview(Integer socialreviewId, int customerId, int facebookURL, int facebookabout, byte[] facebookcoverphoto, int facebooklikes, int facebookname, int facebooktalkingabout, int visibility) {
        this.socialreviewId = socialreviewId;
        this.customerId = customerId;
        this.facebookURL = facebookURL;
        this.facebookabout = facebookabout;
        this.facebookcoverphoto = facebookcoverphoto;
        this.facebooklikes = facebooklikes;
        this.facebookname = facebookname;
        this.facebooktalkingabout = facebooktalkingabout;
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

    public int getFacebookURL() {
        return facebookURL;
    }

    public void setFacebookURL(int facebookURL) {
        this.facebookURL = facebookURL;
    }

    public int getFacebookabout() {
        return facebookabout;
    }

    public void setFacebookabout(int facebookabout) {
        this.facebookabout = facebookabout;
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

    public int getFacebookname() {
        return facebookname;
    }

    public void setFacebookname(int facebookname) {
        this.facebookname = facebookname;
    }

    public int getFacebooktalkingabout() {
        return facebooktalkingabout;
    }

    public void setFacebooktalkingabout(int facebooktalkingabout) {
        this.facebooktalkingabout = facebooktalkingabout;
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
