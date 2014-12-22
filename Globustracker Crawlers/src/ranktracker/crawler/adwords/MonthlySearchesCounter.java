package ranktracker.crawler.adwords;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.ApplicationContext;
import ranktracker.dao.KeywordsDao;
import ranktracker.entity.Serpkeywords;
import ranktracker.entity.Search;

/**
 * The crawler class which provides google monthly searches data. The class uses
 * selenium jars to simulate browser behaviour. The code only works on systems
 * with UI where browser window can be launched.
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class MonthlySearchesCounter implements Runnable {

    static Logger l = Logger.getLogger(MonthlySearchesCounter.class.getName());
    /**
     * objKeywordDao The database layer KeywordsDao object variable
     */
    private KeywordsDao objKeywordDao;
    /**
     * lstKeywords The working list of Keywords objects
     */
    private List<Serpkeywords> lstKeywords;

    /**
     * Constructor to set all the variables
     *
     * @param lstKeywords
     * @param appContext
     */
    public MonthlySearchesCounter(List<Serpkeywords> lstKeywords, ApplicationContext appContext) {
        this.lstKeywords = lstKeywords;
        this.objKeywordDao = appContext.getBean("objKeywordDao", KeywordsDao.class);
    }

    /**
     * This method makes a new list of unique keyword strings from keyword
     * objects. It opens google keyword tool, supplies data, executes the tool,
     * reads the output on the page and sets the data in
     * mapMonthlySearchesCounter.
     *
     * @param lstKeywords
     * @return Map<String, Integer>
     */
    private Map<String, Integer> getMonthlySearchesCounter(List<Serpkeywords> lstKeywords) {

        Search objSearch;
        Set<Search> setSearchKeywords = new HashSet<Search>();
        for (int q = 0; q < lstKeywords.size(); q++) {
            objSearch = new Search(lstKeywords.get(q).getKeyword());
            setSearchKeywords.add(objSearch);
        }
        //Set<Keywords> setKeywords = getKeyword();
        List<Search> lstSearchKeywords = new ArrayList<Search>();
        lstSearchKeywords.addAll(setSearchKeywords);
        //WebDriver driver = new FirefoxDriver();
        File file = new File("C:\\Program Files\\Opera Mobile Emulator\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        StringBuilder sbsearchKey = null;
        Map<String, Integer> mapMonthlySearchesCounter = new HashMap<String, Integer>(0);

        driver.get("https://accounts.google.com/");
        driver.findElement(By.id("Email")).sendKeys("omkaravishal@gmail.com");
        driver.findElement(By.id("Passwd")).sendKeys("omkaraVishal1");
        driver.findElement(By.id("signIn")).click();

        int count1 = 0;
        int count2 = 0;
        int listsize = lstSearchKeywords.size();
        float floatCount = listsize / 50f;
        int intCount = listsize / 50;
        if (floatCount > intCount) {
            intCount = intCount + 1;
        }

        //open keyword page

        driver.get("https://adwords.google.com/o/Targeting/Explorer?__c=8122345663&__u=5202599383&__o=cues&ideaRequestType=KEYWORD_IDEAS");
        for (int i = 0; i < intCount; i++) {
            driver.navigate().refresh();
            int localCount = 0;
            if (i == (intCount - 1)) {
                count2 = count2 + (listsize % 50);
                localCount = listsize % 50;
            } else {
                count2 = count2 + 50;
                localCount = 50;
            }

            sbsearchKey = new StringBuilder();

            for (int j = count1; j < count2; j++) {
                sbsearchKey.append(lstSearchKeywords.get(j).getKeyword());
                count1++;
                if (count1 != count2) {
                    sbsearchKey.append(Keys.ENTER);
                }
            }

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector(".sEFB.sBKB")).clear();
            driver.findElement(By.cssSelector(".sEFB.sBKB")).sendKeys(sbsearchKey.toString());//("smokeless cigarette reviews" + Keys.ENTER + "smokeless cigarette review");
            driver.findElement(By.cssSelector(".gwt-Button.aw-native-save-button-element.aw-larger-button")).click();
            // Wait for page to load
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            WebElement we = driver.findElement(By.id("gwt-debug-column-KEYWORD-row-0-1"));
            we = driver.findElement(By.className("sNSB"));
            String[] values = we.getText().split("\n");;
            for (int x = 0, y = 4, z = 6; x < localCount; x++) {
                try {
                    mapMonthlySearchesCounter.put(values[y], Integer.valueOf(values[z].replace(",", "")));
                } catch (Exception n) {
                    l.debug(n.getMessage() + "  " + n.getMessage());
                    mapMonthlySearchesCounter.put(values[y], 0);
                } finally {
                    y = y + 4;
                    z = z + 4;
                }
            }
        }
        driver.close();
        return mapMonthlySearchesCounter;
    }

    /**
     * This method passes the keywords list to
     *
     * @method getMonthlySearchesCounter(List<Keywords> lstKeywords) and gets
     * the result in Map<String, Integer> mapMonthlySearchesCounter. Then
     * iterates over lstKeywords, gets countMonthlySearches value from
     * mapMonthlySearchesCounter and sends data to database layer by calling
     * @method saveSearchesCountResult(
     * @params).
     */
    @Override
    public void run() {

        String keyword;
        Integer keywordId;
        Map<String, Integer> mapMonthlySearchesCounter = getMonthlySearchesCounter(lstKeywords);


        Integer countMonthlySearches;
        Map<Integer, Integer> mapSearchesCount = new HashMap<Integer, Integer>();
        // System.out.println("lstKeywords.size(): "+lstKeywords.size() );
        Integer[] keywordIDS = new Integer[lstKeywords.size()];
        Integer arrIndex = 0;
        //String domainName;
        try {
            for (Serpkeywords objKeywords : lstKeywords) {
                keyword = objKeywords.getKeyword();
                keywordId = objKeywords.getKeywordID();
                countMonthlySearches = mapMonthlySearchesCounter.get(keyword);
                mapSearchesCount.put(keywordId, countMonthlySearches);
                keywordIDS[arrIndex] = keywordId;
                arrIndex++;
                //System.out.println("   keywordId:"+keywordId+"   countMonthlySearches: "+countMonthlySearches);
            }
            objKeywordDao.saveSearchesCountResult(mapSearchesCount, keywordIDS);
        } catch (Exception ex) {
            l.debug(ex.getMessage() + "  " + ex.getMessage());
        }
    }
}
