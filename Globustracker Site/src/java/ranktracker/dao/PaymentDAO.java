package ranktracker.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;

/**
 * DAO layer interface for Payments Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public interface PaymentDAO {

    /**
     * The method saves a payment record
     *
     * @param payments
     * @return int
     */
    public int savePayment(Payments payments);

    /**
     * The method gets a plan object by given plan name
     *
     * @param planName
     * @return List<Plans>
     */
    public List<Plans> getPlans(String planName);
}
