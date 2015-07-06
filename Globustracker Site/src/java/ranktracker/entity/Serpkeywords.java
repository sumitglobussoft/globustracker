/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ranktracker.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "serpkeywords")
public class Serpkeywords implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KeywordID")
    private Integer keywordID;
    @Basic(optional = false)
    @Column(name = "Url")
    private String url;
    @Basic(optional = false)
    @Column(name = "Keyword")
    private String keyword;
    @Basic(optional = false)
    @Column(name = "LinkGoogle")
    private String linkGoogle;
    @Basic(optional = false)
    @Column(name = "Region")
    private String region;
    @Basic(optional = false)
    @Column(name = "RankGoogle")
    private int rankGoogle;
    @Basic(optional = false)
    @Column(name = "BestMatchRankGoogle")
    private int bestMatchRankGoogle;
    @Column(name = "BestMatchLinkGoogle")
    private String bestMatchLinkGoogle;
    @Basic(optional = false)
    @Column(name = "GooglePageRank")
    private int googlePageRank;
    @Basic(optional = false)
    @Column(name = "RankBing")
    private int rankBing;
    @Basic(optional = false)
    @Column(name = "BestMatchRankBing")
    private int bestMatchRankBing;
    @Column(name = "BestMatchLinkBing")
    private String bestMatchLinkBing;
    @Basic(optional = false)
    @Column(name = "RankYahoo")
    private int rankYahoo;
    @Basic(optional = false)
    @Column(name = "BestMatchRankYahoo")
    private int bestMatchRankYahoo;
    @Column(name = "BestMatchLinkYahoo")
    private String bestMatchLinkYahoo;
    @Basic(optional = false)
    @Column(name = "RankGoogleDayChange")
    private int rankGoogleDayChange;
    @Basic(optional = false)
    @Column(name = "RankGoogleWeekChange")
    private int rankGoogleWeekChange;
    @Basic(optional = false)
    @Column(name = "RankGoogleMonthChange")
    private int rankGoogleMonthChange;
    @Basic(optional = false)
    @Column(name = "RankBingDayChange")
    private int rankBingDayChange;
    @Basic(optional = false)
    @Column(name = "RankBingWeekChange")
    private int rankBingWeekChange;
    @Basic(optional = false)
    @Column(name = "RankBingMonthChange")
    private int rankBingMonthChange;
    @Basic(optional = false)
    @Column(name = "RankYahooDayChange")
    private int rankYahooDayChange;
    @Basic(optional = false)
    @Column(name = "RankYahooWeekChange")
    private int rankYahooWeekChange;
    @Basic(optional = false)
    @Column(name = "RankYahooMonthChange")
    private int rankYahooMonthChange;
    @Column(name = "GoogleUpdatedDate")
    private String googleUpdatedDate;
    @Column(name = "YahooUpdateDate")
    private String yahooUpdateDate;
    @Column(name = "BingUpdateDate")
    private String bingUpdateDate;
    @Basic(optional = false)
    @Column(name = "Visibility")
    private int visibility;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "keywordID")
    private Collection<Seokeyworddetails> seokeyworddetailsCollection;
    @JoinColumn(name = "CampaignID", referencedColumnName = "CampaignID")
    @ManyToOne(optional = false)
    private Campaigns campaignID;

    public Serpkeywords() {
    }

    public Serpkeywords(Integer keywordID) {
        this.keywordID = keywordID;
    }

    public Serpkeywords(Integer keywordID, String url, String keyword, String linkGoogle, String region, int rankGoogle, int bestMatchRankGoogle, int googlePageRank, int rankBing, int bestMatchRankBing, int rankYahoo, int bestMatchRankYahoo, int rankGoogleDayChange, int rankGoogleWeekChange, int rankGoogleMonthChange, int rankBingDayChange, int rankBingWeekChange, int rankBingMonthChange, int rankYahooDayChange, int rankYahooWeekChange, int rankYahooMonthChange, int visibility) {
        this.keywordID = keywordID;
        this.url = url;
        this.keyword = keyword;
        this.linkGoogle = linkGoogle;
        this.region = region;
        this.rankGoogle = rankGoogle;
        this.bestMatchRankGoogle = bestMatchRankGoogle;
        this.googlePageRank = googlePageRank;
        this.rankBing = rankBing;
        this.bestMatchRankBing = bestMatchRankBing;
        this.rankYahoo = rankYahoo;
        this.bestMatchRankYahoo = bestMatchRankYahoo;
        this.rankGoogleDayChange = rankGoogleDayChange;
        this.rankGoogleWeekChange = rankGoogleWeekChange;
        this.rankGoogleMonthChange = rankGoogleMonthChange;
        this.rankBingDayChange = rankBingDayChange;
        this.rankBingWeekChange = rankBingWeekChange;
        this.rankBingMonthChange = rankBingMonthChange;
        this.rankYahooDayChange = rankYahooDayChange;
        this.rankYahooWeekChange = rankYahooWeekChange;
        this.rankYahooMonthChange = rankYahooMonthChange;
        this.visibility = visibility;
    }

    public Integer getKeywordID() {
        return keywordID;
    }

    public void setKeywordID(Integer keywordID) {
        this.keywordID = keywordID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getLinkGoogle() {
        return linkGoogle;
    }

    public void setLinkGoogle(String linkGoogle) {
        this.linkGoogle = linkGoogle;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getRankGoogle() {
        return rankGoogle;
    }

    public void setRankGoogle(int rankGoogle) {
        this.rankGoogle = rankGoogle;
    }

    public int getBestMatchRankGoogle() {
        return bestMatchRankGoogle;
    }

    public void setBestMatchRankGoogle(int bestMatchRankGoogle) {
        this.bestMatchRankGoogle = bestMatchRankGoogle;
    }

    public String getBestMatchLinkGoogle() {
        return bestMatchLinkGoogle;
    }

    public void setBestMatchLinkGoogle(String bestMatchLinkGoogle) {
        this.bestMatchLinkGoogle = bestMatchLinkGoogle;
    }

    public int getGooglePageRank() {
        return googlePageRank;
    }

    public void setGooglePageRank(int googlePageRank) {
        this.googlePageRank = googlePageRank;
    }

    public int getRankBing() {
        return rankBing;
    }

    public void setRankBing(int rankBing) {
        this.rankBing = rankBing;
    }

    public int getBestMatchRankBing() {
        return bestMatchRankBing;
    }

    public void setBestMatchRankBing(int bestMatchRankBing) {
        this.bestMatchRankBing = bestMatchRankBing;
    }

    public String getBestMatchLinkBing() {
        return bestMatchLinkBing;
    }

    public void setBestMatchLinkBing(String bestMatchLinkBing) {
        this.bestMatchLinkBing = bestMatchLinkBing;
    }

    public int getRankYahoo() {
        return rankYahoo;
    }

    public void setRankYahoo(int rankYahoo) {
        this.rankYahoo = rankYahoo;
    }

    public int getBestMatchRankYahoo() {
        return bestMatchRankYahoo;
    }

    public void setBestMatchRankYahoo(int bestMatchRankYahoo) {
        this.bestMatchRankYahoo = bestMatchRankYahoo;
    }

    public String getBestMatchLinkYahoo() {
        return bestMatchLinkYahoo;
    }

    public void setBestMatchLinkYahoo(String bestMatchLinkYahoo) {
        this.bestMatchLinkYahoo = bestMatchLinkYahoo;
    }

    public int getRankGoogleDayChange() {
        return rankGoogleDayChange;
    }

    public void setRankGoogleDayChange(int rankGoogleDayChange) {
        this.rankGoogleDayChange = rankGoogleDayChange;
    }

    public int getRankGoogleWeekChange() {
        return rankGoogleWeekChange;
    }

    public void setRankGoogleWeekChange(int rankGoogleWeekChange) {
        this.rankGoogleWeekChange = rankGoogleWeekChange;
    }

    public int getRankGoogleMonthChange() {
        return rankGoogleMonthChange;
    }

    public void setRankGoogleMonthChange(int rankGoogleMonthChange) {
        this.rankGoogleMonthChange = rankGoogleMonthChange;
    }

    public int getRankBingDayChange() {
        return rankBingDayChange;
    }

    public void setRankBingDayChange(int rankBingDayChange) {
        this.rankBingDayChange = rankBingDayChange;
    }

    public int getRankBingWeekChange() {
        return rankBingWeekChange;
    }

    public void setRankBingWeekChange(int rankBingWeekChange) {
        this.rankBingWeekChange = rankBingWeekChange;
    }

    public int getRankBingMonthChange() {
        return rankBingMonthChange;
    }

    public void setRankBingMonthChange(int rankBingMonthChange) {
        this.rankBingMonthChange = rankBingMonthChange;
    }

    public int getRankYahooDayChange() {
        return rankYahooDayChange;
    }

    public void setRankYahooDayChange(int rankYahooDayChange) {
        this.rankYahooDayChange = rankYahooDayChange;
    }

    public int getRankYahooWeekChange() {
        return rankYahooWeekChange;
    }

    public void setRankYahooWeekChange(int rankYahooWeekChange) {
        this.rankYahooWeekChange = rankYahooWeekChange;
    }

    public int getRankYahooMonthChange() {
        return rankYahooMonthChange;
    }

    public void setRankYahooMonthChange(int rankYahooMonthChange) {
        this.rankYahooMonthChange = rankYahooMonthChange;
    }

    public String getGoogleUpdatedDate() {
        return googleUpdatedDate;
    }

    public void setGoogleUpdatedDate(String googleUpdatedDate) {
        this.googleUpdatedDate = googleUpdatedDate;
    }

    public String getYahooUpdateDate() {
        return yahooUpdateDate;
    }

    public void setYahooUpdateDate(String yahooUpdateDate) {
        this.yahooUpdateDate = yahooUpdateDate;
    }

    public String getBingUpdateDate() {
        return bingUpdateDate;
    }

    public void setBingUpdateDate(String bingUpdateDate) {
        this.bingUpdateDate = bingUpdateDate;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Collection<Seokeyworddetails> getSeokeyworddetailsCollection() {
        return seokeyworddetailsCollection;
    }

    public void setSeokeyworddetailsCollection(Collection<Seokeyworddetails> seokeyworddetailsCollection) {
        this.seokeyworddetailsCollection = seokeyworddetailsCollection;
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
        hash += (keywordID != null ? keywordID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serpkeywords)) {
            return false;
        }
        Serpkeywords other = (Serpkeywords) object;
        if ((this.keywordID == null && other.keywordID != null) || (this.keywordID != null && !this.keywordID.equals(other.keywordID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Serpkeywords[ keywordID=" + keywordID + " ]";
    }
    
}
