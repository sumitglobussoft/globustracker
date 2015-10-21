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
@Table(name = "webmastersitemap")
@NamedQueries({
    @NamedQuery(name = "Webmastersitemap.findAll", query = "SELECT w FROM Webmastersitemap w")})
public class Webmastersitemap implements Serializable {
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
    @Column(name = "indexed")
    private long indexed;
    @Basic(optional = false)
    @Column(name = "submitted")
    private long submitted;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "path")
    private String path;
    @Basic(optional = false)
    @Column(name = "lastsubmitteddate")
    @Temporal(TemporalType.DATE)
    private Date lastsubmitteddate;
    @Basic(optional = false)
    @Column(name = "typemap")
    private String typemap;
    @Basic(optional = false)
    @Column(name = "lastdownloadeddate")
    @Temporal(TemporalType.DATE)
    private Date lastdownloadeddate;
    @Basic(optional = false)
    @Column(name = "errors")
    private long errors;
    @Basic(optional = false)
    @Column(name = "warning")
    private long warning;

    public Webmastersitemap() {
    }

    public Webmastersitemap(Integer id) {
        this.id = id;
    }

    public Webmastersitemap(Integer id, String siteurl, long indexed, long submitted, String type, String path, Date lastsubmitteddate, String typemap, Date lastdownloadeddate, long errors, long warning) {
        this.id = id;
        this.siteurl = siteurl;
        this.indexed = indexed;
        this.submitted = submitted;
        this.type = type;
        this.path = path;
        this.lastsubmitteddate = lastsubmitteddate;
        this.typemap = typemap;
        this.lastdownloadeddate = lastdownloadeddate;
        this.errors = errors;
        this.warning = warning;
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

    public long getIndexed() {
        return indexed;
    }

    public void setIndexed(long indexed) {
        this.indexed = indexed;
    }

    public long getSubmitted() {
        return submitted;
    }

    public void setSubmitted(long submitted) {
        this.submitted = submitted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getLastsubmitteddate() {
        return lastsubmitteddate;
    }

    public void setLastsubmitteddate(Date lastsubmitteddate) {
        this.lastsubmitteddate = lastsubmitteddate;
    }

    public String getTypemap() {
        return typemap;
    }

    public void setTypemap(String typemap) {
        this.typemap = typemap;
    }

    public Date getLastdownloadeddate() {
        return lastdownloadeddate;
    }

    public void setLastdownloadeddate(Date lastdownloadeddate) {
        this.lastdownloadeddate = lastdownloadeddate;
    }

    public long getErrors() {
        return errors;
    }

    public void setErrors(long errors) {
        this.errors = errors;
    }

    public long getWarning() {
        return warning;
    }

    public void setWarning(long warning) {
        this.warning = warning;
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
        if (!(object instanceof Webmastersitemap)) {
            return false;
        }
        Webmastersitemap other = (Webmastersitemap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Webmastersitemap[ id=" + id + " ]";
    }
    
}
