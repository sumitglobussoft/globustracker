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
@Table(name = "proxydata")
public class ProxyData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ProxyID")
    private Integer proxyID;
    @Basic(optional = false)
    @Column(name = "DateAdded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Basic(optional = false)
    @Column(name = "IPAddress")
    private String iPAddress;
    @Basic(optional = false)
    @Column(name = "PortNo")
    private int portNo;
    @Column(name = "ProxyUser")
    private String proxyUser;
    @Column(name = "ProxyPassword")
    private String proxyPassword;
    @Column(name = "Blocked")
    private Integer blocked;
    @Column(name = "UseCount")
    private Integer useCount;
    @Column(name = "HttpStatusCode")
    private Integer httpStatusCode;
    @Column(name = "Exception")
    private String exception;
    @Column(name = "PageSource")
    private String pageSource;
    @Column(name = "Url")
    private String url;
    @Column(name = "GoogleBlocked")
    private Integer googleBlocked;
    @Column(name = "ResponseTime")
    private String responseTime;

    public ProxyData() {
    }

    public ProxyData(Integer proxyID) {
        this.proxyID = proxyID;
    }

    public ProxyData(Integer proxyID, Date dateAdded, String iPAddress, int portNo) {
        this.proxyID = proxyID;
        this.dateAdded = dateAdded;
        this.iPAddress = iPAddress;
        this.portNo = portNo;
    }

    public Integer getProxyID() {
        return proxyID;
    }

    public void setProxyID(Integer proxyID) {
        this.proxyID = proxyID;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getIPAddress() {
        return iPAddress;
    }

    public void setIPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }

    public int getPortNo() {
        return portNo;
    }

    public void setPortNo(int portNo) {
        this.portNo = portNo;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public Integer getBlocked() {
        return blocked;
    }

    public void setBlocked(Integer blocked) {
        this.blocked = blocked;
    }

    public Integer getUseCount() {
        return useCount;
    }

    public void setUseCount(Integer useCount) {
        this.useCount = useCount;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getPageSource() {
        return pageSource;
    }

    public void setPageSource(String pageSource) {
        this.pageSource = pageSource;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getGoogleBlocked() {
        return googleBlocked;
    }

    public void setGoogleBlocked(Integer googleBlocked) {
        this.googleBlocked = googleBlocked;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proxyID != null ? proxyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProxyData)) {
            return false;
        }
        ProxyData other = (ProxyData) object;
        if ((this.proxyID == null && other.proxyID != null) || (this.proxyID != null && !this.proxyID.equals(other.proxyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Proxydata[ proxyID=" + proxyID + " ]";
    }
    
}
