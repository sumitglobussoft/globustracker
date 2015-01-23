package ranktracker.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ranktracker.entity.Customers;
import ranktracker.entity.Displaysettings;
import ranktracker.entity.Reportfrequency;
import ranktracker.entity.Users;

/**
 * DAO layer class for utilities Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class UtilityDataDaoImpl extends HibernateDaoSupport implements UtilityDataDao {

    static Logger l = Logger.getLogger(UtilityDataDaoImpl.class.getName());

    /**
     * The method adds a new user to database
     *
     * @param email
     * @param password
     * @param userType
     * @param customerID
     */
    @Override
    public void addUser(String email, String password, Integer userType, Integer customerID) {

        try {
            //creating the Criteria object for Customers class 
            Criteria objCriteria = getSession().createCriteria(Customers.class);

            //adding the Restrictions  for customerId
            //Restrictions are where clauses
            objCriteria.add(Restrictions.eq("customerID", customerID));

            //retrieving the customer object from Criteria list
            Customers objCustomers = (Customers) objCriteria.list().get(0);

            //instantiating the user object
            Users objUsers = new Users();

            //invoking the setters methods to set <email>,<password>,<userType> and customer object
            objUsers.setLoginID(email);
            objUsers.setPassword(password);
            objUsers.setUserType(userType);
            objUsers.setCustomerID(objCustomers);
            objUsers.setActive(1);
            objUsers.setAddeddate(new Date());

            //invoking getSession() method to save <objUsers> object
            getSession().save(objUsers);

            //UPDATE ACTIVE USER COUNT in customer object
            int updateActiveCount = objCustomers.getActiveUserCount() + 1;
            objCustomers.setActiveUserCount(updateActiveCount);

            //invoking getSession() method to save <objCustomers> object
            getSession().update(objCustomers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @Override
//    public List<Alertsettings> getAlertSettings() {
//        Criteria objCriteria = getSession().createCriteria(Alertsettings.class);
//        return objCriteria.list();
//    }
//
//    @Override
//    public List<Reportfrequency> getReportfrequency() {
//        Criteria objCriteria = getSession().createCriteria(Reportfrequency.class);
//        return objCriteria.list();
//    }
//
//    @Override
//    public List<Timezones> getTimezones() {
//        Criteria objCriteria = getSession().createCriteria(Timezones.class);
//        return objCriteria.list();
//    }

    /**
     * The method checks number of existing users for a customer
     *
     * @param customerID
     * @return int
     */
    @Override
    public int checkAddUserQuota(Integer customerID) {

        //creating the getSession() method to create criteria object for Customers class
        Criteria objCriteria = getSession().createCriteria(Customers.class);

        //adding Restrictions for <customerId>
        //Restrictions are where clause
        objCriteria.add(Restrictions.eq("customerID", customerID));

        //now retrieving the customer object from Criteria list
        Customers objCustomers = (Customers) objCriteria.list().get(0);

        //now calculating the user quota
        int allowed = objCustomers.getAllowedUserCount() - objCustomers.getActiveUserCount();
        return allowed;
    }

    /**
     * The method retrieves reportfrequency data
     *
     * @return List<ReportFrequency>
     */
    @Override
    public List<Reportfrequency> getFrequency() {

        //creating the getSession() method to create criteria object for Reportfrequency class
        return getSession().createQuery("from Reportfrequency").list();
    }

    /**
     * The method retrieves user records for a given customer id
     *
     * @param customerID
     * @param userID
     * @return List
     */
    @Override
    public List getUsers(Integer customerID, Integer userID) {

        //creating the getSession() method to create criteria object for Users class
        Criteria objCriteria = getSession().createCriteria(Users.class);

        //adding Restrictions for <customerId>,<userId>
        //Restrictions are where clause
        objCriteria.add(Restrictions.eq("customerID.customerID", customerID));
        objCriteria.add(Restrictions.ne("userID", userID));

        //returning the list of users
        return objCriteria.list();
    }

    /**
     *
     * @param tabsettings
     * @return
     */
    @Override
    public Integer addSettingsStore(Map tabsettings) {

        List list;
        Displaysettings displaysettings = new Displaysettings();
        int customerId = Integer.parseInt(tabsettings.get("customerID").toString());
        System.out.println("------" + customerId);
        try {
            String query = "FROM Displaysettings WHERE customerId = ?";
            list = getHibernateTemplate().find(query, new Object[]{new Customers(customerId)});
            if (list.isEmpty()) {
                System.out.println("----------------------------------");
                displaysettings.setCustomerId(new Customers(customerId));
                displaysettings.setGoogletab((Integer) tabsettings.get("googletab"));
                displaysettings.setBingtab((Integer) tabsettings.get("bingtab"));
                displaysettings.setYahootab((Integer) tabsettings.get("yahootab"));
                displaysettings.setDaychangetab((Integer) tabsettings.get("daychange"));
                displaysettings.setWeekchangetab((Integer) tabsettings.get("weektab"));
                displaysettings.setMonthchangetab((Integer) tabsettings.get("monthtab"));
                displaysettings.setAlexatab((Integer) tabsettings.get("alexatab"));
                displaysettings.setBacklinkstab((Integer) tabsettings.get("backlinktab"));
                displaysettings.setMonthlysearchstab((Integer) tabsettings.get("monthlysearch"));
                displaysettings.setSerpcampaigntab((Integer) tabsettings.get("serpcampaigntab"));
                displaysettings.setVideocampaigntab((Integer) tabsettings.get("videocampaigntab"));
                getHibernateTemplate().save(displaysettings);
                return 1;
            } else {
                Integer displaysettingsid = null;
                Iterator itr = list.iterator();
                while (itr.hasNext()) {
                    Displaysettings dispset = (Displaysettings) itr.next();
                    displaysettingsid = dispset.getDisplaysettingsID();
                }
                Displaysettings dispsettings = (Displaysettings) getSession().get(Displaysettings.class, displaysettingsid);
                dispsettings.setGoogletab((Integer) tabsettings.get("googletab"));
                dispsettings.setBingtab((Integer) tabsettings.get("bingtab"));
                dispsettings.setYahootab((Integer) tabsettings.get("yahootab"));
                dispsettings.setDaychangetab((Integer) tabsettings.get("daychange"));
                dispsettings.setWeekchangetab((Integer) tabsettings.get("weektab"));
                dispsettings.setMonthchangetab((Integer) tabsettings.get("monthtab"));
                dispsettings.setAlexatab((Integer) tabsettings.get("alexatab"));
                dispsettings.setBacklinkstab((Integer) tabsettings.get("backlinktab"));
                dispsettings.setMonthlysearchstab((Integer) tabsettings.get("monthlysearch"));
                dispsettings.setSerpcampaigntab((Integer) tabsettings.get("serpcampaigntab"));
                dispsettings.setVideocampaigntab((Integer) tabsettings.get("videocampaigntab"));
                getSession().update(dispsettings);
                return 1;
            }
        } catch (Exception e) {
            System.out.println("-----------------Exception-------------------");
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public List<Displaysettings> showSettingUser(Integer customerID) {

        String query = "FROM Displaysettings WHERE customerId = ?";
        List list = getHibernateTemplate().find(query, new Object[]{new Customers(customerID)});
        return list;
    }

    @Override
    public Integer getUserType(Integer customerID, Integer userID) {
        Integer userType = 0;
        try {
            List list = new ArrayList<>();
            String query = "FROM Users WHERE userID = ?";
            list = getHibernateTemplate().find(query, new Object[]{userID});
            if (!list.isEmpty()) {
                Iterator ittr = list.iterator();
                while (ittr.hasNext()) {
                    Users objUsers = (Users) ittr.next();
                    userType = objUsers.getUserType();
                }
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            //l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
        }

        //now returning the campaign name
        return userType;
    }

    @Override
    public Integer updateUserInfo(Integer userID, String loginID, String password) {
        Users objUsers = (Users) getSession().get(Users.class, userID);
        try {
            String hql = "from Users";
            List results = getHibernateTemplate().find(hql);
            //   list = getHibernateTemplate().find(query, new Object[]{Users.class});
            if (!results.isEmpty()) {
                Iterator ittr = results.iterator();
                while (ittr.hasNext()) {
                    Users userObj = (Users) ittr.next();
                    if ((userObj.getLoginID().equalsIgnoreCase(loginID)) && !(userObj.getUserID().equals(userID))) {
                        return 0;
                    }
                }
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
        }
        //invoking the setters method of Users object for <loginID>,<password>
        objUsers.setLoginID(loginID);
        objUsers.setPassword(password);

        //invoking the getSession() method to update the Customer object
        getSession().update(objUsers);
        return 1;
    }

    @Override
    public void deleteUserAccount(Integer userID, Integer customerID) {

        try {

            //creating the Criteria object for Customers class 
            Criteria objCriteria = getSession().createCriteria(Customers.class);

            //adding the Restrictions  for customerId
            //Restrictions are where clauses
            objCriteria.add(Restrictions.eq("customerID", customerID));

            //retrieving the customer object from Criteria list
            Customers objCustomers = (Customers) objCriteria.list().get(0);

            String hql = "delete from Users where userID=" + userID;
            //creating the query object for <hqlQuery>
            Query objQuery = getSession().createQuery(hql);
            objQuery.executeUpdate();

            //UPDATE ACTIVE USER COUNT in customer object
            int updateActiveCount = objCustomers.getActiveUserCount() - 1;
            objCustomers.setActiveUserCount(updateActiveCount);

            //invoking getSession() method to save <objCustomers> object
            getSession().update(objCustomers);

        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            ex.printStackTrace();
        }
    }
}
