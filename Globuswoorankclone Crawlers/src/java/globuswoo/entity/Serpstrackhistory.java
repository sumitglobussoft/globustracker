package globuswoo.entity;
// Generated May 23, 2013 8:20:10 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Serpstrackhistory generated manually
 */
@Entity
@Table(name="serpstrackhistory")
public class Serpstrackhistory  implements java.io.Serializable {

     private Integer trackId;
     private Date trackDate;
     private int keywordId;
     private String searchEngine;
     private Integer rank;
     private Integer bestMatchRank;
     private String bestMatchLink;
     
    public Serpstrackhistory() {
    }

	
    public Serpstrackhistory(int keywordId) {
        this.keywordId = keywordId;
    }
    public Serpstrackhistory(Date trackDate, int keywordId,String searchEngine, Integer rank, Integer bestMatchRank, String bestMatchLink) {
       this.trackDate = trackDate;
       this.keywordId = keywordId;
       this.searchEngine=searchEngine;
       this.rank = rank;
       this.bestMatchRank = bestMatchRank;
       this.bestMatchLink = bestMatchLink;
       
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="TrackId", unique=true, nullable=false)
    public Integer getTrackId() {
        return this.trackId;
    }
    
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="TrackDate", length=0)
    public Date getTrackDate() {
        return this.trackDate;
    }
    
    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }
    
    @Column(name="KeywordID", nullable=false)
    public int getKeywordId() {
        return this.keywordId;
    }
    
    public void setKeywordId(int keywordId) {
        this.keywordId = keywordId;
    }
    
    @Column(name="Rank")
    public Integer getRank() {
        return this.rank;
    }
    
    public void setRank(Integer rank) {
        this.rank = rank;
    }
    
    @Column(name="BestMatchRank")
    public Integer getBestMatchRank() {
        return this.bestMatchRank;
    }
    
    public void setBestMatchRank(Integer bestMatchRank) {
        this.bestMatchRank = bestMatchRank;
    }
    
    @Column(name="BestMatchLink", length=300)
    public String getBestMatchLink() {
        return this.bestMatchLink;
    }
    
    public void setBestMatchLink(String bestMatchLink) {
        this.bestMatchLink = bestMatchLink;
    }
    
    @Column(name="SearchEngine")
    public String getSearchEngine() {
        return this.searchEngine;
    }
    
    public void setSearchEngine(String searchEngine) {
        this.searchEngine = searchEngine;
    }
    



}


