package ranktracker.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * DAO layer parent class to set sessionfactory object
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {

    /**
     * This method sets sessionfactory object to be used by DAO layer classes.
     *
     * @param sessionFactory The sessionfactory created from given datasource
     */
    @Autowired
    public void initDao(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}