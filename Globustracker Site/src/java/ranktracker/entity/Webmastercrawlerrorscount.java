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
@Table(name = "webmastercrawlerrorscount")
@NamedQueries({
    @NamedQuery(name = "Webmastercrawlerrorscount.findAll", query = "SELECT w FROM Webmastercrawlerrorscount w")})
public class Webmastercrawlerrorscount implements Serializable {
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
    @Column(name = "platform")
    private String platform;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @Column(name = "count")
    private long count;
    @Basic(optional = false)
    @Column(name = "datestring")
    @Temporal(TemporalType.DATE)
    private Date datestring;

    public Webmastercrawlerrorscount() {
    }

    public Webmastercrawlerrorscount(Integer id) {
        this.id = id;
    }

    public Webmastercrawlerrorscount(Integer id, String siteurl, String platform, String category, long count, Date datestring) {
        this.id = id;
        this.siteurl = siteurl;
        this.platform = platform;
        this.category = category;
        this.count = count;
        this.datestring = datestring;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Date getDatestring() {
        return datestring;
    }

    public void setDatestring(Date datestring) {
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
        if (!(object instanceof Webmastercrawlerrorscount)) {
            return false;
        }
        Webmastercrawlerrorscount other = (Webmastercrawlerrorscount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Webmastercrawlerrorscount[ id=" + id + " ]";
    }
    
}
