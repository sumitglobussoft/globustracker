/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com)
 */
@Entity 
@IdClass(CampaignKeywordsPK.class)
@Table(name="campaignkeywords")
public class CampaignKeywords {
    @Id
 private Campaigns campaignId;
 @Id
 private Serpkeywords keywordId; 

    public Campaigns getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Campaigns campaignId) {
        this.campaignId = campaignId;
    }

    public Serpkeywords getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(Serpkeywords keywordId) {
        this.keywordId = keywordId;
    }
}
