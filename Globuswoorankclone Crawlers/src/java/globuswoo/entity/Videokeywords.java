/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

import java.io.Serializable;
import java.util.Set;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
@Entity
@Table(name = "videokeywords")
@XmlRootElement
public class Videokeywords implements Serializable {
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VideokeywordID", nullable = false)
    private Integer videokeywordID;
    
    @Column(name = "YoutubeURL", nullable = false, length = 300)
    private String youtubeURL;
    
    @Column(name = "VimeoURL", length = 255)
    private String vimeoURL;
    
    @Column(name = "DailymotionURL", length = 255)
    private String dailymotionURL;
    
    @Column(name = "MetacafeURL", length = 255)
    private String metacafeURL;
    
    @Column(name = "RankYoutube")
    private Short rankYoutube;
    
    @Column(name = "RankVimeo")
    private Short rankVimeo;
    
    @Column(name = "RankDailyMotion")
    private Short rankDailyMotion;
    
    @Column(name = "RankMetacafe")
    private Short rankMetacafe;
    
    @Column(name = "Youtubeviewcoint")
    private int youtubeviewcoint;
    
    @Column(name = "YoutubeLikeCount" )
    private int youtubeLikeCount;
    
    @Column(name = "YoutubeDislikeCount")
    private int youtubeDislikeCount;
    
    @Column(name = "YoutubeCommentCount")
    private int youtubeCommentCount;
    
    @Column(name = "YoutubeDailyViewcount")
    private short youtubeDailyViewCount;
    
    @Column(name = "Visibility")
    private Short visibility;
    
    @Column(name = "VideoKeyword", nullable = false, length = 200)
    private String videoKeyword;
    
    @JoinColumn(name = "CampaignID", referencedColumnName = "CampaignID", nullable = false)
    @ManyToOne(optional = false)
    private Campaigns campaignID;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "videoKeywordID")
    private Set<Videotrackhistory> videotrackhistoryCollection;
    
    public Videokeywords() {
    }

    public Videokeywords(Integer videokeywordID) {
        this.videokeywordID = videokeywordID;
    }

    public Videokeywords(Integer videokeywordID, String videoURL, String videoKeyword) {
        this.videokeywordID = videokeywordID;
        this.videoKeyword = videoKeyword;
    }

    public Integer getVideokeywordID() {
        return videokeywordID;
    }

    public void setVideokeywordID(Integer videokeywordID) {
        this.videokeywordID = videokeywordID;
    }

    public String getVideoKeyword() {
        return videoKeyword;
    }

    public void setVideoKeyword(String videoKeyword) {
        this.videoKeyword = videoKeyword;
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
        hash += (videokeywordID != null ? videokeywordID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Videokeywords)) {
            return false;
        }
        Videokeywords other = (Videokeywords) object;
        if ((this.videokeywordID == null && other.videokeywordID != null) || (this.videokeywordID != null && !this.videokeywordID.equals(other.videokeywordID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Videokeywords[ videokeywordID=" + videokeywordID + " ]";
    }

    @XmlTransient
    public Set<Videotrackhistory> getVideotrackhistoryCollection() {
        return videotrackhistoryCollection;
    }

    public void setVideotrackhistoryCollection(Set<Videotrackhistory> videotrackhistoryCollection) {
        this.videotrackhistoryCollection = videotrackhistoryCollection;
    }

    public Short getRankYoutube() {
        return rankYoutube;
    }

    public void setRankYoutube(Short rankYoutube) {
        this.rankYoutube = rankYoutube;
    }

    public Short getRankVimeo() {
        return rankVimeo;
    }

    public void setRankVimeo(Short rankVimeo) {
        this.rankVimeo = rankVimeo;
    }

    public Short getRankDailyMotion() {
        return rankDailyMotion;
    }

    public void setRankDailyMotion(Short rankDailyMotion) {
        this.rankDailyMotion = rankDailyMotion;
    }

    public Short getRankMetacafe() {
        return rankMetacafe;
    }

    public void setRankMetacafe(Short rankMetacafe) {
        this.rankMetacafe = rankMetacafe;
    }

    public int getYoutubeviewcoint() {
        return youtubeviewcoint;
    }

    public void setYoutubeviewcoint(int youtubeviewcoint) {
        this.youtubeviewcoint = youtubeviewcoint;
    }

    public int getYoutubeLikeCount() {
        return youtubeLikeCount;
    }

    public void setYoutubeLikeCount(int youtubeLikeCount) {
        this.youtubeLikeCount = youtubeLikeCount;
    }

    public int getYoutubeDislikeCount() {
        return youtubeDislikeCount;
    }

    public void setYoutubeDislikeCount(int youtubeDislikeCount) {
        this.youtubeDislikeCount = youtubeDislikeCount;
    }

    public int getYoutubeCommentCount() {
        return youtubeCommentCount;
    }

    public void setYoutubeCommentCount(int youtubeCommentCount) {
        this.youtubeCommentCount = youtubeCommentCount;
    }

    public short getYoutubeDailyViewcount() {
        return youtubeDailyViewCount;
    }

    public void setYoutubeDailyViewcount(short youtubeDailyViewcount) {
        this.youtubeDailyViewCount = youtubeDailyViewCount;
    }

    public Short getVisibility() {
        return visibility;
    }

    public void setVisibility(Short visibility) {
        this.visibility = visibility;
    }

    public String getYoutubeURL() {
        return youtubeURL;
    }

    public void setYoutubeURL(String youtubeURL) {
        this.youtubeURL = youtubeURL;
    }

    public String getVimeoURL() {
        return vimeoURL;
    }

    public void setVimeoURL(String vimeoURL) {
        this.vimeoURL = vimeoURL;
    }

    public String getDailymotionURL() {
        return dailymotionURL;
    }

    public void setDailymotionURL(String dailymotionURL) {
        this.dailymotionURL = dailymotionURL;
    }

    public String getMetacafeURL() {
        return metacafeURL;
    }

    public void setMetacafeURL(String metacafeURL) {
        this.metacafeURL = metacafeURL;
    }

}
