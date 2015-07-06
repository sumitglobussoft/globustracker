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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "displaysettings")
public class Displaysettings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DisplaysettingsID")
    private Integer displaysettingsID;
    @Basic(optional = false)
    @Column(name = "Googletab")
    private int googletab;
    @Basic(optional = false)
    @Column(name = "Yahootab")
    private int yahootab;
    @Basic(optional = false)
    @Column(name = "Bingtab")
    private int bingtab;
    @Basic(optional = false)
    @Column(name = "Daychangetab")
    private int daychangetab;
    @Basic(optional = false)
    @Column(name = "Weekchangetab")
    private int weekchangetab;
    @Basic(optional = false)
    @Column(name = "Monthchangetab")
    private int monthchangetab;
    @Basic(optional = false)
    @Column(name = "Alexatab")
    private int alexatab;
    @Basic(optional = false)
    @Column(name = "Backlinkstab")
    private int backlinkstab;
    @Basic(optional = false)
    @Column(name = "Monthlysearchstab")
    private int monthlysearchstab;
    @Basic(optional = false)
    @Column(name = "Serpcampaigntab")
    private int serpcampaigntab;
    @Basic(optional = false)
    @Column(name = "Videocampaigntab")
    private int videocampaigntab;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerId;

    public Displaysettings() {
    }

    public Displaysettings(Integer displaysettingsID) {
        this.displaysettingsID = displaysettingsID;
    }

    public Displaysettings(Integer displaysettingsID, int googletab, int yahootab, int bingtab, int daychangetab, int weekchangetab, int monthchangetab, int alexatab, int backlinkstab, int monthlysearchstab, int serpcampaigntab, int videocampaigntab) {
        this.displaysettingsID = displaysettingsID;
        this.googletab = googletab;
        this.yahootab = yahootab;
        this.bingtab = bingtab;
        this.daychangetab = daychangetab;
        this.weekchangetab = weekchangetab;
        this.monthchangetab = monthchangetab;
        this.alexatab = alexatab;
        this.backlinkstab = backlinkstab;
        this.monthlysearchstab = monthlysearchstab;
        this.serpcampaigntab = serpcampaigntab;
        this.videocampaigntab = videocampaigntab;
    }

    public Integer getDisplaysettingsID() {
        return displaysettingsID;
    }

    public void setDisplaysettingsID(Integer displaysettingsID) {
        this.displaysettingsID = displaysettingsID;
    }

    public int getGoogletab() {
        return googletab;
    }

    public void setGoogletab(int googletab) {
        this.googletab = googletab;
    }

    public int getYahootab() {
        return yahootab;
    }

    public void setYahootab(int yahootab) {
        this.yahootab = yahootab;
    }

    public int getBingtab() {
        return bingtab;
    }

    public void setBingtab(int bingtab) {
        this.bingtab = bingtab;
    }

    public int getDaychangetab() {
        return daychangetab;
    }

    public void setDaychangetab(int daychangetab) {
        this.daychangetab = daychangetab;
    }

    public int getWeekchangetab() {
        return weekchangetab;
    }

    public void setWeekchangetab(int weekchangetab) {
        this.weekchangetab = weekchangetab;
    }

    public int getMonthchangetab() {
        return monthchangetab;
    }

    public void setMonthchangetab(int monthchangetab) {
        this.monthchangetab = monthchangetab;
    }

    public int getAlexatab() {
        return alexatab;
    }

    public void setAlexatab(int alexatab) {
        this.alexatab = alexatab;
    }

    public int getBacklinkstab() {
        return backlinkstab;
    }

    public void setBacklinkstab(int backlinkstab) {
        this.backlinkstab = backlinkstab;
    }

    public int getMonthlysearchstab() {
        return monthlysearchstab;
    }

    public void setMonthlysearchstab(int monthlysearchstab) {
        this.monthlysearchstab = monthlysearchstab;
    }

    public int getSerpcampaigntab() {
        return serpcampaigntab;
    }

    public void setSerpcampaigntab(int serpcampaigntab) {
        this.serpcampaigntab = serpcampaigntab;
    }

    public int getVideocampaigntab() {
        return videocampaigntab;
    }

    public void setVideocampaigntab(int videocampaigntab) {
        this.videocampaigntab = videocampaigntab;
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
        hash += (displaysettingsID != null ? displaysettingsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Displaysettings)) {
            return false;
        }
        Displaysettings other = (Displaysettings) object;
        if ((this.displaysettingsID == null && other.displaysettingsID != null) || (this.displaysettingsID != null && !this.displaysettingsID.equals(other.displaysettingsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Displaysettings[ displaysettingsID=" + displaysettingsID + " ]";
    }
    
}
