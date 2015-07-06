/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "displaysettings")
@XmlRootElement
public class Displaysettings implements Serializable {

    @Column(name = "Googletab", nullable = false)
    private int googletab;
    @Column(name = "Yahootab", nullable = false)
    private int yahootab;
    @Column(name = "Bingtab", nullable = false)
    private int bingtab;
    @Column(name = "Daychangetab", nullable = false)
    private int daychangetab;
    @Column(name = "Weekchangetab", nullable = false)
    private int weekchangetab;
    @Column(name = "Monthchangetab", nullable = false)
    private int monthchangetab;
    @Column(name = "Alexatab", nullable = false)
    private int alexatab;
    @Column(name = "Backlinkstab", nullable = false)
    private int backlinkstab;
    @Column(name = "Monthlysearchstab", nullable = false)
    private int monthlysearchstab;
    @Column(name = "SItab", nullable = false)
    private int sItab;
    @Column(name = "Serpcampaigntab", nullable = false)
    private int serpcampaigntab;
    @Column(name = "Videocampaigntab", nullable = false)
    private int videocampaigntab;
    @Column(name = "Summerytab", nullable = false)
    private int summarytab;
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DisplaysettingsID", nullable = false)
    private Integer displaysettingsID;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerID", nullable = false)
    @ManyToOne(optional = false)
    private Customers customerId;

    public Displaysettings() {
    }

    public Displaysettings(Integer displaysettingsID) {
        this.displaysettingsID = displaysettingsID;
    }

    public Displaysettings(Integer displaysettingsID, int googletab, int yahootab, int bingtab, int daychangetab, int weekchangetab, int monthchangetab, int alexatab, int backlinkstab, int monthlysearchstab, int sItab, int summarytab, int serpcampaigntab, int videocampaigntab) {
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
        this.sItab = sItab;
        this.serpcampaigntab = serpcampaigntab;
        this.videocampaigntab = videocampaigntab;
        this.summarytab = summarytab;
    }

    public Integer getDisplaysettingsID() {
        return displaysettingsID;
    }

    public void setDisplaysettingsID(Integer displaysettingsID) {
        this.displaysettingsID = displaysettingsID;
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
        return "entity.Displaysettings[ displaysettingsID=" + displaysettingsID + " ]";
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

    public int getSItab() {
        return sItab;
    }

    public void setSItab(int sItab) {
        this.sItab = sItab;
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

    public int getSummarytab() {
        return summarytab;
    }

    public void setSummarytab(int summarytab) {
        this.summarytab = summarytab;
    }

}
