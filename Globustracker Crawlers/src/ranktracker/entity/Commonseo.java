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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author GLB-214
 */
@Entity
@Table(name = "commonseo")

public class Commonseo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "countryRank")
    private String countryRank;
    @Lob
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "descriptionLength")
    private String descriptionLength;
    @Column(name = "doctype")
    private String doctype;
    @Column(name = "domainCreated")
    private String domainCreated;
    @Column(name = "domainExpired")
    private String domainExpired;
    @Column(name = "domainUpdated")
    private String domainUpdated;
    @Column(name = "encoding")
    private String encoding;
    @Column(name = "facebookAbout")
    private String facebookAbout;
    @Column(name = "facebookAddress")
    private String facebookAddress;
    @Column(name = "facebookImage")
    private String facebookImage;
    @Column(name = "facebookLikes")
    private String facebookLikes;
    @Lob
    @Column(name = "facebook_mission")
    private String facebookMission;
    @Column(name = "facebookName")
    private String facebookName;
    @Lob
    @Column(name = "facebookOverview")
    private String facebookOverview;
    @Column(name = "facebook_phone")
    private String facebookPhone;
    @Lob
    @Column(name = "facebookProduct")
    private String facebookProduct;
    @Column(name = "facebookUrl")
    private String facebookUrl;
    @Column(name = "flagCode")
    private String flagCode;
    @Column(name = "flash")
    private String flash;
    @Column(name = "frames")
    private String frames;
    @Column(name = "globalRank")
    private String globalRank;
    @Column(name = "googleImage")
    private String googleImage;
    @Lob
    @Column(name = "googleIntroduction")
    private String googleIntroduction;
    @Column(name = "googleName")
    private String googleName;
    @Lob
    @Column(name = "googleOverview")
    private String googleOverview;
    @Column(name = "googlePublisher")
    private String googlePublisher;
    @Column(name = "googleTagline")
    private String googleTagline;
    @Column(name = "googleUrl")
    private String googleUrl;
    @Column(name = "googleVerified")
    private String googleVerified;
    @Column(name = "htmlRatio")
    private String htmlRatio;
    @Column(name = "ipCanonicalization")
    private String ipCanonicalization;
    @Lob
    @Column(name = "ipadView")
    private String ipadView;
    @Column(name = "ipaddress")
    private String ipaddress;
    @Lob
    @Column(name = "iphoneView")
    private String iphoneView;
    @Lob
    @Column(name = "keyword")
    private String keyword;
    @Column(name = "locat")
    private String locat;
    @Column(name = "pageRank")
    private String pageRank;
    @Column(name = "reviewGoogleDesc")
    private String reviewGoogleDesc;
    @Column(name = "reviewGoogleTitle")
    private String reviewGoogleTitle;
    @Column(name = "reviewGoogleUrl")
    private String reviewGoogleUrl;
    @Column(name = "robots")
    private String robots;
    @Column(name = "takingAbout")
    private String takingAbout;
    @Lob
    @Column(name = "title")
    private String title;
    @Column(name = "titleLength")
    private String titleLength;
    @Column(name = "underscores")
    private String underscores;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Column(name = "urlDomain")
    private String urlDomain;
    @Column(name = "w3cvalidity")
    private String w3cvalidity;
    @Column(name = "wwwResolve")
    private String wwwResolve;
    @Lob
    @Column(name = "twitterName")
    private String twitterName;
    @Lob
    @Column(name = "twitterImage")
    private String twitterImage;
    @Column(name = "twitterCount")
    private String twitterCount;
    @Column(name = "twitterFollowing")
    private String twitterFollowing;
    @Column(name = "twitterFollower")
    private String twitterFollower;
    @Lob
    @Column(name = "twitterDescription")
    private String twitterDescription;
    @Lob
    @Column(name = "twitterLocation")
    private String twitterLocation;
    @Column(name = "twitterList")
    private String twitterList;
    @Column(name = "twitterFavourites")
    private String twitterFavourites;
    @Column(name = "twitterDate")
    private String twitterDate;
    @Column(name = "twitterUrl")
    private String twitterUrl;
    @Lob
    @Column(name = "dashboardImage")
    private String dashboardImage;
    @Lob
    @Column(name = "usabilityImage")
    private String usabilityImage;
    @Column(name = "googleFollower")
    private String googleFollower;
    @Column(name = "googleViews")
    private String googleViews;
    @Column(name = "passedPercent")
    private Integer passedPercent;
    @Column(name = "errorPercent")
    private Integer errorPercent;
    @Column(name = "improvePercent")
    private Integer improvePercent;
    @Column(name = "indexedPages")
    private String indexedPages;
    @Column(name = "backlinksCounter")
    private String backlinksCounter;
    @Lob
    @Column(name = "facebookDescription")
    private String facebookDescription;
    @Column(name = "mobileLoadTime")
    private String mobileLoadTime;
    @Column(name = "trafficEstimation")
    private String trafficEstimation;
    @Column(name = "scoreValue")
    private String scoreValue;
    @Column(name = "pInterestBoards")
    private String pInterestBoards;
    @Column(name = "pInterestPins")
    private String pInterestPins;
    @Column(name = "pInterestLikes")
    private String pInterestLikes;
    @Column(name = "pInterestFollower")
    private String pInterestFollower;
    @Column(name = "pInterestFollowing")
    private String pInterestFollowing;
    @Column(name = "pInterestImage")
    private String pInterestImage;
    @Column(name = "pInterestName")
    private String pInterestName;
    @Column(name = "pInterestDescription")
    private String pInterestDescription;
    @Column(name = "linkedFollower")
    private String linkedFollower;
    @Column(name = "linkedImage")
    private String linkedImage;
    @Lob
    @Column(name = "linkedDescription")
    private String linkedDescription;
    @Column(name = "linkedSpecialties")
    private String linkedSpecialties;
    @Column(name = "linkedWebsite")
    private String linkedWebsite;
    @Column(name = "linkedIndustry")
    private String linkedIndustry;
    @Column(name = "linkedType")
    private String linkedType;
    @Column(name = "linkedHeadquater")
    private String linkedHeadquater;
    @Column(name = "linkedCompany")
    private String linkedCompany;
    @Column(name = "linkedFounded")
    private String linkedFounded;
    @Column(name = "linkedEmployee")
    private String linkedEmployee;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "aLexaRank")
    private String aLexaRank;
    @Column(name = "facebookShareCount")
    private String facebookShareCount;
    @Column(name = "facebookLikesCount")
    private String facebookLikesCount;
    @Column(name = "facebookComment")
    private String facebookComment;
    @Column(name = "facebookTotalCount")
    private String facebookTotalCount;
    @Column(name = "facebookClickCount")
    private String facebookClickCount;
    @Column(name = "facebookCommentsBoxCount")
    private String facebookCommentsBoxCount;
    @Column(name = "linkedInCount")
    private String linkedInCount;
    @Column(name = "pinterestCount")
    private String pinterestCount;
    @Column(name = "twitterCounts")
    private String twitterCounts;
    @Column(name = "googlePlusLike")
    private String googlePlusLike;

    public Commonseo() {
    }

    public Commonseo(Integer id) {
        this.id = id;
    }

    public Commonseo(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryRank() {
        return countryRank;
    }

    public void setCountryRank(String countryRank) {
        this.countryRank = countryRank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionLength() {
        return descriptionLength;
    }

    public void setDescriptionLength(String descriptionLength) {
        this.descriptionLength = descriptionLength;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public String getDomainCreated() {
        return domainCreated;
    }

    public void setDomainCreated(String domainCreated) {
        this.domainCreated = domainCreated;
    }

    public String getDomainExpired() {
        return domainExpired;
    }

    public void setDomainExpired(String domainExpired) {
        this.domainExpired = domainExpired;
    }

    public String getDomainUpdated() {
        return domainUpdated;
    }

    public void setDomainUpdated(String domainUpdated) {
        this.domainUpdated = domainUpdated;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getFacebookAbout() {
        return facebookAbout;
    }

    public void setFacebookAbout(String facebookAbout) {
        this.facebookAbout = facebookAbout;
    }

    public String getFacebookAddress() {
        return facebookAddress;
    }

    public void setFacebookAddress(String facebookAddress) {
        this.facebookAddress = facebookAddress;
    }

    public String getFacebookImage() {
        return facebookImage;
    }

    public void setFacebookImage(String facebookImage) {
        this.facebookImage = facebookImage;
    }

    public String getFacebookLikes() {
        return facebookLikes;
    }

    public void setFacebookLikes(String facebookLikes) {
        this.facebookLikes = facebookLikes;
    }

    public String getFacebookMission() {
        return facebookMission;
    }

    public void setFacebookMission(String facebookMission) {
        this.facebookMission = facebookMission;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

    public String getFacebookOverview() {
        return facebookOverview;
    }

    public void setFacebookOverview(String facebookOverview) {
        this.facebookOverview = facebookOverview;
    }

    public String getFacebookPhone() {
        return facebookPhone;
    }

    public void setFacebookPhone(String facebookPhone) {
        this.facebookPhone = facebookPhone;
    }

    public String getFacebookProduct() {
        return facebookProduct;
    }

    public void setFacebookProduct(String facebookProduct) {
        this.facebookProduct = facebookProduct;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getFlagCode() {
        return flagCode;
    }

    public void setFlagCode(String flagCode) {
        this.flagCode = flagCode;
    }

    public String getFlash() {
        return flash;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    public String getFrames() {
        return frames;
    }

    public void setFrames(String frames) {
        this.frames = frames;
    }

    public String getGlobalRank() {
        return globalRank;
    }

    public void setGlobalRank(String globalRank) {
        this.globalRank = globalRank;
    }

    public String getGoogleImage() {
        return googleImage;
    }

    public void setGoogleImage(String googleImage) {
        this.googleImage = googleImage;
    }

    public String getGoogleIntroduction() {
        return googleIntroduction;
    }

    public void setGoogleIntroduction(String googleIntroduction) {
        this.googleIntroduction = googleIntroduction;
    }

    public String getGoogleName() {
        return googleName;
    }

    public void setGoogleName(String googleName) {
        this.googleName = googleName;
    }

    public String getGoogleOverview() {
        return googleOverview;
    }

    public void setGoogleOverview(String googleOverview) {
        this.googleOverview = googleOverview;
    }

    public String getGooglePublisher() {
        return googlePublisher;
    }

    public void setGooglePublisher(String googlePublisher) {
        this.googlePublisher = googlePublisher;
    }

    public String getGoogleTagline() {
        return googleTagline;
    }

    public void setGoogleTagline(String googleTagline) {
        this.googleTagline = googleTagline;
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    public String getGoogleVerified() {
        return googleVerified;
    }

    public void setGoogleVerified(String googleVerified) {
        this.googleVerified = googleVerified;
    }

    public String getHtmlRatio() {
        return htmlRatio;
    }

    public void setHtmlRatio(String htmlRatio) {
        this.htmlRatio = htmlRatio;
    }

    public String getIpCanonicalization() {
        return ipCanonicalization;
    }

    public void setIpCanonicalization(String ipCanonicalization) {
        this.ipCanonicalization = ipCanonicalization;
    }

    public String getIpadView() {
        return ipadView;
    }

    public void setIpadView(String ipadView) {
        this.ipadView = ipadView;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getIphoneView() {
        return iphoneView;
    }

    public void setIphoneView(String iphoneView) {
        this.iphoneView = iphoneView;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getLocat() {
        return locat;
    }

    public void setLocat(String locat) {
        this.locat = locat;
    }

    public String getPageRank() {
        return pageRank;
    }

    public void setPageRank(String pageRank) {
        this.pageRank = pageRank;
    }

    public String getReviewGoogleDesc() {
        return reviewGoogleDesc;
    }

    public void setReviewGoogleDesc(String reviewGoogleDesc) {
        this.reviewGoogleDesc = reviewGoogleDesc;
    }

    public String getReviewGoogleTitle() {
        return reviewGoogleTitle;
    }

    public void setReviewGoogleTitle(String reviewGoogleTitle) {
        this.reviewGoogleTitle = reviewGoogleTitle;
    }

    public String getReviewGoogleUrl() {
        return reviewGoogleUrl;
    }

    public void setReviewGoogleUrl(String reviewGoogleUrl) {
        this.reviewGoogleUrl = reviewGoogleUrl;
    }

    public String getRobots() {
        return robots;
    }

    public void setRobots(String robots) {
        this.robots = robots;
    }

    public String getTakingAbout() {
        return takingAbout;
    }

    public void setTakingAbout(String takingAbout) {
        this.takingAbout = takingAbout;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleLength() {
        return titleLength;
    }

    public void setTitleLength(String titleLength) {
        this.titleLength = titleLength;
    }

    public String getUnderscores() {
        return underscores;
    }

    public void setUnderscores(String underscores) {
        this.underscores = underscores;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlDomain() {
        return urlDomain;
    }

    public void setUrlDomain(String urlDomain) {
        this.urlDomain = urlDomain;
    }

    public String getW3cvalidity() {
        return w3cvalidity;
    }

    public void setW3cvalidity(String w3cvalidity) {
        this.w3cvalidity = w3cvalidity;
    }

    public String getWwwResolve() {
        return wwwResolve;
    }

    public void setWwwResolve(String wwwResolve) {
        this.wwwResolve = wwwResolve;
    }

    public String getTwitterName() {
        return twitterName;
    }

    public void setTwitterName(String twitterName) {
        this.twitterName = twitterName;
    }

    public String getTwitterImage() {
        return twitterImage;
    }

    public void setTwitterImage(String twitterImage) {
        this.twitterImage = twitterImage;
    }

    public String getTwitterCount() {
        return twitterCount;
    }

    public void setTwitterCount(String twitterCount) {
        this.twitterCount = twitterCount;
    }

    public String getTwitterFollowing() {
        return twitterFollowing;
    }

    public void setTwitterFollowing(String twitterFollowing) {
        this.twitterFollowing = twitterFollowing;
    }

    public String getTwitterFollower() {
        return twitterFollower;
    }

    public void setTwitterFollower(String twitterFollower) {
        this.twitterFollower = twitterFollower;
    }

    public String getTwitterDescription() {
        return twitterDescription;
    }

    public void setTwitterDescription(String twitterDescription) {
        this.twitterDescription = twitterDescription;
    }

    public String getTwitterLocation() {
        return twitterLocation;
    }

    public void setTwitterLocation(String twitterLocation) {
        this.twitterLocation = twitterLocation;
    }

    public String getTwitterList() {
        return twitterList;
    }

    public void setTwitterList(String twitterList) {
        this.twitterList = twitterList;
    }

    public String getTwitterFavourites() {
        return twitterFavourites;
    }

    public void setTwitterFavourites(String twitterFavourites) {
        this.twitterFavourites = twitterFavourites;
    }

    public String getTwitterDate() {
        return twitterDate;
    }

    public void setTwitterDate(String twitterDate) {
        this.twitterDate = twitterDate;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getDashboardImage() {
        return dashboardImage;
    }

    public void setDashboardImage(String dashboardImage) {
        this.dashboardImage = dashboardImage;
    }

    public String getUsabilityImage() {
        return usabilityImage;
    }

    public void setUsabilityImage(String usabilityImage) {
        this.usabilityImage = usabilityImage;
    }

    public String getGoogleFollower() {
        return googleFollower;
    }

    public void setGoogleFollower(String googleFollower) {
        this.googleFollower = googleFollower;
    }

    public String getGoogleViews() {
        return googleViews;
    }

    public void setGoogleViews(String googleViews) {
        this.googleViews = googleViews;
    }

    public Integer getPassedPercent() {
        return passedPercent;
    }

    public void setPassedPercent(Integer passedPercent) {
        this.passedPercent = passedPercent;
    }

    public Integer getErrorPercent() {
        return errorPercent;
    }

    public void setErrorPercent(Integer errorPercent) {
        this.errorPercent = errorPercent;
    }

    public Integer getImprovePercent() {
        return improvePercent;
    }

    public void setImprovePercent(Integer improvePercent) {
        this.improvePercent = improvePercent;
    }

    public String getIndexedPages() {
        return indexedPages;
    }

    public void setIndexedPages(String indexedPages) {
        this.indexedPages = indexedPages;
    }

    public String getBacklinksCounter() {
        return backlinksCounter;
    }

    public void setBacklinksCounter(String backlinksCounter) {
        this.backlinksCounter = backlinksCounter;
    }

    public String getFacebookDescription() {
        return facebookDescription;
    }

    public void setFacebookDescription(String facebookDescription) {
        this.facebookDescription = facebookDescription;
    }

    public String getMobileLoadTime() {
        return mobileLoadTime;
    }

    public void setMobileLoadTime(String mobileLoadTime) {
        this.mobileLoadTime = mobileLoadTime;
    }

    public String getTrafficEstimation() {
        return trafficEstimation;
    }

    public void setTrafficEstimation(String trafficEstimation) {
        this.trafficEstimation = trafficEstimation;
    }

    public String getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(String scoreValue) {
        this.scoreValue = scoreValue;
    }

    public String getPInterestBoards() {
        return pInterestBoards;
    }

    public void setPInterestBoards(String pInterestBoards) {
        this.pInterestBoards = pInterestBoards;
    }

    public String getPInterestPins() {
        return pInterestPins;
    }

    public void setPInterestPins(String pInterestPins) {
        this.pInterestPins = pInterestPins;
    }

    public String getPInterestLikes() {
        return pInterestLikes;
    }

    public void setPInterestLikes(String pInterestLikes) {
        this.pInterestLikes = pInterestLikes;
    }

    public String getPInterestFollower() {
        return pInterestFollower;
    }

    public void setPInterestFollower(String pInterestFollower) {
        this.pInterestFollower = pInterestFollower;
    }

    public String getPInterestFollowing() {
        return pInterestFollowing;
    }

    public void setPInterestFollowing(String pInterestFollowing) {
        this.pInterestFollowing = pInterestFollowing;
    }

    public String getPInterestImage() {
        return pInterestImage;
    }

    public void setPInterestImage(String pInterestImage) {
        this.pInterestImage = pInterestImage;
    }

    public String getPInterestName() {
        return pInterestName;
    }

    public void setPInterestName(String pInterestName) {
        this.pInterestName = pInterestName;
    }

    public String getPInterestDescription() {
        return pInterestDescription;
    }

    public void setPInterestDescription(String pInterestDescription) {
        this.pInterestDescription = pInterestDescription;
    }

    public String getLinkedFollower() {
        return linkedFollower;
    }

    public void setLinkedFollower(String linkedFollower) {
        this.linkedFollower = linkedFollower;
    }

    public String getLinkedImage() {
        return linkedImage;
    }

    public void setLinkedImage(String linkedImage) {
        this.linkedImage = linkedImage;
    }

    public String getLinkedDescription() {
        return linkedDescription;
    }

    public void setLinkedDescription(String linkedDescription) {
        this.linkedDescription = linkedDescription;
    }

    public String getLinkedSpecialties() {
        return linkedSpecialties;
    }

    public void setLinkedSpecialties(String linkedSpecialties) {
        this.linkedSpecialties = linkedSpecialties;
    }

    public String getLinkedWebsite() {
        return linkedWebsite;
    }

    public void setLinkedWebsite(String linkedWebsite) {
        this.linkedWebsite = linkedWebsite;
    }

    public String getLinkedIndustry() {
        return linkedIndustry;
    }

    public void setLinkedIndustry(String linkedIndustry) {
        this.linkedIndustry = linkedIndustry;
    }

    public String getLinkedType() {
        return linkedType;
    }

    public void setLinkedType(String linkedType) {
        this.linkedType = linkedType;
    }

    public String getLinkedHeadquater() {
        return linkedHeadquater;
    }

    public void setLinkedHeadquater(String linkedHeadquater) {
        this.linkedHeadquater = linkedHeadquater;
    }

    public String getLinkedCompany() {
        return linkedCompany;
    }

    public void setLinkedCompany(String linkedCompany) {
        this.linkedCompany = linkedCompany;
    }

    public String getLinkedFounded() {
        return linkedFounded;
    }

    public void setLinkedFounded(String linkedFounded) {
        this.linkedFounded = linkedFounded;
    }

    public String getLinkedEmployee() {
        return linkedEmployee;
    }

    public void setLinkedEmployee(String linkedEmployee) {
        this.linkedEmployee = linkedEmployee;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getALexaRank() {
        return aLexaRank;
    }

    public void setALexaRank(String aLexaRank) {
        this.aLexaRank = aLexaRank;
    }

    public String getFacebookShareCount() {
        return facebookShareCount;
    }

    public void setFacebookShareCount(String facebookShareCount) {
        this.facebookShareCount = facebookShareCount;
    }

    public String getFacebookLikesCount() {
        return facebookLikesCount;
    }

    public void setFacebookLikesCount(String facebookLikesCount) {
        this.facebookLikesCount = facebookLikesCount;
    }

    public String getFacebookComment() {
        return facebookComment;
    }

    public void setFacebookComment(String facebookComment) {
        this.facebookComment = facebookComment;
    }

    public String getFacebookTotalCount() {
        return facebookTotalCount;
    }

    public void setFacebookTotalCount(String facebookTotalCount) {
        this.facebookTotalCount = facebookTotalCount;
    }

    public String getFacebookClickCount() {
        return facebookClickCount;
    }

    public void setFacebookClickCount(String facebookClickCount) {
        this.facebookClickCount = facebookClickCount;
    }

    public String getFacebookCommentsBoxCount() {
        return facebookCommentsBoxCount;
    }

    public void setFacebookCommentsBoxCount(String facebookCommentsBoxCount) {
        this.facebookCommentsBoxCount = facebookCommentsBoxCount;
    }

    public String getLinkedInCount() {
        return linkedInCount;
    }

    public void setLinkedInCount(String linkedInCount) {
        this.linkedInCount = linkedInCount;
    }

    public String getPinterestCount() {
        return pinterestCount;
    }

    public void setPinterestCount(String pinterestCount) {
        this.pinterestCount = pinterestCount;
    }

    public String getTwitterCounts() {
        return twitterCounts;
    }

    public void setTwitterCounts(String twitterCounts) {
        this.twitterCounts = twitterCounts;
    }

    public String getGooglePlusLike() {
        return googlePlusLike;
    }

    public void setGooglePlusLike(String googlePlusLike) {
        this.googlePlusLike = googlePlusLike;
    }
}
