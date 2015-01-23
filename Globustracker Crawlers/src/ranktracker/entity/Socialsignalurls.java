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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "socialsignalurls")
public class Socialsignalurls implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SocialSignalUrlID")
    private Integer socialSignalUrlID;
    @Basic(optional = false)
    @Column(name = "SocialSignalUrl")
    private String socialSignalUrl;
    @Basic(optional = false)
    @Column(name = "FacebookLike")
    private int facebookLike;
    @Basic(optional = false)
    @Column(name = "FacebookShare")
    private int facebookShare;
    @Basic(optional = false)
    @Column(name = "TweetCount")
    private int tweetCount;
    @Basic(optional = false)
    @Column(name = "PinterestPins")
    private int pinterestPins;
    @Basic(optional = false)
    @Column(name = "GooglePlusLikes")
    private int googlePlusLikes;
    @Basic(optional = false)
    @Column(name = "LinkedInShares")
    private int linkedInShares;
    @Basic(optional = false)
    @Column(name = "RedittVotes")
    private int redittVotes;
    @Basic(optional = false)
    @Column(name = "StumbleUponLikes")
    private int stumbleUponLikes;
    @Basic(optional = false)
    @Column(name = "Visibility")
    private int visibility;
    @JoinColumn(name = "CampaignID", referencedColumnName = "CampaignID")
    @ManyToOne(optional = false)
    private Campaigns campaignID;

    public Socialsignalurls() {
    }

    public Socialsignalurls(Integer socialSignalUrlID) {
        this.socialSignalUrlID = socialSignalUrlID;
    }

    public Socialsignalurls(Integer socialSignalUrlID, String socialSignalUrl, int facebookLike, int facebookShare, int tweetCount, int pinterestPins, int googlePlusLikes, int linkedInShares, int redittVotes, int stumbleUponLikes, int visibility) {
        this.socialSignalUrlID = socialSignalUrlID;
        this.socialSignalUrl = socialSignalUrl;
        this.facebookLike = facebookLike;
        this.facebookShare = facebookShare;
        this.tweetCount = tweetCount;
        this.pinterestPins = pinterestPins;
        this.googlePlusLikes = googlePlusLikes;
        this.linkedInShares = linkedInShares;
        this.redittVotes = redittVotes;
        this.stumbleUponLikes = stumbleUponLikes;
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

    public int getFacebookLike() {
        return facebookLike;
    }

    public void setFacebookLike(int facebookLike) {
        this.facebookLike = facebookLike;
    }

    public int getFacebookShare() {
        return facebookShare;
    }

    public void setFacebookShare(int facebookShare) {
        this.facebookShare = facebookShare;
    }

    public int getTweetCount() {
        return tweetCount;
    }

    public void setTweetCount(int tweetCount) {
        this.tweetCount = tweetCount;
    }

    public int getPinterestPins() {
        return pinterestPins;
    }

    public void setPinterestPins(int pinterestPins) {
        this.pinterestPins = pinterestPins;
    }

    public int getGooglePlusLikes() {
        return googlePlusLikes;
    }

    public void setGooglePlusLikes(int googlePlusLikes) {
        this.googlePlusLikes = googlePlusLikes;
    }

    public int getLinkedInShares() {
        return linkedInShares;
    }

    public void setLinkedInShares(int linkedInShares) {
        this.linkedInShares = linkedInShares;
    }

    public int getRedittVotes() {
        return redittVotes;
    }

    public void setRedittVotes(int redittVotes) {
        this.redittVotes = redittVotes;
    }

    public int getStumbleUponLikes() {
        return stumbleUponLikes;
    }

    public void setStumbleUponLikes(int stumbleUponLikes) {
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
