package globuswoo.entity;
// Generated May 23, 2013 8:20:10 PM by Hibernate Tools 3.2.1.GA

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Socialtrackhistory generated manually
 */
@Entity
@Table(name = "socialtrackhistory")
@XmlRootElement
public class Socialtrackhistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TrackId", nullable = false)
    private Integer trackId;
    @Column(name = "TrackDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date trackDate;
    @Column(name = "SocialSignalUrlID")
    private Integer socialSignalUrlId;
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

    private static final long serialVersionUID = 1L;

    public Socialtrackhistory() {
    }

    public Socialtrackhistory(Integer trackId) {
        this.trackId = trackId;
    }
   
    public Socialtrackhistory(Integer trackId, Date trackDate) {
        this.trackId = trackId;
        this.trackDate = trackDate;
    }

    public Socialtrackhistory(Date trackDate, Integer socialSignalUrlId, Integer faceBookLike, Integer faceBookShare, Integer tweetCount, Integer pinterestPin, Integer googlePlus, Integer linkedInShare, Integer redittVote, Integer stumbleUponStumble) {
        this.trackDate = trackDate;
        this.socialSignalUrlId = socialSignalUrlId;
        this.faceBookLike = faceBookLike;
        this.faceBookShare = faceBookShare;
        this.tweetCount = tweetCount;
        this.pinterestPin = pinterestPin;
        this.googlePlus = googlePlus;
        this.linkedInShare = linkedInShare;
        this.redittVote = redittVote;
        this.stumbleUponStumble = stumbleUponStumble;
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

    public Integer getSocialSignalUrlId() {
        return socialSignalUrlId;
    }

    public void setSocialSignalUrlId(Integer socialSignalUrlId) {
        this.socialSignalUrlId = socialSignalUrlId;
    }
   
 


}


