package ranktracker.utility;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import ranktracker.crawler.google.NewWebRankGoogle;
import ranktracker.dao.KeywordsDao;
import ranktracker.dao.ProxyDao;
import ranktracker.entity.Serpkeywords;
import ranktracker.to.DetailsTO;

/**
 * Utility Class to create thread groups for crawling.
 *
 * @author Anshuman
 */
public class ThreadCreator_google extends Thread {

    static Logger l = Logger.getLogger(ThreadCreator_google.class.getName());
    /**
     * lstKeywords The working list of Keywords objects
     */
    private List<Serpkeywords> lstKeywords = null;
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
    public static ApplicationContext appContext;
    /**
     * setDomains The set of unique domain strings
     */
    private Set<String> setDomains;
    /**
     * lstKeywords The working list of Keywords objects
     */
    public static LinkedBlockingDeque<DetailsTO> bque = new LinkedBlockingDeque<DetailsTO>();
    ranktracker.to.DetailsTO dto = null;
    String toUrl;
    String toKeyword;
    String toLinkGoogle;
    int toCrawlCount;
    int toKeywordID;
    int sKeywordID;
    int eKeywordID;
    int clientid;
    public static int sTrackID;
    public static int eTrackID;
    private static Runnable googleThread; 

    public ThreadCreator_google(ApplicationContext appContext,int sKeywordID,int eKeywordID,List<Serpkeywords> lstKeywords) {
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
        this.appContext = appContext;
        this.sKeywordID=sKeywordID;
        this.eKeywordID=eKeywordID;
        this.lstKeywords=lstKeywords;
    }

    /**
     * Constructor to set all the variables
     *
     * @param setDomains
     * @param lstKeywords
     * @param appContext
     * @param iCount
     *
     */
//    public ThreadCreator_google(Set<String> setDomains, List<Keywords> lstKeywords, ApplicationContext appContext,
//            Integer iCount) {
//
//        this.setDomains = setDomains;
//        this.lstKeywords = lstKeywords;
//        this.appContext = appContext;
//        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
//        this.iCount = iCount;
//    }
    /**
     * This method asks for creation of new rows in trackhistory table using
     *
     * @method createRows(). Then all crawlers objects are created with supplied
     * information and started. The main thread awaits completion of all crawler
     * threads and after joining with every crawler thread, invokes
     * UpdateRecords object to update crawled records to Keywords table.
     * @method readProperties(). read the properties start TrackId,end
     * trackId,start KeywordID,end KeywordID from properties file
     *
     * @method run() : start 50 threads for google crawler
     */
    @Override
    public void run() {
//        Integer[] configuration = ReadConfiguration.readProperties();
//        startTrackId = configuration[2];
//        endtrackId = configuration[3];
//        sTrackID=startTrackId;
//        eTrackID=endtrackId;
        
//        Thread googleThread = null;
        
//        Integer sKeywordID = configuration[0];
//        Integer eKeywordID = configuration[1];

        ///some logic to get keywords
           //lstKeywords = objKeywordDao.getCustomerKeywords(clientid);


// adding all details into blockingque
        for (Serpkeywords k : lstKeywords) {
            ranktracker.to.DetailsTO dto = null;
            toUrl = k.getUrl();
            toKeyword = k.getKeyword();
            toLinkGoogle = k.getLinkGoogle();
            toCrawlCount = 0;
            toKeywordID = k.getKeywordID();
            

            dto = new DetailsTO(toKeywordID, toUrl, toKeyword, toLinkGoogle);
            if(dto!=null)bque.offer(dto);


        }
//        Set<String> setDomains = new HashSet<String>(0);
//        for (Keywords objKeyword : lstKeywords) {
//            setDomains.add(objKeyword.getUrl().trim());
//        }

        //read start trackid and end trackid from table
//        try {
//            Integer[] trackIdRange = objKeywordDao.getTrackIdRange(lstKeywords);
//            startTrackId = trackIdRange[0];
//            endtrackId = trackIdRange[1];
//            for (int n=0;n<=trackIdRange.length;n++){
//            System.out.println("trackIdRange= "+trackIdRange[n]);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            l.debug(e.getMessage() + " ");
//        }

//        try {
        // get detailsTO from bque
//            googleThread = new Thread(new NewWebRankGoogle(dto , appContext));
//            googleThread.start();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            l.debug(e.getMessage() + "  " + e.getMessage());
//        }
//        try {
//            googleThread.join();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
///////////////////////////////////////////////////////////         starting thread for new Web  Rank google


        ExecutorService executor = Executors.newFixedThreadPool(40);
       
        
            // con
            for (int i=0;i<40 ;i++) {
               
                Runnable googleThread = new NewWebRankGoogle( appContext);
                executor.execute(googleThread);
                System.out.println("--------------i"+i);
            }
               executor.shutdown();
        while (!executor.isTerminated()) {
        }
            System.out.println(" bque size=  " + bque.size());
      
     

        System.out.println("Finished all threads- program compleated sucessfully");
        System.out.println("bque size=  " + bque.size());


/////////////////////////////////////////////////////////// `       ending threading for new web Rank Google
//        try {
//            Thread tUpdateRecords = new Thread(new UpdateRecords(lstKeywords, objKeywordDao, startTrackId, endtrackId));
//            tUpdateRecords.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//            l.debug(e.getMessage() + "  " + e.getMessage());
//        }
    }
    
   
}
