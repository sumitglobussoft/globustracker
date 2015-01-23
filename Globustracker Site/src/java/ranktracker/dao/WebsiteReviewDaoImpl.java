/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ranktracker.entity.Commonseo;
import ranktracker.entity.Headingcount;
import ranktracker.entity.Headingelements;
import ranktracker.entity.Image;
import ranktracker.entity.Pagelinks;
import ranktracker.entity.Relatedwebsite;
import ranktracker.entity.Technology;
import ranktracker.entity.Visitorarray;
import ranktracker.entity.Xmldata;
import java.util.Set;

/**
 *
 * @author User
 */
public class WebsiteReviewDaoImpl extends HibernateDaoSupport implements WebsiteReviewDao {

    @Override
    public Map getCommonsDetails(String sitename) {
        Map<String, String> visitormap = new LinkedHashMap<>();

        List<Commonseo> commonseo;
        try {

            Criteria criteria = getSession().createCriteria(Commonseo.class);
            criteria.add(Restrictions.eq("urlDomain", sitename));

            commonseo = criteria.list();
            if (commonseo.isEmpty()) {
                Thread.sleep(1000);
                commonseo = criteria.list();
            }

            for (Commonseo commnseo : commonseo) {
                visitormap.put("wwwresolve", commnseo.getWwwResolve());
                visitormap.put("ipCanonicalization", commnseo.getIpCanonicalization());
                visitormap.put("robots", commnseo.getRobots());
                visitormap.put("underscores", commnseo.getUnderscores());
                visitormap.put("reviewGoogleTitle", commnseo.getReviewGoogleTitle());
                visitormap.put("reviewGoogleUrl", commnseo.getReviewGoogleUrl());
                visitormap.put("reviewGoogleDesc", commnseo.getReviewGoogleDesc());
                visitormap.put("googlePublisher", commnseo.getGooglePublisher());
                visitormap.put("title", commnseo.getTitle());
                visitormap.put("titleLength", commnseo.getTitleLength());
                visitormap.put("description", commnseo.getDescription());
                visitormap.put("descriptionLength", commnseo.getDescriptionLength());
                visitormap.put("keyword", commnseo.getKeyword());
                visitormap.put("htmlRatio", commnseo.getHtmlRatio());
                visitormap.put("flash", commnseo.getFlash());
                visitormap.put("frames", commnseo.getFrames());
                visitormap.put("pageRank", commnseo.getPageRank());
                visitormap.put("domainCreated", commnseo.getDomainCreated());
                visitormap.put("domainUpdated", commnseo.getDomainUpdated());
                visitormap.put("domainExpired", commnseo.getDomainExpired());
                visitormap.put("ipaddress", commnseo.getIpaddress());
                visitormap.put("facebookUrl", commnseo.getFacebookUrl());
                visitormap.put("facebookName", commnseo.getFacebookName());
                visitormap.put("facebookLikes", commnseo.getFacebookLikes());
                visitormap.put("facebookAbout", commnseo.getFacebookAbout());
                visitormap.put("facebookImage", commnseo.getFacebookImage());
                visitormap.put("facebookOverview", commnseo.getFacebookOverview());
                visitormap.put("facebookProduct", commnseo.getFacebookProduct());
                visitormap.put("facebookAddress", commnseo.getFacebookAddress());
                visitormap.put("facebookPhone", commnseo.getFacebookPhone());
                visitormap.put("facebookMission", commnseo.getFacebookMission());
                visitormap.put("takingAbout", commnseo.getTakingAbout());
                visitormap.put("googleImage", commnseo.getGoogleImage());
                visitormap.put("googleUrl", commnseo.getGoogleUrl());
                visitormap.put("googleName", commnseo.getGoogleName());
                visitormap.put("googleVerified", commnseo.getGoogleVerified());
                visitormap.put("googleTagline", commnseo.getGoogleTagline());
                visitormap.put("googleIntroduction", commnseo.getGoogleIntroduction());
                visitormap.put("googleOverview", commnseo.getGoogleOverview());
                visitormap.put("googleFollower", commnseo.getGoogleFollower());
                visitormap.put("googleViews", commnseo.getGoogleViews());
                visitormap.put("flagCode", commnseo.getFlagCode());
                visitormap.put("location", commnseo.getLocat());
                visitormap.put("urlDomain", commnseo.getUrlDomain());
                visitormap.put("iphoneView", commnseo.getIphoneView());
                visitormap.put("ipadView", commnseo.getIpadView());
                visitormap.put("countryRank", commnseo.getCountryRank());
                visitormap.put("globalrank", commnseo.getGlobalRank());
                visitormap.put("w3cvalidity", commnseo.getW3cvalidity());
                visitormap.put("encoding", commnseo.getEncoding());
                visitormap.put("doctype", commnseo.getDoctype());
                visitormap.put("twitterName", commnseo.getTwitterName());
                visitormap.put("twitterImage", commnseo.getTwitterImage());
                visitormap.put("twitterCount", commnseo.getTwitterCount());
                visitormap.put("twitterFollowing", commnseo.getTwitterFollowing());
                visitormap.put("twitterFollower", commnseo.getTwitterFollower());
                visitormap.put("twitterDescription", commnseo.getTwitterDescription());
                visitormap.put("twitterLocation", commnseo.getTwitterLocation());
                visitormap.put("twitterUrl", commnseo.getTwitterUrl());
                visitormap.put("twitterFavourites", commnseo.getTwitterFavourites());
                visitormap.put("twitterDate", commnseo.getTwitterDate());
                visitormap.put("twitterList", commnseo.getTwitterList());
                visitormap.put("dashboardImage", commnseo.getDashboardImage());
                visitormap.put("usabilityImage", commnseo.getUsabilityImage());
                visitormap.put("passedPercent", commnseo.getPassedPercent().toString());
                visitormap.put("errorPercent", commnseo.getErrorPercent().toString());
                visitormap.put("improvePercent", commnseo.getImprovePercent().toString());
                visitormap.put("indexedPages", commnseo.getIndexedPages());
                visitormap.put("backlinksCounter", commnseo.getBacklinksCounter());
                visitormap.put("facebookDescription", commnseo.getFacebookDescription());
                visitormap.put("mobileLoadTime", commnseo.getMobileLoadTime());
                visitormap.put("trafficEstimation", commnseo.getTrafficEstimation());
//                visitormap.put("scoreValue", commnseo.getScoreValue());
//                visitormap.put("latitude", ""+commnseo.getLatitude());
//                visitormap.put("longitude", commnseo.getLongitude());
                visitormap.put("pInterestBoards", commnseo.getPInterestBoards());
                visitormap.put("pInterestPins", commnseo.getPInterestPins());
                visitormap.put("pInterestLikes", commnseo.getPInterestLikes());
                visitormap.put("pInterestFollower", commnseo.getPInterestFollower());
                visitormap.put("pInterestFollowing", commnseo.getPInterestFollowing());
                visitormap.put("pInterestImage", commnseo.getPInterestImage());
                visitormap.put("pInterestName", commnseo.getPInterestName());
                visitormap.put("pInterestDescription", commnseo.getPInterestDescription());
                visitormap.put("linkedFollower", commnseo.getLinkedFollower());
                visitormap.put("linkedImage", commnseo.getLinkedImage());
                visitormap.put("linkedDescription", commnseo.getLinkedDescription());
                visitormap.put("linkedSpecialties", commnseo.getLinkedSpecialties());
                visitormap.put("linkedWebsite", commnseo.getLinkedWebsite());
                visitormap.put("linkedIndustry", commnseo.getLinkedIndustry());
                visitormap.put("linkedType", commnseo.getLinkedType());
                visitormap.put("linkedHeadquater", commnseo.getLinkedHeadquater());
                visitormap.put("linkedCompany", commnseo.getLinkedCompany());
                visitormap.put("linkedFounded", commnseo.getLinkedFounded());
                visitormap.put("linkedEmployee", commnseo.getLinkedEmployee());

                System.out.println("commnseo.getDoctype() ============ " + commnseo.getDoctype());
                break;
            }
        } catch (Exception ex) {
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visitormap;
    }

    @Override
    public Map getHeadingcount(String sitename) {

        System.out.println("getHeadingcount--------------");
        Map<String, String> headingmap = new LinkedHashMap<>();
        List<Headingcount> headingcount;
        try {

            Criteria criteria = getSession().createCriteria(Headingcount.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            headingcount = criteria.list();
            if (headingcount.isEmpty()) {
                Thread.sleep(1000);
                headingcount = criteria.list();
            }

            for (Headingcount headcount : headingcount) {
                headingmap.put("heading1", headcount.getHeading1());
                headingmap.put("heading2", headcount.getHeading2());
                headingmap.put("heading3", headcount.getHeading3());
                headingmap.put("heading4", headcount.getHeading4());
                headingmap.put("heading5", headcount.getHeading5());
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException | InterruptedException e) {
            e.printStackTrace();
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return headingmap;
    }

    @Override
    public Map getHeadingelement(String sitename) {
        System.out.println("==========ENTER IN HEADINGSELEMENTS===================");
        Map<String, String> headingmap = new LinkedHashMap<>();
        List<Headingelements> headingcount;
        try {

            Criteria criteria = getSession().createCriteria(Headingelements.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            headingcount = criteria.list();
            if (headingcount.isEmpty()) {
                Thread.sleep(1000);
                headingcount = criteria.list();
            }
            int k = 1;
            for (Headingelements headingelements : headingcount) {
                // System.out.println("-------------HEADINGSELEMENTS----------------------");
                if (headingelements.getH1elements() != null && headingelements.getH1elements().contains("h1")) {
                    headingmap.put("h1elements" + k, headingelements.getH1elements());
//                    System.out.println(headingmap);
                } else if (headingelements.getH2elements() != null && headingelements.getH2elements().contains("h2")) {
                    headingmap.put("h2elements" + k, headingelements.getH2elements());
//                    System.out.println(headingmap);
                } else if (headingelements.getH3elements() != null && headingelements.getH3elements().contains("h3")) {
                    headingmap.put("h3elements" + k, headingelements.getH3elements());
//                    System.out.println(headingmap);
                } else if (headingelements.getH4elements() != null && headingelements.getH4elements().contains("h4")) {
                    headingmap.put("h4elements" + k, headingelements.getH4elements());
//                    System.out.println(headingmap);
                } else if (headingelements.getH5elements() != null && headingelements.getH5elements().contains("h5")) {
                    headingmap.put("h5elements" + k, headingelements.getH5elements());
//                    System.out.println(headingmap);
                }
                k++;
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException | InterruptedException e) {
            e.printStackTrace();
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return headingmap;
    }

    @Override
    public Map getImagedata(String sitename) {

        Map<String, String> imagemap = new LinkedHashMap<>();
        List<Image> image;
        try {

            Criteria criteria = getSession().createCriteria(Image.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            image = criteria.list();
            if (image.isEmpty()) {
                Thread.sleep(1000);
                image = criteria.list();
            }

            int i = 1;
            for (Image imagecount : image) {
                imagemap.put("src" + i, imagecount.getSrc());
                i++;
                // System.out.println(imagemap);
            }

        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException | InterruptedException e) {
            e.printStackTrace();
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return imagemap;
    }

    @Override
    public Map getPageLinksdata(String sitename) {
        Map<Integer, Pagelinks> pagemap = new LinkedHashMap<>();

        List<Pagelinks> pagelinks;
        try {
            System.out.println("==========Enter in PageLinksdata====================");
            Criteria criteria = getSession().createCriteria(Pagelinks.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            pagelinks = criteria.list();
            if (pagelinks.isEmpty()) {
                Thread.sleep(1000);
                pagelinks = criteria.list();
            }
            int k = 1;
            for (Pagelinks pagecount : pagelinks) {
                pagemap.put(k, pagecount);
//                pagemap.put("links" + k, pagecount.getLinks());
//                System.out.println(pagemap.get("links"));
//                System.out.println(pagemap);
//                pagemap.put("title" + k, pagecount.getTitle());
//                System.out.println(pagemap);
//                pagemap.put("type" + k, pagecount.getType());
//                System.out.println(pagemap);
                k++;
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException | InterruptedException e) {
            e.printStackTrace();
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return pagemap;

    }

    @Override
    public Map getRelatedWebsite(String sitename) {
        Map<String, String> relwebsitemap = new LinkedHashMap<>();
        List<Relatedwebsite> pagelinks;
        try {

            Criteria criteria = getSession().createCriteria(Relatedwebsite.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            pagelinks = criteria.list();
            if (pagelinks.isEmpty()) {
                Thread.sleep(1000);
                pagelinks = criteria.list();
            }

            int j = 1;
            for (Relatedwebsite relatedwebcount : pagelinks) {
                relwebsitemap.put("relatedlink" + j, relatedwebcount.getRelatedLinks());
                j++;
//                System.out.println(relwebsitemap);
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException | InterruptedException e) {
            e.printStackTrace();
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return relwebsitemap;
    }

    @Override
    public Map getTechnologydata(String sitename) {
        Map<String, String> technologymap = new LinkedHashMap<>();
        System.out.println("ENTER IN TECHNOLOGY");
        List<Technology> technology;
        try {

            Criteria criteria = getSession().createCriteria(Technology.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            technology = criteria.list();
            if (technology.isEmpty()) {
                Thread.sleep(1000);
                technology = criteria.list();
            }
            int k = 1;
            for (Technology technologycount : technology) {
                technologymap.put("technologyused" + k, technologycount.getTechUsed());
//                System.out.println(technologymap);
                technologymap.put("analytics" + k, technologycount.getAnalytics());
//                System.out.println(technologymap);
                k++;
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException | InterruptedException e) {
            e.printStackTrace();
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return technologymap;
    }

    @Override
    public Map getVisitorarray(String sitename) {
        Map<Integer, Visitorarray> visitorarraymap = new LinkedHashMap<>();
        LinkedHashSet hs = new LinkedHashSet();
        List<Visitorarray> visitorarray;
        try {

            Criteria criteria = getSession().createCriteria(Visitorarray.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            visitorarray = criteria.list();

            if (visitorarray.isEmpty()) {
                Thread.sleep(1000);
                visitorarray = criteria.list();
            }

            int k = 1;
            for (Visitorarray visitorcount : visitorarray) {
                visitorarraymap.put(k, visitorcount);
//                visitorarraymap.put("country" + k, visitorcount.getCountry());
////                System.out.println(visitorarraymap);      
//                visitorarraymap.put("percent" + k, visitorcount.getPercent());
////                System.out.println(visitorarraymap);
//                visitorarraymap.put("rank" + k, visitorcount.getRank());
//                System.out.println(visitorarraymap);
                k++;
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException | InterruptedException e) {
            e.printStackTrace();
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return visitorarraymap;
    }

    @Override
    public Map getXmldata(String sitename) {
        Map<String, String> xmldatamap = new LinkedHashMap<>();
        try {

            Criteria criteria = getSession().createCriteria(Xmldata.class);
            criteria.add(Restrictions.like("url", "%" + sitename));

            List<Xmldata> xmldata = criteria.list();

            if (xmldata.isEmpty()) {
                Thread.sleep(1000);
            }
            int m = 0;
            for (Xmldata xmldatacount : xmldata) {
                xmldatamap.put("xmlfiles" + m, xmldatacount.getXmlfiles());
//                System.out.println(xmldatamap);
                m++;
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException | InterruptedException e) {
            e.printStackTrace();
            Logger.getLogger(WebsiteReviewDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return xmldatamap;
    }

}
