/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import ranktracker.entity.Webmastercrawlerrorscount;
import ranktracker.entity.Webmastercrawlerrorssamples;
import ranktracker.entity.Webmastergraph;
import ranktracker.entity.Webmasterquery;
import ranktracker.entity.Webmastersitemap;
import ranktracker.entity.Webmasterurl;

/**
 *
 * @author NITESH SHAH
 */
public class WebmasterDaoImpl {

    public Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

    public void saveQueries(List<Webmasterquery> list) {
        for (Webmasterquery query : list) {
            try {
                session.beginTransaction();
                session.save(query);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveWebmasterUrls(List<Webmasterurl> list) {
        for (Webmasterurl url : list) {
            try {
                session.beginTransaction();
                session.save(url);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveGraphData(List<Webmastergraph> list) {
        for (Webmastergraph graph : list) {
            try {
                session.beginTransaction();
                session.save(graph);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveWebmasterSiteMap(List<Webmastersitemap> list) {
        for (Webmastersitemap sitemapList : list) {
            try {
                session.beginTransaction();
                session.save(sitemapList);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveWebmasterCrawlErrorsCount(List<Webmastercrawlerrorscount> list) {
        for (Webmastercrawlerrorscount errorcountList : list) {
            try {
                session.beginTransaction();
                session.save(errorcountList);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveWebmasterCrawlErrorsSamples(List<Webmastercrawlerrorssamples> list) {
        for (Webmastercrawlerrorssamples errorsampleList : list) {
            try {
                session.beginTransaction();
                session.save(errorsampleList);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List getGraphData(String siteUrl) {
        Query query = session.createQuery("from Webmastergraph where siteurl = " + "'" + siteUrl + "'");
        List<Webmastergraph> list = query.list();
        return list;
    }

    public List getQueryData(String siteUrl) {
        Query query = session.createQuery("from Webmasterquery where siteurl = " + "'" + siteUrl + "'");
        List<Webmasterquery> list = query.list();
        return list;
    }

    public List<String> getWebmasterUrls(int customerId) {
        Query query = session.createQuery("select url from Webmasterurl where customerId = " + customerId);
        List<String> list = query.list();
        return list;
    }

    public List getSiteMapData(String siteUrl) {
        Query query = session.createQuery("from Webmastersitemap where siteurl = " + "'" + siteUrl + "'");
        List<Webmastersitemap> list = query.list();
        return list;
    }

    public List getCrawlErrorCountData(String siteUrl) {
        Query query = session.createQuery("from Webmastercrawlerrorscount where siteurl = " + "'" + siteUrl + "'");
        List<Webmastercrawlerrorscount> list = query.list();
        return list;
    }

    public List getCrawlErrorSamplesData(String siteUrl) {
        Query query = session.createQuery("from Webmastercrawlerrorssamples where siteurl = " + "'" + siteUrl + "'");
        List<Webmastercrawlerrorssamples> list = query.list();
        return list;
    }

    public void deleteOldData(String url) {
        try {
            Query urlQuery = session.createQuery("Delete from Webmasterurl where url = '" + url + "'");
            session.beginTransaction();
            urlQuery.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Query graphQuery = session.createQuery("Delete from Webmasterquery where siteurl = '" + url + "'");
            session.beginTransaction();
            graphQuery.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Query queryQuery = session.createQuery("Delete from Webmastergraph where siteurl = '" + url + "'");
            session.beginTransaction();
            queryQuery.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Query siteMapQuery = session.createQuery("Delete from Webmastersitemap where siteurl = '" + url + "'");
            session.beginTransaction();
            siteMapQuery.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Query errorCountQuery = session.createQuery("Delete from Webmastercrawlerrorscount where siteurl = '" + url + "'");
            session.beginTransaction();
            errorCountQuery.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Query errorSamplesQuery = session.createQuery("Delete from Webmastercrawlerrorssamples where siteurl = '" + url + "'");
            session.beginTransaction();
            errorSamplesQuery.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
