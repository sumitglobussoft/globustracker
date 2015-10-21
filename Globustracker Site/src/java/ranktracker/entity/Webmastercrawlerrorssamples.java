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
@Table(name = "webmastercrawlerrorssamples")
@NamedQueries({
    @NamedQuery(name = "Webmastercrawlerrorssamples.findAll", query = "SELECT w FROM Webmastercrawlerrorssamples w")})
public class Webmastercrawlerrorssamples implements Serializable {
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
    @Column(name = "pageurl")
    private String pageurl;
    @Basic(optional = false)
    @Column(name = "lastcrawled")
    @Temporal(TemporalType.DATE)
    private Date lastcrawled;
    @Basic(optional = false)
    @Column(name = "firstdetected")
    @Temporal(TemporalType.DATE)
    private Date firstdetected;
    @Basic(optional = false)
    @Column(name = "responsecode")
    private int responsecode;

    public Webmastercrawlerrorssamples() {
    }

    public Webmastercrawlerrorssamples(Integer id) {
        this.id = id;
    }

    public Webmastercrawlerrorssamples(Integer id, String siteurl, String pageurl, Date lastcrawled, Date firstdetected, int responsecode) {
        this.id = id;
        this.siteurl = siteurl;
        this.pageurl = pageurl;
        this.lastcrawled = lastcrawled;
        this.firstdetected = firstdetected;
        this.responsecode = responsecode;
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

    public String getPageurl() {
        return pageurl;
    }

    public void setPageurl(String pageurl) {
        this.pageurl = pageurl;
    }

    public Date getLastcrawled() {
        return lastcrawled;
    }

    public void setLastcrawled(Date lastcrawled) {
        this.lastcrawled = lastcrawled;
    }

    public Date getFirstdetected() {
        return firstdetected;
    }

    public void setFirstdetected(Date firstdetected) {
        this.firstdetected = firstdetected;
    }

    public int getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(int responsecode) {
        this.responsecode = responsecode;
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
        if (!(object instanceof Webmastercrawlerrorssamples)) {
            return false;
        }
        Webmastercrawlerrorssamples other = (Webmastercrawlerrorssamples) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Webmastercrawlerrorssamples[ id=" + id + " ]";
    }
    
}
