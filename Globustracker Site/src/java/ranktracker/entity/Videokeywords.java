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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "videokeywords")
@NamedQueries({
    @NamedQuery(name = "Videokeywords.findAll", query = "SELECT v FROM Videokeywords v")})
public class Videokeywords implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VideokeywordID")
    private Integer videokeywordID;
    @Basic(optional = false)
    @Column(name = "VideoKeyword")
    private String videoKeyword;
    @Basic(optional = false)
    @Column(name = "YoutubeURL")
    private String youtubeURL;
    @Column(name = "RankYoutube")
    private Short rankYoutube;
    @Column(name = "VimeoURL")
    private String vimeoURL;
    @Column(name = "RankVimeo")
    private Short rankVimeo;
    @Column(name = "DailymotionURL")
    private String dailymotionURL;
    @Column(name = "RankDailyMotion")
    private Short rankDailyMotion;
    @Column(name = "MetacafeURL")
    private String metacafeURL;
    @Column(name = "RankMetacafe")
    private Short rankMetacafe;
    @Basic(optional = false)
    @Column(name = "Youtubeviewcoint")
    private int youtubeviewcoint;
    @Basic(optional = false)
    @Column(name = "YoutubeLikeCount")
    private int youtubeLikeCount;
    @Basic(optional = false)
    @Column(name = "YoutubeDislikeCount")
    private int youtubeDislikeCount;
    @Basic(optional = false)
    @Column(name = "YoutubeCommentCount")
    private int youtubeCommentCount;
    @Basic(optional = false)
    @Column(name = "YoutubeDailyViewcount")
    private short youtubeDailyViewcount;
    @Column(name = "Visibility")
    private Short visibility;
    @JoinColumn(name = "CampaignID", referencedColumnName = "CampaignID")
    @ManyToOne(optional = false)
    private Campaigns campaignID;

    public Videokeywords() {
    }

    public Videokeywords(Integer videokeywordID) {
        this.videokeywordID = videokeywordID;
    }

    public Videokeywords(Integer videokeywordID, String videoKeyword, String youtubeURL, int youtubeviewcoint, int youtubeLikeCount, int youtubeDislikeCount, int youtubeCommentCount, short youtubeDailyViewcount) {
        this.videokeywordID = videokeywordID;
        this.videoKeyword = videoKeyword;
        this.youtubeURL = youtubeURL;
        this.youtubeviewcoint = youtubeviewcoint;
        this.youtubeLikeCount = youtubeLikeCount;
        this.youtubeDislikeCount = youtubeDislikeCount;
        this.youtubeCommentCount = youtubeCommentCount;
        this.youtubeDailyViewcount = youtubeDailyViewcount;
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

    public String getYoutubeURL() {
        return youtubeURL;
    }

    public void setYoutubeURL(String youtubeURL) {
        this.youtubeURL = youtubeURL;
    }

    public Short getRankYoutube() {
        return rankYoutube;
    }

    public void setRankYoutube(Short rankYoutube) {
        this.rankYoutube = rankYoutube;
    }

    public String getVimeoURL() {
        return vimeoURL;
    }

    public void setVimeoURL(String vimeoURL) {
        this.vimeoURL = vimeoURL;
    }

    public Short getRankVimeo() {
        return rankVimeo;
    }

    public void setRankVimeo(Short rankVimeo) {
        this.rankVimeo = rankVimeo;
    }

    public String getDailymotionURL() {
        return dailymotionURL;
    }

    public void setDailymotionURL(String dailymotionURL) {
        this.dailymotionURL = dailymotionURL;
    }

    public Short getRankDailyMotion() {
        return rankDailyMotion;
    }

    public void setRankDailyMotion(Short rankDailyMotion) {
        this.rankDailyMotion = rankDailyMotion;
    }

    public String getMetacafeURL() {
        return metacafeURL;
    }

    public void setMetacafeURL(String metacafeURL) {
        this.metacafeURL = metacafeURL;
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
        return youtubeDailyViewcount;
    }

    public void setYoutubeDailyViewcount(short youtubeDailyViewcount) {
        this.youtubeDailyViewcount = youtubeDailyViewcount;
    }

    public Short getVisibility() {
        return visibility;
    }

    public void setVisibility(Short visibility) {
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
}
