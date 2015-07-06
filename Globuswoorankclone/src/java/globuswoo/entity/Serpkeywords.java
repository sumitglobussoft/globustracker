/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "serpkeywords")
@XmlRootElement
public class Serpkeywords implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serpKeywordId")
    private Collection<Serpkeywordgoal> serpkeywordgoalCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KeywordID", nullable = false)
    private Integer keywordId;
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
    @Basic(optional = false)
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
    @Column(name = "SiteIndexing")
    private String siteIndexing;
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
    @Basic(optional = false)
    @Column(name = "Visibility")
    private int visibility;
//    @JoinTable(name = "campaignkeywords", joinColumns = {
//        @JoinColumn(name = "KeywordID", referencedColumnName = "KeywordID", nullable = false)}, inverseJoinColumns = {
//        @JoinColumn(name = "CampaignId", referencedColumnName = "CampaignID", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "keywordses")
    private Set<Campaigns> campaignses = new HashSet<>();
//    @ManyToMany(mappedBy = "serpkeywordsCollection")
//    private Set<Campaigns> campaignsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "keywordId")
    private Set<Seokeyworddetails> seokeyworddetailsCollection;

    public Serpkeywords() {
    }

    public Serpkeywords(Integer keywordId) {
        this.keywordId = keywordId;
    }

    public Serpkeywords(Integer keywordId, String url, String keyword, String linkGoogle, String region, int rankGoogle, int bestMatchRankGoogle, String bestMatchLinkGoogle, int googlePageRank, int rankBing, int bestMatchRankBing, String bestMatchLinkBing, int rankYahoo, int bestMatchRankYahoo, String bestMatchLinkYahoo, int rankGoogleDayChange, int rankGoogleWeekChange, int rankGoogleMonthChange, int rankBingDayChange, int rankBingWeekChange, int rankBingMonthChange, int rankYahooDayChange, int rankYahooWeekChange, int rankYahooMonthChange, int rankPage, int rankAlexa, int countBackLinks, int countMonthlySearches, int facebookLike, int facebookShare, int tweetCount, int pinterestPins, int googlePlusLikes, int linkedInShares, int redittVotes, int stumbleUponLikes, int visibility) {
        this.keywordId = keywordId;
        this.url = url;
        this.keyword = keyword;
        this.linkGoogle = linkGoogle;
        this.region = region;
        this.rankGoogle = rankGoogle;
        this.bestMatchRankGoogle = bestMatchRankGoogle;
        this.bestMatchLinkGoogle = bestMatchLinkGoogle;
        this.googlePageRank = googlePageRank;
        this.rankBing = rankBing;
        this.bestMatchRankBing = bestMatchRankBing;
        this.bestMatchLinkBing = bestMatchLinkBing;
        this.rankYahoo = rankYahoo;
        this.bestMatchRankYahoo = bestMatchRankYahoo;
        this.bestMatchLinkYahoo = bestMatchLinkYahoo;
        this.rankGoogleDayChange = rankGoogleDayChange;
        this.rankGoogleWeekChange = rankGoogleWeekChange;
        this.rankGoogleMonthChange = rankGoogleMonthChange;
        this.rankBingDayChange = rankBingDayChange;
        this.rankBingWeekChange = rankBingWeekChange;
        this.rankBingMonthChange = rankBingMonthChange;
        this.rankYahooDayChange = rankYahooDayChange;
        this.rankYahooWeekChange = rankYahooWeekChange;
        this.rankYahooMonthChange = rankYahooMonthChange;
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
        this.visibility = visibility;
    }

    public Integer getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Integer keywordID) {
        this.keywordId = keywordID;
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

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    @XmlTransient
    public Set<Campaigns> getCampaignses() {
        return campaignses;
    }

    public void setCampaignses(Set<Campaigns> campaignses) {
        this.campaignses = campaignses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (keywordId != null ? keywordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serpkeywords)) {
            return false;
        }
        Serpkeywords other = (Serpkeywords) object;
        if ((this.keywordId == null && other.keywordId != null) || (this.keywordId != null && !this.keywordId.equals(other.keywordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Serpkeywords[ keywordID=" + keywordId + " ]";
    }

    public String getSiteIndexing() {
        return siteIndexing;
    }

    public void setSiteIndexing(String siteIndexing) {
        this.siteIndexing = siteIndexing;
    }

//    @XmlTransient
//    public Set<Campaigns> getCampaignsCollection() {
//        return campaignsCollection;
//    }
//
//    public void setCampaignsCollection(Set<Campaigns> campaignsCollection) {
//        this.campaignsCollection = campaignsCollection;
//    }
    @XmlTransient
    public Set<Seokeyworddetails> getSeokeyworddetailsCollection() {
        return seokeyworddetailsCollection;
    }

    public void setSeokeyworddetailsCollection(Set<Seokeyworddetails> seokeyworddetailsCollection) {
        this.seokeyworddetailsCollection = seokeyworddetailsCollection;
    }

    @XmlTransient
    public Collection<Serpkeywordgoal> getSerpkeywordgoalCollection() {
        return serpkeywordgoalCollection;
    }

    public void setSerpkeywordgoalCollection(Collection<Serpkeywordgoal> serpkeywordgoalCollection) {
        this.serpkeywordgoalCollection = serpkeywordgoalCollection;
    }
}
