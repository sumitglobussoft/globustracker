package ranktracker.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ranktracker.entity.*;
import ranktracker.form.KeywordsLastUpdatedForm;

/**
 * DAO layer class for Serpkeywords Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class KeywordsDaoImpl extends HibernateDaoSupport implements KeywordsDao {

    static org.apache.log4j.Logger l = org.apache.log4j.Logger.getLogger(KeywordsDaoImpl.class.getName());

    /**
     * The method gets keywords for a given campaign id
     *
     * @param campaignId
     * @return List<Serpkeywords>
     */
    @Override
    public List<Serpkeywords> getKeywords(Integer campaignId) {

        //invoking the getSession() method to retrieve object of Campaigns class for <campaignId>
        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignId);
        if (objCampaigns == null) {
            return null;
        } else {

            List<Serpkeywords> lstKeywords = new ArrayList<>();
            Collection<Serpkeywords> id = objCampaigns.getSerpkeywordsCollection();

            //retrieving the keywords from <objCampaigns>
            Iterator itr = id.iterator();
            while (itr.hasNext()) {
                Serpkeywords ck = (Serpkeywords) itr.next();
                lstKeywords.add(ck);
            }
            return lstKeywords;
        }
    }

    /**
     *
     * @param campaignId
     * @return
     */
    @Override
    public List<Serpkeywords> getSerpKeywords(Integer campaignId, Integer customerID) {
        //invoking the getSession() method to retrieve object of Campaigns class for <campaignId>
//        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignId);
        Criteria objCriteria = getSession().createCriteria(Campaigns.class);
        try {
            //adding Restrictions for <url>,<keyword> and <linkGoogle>
            objCriteria.add(Restrictions.eq("campaignID", campaignId));
            objCriteria.add(Restrictions.eq("customerID", new Customers(customerID)));
            objCriteria.add(Restrictions.eq("visibility", 1));
            //retrieving the list of keywords object from objCriteria object
            //Campaigns objCampaigns = (Campaigns) objCriteria.list().iterator().next();
            List<Campaigns> list = new ArrayList<>();
            List<Serpkeywords> keywordobj = new ArrayList<>();
            list.addAll(objCriteria.list());
            Iterator ittr = list.iterator();
            while (ittr.hasNext()) {
                try {
                    Campaigns objCampaigns = (Campaigns) ittr.next();
                    if (objCampaigns == null) {
                        return new ArrayList<>();
                    } else {
                        keywordobj = getHibernateTemplate().find("FROM Serpkeywords where CampaignID=? and visibility = 1", new Object[]{campaignId});
                        return keywordobj;
                    }

                } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Seokeyworddetails> getSeoDetails(Integer campaignId, Integer customerID) {
        //invoking the getSession() method to retrieve object of Campaigns class for <campaignId>
//        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignId);
        Criteria objCriteria = getSession().createCriteria(Campaigns.class);
        //adding Restrictions for <url>,<keyword> and <linkGoogle>
        objCriteria.add(Restrictions.eq("campaignID", campaignId));
        objCriteria.add(Restrictions.eq("customerID", new Customers(customerID)));
        objCriteria.add(Restrictions.eq("visibility", 1));
        //retrieving the list of keywords object from objCriteria object
        //Campaigns objCampaigns = (Campaigns) objCriteria.list().iterator().next();
        List<Campaigns> list = new ArrayList<>();
        List<Seokeyworddetails> keywordobj = new ArrayList<>();
        list.addAll(objCriteria.list());
        Iterator ittr = list.iterator();
        while (ittr.hasNext()) {
            try {
                Campaigns objCampaigns = (Campaigns) ittr.next();
                if (objCampaigns == null) {
                    return new ArrayList<>();
                } else {
                    keywordobj = getHibernateTemplate().find("FROM Seokeyworddetails where CampaignID=? and visibility = 1", new Object[]{campaignId});
                    return keywordobj;
                }

            } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    /**
     *
     * @param campaignId
     * @return
     */
    @Override
    public List<Videokeywords> getChartDataVideo(Integer videokeywordId) {

        List<Videokeywords> l = getHibernateTemplate().find("FROM Videokeywords where videokeywordID=?", new Object[]{videokeywordId});

        return l;
    }

    /**
     *
     * @param campaignId
     * @return
     */
    @Override
    public List<Videokeywords> getVideoKeywords(Integer campaignId, Integer customerId) {
        List vkeywords;
        List lstKeywords = new ArrayList();
        //Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignId);
        Criteria objCriteria = getSession().createCriteria(Campaigns.class);
        //adding Restrictions for <url>,<keyword> and <linkGoogle>
        objCriteria.add(Restrictions.eq("campaignID", campaignId));
        objCriteria.add(Restrictions.eq("customerID", new Customers(customerId)));
        objCriteria.add(Restrictions.eq("campaignType", "video"));
        objCriteria.add(Restrictions.eq("visibility", 1));
        //retrieving the list of keywords object from objCriteria object
        //Campaigns objCampaigns = (Campaigns) objCriteria.list().iterator().next();
        List<Campaigns> list = new ArrayList<>();
        list.addAll(objCriteria.list());
        Iterator ittr = list.iterator();
        while (ittr.hasNext()) {
            Campaigns objCampaigns = (Campaigns) ittr.next();
            if (objCampaigns == null) {
                return new ArrayList<Videokeywords>();
            } else {

//                lstKeywords.addAll(objCampaigns.getVideoKeywordses());
                // List<Videokeywords> keywords=new ArrayList(objCampaigns.getVideokeywordsCollection());
                String query = "from Videokeywords where campaignID = ? and visibility = 1";
                vkeywords = getHibernateTemplate().find(query, new Object[]{new Campaigns(campaignId)});
                lstKeywords.addAll(vkeywords);
            }
        }
        return lstKeywords;
    }

    /**
     * The method adds new keyword records to database
     *
     * @param keys
     * @param siteId
     * @param url
     * @param googleRegion
     * @param matchLink
     * @param matchRank
     * @param engine
     * @return int
     */
    @Override
    public int addKeyword(List keys, Integer campaignId, String url, String linkGoogle, String matchLink, String matchRank, String engine) {
        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignId);
        Serpkeywords objKeyword = null;
        //now retrieving <customerID> from <objCampaigns> object
        Integer customerID = objCampaigns.getCustomerID().getCustomerID();

        System.out.println("customerID = >>>>>>>>>>>>>>>>" + customerID);
        //now retrieving the <objCustomer> object for <customerID>
        Collection campaignkeywordIDs = objCampaigns.getSerpkeywordsCollection();
        // Set<Serpkeywords> setkeywords = new HashSet<Serpkeywords>();
        Customers objCustomer = (Customers) getSession().get(Customers.class, customerID);

        if (campaignkeywordIDs.isEmpty()) {
            for (Object keywrd : keys) {
                try {
                    // this part of code inserts keyword for first time into db after creation of campaign
                    objKeyword = new Serpkeywords();
                    objKeyword.setKeyword(keywrd.toString());
                    objKeyword.setUrl(url);
                    objKeyword.setLinkGoogle(linkGoogle);
                    objKeyword.setBestMatchLinkBing("");
                    objKeyword.setBestMatchLinkGoogle("");
                    objKeyword.setBestMatchLinkYahoo("");
                    objKeyword.setRegion(engine);
                    objKeyword.setGoogleUpdatedDate("-");
                    objKeyword.setYahooUpdateDate("-");
                    objKeyword.setBingUpdateDate("-");
                    objKeyword.setVisibility(1);

                    objCampaigns.getSerpkeywordsCollection().add(objKeyword);
                    objKeyword.setCampaignID(objCampaigns);
                    getHibernateTemplate().save(objKeyword);

                    //increasing the active keyword count by 1
                    objCustomer.setActiveKeywordCount(objCustomer.getActiveKeywordCount() + 1);
                    //saving the objCustomer object
                    getSession().update(objCustomer);
                    // int q = insertIntoSeoDetails(keywrd, customerID, keyid, objCampaigns);
                } catch (DataAccessException | NumberFormatException | IllegalStateException | HibernateException e) {
                    l.error(e + " " + e.getMessage());
                    e.printStackTrace();
                }
            }
            return 1;
        } else {
            Collection<Serpkeywords> storedkeywordses = objCampaigns.getSerpkeywordsCollection();
            try {
                //checking for domain value of the url from already added url ,
                //if domain matches then we will add this url otherwise return 0
                boolean match = checkHost(url, objCampaigns);
                if (!match) {
                    return 0;
                }
            } catch (Exception e) {
            }
            int foundKeyword = 0;
            int keywordCount = 0;
            int keywordAdded = 0;
            for (Object keyword : keys) {
                boolean foundInSameCampaign = false;
                //            Customers objCustomer = (Customers) getSession().get(Customers.class, customerID);
                try {
                    //now check for : is keyword and url already exist in the same campaign 
                    //if yes and visibility is 0 then make it visible i.e visibility=1
                    //if yes and visibility is 1 then continue the loop
                    for (Serpkeywords objKeywords : storedkeywordses) {

                        if (objKeywords.getKeyword().equalsIgnoreCase(keyword.toString()) && objKeywords.getUrl().equalsIgnoreCase(url)) {
                            if (objKeywords.getVisibility() == 1) {
                                foundInSameCampaign = true;
                                foundKeyword++;
                                continue;
                            } else if (objKeywords.getVisibility() == 0) {
                                try {
                                    objKeywords.setVisibility(1);
                                    objCampaigns.getSerpkeywordsCollection().add(objKeywords);
                                    objKeywords.setCampaignID(objCampaigns);
                                    getSession().update(objKeywords);
                                    foundInSameCampaign = true;
                                    keywordAdded++;
                                    //now have to increase active keyword count
                                    objCustomer.setActiveKeywordCount(objCustomer.getActiveKeywordCount() + 1);
                                    getSession().save(objCustomer);

                                    keywordAdded++;
                                } catch (IllegalStateException | HibernateException | DataAccessResourceFailureException ex) {
                                    l.error(ex + "  " + ex.getMessage());
                                }
                            }
                            continue;
                        }
                    }
                } catch (Exception ex) {
                    l.error(ex + "  " + ex.getMessage());
                }
                if (!foundInSameCampaign) {
                    try {
                        //if keyword ,url not exist in table 
                        objKeyword = new Serpkeywords();
                        //set all the parameter of Serpkeywords in objKeyword
                        objKeyword.setKeyword(keyword.toString());
                        objKeyword.setUrl(url);
                        objKeyword.setLinkGoogle(linkGoogle);
                        objKeyword.setBestMatchLinkBing("");
                        objKeyword.setBestMatchLinkGoogle("");
                        objKeyword.setBestMatchLinkYahoo("");
                        objKeyword.setRegion(engine);
                        objKeyword.setGoogleUpdatedDate(new Date().toString());
                        objKeyword.setYahooUpdateDate(new Date().toString());
                        objKeyword.setBingUpdateDate(new Date().toString());
                        objKeyword.setVisibility(1);
                        objCampaigns.getSerpkeywordsCollection().add(objKeyword);
                        //invoking getSession method to save <objCampaigns> object
                        objKeyword.setCampaignID(objCampaigns);
                        getHibernateTemplate().save(objKeyword);
                        //getSession().update(objCampaigns);
                        // insertIntoSeoDetails(keyword, customerID, keyid1, objCampaigns);
                        //increasing the active keyword count by 1
                        objCustomer.setActiveKeywordCount(objCustomer.getActiveKeywordCount() + 1);
                        //saving the objCustomer object
                        getSession().save(objCustomer);
                        keywordAdded++;

                    } catch (DataAccessException | IllegalStateException | HibernateException ex) {
                        l.error(ex + "  " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                keywordCount++;
            }
            if (foundKeyword == 1 && keywordCount == 1) {
                return -10;
            } else if (keywordAdded > 0) {
                return 1;
            } else {
                return -10;
            }
        }
    }

    @Override
    public int addVideoKeyword(List keys, Integer campaignId, String youtubeurl, String vimeourl, String dailymotionurl,
            String metacafeurl) {
        Campaigns campaign = (Campaigns) getSession().get(Campaigns.class, campaignId);
        //now retrieving <customerID> from <objCampaigns> object
        Integer customerID = campaign.getCustomerID().getCustomerID();
        System.out.println("customerID **********************= " + customerID);
        //now retrieving the <objCustomer> object for <customerID>
        Customers objCustomer = (Customers) getSession().get(Customers.class, customerID);
        List list = null;
        //It checks whether the data is entering Videokeywords table for first time for a campaign or not
        try {
            String query = "FROM Videokeywords where campaignID = ? and visibility = 1";
            list = getHibernateTemplate().find(query, new Object[]{new Campaigns(campaign.getCampaignID())});
        } catch (Exception e) {
            e.printStackTrace();
            l.error(e + "  " + e.getMessage());
        }

        //Enters data if list is empty
        Short n = 0;
        if (list.isEmpty()) {
            Iterator itr = keys.iterator();
            while (itr.hasNext()) {
                String key = (String) itr.next();
                try {
                    System.out.println("----------------youtubeurl" + youtubeurl);
                    Videokeywords videokeywords = new Videokeywords();
                    videokeywords.setCampaignID(new Campaigns(campaign.getCampaignID()));
                    videokeywords.setYoutubeURL(youtubeurl);
                    videokeywords.setRankYoutube(n);
                    videokeywords.setVimeoURL(vimeourl);
                    videokeywords.setRankVimeo(n);
                    videokeywords.setDailymotionURL(dailymotionurl);
                    videokeywords.setRankDailyMotion(n);
                    videokeywords.setMetacafeURL(metacafeurl);
                    videokeywords.setRankMetacafe(n);
                    videokeywords.setVideoKeyword(key);
                    videokeywords.setVisibility(Short.parseShort("1"));
                    getHibernateTemplate().save(videokeywords);

                    //increasing the active keyword count by 1
                    objCustomer.setActiveVideoKeywordCount(objCustomer.getActiveVideoKeywordCount() + 1);
                    //saving the objCustomer object
                    getSession().update(objCustomer);
                } catch (NumberFormatException | DataAccessException | IllegalStateException | HibernateException e) {
                    e.printStackTrace();
                    l.error(e + "  " + e.getMessage());
                    return 0;
                }
            }
            return 1;
        } else {
            int foundKeyword = 0;
            int keywordCount = 0;
            int keywordAdded = 0;
            Videokeywords videoKeywords = null;
            for (Iterator it = keys.iterator(); it.hasNext();) {
                boolean foundInSameCampaign = false;
                Object keywords = it.next();
                Collection<Videokeywords> setkeywords = campaign.getVideokeywordsCollection();
                for (Videokeywords setkey : setkeywords) {
                    if (setkey.getVideoKeyword().equalsIgnoreCase(keywords.toString())) {
                        if (setkey.getVisibility() == 1) {
                            foundInSameCampaign = true;
                            foundKeyword++;
                            continue;
                        } else if (setkey.getVisibility() == 0) {
                            try {
                                foundInSameCampaign = true;
                                setkey.setYoutubeURL(youtubeurl);
                                setkey.setRankYoutube(n);
                                setkey.setDailymotionURL(dailymotionurl);
                                setkey.setRankDailyMotion(n);
                                setkey.setVimeoURL(vimeourl);
                                setkey.setRankVimeo(n);
                                setkey.setMetacafeURL(metacafeurl);
                                setkey.setRankMetacafe(n);
                                setkey.setYoutubeViewCount(n);//am1
                                setkey.setVimeoViewCount(n);//am2
                                setkey.setMetacafeViewCount(n);//am3
                                setkey.setDailymotionViewCount(n);//am4
                                setkey.setVisibility(Short.parseShort("1"));
                                getSession().update(setkey);
                                Customers customer = (Customers) getSession().get(Customers.class, customerID);
                                customer.setActiveVideoKeywordCount(customer.getActiveVideoKeywordCount() + 1);
                                getSession().update(customer);

                                keywordAdded++;
                            } catch (NumberFormatException | DataAccessResourceFailureException | IllegalStateException | HibernateException e) {
                                l.error(e + " " + e.getMessage());
                            }
                            continue;
                        }
                    }
                }
                if (!foundInSameCampaign) {
                    try {
                        videoKeywords = new Videokeywords();
                        videoKeywords.setVideoKeyword(keywords.toString());
                        videoKeywords.setYoutubeURL(youtubeurl);
                        videoKeywords.setRankYoutube(n);
                        videoKeywords.setVimeoURL(vimeourl);
                        videoKeywords.setRankVimeo(n);
                        videoKeywords.setDailymotionURL(dailymotionurl);
                        videoKeywords.setRankDailyMotion(n);
                        videoKeywords.setMetacafeURL(metacafeurl);
                        videoKeywords.setRankMetacafe(n);
                        videoKeywords.setYoutubeViewCount(n);//am5
                        videoKeywords.setVimeoViewCount(n);//am6
                        videoKeywords.setMetacafeViewCount(n);//am7
                        videoKeywords.setDailymotionViewCount(n);//am8
                        videoKeywords.setCampaignID(new Campaigns(campaign.getCampaignID()));
                        videoKeywords.setVisibility(Short.parseShort("1"));
                        getHibernateTemplate().save(videoKeywords);
                        //increasing the active keyword count by 1
                        objCustomer.setActiveVideoKeywordCount(objCustomer.getActiveVideoKeywordCount() + 1);
                        //saving the objCustomer object
                        getSession().update(objCustomer);

                        keywordAdded++;
                    } catch (NumberFormatException | DataAccessException | IllegalStateException | HibernateException e) {
                        l.error(e + " " + e.getMessage());
                    }
                }
                keywordCount++;
            }
            if (foundKeyword == 1 && keywordCount == 1) {
                return 0;
            } else if (keywordAdded > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private boolean checkHost(String url, Campaigns objCampaigns) {

        //this method recieves the url and objCampaigns object
        //and find out <url> domains and domain added in <objCampaigns> object
        //if match found then return true
        //else return false
        boolean b = true;
        String checkurl = "";
        String matchUrl = url;
        String checkHost = null;
        String matchHost = null;
        try {
            List<Serpkeywords> lstKeywordsDomain = new ArrayList<>(objCampaigns.getSerpkeywordsCollection());
            checkurl = lstKeywordsDomain.get(0).getUrl();
            Iterator itr = lstKeywordsDomain.iterator();
            while (itr.hasNext()) {
                Serpkeywords serps = (Serpkeywords) itr.next();
                if (serps.getVisibility() == 1) {
                    checkurl = checkurl.replace("http://", "").replace("https://", "").replace("www.", "");
                    matchUrl = matchUrl.replace("http://", "").replace("https://", "").replace("www.", "");
                    checkurl = "http://" + checkurl;
                    matchUrl = "http://" + matchUrl;
                    checkHost = new URL(checkurl).getHost();
                    matchHost = new URL(matchUrl).getHost();
                    if (!checkHost.equals(matchHost)) {
                        b = false;
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
            Logger.getLogger(KeywordsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    @Override
    public int addBestMatchKeyword(List keys, Integer campaignId, String url, String linkGoogle, String matchLink, String matchRank, String engine) {
        String checkurl = "";
        String matchUrl = matchLink;
        String checkHost = null;
        String matchHost = null;

        //invoking the getSession method for Campaigns class object 
        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignId);
        List<Serpkeywords> lstKeywordsDomain = new ArrayList<>(objCampaigns.getSerpkeywordsCollection());

        try {
            //now retrieving the first record of Keyword object from <lstKeywordsDomain> object
            checkurl = lstKeywordsDomain.get(0).getUrl();

            //checking for the domain
            checkurl = checkurl.replace("http://", "").replace("https://", "").replace("www.", "");
            matchUrl = matchUrl.replace("http://", "").replace("https://", "").replace("www.", "");
            checkurl = "http://" + checkurl;
            matchUrl = "http://" + matchUrl;
            checkHost = new URL(checkurl).getHost();
            matchHost = new URL(matchUrl).getHost();
            if (!checkHost.equals(matchHost)) {
                //if domain does not matches then return 0
                return 0;
            }
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
            Logger.getLogger(KeywordsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Object keyword : keys) {
            Serpkeywords objKeyword = null;
            if ((keyword.toString()).equals("") || url.length() > 200 || url.isEmpty() || url.equals("")) {
                return -1;
            }

            //remove http,https,www, and end /
            matchLink = matchLink.replace("https://", "").replace("http://", "").replace("www.", "");
            if (matchLink.endsWith("/")) {
                matchLink = matchLink.substring(0, matchLink.length() - 1);
            }

            try {
                //now check for is keyword and url already exist in the same campaign if yes return 0
                Set<Serpkeywords> keywordses = (Set<Serpkeywords>) objCampaigns.getSerpkeywordsCollection();
                for (Serpkeywords objKeywords : keywordses) {
                    if (objKeywords.getKeyword().equals(keyword) && objKeywords.getUrl().equals(matchLink)) {
                        if (objKeywords.getVisibility() == 1) {
                            return -10;
                        }
                    }
                }
            } catch (Exception ex) {
                l.error(ex + "  " + ex.getMessage());
            }

            try {

                objKeyword = new Serpkeywords();

                //set all the parameter of Serpkeywords in objKeyword
                objKeyword.setKeyword(keyword.toString());
                objKeyword.setVisibility(1);
                objKeyword.setLinkGoogle(linkGoogle);
                if (matchLink != null) {
                    objKeyword.setUrl(matchLink);
                    switch (engine) {
                        case "google":
                            //if engine is "google" then add best match rank and best match link for google
                            objKeyword.setRankGoogle(Integer.parseInt(matchRank));
                            objKeyword.setBestMatchLinkGoogle(null);
                            objKeyword.setBestMatchRankGoogle(0);
                            break;
                        case "bing":
                            //if engine is "bing" then add best match rank and best match link for bing
                            objKeyword.setRankBing(Integer.parseInt(matchRank));
                            objKeyword.setBestMatchLinkBing(null);
                            objKeyword.setBestMatchRankBing(0);
                            break;
                        case "yahoo":
                            //if engine is "yahoo" then add best match rank and best match link for yahoo
                            objKeyword.setRankYahoo(Integer.parseInt(matchRank));
                            objKeyword.setBestMatchLinkYahoo(null);
                            objKeyword.setBestMatchRankYahoo(0);
                            break;
                    }
                }

                //adding the <objKeyword> mapping in objCampaigns object
                objCampaigns.getSerpkeywordsCollection().add(objKeyword);

                //now saving the <objCampaigns> object into session
                getSession().save(objCampaigns);
            } catch (NumberFormatException | DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
                l.error(ex + "  " + ex.getMessage());
            }
        }
        Integer customerID = objCampaigns.getCustomerID().getCustomerID();
        Customers objCustomer = (Customers) getSession().get(Customers.class, customerID);
        try {
            //now increasing the active keyword count by 1
            objCustomer.setActiveKeywordCount(objCustomer.getActiveKeywordCount() + 1);
            getSession().save(objCustomer);
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
        }

        return 1;
    }

    /**
     * The method edits/updates a given keyword
     *
     * @param keywordId
     * @param keyword
     * @param url
     * @param linkGoogle
     * @param campaignId
     * @return int
     */
    @Override
    public Integer editKeyword(Integer keywordId, String keyword, String url, String linkGoogle, Integer campaignId) {
        Campaigns objCampaign = (Campaigns) getSession().get(Campaigns.class, campaignId);

        //invoking the getSession() to get the Serpkeywords class object for <keywordId>
        Serpkeywords objKeyword = (Serpkeywords) getSession().get(Serpkeywords.class, keywordId);

        try {
            boolean foundInSameCampaign = false;
            Collection<Serpkeywords> setkeywords = objCampaign.getSerpkeywordsCollection();
            for (Serpkeywords setkey : setkeywords) {
                if (setkey.getKeyword().equalsIgnoreCase(keyword.toString()) && !keywordId.equals(setkey.getKeywordID())) {
                    if (setkey.getVisibility() == 1) {
                        foundInSameCampaign = true;
                        return 0;
                    }
                }
            }
            try {
                //checking for domain value of the url from already added url ,
                //if domain matches then we will add this url otherwise return 0
                boolean match = checkHost(url, objCampaign);
                if (!match) {
                    return 2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (!foundInSameCampaign) {
                objKeyword.setKeyword(keyword);
                objKeyword.setUrl(url);
                objKeyword.setLinkGoogle(linkGoogle);
                getSession().update(objKeyword);
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
            ex.printStackTrace();
            return 0;
        }
        return 1;
    }

    /**
     * The method deletes a keyword
     *
     * @param keywordId
     * @param campaignId
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteKeyword(Integer keywordId, Integer campaignId) {
        List<Seokeyworddetails> lstSeoDetails;
        //invoking the getSession() method to get Serpkeywords class object for keywordId
        Serpkeywords objKeyword = (Serpkeywords) getSession().get(Serpkeywords.class, keywordId);

        //invoking the getSession() method to create Criteria for Seokeyworddetails class
        Criteria objCriteria = getSession().createCriteria(Seokeyworddetails.class);

        //adding the Restrictions for <keywordID>
        objCriteria.add(Restrictions.eq("keywordID.keywordID", keywordId));

        lstSeoDetails = objCriteria.list();

        //invoking the getSession() method to get Campaigns class object for campaignId
        Campaigns objCampaign = (Campaigns) getSession().get(Campaigns.class, campaignId);

        try {
            //to delete a keyword use the visibility factor as 0
            objKeyword.setVisibility(0);
            getSession().update(objKeyword);
//            objCampaign.getKeywordses().remove(objKeyword);
            if (!lstSeoDetails.isEmpty()) {
                String pagerankquery = "update Seokeyworddetails set visibility = 0 where keywordID.keywordID = ?";
                getHibernateTemplate().bulkUpdate(pagerankquery, new Object[]{keywordId});
            }

            //now invoking the getSession()
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            ex.printStackTrace();
        }

        //now decreasing the active keyword count by 1 for <customerID>
        Integer customerID = objCampaign.getCustomerID().getCustomerID();
        Customers objCustomer = (Customers) getSession().get(Customers.class, customerID);
        try {
            objCustomer.setActiveKeywordCount(objCustomer.getActiveKeywordCount() - 1);
            getSession().update(objCustomer);
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
        }
    }

    /**
     * The method retrieves keyword records for a given customer id
     *
     * @param customerID
     * @return List<Serpkeywords>
     */
    @Override
    public List<Serpkeywords> getKeywordses(Integer customerID) {

        List<Campaigns> lstCampaigns = new ArrayList<>();
        List<Serpkeywords> lstKeywords = new ArrayList<>();

        //now invoking the getSession() to create Criteria for Campaigns class
        Criteria objCriteria = getSession().createCriteria(Campaigns.class);

        //adding Restrictions for <customerID>
        objCriteria.add(Restrictions.eq("customerID.customerID", customerID));

        //now retrieving the list of campaigns for <customerID>
        lstCampaigns = objCriteria.list();
        Iterator it = lstCampaigns.iterator();
        while (it.hasNext()) {
            int i = 0;

            //now iterating the loop 
            //getting each of the campaigns object
            Campaigns objCampaigns = (Campaigns) it.next();
            Collection<Serpkeywords> keywordses = objCampaigns.getSerpkeywordsCollection();
            Iterator it1 = keywordses.iterator();
            while (it1.hasNext()) {

                //retrieving each of the set of keywords for campaigns
                Serpkeywords key = (Serpkeywords) it1.next();
                if (i == 0) {
                    Serpkeywords key1 = new Serpkeywords();
                    lstKeywords.add(key1);
                }
                i++;
                lstKeywords.add(key);
            }
        }
        return lstKeywords;
    }

    /**
     * The method gets serpstrackhistory table data for charts module
     *
     * @param keywordId
     * @param range
     * @return List<Serpstrackhistory>
     */
    @Override
    public List<Serpstrackhistory> getChartData(Integer keywordId, Integer range) {

        //invoking the getSession() method to create Criteria for Serpstrackhistory class
        Criteria objCriteria = getSession().createCriteria(Serpstrackhistory.class);

        //adding the Restrictions for <keywordId>
        objCriteria.add(Restrictions.eq("keywordId", keywordId));

        //setting order for <trackDate> as asending
        objCriteria.addOrder(Order.asc("trackDate"));
        Date previousDate = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (range != 0) {
            calendar.add(Calendar.DAY_OF_YEAR, -range);
            previousDate = calendar.getTime();
            //adding Restrictions for trackDate 
            objCriteria.add(Restrictions.between("trackDate", previousDate, new Date()));
        }

        //returning list of trackhistory object
        List<Serpstrackhistory> lstSerpstrack = objCriteria.list();
        return lstSerpstrack;
    }

//    @Override
//    public int addVideoKeyword(List keys, Integer siteId, String url, String linkGoogle, String matchLink, String matchRank, String engine) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    /**
     * The method gets socialtrackhistory table data for charts module
     *
     * @param keywordId
     * @param range
     * @return List<Serpstrackhistory>
     */
    @Override
    public List<Socialtrackhistory> getChartDataSocial(Integer urlId, Integer range) {

        //invoking the getSession() method to create Criteria for Serpstrackhistory class
        Criteria objCriteria = getSession().createCriteria(Socialtrackhistory.class);

        //adding the Restrictions for <SocialSignalUrlId>
        objCriteria.add(Restrictions.eq("socialSignalUrlID", urlId));

        //setting order for <trackDate> as asending
        objCriteria.addOrder(Order.asc("trackDate"));
        Date previousDate = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (range != 0) {
            calendar.add(Calendar.DAY_OF_YEAR, -range);
            previousDate = calendar.getTime();

            //adding Restrictions for trackDate 
            objCriteria.add(Restrictions.between("trackDate", previousDate, new Date()));
        }

        //returning list of trackhistory object
        List<Socialtrackhistory> lstSocialtrack = objCriteria.list();
        return lstSocialtrack;
    }

    /**
     * The method adds better ranking url for a given keyword, engine
     *
     * @param keywordId
     */
    @Override
    public void addBetterRankingKeyword(Integer keywordId) {

        //invoking the getSession() method to get the Serpkeywords class object for <keywordId>
        Serpkeywords objKeyword = (Serpkeywords) getSession().get(Serpkeywords.class, keywordId);

        Serpkeywords newKeyword = new Serpkeywords();
        try {
            newKeyword.setKeyword(objKeyword.getKeyword());
            //newKeyword.setCampaigns(objKeyword.getCampaigns());
            newKeyword.setLinkGoogle(objKeyword.getLinkGoogle());

            //setting the best match link for google,bing and yahoo
            newKeyword.setUrl(objKeyword.getBestMatchLinkGoogle());
            newKeyword.setUrl(objKeyword.getBestMatchLinkBing());
            newKeyword.setUrl(objKeyword.getBestMatchLinkYahoo());

            //setting the google rank,bing rank and yahoo rank
            newKeyword.setRankGoogle(objKeyword.getRankGoogle());
            newKeyword.setRankBing(objKeyword.getRankBing());
            newKeyword.setRankYahoo(objKeyword.getRankYahoo());

            //invoking the getSession method and save <newKeyword> object
            getSession().save(newKeyword);
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
        }
    }

    /**
     * the method checks keyword quota of a customer
     *
     * @param userID
     * @return int
     */
    @Override
    public int checkKeywordQuota(Integer customerID) {

        //invoking getSession() method to create Criteria object for Customers class
        Criteria objCriteria = getSession().createCriteria(Customers.class);

        //adding Restrictions for <customerID>
        objCriteria.add(Restrictions.eq("customerID", customerID));

        //retrieving the <objCustomers> object
        Customers objCustomers = (Customers) objCriteria.list().get(0);
        int quota = 0;
        try {
            //calculating the quota of keywords
            quota = objCustomers.getAllowedKeywordCount() - (objCustomers.getActiveKeywordCount() + objCustomers.getActiveVideoKeywordCount());
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
        }
        return quota;
    }

    @Override
    public List<Serpkeywords> getKeywords(Integer customerId, String campaign) {

        //creating objCriteria object for Campaigns class.
        Criteria objCriteria = getSession().createCriteria(Campaigns.class);

        //adding Restrictions for <customerId> and <campaign>
        objCriteria.add(Restrictions.eq("customerID.customerID", customerId));
        objCriteria.add(Restrictions.eq("campaign", campaign));

        //retrieving the <objCampaigns> object
        Campaigns objCampaigns = (Campaigns) objCriteria.list().get(0);

        //retrieving the set of keywords object from <objCampaigns>
        Collection<Serpkeywords> keywordses = objCampaigns.getSerpkeywordsCollection();

        //type casting the set of keywords object into list of keywords object
        List<Serpkeywords> lstKeyWords = new ArrayList<>(keywordses);
        return lstKeyWords;

    }

    @Override
    public int editVideoKeyword(Integer campaignId, Integer keywordId, String keyword, String youtubeurl, String vimeourl, String dailymotionurl, String metacafeurl) {
        Campaigns campaign = (Campaigns) getSession().get(Campaigns.class, campaignId);
        Videokeywords videokeyword = (Videokeywords) getSession().get(Videokeywords.class, keywordId);
        int foundKeyword = 0;
        try {
            boolean foundInSameCampaign = false;
            Collection<Videokeywords> setkeywords = campaign.getVideokeywordsCollection();
            for (Videokeywords setkey : setkeywords) {
                if (setkey.getVideoKeyword().equalsIgnoreCase(keyword.toString()) && !keywordId.equals(setkey.getVideokeywordID())) {
                    if (setkey.getVisibility() == 1) {
                        foundInSameCampaign = true;
                        foundKeyword++;
                        continue;
                    }
                }
            }
            if (!foundInSameCampaign) {
                short n = 0;
                if (!videokeyword.getYoutubeURL().equalsIgnoreCase(youtubeurl)) {
                    videokeyword.setRankYoutube(n);
                    videokeyword.setYoutubeViewCount(n);//am9
                }
                if (!videokeyword.getDailymotionURL().equalsIgnoreCase(dailymotionurl)) {
                    videokeyword.setRankDailyMotion(n);
                    videokeyword.setDailymotionViewCount(n);//am10
                }
                if (!videokeyword.getVimeoURL().equalsIgnoreCase(vimeourl)) {
                    videokeyword.setRankVimeo(n);
                    videokeyword.setVimeoViewCount(n);//am11
                }
                if (!videokeyword.getMetacafeURL().equalsIgnoreCase(metacafeurl)) {
                    videokeyword.setRankMetacafe(n);
                    videokeyword.setMetacafeViewCount(n);//am12
                }
                if (!keyword.equalsIgnoreCase(videokeyword.getVideoKeyword())) {
                    videokeyword.setRankYoutube(n);
                    videokeyword.setYoutubeViewCount(n);//am13
                    videokeyword.setRankDailyMotion(n);
                    videokeyword.setDailymotionViewCount(n);//am14
                    videokeyword.setRankVimeo(n);
                    videokeyword.setVimeoViewCount(n);//am15
                    videokeyword.setRankMetacafe(n);
                    videokeyword.setMetacafeViewCount(n);//am16
                }
                videokeyword.setYoutubeURL(youtubeurl);
                videokeyword.setDailymotionURL(dailymotionurl);
                videokeyword.setVimeoURL(vimeourl);
                videokeyword.setMetacafeURL(metacafeurl);
                videokeyword.setVideoKeyword(keyword);
                getSession().update(videokeyword);
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException e) {
            l.error(e + "  " + e.getMessage());
            return 0;
        }
        if (foundKeyword == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * this method deletes the keyword
     *
     * @param keywordId
     * @param campaignId
     */
    @Override
    public void deleteVideoKeyword(Integer keywordId, Integer campaignId) {
        Videokeywords videokeyword = (Videokeywords) getSession().get(Videokeywords.class, keywordId);
        Campaigns campaign = (Campaigns) getSession().get(Campaigns.class, campaignId);
        Integer customerid = campaign.getCustomerID().getCustomerID();
        Customers customer = (Customers) getSession().get(Customers.class, customerid);
        try {
            videokeyword.setVisibility(Short.parseShort("0"));
            getSession().update(videokeyword);
            customer.setActiveVideoKeywordCount(customer.getActiveVideoKeywordCount() - 1);
            getSession().update(customer);
        } catch (NumberFormatException | DataAccessResourceFailureException | IllegalStateException | HibernateException e) {
            l.error(e + " " + e.getMessage());
        }
    }

    /**
     *
     * @param customerID
     * @return
     */
    @Override
    public List<Displaysettings> showCustomerSettings(Integer customerID) {

        String query = "FROM Displaysettings WHERE customerId = ?";
        List list = getHibernateTemplate().find(query, new Object[]{new Customers(customerID)});
        return list;
    }

    /**
     * this method runs only when a new keyword is entered. It fetches data from
     * SEM Rush for that keyword.
     *
     * @param keywrd
     * @param customerID
     * @param keyid
     * @param objCampaigns
     * @return
     * @throws IOException
     */
    public int insertIntoSeoDetails(Object keywrd, Integer customerID, Integer keyid, Campaigns objCampaigns) throws IOException {
        String keysem = "648ec3d46dbd48fb4a469dd08a6d2c41";
        //String keysem = "XXXXXXXXXXXXXXXXXXXXXXX";
        String keyword1 = keywrd.toString();
        String keyword = keyword1.replaceAll(" ", "+");

        String url1 = "http://us.api.semrush.com/?action=report&type=phrase_this&key=" + keysem + "&export=api&export_columns=Ph,Nq,Cp,Co,Nr&phrase=" + keyword;
        System.out.println(url1);
        //String input="Keyword;Search Volume;CPC;Competition;Number of Results search engine optimization;33100;17.41;0.92;111000000";
        String input = fetchSemrushPage(url1);
        System.out.println(input);
        if (input.contains("ERROR")) {
            Seokeyworddetails objSeokeyworddetails = new Seokeyworddetails();
            try {
                objSeokeyworddetails.setKeywordID(new Serpkeywords(keyid));
                objSeokeyworddetails.setCampaignID(objCampaigns);
                objSeokeyworddetails.setSearchVolume(0);
                objSeokeyworddetails.setGoogleCPC(0.0f);
                objSeokeyworddetails.setKeywordCompetition(0.0f);
                objSeokeyworddetails.setNumberofResult(Long.parseLong("0"));
                objSeokeyworddetails.setAddedDate(new Date());
                getHibernateTemplate().save(objSeokeyworddetails);
                System.out.println("--------------------------");
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return 0;
        } else {

            String[] domainsparts = input.split(";", 9);

            String Search_Volume = domainsparts[5];
            System.out.println("Search_Volume = " + Search_Volume);
            String cpc = domainsparts[6];
            System.out.println("cpc = " + cpc);
            String competitio = domainsparts[7];
            System.out.println("competitio = " + competitio);
            String Number_of_Results = domainsparts[8];
            System.out.println("Number_of_Results = " + Number_of_Results);

            Seokeyworddetails objSeokeyworddetails = new Seokeyworddetails();
            try {
                objSeokeyworddetails.setKeywordID(new Serpkeywords(keyid));
                objSeokeyworddetails.setCampaignID(objCampaigns);
                objSeokeyworddetails.setSearchVolume(Integer.parseInt(Search_Volume));
                objSeokeyworddetails.setGoogleCPC(Float.parseFloat(cpc));
                objSeokeyworddetails.setKeywordCompetition(Float.parseFloat(competitio));
                objSeokeyworddetails.setNumberofResult(Long.parseLong(Number_of_Results));
                objSeokeyworddetails.setAddedDate(new Date());
                getHibernateTemplate().save(objSeokeyworddetails);
                System.out.println("--------------------------");
            } catch (NumberFormatException | DataAccessException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    public static String fetchSemrushPage(String urlsrc) throws IOException {
        System.out.println("---------------Without Proxy-----------------");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String responseBody = "";
        try {
            HttpGet httpget = new HttpGet(urlsrc);

            System.out.println("executing request " + httpget.getURI());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status <= 600) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            responseBody = httpclient.execute(httpget, responseHandler);
            return responseBody;
        } catch (Exception e) {
            System.out.println("Exception in getting the sourec code from website :" + e);
        } finally {
            try {
                httpclient.close();
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        }

        return responseBody;
    }

    @Override
    public List<Serpkeywordgoal> getChartGoalData(Integer keywordId) {
        List<Serpkeywordgoal> goallist;
        List<Serpkeywordgoal> lstGoal = new ArrayList<>();

        //Serpkeywords objSerpkeywords = (Serpkeywords) getSession().get(Serpkeywords.class, keywordId);
        // List<Videokeywords> keywords=new ArrayList(objCampaigns.getVideokeywordsCollection());
        String query = "from Serpkeywordgoal where serpKeywordId = ? ";
        goallist = getHibernateTemplate().find(query, new Object[]{new Serpkeywords(keywordId)});
        lstGoal.addAll(goallist);

        return lstGoal;

    }

    @Override
    public List<Globustrackerevents> getChartEventData() {
        List<Globustrackerevents> eventlist;
        List<Globustrackerevents> lstEvent = new ArrayList<>();

        String query = "from Globustrackerevents";
        eventlist = getHibernateTemplate().find(query);
        lstEvent.addAll(eventlist);

        return lstEvent;

    }

    @Override
    public int setSerpsKeywordGoal(Integer keywordId, Integer goalRank, String dategoal) {

        try {
            Serpkeywordgoal serpkeygoal = new Serpkeywordgoal();
            serpkeygoal.setSerpKeywordId(keywordId);
            serpkeygoal.setGoalRank(goalRank.shortValue());
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date result = df.parse(dategoal);
            System.out.println(result);
            serpkeygoal.setGoalDate(result);
            serpkeygoal.setAddedDate(new Date());
            getHibernateTemplate().save(serpkeygoal);

        } catch (ParseException | DataAccessException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public List<Integer> getCampaignChartData(Integer campaignId) {
        List<Integer> keyid = new ArrayList<>();
        List<Serpkeywords> lserpkey;
        lserpkey = getHibernateTemplate().find("FROM Serpkeywords where CampaignID=? and visibility = 1", new Object[]{campaignId});
        Iterator ittr = lserpkey.iterator();
        while (ittr.hasNext()) {
            Serpkeywords keyobj = (Serpkeywords) ittr.next();
            Integer keywordId = keyobj.getKeywordID();
            keyid.add(keywordId);
        }
        return keyid;
    }

    @Override
    public String getKeywordName(Integer keywordID) {
        String keyword = null;
        List<Serpkeywords> lserp = getHibernateTemplate().find("FROM Serpkeywords where keywordId=?", new Object[]{keywordID});
        Iterator ittr = lserp.iterator();
        while (ittr.hasNext()) {
            Serpkeywords keyobj = (Serpkeywords) ittr.next();
            keyword = keyobj.getKeyword();
        }
        return keyword;
    }

    @Override
    public int addUrl(Integer campaignID, String url) {
        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignID);
        Socialsignalurls objUrl = null;
        //now retrieving <customerID> from <objCampaigns> object
        Integer customerID = objCampaigns.getCustomerID().getCustomerID();
        System.out.println("CampaignID = >>>>>>>>>>>>>>>>" + campaignID);
        System.out.println("CustomerID = >>>>>>>>>>>>>>>>" + customerID);
        //now retrieving the <objCustomer> object for <customerID>
        Collection<Socialsignalurls> objSocialsignalurlses = objCampaigns.getSocialsignalurlsCollection();
        // Set<Serpkeywords> setkeywords = new HashSet<Serpkeywords>();
        Customers objCustomer = (Customers) getSession().get(Customers.class, customerID);

        if (objSocialsignalurlses.isEmpty()) {
            try {
                objUrl = new Socialsignalurls();
                objUrl.setSocialSignalUrl(url);
                objUrl.setCampaignID(new Campaigns(campaignID));
                objUrl.setFacebookLike(0);
                objUrl.setFacebookShare(0);
                objUrl.setGooglePlusLikes(0);
                objUrl.setLinkedInShares(0);
                objUrl.setPinterestPins(0);
                objUrl.setRedittVotes(0);
                objUrl.setStumbleUponLikes(0);
                objUrl.setTweetCount(0);
                objUrl.setVisibility(1);
                getHibernateTemplate().save(objUrl);
                //increasing the active keyword count by 1
                objCustomer.setActiveKeywordCount(objCustomer.getActiveKeywordCount() + 1);
                //saving the objCustomer object
                getSession().update(objCustomer);
            } catch (DataAccessException | NumberFormatException | IllegalStateException | HibernateException e) {
                l.error(e + " " + e.getMessage());
                e.printStackTrace();
            }
            return 1;
        } else {
            try {

                //checking for domain value of the url from already added url ,
                //if domain matches then we will add this url otherwise return 0
//                boolean match = checkUrlHost(url, objCampaigns);
//                if (!match) {
//                    return 0;
//                }
                //now check for : url already exist in the same campaign
                //if yes and visibility is 0 then make it visible i.e visibility=1
                //if yes and visibility is 1 then skip loop
                for (Socialsignalurls objUrls : objSocialsignalurlses) {
                    if (objUrls.getSocialSignalUrl().equalsIgnoreCase(url)) {
                        if (objUrls.getVisibility() == 1) {
                            return 2;
                        } else if (objUrls.getVisibility() == 0) {
                            objUrls.setVisibility(1);
                            getSession().update(objUrls);

                            //now have to increase active keyword count
                            objCustomer.setActiveKeywordCount(objCustomer.getActiveKeywordCount() + 1);
                            getSession().save(objCustomer);
                            return 1;
                        }
                    }
                }
                objUrl = new Socialsignalurls();
                objUrl.setSocialSignalUrl(url);
                objUrl.setCampaignID(new Campaigns(campaignID));
                objUrl.setFacebookLike(0);
                objUrl.setFacebookShare(0);
                objUrl.setGooglePlusLikes(0);
                objUrl.setLinkedInShares(0);
                objUrl.setPinterestPins(0);
                objUrl.setRedittVotes(0);
                objUrl.setStumbleUponLikes(0);
                objUrl.setTweetCount(0);
                objUrl.setVisibility(1);
                getHibernateTemplate().save(objUrl);
                //increasing the active keyword count by 1
                objCustomer.setActiveKeywordCount(objCustomer.getActiveKeywordCount() + 1);
                //saving the objCustomer object
                getSession().update(objCustomer);
            } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
                l.error(ex + "  " + ex.getMessage());
            }
            return 1;
        }
    }

    private boolean checkUrlHost(String url, Campaigns objCampaigns) {

        //this method recieves the url and objCampaigns object
        //and find out <url> domains and domain added in <objCampaigns> object
        //if match found then return true
        //else return false
        boolean b = true;
        String checkurl = "";
        String matchUrl = url;
        String checkHost = null;
        String matchHost = null;
        try {
            List<Socialsignalurls> lstUrl = new ArrayList<>(objCampaigns.getSocialsignalurlsCollection());
            checkurl = lstUrl.get(0).getSocialSignalUrl();
            Iterator itr = lstUrl.iterator();
            while (itr.hasNext()) {
                Socialsignalurls ssurls = (Socialsignalurls) itr.next();
                if (ssurls.getVisibility() == 1) {
                    checkurl = checkurl.replace("http://", "").replace("https://", "").replace("www.", "");
                    matchUrl = matchUrl.replace("http://", "").replace("https://", "").replace("www.", "");
                    checkurl = "http://" + checkurl;
                    matchUrl = "http://" + matchUrl;
                    checkHost = new URL(checkurl).getHost();
                    matchHost = new URL(matchUrl).getHost();
                    if (!checkHost.equals(matchHost)) {
                        b = false;
                        break;
                    }
                }
            }
        } catch (Exception ex) {
            l.error(ex + "  " + ex.getMessage());
            Logger.getLogger(KeywordsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    @Override
    public List<KeywordsLastUpdatedForm> getSocialSignalData(Integer campaignId) {
        //invoking the getSession() method to retrieve object of Campaigns class for <campaignId>
        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignId);
        if (objCampaigns == null) {
            return new ArrayList<>();
        } else {

            List<KeywordsLastUpdatedForm> ssData = new ArrayList<>();
            Collection<Socialsignalurls> ssUrlList = objCampaigns.getSocialsignalurlsCollection();
            for (Socialsignalurls urls : ssUrlList) {
                try {
                    // Socialsignalurls urls = (Socialsignalurls) getSession().get(Socialsignalurls.class, ssUrl.getCampaignID());
                    if (urls.getVisibility() == 1) {
                        KeywordsLastUpdatedForm ssObj = new KeywordsLastUpdatedForm();
                        ssObj.setSocialSignalUrlID(urls.getSocialSignalUrlID());
                        ssObj.setSocialSignalUrl(urls.getSocialSignalUrl());
                        ssObj.setFacebookLike(urls.getFacebookLike());
                        ssObj.setFacebookShare(urls.getFacebookShare());
                        ssObj.setTweetCount(urls.getTweetCount());
                        ssObj.setPinterestPins(urls.getPinterestPins());
                        ssObj.setGooglePlusLikes(urls.getGooglePlusLikes());
                        ssObj.setLinkedInShares(urls.getLinkedInShares());
                        ssObj.setRedittVotes(urls.getRedittVotes());
                        ssObj.setStumbleUponLikes(urls.getStumbleUponLikes());
                        ssData.add(ssObj);
                    }
                } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException e) {
                    e.printStackTrace();
                }
            }
            return ssData;
        }
    }
    
    @Override
    public int editUrl(Integer urlID, String url, Integer campaignID) {
        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignID);
        Socialsignalurls objUrl = (Socialsignalurls) getSession().get(Socialsignalurls.class, urlID);
        Collection<Socialsignalurls> objSocialsignalurlses = objCampaigns.getSocialsignalurlsCollection();
        for (Socialsignalurls objUrls : objSocialsignalurlses) {
            if (objUrls.getSocialSignalUrl().equalsIgnoreCase(url) && !urlID.equals(objUrls.getSocialSignalUrlID())) {
                if (objUrls.getVisibility() == 1) {
                    return 2;
                }
            }
        }
        try {
            if (!objUrl.getSocialSignalUrl().equalsIgnoreCase(url)) {
                objUrl.setSocialSignalUrl(url);
                objUrl.setFacebookLike(0);
                objUrl.setFacebookShare(0);
                objUrl.setGooglePlusLikes(0);
                objUrl.setLinkedInShares(0);
                objUrl.setPinterestPins(0);
                objUrl.setRedittVotes(0);
                objUrl.setStumbleUponLikes(0);
                objUrl.setTweetCount(0);
                getSession().update(objUrl);
            }
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
            return 0;
        }
        return 1;
    }

    /**
     * The method deletes a Url
     *
     * @param urlID
     */
    @Override
    public void deleteUrl(Integer urlID, Integer campaignID) {

        Socialsignalurls objUrl = (Socialsignalurls) getSession().get(Socialsignalurls.class, urlID);

        //invoking the getSession() method to retrieve object of Campaigns class for <campaignId>
        Campaigns objCampaigns = (Campaigns) getSession().get(Campaigns.class, campaignID);

        try {
            //to delete a keyword use the visibility factor as 0
            objUrl.setVisibility(0);

            //now invoking the getSession()
            getSession().update(objUrl);
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
        }

        //now decreasing the active keyword count by 1 for <customerID>
        Integer customerID = objCampaigns.getCustomerID().getCustomerID();
        Customers objCustomer = (Customers) getSession().get(Customers.class, customerID);
        try {
            objCustomer.setActiveKeywordCount(objCustomer.getActiveKeywordCount() - 1);
            getSession().save(objCustomer);
        } catch (DataAccessResourceFailureException | IllegalStateException | HibernateException ex) {
            l.error(ex + "  " + ex.getMessage());
        }
    }
}
