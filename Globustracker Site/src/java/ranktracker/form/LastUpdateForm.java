/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.form;

import java.util.HashSet;
import java.util.Set;
import ranktracker.entity.Campaigns;

/**
 *
 * @author glb-074
 */
public class LastUpdateForm {

    private int googlePageRank;
    private int rankGoogle;
    private int bestMatchRankGoogle;
    private int rankBing;
    private int bestMatchRankBing;
    private int rankYahoo;
    private int bestMatchRankYahoo;
    private int rankGoogleDayChange;
    private int rankGoogleWeekChange;
    private int rankGoogleMonthChange;
    private int rankBingDayChange;
    private int rankBingWeekChange;
    private int rankBingMonthChange;
    private int rankYahooDayChange;
    private int rankYahooWeekChange;
    private int rankYahooMonthChange;
    private int rankPage;
    private int rankAlexa;
    private int countBackLinks;
    private int countMonthlySearches;
    private int facebookLike;
    private int facebookShare;
    private int tweetCount;
    private int pinterestPins;
    private int googlePlusLikes;
    private int linkedInShares;
    private int redittVotes;
    private int stumbleUponLikes;
    private int visibility;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "keywordId")
//    private Collection<Videotrackhistory> videotrackhistoryCollection;
    private Integer keywordId;
    private String url;
    private String keyword;
    private String linkGoogle;
    private String region = "";
    private String bestMatchLinkGoogle = "";
    private String bestMatchLinkBing = "";
    private String bestMatchLinkYahoo = "";
    
    private String lastUpdate = "";

    public Integer getKeywordId() {
        return this.keywordId;
    }

    public void setKeywordId(Integer keywordId) {
        this.keywordId = keywordId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getLinkGoogle() {
        return this.linkGoogle;
    }

    public void setLinkGoogle(String linkGoogle) {
        this.linkGoogle = linkGoogle;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBestMatchLinkGoogle() {
        return this.bestMatchLinkGoogle;
    }

    public void setBestMatchLinkGoogle(String bestMatchLinkGoogle) {
        this.bestMatchLinkGoogle = bestMatchLinkGoogle;
    }

    public String getBestMatchLinkBing() {
        return this.bestMatchLinkBing;
    }

    public void setBestMatchLinkBing(String bestMatchLinkBing) {
        this.bestMatchLinkBing = bestMatchLinkBing;
    }

    public String getBestMatchLinkYahoo() {
        return this.bestMatchLinkYahoo;
    }

    public void setBestMatchLinkYahoo(String bestMatchLinkYahoo) {
        this.bestMatchLinkYahoo = bestMatchLinkYahoo;
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

//    @XmlTransient
//    public Collection<Videotrackhistory> getVideotrackhistoryCollection() {
//        return videotrackhistoryCollection;
//    }
//
//    public void setVideotrackhistoryCollection(Collection<Videotrackhistory> videotrackhistoryCollection) {
//        this.videotrackhistoryCollection = videotrackhistoryCollection;
//    }
    public int getGooglePageRank() {
        return googlePageRank;
    }

    public void setGooglePageRank(int googlePageRank) {
        this.googlePageRank = googlePageRank;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
