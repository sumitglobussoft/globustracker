package ranktracker.utility;

import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Socialsignalurls;
import ranktracker.social.facebook.FacebookSignifier;
import ranktracker.social.google.GoogleSignifier;
import ranktracker.social.linkedIn.LinkedInSignifier;
import ranktracker.social.pinterest.PinterestSignifier;
import ranktracker.social.reddit.RedditSignifier;
import ranktracker.social.stumble.StumbleSignifier;
import ranktracker.social.twitter.TwitterSignifier;

/**
 * Utility Class to create thread groups for crawling.
 *
 * @author user
 */
public class ThreadCreator_signifier extends Thread {

    static Logger l = Logger.getLogger(ThreadCreator_google.class.getName());
    /**
     * lstKeywords The working list of Keywords objects
     */
    private List<Socialsignalurls> lstUrls = null;
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;
    /**
     * startTrackId The first trackid for a given crawl thread
     */
    private Integer startTrackId;
    /**
     * endtrackId The last trackid for a given crawl thread
     */
    private Integer endtrackId;
    /**
     * appContext The ApplicationContext object variable
     */
    private ApplicationContext appContext;
    /**
     * setDomains The set of unique domain strings
     */
    private Set<String> setDomains;
    /**
     * setDomains The set of unique domain strings
     */
    private String crawlername;

    /**
     * iCount Counter variable for passing thread group information
     */
//    private Integer iCount;
    /**
     * Constructor to set all the variables
     *
     * @param crawlername
     * @param setDomains
     * @param lstKeywords
     * @param appContext
     * @param iCount
     *
     */
    public ThreadCreator_signifier(String crawlername, List<Socialsignalurls> lstUrls, ApplicationContext appContext) {
        this.crawlername = crawlername;
        this.lstUrls = lstUrls;
        this.appContext = appContext;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);

    }

    /**
     * This method asks for creation of new rows in trackhistory table using
     *
     * @method createRows(). Then all crawlers objects are created with supplied
     * information and started. The main thread awaits completion of all crawler
     * threads and after joining with every crawler thread, invokes
     * UpdateRecords object to update crawled records to Keywords table.
     */
    @Override
    public void run() {
//        Integer sKeywordId = lstKeywords.get(0).getKeywordId();
//        Integer eKeywordId = lstKeywords.get(lstKeywords.size() - 1).getKeywordId();
//        Integer[] track = new RowCreator(lstKeywords, appContext).createRows();
//
//        startTrackId = track[0];
//        endtrackId = track[1];
//
//        WriteConfiguration.writeProperties(sKeywordId, eKeywordId, startTrackId, endtrackId);

        try {
            Thread tFacebookSignifier = null, tGoogleSignifier = null, tLinkedInSignifier = null, tPinterestSignifier = null, tRedditSignifier = null, tStumbleSignifier = null, tTwitterSignifier = null;

            if (crawlername.equalsIgnoreCase("facebook") || crawlername.equalsIgnoreCase("all")) {
                System.out.println("-------------Facebook---------------");
                tFacebookSignifier = new Thread(new FacebookSignifier(lstUrls, appContext));
                tFacebookSignifier.start();
                tFacebookSignifier.join();
            }

            if (crawlername.equalsIgnoreCase("google+") || crawlername.equalsIgnoreCase("all")) {
                System.out.println("-------------GooglePlus---------------");
                tGoogleSignifier = new Thread(new GoogleSignifier(lstUrls, appContext));
                tGoogleSignifier.start();
                tGoogleSignifier.join();
            }

            if (crawlername.equalsIgnoreCase("linkedin") || crawlername.equalsIgnoreCase("all")) {
                System.out.println("-------------LinkedIn---------------");
                tLinkedInSignifier = new Thread(new LinkedInSignifier(lstUrls, appContext));
                tLinkedInSignifier.start();
                tLinkedInSignifier.join();
            }

            if (crawlername.equalsIgnoreCase("pinterest") || crawlername.equalsIgnoreCase("all")) {
                System.out.println("-------------Pinterest---------------");
                tPinterestSignifier = new Thread(new PinterestSignifier(lstUrls, appContext));
                tPinterestSignifier.start();
                tPinterestSignifier.join();
            }

            if (crawlername.equalsIgnoreCase("reddit") || crawlername.equalsIgnoreCase("all")) {
                System.out.println("-------------Reditt---------------");
                tRedditSignifier = new Thread(new RedditSignifier(lstUrls, appContext));
                tRedditSignifier.start();
                tRedditSignifier.join();
            }

            if (crawlername.equalsIgnoreCase("stumble") || crawlername.equalsIgnoreCase("all")) {
                System.out.println("-------------Stumble---------------");
                tStumbleSignifier = new Thread(new StumbleSignifier(lstUrls, appContext));
                tStumbleSignifier.start();
                tStumbleSignifier.join();
            }

            if (crawlername.equalsIgnoreCase("twitter") || crawlername.equalsIgnoreCase("all")) {
                System.out.println("-------------Twitter---------------");
                tTwitterSignifier = new Thread(new TwitterSignifier(lstUrls, appContext));
                tTwitterSignifier.start();
                tTwitterSignifier.join();
            }
        } catch (Exception e) {
            l.debug(e.getMessage() + "  " + e.getMessage());
        }
//        try {
//            Thread tUpdateRecords = new Thread(new UpdateRecords(lstKeywords, objKeywordDao, startTrackId, endtrackId));
//            tUpdateRecords.start();
//        } catch (Exception e) {
//            l.debug(e.getMessage() + "  " + e.getMessage());
//        }
    }
}
