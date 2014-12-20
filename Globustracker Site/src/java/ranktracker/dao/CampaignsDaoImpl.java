package ranktracker.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Customers;
import ranktracker.entity.Seokeyworddetails;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Site;
import ranktracker.entity.Users;
import ranktracker.entity.Videokeywords;
import ranktracker.form.EcomtrackerForm;

/**
 * DAO layer class for Campaigns Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class CampaignsDaoImpl extends HibernateDaoSupport implements CampaignsDao {

    static Logger l = Logger.getLogger(CampaignsDaoImpl.class.getName());

    /**
     * The method retrieves campaign name
     *
     * @param campaignID
     * @return campaign name
     */
    @Override
    public String getCampaign(Integer campaignId, Integer customerId) {
        String campaignname = null;
        try {

            //invoking the getSession() method which will return the session object.
            //now invoking the get method to fetch the <objCampaign> object for <campaignId>
            Criteria objCriteria = getSession().createCriteria(Campaigns.class);
            //adding Restrictions for <url>,<keyword> and <linkGoogle>
            objCriteria.add(Restrictions.eq("campaignID", campaignId));
            objCriteria.add(Restrictions.eq("customerID", new Customers(customerId)));
            objCriteria.add(Restrictions.eq("visibility", 1));
            //retrieving the list of keywords object from objCriteria object);
            List<Campaigns> list = new ArrayList<>();
            list.addAll(objCriteria.list());
            if (!list.isEmpty()) {
                Iterator ittr = list.iterator();
                while (ittr.hasNext()) {
                    Campaigns objCampaigns = (Campaigns) ittr.next();
                    campaignname = objCampaigns.getCampaign();
                }
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            //l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
        }

        //now returning the campaign name
        return campaignname;
    }

    /**
     * The method to retrieve campaigns list
     *
     * @param customerId
     * @return list of campaigns
     */
    @Override
    public List<Campaigns> getCampaigns(Integer customerId) {

        //creating the <objCriteria> object for Campaigns class
        //Criteria objCriteria = getSession().createCriteria(Campaigns.class);
        List<Campaigns> objCampaigns = new ArrayList<>();
        String hqlquery = "from Campaigns where customerID = ? and visibility = 1";
        try {

            objCampaigns = getHibernateTemplate().find(hqlquery, new Object[]{new Customers(customerId)});

            //adding the Restrictions in <objCriteria> object for <customerId>,<visibility>
            //Restrictions are where clauses
//            objCriteria.add(Restrictions.eq("customers.customerId", customerId));
//            objCriteria.add(Restrictions.eq("visibility", 1));
            //setting the descending order in <campaignid>
//            objCriteria.addOrder(Order.desc("campaignId"));
//            String query1 = "from Campaigns where customers = ? and visibility = 1";
//            objCampaigns = getHibernateTemplate().find(query1, new Object[]{new Customers(customerId)});
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
        }
        return objCampaigns;
        //return objCampaigns;
    }

    /**
     * The method to retrieve campaigns list
     *
     * @param customerId
     * @return list of campaigns
     */
    @Override
    public List<Campaigns> getSerpCampaigns(Integer customerId) {

        //creating the <objCriteria> object for Campaigns class
        //Criteria objCriteria = getSession().createCriteria(Campaigns.class);
        List<Campaigns> objCampaigns = new ArrayList<>();

        try {
            String hqlquery = "from Campaigns where customerID = ? and visibility = 1 and campaignType = 'serp'";
            //adding the Restrictions in <objCriteria> object for <customerId>,<visibility>
            //Restrictions are where clauses
            objCampaigns = getHibernateTemplate().find(hqlquery, new Object[]{new Customers(customerId)});

//            objCriteria.add(Restrictions.eq("customers.customerId", customerId));
//            objCriteria.add(Restrictions.eq("visibility", 1));
//            objCriteria.add(Restrictions.eq("campaignType", "serp"));
            //setting the descending order in <campaignid>
//            objCriteria.addOrder(Order.desc("campaignId"));
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return objCampaigns;
    }

    /**
     * The method to retrieve campaigns list
     *
     * @param customerId
     * @return list of campaigns
     */
    @Override
    public List<Campaigns> getVideoCampaigns(Integer customerId) {

        //creating the <objCriteria> object for Campaigns class
//        Criteria objCriteria = getSession().createCriteria(Campaigns.class);
        List<Campaigns> objCampaigns = new ArrayList<>();
        try {
            String hqlquery = "from Campaigns where customerID = ? and visibility = 1 and campaignType = 'video'";
            objCampaigns = getHibernateTemplate().find(hqlquery, new Object[]{new Customers(customerId)});
            //adding the Restrictions in <objCriteria> object for <customerId>,<visibility>
            //Restrictions are where clauses
//            objCriteria.add(Restrictions.eq("customers.customerId", customerId));
//            objCriteria.add(Restrictions.eq("visibility", 1));
//            objCriteria.add(Restrictions.eq("campaignType", "video"));

            //setting the descending order in <campaignid>
//            objCriteria.addOrder(Order.desc("campaignId"));
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return objCampaigns;
    }

    /**
     * The method to add new campaign
     *
     * @param siteName
     * @param customerID
     * @return int result
     */
    @Override
    public Integer addCampaign(String campaignName, Integer userID) {
        FNVHash objFNVHash = new FNVHash();

        //invoking the getSession() method which will return the session object.
        //now invoking the get method to fetch the <objUser> object for <userID>
        Users objUser = (Users) getSession().get(Users.class, userID);

        //CHECK FOR REMAINING CAMPAIGN COUNT
        int quota = objUser.getCustomerID().getAllowedCampaignsCount() - (objUser.getCustomerID().getActiveSerpCampaignsCount() + objUser.getCustomerID().getActiveVideoCampaignCount());
        System.out.println("allowedcampaignscount : " + objUser.getCustomerID().getAllowedCampaignsCount());

        //int videokeycount = objUser.getCustomers().getActiveVideoKeywordCount();
        //String query = "from Campaigns where campaign = ?";
        if (quota > 0) {

            //if quota is greater than 0
            //then create the <objCriteria> object for Campaigns class
            Criteria objCriteria = getSession().createCriteria(Campaigns.class);

            //adding the Restrictions in <objCriteria> object for <customerId>,<campaign>
            //Restrictions are where clauses
            objCriteria.add(Restrictions.eq("customerID.customerID", objUser.getCustomerID().getCustomerID()));
            objCriteria.add(Restrictions.eq("campaign", campaignName));

            if (objCriteria.list().isEmpty()) {

                //if objCriteria list is empty
                //then instantiate objCampaign object
                Campaigns objCampaign = new Campaigns();

                //invoking the setter methods for all the instance variable of Campaigns class
                objCampaign.setCustomerID(objUser.getCustomerID());
                objCampaign.setCampaign(campaignName);
                objCampaign.setCampaignType("serp");
                objCampaign.setReportEmailID("");
                objCampaign.setReportFrequency(1);
                objCampaign.setVisibility(1);

                //using the fnvhash value to generate view key
                objCampaign.setViewKey(objFNVHash.fnv1_32((objUser.getLoginID() + campaignName).getBytes()).toString(32));
                Integer campaignId = (Integer) getSession().save(objCampaign);

                //UPDATE NEW ACTIVE CAMPAIGN COUNT
                Customers objCustomers = (Customers) getSession().get(Customers.class, objUser.getCustomerID().getCustomerID());
                int updateActiveCount = objUser.getCustomerID().getActiveSerpCampaignsCount() + 1;
                objCustomers.setActiveSerpCampaignsCount(updateActiveCount);

                //calling the update method to update the objCustomers 
                getSession().update(objCustomers);
                return campaignId;
            } else if (!objCriteria.list().isEmpty()) {
                Iterator itr = objCriteria.list().iterator();
                while (itr.hasNext()) {
                    Campaigns campaigns = (Campaigns) itr.next();
                    if (campaigns.getVisibility() == 1) {
                        return -1;
                    } else if (campaigns.getVisibility() == 0) {
                        Campaigns objCampaign = (Campaigns) getSession().get(Campaigns.class, campaigns.getCampaignID());
                        objCampaign.setVisibility(1);
                        //now updating the <objCampaign> object.
                        getSession().update(objCampaign);
                        Integer campaignId = objCampaign.getCampaignID();
                        //UPDATE NEW ACTIVE CAMPAIGN COUNT
                        Customers objCustomers = (Customers) getSession().get(Customers.class, objUser.getCustomerID().getCustomerID());
                        int updateActiveCount = objUser.getCustomerID().getActiveSerpCampaignsCount() + 1;
                        objCustomers.setActiveSerpCampaignsCount(updateActiveCount);

                        //calling the update method to update the objCustomers 
                        getSession().update(objCustomers);
                        return campaignId;
                    }
                }
            }
        } else {
            return -10;
        }
        return -1;
    }

    /**
     * The method edits/updates given campaign
     *
     * @param siteId
     * @param siteName
     * @param userID
     * @return int result
     */
    @Override
    public int editCampaign(Integer campaignId, String newCampaignName, Integer customerID) {

        //invoking the getSession() method which will return the session object.
        //now invoking the get method to fetch the <objCampaign> object for <campaignId>
        Campaigns objCampaign = (Campaigns) getSession().get(Campaigns.class, campaignId);
        System.out.println("campaignID ===================== " + campaignId);
        //create the <objCriteria> object for Campaigns class
        Criteria objCriteria = getSession().createCriteria(Campaigns.class);

        //invoking the getSession() method which will return the session object.
        //now invoking the get method to fetch the <objUser> object for <userID>
        //Users objUser = (Users) getSession().get(Users.class, userID);
        //adding the Restrictions in <objCriteria> object for <customerId>,<campaign>
        //Restrictions are where clauses
        objCriteria.add(Restrictions.eq("customerId", customerID));
        objCriteria.add(Restrictions.eq("campaign", newCampaignName));

        System.out.println("***************************************");
        if (objCriteria != null) {
            //if list is empty
            try {
                //then rename the campaign name by invoking the setCampaign method with the <newCampaignName>  campaign name 
                objCampaign.setCampaign(newCampaignName);

                //now updating the <objCampaign> object.
                getSession().update(objCampaign);
            } catch (Exception ex) {
                l.error(ex + "  " + ex.getMessage());
            }
            return 1;
        }
        return 0;
    }

    /**
     * The method deletes a campaign
     *
     * @param siteId
     * @param customerID
     */
//    @Override
//    public void deleteCampaign(Integer campaignId, Integer customerID) {
//
//        String sQuery = "delete from campaignkeywords where CampaignId=:campaignId";
//        SQLQuery objQuery = getSession().createSQLQuery(sQuery);
//        int delCount = 0;
//        try {
//            objQuery.setParameter("campaignId", campaignId);
//            delCount = objQuery.executeUpdate();
//            sQuery = "delete from campaigns where CampaignId=:campaignId";
//            objQuery = getSession().createSQLQuery(sQuery);
//            objQuery.setParameter("campaignId", campaignId);
//            objQuery.executeUpdate();
//        } catch (Exception ex) {
//            l.error(ex + "  " + ex.getMessage());
//        }
//        Customers objCustomers = (Customers) getSession().get(Customers.class, customerID);
//        int activeCampaignsCount = objCustomers.getActiveCampaignsCount() - 1;
//        int activeKeywordsCount = objCustomers.getActiveKeywordCount() - delCount;
//        try {
//            objCustomers.setActiveCampaignsCount(activeCampaignsCount);
//            objCustomers.setActiveKeywordCount(activeKeywordsCount);
//            getSession().update(objCustomers);
//        } catch (Exception ex) {
//            l.error(ex + "  " + ex.getMessage());
//        }
//    }
    @Override
    public String deleteCampaign(Integer campaignId, Integer customerID) {
        int delCount = 0;
        Campaigns objcamp = (Campaigns) getSession().get(Campaigns.class, campaignId);
        try {
            Collection objserpkeywords = objcamp.getSerpkeywordsCollection();
            Iterator itr = objserpkeywords.iterator();
            while (itr.hasNext()) {
                Serpkeywords objserpkeys = (Serpkeywords) itr.next();
                if (objserpkeys.getVisibility() == 1) {
                    delCount++;
                    objserpkeys.setVisibility(0);
                    getSession().update(objserpkeys);
                }
            }
            Collection objseokeywords = objcamp.getSeokeyworddetailsCollection();
            Iterator ittr = objseokeywords.iterator();
            while (ittr.hasNext()) {
                Seokeyworddetails objseokeys = (Seokeyworddetails) itr.next();
                if (objseokeys.getVisibility() == 1) {
                    objseokeys.setVisibility(0);
                    getSession().update(objseokeys);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String sQuery = "update campaigns set visibility=0 where CampaignID=:campaignId";
            SQLQuery objQuery = getSession().createSQLQuery(sQuery);
            objQuery.setParameter("campaignId", campaignId);
            objQuery.executeUpdate();
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        Customers objCustomers = (Customers) getSession().get(Customers.class, customerID);
        try {
            objCustomers.setActiveSerpCampaignsCount(objCustomers.getActiveSerpCampaignsCount() - 1);
            objCustomers.setActiveKeywordCount(objCustomers.getActiveKeywordCount() - delCount);
            getSession().update(objCustomers);
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return objcamp.getCampaign();
    }

    /**
     * The method retrieves list of campaigns for given date to send mails
     *
     * @param todayDate
     * @return list of campaigns
     */
    @Override
    public List<Campaigns> getEmailIdsForReport(Date todayDate) {
        Criteria objCriteria = getSession().createCriteria(Campaigns.class, "c");
        objCriteria.add(Restrictions.eq("c.visibility", 1));
        objCriteria.add(Restrictions.isNotNull("c.reportEmailID"));
        objCriteria.add(Restrictions.isNotNull("c.mailSentOn"));
        List<Campaigns> lstCampaigns = new ArrayList<>();
        try {
            List<Campaigns> lst = objCriteria.list();
            Iterator itr = lst.iterator();
            while (itr.hasNext()) {
                Campaigns campaigns = (Campaigns) itr.next();
                if (!"".equals(campaigns.getReportEmailID())) {
                    if (campaigns.getMailSentOn().before(todayDate)) {
                        lstCampaigns.add(campaigns);
                      //  System.out.println(lstCampaigns);
                    }
                }
            }
            Iterator ittr = lstCampaigns.iterator();
            while (ittr.hasNext()) {
                Campaigns ca = (Campaigns) ittr.next();
             //   System.out.println("----------->" + ca.getReportEmailID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstCampaigns;
    }

    /**
     * The method retrieves campaign object
     *
     * @param campaignID
     * @return campaign object
     */
    @Override
    public Campaigns getCampaignObj(Integer campaignID) {
//        Criteria objCriteria = getSession().createCriteria(Campaigns.class);
//        objCriteria.add(Restrictions.eq("campaignId", campaignID));
//        System.out.println("size  "+objCriteria.list().size());
        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignID);
//        System.out.println("objCampaigns = " + objCampaigns);
        return objCampaigns;
    }

    /**
     * the method searches for campaigns based on search key and customer id
     *
     * @param campaign
     * @param customerID
     * @return list of campaigns
     */
    @Override
    public List<Campaigns> searchCampaign(String campaign, Integer customerID) {
        Criteria objCriteria = getSession().createCriteria(Campaigns.class);
        objCriteria.add(Restrictions.like("campaign", "%" + campaign + "%"));
        objCriteria.add(Restrictions.eq("customerID.customerID", customerID));
        objCriteria.add(Restrictions.eq("visibility", 1));
        return objCriteria.list();
    }

    /**
     * The method validates view key and retrieves corresponding campaign object
     *
     * @param viewKey
     * @return campaigns list
     */
    @Override
    public List<Campaigns> getViewKeyData(String viewKey) {
        Criteria objCriteria = getSession().createCriteria(Campaigns.class);
        objCriteria.add(Restrictions.eq("viewKey", viewKey));
        objCriteria.add(Restrictions.eq("visibility", 1));
        return objCriteria.list();
    }

    public Site getSiteData(String host) {
        Site objSite = new Site();
        return objSite;
    }

    @Override
    public List<Serpkeywords> getCustomerRankList(Integer customerID) {

        List<Serpkeywords> keywordobj = new ArrayList<>();
        List lstkeywrd = null;
        try {
            Integer campid = 0;
            List lstcampaign = getHibernateTemplate().find("FROM Campaigns c where c.customerID=? and visibility = 1", new Object[]{new Customers(customerID)});
            Iterator itr = lstcampaign.iterator();
            while (itr.hasNext()) {
                Campaigns c = (Campaigns) itr.next();
                campid = c.getCampaignID();
                lstkeywrd = getHibernateTemplate().find("FROM Serpkeywords where CampaignID=? and visibility = 1", new Object[]{campid});
//                keywordobj.addAll(c.getKeywordses());

                Iterator ittr = lstkeywrd.iterator();
                while (ittr.hasNext()) {
                    Serpkeywords keyobj = (Serpkeywords) ittr.next();
                    keywordobj.add(keyobj);
                }
            }

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return keywordobj;
    }

    @Override
    public List<Videokeywords> getCustomerRankListVideo(Integer customerID) {

        List<Videokeywords> keywordobj = new ArrayList<>();
        List lstkeywrd = null;
        try {
            Integer campid = 0;
            List lstcampaign = getHibernateTemplate().find("FROM Campaigns c where c.customerID=? and visibility = 1", new Object[]{new Customers(customerID)});
            Iterator itr = lstcampaign.iterator();
            while (itr.hasNext()) {
                Campaigns c = (Campaigns) itr.next();
                campid = c.getCampaignID();
//                keywordobj.addAll(c.getKeywordses());
                lstkeywrd = getHibernateTemplate().find("FROM Videokeywords where CampaignId=? and visibility = 1", new Object[]{campid});

                Iterator ittr = lstkeywrd.iterator();
                while (ittr.hasNext()) {
                    Videokeywords keyobj = (Videokeywords) ittr.next();
                    keywordobj.add(keyobj);
                }
            }

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return keywordobj;
    }

    @Override
    public Integer addVideoCampaign(String campaignName, Integer userID) {
        FNVHash objFNVHash = new FNVHash();

        //invoking the getSession() method which will return the session object.
        //now invoking the get method to fetch the <objUser> object for <userID>
        Users objUser = (Users) getSession().get(Users.class, userID);

        //CHECK FOR REMAINING CAMPAIGN COUNT
        int quota = objUser.getCustomerID().getAllowedCampaignsCount() - (objUser.getCustomerID().getActiveVideoCampaignCount() + objUser.getCustomerID().getActiveSerpCampaignsCount());
        //int serpkeycount = objUser.getCustomers().getActiveKeywordCount();

        if (quota > 0) {

            //if quota is greater than 0
            //then create the <objCriteria> object for Campaigns class
            Criteria objCriteria = getSession().createCriteria(Campaigns.class);

            //adding the Restrictions in <objCriteria> object for <customerId>,<campaign>
            //Restrictions are where clauses
            objCriteria.add(Restrictions.eq("customerID.customerID", objUser.getCustomerID().getCustomerID()));
            objCriteria.add(Restrictions.eq("campaign", campaignName));

            if (objCriteria.list().isEmpty()) {

                //if objCriteria list is empty
                //then instantiate objCampaign object
                Campaigns objCampaign = new Campaigns();

                //invoking the setter methods for all the instance variable of Campaigns class
                objCampaign.setCustomerID(objUser.getCustomerID());
                objCampaign.setCampaign(campaignName);
                objCampaign.setReportEmailID("");
                objCampaign.setCampaignType("video");
                objCampaign.setReportFrequency(1);
                objCampaign.setVisibility(1);

                //using the fnvhash value to generate view key
                objCampaign.setViewKey(objFNVHash.fnv1_32((objUser.getLoginID() + campaignName).getBytes()).toString(32));
                Integer campaignId = (Integer) getSession().save(objCampaign);

                //UPDATE NEW ACTIVE CAMPAIGN COUNT
                Customers objCustomers = (Customers) getSession().get(Customers.class, objUser.getCustomerID().getCustomerID());
                int updateActiveCount = objUser.getCustomerID().getActiveVideoCampaignCount() + 1;
                objCustomers.setActiveVideoCampaignCount(updateActiveCount);

                //calling the update method to update the objCustomers 
                getSession().update(objCustomers);
                return campaignId;
            } else if (!objCriteria.list().isEmpty()) {
                Iterator itr = objCriteria.list().iterator();
                while (itr.hasNext()) {
                    Campaigns campaigns = (Campaigns) itr.next();
                    if (campaigns.getVisibility() == 1) {
                        return -1;
                    } else if (campaigns.getVisibility() == 0) {
                        Campaigns objCampaign = (Campaigns) getSession().get(Campaigns.class, campaigns.getCampaignID());
                        objCampaign.setVisibility(1);
                        //now updating the <objCampaign> object.
                        getSession().update(objCampaign);

                        //UPDATE NEW ACTIVE CAMPAIGN COUNT
                        Customers objCustomers = (Customers) getSession().get(Customers.class, objUser.getCustomerID().getCustomerID());
                        int updateActiveCount = objUser.getCustomerID().getActiveVideoCampaignCount() + 1;
                        objCustomers.setActiveVideoCampaignCount(updateActiveCount);

                        //calling the update method to update the objCustomers 
                        getSession().update(objCustomers);

                        Integer campaignId = objCampaign.getCampaignID();
                        return campaignId;
                    }
                }
            }
        } else {
            return -10;
        }
        return -1;
    }

    @Override
    public int refreshCampaign(Integer campaignId, String CampaignName, Integer customerID) {

        //invoking the getSession() method which will return the session object.
        //now invoking the get method to fetch the <objCampaign> object for <campaignId>
        Campaigns objCampaign = (Campaigns) getSession().get(Campaigns.class, campaignId);
        System.out.println("campaignID ===================== " + campaignId);
        //create the <objCriteria> object for Campaigns class
        Criteria objCriteria = getSession().createCriteria(Campaigns.class);

        //invoking the getSession() method which will return the session object.
        //adding the Restrictions in <objCriteria> object for <customerId>,<campaign>
        //Restrictions are where clauses
        objCriteria.add(Restrictions.eq("customerId", customerID));
        objCriteria.add(Restrictions.eq("campaign", CampaignName));

        System.out.println("***************************************");
        //if list is empty
        Date date = new Date();
        Date pastrefresh = objCampaign.getRankRefresher();
        if (pastrefresh == null) {

            //then set current date for the campaign name by invoking the setRankRefresher method with the current date
            objCampaign.setRankRefresher(date);
            objCampaign.setRankRefresherStatus(1);
            //now updating the <objCampaign> object.
            getSession().update(objCampaign);
            return 1;
        } else {
            String pastrefreshDate = pastrefresh.toString();

            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String currentdate = dateformat.format(date);

            if (pastrefreshDate.equals(currentdate)) {
                return 0;
            } else {
                //then set current date for the campaign name by invoking the setRankRefresher method with the current date
                objCampaign.setRankRefresher(date);
                objCampaign.setRankRefresherStatus(1);
                //now updating the <objCampaign> object.
                getSession().update(objCampaign);
                return 1;
            }
        }
    }

    @Override
    public String deleteVideoCampaign(Integer campaignId, Integer customerID) {
        int delCount = 0;
        Campaigns objcamp = (Campaigns) getSession().get(Campaigns.class, campaignId);
        try {
            Collection objvideokeywordsset = objcamp.getVideokeywordsCollection();
            Iterator itr = objvideokeywordsset.iterator();
            while (itr.hasNext()) {
                Videokeywords objvideokeys = (Videokeywords) itr.next();
                if (objvideokeys.getVisibility() == 1) {
                    delCount++;
                    objvideokeys.setVisibility(Short.parseShort("0"));
                    getSession().update(objvideokeys);
                }
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException e) {
            e.printStackTrace();
        }

        try {
            String sQuery = "update campaigns set visibility=0 where CampaignId=:campaignId";
            SQLQuery objQuery = getSession().createSQLQuery(sQuery);
            objQuery.setParameter("campaignId", campaignId);
            objQuery.executeUpdate();
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        Customers objCustomers = (Customers) getSession().get(Customers.class, customerID);
        try {
            objCustomers.setActiveVideoCampaignCount(objCustomers.getActiveVideoCampaignCount() - 1);
            objCustomers.setActiveVideoKeywordCount(objCustomers.getActiveVideoKeywordCount() - delCount);
            getSession().update(objCustomers);
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return objcamp.getCampaign();
    }

    /**
     * The method updates pdf options of a campaign
     *
     * @param customerId
     * @param companyName
     * @param companyUrl
     * @param companyLogo
     */
    @Override
    public void updatePdfOptions(Integer campaignId, String companyName, String companyUrllink, String companyLogoLink) {
        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignId);
        try {

            //invoking the setters method of Customer object for <companyUrl>,<companyLogo>,<companyDesc>
            objCampaigns.setCompanyName(companyName);
            objCampaigns.setCompanyURLLink(companyUrllink);
            objCampaigns.setCompanyLogoLink(companyLogoLink);

            //invoking the getSession() method to update the Customer object
            getSession().update(objCampaigns);
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
        }
    }

    @Override
    public List<Campaigns> getEcomCampaigns(Integer customerId) {
        List<Campaigns> objCampaigns = new ArrayList<>();
        String hqlquery = "from Campaigns where customers = ? and visibility = 1 and campaignID BETWEEN '780' and '787'";
        try {

            objCampaigns = getHibernateTemplate().find(hqlquery, new Object[]{new Customers(customerId)});

        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
        }
        return objCampaigns;
    }

    @Override
    public List<EcomtrackerForm> getEcomComparisons(Collection<Serpkeywords> lstSerpkeywords) {
        List<EcomtrackerForm> lstEcomDetails = new ArrayList<>();
        for (Serpkeywords keyword : lstSerpkeywords) {
            String hqlquery = "from Serpkeywords where keyword = ? and visibility = 1";
            try {
                EcomtrackerForm objEcom = new EcomtrackerForm();
                objEcom.setKeyword(keyword.getKeyword());
                List<Serpkeywords> lstKeywordDetails = getHibernateTemplate().find(hqlquery, keyword.getKeyword());
                for (Serpkeywords ecomKeyword : lstKeywordDetails) {
                    if ("flipkart.com".equals(ecomKeyword.getUrl())) {
                        objEcom.setRankGoogleFlipkart(ecomKeyword.getRankGoogle());
                        objEcom.setRankBingFlipkart(ecomKeyword.getRankBing());
                        objEcom.setRankYahooFlipkart(ecomKeyword.getRankYahoo());
                    } else if ("amazon.in".equals(ecomKeyword.getUrl())) {
                        objEcom.setRankGoogleAmazon(ecomKeyword.getRankGoogle());
                        objEcom.setRankBingAmazon(ecomKeyword.getRankBing());
                        objEcom.setRankYahooAmazon(ecomKeyword.getRankYahoo());
                    } else if ("snapdeal.com".equals(ecomKeyword.getUrl())) {
                        objEcom.setRankGoogleSnapdeal(ecomKeyword.getRankGoogle());
                        objEcom.setRankBingSnapdeal(ecomKeyword.getRankBing());
                        objEcom.setRankYahooSnapdeal(ecomKeyword.getRankYahoo());
                    } else if ("homeshop18.com".equals(ecomKeyword.getUrl())) {
                        objEcom.setRankGoogleHomeshop18(ecomKeyword.getRankGoogle());
                        objEcom.setRankBingHomeshop18(ecomKeyword.getRankBing());
                        objEcom.setRankYahooHomeshop18(ecomKeyword.getRankYahoo());
                    } else if ("myntra.com".equals(ecomKeyword.getUrl())) {
                        objEcom.setRankGoogleMyntra(ecomKeyword.getRankGoogle());
                        objEcom.setRankBingMyntra(ecomKeyword.getRankBing());
                        objEcom.setRankYahooMyntra(ecomKeyword.getRankYahoo());
                    } else if ("ebay.in".equals(ecomKeyword.getUrl())) {
                        objEcom.setRankGoogleEbay(ecomKeyword.getRankGoogle());
                        objEcom.setRankBingEbay(ecomKeyword.getRankBing());
                        objEcom.setRankYahooEbay(ecomKeyword.getRankYahoo());
                    } else if ("tradus.com".equals(ecomKeyword.getUrl())) {
                        objEcom.setRankGoogleTradus(ecomKeyword.getRankGoogle());
                        objEcom.setRankBingTradus(ecomKeyword.getRankBing());
                        objEcom.setRankYahooTradus(ecomKeyword.getRankYahoo());
                    } else if ("shopclues.com".equals(ecomKeyword.getUrl())) {
                        objEcom.setRankGoogleShopclues(ecomKeyword.getRankGoogle());
                        objEcom.setRankBingShopclues(ecomKeyword.getRankBing());
                        objEcom.setRankYahooShopclues(ecomKeyword.getRankYahoo());
                    }
                }
                lstEcomDetails.add(objEcom);
            } catch (Exception ex) {
                l.error(ex + "  " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return lstEcomDetails;
    }
}
