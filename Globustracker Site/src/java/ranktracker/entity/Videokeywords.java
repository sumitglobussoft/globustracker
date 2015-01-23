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
 * @author GLB-130
 */
@Entity
@Table(name = "videokeywords")
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
    @Basic(optional = false)
    @Column(name = "RankYoutube")
    private short rankYoutube;
    @Column(name = "VimeoURL")
    private String vimeoURL;
    @Basic(optional = false)
    @Column(name = "RankVimeo")
    private short rankVimeo;
    @Column(name = "DailymotionURL")
    private String dailymotionURL;
    @Basic(optional = false)
    @Column(name = "RankDailyMotion")
    private short rankDailyMotion;
    @Column(name = "MetacafeURL")
    private String metacafeURL;
    @Basic(optional = false)
    @Column(name = "RankMetacafe")
    private short rankMetacafe;
    @Basic(optional = false)
    @Column(name = "YoutubeViewCount")
    private int youtubeViewCount;
    @Basic(optional = false)
    @Column(name = "VimeoViewCount")
    private int vimeoViewCount;
    @Basic(optional = false)
    @Column(name = "MetacafeViewCount")
    private int metacafeViewCount;
    @Basic(optional = false)
    @Column(name = "DailymotionViewCount")
    private int dailymotionViewCount;
    @Basic(optional = false)
    @Column(name = "YoutubeDailyViewcount")
    private short youtubeDailyViewcount;
    @Column(name = "YoutubeUpdatedDate")
    private String youtubeUpdatedDate;
    @Column(name = "VimeoUpdatedDate")
    private String vimeoUpdatedDate;
    @Column(name = "DailymotionUpdatedDate")
    private String dailymotionUpdatedDate;
    @Column(name = "MetaCafeUpdatedDate")
    private String metaCafeUpdatedDate;
    @Column(name = "ViewStatisticsUpdatedDate")
    private String viewStatisticsUpdatedDate;
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

    public Videokeywords(Integer videokeywordID, String videoKeyword, String youtubeURL, short rankYoutube, short rankVimeo, short rankDailyMotion, short rankMetacafe, int youtubeViewCount, int vimeoViewCount, int metacafeViewCount, int dailymotionViewCount, short youtubeDailyViewcount) {
        this.videokeywordID = videokeywordID;
        this.videoKeyword = videoKeyword;
        this.youtubeURL = youtubeURL;
        this.rankYoutube = rankYoutube;
        this.rankVimeo = rankVimeo;
        this.rankDailyMotion = rankDailyMotion;
        this.rankMetacafe = rankMetacafe;
        this.youtubeViewCount = youtubeViewCount;
        this.vimeoViewCount = vimeoViewCount;
        this.metacafeViewCount = metacafeViewCount;
        this.dailymotionViewCount = dailymotionViewCount;
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

    public short getRankYoutube() {
        return rankYoutube;
    }

    public void setRankYoutube(short rankYoutube) {
        this.rankYoutube = rankYoutube;
    }

    public String getVimeoURL() {
        return vimeoURL;
    }

    public void setVimeoURL(String vimeoURL) {
        this.vimeoURL = vimeoURL;
    }

    public short getRankVimeo() {
        return rankVimeo;
    }

    public void setRankVimeo(short rankVimeo) {
        this.rankVimeo = rankVimeo;
    }

    public String getDailymotionURL() {
        return dailymotionURL;
    }

    public void setDailymotionURL(String dailymotionURL) {
        this.dailymotionURL = dailymotionURL;
    }

    public short getRankDailyMotion() {
        return rankDailyMotion;
    }

    public void setRankDailyMotion(short rankDailyMotion) {
        this.rankDailyMotion = rankDailyMotion;
    }

    public String getMetacafeURL() {
        return metacafeURL;
    }

    public void setMetacafeURL(String metacafeURL) {
        this.metacafeURL = metacafeURL;
    }

    public short getRankMetacafe() {
        return rankMetacafe;
    }

    public void setRankMetacafe(short rankMetacafe) {
        this.rankMetacafe = rankMetacafe;
    }

    public int getYoutubeViewCount() {
        return youtubeViewCount;
    }

    public void setYoutubeViewCount(int youtubeViewCount) {
        this.youtubeViewCount = youtubeViewCount;
    }

    public int getVimeoViewCount() {
        return vimeoViewCount;
    }

    public void setVimeoViewCount(int vimeoViewCount) {
        this.vimeoViewCount = vimeoViewCount;
    }

    public int getMetacafeViewCount() {
        return metacafeViewCount;
    }

    public void setMetacafeViewCount(int metacafeViewCount) {
        this.metacafeViewCount = metacafeViewCount;
    }

    public int getDailymotionViewCount() {
        return dailymotionViewCount;
    }

    public void setDailymotionViewCount(int dailymotionViewCount) {
        this.dailymotionViewCount = dailymotionViewCount;
    }

    public short getYoutubeDailyViewcount() {
        return youtubeDailyViewcount;
    }

    public void setYoutubeDailyViewcount(short youtubeDailyViewcount) {
        this.youtubeDailyViewcount = youtubeDailyViewcount;
    }

    public String getYoutubeUpdatedDate() {
        return youtubeUpdatedDate;
    }

    public void setYoutubeUpdatedDate(String youtubeUpdatedDate) {
        this.youtubeUpdatedDate = youtubeUpdatedDate;
    }

    public String getVimeoUpdatedDate() {
        return vimeoUpdatedDate;
    }

    public void setVimeoUpdatedDate(String vimeoUpdatedDate) {
        this.vimeoUpdatedDate = vimeoUpdatedDate;
    }

    public String getDailymotionUpdatedDate() {
        return dailymotionUpdatedDate;
    }

    public void setDailymotionUpdatedDate(String dailymotionUpdatedDate) {
        this.dailymotionUpdatedDate = dailymotionUpdatedDate;
    }

    public String getMetaCafeUpdatedDate() {
        return metaCafeUpdatedDate;
    }

    public void setMetaCafeUpdatedDate(String metaCafeUpdatedDate) {
        this.metaCafeUpdatedDate = metaCafeUpdatedDate;
    }

    public String getViewStatisticsUpdatedDate() {
        return viewStatisticsUpdatedDate;
    }

    public void setViewStatisticsUpdatedDate(String viewStatisticsUpdatedDate) {
        this.viewStatisticsUpdatedDate = viewStatisticsUpdatedDate;
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
