/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.action;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.webmasters.Webmasters;
import com.google.api.services.webmasters.model.ApiDataRow;
import com.google.api.services.webmasters.model.SearchAnalyticsQueryRequest;
import com.google.api.services.webmasters.model.SearchAnalyticsQueryResponse;
import com.google.api.services.webmasters.model.SitemapsListResponse;
import com.google.api.services.webmasters.model.SitesListResponse;
import com.google.api.services.webmasters.model.UrlCrawlErrorCount;
import com.google.api.services.webmasters.model.UrlCrawlErrorCountsPerType;
import com.google.api.services.webmasters.model.UrlCrawlErrorsCountsQueryResponse;
import com.google.api.services.webmasters.model.UrlCrawlErrorsSample;
import com.google.api.services.webmasters.model.UrlCrawlErrorsSamplesListResponse;
import com.google.api.services.webmasters.model.WmxSite;
import com.google.api.services.webmasters.model.WmxSitemap;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;
import ranktracker.dao.WebmasterDaoImpl;
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
public class WebmastersAction extends ActionSupport {
    
    HttpSession session;
    private HttpServletRequest request;
    private HttpServletResponse response;
    WebmasterDaoImpl dao = new WebmasterDaoImpl();

//    ***********************Localhost API Credidentials************************
    private static final String CLIENT_ID = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    private static final String CLIENT_SECRET = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    private static final String REDIRECT_URI = "http://localhost:8087/oauth2callback.action";
    private static final String OAUTH_SCOPE = "https://www.googleapis.com/auth/webmasters.readonly";
    
    public void webmaster()
            throws Exception {
        request = ServletActionContext.getRequest();
        response = ServletActionContext.getResponse();
        session = request.getSession();

        Integer customerID = (Integer) session.getAttribute("customerID");
        List<String> webmasterUrlLIst = dao.getWebmasterUrls(customerID);

        if (webmasterUrlLIst.isEmpty()) {
            try {
                //TODO: if already have a valid access token, no need to redirect, just login
                response.sendRedirect("https://accounts.google.com/o/oauth2/auth?access_type=online&approval_prompt=auto&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&response_type=code&scope=" + OAUTH_SCOPE);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("" + e);
            }
        } else {
            response.sendRedirect("http://localhost:8087/oauth2callback.action?code=dummy");
        }
    }

    public void refreshData()
            throws Exception {

        try {
            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();
            session = request.getSession();

            Integer customerID = (Integer) session.getAttribute("customerID");
            List<String> webmasterUrlLIst = dao.getWebmasterUrls(customerID);

            for (String webmasterUrl : webmasterUrlLIst) {
                dao.deleteOldData(webmasterUrl);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        try {
            //TODO: if already have a valid access token, no need to redirect, just login
            response.sendRedirect("https://accounts.google.com/o/oauth2/auth?access_type=online&approval_prompt=auto&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&response_type=code&scope=" + OAUTH_SCOPE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String signupAccessCode() throws Exception {

        request = ServletActionContext.getRequest();
        response = ServletActionContext.getResponse();
        session = request.getSession();

        String code = request.getParameter("code");
        request = ServletActionContext.getRequest();
        System.out.println("code : " + code);

        Integer customerID = (Integer) session.getAttribute("customerID");

        if (!code.equals("dummy")) {

            HttpTransport httpTransport = new NetHttpTransport();
            JsonFactory jsonFactory = new JacksonFactory();

            GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                    httpTransport, jsonFactory, CLIENT_ID, CLIENT_SECRET, Arrays.asList(OAUTH_SCOPE))
                    .setAccessType("online")
                    .setApprovalPrompt("auto").build();

            try {
                GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
                GoogleCredential credential = new GoogleCredential().setFromTokenResponse(response);

                // Create a new authorized API client
                Webmasters service = new Webmasters.Builder(httpTransport, jsonFactory, credential)
                        .setApplicationName("WebmastersController")
                        .build();

                Webmasters.Searchanalytics searchAnalytics = service.searchanalytics();

//                Webmasters.Sitemaps sitesMaps = service.sitemaps();
                List<String> verifiedSites = new ArrayList<String>();
                Webmasters.Sites.List webmasterRequest = service.sites().list();
                // Get all sites that are verified
                SitesListResponse siteList = webmasterRequest.execute();

                List<Webmasterurl> webmasterUrlList = new ArrayList<>();

                for (WmxSite currentSite : siteList.getSiteEntry()) {
                    Webmasterurl url = new Webmasterurl();
                    url.setUrl(currentSite.getSiteUrl());
                    url.setCustomerId(customerID);
                    webmasterUrlList.add(url);
                    verifiedSites.add(currentSite.getSiteUrl());
                }
                dao.saveWebmasterUrls(webmasterUrlList);

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date endDate1 = new Date();
                DateTime dateTime = new DateTime();
                Date startDate1 = dateTime.minusDays(30).toDate();
                String startDate = formatter.format(startDate1);
                String endDate = formatter.format(endDate1);
            // Print all verified sites

                //looping to store graph data. 
                for (String siteUrl : verifiedSites) {
                    try {
//***************************Code for Crawl Errors & Status*********************
                        try {
                            Webmasters.Urlcrawlerrorscounts urlCrawlerrorsCount = service.urlcrawlerrorscounts();
                            Webmasters.Urlcrawlerrorscounts.Query q1 = urlCrawlerrorsCount.query(siteUrl);
                            UrlCrawlErrorsCountsQueryResponse count = q1.execute();
//                            System.out.println("-----Crawl Erros & Status----- > >  Site Url : " + q1.getSiteUrl());
                            System.out.println(count.getCountPerTypes());
                            List<Webmastercrawlerrorscount> errorcountList = new ArrayList<>();
                            List<UrlCrawlErrorCountsPerType> perType = count.getCountPerTypes();
                            for (UrlCrawlErrorCountsPerType type : perType) {
                                Webmastercrawlerrorscount errorcountEntity = new Webmastercrawlerrorscount();
                                List<UrlCrawlErrorCount> c = type.getEntries();

                                String platform = type.getPlatform();
                                String category = type.getCategory();
//                                System.out.println("1. PlatForm  : " + platform);
//                                System.out.println("2. Category  : " + category);
                                for (UrlCrawlErrorCount c1 : c) {
//                                    System.out.println("3. Count     : " + c1.getCount());
                                    errorcountEntity.setCount(c1.getCount());
//                                    System.out.println("4. TimeStamp : " + c1.getTimestamp());
                                    String date = c1.getTimestamp().toString();
                                    Date stringdate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                                    errorcountEntity.setDatestring(stringdate);
                                }
                                errorcountEntity.setSiteurl(q1.getSiteUrl());
                                errorcountEntity.setPlatform(platform);
                                errorcountEntity.setCategory(category);

                                errorcountList.add(errorcountEntity);
                            }
                            dao.saveWebmasterCrawlErrorsCount(errorcountList);
                        } catch (Exception e) {
                        }
//********************** Code for  URL Crawl Errors Samples ********************
                        try {
                            Webmasters.Urlcrawlerrorssamples urlCrawlErrorSamples = service.urlcrawlerrorssamples();
                            Webmasters.Urlcrawlerrorssamples.List q2 = urlCrawlErrorSamples.list(siteUrl, "serverError", "web");
                            UrlCrawlErrorsSamplesListResponse count1 = q2.execute();
                            List<Webmastercrawlerrorssamples> errorsamplesList = new ArrayList<>();
                            List<UrlCrawlErrorsSample> count2 = count1.getUrlCrawlErrorSample();
                            System.out.println("----Crawl Errors Samples---- > > Site Url : " + q2.getSiteUrl());
                            for (UrlCrawlErrorsSample count21 : count2) {
                                Webmastercrawlerrorssamples errorsamplesEntity = new Webmastercrawlerrorssamples();
                                System.out.println("1.Page URL       : " + count21.getPageUrl());
                                System.out.println("2.Last Crawled   : " + count21.getLastCrawled());
                                System.out.println("3.First Detected : " + count21.getFirstDetected());
                                System.out.println("4.Response Code  : " + count21.getResponseCode());

                                errorsamplesEntity.setPageurl(count21.getPageUrl());
                                errorsamplesEntity.setSiteurl(q2.getSiteUrl());

                                String lastCrawl = count21.getLastCrawled().toString();
                                Date crawldate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawl);
                                errorsamplesEntity.setLastcrawled(crawldate);

                                String firstDetect = count21.getFirstDetected().toString();
                                Date detectdate = new SimpleDateFormat("yyyy-MM-dd").parse(firstDetect);
                                errorsamplesEntity.setFirstdetected(detectdate);

                                errorsamplesEntity.setResponsecode(count21.getResponseCode());

                                errorsamplesList.add(errorsamplesEntity);
                            }

                            dao.saveWebmasterCrawlErrorsSamples(errorsamplesList);
                        } catch (Exception e) {
                        }
//*******************************Code for Sitemaps******************************  
                        Webmasters.Sitemaps sitesMaps = service.sitemaps();
                        Webmasters.Sitemaps.List q = sitesMaps.list(siteUrl);
                        SitemapsListResponse co = q.execute();
                        List<WmxSitemap> pertype = co.getSitemap();
                        List<Webmastersitemap> sitemapList = new ArrayList<>();
                        for (WmxSitemap pertype1 : pertype) {
                            try {
                                Webmastersitemap sitemapEntity = new Webmastersitemap();
                                pertype1.getPath();
                                pertype1.getLastSubmitted();
                                pertype1.getType();
                                pertype1.getLastDownloaded();
                                pertype1.getErrors();
                                pertype1.getWarnings();

                                System.out.println("1. Indexed         : " + pertype1.getContents().get(0).getIndexed());
                                System.out.println("2. Submitted       : " + pertype1.getContents().get(0).getSubmitted());
                                System.out.println("3. Type            : " + pertype1.getContents().get(0).getType());
                                System.out.println("4. Path            : " + pertype1.getPath());
                                System.out.println("5. Last Submitted  : " + pertype1.getLastSubmitted());
                                System.out.println("6. Typemap         : " + pertype1.getType());
                                System.out.println("7. Last Downloaded : " + pertype1.getLastDownloaded());
                                System.out.println("8. Errors          : " + pertype1.getErrors());
                                System.out.println("9. Warning         : " + pertype1.getWarnings());
                                System.out.println("10. Site Url       : " + pertype1.getPath().replace("sitemap.xml", ""));

                                sitemapEntity.setIndexed(pertype1.getContents().get(0).getIndexed());
                                sitemapEntity.setSubmitted(pertype1.getContents().get(0).getSubmitted());
                                sitemapEntity.setType(pertype1.getContents().get(0).getType());
                                sitemapEntity.setPath(pertype1.getPath());

                                String dates = pertype1.getLastSubmitted().toString();
                                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dates);
                                sitemapEntity.setLastsubmitteddate(date);

                                sitemapEntity.setTypemap(pertype1.getType());

                                String dates1 = pertype1.getLastDownloaded().toString();
                                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dates1);
                                sitemapEntity.setLastdownloadeddate(date1);
                                System.out.println("------------DATE---------------" + date1);

                                sitemapEntity.setErrors(pertype1.getErrors());
                                sitemapEntity.setWarning(pertype1.getWarnings());

                                sitemapEntity.setSiteurl(pertype1.getPath().replace("sitemap.xml", ""));

                                sitemapList.add(sitemapEntity);

                            } catch (Exception e) {
                            }

                        }
                        dao.saveWebmasterSiteMap(sitemapList);
//************************Code for Google Search Analytics**********************
                        SearchAnalyticsQueryRequest analyticRequest = new SearchAnalyticsQueryRequest();
                        analyticRequest.setStartDate(startDate);
                        analyticRequest.setEndDate(endDate);
                        analyticRequest.setSearchType("web");
                        List<String> dimensions = new ArrayList<>();
                        dimensions.add("date");
//                      dimensions.add("query");
                        analyticRequest.setAggregationType("byProperty");
                        analyticRequest.setDimensions(dimensions);

                        Webmasters.Searchanalytics.Query query = searchAnalytics.query(siteUrl, analyticRequest);

                        SearchAnalyticsQueryResponse response1 = query.execute();
                        List<ApiDataRow> list = response1.getRows();
                        List<Webmastergraph> graphList = new ArrayList<>();
                        if (!list.isEmpty()) {
                            for (ApiDataRow row : list) {
                                Webmastergraph graphEntity = new Webmastergraph();
                                Double ctr = Double.parseDouble(new DecimalFormat("#.##").format(row.getCtr()));
                                Double position = Double.parseDouble(new DecimalFormat("#.##").format(row.getPosition()));
                                graphEntity.setSiteurl(siteUrl);
                                graphEntity.setClicks(row.getClicks());
                                graphEntity.setCtr(ctr);
                                graphEntity.setImpression(row.getImpressions());
                                graphEntity.setPosition(position);
                                graphEntity.setDatestring(row.getKeys().get(0));
                                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(row.getKeys().get(0));
                                graphEntity.setDate(date);
                                graphList.add(graphEntity);
                            }
                            dao.saveGraphData(graphList);
                        }
                    } catch (Exception e) {
//                        e.printStackTrace();
                    }
                }

                //looping to store query data. 
                for (String siteUrl : verifiedSites) {
                    try {
                        SearchAnalyticsQueryRequest analyticRequest = new SearchAnalyticsQueryRequest();
                        analyticRequest.setStartDate(startDate);
                        analyticRequest.setEndDate(endDate);
                        analyticRequest.setSearchType("web");
                        List<String> dimensions = new ArrayList<>();
//                      dimensions.add("date");
                        dimensions.add("query");
                        analyticRequest.setAggregationType("byProperty");
                        analyticRequest.setDimensions(dimensions);

                        Webmasters.Searchanalytics.Query query = searchAnalytics.query(siteUrl, analyticRequest);

                        SearchAnalyticsQueryResponse response1 = query.execute();
                        List<ApiDataRow> list = response1.getRows();
                        List<Webmasterquery> queryList = new ArrayList<>();
                        if (!list.isEmpty()) {
                            for (ApiDataRow row : list) {
                                try {
                                    Webmasterquery queryEntity = new Webmasterquery();
                                    Double ctr = Double.parseDouble(new DecimalFormat("#.##").format(row.getCtr()));
                                    Double position = Double.parseDouble(new DecimalFormat("#.##").format(row.getPosition()));

                                    queryEntity.setSiteurl(siteUrl);
                                    queryEntity.setClicks(row.getClicks());
                                    queryEntity.setCtr(ctr);
                                    queryEntity.setImpression(row.getImpressions());
                                    queryEntity.setPosition(position);
                                    queryEntity.setQuery(row.getKeys().get(0));
                                    queryList.add(queryEntity);

                                    queryList.add(queryEntity);
                                } catch (Exception e) {
                                }
                            }
                        }
                        dao.saveQueries(queryList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {

            }
        } else {
        }

        List<String> webmasterUrlLIst = dao.getWebmasterUrls(customerID);
        System.out.println(webmasterUrlLIst.size());
        session.setAttribute("sitelist", webmasterUrlLIst);

        return "success";

    }

    public void webmasterSiteGraphData() throws JSONException {

        try {
            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();
            session = request.getSession();

            String domain = request.getParameter("domainName");
            JSONObject obj = new JSONObject();
            System.out.println("passed domain  " + domain);

            List<Webmastergraph> graphlist = dao.getGraphData(domain);
            System.out.println(graphlist.size());
            obj.put("graphlist", graphlist);

            List<Webmasterquery> querylist = dao.getQueryData(domain);
            System.out.println(querylist.size());
            System.out.println("----------=============----------------"+querylist.get(1).getQuery());
            
            
            obj.put("querylist", querylist);

            System.out.println(obj.toString());
            System.out.println("response" + response);

            response.setContentType("text");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write(obj.toString());
        } catch (Exception e) {
            System.out.println("webmasterSiteGraphData : " + e);
        }
    }

    public void webmasterSiteMapData()
            throws Exception {
        try {
            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();
            session = request.getSession();

            String domain = request.getParameter("domain");
            JSONObject obj = new JSONObject();
            System.out.println("passed domain  " + domain);

            List<Webmastersitemap> sitemaplist = dao.getSiteMapData(domain);
            System.out.println("Size : " + sitemaplist.size());
            obj.put("sitemaplist", sitemaplist);

            response.setContentType("text");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write(obj.toString());
        } catch (Exception e) {
            System.out.println("webmasterSiteMapData : " + e);
        }
    }

    public void webmasterCrawlErrorCountData()
            throws Exception {
        try {
            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();
            session = request.getSession();

            String domain = request.getParameter("domain");
            JSONObject obj = new JSONObject();
            System.out.println("passed domain  " + domain);

            List<Webmastercrawlerrorscount> errorcountlist = dao.getCrawlErrorCountData(domain);
            System.out.println("Size : " + errorcountlist.size());
            obj.put("errorcountlist", errorcountlist);

            System.out.println(obj);

            response.setContentType("text");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write(obj.toString());
        } catch (Exception e) {
            System.out.println("webmasterCrawlErrorCountData : " + e);
        }
    }

    public void webmasterCrawlErrorSamplesData()
            throws Exception {
        try {
            request = ServletActionContext.getRequest();
            response = ServletActionContext.getResponse();
            session = request.getSession();

            String domain = request.getParameter("domain");
            JSONObject obj = new JSONObject();
            System.out.println("passed domain  " + domain);

            List<Webmastercrawlerrorssamples> errorsampleslist = dao.getCrawlErrorSamplesData(domain);
            System.out.println("Size : " + errorsampleslist.size());
            obj.put("errorsampleslist", errorsampleslist);
            obj.put("pageurlsize", errorsampleslist.size());

            response.setContentType("text");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write(obj.toString());
        } catch (Exception e) {
            System.out.println("webmasterCrawlErrorSamplesData : " + e);
        }
    }

    public WebmasterDaoImpl getDao() {
        return dao;
    }

    public void setDao(WebmasterDaoImpl dao) {
        this.dao = dao;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

}
