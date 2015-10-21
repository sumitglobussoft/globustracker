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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GLB-214
 */
@Entity
@Table(name = "webmastergraph")
@NamedQueries({
    @NamedQuery(name = "Webmastergraph.findAll", query = "SELECT w FROM Webmastergraph w")})
public class Webmastergraph implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "clicks")
    private double clicks;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "siteurl")
    private String siteurl;
    @Basic(optional = false)
    @Column(name = "ctr")
    private double ctr;
    @Basic(optional = false)
    @Column(name = "impression")
    private double impression;
    @Basic(optional = false)
    @Column(name = "position")
    private double position;
    @Basic(optional = false)
    @Column(name = "datestring")
    private String datestring;

    public Webmastergraph() {
    }

    public Webmastergraph(Integer id) {
        this.id = id;
    }

    public Webmastergraph(Integer id, double clicks, Date date, String siteurl, double ctr, double impression, double position, String datestring) {
        this.id = id;
        this.clicks = clicks;
        this.date = date;
        this.siteurl = siteurl;
        this.ctr = ctr;
        this.impression = impression;
        this.position = position;
        this.datestring = datestring;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getClicks() {
        return clicks;
    }

    public void setClicks(double clicks) {
        this.clicks = clicks;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSiteurl() {
        return siteurl;
    }

    public void setSiteurl(String siteurl) {
        this.siteurl = siteurl;
    }

    public double getCtr() {
        return ctr;
    }

    public void setCtr(double ctr) {
        this.ctr = ctr;
    }

    public double getImpression() {
        return impression;
    }

    public void setImpression(double impression) {
        this.impression = impression;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public String getDatestring() {
        return datestring;
    }

    public void setDatestring(String datestring) {
        this.datestring = datestring;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Webmastergraph)) {
            return false;
        }
        Webmastergraph other = (Webmastergraph) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Webmastergraph[ id=" + id + " ]";
    }
    
}
