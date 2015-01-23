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
@Table(name = "videotrackhistory")
public class Videotrackhistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VideoTrackId")
    private Integer videoTrackId;
    @Basic(optional = false)
    @Column(name = "TrackDate")
    @Temporal(TemporalType.DATE)
    private Date trackDate;
    @Basic(optional = false)
    @Column(name = "VideoKeywordID")
    private int videoKeywordID;
    @Basic(optional = false)
    @Column(name = "VideoKeyword")
    private String videoKeyword;
    @Basic(optional = false)
    @Column(name = "VideoEngine")
    private String videoEngine;
    @Basic(optional = false)
    @Column(name = "VideoRank")
    private int videoRank;
    @Basic(optional = false)
    @Column(name = "VideoURL")
    private String videoURL;

    public Videotrackhistory() {
    }

    public Videotrackhistory(Integer videoTrackId) {
        this.videoTrackId = videoTrackId;
    }

    public Videotrackhistory(Integer videoTrackId, Date trackDate, int videoKeywordID, String videoKeyword, String videoEngine, int videoRank, String videoURL) {
        this.videoTrackId = videoTrackId;
        this.trackDate = trackDate;
        this.videoKeywordID = videoKeywordID;
        this.videoKeyword = videoKeyword;
        this.videoEngine = videoEngine;
        this.videoRank = videoRank;
        this.videoURL = videoURL;
    }

    public Integer getVideoTrackId() {
        return videoTrackId;
    }

    public void setVideoTrackId(Integer videoTrackId) {
        this.videoTrackId = videoTrackId;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public int getVideoKeywordID() {
        return videoKeywordID;
    }

    public void setVideoKeywordID(int videoKeywordID) {
        this.videoKeywordID = videoKeywordID;
    }

    public String getVideoKeyword() {
        return videoKeyword;
    }

    public void setVideoKeyword(String videoKeyword) {
        this.videoKeyword = videoKeyword;
    }

    public String getVideoEngine() {
        return videoEngine;
    }

    public void setVideoEngine(String videoEngine) {
        this.videoEngine = videoEngine;
    }

    public int getVideoRank() {
        return videoRank;
    }

    public void setVideoRank(int videoRank) {
        this.videoRank = videoRank;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (videoTrackId != null ? videoTrackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videotrackhistory)) {
            return false;
        }
        Videotrackhistory other = (Videotrackhistory) object;
        if ((this.videoTrackId == null && other.videoTrackId != null) || (this.videoTrackId != null && !this.videoTrackId.equals(other.videoTrackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Videotrackhistory[ videoTrackId=" + videoTrackId + " ]";
    }
    
}
