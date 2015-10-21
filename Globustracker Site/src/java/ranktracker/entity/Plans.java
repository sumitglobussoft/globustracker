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
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "plans")
public class Plans implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PlanID")
    private Integer planID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Amount")
    private int amount;
    @Basic(optional = false)
    @Column(name = "Currency")
    private String currency;
    @Basic(optional = false)
    @Column(name = "Campaigns")
    private int campaigns;
    @Basic(optional = false)
    @Column(name = "Keywords")
    private int keywords;
    @Basic(optional = false)
    @Column(name = "Users")
    private int users;
    @Basic(optional = false)
    @Column(name = "GoogleAnalytics")
    private int googleAnalytics;
    @Basic(optional = false)
    @Column(name = "KeywordResearch")
    private int keywordResearch;
    @Basic(optional = false)
    @Column(name = "Webmastertools")
    private int webmastertools;
    @Basic(optional = false)
    @Column(name = "WebsiteReview")
    private int websiteReview;
    @Basic(optional = false)
    @Column(name = "AccurateLocalRanking")
    private int accurateLocalRanking;
    @Basic(optional = false)
    @Column(name = "LinkAnalysis")
    private int linkAnalysis;

    public Plans() {
    }

    public Plans(Integer planID) {
        this.planID = planID;
    }

    public Plans(Integer planID, String name, int amount, String currency, int campaigns, int keywords, int users, int googleAnalytics, int keywordResearch, int webmastertools, int websiteReview, int accurateLocalRanking, int linkAnalysis) {
        this.planID = planID;
        this.name = name;
        this.amount = amount;
        this.currency = currency;
        this.campaigns = campaigns;
        this.keywords = keywords;
        this.users = users;
        this.googleAnalytics = googleAnalytics;
        this.keywordResearch = keywordResearch;
        this.webmastertools = webmastertools;
        this.websiteReview = websiteReview;
        this.accurateLocalRanking = accurateLocalRanking;
        this.linkAnalysis = linkAnalysis;
    }

    public Integer getPlanID() {
        return planID;
    }

    public void setPlanID(Integer planID) {
        this.planID = planID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(int campaigns) {
        this.campaigns = campaigns;
    }

    public int getKeywords() {
        return keywords;
    }

    public void setKeywords(int keywords) {
        this.keywords = keywords;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getGoogleAnalytics() {
        return googleAnalytics;
    }

    public void setGoogleAnalytics(int googleAnalytics) {
        this.googleAnalytics = googleAnalytics;
    }

    public int getKeywordResearch() {
        return keywordResearch;
    }

    public void setKeywordResearch(int keywordResearch) {
        this.keywordResearch = keywordResearch;
    }

    public int getWebmastertools() {
        return webmastertools;
    }

    public void setWebmastertools(int webmastertools) {
        this.webmastertools = webmastertools;
    }

    public int getWebsiteReview() {
        return websiteReview;
    }

    public void setWebsiteReview(int websiteReview) {
        this.websiteReview = websiteReview;
    }

    public int getAccurateLocalRanking() {
        return accurateLocalRanking;
    }

    public void setAccurateLocalRanking(int accurateLocalRanking) {
        this.accurateLocalRanking = accurateLocalRanking;
    }

    public int getLinkAnalysis() {
        return linkAnalysis;
    }

    public void setLinkAnalysis(int linkAnalysis) {
        this.linkAnalysis = linkAnalysis;
    }
}
