package ranktracker.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import ranktracker.entity.Customers;
import ranktracker.entity.Paymenthistory;
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
        Paymenthistory objhistory = new Paymenthistory();

        objhistory.setCustomerId(payments.getCustomerID());
        objhistory.setPaymentDate(new Date());
        objhistory.setPlan(payments.getPlan());

        getSession().save(objhistory);
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

    @Override
    public Date getPaymentEndingDate(Integer customerID) {

        //System.out.println("INSIDE getPaymentEndingDate : customerID " + customerID);
        Payments objPayments = new Payments();
        try {

            //Query objQuery = getSession().createQuery(hqlQuery);
            //setting parameter for <planName>
            Criteria objCriteria = getSession().createCriteria(Payments.class);

            //adding the Restrictions for <keywordID>
            objCriteria.add(Restrictions.eq("customerID.customerID", customerID));

            List<Payments> lstUsers = objCriteria.list();

            objPayments = lstUsers.get(0);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("EXCEPTION IN FETCHING PAYEMENT : " + ex);
        }

        return objPayments.getEndDate();

    }

    @Override
    public void editPaymentDetails(Payments objPayments, Customers objCustomers, Integer customerId) {
        try {

            String query1 = "update Payments set BeginDate=?, Amount=?, EndDate=?, PaymentDate=?, PlanID=?, Plan=? where customerID.customerID = ?";
            getHibernateTemplate().bulkUpdate(query1, new Object[]{objPayments.getBeginDate(), objPayments.getAmount(), objPayments.getEndDate(), objPayments.getPaymentDate(), objPayments.getPlanID(), objPayments.getPlan(), customerId});

            String query2 = "update Customers set allowedCampaignsCount=?, allowedKeywordCount=?, allowedUserCount=? where customerID = ?";
            getHibernateTemplate().bulkUpdate(query2, new Object[]{objCustomers.getAllowedCampaignsCount(), objCustomers.getAllowedKeywordCount(), objCustomers.getAllowedUserCount(), customerId});

            Paymenthistory objhistory = new Paymenthistory();

            objhistory.setCustomerId(new Customers(customerId));
            objhistory.setPaymentDate(new Date());
            objhistory.setPlan(objPayments.getPlan());

            getSession().save(objhistory);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
