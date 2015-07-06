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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "socialtrackhistory")
public class Socialtrackhistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TrackId")
    private Integer trackId;
    @Basic(optional = false)
    @Column(name = "TrackDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trackDate;
    @Column(name = "SocialSignalUrlID")
    private Integer socialSignalUrlID;
    @Column(name = "FaceBookLike")
    private Integer faceBookLike;
    @Column(name = "FaceBookShare")
    private Integer faceBookShare;
    @Column(name = "TweetCount")
    private Integer tweetCount;
    @Column(name = "PinterestPin")
    private Integer pinterestPin;
    @Column(name = "GooglePlus")
    private Integer googlePlus;
    @Column(name = "LinkedInShare")
    private Integer linkedInShare;
    @Column(name = "RedittVote")
    private Integer redittVote;
    @Column(name = "StumbleUponStumble")
    private Integer stumbleUponStumble;

    public Socialtrackhistory() {
    }

    public Socialtrackhistory(Integer trackId) {
        this.trackId = trackId;
    }

    public Socialtrackhistory(Integer trackId, Date trackDate) {
        this.trackId = trackId;
        this.trackDate = trackDate;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public Integer getSocialSignalUrlID() {
        return socialSignalUrlID;
    }

    public void setSocialSignalUrlID(Integer socialSignalUrlID) {
        this.socialSignalUrlID = socialSignalUrlID;
    }

    public Integer getFaceBookLike() {
        return faceBookLike;
    }

    public void setFaceBookLike(Integer faceBookLike) {
        this.faceBookLike = faceBookLike;
    }

    public Integer getFaceBookShare() {
        return faceBookShare;
    }

    public void setFaceBookShare(Integer faceBookShare) {
        this.faceBookShare = faceBookShare;
    }

    public Integer getTweetCount() {
        return tweetCount;
    }

    public void setTweetCount(Integer tweetCount) {
        this.tweetCount = tweetCount;
    }

    public Integer getPinterestPin() {
        return pinterestPin;
    }

    public void setPinterestPin(Integer pinterestPin) {
        this.pinterestPin = pinterestPin;
    }

    public Integer getGooglePlus() {
        return googlePlus;
    }

    public void setGooglePlus(Integer googlePlus) {
        this.googlePlus = googlePlus;
    }

    public Integer getLinkedInShare() {
        return linkedInShare;
    }

    public void setLinkedInShare(Integer linkedInShare) {
        this.linkedInShare = linkedInShare;
    }

    public Integer getRedittVote() {
        return redittVote;
    }

    public void setRedittVote(Integer redittVote) {
        this.redittVote = redittVote;
    }

    public Integer getStumbleUponStumble() {
        return stumbleUponStumble;
    }

    public void setStumbleUponStumble(Integer stumbleUponStumble) {
        this.stumbleUponStumble = stumbleUponStumble;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackId != null ? trackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socialtrackhistory)) {
            return false;
        }
        Socialtrackhistory other = (Socialtrackhistory) object;
        if ((this.trackId == null && other.trackId != null) || (this.trackId != null && !this.trackId.equals(other.trackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Socialtrackhistory[ trackId=" + trackId + " ]";
    }
    
}
