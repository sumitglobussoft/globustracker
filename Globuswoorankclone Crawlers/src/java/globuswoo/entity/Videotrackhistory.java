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
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
@Entity
@Table(name = "videotrackhistory")
@XmlRootElement
public class Videotrackhistory implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TrackId", nullable = false)
    private Integer trackId;
    @Basic(optional = false)
    @Column(name = "TrackDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date trackDate;
    @Basic(optional = false)
    @Column(name = "Keyword", nullable = false, length = 100)
    private String keyword;
    @Column(name = "YoutubeUrl", length = 300)
    private String youtubeUrl;
    @Column(name = "YoutubeRank")
    private Integer youtubeRank;
    @Column(name = "MetacafeUrl", length = 300)
    private String metacafeUrl;
    @Column(name = "MetacafeRank")
    private Integer metacafeRank;
    @Column(name = "DailyMotionUrl", length = 300)
    private String dailyMotionUrl;
    @Column(name = "DailyMotionRank")
    private Integer dailyMotionRank;
    @Column(name = "VimeoUrl", length = 300)
    private String vimeoUrl;
    @Column(name = "VimeoRank")
    private Integer vimeoRank;
    @JoinColumn(name = "VideoKeywordID", referencedColumnName = "VideokeywordID")
    @ManyToOne(optional = false)
    private Videokeywords videoKeywordID;
//    @JoinColumn(name = "KeywordId", referencedColumnName = "KeywordID", nullable = false)
//    @ManyToOne(optional = false)
//    private Keywords keywordId;

    public Videotrackhistory() {
    }

    public Videotrackhistory(Integer trackId) {
        this.trackId = trackId;
    }

    public Videotrackhistory(Integer trackId, Date trackDate, String keyword) {
        this.trackId = trackId;
        this.trackDate = trackDate;
        this.keyword = keyword;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public Integer getYoutubeRank() {
        return youtubeRank;
    }

    public void setYoutubeRank(Integer youtubeRank) {
        this.youtubeRank = youtubeRank;
    }

    public String getMetacafeUrl() {
        return metacafeUrl;
    }

    public void setMetacafeUrl(String metacafeUrl) {
        this.metacafeUrl = metacafeUrl;
    }

    public Integer getMetacafeRank() {
        return metacafeRank;
    }

    public void setMetacafeRank(Integer metacafeRank) {
        this.metacafeRank = metacafeRank;
    }

    public String getDailyMotionUrl() {
        return dailyMotionUrl;
    }

    public void setDailyMotionUrl(String dailyMotionUrl) {
        this.dailyMotionUrl = dailyMotionUrl;
    }

    public Integer getDailyMotionRank() {
        return dailyMotionRank;
    }

    public void setDailyMotionRank(Integer dailyMotionRank) {
        this.dailyMotionRank = dailyMotionRank;
    }

    public String getVimeoUrl() {
        return vimeoUrl;
    }

    public void setVimeoUrl(String vimeoUrl) {
        this.vimeoUrl = vimeoUrl;
    }

    public Integer getVimeoRank() {
        return vimeoRank;
    }

    public void setVimeoRank(Integer vimeoRank) {
        this.vimeoRank = vimeoRank;
    }

//    public Keywords getKeywordId() {
//        return keywordId;
//    }
//
//    public void setKeywordId(Keywords keywordId) {
//        this.keywordId = keywordId;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackId != null ? trackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videotrackhistory)) {
            return false;
        }
        Videotrackhistory other = (Videotrackhistory) object;
        if ((this.trackId == null && other.trackId != null) || (this.trackId != null && !this.trackId.equals(other.trackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Videotrackhistory[ trackId=" + trackId + " ]";
    }

    public Videokeywords getVideoKeywordID() {
        return videoKeywordID;
    }

    public void setVideoKeywordID(Videokeywords videoKeywordID) {
        this.videoKeywordID = videoKeywordID;
    }
    
}
