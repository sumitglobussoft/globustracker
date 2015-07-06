package ranktracker.crawler.google;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.utility.FetchPage;
import ranktracker.utility.FetchPageHttpClient;
import ranktracker.utility.ThreadCreator_google;
import ranktracker.to.DetailsTO;
import ranktracker.utility.ReplaceAllHtmlTags;

/**
 * The crawler class get Google search web rank for a given keyword, url
 * combination.
 *
 * @author Anshuman
 */
public class NewWebRankGoogle extends Thread {

    static Logger l = Logger.getLogger(NewWebRankGoogle.class.getName());
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;
    /**
     * bestMatchLinkGoogle The best match link for a given keyword
     */
    private String bestMatchLinkGoogle = "";
    /**
     * bestMatchRankGoogle The best match rank for a given keyword
     */
    private Integer bestMatchRankGoogle = 0;
    /**
     * objProxyDao The database layer ProxyDao object variable
     */
    private ProxyDao objProxyDao;
    /**
     * iCrawled integer variable for checking that atleast one parser has
     * crawled the data if 0 then re-request for page source
     */
    public int isCrawled;
    private FetchPage objClient;
    private DetailsTO dto;
    // variable to check whether rank is found or not found 
    boolean doneWithKeyword = false;
    // variable for storing position of pointer  of crawled data count  
    int count = 0;
     boolean b = false;
    
     // tracking scrapped url for testing purposes
     private String scrapedUrl=null;
    /**
     * Constructor to set all the variables
     *
     *
     * @param lstKeywords
     * @param appContext
     *
     *
     */
    public NewWebRankGoogle(ApplicationContext appContext) {


        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.objProxyDao = appContext.getBean("objProxyDao", ProxyDao.class);


       
    }

    /**
     * This method makes a search query call to google website, gets the
     * pagesource of results page, parses the pagesource, matches given domain
     * to extracted domain, if match is found, the result counter is returned as
     * rank. If a matching domain is found prior to exact match of url, the
     * results counter is stored as best match.
     *
     * @param domain
     * @param keyword
     * @return Integer
     */
    public Integer getNewWebRankGoogle(String domain, String keyword, String linkGoogle) throws Exception {
        objClient = new FetchPageHttpClient();                            // singleton removed


        System.out.println("just Started  getNewWebRankGoogle() method ");
        System.out.println("handling keyword : " + keyword);

        String searchKeyword = keyword.replace(" ", "+");
        System.out.println("modified keyword : " + searchKeyword);
        String matchUrl = domain;
        matchUrl = matchUrl.replace("www.", "").trim();

        String matchHost = "";
        try {
            String tempMatchUrl = "";
            tempMatchUrl = "http://" + matchUrl;
            System.out.println("tempMatchUrl = " + tempMatchUrl);
            URL matchLink = new URL(tempMatchUrl);
            System.out.println("matchLink = " + matchLink);
            matchHost = matchLink.getHost();
            System.out.println("matchHost = " + matchHost);
            matchHost = matchHost.replace("www.", "").trim();
            System.out.println("matchHost = " + matchHost);
        } catch (Exception e) {
            e.printStackTrace();
            l.debug(e + "  " + e.getMessage() + " Exception come for keyword " + keyword + " Domain" + domain);
        }
        bestMatchLinkGoogle = "";
        bestMatchRankGoogle = 0;

        if (linkGoogle.isEmpty()) {
            linkGoogle = "google.com";
        }
//        boolean foundFlag = false;
        int c = 0;
        try {
//            for (int j = count; j < count; j++) {
//                if (foundFlag) {
//                    break;
//                }

            isCrawled = 0;
            do {   // while (isCrawled == 0);     implimented to enshure any one of the parsers hava extracted the data
                String temp = "";
                count=dto.getCrawlCount();
                int argumentForPageNo = count;
                if(argumentForPageNo==0)argumentForPageNo=1;
                String url = "https://www." + linkGoogle + "/search?output=search&q=" + searchKeyword + "&start=" + argumentForPageNo+"&num=100";
                // new search url structure https ://www.google.com/?gws_rd=cr&ei=5LRPUrrVComOrQf5voCgCQ#q=cell+phone as on 5/10/2013
                System.out.println("url = " + url);

                try {
                    String detail = null;
                    String web_page = null;
                    String scrapedUrl = null;


                    web_page = objClient.fetchPageSourceString_Get(url, linkGoogle, argumentForPageNo / 10 + 1);


                    isCrawled = 0;
/////////////////////////////////////////First Parser ( general pc )

                    Pattern pattern = Pattern.compile("data-hveid(.*?)href(.*?)onmousedown", Pattern.DOTALL);
                    Matcher matcher = pattern.matcher(web_page);

                    while (matcher.find()) {
                        isCrawled = 1;
                        if (doneWithKeyword) {
                            break;
                        }

                        detail = matcher.group(2);
                        detail = detail.replace("\\\\x3d", "");
                        detail = detail.replace("\\\\x22", "");
                        detail = detail.replace("=\"", "");
                        detail = detail.replace("\"", "");
                        detail = detail.substring(0, detail.length() - 1);

                        if (doneWithKeyword) {
                            break;
                        }

                        count++;
                        c++;
                        //pattern matcher for scrapedUrl
                        scrapedUrl = detail;
                        scrapedUrl = ReplaceAllHtmlTags.GetOnlyData(scrapedUrl);
                        URL scrapedLink = null;
                        String escapedUrl = scrapedUrl;
                        if (scrapedUrl.contains("https://") || scrapedUrl.contains("http://")) {
                            scrapedLink = new URL(scrapedUrl);
                            escapedUrl = escapedUrl.replace("https://", "");
                            escapedUrl = escapedUrl.replace("http://", "");
                        } else {
                            scrapedLink = new URL("http://" + scrapedUrl);
                        }

                        //remove last "/" from scrapedUrl

                        if (scrapedUrl.endsWith("/")) {
                            scrapedUrl = scrapedUrl.substring(0, scrapedUrl.length() - 1);
                        }

                        escapedUrl = escapedUrl.replace("www.", "").trim();
                        if (escapedUrl.endsWith("/")) {

                            escapedUrl = escapedUrl.substring(0, escapedUrl.length() - 1).trim();
                        }
                        String scrappedHost = null;

                        scrappedHost = scrapedLink.getHost().trim();
                        scrappedHost = scrappedHost.replace("www.", "").trim();

                        if (scrappedHost != null && !scrappedHost.isEmpty()) {
                            
                            System.out.println(count + " our url:        " + matchHost + "       found url       " + scrappedHost  );
                            if (matchHost.equalsIgnoreCase(scrappedHost)) {
                                System.out.println("+++++++++++++++++++++++++++++++++++Match found");
                                doneWithKeyword = true;
                                scrapedUrl = scrapedUrl.replace("/m.", "/");
                                scrapedUrl = scrapedUrl.replace("http://", "");
                                scrapedUrl = scrapedUrl.replace("https://", "");
                                bestMatchLinkGoogle = scrapedUrl;                                
                                bestMatchRankGoogle = count;
                                if (matchUrl.equalsIgnoreCase(escapedUrl)) {
                                    doneWithKeyword = true;

                                } else {
                                    if (!b) {
                                        b = true;

                                    }
                                }
                            }
                        }

                    }
////////////////////////////////////////////////////////second parser(apple web kit)
                    if (isCrawled == 0) {
                        pattern = Pattern.compile("class=\"r\"><a href=\"(.*?)\"", Pattern.DOTALL);
                        matcher = pattern.matcher(web_page);
                        while (matcher.find()) {
                            isCrawled = 1;
                            if (doneWithKeyword) {
                                break;
                            }


                            detail = matcher.group(1);
                            scrapedUrl = ReplaceAllHtmlTags.GetOnlyData(scrapedUrl);
                            count++;
                            c++;
                            //pattern matcher for scrapedUrl
                            scrapedUrl = detail;
                            URL scrapedLink = null;
                            String escapedUrl = scrapedUrl;
                            if (scrapedUrl.contains("https://") || scrapedUrl.contains("http://")) {
                                escapedUrl = escapedUrl.replace("/m.", "/");

////                                escapedUrl = escapedUrl.replace("/url?q=", "");
                                scrapedUrl = scrapedUrl.replace("(.*?)q=", "");
                                scrapedUrl = scrapedUrl.replace("/url?q=", "");
                                scrapedUrl = scrapedUrl.replace("/url?url=", "");
                                
                                try{
                                    
                                this.scrapedUrl=scrapedUrl;
                                scrapedLink = new URL(scrapedUrl);
                                
                                }catch(Exception e){e.printStackTrace();}
                                
                                escapedUrl = escapedUrl.replace("https://", "");
                                escapedUrl = escapedUrl.replace("http://", "");
                            } else {
                                scrapedLink = new URL("http://" + scrapedUrl);
                            }


                            //remove last "/" from scrapedUrl

                            if (scrapedUrl.endsWith("/")) {
                                scrapedUrl = scrapedUrl.substring(0, scrapedUrl.length() - 1);
                            }

                            escapedUrl = escapedUrl.replace("www.", "").trim();
                            if (escapedUrl.endsWith("/")) {

                                escapedUrl = escapedUrl.substring(0, escapedUrl.length() - 1).trim();

                            }
                            String scrappedHost = null;

                            scrappedHost = scrapedLink.getHost().trim();
                            scrappedHost = scrappedHost.replace("www.", "").trim();

                            if (scrappedHost != null && !scrappedHost.isEmpty()) {
                               System.out.println(count + " our url:        " + matchHost + "       found url       " + scrappedHost  );
                                if (matchHost.equalsIgnoreCase(scrappedHost)) {
                                    System.out.println("+++++++++++++++++++++++++++++++++++Match found");
                                    doneWithKeyword = true;
                                    scrapedUrl = scrapedUrl.replace("/m.", "/");
                                    scrapedUrl = scrapedUrl.replace("http://", "");
                                    scrapedUrl = scrapedUrl.replace("https://", "");
                                    bestMatchLinkGoogle = scrapedUrl;
                                    bestMatchRankGoogle = count;
                                    if (matchUrl.equalsIgnoreCase(escapedUrl)) {
                                        doneWithKeyword = true;

                                    } else {
                                        if (!b) {
                                            b = true;

                                        }
                                    }
                                }
                            }

                        }
                    }// end if scrape (apple web kit)
//
//////////////////////////////////////////////////////////////////////end of ssecond parser
//
//                    //////////////////////////////////////////////////////////////Third parser (Symbian)   
//                    if (isCrawled == 0) {
//                        pattern = Pattern.compile("\"web_result\"(.*?)<a href=\"(.*?)\"", Pattern.DOTALL);
//                        matcher = pattern.matcher(web_page);
//                        while (matcher.find()) {
//                            isCrawled = 1;
//                            if (doneWithKeyword) {
//                                break;
//                            }
//
//                            detail = matcher.group(2);
//                            detail = detail.substring(detail.indexOf("u=") + 2);
//
//                            if (doneWithKeyword) {
//                                break;
//                            }
//
//                            count++;
//                            c++;
//                            //pattern matcher for scrapedUrl
//                            scrapedUrl = detail;
//                            URL scrapedLink = null;
//                            String escapedUrl = scrapedUrl;
//                            if (scrapedUrl.contains("https://") || scrapedUrl.contains("http://")) {
//                                escapedUrl = escapedUrl.replace("/m.", "/");
//                                scrapedUrl = scrapedUrl.replace("/url?q=", "");
//                                scrapedUrl = scrapedUrl.replace("url?q=", "");
//                                scrapedLink = new URL(scrapedUrl);
//                                escapedUrl = escapedUrl.replace("https://", "");
//                                escapedUrl = escapedUrl.replace("http://", "");
//                            } else {
//                                scrapedLink = new URL("http://" + scrapedUrl);
//                            }
//
//
//                            //remove last "/" from scrapedUrl
//
//                            if (scrapedUrl.endsWith("/")) {
//                                scrapedUrl = scrapedUrl.substring(0, scrapedUrl.length() - 1);
//                            }
//
//                            escapedUrl = escapedUrl.replace("www.", "").trim();
//                            if (escapedUrl.endsWith("/")) {
//
//                                escapedUrl = escapedUrl.substring(0, escapedUrl.length() - 1).trim();
//
//                            }
//                            String scrappedHost = null;
//
//                            scrappedHost = scrapedLink.getHost().trim();
//                            scrappedHost = scrappedHost.replace("www.", "").trim();
//
//                            if (scrappedHost != null && !scrappedHost.isEmpty()) {
//                              System.out.println(count + " our url:        " + matchHost + "       found url       " + scrappedHost  );
//                                if (matchHost.equalsIgnoreCase(scrappedHost)) {
//                                    System.out.println("+++++++++++++++++++++++++++++++++++Match found");
//                                    doneWithKeyword = true;
//                                    scrapedUrl = scrapedUrl.replace("/m.", "/");
//                                    scrapedUrl = scrapedUrl.replace("http://", "");
//                                    scrapedUrl = scrapedUrl.replace("https://", "");
//                                    bestMatchLinkGoogle = scrapedUrl;
//                                    bestMatchRankGoogle = count;
////                                       
//                                    if (matchUrl.equalsIgnoreCase(escapedUrl)) {
//                                    
//                                        doneWithKeyword = true;
//                                    } else {
//                                        if (!b) {
//                                            b = true;
//
//                                        }
//                                    }
//                                    
//                                }
//                            }
//
//                        }
//                    } //end if for (Symbian crawl)
//                    //////////////////////////////////////////////////////////////end of third parser 



                    /////////////////////////////////////////////////////////////////

//                      if count pointer is around 900  just stop sending re-request for page source                 
                        if (count >900) {
                       
                                doneWithKeyword = true;
                                isCrawled=1;
                         
                            }

                } catch (Exception ex) {
                    
                    System.err.println("Exception thrown in parsing url for "+scrapedUrl);
                    ex.printStackTrace();
                    l.debug(ex + "  " + ex.getMessage() + " Exception thrown in parsing data for keyword " + keyword + " Domain" + domain + "url " + url);
                }
            } while (isCrawled == 0);   //end of do while loop
//            }   //end of crawl pagination for loop


        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage() + " Exception come for keyword " + keyword + " Domain" + domain+" scrappedUrl= ");
        }

       if(doneWithKeyword) {
            System.out.println("Google Rank for Keyword= " + keyword + " Url= " + domain + "   is= " + count);
        }
        return count;
    }

    /**
     * This method passes the url and keyword from keywords list to
     *
     * @method getNewWebRankGoogle(
     * @params) and gets the result in newWebRankGoogle. This result is sent to
     * database layer by calling
     * @method saveGoogleResult(
     * @params).
     */
    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName() + " KeywordID= " + dto.getKeywordID() + " for url= " + dto.getUrl() + " keyword= " + dto.getKeyword() + " crawled " + dto.getCrawlCount());


        boolean b1 = true;
        while (b1) {
            Integer keywordId = 0;
            Integer newWebRankGoogle;
            try {
                if(ThreadCreator_google.bque.size()==0)break;
                System.out.println("bque.size()= "+ThreadCreator_google.bque.size());
                this.dto = ThreadCreator_google.bque.take();
                System.out.println("bque.size()= "+ThreadCreator_google.bque.size());
                if (dto.isDone() == true) {
                     if(ThreadCreator_google.bque.size()==0)break;
                     System.out.println("-----------------------");
                     System.out.println("bque.size()= "+ThreadCreator_google.bque.size());
                     this.dto = ThreadCreator_google.bque.take();//take next value from queue and dispose off the current one
                      System.out.println("bque.size()= "+ThreadCreator_google.bque.size());
                      System.out.println("----------------------");
                }
                keywordId = dto.getKeywordID();

                System.out.println(dto.getUrl() + "---------" + dto.getKeyword());
                keywordId = dto.getKeywordID();
                newWebRankGoogle = getNewWebRankGoogle(dto.getUrl(), dto.getKeyword(), dto.getLinkGoogle());

                // checking rank found or not 
                if (doneWithKeyword == true) {
                    doneWithKeyword=false;
                    System.out.println("Google Rank= " + newWebRankGoogle);
                    if(this.b){
                        bestMatchRankGoogle=count;
                        newWebRankGoogle=0;
                        this.b=false;
                    }
                   //Storing in database
                    objKeywordDao.saveResult(keywordId , newWebRankGoogle , bestMatchRankGoogle , bestMatchLinkGoogle,"google.com",dto.getKeyword(),dto.getUrl());
                   // SaveData.write(keywordId, "google",newWebRankGoogle,bestMatchRankGoogle,bestMatchLinkGoogle)  ;
                   // objKeywordDao.newUpdateKeywords( keywordId,ThreadCreator_google.sTrackID, ThreadCreator_google.eTrackID  );
                    dto.setDone(true);
                } else {
                    // logic for updating the crawl pointer count and adding it back to blocking Queue
                    if (count > 900) {
                        dto.setDone(true);
                    }
                    dto.setCrawlCount(count);
                    
                }
                System.out.println("bque.size()= "+ThreadCreator_google.bque.size());
                if(!dto.isDone())ranktracker.utility.ThreadCreator_google.bque.offer(dto);
                System.out.println("bque.size()= "+ThreadCreator_google.bque.size());
                System.out.println(Thread.currentThread().getName() + "    processed sucessfully");


            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Googl exception" + ex);
                l.debug(ex + "  " + ex.getMessage() + " Exception in saving keywordId " + keywordId);

            }
        }
        System.out.println(Thread.currentThread().getName() + " finished sucessfully");

    }
}