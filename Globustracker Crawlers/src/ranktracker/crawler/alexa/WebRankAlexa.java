package ranktracker.crawler.alexa;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;

/**
 * The crawler class get Alexa rank for a given domain.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class WebRankAlexa implements Runnable {

    static Logger l = Logger.getLogger(WebRankAlexa.class.getName());
    /**
     * setDomains The unique collection of domains
     */
    private Set<String> setDomains;
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;
    /**
     * lstKeywords The working list of Keywords objects
     */
    private List<Serpkeywords> lstKeywords;
    /**
     * startTrackId The first trackid for a given crawl thread
     */
    private Integer startTrackId;
    /**
     * endtrackId The last trackid for a given crawl thread
     */
    private Integer endtrackId;
    /**
     * iCount Counter variable for passing thread group information
     */
    private Integer iCount;

    /**
     * Constructor to set all the variables
     *
     * @param iCount
     * @param setDomains
     * @param lstKeywords
     * @param appContext
     * @param startTrackId
     * @param endtrackId
     *
     */
    public WebRankAlexa(Set<String> setDomains, List<Serpkeywords> lstKeywords,
            ApplicationContext appContext) {

        // this.iCount = iCount;
        this.setDomains = setDomains;
        this.lstKeywords = lstKeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);

    }

    /**
     * This method makes a call to alexa website, gets an xml response, parses
     * the xml and reads the alexa rank for a given domain.
     *
     * @param domain
     * @return Integer
     */
    public Integer getWebRankAlexa(String domain) throws Exception {
        String x = "blank";
        try {
            URL xmlURL = new URL("http://data.alexa.com/data?cli=10&dat=s&url=" + domain);
            InputStream stream = xmlURL.openStream();
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("POPULARITY");
            x = "blank";
            if (nodeList != null && nodeList.getLength() > 0) {
                Node currentNode = nodeList.item(0);
                Element currentElement = (Element) currentNode;
                x = currentElement.getAttribute("TEXT");
            }
        } catch (Exception e) {
            l.debug(e + "  " + e.getMessage());
        }
        System.out.println("domain:" + domain + "ALexa rank" + x);
        if (x == null || x.equalsIgnoreCase("") || x.equalsIgnoreCase("blank")) {
            return 0;
        } else {
            return Integer.valueOf(x);
        }

    }

    /**
     * This method passes the domains from keywords list to
     *
     * @method getWebRankAlexa(String domain) and gets the result in Map<String,
     * Integer> mapWebRankAlexa. Then iterates over lstKeywords, gets
     * webRankAlexa value from mapWebRankAlexa and sends data to database layer
     * by calling
     * @method saveAlexaResult(
     * @params).
     */
    @Override
    public void run() {
        Map<String, Integer> mapWebRankAlexa = new HashMap<>(0);
        try {
            for (String domainName : setDomains) {
                mapWebRankAlexa.put(domainName.trim(), getWebRankAlexa(domainName.trim()));
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage());
            java.util.logging.Logger.getLogger(WebRankAlexa.class.getName()).log(Level.SEVERE, null, ex);
        }

        Integer webRankAlexa;
        Integer keywordId = 0;
        String domainName = "";
        try {
            for (Serpkeywords objKeywords : lstKeywords) {
                domainName = objKeywords.getUrl().trim();
                keywordId = objKeywords.getKeywordID();
                webRankAlexa = mapWebRankAlexa.get(domainName);
                webRankAlexa = webRankAlexa == null ? 0 : webRankAlexa;
                objKeywordDao.saveAlexaResult(keywordId, domainName, objKeywords.getKeyword(), objKeywords.getCampaignID(), webRankAlexa);
            }
        } catch (Exception ex) {
            l.debug(ex + "  " + ex.getMessage() + " Exception come for keyword " + keywordId + " Domain" + domainName);
        }

    }
}
