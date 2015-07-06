package ranktracker.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ranktracker.entity.Alertsdata;
import ranktracker.entity.Campaigns;
import ranktracker.entity.Commonseo;
import ranktracker.entity.Customers;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Monitor;
import ranktracker.entity.Serpstrackhistory;
import ranktracker.entity.Socialtrackhistory;
import ranktracker.entity.Trackhistory;
import ranktracker.entity.Users;
import ranktracker.entity.Videokeywords;
import ranktracker.entity.Videotrackhistory;
import ranktracker.entity.Seokeyworddetails;

/**
 * DAO layer class to update crawl results to database.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
@Repository("objKeywordDao")
public class KeywordsDao extends CustomHibernateDaoSupport {

    static Logger l = Logger.getLogger(KeywordsDao.class.getName());

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Serpkeywords> getCustomerKeywords(Integer customerid) {
        System.out.println("customerid = " + customerid);
        List<Serpkeywords> keywordobj = new ArrayList<>();
        List lstkeywrd;
        try {
            Integer campid = 0;
            List lstcampaign = getHibernateTemplate().find("FROM Campaigns where customerID=? and visibility = 1", new Object[]{new Customers(customerid)});
            Iterator itr = lstcampaign.iterator();
            while (itr.hasNext()) {
                Campaigns c = (Campaigns) itr.next();
                campid = c.getCampaignID();
                lstkeywrd = getHibernateTemplate().find("FROM Serpkeywords where CampaignID=? and visibility = 1", new Object[]{campid});
                Iterator ittr = lstkeywrd.iterator();
                while (ittr.hasNext()) {
                    Serpkeywords keyobj = (Serpkeywords) ittr.next();
                    System.out.println("ky = " + keyobj.getKeyword());
                    keywordobj.add(keyobj);
                }
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return keywordobj;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Serpkeywords> getCustomerKeywordsForAll(Integer customerid) {
        System.out.println("customerid = " + customerid);
        List<Serpkeywords> keywordobj = new ArrayList<>();
        List lstkeywrd;
        try {
            Integer campid = 0;
            List lstcampaign = getHibernateTemplate().find("FROM Campaigns where customerID=? and visibility = 1", new Object[]{new Customers(customerid)});
            Iterator itr = lstcampaign.iterator();
            while (itr.hasNext()) {
                Campaigns c = (Campaigns) itr.next();
                campid = c.getCampaignID();
                lstkeywrd = getHibernateTemplate().find("FROM Serpkeywords where CampaignID=? and visibility = 1 group by CampaignID,Url,Keyword", new Object[]{campid});
                Iterator ittr = lstkeywrd.iterator();
                while (ittr.hasNext()) {
                    Serpkeywords keyobj = (Serpkeywords) ittr.next();
                    System.out.println("ky = " + keyobj.getKeyword());
                    keywordobj.add(keyobj);
                }
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return keywordobj;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Serpkeywords> getCampaignKeywords(Integer campaignid) {
        List<Serpkeywords> keywordobj = new ArrayList<>();
        List lstkeywrd;
        try {
            lstkeywrd = getHibernateTemplate().find("FROM Serpkeywords where CampaignID=? and visibility = 1", new Object[]{campaignid});
            Iterator ittr = lstkeywrd.iterator();
            while (ittr.hasNext()) {
                Serpkeywords keyobj = (Serpkeywords) ittr.next();
                System.out.println("ky = " + keyobj.getKeyword());
                keywordobj.add(keyobj);
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return keywordobj;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Serpkeywords> getCampaignKeywordsForAll(Integer campaignid) {
        List<Serpkeywords> keywordobj = new ArrayList<>();
        List lstkeywrd;
        try {
            lstkeywrd = getHibernateTemplate().find("FROM Serpkeywords where CampaignID=? and visibility = 1 group by Url,Keyword", new Object[]{campaignid});
            Iterator ittr = lstkeywrd.iterator();
            while (ittr.hasNext()) {
                Serpkeywords keyobj = (Serpkeywords) ittr.next();
                System.out.println("ky = " + keyobj.getKeyword());
                keywordobj.add(keyobj);
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return keywordobj;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Videokeywords> getVideoKeywords(Integer campaignid) {
        List<Videokeywords> keywordobj = new ArrayList<>();
        List lstkeywrd;
        try {
            lstkeywrd = getHibernateTemplate().find("FROM Videokeywords where CampaignID = ? and visibility = 1", new Object[]{campaignid});
            Iterator ittr = lstkeywrd.iterator();
            while (ittr.hasNext()) {
                Videokeywords keyobj = (Videokeywords) ittr.next();
                System.out.println("ky = " + keyobj.getVideoKeyword());
                keywordobj.add(keyobj);
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return keywordobj;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Videokeywords> getCustomerVideoKeywords(Integer customerid) {
        List<Videokeywords> lstvideokeywords = new ArrayList<>();
        String query1 = "from Campaigns where customerID = ? and visibility = 1";
        List<Campaigns> campaig = getHibernateTemplate().find(query1, new Object[]{new Customers(customerid)});
        for (Campaigns camps : campaig) {
            Integer campid = camps.getCampaignID();
            String query = "from Videokeywords where campaignID = ? and visibility = 1";
            lstvideokeywords.addAll(getHibernateTemplate().find(query, new Object[]{new Campaigns(campid)}));
        }
        return lstvideokeywords;
    }
    
     @Transactional(propagation = Propagation.REQUIRED)
     public List<Commonseo> getAllCommonseoUrls(){
         List<Commonseo> lstCommonseo = getHibernateTemplate().find("from Commonseo");
         return lstCommonseo;
    }
     
    /*
     * @method getTrackIdRange() : read the start track id and end track id from trackhistory table
     */

    public Integer[] getTrackIdRange(List<Serpkeywords> lstKeywords) {
        int startTrackId = 0;
        int endTrackId = 0;
        try {
            List sTrackId = getHibernateTemplate().find("select t.trackID from Trackhistory t where t.trackDate>=? and t.keywordID=?", new Object[]{new Date(), lstKeywords.get(0).getKeywordID()});
            startTrackId = (Integer) sTrackId.get(0);

            List eTrackId = getHibernateTemplate().find("select t.trackID from Trackhistory t where t.trackDate>=? and t.keywordID=?", new Object[]{new Date(), lstKeywords.get(lstKeywords.size() - 1).getKeywordID()});
            endTrackId = (Integer) eTrackId.get(0);
        } catch (DataAccessException e) {
            l.error(e + " Exception comes in UpdateKeywords() Method");
        }
        return new Integer[]{startTrackId, endTrackId};
    }

    //////////////////////////////////////////////////////////////////////////////added by test user
    /**
     * This method creates rows in trackhistory table.
     *
     * @param lstKeywords The list used to get information for new rows creation
     * in trackhistory
     * @return Integer[] containing the created start and end trackid
     */
    public Integer[] createRows(List<Serpkeywords> lstKeywords) {
        Integer keywordId = 0;
        Trackhistory objTrackhistory = null;
        boolean s = false;
        Integer trackid = 0;
        Integer startTrackId = 0;
        Integer endTrackId = 0;
        try {
            for (Serpkeywords objKeywords : lstKeywords) {
                keywordId = objKeywords.getKeywordID();
                objTrackhistory = new Trackhistory();
                objTrackhistory.setKeywordID(keywordId);
                objTrackhistory.setTrackDate(new Date());
                trackid = (Integer) getHibernateTemplate().save(objTrackhistory);
                if (s == false) {
                    startTrackId = trackid;
                }
                s = true;
            }
            endTrackId = trackid;
        } catch (DataAccessException e) {
            l.debug(e + "  " + e.getMessage() + "Exception comes in createRows() of KeywordsDao class");
            e.printStackTrace();
        }
        return new Integer[]{startTrackId, endTrackId};
    }

    /* 
     * method to return minimum keywordId to caller
     */
    @Transactional(readOnly = true)
    public Integer getMinKeywordId() {
        List<Integer> lstSize = getHibernateTemplate().find("select min(keywordID)from Serpkeywords");
        return lstSize.get(0);
    }
    /*
     * method to return maximum KeywordId to caller
     */

    @Transactional(readOnly = true)
    public Integer getMaxKeywordId() {
        List<Integer> lstSize = getHibernateTemplate().find("select max(trackID)from Socialtrackhistory");
        return lstSize.get(0);
    }
    /////////////////////////////////////////////////////////////////////////////

    /**
     * This method reads maximum keywordif from keywords table.
     *
     * @return Integer max keywordid
     */
    @Transactional(readOnly = true)
    public Integer countKeywordRows() {
        List<Integer> lstSize = getHibernateTemplate().find("select keywordID from Serpkeywords where Visibility=1");
        //System.out.println("List size" + lstSize.get(0));

        return lstSize.size();
    }

    /**
     * This method reads rows from keywords table.
     *
     * @param sKeywordID The start keywordid
     * @param eKeywordID The end keywordid
     * @return List<Keywords> list of keyword objects
     */
    @Transactional(readOnly = true)
    public List<Serpkeywords> getKeywords(Integer sKeywordID, Integer eKeywordID) {
        List<Serpkeywords> lstKeywords = getHibernateTemplate().find("from Serpkeywords "
                + "where Visibility=1");

        List<Serpkeywords> keywordList=new ArrayList<>();
        
        for (int i = 1; i <= lstKeywords.size(); i++) {
            if(i>=sKeywordID&&i<=eKeywordID){
                keywordList.add(lstKeywords.get(i-1));
            }
            
        }

        return keywordList;
    }

    /**
     * This method returns specific trackhistory record subject to given params.
     * keywordid
     *
     * @param keywordId
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     * @return List<Trackhistory> list of Trackhistory objects
     */
    @Transactional(readOnly = true)
    public List<Trackhistory> getTrackHistorySingleRecord(Integer keywordId, Integer startTrackId, Integer endTrackId) {
        List<Trackhistory> lstTrackhistory = getHibernateTemplate().find("from Trackhistory t "
                + "where t.trackID >= ? and  t.trackID <= ? and t.keywordID = ?",
                new Object[]{startTrackId, endTrackId, keywordId});

        return lstTrackhistory;
    }

    /**
     * This method returns trackhistory records subject to given params.
     *
     * @param keywordIDS
     * @return List<Trackhistory> list of Trackhistory objects
     */
    @Transactional(readOnly = true)
    public List<Trackhistory> getTrackHistoryMultipleRecords(Integer[] keywordIDS) {
        List<Trackhistory> lstTrackhistory = getHibernateTemplate().findByNamedParam(
                "from Trackhistory t where t.trackDate = :trackDate and t.keywordID in (:keywordIDS)",
                new String[]{"trackDate", "keywordIDS"}, new Object[]{new Date(), keywordIDS});

        return lstTrackhistory;
    }

    /**
     * This method saves google web crawl results to trackhistory table.
     *
     * @param keywordId
     * @param webRankGoogle The exact crawl
     * @param bestMatchRankGoogle The best match rank found in crawl
     * @param bestMatchLinkGoogle The best match link found in crawl
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveGoogleResult(Integer keywordId, Integer webRankGoogle, Integer bestMatchRankGoogle,
            String bestMatchLinkGoogle, Integer startTrackId, Integer endTrackId) {
        System.out.println("saving record  keywordId, startTrackId, endTrackId     " + keywordId + " " + startTrackId + " " + endTrackId);
        List<Trackhistory> lstTrackhistory = getTrackHistorySingleRecord(keywordId, startTrackId, endTrackId);
        Trackhistory objTrackhistory = lstTrackhistory.get(0);
        String hqlQuery = "update Trackhistory set rankGoogle = ?, bestMatchRankGoogle = ?, "
                + "bestMatchLinkGoogle =? where trackId = ?";
        getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{webRankGoogle, bestMatchRankGoogle,
            bestMatchLinkGoogle, objTrackhistory.getTrackID()});
        System.out.println("Saving google data:" + keywordId + "rank" + webRankGoogle + " trackhistory.TracID= " + objTrackhistory.getTrackID());
    }

    /**
     * Below method is overloading of above method. But stores the data in
     * serpstrackhistory table
     *
     * @param keywordId
     * @param webRank
     * @param bestMatchRank
     * @param bestMatchLink
     * @param link
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveResult(Integer keywordId, Integer webRank, Integer bestMatchRank,
            String bestMatchLink, String link, String Keyword, String URL) {

        try {
            Serpstrackhistory serpstrackhst = new Serpstrackhistory();
            serpstrackhst.setKeywordId(keywordId);
            serpstrackhst.setSearchEngine(link);
            serpstrackhst.setRank(webRank);
            serpstrackhst.setBestMatchRank(bestMatchRank);
            serpstrackhst.setBestMatchLink(bestMatchLink);
            serpstrackhst.setTrackDate(new Date());
            getHibernateTemplate().save(serpstrackhst);
            updateAlertsRank(keywordId, link, webRank);

            updateUserKeywords(keywordId, webRank, bestMatchRank, bestMatchLink, link, Keyword, URL);

        } catch (HibernateException e) {
            System.out.println("HibernateException in KeywordsDao " + e);
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveGooglePageRank(Integer keywordId, Integer rankpage) {
        try {
            String pagerankquery = "update Serpkeywords set googlePageRank = ? where keywordID = ?";
            getHibernateTemplate().bulkUpdate(pagerankquery, new Object[]{rankpage, keywordId});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveSiteIndex(Integer keywordId, String result) {

        try {
            Serpkeywords objserps = (Serpkeywords) getSession().get(Serpkeywords.class, keywordId);

            String hqlQuery = "update Seokeyworddetails set siteIndexing = ? where CampaignID = ? ";
            getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{result, objserps.getCampaignID().getCampaignID()});
            System.out.println("********updated*******");

        } catch (DataAccessException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int check(Integer keywordId, String keyword) {
        try {
            List lstseokeyword;
            lstseokeyword = getHibernateTemplate().find("FROM Seokeyworddetails where keywordID = ? ", new Object[]{keywordId});
            if (lstseokeyword.isEmpty()) {
                return 1;
            }
            String date = "" + lstseokeyword.get(9);
            Date date1 = new Date();
            String date2 = date1.toString();
            if (date.contains(date2)) {
                return 0;
            } else {
                return 1;
            }

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveSeoResult(Integer keywordID, String url, String keyword, Campaigns objcampaigns, String search_volume, String cpc, String competitio, String number_of_results) {
        List lstseokeyword;

        try {
            lstseokeyword = getHibernateTemplate().find("FROM Seokeyworddetails where keywordID = ? ", new Object[]{new Serpkeywords(keywordID)});
            if (lstseokeyword.isEmpty()) {
                try {
                    Seokeyworddetails objSeokeyworddetails = new Seokeyworddetails();
                    objSeokeyworddetails.setCampaignID(objcampaigns);
                    objSeokeyworddetails.setKeywordID(new Serpkeywords(keywordID));
                    objSeokeyworddetails.setUrl(url);
                    objSeokeyworddetails.setKeyword(keyword);
                    objSeokeyworddetails.setSearchVolume(Integer.parseInt(search_volume));
                    objSeokeyworddetails.setGoogleCPC(Float.parseFloat(cpc));
                    objSeokeyworddetails.setKeywordCompetition(Float.parseFloat(competitio));
                    objSeokeyworddetails.setNumberofResult(Long.parseLong(number_of_results));
                    objSeokeyworddetails.setGoogleDA(0);
                    objSeokeyworddetails.setGooglePA(0);
                    objSeokeyworddetails.setSiteIndexing("");
                    objSeokeyworddetails.setAddedDate(new Date());
                    objSeokeyworddetails.setRankPage(0);
                    objSeokeyworddetails.setRankAlexa(0);
                    objSeokeyworddetails.setCountBackLinks(0);
                    objSeokeyworddetails.setCountMonthlySearches(0);
                    objSeokeyworddetails.setVisibility(1);
                    getHibernateTemplate().save(objSeokeyworddetails);
                } catch (NumberFormatException | DataAccessException e) {
                    e.printStackTrace();
                }
                System.out.println("**********inserted********");
            } else {
                String hqlQuery = "update Seokeyworddetails set searchVolume = ?,googleCPC=?,keywordCompetition = ?,numberofResult=?,addedDate=? where keywordID = ? ";
                getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{(Integer.parseInt(search_volume)), (Float.parseFloat(cpc)), (Float.parseFloat(competitio)), (Long.parseLong(number_of_results)), (new Date()), new Serpkeywords(keywordID)});
                System.out.println("********updated*******");
            }
        } catch (DataAccessException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param keywordId
     * @param webRank
     * @param bestMatchRank
     * @param bestMatchLink
     * @param link
     * @param Keyword
     * @param URL
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserKeywords(Integer keywordId, Integer webRank, Integer bestMatchRank,
            String bestMatchLink, String link, String Keyword, String URL) {
        String query = null;
        Serpkeywords serpkeys = (Serpkeywords) getSession().get(Serpkeywords.class, keywordId);
        int lastgooglewebrank = serpkeys.getRankGoogle();
        int lastyahoowebrank = serpkeys.getRankYahoo();
        int lastbingwebrank = serpkeys.getRankBing();
        Integer weekrankgoogle, weekrankg = 0, monthrankgoogle, monthrankg = 0, googlezero = 0, googleminus = -1, googleplus = 1;
        Integer weekrankbing, weekrankb = 0, monthrankbing, monthrankb = 0;
        Integer weekrankyahoo, weekranky = 0, monthrankyahoo, monthranky = 0;

        Integer dayChangeGoogle = 0;
        Integer dayChangeYahoo = 0;
        Integer dayChangeBing = 0;
        try {
            switch (link) {
                case "google.com":
                case "google":
//                    query = "update Serpkeywords set rankGoogle = ?,bestMatchRankGoogle = ?,"
//                            + "bestMatchLinkGoogle = ?, rankGoogleDayChange = ?, rankGoogleWeekChange =?,"
//                            + "rankGoogleMonthChange = ?, googleUpdatedDate= ? where keywordID = ?";

                    query = "update Serpkeywords set rankGoogle = ?,bestMatchRankGoogle = ?,"
                            + "bestMatchLinkGoogle = ?, rankGoogleDayChange = ?, rankGoogleWeekChange =?,"
                            + "rankGoogleMonthChange = ?, googleUpdatedDate= ? where keywordID = ?";
                    if (!serpkeys.getGoogleUpdatedDate().equals("-")) {
                        weekrankgoogle = getWeekRank(keywordId, "google.com");
                        weekrankg = (weekrankgoogle == 0) ? 0 : weekrankgoogle - webRank;
                        monthrankgoogle = getMonthRank(keywordId, "google.com");
                        monthrankg = (monthrankgoogle == 0) ? 0 : monthrankgoogle - webRank;
                        dayChangeGoogle = serpkeys.getRankGoogle() - webRank;
                    }
                    if (lastgooglewebrank == 0) {
                    } else if (lastgooglewebrank != 0 && webRank == 0) {
                        webRank = lastgooglewebrank;
                    }
                    getHibernateTemplate().bulkUpdate(query, new Object[]{webRank, bestMatchRank, bestMatchLink, dayChangeGoogle, weekrankg, monthrankg, new Date().toString(), keywordId});
                    break;
                case "yahoo.com":
                case "yahoo":
                    query = "update Serpkeywords set rankYahoo = ?,bestMatchRankYahoo = ?,"
                            + "bestMatchLinkYahoo = ?, rankYahooDayChange = ?, rankYahooWeekChange = ?,"
                            + "rankYahooMonthChange = ?, yahooUpdateDate= ? where Keyword  = ? and Url = ?";

                    if (!serpkeys.getYahooUpdateDate().equals("-")) {
                        weekrankyahoo = getWeekRank(keywordId, "yahoo.com");
                        weekranky = weekrankyahoo == 0 ? 0 : weekrankyahoo - webRank;
                        monthrankyahoo = getMonthRank(keywordId, "yahoo.com");
                        monthranky = monthrankyahoo == 0 ? 0 : monthrankyahoo - webRank;
                        dayChangeYahoo = serpkeys.getRankYahoo() - webRank;
                    }
                    if (lastyahoowebrank == 0) {
                    } else if (lastyahoowebrank != 0 && webRank == 0) {
                        webRank = lastyahoowebrank;
                    }
                    getHibernateTemplate().bulkUpdate(query, new Object[]{webRank, bestMatchRank, bestMatchLink, dayChangeYahoo, weekranky, monthranky, new Date().toString(), Keyword, URL});
                    break;
                case "bing.com":
                case "bing":
                    query = "update Serpkeywords set rankBing = ?,bestMatchRankBing = ?,"
                            + "bestMatchLinkBing = ?, rankBingDayChange = ?, rankBingWeekChange = ?,"
                            + "rankBingMonthChange = ?, bingUpdateDate= ? where Keyword  = ? and Url = ?";
                    if (!serpkeys.getBingUpdateDate().equals("-")) {
                        weekrankbing = getWeekRank(keywordId, "bing.com");
                        weekrankb = weekrankbing == 0 ? 0 : weekrankbing - webRank;
                        monthrankbing = getMonthRank(keywordId, "bing.com");
                        monthrankb = monthrankbing == 0 ? 0 : monthrankbing - webRank;
                        dayChangeBing = serpkeys.getRankBing() - webRank;
                    }
                    if (lastbingwebrank == 0) {
                    } else if (lastbingwebrank != 0 && webRank == 0) {
                        webRank = lastbingwebrank;
                    }
                    getHibernateTemplate().bulkUpdate(query, new Object[]{webRank, bestMatchRank, bestMatchLink, dayChangeBing, weekrankb, monthrankb, new Date().toString(), Keyword, URL});
                    break;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method returns the least rank in a week
     *
     * @param keywordId
     * @param engine keywordId
     * @return
     */
    public Integer getWeekRank(Integer keywordId, String engine) {
        Date date = new Date(System.currentTimeMillis() - 7L * 24 * 3600 * 1000);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dat = formatter.format(date);
        Integer rank = 0, temprank;
        Boolean flag = true;
        String hqlquery = "from Serpstrackhistory where keywordId = ? and searchEngine = ? and trackDate like '" + dat + "%' order by trackDate DESC limit 1";
        try {
            List weekdaybackrecord = getHibernateTemplate().find(hqlquery, new Object[]{keywordId, engine});
            if (!weekdaybackrecord.isEmpty()) {
                Iterator itr = weekdaybackrecord.iterator();
                while (itr.hasNext()) {
                    Serpstrackhistory serphistory = (Serpstrackhistory) itr.next();
                    temprank = serphistory.getRank();
                    if (flag) {
                        rank = serphistory.getRank();
                        flag = false;
                    }
                    if (temprank < rank) {
                        rank = temprank;
                    }
                }
            }
        } catch (DataAccessException e) {
            System.out.println("Exception in week rank");
            e.printStackTrace();
        }
        return rank;
    }

    /**
     * this method returns the least rank in a month
     *
     * @param keywordId
     * @param engine
     * @return
     */
    public Integer getMonthRank(Integer keywordId, String engine) {
        Date date = new Date(System.currentTimeMillis() - 30L * 24 * 3600 * 1000);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dat = formatter.format(date);
        Integer rank = 0, temprank;
        Boolean flag = true;
        String hqlquery = "from Serpstrackhistory where keywordId = ? and searchEngine = ? and trackDate like '" + dat + "%' order by trackDate DESC limit 1";
        try {
            List monthdaybackrecord = getHibernateTemplate().find(hqlquery, new Object[]{keywordId, engine});
            if (!monthdaybackrecord.isEmpty()) {
                Iterator itr = monthdaybackrecord.iterator();
                while (itr.hasNext()) {
                    Serpstrackhistory serphistory = (Serpstrackhistory) itr.next();
                    temprank = serphistory.getRank();
                    if (flag) {
                        rank = serphistory.getRank();
                        flag = false;
                    }
                    if (temprank < rank) {
                        rank = temprank;
                    }
                }
            }
        } catch (DataAccessException e) {
            System.out.println("Exception in month rank");
            e.printStackTrace();
        }
        return rank;
    }

    /**
     * This method saves bing web crawl results to trackhistory table. keywordid
     *
     * @param keywordId
     * @param webRankBing The exact crawl
     * @param bestMatchRankBing The best match rank found in crawl
     * @param bestMatchLinkBing The best match link found in crawl
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveBingResult(Integer keywordId, Integer webRankBing, Integer bestMatchRankBing,
            String bestMatchLinkBing, Integer startTrackId, Integer endTrackId) {
        List<Trackhistory> lstTrackhistory = getTrackHistorySingleRecord(keywordId, startTrackId, endTrackId);
        Trackhistory objTrackhistory = lstTrackhistory.get(0);
        String hqlQuery = "update Trackhistory set rankBing = ?, bestMatchRankBing = ?, "
                + "bestMatchLinkBing =? where trackId = ?";
        getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{webRankBing, bestMatchRankBing,
            bestMatchLinkBing, objTrackhistory.getTrackID()});
        //System.out.println("Saving bing data:" + keywordId + "rank" + webRankBing);
    }

    /**
     * This method saves yahoo web crawl results to trackhistory table.
     *
     * @param keywordId
     * @param webRankYahoo The exact crawl
     * @param bestMatchRankYahoo The best match rank found in crawl
     * @param bestMatchLinkYahoo The best match link found in crawl
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveYahooResult(Integer keywordId, Integer webRankYahoo, Integer bestMatchRankYahoo,
            String bestMatchLinkYahoo, Integer startTrackId, Integer endTrackId) {
        List<Trackhistory> lstTrackhistory = getTrackHistorySingleRecord(keywordId, startTrackId, endTrackId);
        Trackhistory objTrackhistory = lstTrackhistory.get(0);
        String hqlQuery = "update Trackhistory set rankYahoo = ?, bestMatchRankYahoo = ?, "
                + "bestMatchLinkYahoo =? where trackId = ?";
        getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{webRankYahoo, bestMatchRankYahoo,
            bestMatchLinkYahoo, objTrackhistory.getTrackID()});
        //System.out.println("Saving yahoo data:" + keywordId + "rank" + webRankYahoo);
    }

    /**
     * This method saves alexa rank results to trackhistory table.
     *
     * @param keywordId
     * @param url
     * @param webRankAlexa The crawl rank
     * @param keyword
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveAlexaResult(Integer keywordId, String url, String keyword, Campaigns objcampaigns, Integer webRankAlexa) {
        List lstseokeyword;

        try {
            lstseokeyword = getHibernateTemplate().find("FROM Seokeyworddetails where keywordID = ? ", new Object[]{new Serpkeywords(keywordId)});
            if (lstseokeyword.isEmpty()) {
                try {
                    Seokeyworddetails objSeokeyworddetails = new Seokeyworddetails();
                    objSeokeyworddetails.setCampaignID(objcampaigns);
                    objSeokeyworddetails.setKeywordID(new Serpkeywords(keywordId));
                    objSeokeyworddetails.setUrl(url);
                    objSeokeyworddetails.setKeyword(keyword);
                    objSeokeyworddetails.setSearchVolume(0);
                    objSeokeyworddetails.setGoogleCPC(0);
                    objSeokeyworddetails.setKeywordCompetition(0);
                    objSeokeyworddetails.setNumberofResult(0);
                    objSeokeyworddetails.setGoogleDA(0);
                    objSeokeyworddetails.setGooglePA(0);
                    objSeokeyworddetails.setSiteIndexing("");
                    objSeokeyworddetails.setAddedDate(new Date());
                    objSeokeyworddetails.setRankPage(0);
                    objSeokeyworddetails.setRankAlexa(webRankAlexa);
                    objSeokeyworddetails.setCountBackLinks(0);
                    objSeokeyworddetails.setCountMonthlySearches(0);
                    objSeokeyworddetails.setVisibility(1);
                    getHibernateTemplate().save(objSeokeyworddetails);
                } catch (NumberFormatException | DataAccessException e) {
                    e.printStackTrace();
                }
                System.out.println("**********inserted********");
            } else {
                String hqlQuery = "update Seokeyworddetails set rankAlexa = ? where keywordID = ? ";
                getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{webRankAlexa, new Serpkeywords(keywordId)});
                System.out.println("********updated*******");
            }
        } catch (DataAccessException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method saves page rank results to trackhistory table.
     *
     * @param keywordId
     * @param webPageRank The crawl rank
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void savePageRankResult(Integer keywordId, Integer webPageRank, Integer startTrackId, Integer endTrackId) {
        List<Trackhistory> lstTrackhistory = getTrackHistorySingleRecord(keywordId, startTrackId, endTrackId);
        Trackhistory objTrackhistory = lstTrackhistory.get(0);
        String hqlQuery = "update Trackhistory set rankPage = ? where trackId = ?";
        getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{webPageRank, objTrackhistory.getTrackID()});
        //System.out.println("Saving page data:" + keywordId + "rank" + webPageRank);
    }

    /**
     * This method saves backlinks count results to trackhistory table.
     *
     * @param keywordId
     * @param url
     * @param keyword
     * @param countBackLinks The backlinks count
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveBackLinksResult(Integer keywordId, String url, String keyword, Campaigns objcampaigns, Integer countBackLinks, Integer startTrackId, Integer endTrackId) {
        //List<Trackhistory> lstTrackhistory = getTrackHistorySingleRecord(keywordId, startTrackId, endTrackId);
        // Trackhistory objTrackhistory = lstTrackhistory.get(0);
        List lstseokeyword;

        try {
            lstseokeyword = getHibernateTemplate().find("FROM Seokeyworddetails where keywordID = ? ", new Object[]{new Serpkeywords(keywordId)});
            if (lstseokeyword.isEmpty()) {
                try {
                    Seokeyworddetails seodata = new Seokeyworddetails();
                    seodata.setCampaignID(objcampaigns);
                    seodata.setKeywordID(new Serpkeywords(keywordId));
                    seodata.setUrl(url);
                    seodata.setKeyword(keyword);
                    seodata.setSearchVolume(0);
                    seodata.setGoogleCPC((float) 0);
                    seodata.setKeywordCompetition((float) 0);
                    seodata.setNumberofResult((long) 0);
                    seodata.setGooglePA(0);
                    seodata.setGoogleDA(0);
                    seodata.setSiteIndexing("");
                    seodata.setAddedDate(new Date());
                    seodata.setRankPage(0);
                    seodata.setRankAlexa(0);
                    seodata.setCountBackLinks(countBackLinks);
                    seodata.setCountMonthlySearches(0);
                    seodata.setVisibility(1);
                    getHibernateTemplate().save(seodata);
                } catch (DataAccessException e) {
                    e.printStackTrace();
                }
                System.out.println("**********inserted********");
            } else {
                String hqlQuery = "update Seokeyworddetails set countBackLinks = ? where keywordID = ? ";
                getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{countBackLinks, new Serpkeywords(keywordId)});
                System.out.println("********updated*******");
            }
        } catch (DataAccessException | IllegalStateException | HibernateException e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveBackLinksResult1(Integer keywordId, String url, String keyword, Campaigns objcampaigns, Integer countBackLinks, Integer startTrackId, Integer endTrackId, String keywordURL) {
        //List<Trackhistory> lstTrackhistory = getTrackHistorySingleRecord(keywordId, startTrackId, endTrackId);
        // Trackhistory objTrackhistory = lstTrackhistory.get(0);
        List lstseokeyword;

        try {
            lstseokeyword = getHibernateTemplate().find("FROM Seokeyworddetails where Url = ? ", new Object[]{keywordURL});
            if (lstseokeyword.isEmpty()) {
                try {
                    Seokeyworddetails seodata = new Seokeyworddetails();
                    seodata.setCampaignID(objcampaigns);
                    seodata.setKeywordID(new Serpkeywords(keywordId));
                    seodata.setUrl(url);
                    seodata.setKeyword(keyword);
                    seodata.setSearchVolume(0);
                    seodata.setGoogleCPC((float) 0);
                    seodata.setKeywordCompetition((float) 0);
                    seodata.setNumberofResult((long) 0);
                    seodata.setGooglePA(0);
                    seodata.setGoogleDA(0);
                    seodata.setSiteIndexing("");
                    seodata.setAddedDate(new Date());
                    seodata.setRankPage(0);
                    seodata.setRankAlexa(0);
                    seodata.setCountBackLinks(countBackLinks);
                    seodata.setCountMonthlySearches(0);
                    seodata.setVisibility(1);
                    getHibernateTemplate().save(seodata);
                } catch (DataAccessException e) {
                    e.printStackTrace();
                }
                System.out.println("**********inserted********");
            } else {
                String hqlQuery = "update Seokeyworddetails set countBackLinks = ? where Url = ? ";
                getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{countBackLinks, keywordURL});
                System.out.println("********updated*******");
            }
        } catch (DataAccessException | IllegalStateException | HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method saves google monthly searches results to trackhistory table.
     *
     * @param mapSearchesCount The map of google searches results
     * @param keywordIDS[] The array of keyword ids
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveSearchesCountResult(Map<Integer, Integer> mapSearchesCount, Integer[] keywordIDS) {
        List<Trackhistory> lstTrackhistory = getTrackHistoryMultipleRecords(keywordIDS);
        Integer arrIndex = 0;
        try {
            for (Trackhistory objTrackhistory : lstTrackhistory) {
                objTrackhistory.setCountMonthlySearches(mapSearchesCount.get(keywordIDS[arrIndex]));
                arrIndex++;
            }
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage());
            //e.printStackTrace();
        }
        getHibernateTemplate().saveOrUpdateAll(lstTrackhistory);
    }

    /**
     *
     * @param keywordId
     * @param engine
     * @param currentrank
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateAlertsRank(Integer keywordId, String engine, Integer currentrank) {
        try {
            Serpkeywords serpkeys = (Serpkeywords) getSession().get(Serpkeywords.class, keywordId);
            if ((serpkeys.getRankGoogle() != currentrank) && (engine.equalsIgnoreCase("google.com"))) {
                Alertsdata alertsdata = new Alertsdata();
                alertsdata.setResellerId(0);
                alertsdata.setCustomerID(serpkeys.getCampaignID().getCustomerID());
                alertsdata.setCampaign(serpkeys.getCampaignID().getCampaign());
                alertsdata.setUrl(serpkeys.getUrl());
                alertsdata.setKeyword(serpkeys.getKeyword());
                alertsdata.setEngine(engine);
                alertsdata.setPreviousRank(serpkeys.getRankGoogle());
                alertsdata.setCurrentRank(currentrank);
                alertsdata.setTrackDate(new Date());
                getHibernateTemplate().save(alertsdata);
            }
            if ((serpkeys.getRankYahoo() != currentrank) && (engine.equalsIgnoreCase("yahoo.com"))) {
                Alertsdata alertsdata = new Alertsdata();
                alertsdata.setResellerId(0);
                alertsdata.setCustomerID(serpkeys.getCampaignID().getCustomerID());
                alertsdata.setCampaign(serpkeys.getCampaignID().getCampaign());
                alertsdata.setUrl(serpkeys.getUrl());
                alertsdata.setKeyword(serpkeys.getKeyword());
                alertsdata.setEngine(engine);
                alertsdata.setPreviousRank(serpkeys.getRankYahoo());
                alertsdata.setCurrentRank(currentrank);
                alertsdata.setTrackDate(new Date());
                getHibernateTemplate().save(alertsdata);
            }
            if ((serpkeys.getRankBing() != currentrank) && (engine.equalsIgnoreCase("bing.com"))) {
                Alertsdata alertsdata = new Alertsdata();
                alertsdata.setResellerId(0);
                alertsdata.setCustomerID(serpkeys.getCampaignID().getCustomerID());
                alertsdata.setCampaign(serpkeys.getCampaignID().getCampaign());
                alertsdata.setUrl(serpkeys.getUrl());
                alertsdata.setKeyword(serpkeys.getKeyword());
                alertsdata.setEngine(engine);
                alertsdata.setPreviousRank(serpkeys.getRankBing());
                alertsdata.setCurrentRank(currentrank);
                alertsdata.setTrackDate(new Date());
                getHibernateTemplate().save(alertsdata);
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method creates new alerts
     *
     * @param lstKeywords The list of keywords
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateAlerts(List<Serpkeywords> lstKeywords, Integer startTrackId, Integer endTrackId) {

        List<Customers> lstCustomers = getHibernateTemplate().find("from Customers");
        List<Campaigns> lstCampaigns = null;
        for (Customers objCustomer : lstCustomers) {
            lstCampaigns = new ArrayList<>(objCustomer.getCampaignsCollection());
            for (Campaigns objCampaign : lstCampaigns) {
                lstKeywords = new ArrayList<>(objCampaign.getSerpkeywordsCollection());
                Integer keywordID = 0;
                Date previousDate = null;
                Date currentDate = new Date();
                Calendar calendar = Calendar.getInstance();
                List<Trackhistory> lstRecord;
                Integer currRankGoogle = 0;
                Integer prevRankGoogle = 0;
                Integer currRankBing = 0;
                Integer prevRankBing = 0;
                Integer currRankYahoo = 0;
                Integer prevRankYahoo = 0;
                Alertsdata objAlertsdata = null;

                for (Serpkeywords objKeyword : lstKeywords) {
                    keywordID = objKeyword.getKeywordID();

                    calendar.setTime(new Date());
                    calendar.add(Calendar.DAY_OF_YEAR, -1);
                    previousDate = calendar.getTime();
                    try {
                        lstRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordID"
                                + " =? and t.trackDate = ? ", new Object[]{keywordID, currentDate});
                        if (lstRecord.size() > 0) {
                            currRankGoogle = lstRecord.get(0).getRankGoogle();// == null ? 1000 : lstRecord.get(0).getRankGoogle();
                            currRankBing = lstRecord.get(0).getRankBing();// == null ? 1000 : lstRecord.get(0).getRankBing();
                            currRankYahoo = lstRecord.get(0).getRankYahoo();// == null ? 1000 : lstRecord.get(0).getRankYahoo();
                        }
                        lstRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordID"
                                + " =? and t.trackDate = ? ", new Object[]{keywordID, previousDate});
                        //
                        if (lstRecord.size() > 0) {
                            prevRankGoogle = lstRecord.get(0).getRankGoogle();// == null ? 1000 : lstRecord.get(0).getRankGoogle();
                            prevRankBing = lstRecord.get(0).getRankBing();// == null ? 1000 : lstRecord.get(0).getRankBing();
                            prevRankYahoo = lstRecord.get(0).getRankYahoo();// == null ? 1000 : lstRecord.get(0).getRankYahoo();
                        }

                        if (currRankGoogle - prevRankGoogle != 0) {
                            objAlertsdata = new Alertsdata(objCustomer.getCustomerID(), objCampaign.getCampaign(),
                                    objKeyword.getUrl(), objKeyword.getKeyword(), "Google", prevRankGoogle,
                                    currRankGoogle, new Date());
                            saveAlertsData(objAlertsdata);
                        }
                        if (currRankBing - prevRankBing != 0) {
                            objAlertsdata = new Alertsdata(objCustomer.getCustomerID(), objCampaign.getCampaign(),
                                    objKeyword.getUrl(), objKeyword.getKeyword(), "Bing", prevRankBing,
                                    currRankBing, new Date());
                            saveAlertsData(objAlertsdata);
                        }
                        if (currRankYahoo - prevRankYahoo != 0) {
                            objAlertsdata = new Alertsdata(objCustomer.getCustomerID(), objCampaign.getCampaign(),
                                    objKeyword.getUrl(), objKeyword.getKeyword(), "Yahoo", prevRankYahoo,
                                    currRankYahoo, new Date());
                            saveAlertsData(objAlertsdata);
                        }
                    } catch (DataAccessException e) {
                        l.debug(e + "  " + e.getMessage());
                        //e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * This method saves new alerts to alerts table.
     *
     * @param objAlertsdata The Alertsdata object
     */
    @Transactional(propagation = Propagation.REQUIRED)
    private void saveAlertsData(Alertsdata objAlertsdata) {
        getHibernateTemplate().save(objAlertsdata);
    }

    /**
     * This method updates keyword records to Keywords table.
     *
     * @param objKeyword The Keywords object
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateKeyword(Serpkeywords objKeyword) {
        getHibernateTemplate().update(objKeyword);
    }

    /**
     * This method creates google monthly searches data keyword object to be
     * saved to keywords table
     *
     * @param lstKeywords The list of keywords
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateMonthlySearches(List<Serpkeywords> lstKeywords) {

        Integer keywordID = 0;
        Date currentDate = new Date();
        List<Trackhistory> currRecord;
        try {
            for (Serpkeywords objKeyword : lstKeywords) {
                keywordID = objKeyword.getKeywordID();
                currRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordID"
                        + " =? and t.trackDate =?", new Object[]{keywordID, currentDate});
                //objKeyword.setCountMonthlySearches(currRecord.get(0).getCountMonthlySearches());
                updateKeyword(objKeyword);
            }
        } catch (DataAccessException e) {
            l.debug(e + "  " + e.getMessage());
            //e.printStackTrace();
        }
    }

    /**
     * This method adds crawl info to monitor table
     *
     * @param lstKeywords The list of keywords
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void setCrawlInfo(List<Serpkeywords> lstKeywords, Integer startTrackId, Integer endTrackId) {
        Monitor objMonitor = new Monitor();
        objMonitor.setStartKeywordID(lstKeywords.get(0).getKeywordID());
        objMonitor.setEndKeywordID(lstKeywords.get(lstKeywords.size() - 1).getKeywordID());
        objMonitor.setCrawlEndTime(new Date());
        getHibernateTemplate().save(objMonitor);
    }

    /**
     * This method saves Facebook likes and shares count results to trackhistory
     * table.
     *
     * @param keywordId
     * @param result The Integer array containing facebook likes and facebook
     * share count
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveFacebookResult(Integer keywordId, Integer[] result, Integer startTrackId, Integer endTrackId) {
        try {
            List<Trackhistory> lstTrackhistory = getTrackHistorySingleRecord(keywordId, startTrackId, endTrackId);
            Trackhistory objTrackhistory = lstTrackhistory.get(0);
            String hqlQuery = "update Trackhistory set facebookShare = ?, facebookLike = ? where trackID = ?";
            getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{result[0], result[0] + result[1], objTrackhistory.getTrackID()});
            //System.out.println("Saving facebook result:" + keywordId + "rank" + result[1] + "share" + result[0]);
        } catch (DataAccessException e) {
            l.debug(e + "  " + e.getMessage());
            //e.printStackTrace();
        }
    }

    /**
     * keywordId
     *
     * @param urlId
     * @param result
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int saveFacebookResult(Integer urlId, Integer[] result) {
        int returnind = 0;
        try {
            Socialtrackhistory soctrackhrtry = new Socialtrackhistory();
            soctrackhrtry.setSocialSignalUrlID(urlId);
            soctrackhrtry.setFaceBookLike(result[1]);
            soctrackhrtry.setFaceBookShare(result[0]);
            soctrackhrtry.setTrackDate(new Date());
            getHibernateTemplate().save(soctrackhrtry);

//                query2="update Socialtrackhistory set faceBookLike = ?, faceBookShare = ? where keywordId = ?";
//                getHibernateTemplate().bulkUpdate(query2,new Object[]{result[1],result[0],keywordId});
        } catch (DataAccessException e) {
            System.out.println("Exception in saveFacebookResult " + e);
            e.printStackTrace();
        }
        return returnind;
    }

    /**
     * keywordId
     *
     * @param urlId
     * @param result
     */
    public void updateSocialFacebookKeywords(Integer urlId, Integer[] result) {
        try {
            String query = "update Socialsignalurls set facebookLike = ?, facebookShare = ? where SocialSignalUrlID = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result[1], result[0], urlId});
        } catch (DataAccessException e) {
            System.out.println("Exception in updateSocialFacebookKeywords " + e);
        }
    }

    /**
     * This method saves Googleplus likes count to socialtrackhistory table.
     *
     * @param urlId
     * @param result The Integer containing Googleplus likes count
     */
    public void saveGooglePlusResult(Integer urlId, Integer result) {
        try {
            Integer trkid = getMaxSocialKeywordId(urlId);
            String query = "update Socialtrackhistory set googlePlus = ? where trackId = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, trkid});

//                Socialtrackhistory soctrackhrtry=new Socialtrackhistory();
//                soctrackhrtry.setKeywordId(keywordId);
//                soctrackhrtry.setGooglePlus(result);
//                soctrackhrtry.setTrackDate(new Date());
//                getHibernateTemplate().save(soctrackhrtry);
        } catch (DataAccessException e) {
            System.out.println("Exception in saveGooglePlusResult " + e);
            e.printStackTrace();
        }
    }

    @Transactional(readOnly = true)
    public Integer getMaxSocialKeywordId(Integer urlId) {
        List<Integer> lstSize = getHibernateTemplate().find("select max(trackId)from Socialtrackhistory where SocialSignalUrlID =" + urlId);
        return lstSize.get(0);
    }

    /**
     * keywordId
     *
     * @param urlId
     * @param result
     */
    public void updateSocialGoogleplusKeywords(Integer urlId, Integer result) {
        try {
            String query = "update Socialsignalurls set googlePlusLikes = ? where SocialSignalUrlID = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, urlId});
        } catch (DataAccessException e) {
            System.out.println("Exception in updateSocialGoogleplusKeywords " + e);
        }
    }

    /**
     * This method saves LinkedIn shares count to trackhistory table. keywordid
     *
     * @param urlId
     * @param result The Integer containing LinkedIn shares count
     */
    public void saveLinkedInResult(Integer urlId, Integer result) {
        try {
            Integer trkid = getMaxSocialKeywordId(urlId);
            String query = "update Socialtrackhistory set linkedInShare = ? where trackId = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, trkid});

//            Socialtrackhistory soctrackhrtry=new Socialtrackhistory();
//            soctrackhrtry.setKeywordId(keywordId);
//            soctrackhrtry.setLinkedInShare(result);
//            soctrackhrtry.setTrackDate(new Date());
//            getHibernateTemplate().save(soctrackhrtry);             
        } catch (DataAccessException e) {
            System.out.println("Exception in saveLinkedInResult " + e);
            e.printStackTrace();
        }
    }

    /**
     * keywordId
     *
     * @param urlId
     * @param result
     */
    public void updateSocialLinkedInKeywords(Integer urlId, Integer result) {
        try {
            String query = "update Socialsignalurls set linkedInShares = ? where SocialSignalUrlID = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, urlId});
        } catch (DataAccessException e) {
            System.out.println("Exception in updateSocialLinkedInKeywords " + e);
        }
    }

    /**
     * This method saves Pinterest pins count to trackhistory table. keywordid
     *
     * @param urlId
     * @param result The Integer containing Pinterest pins count
     */
    public void savePinterestResult(Integer urlId, Integer result) {
        try {
            Integer trkid = getMaxSocialKeywordId(urlId);
            String query = "update Socialtrackhistory set pinterestPin = ? where trackId = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, trkid});

//            Socialtrackhistory soctrackhrtry=new Socialtrackhistory();
//            soctrackhrtry.setKeywordId(keywordId);
//            soctrackhrtry.setPinterestPin(result);
//            soctrackhrtry.setTrackDate(new Date());
//            getHibernateTemplate().save(soctrackhrtry);
        } catch (DataAccessException e) {
            System.out.println("Exception in savePinterestResult " + e);
            e.printStackTrace();
        }
    }

    /**
     * keywordId
     *
     * @param urlId
     * @param result
     */
    public void updateSocialPinterestKeywords(Integer urlId, Integer result) {
        try {
            String query = "update Socialsignalurls set pinterestPins = ? where SocialSignalUrlID = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, urlId});
        } catch (DataAccessException e) {
            System.out.println("Exception in updateSocialLinkedInKeywords " + e);
        }
    }

    /**
     * This method saves Reddit votes count to trackhistory table. keywordid
     *
     * @param urlId
     * @param result The Integer containing Reddit votes count
     */
    public void saveRedditResult(Integer urlId, Integer result) {
        try {
            Integer trkid = getMaxSocialKeywordId(urlId);
            String query = "update Socialtrackhistory set redittVote = ? where trackId = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, trkid});

//            Socialtrackhistory soctrackhrtry=new Socialtrackhistory();
//            soctrackhrtry.setKeywordId(keywordId);
//            soctrackhrtry.setRedittVote(result);
//            soctrackhrtry.setTrackDate(new Date());
//            getHibernateTemplate().save(soctrackhrtry);
        } catch (DataAccessException e) {
            System.out.println("Exception in saveRedditResult " + e);
            e.printStackTrace();
        }
    }

    /**
     * keywordId
     *
     * @param urlId
     * @param result
     */
    public void updateSocialRedditKeywords(Integer urlId, Integer result) {
        try {
            String query = "update Socialsignalurls set redittVotes = ? where SocialSignalUrlID = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, urlId});
        } catch (DataAccessException e) {
            System.out.println("Exception in updateSocialRedditKeywords " + e);
        }
    }

    /**
     * This method saves Stumbleupon stumbles count to trackhistory table.
     * keywordid
     *
     * @param urlId
     * @param result The Integer containing Stumbleupon stumbles count
     */
    public void saveStumbleResult(Integer urlId, Integer result) {
        try {
            Integer trkid = getMaxSocialKeywordId(urlId);
            String query = "update Socialtrackhistory set stumbleUponStumble = ? where trackId = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, trkid});

//            Socialtrackhistory soctrackhrtry=new Socialtrackhistory();
//            soctrackhrtry.setKeywordId(keywordId);
//            soctrackhrtry.setStumbleUponStumble(result);
//            soctrackhrtry.setTrackDate(new Date());
//            getHibernateTemplate().save(soctrackhrtry);
        } catch (DataAccessException e) {
            System.out.println("Exception in saveStumbleResult " + e);
            e.printStackTrace();
        }
    }

    /**
     * keywordId
     *
     * @param urlId
     * @param result
     */
    public void updateSocialStumbleKeywords(Integer urlId, Integer result) {
        try {
            String query = "update Socialsignalurls set stumbleUponLikes = ? where SocialSignalUrlID = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, urlId});
        } catch (DataAccessException e) {
            System.out.println("Exception in updateSocialRedditKeywords " + e);
        }
    }

    /**
     * This method saves Twitter tweets count to trackhistory table. keywordid
     *
     * @param urlId
     * @param result The Integer containing Twitter tweets count
     */
    public void saveTwitterResult(Integer urlId, Integer result) {
        try {
            Integer trkid = getMaxSocialKeywordId(urlId);
            String query = "update Socialtrackhistory set tweetCount = ? where trackId = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, trkid});

//                Socialtrackhistory soctrackhrtry=new Socialtrackhistory();
//                soctrackhrtry.setKeywordId(keywordId);
//                soctrackhrtry.setTweetCount(result);
//                soctrackhrtry.setTrackDate(new Date());
//                getHibernateTemplate().save(soctrackhrtry);
        } catch (DataAccessException e) {
            System.out.println("Exception in saveTwitterResult " + e);
            e.printStackTrace();
        }
    }

    /**
     * keywordId
     *
     * @param urlId
     * @param result
     */
    public void updateSocialTwitterKeywords(Integer urlId, Integer result) {
        try {
            String query = "update Socialsignalurls set tweetCount = ? where SocialSignalUrlID = ?";
            getHibernateTemplate().bulkUpdate(query, new Object[]{result, urlId});
        } catch (DataAccessException e) {
            System.out.println("Exception in updateSocialRedditKeywords " + e);
        }
    }

    /**
     *
     * @param keywordId
     * @param keyword
     * @param youtubeurl
     * @param youtuberank
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveYoutubeResult(Integer keywordId, String keyword, String youtubeurl,
            Integer youtuberank) {
        try {
            Videotrackhistory videotrackhrtry = new Videotrackhistory();
            videotrackhrtry.setVideoKeywordID(keywordId);
            videotrackhrtry.setVideoKeyword(keyword);
            videotrackhrtry.setVideoEngine("youtube.com");
            videotrackhrtry.setVideoRank(youtuberank);
            videotrackhrtry.setVideoURL(youtubeurl);
            videotrackhrtry.setTrackDate(new Date());
            getHibernateTemplate().save(videotrackhrtry);
            updateVideoKeywords(keywordId, Short.parseShort(youtuberank.toString()), Short.parseShort(youtuberank.toString()), youtubeurl, "youtube");
        } catch (DataAccessException | NumberFormatException e) {
            System.out.println("Exception in saveYoutubeResult " + e);
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int LastView(Integer keywordId) {
        try {
            System.out.println("***************");
            List lstkeyword;
            lstkeyword = getHibernateTemplate().find("FROM Videokeywords where VideokeywordID = ? ", new Object[]{new Videokeywords(keywordId)});
            // Videokeywords objvideokeywords = new Videokeywords();
            if (lstkeyword.isEmpty()) {

                return 1;
            } else {
                Iterator itr = lstkeyword.iterator();
                Videokeywords objvideokeywords = (Videokeywords) itr.next();
                int last_view = objvideokeywords.getYoutubeViewCount();
                return last_view;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveYoutubeStatistics(Integer keywordId, int youtube_view_count, int vimeo_view_count, int metacafe_view_count, int dailymotion_view_count, short daily_view) {
        try {
            System.out.println("youtube_view_count=" + youtube_view_count);
            System.out.println("vimeo_view_count=" + vimeo_view_count);
            System.out.println("metacafe_view_count=" + metacafe_view_count);
            System.out.println("dailymotion_view_count=" + dailymotion_view_count);
            System.out.println("daily_view=" + daily_view);
            System.out.println("(new Date().toString())=" + (new Date().toString()));
            String hqlQuery = "update Videokeywords set YoutubeViewCount = ?,VimeoViewCount=?,MetacafeViewCount = ?,DailymotionViewCount=?,youtubeDailyViewCount=?,ViewStatisticsUpdatedDate=? where videokeywordID = ? ";
            getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{(youtube_view_count), (vimeo_view_count), (metacafe_view_count), (dailymotion_view_count), (daily_view), (new Date().toString()), (keywordId)});
            System.out.println("********updated*******");

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param keywordId
     * @param keyword
     * @param metacafeurl
     * @param metacaferank
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveMetacafeResult(Integer keywordId, String keyword, String metacafeurl,
            Integer metacaferank) {
        try {
            Videotrackhistory videotrackhrtry = new Videotrackhistory();
            videotrackhrtry.setVideoKeywordID(keywordId);
            videotrackhrtry.setVideoKeyword(keyword);
            videotrackhrtry.setVideoRank(metacaferank);
            videotrackhrtry.setVideoEngine("metacafe.com");
            videotrackhrtry.setVideoURL(metacafeurl);
            videotrackhrtry.setTrackDate(new Date());
            getHibernateTemplate().save(videotrackhrtry);
            updateVideoKeywords(keywordId, Short.parseShort(metacaferank.toString()), Short.parseShort(metacaferank.toString()), metacafeurl, "metacafe");
        } catch (DataAccessException | NumberFormatException e) {
            System.out.println("Exception in saveMetacafeResult " + e);
            e.printStackTrace();
        }
    }

    /**
     *
     * @param keywordId
     * @param keyword
     * @param dailymotionurl
     * @param dailymotionrank
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveDailymotionResult(Integer keywordId, String keyword, String dailymotionurl,
            Integer dailymotionrank) {
        try {
            Videotrackhistory videotrackhrtry = new Videotrackhistory();
            videotrackhrtry.setVideoKeywordID(keywordId);
            videotrackhrtry.setVideoKeyword(keyword);
            videotrackhrtry.setVideoRank(dailymotionrank);
            videotrackhrtry.setVideoEngine("dailymotion.com");
            videotrackhrtry.setVideoURL(dailymotionurl);
            videotrackhrtry.setTrackDate(new Date());
            getHibernateTemplate().save(videotrackhrtry);
            updateVideoKeywords(keywordId, Short.parseShort(dailymotionrank.toString()), Short.parseShort(dailymotionrank.toString()), dailymotionurl, "dailymotion");
        } catch (DataAccessException | NumberFormatException e) {
            System.out.println("Exception in saveDailymotionResult " + e);
            e.printStackTrace();
        }
    }

    /**
     *
     * @param keywordId
     * @param keyword
     * @param vimeourl
     * @param vimeorank
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveVimeoResult(Integer keywordId, String keyword, String vimeourl,
            Integer vimeorank) {
        try {
            Videotrackhistory videotrackhrtry = new Videotrackhistory();
            videotrackhrtry.setVideoKeywordID(keywordId);
            videotrackhrtry.setVideoKeyword(keyword);
            videotrackhrtry.setVideoRank(vimeorank);
            videotrackhrtry.setVideoEngine("vimeo.com");
            videotrackhrtry.setVideoURL(vimeourl);
            videotrackhrtry.setTrackDate(new Date());
            getHibernateTemplate().save(videotrackhrtry);
            updateVideoKeywords(keywordId, Short.parseShort(vimeorank.toString()), Short.parseShort(vimeorank.toString()), vimeourl, "vimeo");
        } catch (DataAccessException | NumberFormatException e) {
            System.out.println("Exception in saveVimeoResult " + e);
            e.printStackTrace();
        }
    }

    /**
     *
     * @param keywordId
     * @param webRank
     * @param bestMatchRank
     * @param bestMatchLink
     * @param link
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateVideoKeywords(Integer keywordId, Short webRank, Short bestMatchRank,
            String bestMatchLink, String link) {
        String query = null;
        Videokeywords vidkeys = (Videokeywords) getSession().get(Videokeywords.class, keywordId);
        short lastyoutuberank = vidkeys.getRankYoutube();
        short lastvimeorank = vidkeys.getRankVimeo();
        short lastdailymotionrank = vidkeys.getRankDailyMotion();
        short lastmetacaferank = vidkeys.getRankMetacafe();
        try {
            switch (link) {
                case "youtube.com":
                case "youtube":
                    if (lastyoutuberank == 0 && webRank == 501) {
                        webRank = lastyoutuberank;
                    } else if (lastyoutuberank != 0 && webRank == 501) {
                        webRank = lastyoutuberank;
                    } else if (lastyoutuberank != 0 && webRank == 0) {
                        webRank = lastyoutuberank;
                    } else if (lastyoutuberank == 0) {
                    }
                    query = "update Videokeywords set rankYoutube = ?,YoutubeUpdatedDate=? where videokeywordID = ?";
                    getHibernateTemplate().bulkUpdate(query, new Object[]{webRank, new Date().toString(), keywordId});
                    break;
                case "dailymotion.com":
                case "dailymotion":
                    if (lastdailymotionrank == 0 && webRank == 501) {
                        webRank = lastdailymotionrank;
                    } else if (lastdailymotionrank != 0 && webRank == 501) {
                        webRank = lastdailymotionrank;
                    } else if (lastdailymotionrank != 0 && webRank == 0) {
                        webRank = lastdailymotionrank;
                    } else if (lastdailymotionrank == 0) {
                    }
                    query = "update Videokeywords set rankDailyMotion = ?,DailymotionUpdatedDate=? where videokeywordID = ?";
                    getHibernateTemplate().bulkUpdate(query, new Object[]{webRank, new Date().toString(), keywordId});
                    break;
                case "metacafe.com":
                case "metacafe":
                    if (lastmetacaferank == 0 && webRank == 501) {
                        webRank = lastmetacaferank;
                    } else if (lastmetacaferank != 0 && webRank == 501) {
                        webRank = lastmetacaferank;
                    } else if (lastmetacaferank != 0 && webRank == 0) {
                        webRank = lastmetacaferank;
                    } else if (lastmetacaferank == 0) {

                    }

                    query = "update Videokeywords set RankMetacafe=?,MetaCafeUpdatedDate= ? where videokeywordID = ?";
                    getHibernateTemplate().bulkUpdate(query, new Object[]{webRank, new Date().toString(), keywordId});
                    break;
                case "vimeo.com":
                case "vimeo":
                    if (lastvimeorank == 0 && webRank == 501) {
                        webRank = lastvimeorank;
                    } else if (lastvimeorank != 0 && webRank == 501) {
                        webRank = lastvimeorank;
                    } else if (lastvimeorank != 0 && webRank == 0) {
                        webRank = lastvimeorank;
                    } else if (lastvimeorank == 0) {
                    }
                    query = "update Videokeywords set rankVimeo = ?,VimeoUpdatedDate=? where videokeywordID = ?";
                    getHibernateTemplate().bulkUpdate(query, new Object[]{webRank, new Date().toString(), keywordId});
                    break;
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method creates new keyword records for update to keywords tablef
     * keywords
     *
     * @param keywordID
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void newUpdateKeywords(int keywordID, Integer startTrackId, Integer endTrackId) {

        Date previousDate = null;
        Calendar calendar = Calendar.getInstance();
        List<Trackhistory> prevRecord;
        List<Trackhistory> currRecord;
        Integer currRankGoogle = 0;
        Integer currRankBing = 0;
        Integer currRankYahoo = 0;
        List<Serpkeywords> lstKeywords = null;

        //System.out.println("lstKeywords:" + lstKeywords.size());
        try {
            lstKeywords = getHibernateTemplate().find("from Keywords k where k.keywordId"
                    + " =? ", new Object[]{keywordID});
            for (Serpkeywords objKeyword : lstKeywords) {
                keywordID = objKeyword.getKeywordID();
                System.out.println("saving record KeywordID= " + keywordID);
                currRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordId"
                        + " =? and t.trackId >=? and t.trackId <= ?", new Object[]{keywordID, startTrackId, endTrackId});
                objKeyword.setRankGoogle(currRecord.get(0).getRankGoogle());
                objKeyword.setBestMatchLinkGoogle(currRecord.get(0).getBestMatchLinkGoogle());
                objKeyword.setBestMatchRankGoogle(currRecord.get(0).getBestMatchRankGoogle());
                currRankGoogle = currRecord.get(0).getRankGoogle();
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_YEAR, -1);
                previousDate = calendar.getTime();
                prevRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordId"
                        + " =? and t.trackDate =?", new Object[]{keywordID, previousDate});
                if (prevRecord != null && prevRecord.size() > 0) {
                    objKeyword.setRankGoogleDayChange(prevRecord.get(0).getRankGoogle() - currRankGoogle);
                } else {
                    objKeyword.setRankGoogleDayChange(0);
                }
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_YEAR, -7);
                previousDate = calendar.getTime();
                prevRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordId"
                        + " =? and t.trackDate =?", new Object[]{keywordID, previousDate});
                if (prevRecord != null && prevRecord.size() > 0) {
                    objKeyword.setRankGoogleWeekChange(prevRecord.get(0).getRankGoogle() - currRankGoogle);
                } else {
                    objKeyword.setRankGoogleWeekChange(0);
                }
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_YEAR, -30);
                previousDate = calendar.getTime();
                prevRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordId"
                        + " =? and t.trackDate =?", new Object[]{keywordID, previousDate});
                if (prevRecord != null && prevRecord.size() > 0) {
                    objKeyword.setRankGoogleMonthChange(prevRecord.get(0).getRankGoogle() - currRankGoogle);
                } else {
                    objKeyword.setRankGoogleMonthChange(0);
                }
                updateKeyword(objKeyword);
            }
        } catch (DataAccessException e) {
            l.debug(e + "  " + e.getMessage());
            //e.printStackTrace();
        }
    }

    /**
     * This method creates new keyword records for update to keywords table
     *
     * @param lstKeywords The list of keywords
     * @param startTrackId The start trackid
     * @param endTrackId The end trackid
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateKeywords(List<Serpkeywords> lstKeywords, Integer startTrackId, Integer endTrackId) {

        Integer keywordID = 0;
        Date previousDate = null;
        Calendar calendar = Calendar.getInstance();
        List<Trackhistory> prevRecord;
        List<Trackhistory> currRecord;
        Integer currRankGoogle = 0;
        Integer currRankBing = 0;
        Integer currRankYahoo = 0;
        //System.out.println("lstKeywords:" + lstKeywords.size());
        try {
            for (Serpkeywords objKeyword : lstKeywords) {
                keywordID = objKeyword.getKeywordID();
                System.out.println("saving record KeywordID= " + keywordID);
                currRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordId"
                        + " =? and t.trackId >=? and t.trackId <= ?", new Object[]{keywordID, startTrackId, endTrackId});
                objKeyword.setRankGoogle(currRecord.get(0).getRankGoogle());
                objKeyword.setBestMatchLinkGoogle(currRecord.get(0).getBestMatchLinkGoogle());
                objKeyword.setBestMatchRankGoogle(currRecord.get(0).getBestMatchRankGoogle());
                currRankGoogle = currRecord.get(0).getRankGoogle();
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_YEAR, -1);
                previousDate = calendar.getTime();
                prevRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordId"
                        + " =? and t.trackDate =?", new Object[]{keywordID, previousDate});
                if (prevRecord != null && prevRecord.size() > 0) {
                    objKeyword.setRankGoogleDayChange(prevRecord.get(0).getRankGoogle() - currRankGoogle);
                } else {
                    objKeyword.setRankGoogleDayChange(0);
                }
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_YEAR, -7);
                previousDate = calendar.getTime();
                prevRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordId"
                        + " =? and t.trackDate =?", new Object[]{keywordID, previousDate});
                if (prevRecord != null && prevRecord.size() > 0) {
                    objKeyword.setRankGoogleWeekChange(prevRecord.get(0).getRankGoogle() - currRankGoogle);
                } else {
                    objKeyword.setRankGoogleWeekChange(0);
                }
                calendar.setTime(new Date());
                calendar.add(Calendar.DAY_OF_YEAR, -30);
                previousDate = calendar.getTime();
                prevRecord = getHibernateTemplate().find("from Trackhistory t where t.keywordId"
                        + " =? and t.trackDate =?", new Object[]{keywordID, previousDate});
                if (prevRecord != null && prevRecord.size() > 0) {
                    objKeyword.setRankGoogleMonthChange(prevRecord.get(0).getRankGoogle() - currRankGoogle);
                } else {
                    objKeyword.setRankGoogleMonthChange(0);
                }
                updateKeyword(objKeyword);
            }
        } catch (DataAccessException e) {
            l.debug(e + "  " + e.getMessage());
            //e.printStackTrace();
        }
    }

    /**
     * This method gives list of campaigns
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Campaigns> getCampaignsList() {
        List<Campaigns> lstCampaigns = new ArrayList();
        try {
            String query = "from Campaigns where visibility = 1";
            lstCampaigns = getHibernateTemplate().find(query);
        } catch (DataAccessException e) {
            l.debug(e + " " + e.getMessage());
        }
        return lstCampaigns;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Serpkeywords> getNewSerpList() {
        List<Serpkeywords> lstKeywords = new ArrayList();
        try {
            //String query = "from Serpkeywords where RankGoogle = 0";
            String query = "from Serpkeywords where GoogleUpdatedDate = '-' or YahooUpdateDate ='-' or BingUpdateDate='-'";
            lstKeywords = getHibernateTemplate().find(query);
        } catch (DataAccessException e) {
            l.debug(e + " " + e.getMessage());
        }
        return lstKeywords;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Serpkeywords> getNewSerpListForAll() {
        List<Serpkeywords> lstKeywords = new ArrayList();
        try {
            //String query = "from Serpkeywords where RankGoogle = 0";
            String query = "from Serpkeywords where GoogleUpdatedDate = '-' or YahooUpdateDate ='-' or BingUpdateDate='-' group by CampaignID,Url,Keyword";
            lstKeywords = getHibernateTemplate().find(query);
        } catch (DataAccessException e) {
            l.debug(e + " " + e.getMessage());
        }
        return lstKeywords;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Videokeywords> getNewVideoList() {
        List<Videokeywords> lstKeywords = new ArrayList();
        try {
            String query = "from Videokeywords where (YoutubeUpdatedDate='-' or VimeoUpdatedDate='-' or DailymotionUpdatedDate='-' or MetaCafeUpdatedDate='-') and Visibility ='1'";
            lstKeywords = getHibernateTemplate().find(query);
        } catch (DataAccessException e) {
            l.debug(e + " " + e.getMessage());
        }
        return lstKeywords;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List getspecifiedCustomerKeywords(int customerid) {
        Integer campaignid = 0, camp = 0;
        List<Integer> customerkeywords = new ArrayList<>();
        List<Customers> l1 = null;
        //Session session=HibernateUtil.getSessionFactory().openSession(); 
        try {

            System.out.println("customerid = " + customerid);
            //String query1="FROM Customers c WHERE c.customerID = :customerID";
            l1 = getHibernateTemplate().find("SELECT c FROM Customers c WHERE c.customerID = ?", new Object[]{customerid});
            for (Object o : l1) {
                System.out.println("o = " + o);
            }
//        String query2="FROM Campaigns s WHERE s.customers = :customer";
//        List<Object> l=getHibernateTemplate().find("FROM Campaigns s WHERE s.customers = ?",new Object[]{customerid});
//        campaignid=(Integer)l.get(0);
//        System.out.println("camp1 = " + campaignid);
        } catch (DataAccessException e) {
            System.out.println("Exception in KeywordsDao getspecifiedCustomerKeywords " + e);
            e.printStackTrace();

        }
//        finally{
//            session.close();
//        }
        return customerkeywords;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<String> getUrlList(Integer campaignID) {
        List lst;
        List<String> urlList = new ArrayList<>();
        try {

            lst = getHibernateTemplate().find("FROM Serpkeywords where CampaignID=? and visibility = 1", new Object[]{campaignID});
            Iterator itr3 = lst.iterator();
            while (itr3.hasNext()) {
                Serpkeywords keyobj = (Serpkeywords) itr3.next();
                urlList.add(keyobj.getUrl());
            }

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return urlList;
    }

    public String getClientEmailId(Integer customerid) {

        List lstusers = getHibernateTemplate().find("FROM Users where customerID=?", new Object[]{new Customers(customerid)});
        Iterator itr = lstusers.iterator();
        Users user = (Users) itr.next();
        String loginId = user.getLoginID();
        return loginId;

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void savePaDaResult(Integer keywoId, String url, String keyword, Campaigns objcampaigns, Integer pacount, Integer dacount) {
        List lstseokeyword;

        try {
            lstseokeyword = getHibernateTemplate().find("FROM Seokeyworddetails where keywordID = ? ", new Object[]{new Serpkeywords(keywoId)});
            if (lstseokeyword.isEmpty()) {
                try {
                    Seokeyworddetails seodata = new Seokeyworddetails();
                    seodata.setCampaignID(objcampaigns);
                    seodata.setKeywordID(new Serpkeywords(keywoId));
                    seodata.setUrl(url);
                    seodata.setKeyword(keyword);
                    seodata.setSearchVolume(0);
                    seodata.setGoogleCPC((float) 0);
                    seodata.setKeywordCompetition((float) 0);
                    seodata.setNumberofResult((long) 0);
                    seodata.setGooglePA(pacount);
                    seodata.setGoogleDA(dacount);
                    seodata.setSiteIndexing("");
                    seodata.setAddedDate(new Date());
                    seodata.setRankPage(0);
                    seodata.setRankAlexa(0);
                    seodata.setCountBackLinks(0);
                    seodata.setCountMonthlySearches(0);
                    seodata.setVisibility(1);
                    getHibernateTemplate().save(seodata);
                } catch (DataAccessException e) {
                    e.printStackTrace();
                }
                System.out.println("**********inserted********");
            } else {
                String hqlQuery = "update Seokeyworddetails set googlePA = ?,googleDA=?,addedDate=?  where keywordID = ? ";
                getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{pacount, dacount, new Date(), new Serpkeywords(keywoId)});
                System.out.println("********updated*******");
            }
        } catch (DataAccessException | IllegalStateException | HibernateException e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void savePaDaResult1(Integer keywoId, String url, String keyword, Campaigns objcampaigns, Integer pacount, Integer dacount, String KeywordsURL) {
        List lstseokeyword;

        try {
            lstseokeyword = getHibernateTemplate().find("FROM Seokeyworddetails where keywordID = ? ", new Object[]{new Serpkeywords(keywoId)});
            if (lstseokeyword.isEmpty()) {
                try {
                    Seokeyworddetails seodata = new Seokeyworddetails();
                    seodata.setCampaignID(objcampaigns);
                    seodata.setKeywordID(new Serpkeywords(keywoId));
                    seodata.setUrl(url);
                    seodata.setKeyword(keyword);
                    seodata.setSearchVolume(0);
                    seodata.setGoogleCPC((float) 0);
                    seodata.setKeywordCompetition((float) 0);
                    seodata.setNumberofResult((long) 0);
                    seodata.setGooglePA(pacount);
                    seodata.setGoogleDA(dacount);
                    seodata.setSiteIndexing("");
                    seodata.setAddedDate(new Date());
                    seodata.setRankPage(0);
                    seodata.setRankAlexa(0);
                    seodata.setCountBackLinks(0);
                    seodata.setCountMonthlySearches(0);
                    seodata.setVisibility(1);
                    getHibernateTemplate().save(seodata);
                } catch (DataAccessException e) {
                    e.printStackTrace();
                }
                System.out.println("**********inserted********");
            } else {
                String hqlQuery = "update Seokeyworddetails set googlePA = ?,googleDA=?,addedDate=?  where Url = ? ";
                getHibernateTemplate().bulkUpdate(hqlQuery, new Object[]{pacount, dacount, new Date(), KeywordsURL});
                System.out.println("********updated*******");
            }
        } catch (DataAccessException | IllegalStateException | HibernateException e) {
            e.printStackTrace();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Serpkeywords> getCampaignsKeywords(Integer campaignid) {
        List<Serpkeywords> keywordobj = new ArrayList<>();
        List lstkeywrd;
        try {
            lstkeywrd = getHibernateTemplate().find("FROM Serpkeywords where campaignID=? and visibility = 1", new Object[]{campaignid});
            Iterator ittr = lstkeywrd.iterator();
            while (ittr.hasNext()) {
                Serpkeywords keyobj = (Serpkeywords) ittr.next();
                System.out.println("ky = " + keyobj.getKeyword());
                keywordobj.add(keyobj);
            }

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return keywordobj;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Campaigns> getRankRefresherCampaignsList() {
        List<Campaigns> lstCampaigns = new ArrayList();
        try {
            String query = "from Campaigns where rankRefresherStatus=1";
            lstCampaigns = getHibernateTemplate().find(query);
            for (Campaigns campaigns : lstCampaigns) {
                campaigns.setRankRefresherStatus(0);
                getHibernateTemplate().update(campaigns);
                System.out.println("Refresh  : " + campaigns.getCampaignID());
            }
        } catch (DataAccessException e) {
            l.debug(e + " " + e.getMessage());
        }
        return lstCampaigns;
    }
}
