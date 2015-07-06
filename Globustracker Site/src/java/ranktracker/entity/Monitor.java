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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "monitor")
public class Monitor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CrawlID")
    private Integer crawlID;
    @Column(name = "StartKeywordID")
    private Integer startKeywordID;
    @Column(name = "EndKeywordID")
    private Integer endKeywordID;
    @Column(name = "CrawlInitTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crawlInitTime;
    @Column(name = "CrawlStartTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crawlStartTime;
    @Column(name = "CrawlEndTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crawlEndTime;

    public Monitor() {
    }

    public Monitor(Integer crawlID) {
        this.crawlID = crawlID;
    }

    public Integer getCrawlID() {
        return crawlID;
    }

    public void setCrawlID(Integer crawlID) {
        this.crawlID = crawlID;
    }

    public Integer getStartKeywordID() {
        return startKeywordID;
    }

    public void setStartKeywordID(Integer startKeywordID) {
        this.startKeywordID = startKeywordID;
    }

    public Integer getEndKeywordID() {
        return endKeywordID;
    }

    public void setEndKeywordID(Integer endKeywordID) {
        this.endKeywordID = endKeywordID;
    }

    public Date getCrawlInitTime() {
        return crawlInitTime;
    }

    public void setCrawlInitTime(Date crawlInitTime) {
        this.crawlInitTime = crawlInitTime;
    }

    public Date getCrawlStartTime() {
        return crawlStartTime;
    }

    public void setCrawlStartTime(Date crawlStartTime) {
        this.crawlStartTime = crawlStartTime;
    }

    public Date getCrawlEndTime() {
        return crawlEndTime;
    }

    public void setCrawlEndTime(Date crawlEndTime) {
        this.crawlEndTime = crawlEndTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (crawlID != null ? crawlID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monitor)) {
            return false;
        }
        Monitor other = (Monitor) object;
        if ((this.crawlID == null && other.crawlID != null) || (this.crawlID != null && !this.crawlID.equals(other.crawlID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Monitor[ crawlID=" + crawlID + " ]";
    }
    
}
