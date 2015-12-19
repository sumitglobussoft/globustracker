/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
public interface WebmasterService {

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveQueries(List<Webmasterquery> list);

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWebmasterUrls(List<Webmasterurl> list);

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveGraphData(List<Webmastergraph> list);

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWebmasterSiteMap(List<Webmastersitemap> list);

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWebmasterCrawlErrorsCount(List<Webmastercrawlerrorscount> list);

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveWebmasterCrawlErrorsSamples(List<Webmastercrawlerrorssamples> list);

    public List getGraphData(String siteUrl);

    public List getQueryData(String siteUrl);

    public List<String> getWebmasterUrls(int customerId);

    public List getSiteMapData(String siteUrl);

    public List getCrawlErrorCountData(String siteUrl);

    public List getCrawlErrorSamplesData(String siteUrl);

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteOldData(String url);

}
