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
    private short googletab;
    @Basic(optional = false)
    @Column(name = "Yahootab")
    private short yahootab;
    @Basic(optional = false)
    @Column(name = "Bingtab")
    private short bingtab;
    @Basic(optional = false)
    @Column(name = "Daychangetab")
    private short daychangetab;
    @Basic(optional = false)
    @Column(name = "Weekchangetab")
    private short weekchangetab;
    @Basic(optional = false)
    @Column(name = "Monthchangetab")
    private short monthchangetab;
    @Basic(optional = false)
    @Column(name = "Alexatab")
    private short alexatab;
    @Basic(optional = false)
    @Column(name = "Backlinkstab")
    private short backlinkstab;
    @Basic(optional = false)
    @Column(name = "Monthlysearchstab")
    private short monthlysearchstab;
    @Basic(optional = false)
    @Column(name = "Serpcampaigntab")
    private short serpcampaigntab;
    @Basic(optional = false)
    @Column(name = "Videocampaigntab")
    private short videocampaigntab;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerID")
    @ManyToOne(optional = false)
    private Customers customerId;

    public Displaysettings() {
    }

    public Displaysettings(Integer displaysettingsID) {
        this.displaysettingsID = displaysettingsID;
    }

    public Displaysettings(Integer displaysettingsID, short googletab, short yahootab, short bingtab, short daychangetab, short weekchangetab, short monthchangetab, short alexatab, short backlinkstab, short monthlysearchstab, short serpcampaigntab, short videocampaigntab) {
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

    public short getGoogletab() {
        return googletab;
    }

    public void setGoogletab(short googletab) {
        this.googletab = googletab;
    }

    public short getYahootab() {
        return yahootab;
    }

    public void setYahootab(short yahootab) {
        this.yahootab = yahootab;
    }

    public short getBingtab() {
        return bingtab;
    }

    public void setBingtab(short bingtab) {
        this.bingtab = bingtab;
    }

    public short getDaychangetab() {
        return daychangetab;
    }

    public void setDaychangetab(short daychangetab) {
        this.daychangetab = daychangetab;
    }

    public short getWeekchangetab() {
        return weekchangetab;
    }

    public void setWeekchangetab(short weekchangetab) {
        this.weekchangetab = weekchangetab;
    }

    public short getMonthchangetab() {
        return monthchangetab;
    }

    public void setMonthchangetab(short monthchangetab) {
        this.monthchangetab = monthchangetab;
    }

    public short getAlexatab() {
        return alexatab;
    }

    public void setAlexatab(short alexatab) {
        this.alexatab = alexatab;
    }

    public short getBacklinkstab() {
        return backlinkstab;
    }

    public void setBacklinkstab(short backlinkstab) {
        this.backlinkstab = backlinkstab;
    }

    public short getMonthlysearchstab() {
        return monthlysearchstab;
    }

    public void setMonthlysearchstab(short monthlysearchstab) {
        this.monthlysearchstab = monthlysearchstab;
    }

    public short getSerpcampaigntab() {
        return serpcampaigntab;
    }

    public void setSerpcampaigntab(short serpcampaigntab) {
        this.serpcampaigntab = serpcampaigntab;
    }

    public short getVideocampaigntab() {
        return videocampaigntab;
    }

    public void setVideocampaigntab(short videocampaigntab) {
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
