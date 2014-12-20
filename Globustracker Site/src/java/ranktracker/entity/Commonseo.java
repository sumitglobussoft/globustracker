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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "commonseo")
@NamedQueries({
    @NamedQuery(name = "Commonseo.findAll", query = "SELECT c FROM Commonseo c")})
public class Commonseo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "countryRank")
    private String countryRank;
    @Lob
    @Column(name = "description")
    private String description;
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
    @Column(name = "ipadView")
    private String ipadView;
    @Column(name = "ipaddress")
    private String ipaddress;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commonseo)) {
            return false;
        }
        Commonseo other = (Commonseo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Commonseo[ id=" + id + " ]";
    }
    
}
