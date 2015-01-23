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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "seokeyworddetails")
public class Seokeyworddetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SEOKeywordId")
    private Integer sEOKeywordId;
    @Basic(optional = false)
    @Column(name = "Url")
    private String url;
    @Basic(optional = false)
    @Column(name = "Keyword")
    private String keyword;
    @Basic(optional = false)
    @Column(name = "SearchVolume")
    private int searchVolume;
    @Basic(optional = false)
    @Column(name = "GoogleCPC")
    private float googleCPC;
    @Basic(optional = false)
    @Column(name = "KeywordCompetition")
    private float keywordCompetition;
    @Basic(optional = false)
    @Column(name = "NumberofResult")
    private long numberofResult;
    @Basic(optional = false)
    @Column(name = "GooglePA")
    private int googlePA;
    @Basic(optional = false)
    @Column(name = "GoogleDA")
    private int googleDA;
    @Basic(optional = false)
    @Column(name = "SiteIndexing")
    private String siteIndexing;
    @Basic(optional = false)
    @Column(name = "AddedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Basic(optional = false)
    @Column(name = "RankPage")
    private int rankPage;
    @Basic(optional = false)
    @Column(name = "RankAlexa")
    private int rankAlexa;
    @Basic(optional = false)
    @Column(name = "CountBackLinks")
    private int countBackLinks;
    @Basic(optional = false)
    @Column(name = "CountMonthlySearches")
    private int countMonthlySearches;
    @Basic(optional = false)
    @Column(name = "Visibility")
    private int visibility;
    @JoinColumn(name = "KeywordID", referencedColumnName = "KeywordID")
    @ManyToOne(optional = false)
    private Serpkeywords keywordID;
    @JoinColumn(name = "CampaignID", referencedColumnName = "CampaignID")
    @ManyToOne(optional = false)
    private Campaigns campaignID;

    public Seokeyworddetails() {
    }

    public Seokeyworddetails(Integer sEOKeywordId) {
        this.sEOKeywordId = sEOKeywordId;
    }

    public Seokeyworddetails(Integer sEOKeywordId, String url, String keyword, int searchVolume, float googleCPC, float keywordCompetition, long numberofResult, int googlePA, int googleDA, String siteIndexing, Date addedDate, int rankPage, int rankAlexa, int countBackLinks, int countMonthlySearches, int visibility) {
        this.sEOKeywordId = sEOKeywordId;
        this.url = url;
        this.keyword = keyword;
        this.searchVolume = searchVolume;
        this.googleCPC = googleCPC;
        this.keywordCompetition = keywordCompetition;
        this.numberofResult = numberofResult;
        this.googlePA = googlePA;
        this.googleDA = googleDA;
        this.siteIndexing = siteIndexing;
        this.addedDate = addedDate;
        this.rankPage = rankPage;
        this.rankAlexa = rankAlexa;
        this.countBackLinks = countBackLinks;
        this.countMonthlySearches = countMonthlySearches;
        this.visibility = visibility;
    }

    public Integer getSEOKeywordId() {
        return sEOKeywordId;
    }

    public void setSEOKeywordId(Integer sEOKeywordId) {
        this.sEOKeywordId = sEOKeywordId;
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

    public int getSearchVolume() {
        return searchVolume;
    }

    public void setSearchVolume(int searchVolume) {
        this.searchVolume = searchVolume;
    }

    public float getGoogleCPC() {
        return googleCPC;
    }

    public void setGoogleCPC(float googleCPC) {
        this.googleCPC = googleCPC;
    }

    public float getKeywordCompetition() {
        return keywordCompetition;
    }

    public void setKeywordCompetition(float keywordCompetition) {
        this.keywordCompetition = keywordCompetition;
    }

    public long getNumberofResult() {
        return numberofResult;
    }

    public void setNumberofResult(long numberofResult) {
        this.numberofResult = numberofResult;
    }

    public int getGooglePA() {
        return googlePA;
    }

    public void setGooglePA(int googlePA) {
        this.googlePA = googlePA;
    }

    public int getGoogleDA() {
        return googleDA;
    }

    public void setGoogleDA(int googleDA) {
        this.googleDA = googleDA;
    }

    public String getSiteIndexing() {
        return siteIndexing;
    }

    public void setSiteIndexing(String siteIndexing) {
        this.siteIndexing = siteIndexing;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public int getRankPage() {
        return rankPage;
    }

    public void setRankPage(int rankPage) {
        this.rankPage = rankPage;
    }

    public int getRankAlexa() {
        return rankAlexa;
    }

    public void setRankAlexa(int rankAlexa) {
        this.rankAlexa = rankAlexa;
    }

    public int getCountBackLinks() {
        return countBackLinks;
    }

    public void setCountBackLinks(int countBackLinks) {
        this.countBackLinks = countBackLinks;
    }

    public int getCountMonthlySearches() {
        return countMonthlySearches;
    }

    public void setCountMonthlySearches(int countMonthlySearches) {
        this.countMonthlySearches = countMonthlySearches;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Serpkeywords getKeywordID() {
        return keywordID;
    }

    public void setKeywordID(Serpkeywords keywordID) {
        this.keywordID = keywordID;
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
        hash += (sEOKeywordId != null ? sEOKeywordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seokeyworddetails)) {
            return false;
        }
        Seokeyworddetails other = (Seokeyworddetails) object;
        if ((this.sEOKeywordId == null && other.sEOKeywordId != null) || (this.sEOKeywordId != null && !this.sEOKeywordId.equals(other.sEOKeywordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Seokeyworddetails[ sEOKeywordId=" + sEOKeywordId + " ]";
    }
    
}
