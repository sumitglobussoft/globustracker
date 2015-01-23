/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import org.apache.log4j.Logger;
import ranktracker.dao.PaymentDAO;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;

/**
 * Service layer class for Payments Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class PaymentServiceImpl implements PaymentService {
    
    static Logger l = Logger.getLogger(PaymentServiceImpl.class.getName());
    /**
     * objPaymentDAO The database layer object variable for PaymentDAO object
     */
    private PaymentDAO objPaymentDAO;

    //This object name 'objPaymentDAO' should be same as declared bean in 'beans.xml' for ranktracker.dao.PaymentDaoImpl class
    //then we have to generate getter and setter method for objPaymentDAO object.
    //by doing so, spring container initialize the objPaymentDAO object.
    
    /**
     * The method saves a payment record
     *
     * @param payments
     * @return int
     */
    @Override
    public int savePayment(Payments payments) {

        //calling the savePayment method of PaymentDAOImpl class
        return objPaymentDAO.savePayment(payments);
    }

    /**
     *
     * @return objPaymentDAO
     */
    public PaymentDAO getobjPaymentDAO() {
        return objPaymentDAO;
    }

    /**
     *
     * @param objPaymentDAO
     */
    public void setObjobjPaymentDAO(PaymentDAO objPaymentDAO) {
        this.objPaymentDAO = objPaymentDAO;
    }

    /**
     *
     * @return objPaymentDAO
     */
    public PaymentDAO getObjPaymentDAO() {
        return objPaymentDAO;
    }

    /**
     *
     * @param objPaymentDAO
     */
    public void setObjPaymentDAO(PaymentDAO objPaymentDAO) {
        this.objPaymentDAO = objPaymentDAO;
    }

    /**
     * The method gets a plan object by given plan name
     *
     * @param planName
     * @return List<Plans>
     */
    @Override
    public List<Plans> getPlans(String planName) {

        //calling the getPlans method of PaymentDAOImpl class
        return objPaymentDAO.getPlans(planName);
    }
    }
