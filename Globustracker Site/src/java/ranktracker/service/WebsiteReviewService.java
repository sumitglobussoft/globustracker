/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.Map;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Transactional(readOnly = true)
public interface WebsiteReviewService {

    /**
     *
     * @param sitename
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Map getCommonsDetails(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getHeadingcount(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getHeadingelement(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getImagedata(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getPagelinksdata(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getRelatedwebsite(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getTechnologydata(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getVisitorarray(String sitename);

    @Transactional(propagation = Propagation.REQUIRED)
    public Map getXmldata(String sitename);
}
