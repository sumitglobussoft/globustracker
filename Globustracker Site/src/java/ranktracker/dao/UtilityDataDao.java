package ranktracker.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ranktracker.entity.Displaysettings;
import ranktracker.entity.Reportfrequency;

/**
 * DAO layer interface for utilities Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public interface UtilityDataDao {

//    public List<Alertsettings> getAlertSettings();
//
//    public List<Reportfrequency> getReportfrequency();
//
//    public List<Timezones> getTimezones();
    /**
     * The method adds a new user to database
     *
     * @param email
     * @param password
     * @param userType
     * @param customerID
     */
    public void addUser(String email, String password, Integer userType, Integer customerID);

    /**
     * The method checks number of existing users for a customer
     *
     * @param customerID
     * @return int
     */
    public int checkAddUserQuota(Integer customerID);

    /**
     * This method add the settings to the tabs
     *
     * @param tabsettings
     * @return
     */
    public Integer addSettingsStore(Map tabsettings);

    /**
     *
     * @param customerID
     * @return
     */
    public List<Displaysettings> showSettingUser(Integer customerID);

    /**
     * The method retrieves reportfrequency data
     *
     * @return List<ReportFrequency>
     */
    public List<Reportfrequency> getFrequency();

    /**
     * The method retrieves user records for a given customer id
     *
     * @param customerID
     * @param userID
     * @return List
     */
    public List getUsers(Integer customerID, Integer userID);

    /**
     * The method retrieves user records for a given customer id
     *
     * @param userID
     * @return Integer
     */
    public Integer getUserType(Integer customerID, Integer userID);

    /**
     * The method retrieves user records for a given customer id
     *
     * @param userID
     * @param loginID
     * @param password
     * @return Integer
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updateUserInfo(Integer userID, String loginID, String password);

    /**
     * The method retrieves user records for a given customer id
     *
     * @param userID
     * @return Integer
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserAccount(Integer userID, Integer customerID);
}
