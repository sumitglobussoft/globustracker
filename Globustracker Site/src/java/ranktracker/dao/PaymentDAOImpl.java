package ranktracker.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;

/**
 * DAO layer class for Payments Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class PaymentDAOImpl extends HibernateDaoSupport implements PaymentDAO {

    static Logger l = Logger.getLogger(PaymentDAOImpl.class.getName());

    /**
     * The method saves a payment record
     *
     * @param payments
     * @return int
     */
    @Override
    public int savePayment(Payments payments) {
        
        //invoking the getSession() method to save <payments> object
        Integer paymentId = (Integer) getSession().save(payments);
        return paymentId;
    }

    /**
     * The method gets a plan object by given plan name
     *
     * @param planName
     * @return List<Plans>
     */
    @Override
    public List<Plans> getPlans(String planName) {
        
        //forming the hqlQuery to select plan object for planName
        String hqlQuery = "from Plans where name = :planName";
        
        //invoking getSession() method to create Query object for <hqlQuery>
        Query objQuery = getSession().createQuery(hqlQuery);
        
        //setting parameter for <planName>
        objQuery.setParameter("planName", planName);
        List<Plans> lstPlans = objQuery.list();
        System.out.println("--------");
        //now returning list of plans object
        return lstPlans;
    }
}
