/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.dao;

import java.util.List;
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
public interface WebmasterDao {

    public void saveQueries(List<Webmasterquery> list);

    public void saveWebmasterUrls(List<Webmasterurl> list);

    public void saveGraphData(List<Webmastergraph> list);

    public void saveWebmasterSiteMap(List<Webmastersitemap> list);

    public void saveWebmasterCrawlErrorsCount(List<Webmastercrawlerrorscount> list);

    public void saveWebmasterCrawlErrorsSamples(List<Webmastercrawlerrorssamples> list);

    public List getGraphData(String siteUrl);

    public List getQueryData(String siteUrl);

    public List<String> getWebmasterUrls(int customerId);

    public List getSiteMapData(String siteUrl);

    public List getCrawlErrorCountData(String siteUrl);

    public List getCrawlErrorSamplesData(String siteUrl);

    public void deleteOldData(String url);

}
