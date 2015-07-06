package globuswoo.dao;

import globuswoo.crawlers.HeadingStructure;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import globuswoo.entity.Commonseo;
import globuswoo.entity.Headingcount;
import globuswoo.entity.Headingelements;
import globuswoo.entity.Image;
import globuswoo.entity.Pagelinks;
import globuswoo.entity.Relatedwebsite;
import globuswoo.entity.Technology;
import globuswoo.entity.Visitorarray;
import globuswoo.entity.Xmldata;
import org.hibernate.Transaction;

public class WoorankDaoImpl implements WoorankDao {

    public HeadingStructure objHeadingStructure = new HeadingStructure();
    public Image objImage = new Image();
    public Pagelinks objPagelinks = new Pagelinks();
    public Relatedwebsite objRelatedwebsite = new Relatedwebsite();
    public Technology objTechnology = new Technology();
    public Visitorarray objVisitorarray = new Visitorarray();
    public Xmldata objXmldata = new Xmldata();
    public Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

    @Override
    public void insertCommonseo(Commonseo objcommonseo) {

//        getSession().save(objcommonseo);
        session.beginTransaction();
        session.save(objcommonseo);
        session.getTransaction().commit();
    }

    @Override
    public void insertHeading(Headingcount objheadingcount) {
        session.beginTransaction();
        session.save(objheadingcount);
        session.getTransaction().commit();
    }

    @Override
    public void insertHeadingElement(Headingelements objHeadingelements) {
        session.beginTransaction();
        session.save(objHeadingelements);
        session.getTransaction().commit();
    }

    @Override
    public void insertPageLinks(Pagelinks objPagelinks) {
        session.beginTransaction();
        session.save(objPagelinks);
        session.getTransaction().commit();
    }

    @Override
    public void insertImage(Image objImage) {
        session.beginTransaction();
        session.save(objImage);
        session.getTransaction().commit();
    }

    @Override
    public void insertRelatedWebsite(Relatedwebsite objRelatedwebsite) {
        session.beginTransaction();
        session.save(objRelatedwebsite);
        session.getTransaction().commit();
    }

    @Override
    public void insertTechnology(Technology objTechnology) {
        session.beginTransaction();
        session.save(objTechnology);
        session.getTransaction().commit();
    }

    @Override
    public void insertVisitor(Visitorarray objVisitorarray) {
        session.beginTransaction();
        session.save(objVisitorarray);
        session.getTransaction().commit();
    }

    @Override
    public void insertXmlData(Xmldata objXmldata) {
        session.beginTransaction();
        session.save(objXmldata);
        session.getTransaction().commit();
    }

    @Override
    public Commonseo getCommonSeoDetails(String url) {
        Commonseo objCommonseo = new Commonseo();
        try {

            Query queryResult = session.createQuery("from Commonseo where url = :url");
            queryResult.setString("url", url);
            List result = queryResult.list();
            for (int i = 0; i < result.size(); i++) {
                objCommonseo = (Commonseo) result.get(i);
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return objCommonseo;
    }

    @Override
    public Headingcount getHeadingCountDetails(String url) {
        Headingcount objHeadingcount = new Headingcount();
        try {

            Query queryResult = session.createQuery("from Headingcount where url = :url");
            queryResult.setString("url", url);
            List result = queryResult.list();
            for (int i = 0; i < result.size(); i++) {
                objHeadingcount = (Headingcount) result.get(i);
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return objHeadingcount;
    }

    @Override
    public Headingelements getHeadingelementsDetails(String url) {
        Headingelements objHeadingelements = new Headingelements();
//        List<Headingelements> result = null;
        try {

            Query queryResult = session.createQuery("from Headingelements where url = :url");
            queryResult.setString("url", url);
            List result = queryResult.list();
            for (int i = 0; i < result.size(); i++) {
                objHeadingelements = (Headingelements) result.get(i);
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return objHeadingelements;
    }

    @Override
    public Image getImageDetails(String url) {
        Image objImage = new Image();
//        List<Image> result = null;
        try {

            Query queryResult = session.createQuery("from Image where url = :url");
            queryResult.setString("url", url);
            List result = queryResult.list();
            for (int i = 0; i < result.size(); i++) {
                objImage = (Image) result.get(i);
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return objImage;
    }

    @Override
    public Pagelinks getPagelinksDetails(String url) {
        Pagelinks objPagelinks = new Pagelinks();
//        List<Pagelinks> result = null;
        try {

            Query queryResult = session.createQuery("from Pagelinks where url = :url");
            queryResult.setString("url", url);
//            result = queryResult.list();
            List result = queryResult.list();
            for (int i = 0; i < result.size(); i++) {
                objPagelinks = (Pagelinks) result.get(i);
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return objPagelinks;
    }

    @Override
    public Relatedwebsite getRelatedwebsiteDetails(String url) {
        Relatedwebsite objRelatedwebsite = new Relatedwebsite();
//        List<Relatedwebsite> result = null;
        try {

            Query queryResult = session.createQuery("from Relatedwebsite where url = :url");
            queryResult.setString("url", url);
            List result = queryResult.list();
            for (int i = 0; i < result.size(); i++) {
                objRelatedwebsite = (Relatedwebsite) result.get(i);
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return objRelatedwebsite;
    }

    @Override
    public Technology getTechnologyDetails(String url) {
        Technology objTechnology = new Technology();
//        List<Technology> result = null;
        try {

            Query queryResult = session.createQuery("from Technology where url = :url");
            queryResult.setString("url", url);
//            result = queryResult.list();
            List result = queryResult.list();
            for (int i = 0; i < result.size(); i++) {
                objTechnology = (Technology) result.get(i);
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return objTechnology;
    }

    @Override
    public Visitorarray getVisitorarrayDetails(String url) {
        Visitorarray objVisitorarray = new Visitorarray();
//        List<Visitorarray> result = null;
        try {

            Query queryResult = session.createQuery("from Visitorarray where url = :url");
            queryResult.setString("url", url);
//            result = queryResult.list();
            List result = queryResult.list();
            for (int i = 0; i < result.size(); i++) {
                objVisitorarray = (Visitorarray) result.get(i);
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return objVisitorarray;
    }

    @Override
    public Xmldata getXmldataDetails(String url) {
        Xmldata objXmldata = new Xmldata();
//        List<Xmldata> result = null;
        try {

            Query queryResult = session.createQuery("from Xmldata where url = :url");
            queryResult.setString("url", url);
            List result = queryResult.list();
            for (int i = 0; i < result.size(); i++) {
                objXmldata = (Xmldata) result.get(i);
            }

        } catch (HibernateException ex) {
        }
        return objXmldata;
    }

    @Override
    public void updateCommonseo(int id, String url, String pageRank, String titleLength, String title, String description, String descriptionLength, String flash, String frames, String htmlRatio, String facebookLikes, String facebookAbout, String facebookImage, String takingAbout, String googleImage, String googleFollower, String googleViews, String keyword, String globalRank, String countryRank, String w3cvalidity, String encoding, String doctype, String twitterimage, String twittercount, String twitterfolowing, String twitterfolowrs, String twitterdescrip, String twitterfavorites, String twitterdate, String twitterList, String indexedPages, String backlinksCounter, String mobileLoadTime, String trafficEstimation, String PinterestBoards, String PinterestPins, String PinterestLikes, String PinterestFollower, String PinterestFollowing, String PinterestImage, String PinterestName, String PinterestDescription, String linkedFollower, String linkedImage, String linkedDescription, String linkedSpecialties, String linkedWebsite, String linkedIndustry, String linkedType, String linkedHeadquater, String linkedCompany, String linkedFounded, String linkedEmployee, String aLexaRank, String facebookShareCount, String facebookLikesCount, String facebookComment, String facebookTotalCount, String facebookClickCount, String facebookCommentsBoxCount, String linkedInCount, String pinterestCount, String twitterCounts) {
        System.out.println("----------------------------------------------------------" + pageRank);
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Commonseo commonseo
                    = (Commonseo) session.get(Commonseo.class, id);
            commonseo.setPageRank(pageRank);
            commonseo.setTitleLength(titleLength);
            commonseo.setTitle(title);
            commonseo.setDescription(description);
            commonseo.setDescriptionLength(descriptionLength);
            commonseo.setFlash(flash);
            commonseo.setFrames(frames);
            commonseo.setHtmlRatio(htmlRatio);
            commonseo.setFacebookLikes(facebookLikes);
            commonseo.setFacebookAbout(facebookAbout);
            commonseo.setFacebookImage(facebookImage);
            commonseo.setTakingAbout(takingAbout);
            commonseo.setGoogleImage(googleImage);
            commonseo.setGoogleFollower(googleFollower);
            commonseo.setGoogleViews(googleViews);
            commonseo.setKeyword(keyword);
            commonseo.setGlobalRank(globalRank);
            commonseo.setCountryRank(countryRank);
            commonseo.setW3cvalidity(w3cvalidity);
            commonseo.setEncoding(encoding);
            commonseo.setDoctype(doctype);
            commonseo.setTwitterImage(twitterimage);
            commonseo.setTwitterCount(twittercount);
            commonseo.setTwitterFollowing(twitterfolowing);
            commonseo.setTwitterFollower(twitterfolowrs);
            commonseo.setTwitterDescription(twitterdescrip);
            commonseo.setTwitterFavourites(twitterfavorites);
            commonseo.setTwitterDate(twitterdate);
            commonseo.setTwitterList(twitterList);
            commonseo.setIndexedPages(indexedPages);
            commonseo.setBacklinksCounter(backlinksCounter);
            commonseo.setMobileLoadTime(mobileLoadTime);
            commonseo.setTrafficEstimation(trafficEstimation);
            commonseo.setPInterestBoards(PinterestBoards);
            commonseo.setPInterestPins(PinterestPins);
            commonseo.setPInterestLikes(PinterestLikes);
            commonseo.setPInterestFollower(PinterestFollower);
            commonseo.setPInterestFollowing(PinterestFollowing);
            commonseo.setPInterestImage(PinterestImage);
            commonseo.setPInterestName(PinterestName);
            commonseo.setPInterestDescription(PinterestDescription);
            commonseo.setLinkedFollower(linkedFollower);
            commonseo.setLinkedImage(linkedImage);
            commonseo.setLinkedDescription(linkedDescription);
            commonseo.setLinkedSpecialties(linkedSpecialties);
            commonseo.setLinkedWebsite(linkedWebsite);
            commonseo.setLinkedIndustry(linkedIndustry);
            commonseo.setLinkedHeadquater(linkedHeadquater);
            commonseo.setLinkedCompany(linkedCompany);
            commonseo.setLinkedFounded(linkedFounded);
            commonseo.setLinkedEmployee(linkedEmployee);
            commonseo.setALexaRank(aLexaRank);
            commonseo.setFacebookShareCount(facebookShareCount);
            commonseo.setFacebookLikesCount(facebookLikesCount);
            commonseo.setFacebookComment(facebookComment);
            commonseo.setFacebookTotalCount(facebookTotalCount);
            commonseo.setFacebookClickCount(facebookClickCount);
            commonseo.setFacebookCommentsBoxCount(facebookCommentsBoxCount);
            commonseo.setLinkedInCount(linkedInCount);
            commonseo.setPinterestCount(pinterestCount);
            commonseo.setTwitterCounts(twitterCounts);
            
            session.update(commonseo);
            //            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.close();
        }
    }

    @Override
    public void updateHeadingcount(String url, String heading1, String heading2, String heading3, String heading4, String heading5) {
        try {
            String s = "update headingcount set heading1=:h1,heading2=:h2,heading3=:h3,heading4=:h4,heading5=:h5 where url=:url";
            session.getTransaction().begin();
            Query query = session.createSQLQuery(s);
            query.setParameter("h1", heading1);
            query.setParameter("h2", heading2);
            query.setParameter("h3", heading3);
            query.setParameter("h4", heading4);
            query.setParameter("h5", heading5);
            query.setParameter("url", url);
            query.executeUpdate();
            session.getTransaction().commit();
            //session.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void updateHeadingelements(String url, String h1elements, String h2elements, String h3elements, String h4elements, String h5elements) {
        Transaction tx = null;

        try {
            String s = "update headingelements set h1elements=:h1elements,h2elements=:h2elements,h3elements=:h3elements,h4elements=:h4elements,h5elements=:h5elements where url=:url";
            session.getTransaction().begin();
//            System.out.println("----------------heading1" + h1elements);
//            System.out.println("----------------heading2" + h2elements);
//            System.out.println("----------------heading3" + h3elements);
//            System.out.println("----------------heading4" + h4elements);
//            System.out.println("----------------heading5" + h5elements);
            Query query = session.createSQLQuery(s);
            query.setParameter("h1elements", h1elements);
            query.setParameter("h2elements", h2elements);
            query.setParameter("h3elements", h3elements);
            query.setParameter("h4elements", h4elements);
            query.setParameter("h5elements", h5elements);
            query.setParameter("url", url);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }

    }

    @Override
    public void updateImage(String url, String src) {
        Transaction tx = null;
        try {
            String s = "update image set src=:src where url=:url";

            session.getTransaction().begin();
            Query query = session.createSQLQuery(s);
            query.setParameter("url", url);
            query.setParameter("src", src);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public void updatePagelinks(String url, String links, String title, String type) {
        Transaction tx = null;

//        links="hjahdjad";
//        title="gdhasdjk";
//        type="bjdhjd";
        try {
            //String s ="update pagelinks set links=:links,title=:title,type:=type where url=:url";
            String s = "update pagelinks set links=:links,title=:title,type=:type where url=:url";
//            System.out.println("===========Links=============="+links);
//            System.out.println("===========title=============="+title);
//            System.out.println("===========type=============="+type);
            session.getTransaction().begin();
            Query query = session.createSQLQuery(s);
            query.setParameter("url", url);
            query.setParameter("links", links);
            query.setParameter("title", title);
            query.setParameter("type", type);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRelatedwebsite(String url, String relatedLinks) {
        Transaction tx = null;
        try {
            String s = "update relatedwebsite set relatedLinks=:relatedLinks where url=:url";

            session.getTransaction().begin();
            Query query = session.createSQLQuery(s);
            query.setParameter("url", url);
            query.setParameter("relatedLinks", relatedLinks);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public void updateTechnology(String url, String techUsed, String analytics) {
        Transaction tx = null;
        try {
            String s = "update technology set techUsed=:techUsed, analytics=:analytics where url=:url";

            session.getTransaction().begin();
            Query query = session.createSQLQuery(s);
            query.setParameter("url", url);
            query.setParameter("techUsed", techUsed);
            query.setParameter("analytics", analytics);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public void upadteVisitorarray(String url, String country, String percent, String rank) {
        Transaction tx = null;
        try {
            String s = "update visitorarray set country=:country, percent=:percent, rank=:rank where url=:url";

            session.getTransaction().begin();
            Query query = session.createSQLQuery(s);
            query.setParameter("url", url);
            query.setParameter("country", country);
            query.setParameter("percent", percent);
            query.setParameter("rank", rank);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }

    }

    @Override
    public void updateXmldata(String url, String xmlfiles) {
        Transaction tx = null;
        try {
            String s = "update xmldata set xmlfiles=:xmlfiles where url=:url";

            session.getTransaction().begin();
            Query query = session.createSQLQuery(s);
            query.setParameter("url", url);
            query.setParameter("xmlfiles", xmlfiles);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }
}
