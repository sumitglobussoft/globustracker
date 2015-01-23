/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ranktracker.entity.Payments;
import ranktracker.entity.Plans;

/**
 * Service layer interface for Payments Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
@Transactional(readOnly = true)
public interface PaymentService {

    /**
     * The method saves a payment record
     *
     * @param payments
     * @return int
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int savePayment(Payments payments);

    /**
     * The method gets a plan object by given plan name
     *
     * @param planName
     * @return List<Plans>
     */
    public List<Plans> getPlans(String planName);
}
