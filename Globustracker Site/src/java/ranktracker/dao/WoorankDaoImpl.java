package ranktracker.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ranktracker.entity.Commonseo;
import ranktracker.entity.Headingcount;
import ranktracker.entity.Headingelements;
import ranktracker.entity.Image;
import ranktracker.entity.Pagelinks;
import ranktracker.entity.Relatedwebsite;
import ranktracker.entity.Technology;
import ranktracker.entity.Videokeywords;
import ranktracker.entity.Visitorarray;
import ranktracker.entity.Xmldata;

public class WoorankDaoImpl extends HibernateDaoSupport implements WoorankDao {

    public Session session = new AnnotationConfiguration().configure().buildSessionFactory().openSession();

    @Override
    public void insertCommonseo(Commonseo objcommonseo) {

        //getSession().save(objcommonseo);
        session.beginTransaction();
        session.save(objcommonseo);
        session.getTransaction().commit();
     //   session.close();
    }

    @Override
    public void insertHeading(Headingcount objheadingcount) {
        session.beginTransaction();
        session.save(objheadingcount);
        session.getTransaction().commit();
      //  session.close();
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
          //  session.close();

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
         //   session.close();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return objHeadingcount;
    }

    public List<Headingelements> getHeadingelementsDetails(String url) {

        List<Headingelements> result = null;
        try {

            Query queryResult = session.createQuery("from Headingelements where url = :url");
            queryResult.setString("url", url);
            result = queryResult.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
     //   session.close();
        return result;
    }

    public List<Image> getImageDetails(String url) {

        List<Image> result = null;
        try {

            Query queryResult = session.createQuery("from Image where url = :url");
            queryResult.setString("url", url);
            result = queryResult.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
      //  session.close();
        return result;
    }

    public List<Pagelinks> getPagelinksDetails(String url) {

        List<Pagelinks> result = null;
        try {

            Query queryResult = session.createQuery("from Pagelinks where url = :url");
            queryResult.setString("url", url);
            result = queryResult.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
     //   session.close();
        return result;
    }

    public List<Relatedwebsite> getRelatedwebsiteDetails(String url) {

        List<Relatedwebsite> result = null;
        try {

            Query queryResult = session.createQuery("from Relatedwebsite where url = :url");
            queryResult.setString("url", url);
            result = queryResult.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
       // session.close();
        return result;
    }

    public List<Technology> getTechnologyDetails(String url) {

        List<Technology> result = null;
        try {

            Query queryResult = session.createQuery("from Technology where url = :url");
            queryResult.setString("url", url);
            result = queryResult.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
       // session.close();
        return result;
    }

    @Override
    public List<Visitorarray> getVisitorarrayDetails(String url) {

        List<Visitorarray> result = null;
        try {

            Query queryResult = session.createQuery("from Visitorarray where url = :url");
            queryResult.setString("url", url);
            result = queryResult.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
      //  session.close();
        return result;
    }

    @Override
    public List<Xmldata> getXmldataDetails(String url) {

        List<Xmldata> result = null;
        try {

            Query queryResult = session.createQuery("from Xmldata where url = :url");
            queryResult.setString("url", url);
            result = queryResult.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
      //  session.close();
        return result;
    }

}
