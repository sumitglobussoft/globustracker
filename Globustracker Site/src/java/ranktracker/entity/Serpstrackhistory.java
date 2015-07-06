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
@Table(name = "serpstrackhistory")
public class Serpstrackhistory implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "KeywordId")
    private int keywordId;
    @Basic(optional = false)
    @Column(name = "SearchEngine")
    private String searchEngine;
    @Column(name = "Rank")
    private Integer rank;
    @Column(name = "BestMatchRank")
    private Integer bestMatchRank;
    @Column(name = "BestMatchLink")
    private String bestMatchLink;

    public Serpstrackhistory() {
    }

    public Serpstrackhistory(Integer trackId) {
        this.trackId = trackId;
    }

    public Serpstrackhistory(Integer trackId, Date trackDate, int keywordId, String searchEngine) {
        this.trackId = trackId;
        this.trackDate = trackDate;
        this.keywordId = keywordId;
        this.searchEngine = searchEngine;
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

    public int getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }

    public String getSearchEngine() {
        return searchEngine;
    }

    public void setSearchEngine(String searchEngine) {
        this.searchEngine = searchEngine;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getBestMatchRank() {
        return bestMatchRank;
    }

    public void setBestMatchRank(Integer bestMatchRank) {
        this.bestMatchRank = bestMatchRank;
    }

    public String getBestMatchLink() {
        return bestMatchLink;
    }

    public void setBestMatchLink(String bestMatchLink) {
        this.bestMatchLink = bestMatchLink;
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
        if (!(object instanceof Serpstrackhistory)) {
            return false;
        }
        Serpstrackhistory other = (Serpstrackhistory) object;
        if ((this.trackId == null && other.trackId != null) || (this.trackId != null && !this.trackId.equals(other.trackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Serpstrackhistory[ trackId=" + trackId + " ]";
    }
    
}
