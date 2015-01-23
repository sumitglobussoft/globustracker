/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ranktracker.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "campaignkeywords")
public class Campaignkeywords implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CampaignkeywordsPK campaignkeywordsPK;
    @JoinColumn(name = "CampaignId", referencedColumnName = "CampaignID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Campaigns campaigns;

    public Campaignkeywords() {
    }

    public Campaignkeywords(CampaignkeywordsPK campaignkeywordsPK) {
        this.campaignkeywordsPK = campaignkeywordsPK;
    }

    public Campaignkeywords(int campaignId, int keywordID) {
        this.campaignkeywordsPK = new CampaignkeywordsPK(campaignId, keywordID);
    }

    public CampaignkeywordsPK getCampaignkeywordsPK() {
        return campaignkeywordsPK;
    }

    public void setCampaignkeywordsPK(CampaignkeywordsPK campaignkeywordsPK) {
        this.campaignkeywordsPK = campaignkeywordsPK;
    }

    public Campaigns getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(Campaigns campaigns) {
        this.campaigns = campaigns;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campaignkeywordsPK != null ? campaignkeywordsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campaignkeywords)) {
            return false;
        }
        Campaignkeywords other = (Campaignkeywords) object;
        if ((this.campaignkeywordsPK == null && other.campaignkeywordsPK != null) || (this.campaignkeywordsPK != null && !this.campaignkeywordsPK.equals(other.campaignkeywordsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Campaignkeywords[ campaignkeywordsPK=" + campaignkeywordsPK + " ]";
    }
    
}
