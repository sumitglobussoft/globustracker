/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ranktracker.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author GLB-008
 */
@Embeddable
public class CampaignkeywordsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CampaignId")
    private int campaignId;
    @Basic(optional = false)
    @Column(name = "KeywordID")
    private int keywordID;

    public CampaignkeywordsPK() {
    }

    public CampaignkeywordsPK(int campaignId, int keywordID) {
        this.campaignId = campaignId;
        this.keywordID = keywordID;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getKeywordID() {
        return keywordID;
    }

    public void setKeywordID(int keywordID) {
        this.keywordID = keywordID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) campaignId;
        hash += (int) keywordID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampaignkeywordsPK)) {
            return false;
        }
        CampaignkeywordsPK other = (CampaignkeywordsPK) object;
        if (this.campaignId != other.campaignId) {
            return false;
        }
        if (this.keywordID != other.keywordID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.CampaignkeywordsPK[ campaignId=" + campaignId + ", keywordID=" + keywordID + " ]";
    }
    
}
