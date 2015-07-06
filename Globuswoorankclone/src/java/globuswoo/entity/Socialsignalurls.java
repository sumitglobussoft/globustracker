/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author GLB-115
 */
@Entity
@Table(name = "socialsignalurls")
public class Socialsignalurls implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SocialSignalUrlID", nullable = false)
    private Integer socialSignalUrlID;
    @Column(name = "SocialSignalUrl", nullable = false, length = 255)
    private String socialSignalUrl;
    @Column(name = "FacebookLike")
    private Integer facebookLike;
    @Column(name = "FacebookShare")
    private Integer facebookShare;
    @Column(name = "TweetCount")
    private Integer tweetCount;
    @Column(name = "PinterestPins")
    private Integer pinterestPins;
    @Column(name = "GooglePlusLikes")
    private Integer googlePlusLikes;
    @Column(name = "LinkedInShares")
    private Integer linkedInShares;
    @Column(name = "RedittVotes")
    private Integer redittVotes;
    @Column(name = "StumbleUponLikes")
    private Integer stumbleUponLikes;
    @Column(name = "Visibility", nullable = false)
    private int visibility;
    @JoinColumn(name = "CampaignID", referencedColumnName = "CampaignID", nullable = false)
    @ManyToOne(optional = false)
    private Campaigns campaignID;

    public Socialsignalurls() {
    }

    public Socialsignalurls(Integer socialSignalUrlID) {
        this.socialSignalUrlID = socialSignalUrlID;
    }

    public Socialsignalurls(Integer socialSignalUrlID, String socialSignalUrl, int visibility) {
        this.socialSignalUrlID = socialSignalUrlID;
        this.socialSignalUrl = socialSignalUrl;
        this.visibility = visibility;
    }

    public Integer getSocialSignalUrlID() {
        return socialSignalUrlID;
    }

    public void setSocialSignalUrlID(Integer socialSignalUrlID) {
        this.socialSignalUrlID = socialSignalUrlID;
    }

    public String getSocialSignalUrl() {
        return socialSignalUrl;
    }

    public void setSocialSignalUrl(String socialSignalUrl) {
        this.socialSignalUrl = socialSignalUrl;
    }

    public Integer getFacebookLike() {
        return facebookLike;
    }

    public void setFacebookLike(Integer facebookLike) {
        this.facebookLike = facebookLike;
    }

    public Integer getFacebookShare() {
        return facebookShare;
    }

    public void setFacebookShare(Integer facebookShare) {
        this.facebookShare = facebookShare;
    }

    public Integer getTweetCount() {
        return tweetCount;
    }

    public void setTweetCount(Integer tweetCount) {
        this.tweetCount = tweetCount;
    }

    public Integer getPinterestPins() {
        return pinterestPins;
    }

    public void setPinterestPins(Integer pinterestPins) {
        this.pinterestPins = pinterestPins;
    }

    public Integer getGooglePlusLikes() {
        return googlePlusLikes;
    }

    public void setGooglePlusLikes(Integer googlePlusLikes) {
        this.googlePlusLikes = googlePlusLikes;
    }

    public Integer getLinkedInShares() {
        return linkedInShares;
    }

    public void setLinkedInShares(Integer linkedInShares) {
        this.linkedInShares = linkedInShares;
    }

    public Integer getRedittVotes() {
        return redittVotes;
    }

    public void setRedittVotes(Integer redittVotes) {
        this.redittVotes = redittVotes;
    }

    public Integer getStumbleUponLikes() {
        return stumbleUponLikes;
    }

    public void setStumbleUponLikes(Integer stumbleUponLikes) {
        this.stumbleUponLikes = stumbleUponLikes;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Campaigns getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(Campaigns campaignID) {
        this.campaignID = campaignID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (socialSignalUrlID != null ? socialSignalUrlID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socialsignalurls)) {
            return false;
        }
        Socialsignalurls other = (Socialsignalurls) object;
        if ((this.socialSignalUrlID == null && other.socialSignalUrlID != null) || (this.socialSignalUrlID != null && !this.socialSignalUrlID.equals(other.socialSignalUrlID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Socialsignalurls[ socialSignalUrlID=" + socialSignalUrlID + " ]";
    }
}
