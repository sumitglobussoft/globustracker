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
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "site")
public class Site implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SiteId")
    private Long siteId;
    @Basic(optional = false)
    @Column(name = "ResellerId")
    private long resellerId;
    @Basic(optional = false)
    @Column(name = "Ip")
    private String ip;
    @Basic(optional = false)
    @Column(name = "Domain")
    private String domain;
    @Column(name = "Logo")
    private String logo;
    @Column(name = "Css")
    private String css;

    public Site() {
    }

    public Site(Long siteId) {
        this.siteId = siteId;
    }

    public Site(Long siteId, long resellerId, String ip, String domain) {
        this.siteId = siteId;
        this.resellerId = resellerId;
        this.ip = ip;
        this.domain = domain;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public long getResellerId() {
        return resellerId;
    }

    public void setResellerId(long resellerId) {
        this.resellerId = resellerId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteId != null ? siteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.siteId == null && other.siteId != null) || (this.siteId != null && !this.siteId.equals(other.siteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Site[ siteId=" + siteId + " ]";
    }
    
}
