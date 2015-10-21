/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author GLB-214
 */
@Entity
@Table(name = "webmasterquery")
@NamedQueries({
    @NamedQuery(name = "Webmasterquery.findAll", query = "SELECT w FROM Webmasterquery w")})
public class Webmasterquery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "siteurl")
    private String siteurl;
    @Basic(optional = false)
    @Column(name = "query")
    private String query;
    @Basic(optional = false)
    @Column(name = "clicks")
    private double clicks;
    @Basic(optional = false)
    @Column(name = "impression")
    private double impression;
    @Basic(optional = false)
    @Column(name = "ctr")
    private double ctr;
    @Basic(optional = false)
    @Column(name = "position")
    private double position;

    public Webmasterquery() {
    }

    public Webmasterquery(Integer id) {
        this.id = id;
    }

    public Webmasterquery(Integer id, String siteurl, String query, double clicks, double impression, double ctr, double position) {
        this.id = id;
        this.siteurl = siteurl;
        this.query = query;
        this.clicks = clicks;
        this.impression = impression;
        this.ctr = ctr;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteurl() {
        return siteurl;
    }

    public void setSiteurl(String siteurl) {
        this.siteurl = siteurl;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public double getClicks() {
        return clicks;
    }

    public void setClicks(double clicks) {
        this.clicks = clicks;
    }

    public double getImpression() {
        return impression;
    }

    public void setImpression(double impression) {
        this.impression = impression;
    }

    public double getCtr() {
        return ctr;
    }

    public void setCtr(double ctr) {
        this.ctr = ctr;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
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
        if (!(object instanceof Webmasterquery)) {
            return false;
        }
        Webmasterquery other = (Webmasterquery) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Webmasterquery[ id=" + id + " ]";
    }
    
}
