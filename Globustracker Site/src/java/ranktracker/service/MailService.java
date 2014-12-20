/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.service;

import ranktracker.entity.MasterEmail;

/**
 * Service layer interface for Mail Module
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public interface MailService {

    /**
     * The method sends reminder password to customer
     *
     * @param emailId
     * @param password
     */
    public void sendReminderPassword(String emailId, String password);

    /**
     * The method retrieves mail settings by given mailer id
     *
     * @param mailerId
     * @return MasterEmail
     */
    public MasterEmail getMasterEmailSettings(int mailerId);
}
