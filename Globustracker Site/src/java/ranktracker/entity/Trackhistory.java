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
@Table(name = "trackhistory")
public class Trackhistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TrackID")
    private Integer trackID;
    @Basic(optional = false)
    @Column(name = "TrackDate")
    @Temporal(TemporalType.DATE)
    private Date trackDate;
    @Basic(optional = false)
    @Column(name = "KeywordID")
    private int keywordID;
    @Basic(optional = false)
    @Column(name = "RankGoogle")
    private int rankGoogle;
    @Basic(optional = false)
    @Column(name = "BestMatchRankGoogle")
    private int bestMatchRankGoogle;
    @Basic(optional = false)
    @Column(name = "BestMatchLinkGoogle")
    private String bestMatchLinkGoogle;
    @Basic(optional = false)
    @Column(name = "RankBing")
    private int rankBing;
    @Basic(optional = false)
    @Column(name = "BestMatchRankBing")
    private int bestMatchRankBing;
    @Basic(optional = false)
    @Column(name = "BestMatchLinkBing")
    private String bestMatchLinkBing;
    @Basic(optional = false)
    @Column(name = "RankYahoo")
    private int rankYahoo;
    @Basic(optional = false)
    @Column(name = "BestMatchRankYahoo")
    private int bestMatchRankYahoo;
    @Basic(optional = false)
    @Column(name = "BestMatchLinkYahoo")
    private String bestMatchLinkYahoo;
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
    @Column(name = "FacebookLike")
    private int facebookLike;
    @Basic(optional = false)
    @Column(name = "FacebookShare")
    private int facebookShare;
    @Basic(optional = false)
    @Column(name = "TweetCount")
    private int tweetCount;
    @Basic(optional = false)
    @Column(name = "PinterestPins")
    private int pinterestPins;
    @Basic(optional = false)
    @Column(name = "GooglePlusLikes")
    private int googlePlusLikes;
    @Basic(optional = false)
    @Column(name = "LinkedInShares")
    private int linkedInShares;
    @Basic(optional = false)
    @Column(name = "RedittVotes")
    private int redittVotes;
    @Basic(optional = false)
    @Column(name = "StumbleUponLikes")
    private int stumbleUponLikes;

    public Trackhistory() {
    }

    public Trackhistory(Integer trackID) {
        this.trackID = trackID;
    }

    public Trackhistory(Integer trackID, Date trackDate, int keywordID, int rankGoogle, int bestMatchRankGoogle, String bestMatchLinkGoogle, int rankBing, int bestMatchRankBing, String bestMatchLinkBing, int rankYahoo, int bestMatchRankYahoo, String bestMatchLinkYahoo, int rankPage, int rankAlexa, int countBackLinks, int countMonthlySearches, int facebookLike, int facebookShare, int tweetCount, int pinterestPins, int googlePlusLikes, int linkedInShares, int redittVotes, int stumbleUponLikes) {
        this.trackID = trackID;
        this.trackDate = trackDate;
        this.keywordID = keywordID;
        this.rankGoogle = rankGoogle;
        this.bestMatchRankGoogle = bestMatchRankGoogle;
        this.bestMatchLinkGoogle = bestMatchLinkGoogle;
        this.rankBing = rankBing;
        this.bestMatchRankBing = bestMatchRankBing;
        this.bestMatchLinkBing = bestMatchLinkBing;
        this.rankYahoo = rankYahoo;
        this.bestMatchRankYahoo = bestMatchRankYahoo;
        this.bestMatchLinkYahoo = bestMatchLinkYahoo;
        this.rankPage = rankPage;
        this.rankAlexa = rankAlexa;
        this.countBackLinks = countBackLinks;
        this.countMonthlySearches = countMonthlySearches;
        this.facebookLike = facebookLike;
        this.facebookShare = facebookShare;
        this.tweetCount = tweetCount;
        this.pinterestPins = pinterestPins;
        this.googlePlusLikes = googlePlusLikes;
        this.linkedInShares = linkedInShares;
        this.redittVotes = redittVotes;
        this.stumbleUponLikes = stumbleUponLikes;
    }

    public Integer getTrackID() {
        return trackID;
    }

    public void setTrackID(Integer trackID) {
        this.trackID = trackID;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public int getKeywordID() {
        return keywordID;
    }

    public void setKeywordID(int keywordID) {
        this.keywordID = keywordID;
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

    public int getFacebookLike() {
        return facebookLike;
    }

    public void setFacebookLike(int facebookLike) {
        this.facebookLike = facebookLike;
    }

    public int getFacebookShare() {
        return facebookShare;
    }

    public void setFacebookShare(int facebookShare) {
        this.facebookShare = facebookShare;
    }

    public int getTweetCount() {
        return tweetCount;
    }

    public void setTweetCount(int tweetCount) {
        this.tweetCount = tweetCount;
    }

    public int getPinterestPins() {
        return pinterestPins;
    }

    public void setPinterestPins(int pinterestPins) {
        this.pinterestPins = pinterestPins;
    }

    public int getGooglePlusLikes() {
        return googlePlusLikes;
    }

    public void setGooglePlusLikes(int googlePlusLikes) {
        this.googlePlusLikes = googlePlusLikes;
    }

    public int getLinkedInShares() {
        return linkedInShares;
    }

    public void setLinkedInShares(int linkedInShares) {
        this.linkedInShares = linkedInShares;
    }

    public int getRedittVotes() {
        return redittVotes;
    }

    public void setRedittVotes(int redittVotes) {
        this.redittVotes = redittVotes;
    }

    public int getStumbleUponLikes() {
        return stumbleUponLikes;
    }

    public void setStumbleUponLikes(int stumbleUponLikes) {
        this.stumbleUponLikes = stumbleUponLikes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackID != null ? trackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trackhistory)) {
            return false;
        }
        Trackhistory other = (Trackhistory) object;
        if ((this.trackID == null && other.trackID != null) || (this.trackID != null && !this.trackID.equals(other.trackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Trackhistory[ trackID=" + trackID + " ]";
    }
    
}
