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
@Table(name = "payments")
public class Payments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PaymentID")
    private Integer paymentID;
    @Column(name = "ResellerId")
    private Integer resellerId;
    @Basic(optional = false)
    @Column(name = "Amount")
    private float amount;
    @Column(name = "BeginDate")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "PaymentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @Basic(optional = false)
    @Column(name = "PayerID")
    private String payerID;
    @Basic(optional = false)
    @Column(name = "EbayTransactionID")
    private String ebayTransactionID;
    @Column(name = "Plan")
    private String plan;
    @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerID;
    @JoinColumn(name = "PlanID", referencedColumnName = "PlanID")
    @ManyToOne
    private Plans planID;

    public Payments() {
    }

    public Payments(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Payments(Integer paymentID, float amount, Date paymentDate, String payerID, String ebayTransactionID) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.payerID = payerID;
        this.ebayTransactionID = ebayTransactionID;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getResellerId() {
        return resellerId;
    }

    public void setResellerId(Integer resellerId) {
        this.resellerId = resellerId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPayerID() {
        return payerID;
    }

    public void setPayerID(String payerID) {
        this.payerID = payerID;
    }

    public String getEbayTransactionID() {
        return ebayTransactionID;
    }

    public void setEbayTransactionID(String ebayTransactionID) {
        this.ebayTransactionID = ebayTransactionID;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    public Plans getPlanID() {
        return planID;
    }

    public void setPlanID(Plans planID) {
        this.planID = planID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentID != null ? paymentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payments)) {
            return false;
        }
        Payments other = (Payments) object;
        if ((this.paymentID == null && other.paymentID != null) || (this.paymentID != null && !this.paymentID.equals(other.paymentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Payments[ paymentID=" + paymentID + " ]";
    }
    
}
