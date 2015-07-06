/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @Laxmi Kiran Nallam(laxmikiran@globussoft.com) User
 */
public class CampaignKeywordsPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="CampaignID",referencedColumnName="campaignID")
    private Campaigns campaignId;
    
    @ManyToOne
    @JoinColumn(name="KeywordID",referencedColumnName="keywordId")
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
