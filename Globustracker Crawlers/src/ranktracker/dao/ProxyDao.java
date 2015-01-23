package ranktracker.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import ranktracker.entity.ProxyData;

/**
 * DAO layer class to update proxy results to database.
 *
 * @author Kalpana Nagle <kalpana@globussoft.com>
 */
@Repository("objProxyDao")
public class ProxyDao extends CustomHibernateDaoSupport implements Runnable {

    static Logger l = Logger.getLogger(ProxyDao.class.getName());
    /**
     * lstProxyData The list of 16 working proxies from database updated every
     * 45 seconds
     */
    public static final List<ProxyData> lstProxyData = new LinkedList();
    /**
     * objProxyData The active proxy data object updated when earlier proxy gets
     * blocked
     */
    public static ProxyData objProxyData = null;

    /**
     * This method updates the current proxy status in database as blocked and
     * sets a new value to objProxyData from a value in database.
     */
    public void changeProxy(String google) {
        try {

            getHibernateTemplate().delete(ProxyDao.objProxyData);
//            if (google.equals("google")) {
//                ProxyDao.objProxyData.setGoogleBlocked(1);
//            } else {
//                ProxyDao.objProxyData.setBlocked(1);
//            }
//            getHibernateTemplate().update(ProxyDao.objProxyData);

        } catch (Exception e) {
        }
        HibernateTemplate ht = getHibernateTemplate();
        ht.setMaxResults(1);
        List<ProxyData> lstDBProxy = ht.find("from ProxyData where dateAdded >= ? and blocked=0"
                + " order by proxyID desc", new Object[]{new Date()});

        if (lstDBProxy.isEmpty()) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            Date yesDate = cal.getTime();
//            lstDBProxy = ht.find("from ProxyData where dateAdded >= ? and blocked=0"
//                    + " order by proxyID asc", new Object[]{yesDate});

            lstDBProxy = ht.find("from ProxyData where blocked=0"
                    + " order by proxyID desc");
        }
        ProxyDao.objProxyData = lstDBProxy.get(0);
    }

    /**
     * This method assigns initial value to objProxyData from a value in
     * database.
     */
    @Override
    public void run() {

        HibernateTemplate ht = getHibernateTemplate();
        ht.setMaxResults(1);
        List<ProxyData> lstDBProxy = ht.find("from ProxyData where dateAdded >= ? and blocked=0"
                + " order by proxyID desc", new Object[]{new Date()});
        if (lstDBProxy.isEmpty()) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            Date yesDate = cal.getTime();
            lstDBProxy = ht.find("from ProxyData where dateAdded >= ? and blocked=0"
                    + " order by proxyID desc", new Object[]{yesDate});
        }
        ProxyDao.objProxyData = lstDBProxy.get(0);
        /*
         List<ProxyData> lstDBProxy = null;
         HibernateTemplate ht = getHibernateTemplate();
         while (true) {
         try {
         if (!lstProxyData.isEmpty()) {
         ProxyData objBlockProxy = lstProxyData.get(0);
         objBlockProxy.setBlocked(1);
         getHibernateTemplate().update(objBlockProxy);
         lstProxyData.remove(0);
         ht.setMaxResults(1);
         lstDBProxy = ht.find("from ProxyData where blocked = 0 order by proxyID desc");
         lstProxyData.add(lstDBProxy.get(0));
         } else {

         ht.setMaxResults(16);
         lstDBProxy = ht.find("from ProxyData where blocked = 0 order by proxyID desc");
         Collections.reverse(lstDBProxy);
         for (int i = 0; i < lstDBProxy.size(); i++) {
         lstProxyData.add(lstDBProxy.get(i));
         }
         }
         Thread.currentThread().sleep(45 * 1000);
         } catch (Exception ex) {
         java.util.logging.Logger.getLogger(ProxyDao.class.getName()).log(Level.SEVERE, null, ex);
         //ex.printStackTrace();
         }
         }
         * */
    }

    /**
     * This method increments usecount value of a ProxyData object in database
     *
     * @param proxyData The object to update the usecount for
     */
    public void updateUseCount(ProxyData proxyData) {
        try {
            proxyData.setUseCount(proxyData.getUseCount() + 1);
            getHibernateTemplate().update(proxyData);
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage());
        }
    }

    /**
     * This method reads database and returns a list of proxy objects added on
     * current date
     *
     * @return List<ProxyData> The List object containing proxies
     */
    public List<ProxyData> getProxies() {

        List<ProxyData> lstDBProxy = Collections.EMPTY_LIST;
        lstDBProxy = getHibernateTemplate().find("from ProxyData where dateAdded >= ? and blocked = 0"
                + " order by proxyID desc ", new Object[]{new Date()});
        return lstDBProxy;
    }

    /**
     * This method updates blocked status of a ProxyData object in database as
     * blocked
     *
     * @param proxyData The object to update the blocked value for
     */
    public void isBlocked(ProxyData proxyData) {
        try {
            proxyData.setBlocked(1);
            getHibernateTemplate().update(proxyData);
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage());
        }
    }

    /**
     * This method updates blocked status of a ProxyData object in database as
     * active
     *
     * @param proxyData The object to update the blocked value for
     */
    public void isActive(ProxyData proxyData) {
        try {
            proxyData.setBlocked(0);
            getHibernateTemplate().update(proxyData);
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage());
        }
    }

    /**
     * This method inserts a list of proxy objects to database
     *
     * @param List<ProxyData> The List object containing proxies
     */
    public synchronized void insertProxy(List<ProxyData> lstProxyData) {
        try {
            for (ProxyData objProxyData : lstProxyData) {
                getHibernateTemplate().save(objProxyData);
            }
        } catch (Exception e) {
            l.error(e + "Exception comes in proxy insertion");
        }
    }

    public List<ProxyData> getProxyList() {

        List<ProxyData> proxylist = new ArrayList<>();

        try {
            //System.out.println("baba");
            List plist = getHibernateTemplate().find("FROM ProxyData");
            Iterator itr = plist.iterator();
            while (itr.hasNext()) {
                ProxyData c = (ProxyData) itr.next();

                proxylist.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return proxylist;
    }
}
