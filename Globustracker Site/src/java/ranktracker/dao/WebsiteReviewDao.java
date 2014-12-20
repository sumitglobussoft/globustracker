/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.dao;

import java.util.Map;

/**
 *
 * @author User
 */
public interface WebsiteReviewDao {
        
    /**
     * 
     * @param sitename
     * @return 
     */
    public Map getCommonsDetails(String sitename);
        
    public Map getHeadingcount(String sitename);
    
    public Map getHeadingelement(String sitename);
    
    public Map getImagedata(String sitename);
    
    public Map getPageLinksdata(String sitename);
    
    public Map getRelatedWebsite(String sitename);
    
    public Map getTechnologydata(String sitename);
    
    public Map getVisitorarray(String sitename);
    
    public Map getXmldata(String sitename);
    
}
