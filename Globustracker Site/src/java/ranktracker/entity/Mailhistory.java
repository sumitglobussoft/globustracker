/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ranktracker.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "mailhistory")
public class Mailhistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MailHistoryId")
    private Integer mailHistoryId;
    @Basic(optional = false)
    @Column(name = "EmailId")
    private String emailId;
    @Basic(optional = false)
    @Column(name = "MailSentOn")
    @Temporal(TemporalType.DATE)
    private Date mailSentOn;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerId;

    public Mailhistory() {
    }

    public Mailhistory(Integer mailHistoryId) {
        this.mailHistoryId = mailHistoryId;
    }

    public Mailhistory(Integer mailHistoryId, String emailId, Date mailSentOn) {
        this.mailHistoryId = mailHistoryId;
        this.emailId = emailId;
        this.mailSentOn = mailSentOn;
    }

    public Integer getMailHistoryId() {
        return mailHistoryId;
    }

    public void setMailHistoryId(Integer mailHistoryId) {
        this.mailHistoryId = mailHistoryId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getMailSentOn() {
        return mailSentOn;
    }

    public void setMailSentOn(Date mailSentOn) {
        this.mailSentOn = mailSentOn;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mailHistoryId != null ? mailHistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mailhistory)) {
            return false;
        }
        Mailhistory other = (Mailhistory) object;
        if ((this.mailHistoryId == null && other.mailHistoryId != null) || (this.mailHistoryId != null && !this.mailHistoryId.equals(other.mailHistoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Mailhistory[ mailHistoryId=" + mailHistoryId + " ]";
    }
    
}
