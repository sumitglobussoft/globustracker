/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import ranktracker.dao.WebmasterDao;
import ranktracker.entity.Webmastercrawlerrorscount;
import ranktracker.entity.Webmastercrawlerrorssamples;
import ranktracker.entity.Webmastergraph;
import ranktracker.entity.Webmasterquery;
import ranktracker.entity.Webmastersitemap;
import ranktracker.entity.Webmasterurl;

/**
 *
 * @author GLB-214
 */
public class WebmasterServiceImpl {

    private WebmasterDao objWebmasterDao;

    public void saveQueries(List<Webmasterquery> list) {
        objWebmasterDao.saveQueries(list);
    }

    public void saveWebmasterUrls(List<Webmasterurl> list) {
        objWebmasterDao.saveWebmasterUrls(list);
    }

    public void saveGraphData(List<Webmastergraph> list) {
        objWebmasterDao.saveGraphData(list);
    }

    public void saveWebmasterSiteMap(List<Webmastersitemap> list) {
        objWebmasterDao.saveWebmasterSiteMap(list);
    }

    public void saveWebmasterCrawlErrorsCount(List<Webmastercrawlerrorscount> list) {
        objWebmasterDao.saveWebmasterCrawlErrorsCount(list);
    }

    public void saveWebmasterCrawlErrorsSamples(List<Webmastercrawlerrorssamples> list) {
        objWebmasterDao.saveWebmasterCrawlErrorsSamples(list);
    }

    public List getGraphData(String siteUrl) {
        return objWebmasterDao.getGraphData(siteUrl);
    }

    public List getQueryData(String siteUrl) {
        return objWebmasterDao.getQueryData(siteUrl);
    }

    public List<String> getWebmasterUrls(int customerId) {
        return objWebmasterDao.getWebmasterUrls(customerId);
    }

    public List getSiteMapData(String siteUrl) {
        return objWebmasterDao.getSiteMapData(siteUrl);
    }

    public List getCrawlErrorCountData(String siteUrl) {
        return objWebmasterDao.getCrawlErrorCountData(siteUrl);
    }

    public List getCrawlErrorSamplesData(String siteUrl) {
        return objWebmasterDao.getCrawlErrorSamplesData(siteUrl);
    }

    public void deleteOldData(String url) {
        objWebmasterDao.deleteOldData(url);
    }

    public WebmasterDao getObjWebmasterDao() {
        return objWebmasterDao;
    }

    public void setObjWebmasterDao(WebmasterDao objWebmasterDao) {
        this.objWebmasterDao = objWebmasterDao;
    }

}
