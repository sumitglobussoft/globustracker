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
@Table(name = "serpkeywordgoal")
public class Serpkeywordgoal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SerpKeywordGoalId")
    private Integer serpKeywordGoalId;
    @Basic(optional = false)
    @Column(name = "SerpKeywordId")
    private int serpKeywordId;
    @Basic(optional = false)
    @Column(name = "GoalRank")
    private short goalRank;
    @Basic(optional = false)
    @Column(name = "GoalDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date goalDate;
    @Basic(optional = false)
    @Column(name = "AddedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    public Serpkeywordgoal() {
    }

    public Serpkeywordgoal(Integer serpKeywordGoalId) {
        this.serpKeywordGoalId = serpKeywordGoalId;
    }

    public Serpkeywordgoal(Integer serpKeywordGoalId, int serpKeywordId, short goalRank, Date goalDate, Date addedDate) {
        this.serpKeywordGoalId = serpKeywordGoalId;
        this.serpKeywordId = serpKeywordId;
        this.goalRank = goalRank;
        this.goalDate = goalDate;
        this.addedDate = addedDate;
    }

    public Integer getSerpKeywordGoalId() {
        return serpKeywordGoalId;
    }

    public void setSerpKeywordGoalId(Integer serpKeywordGoalId) {
        this.serpKeywordGoalId = serpKeywordGoalId;
    }

    public int getSerpKeywordId() {
        return serpKeywordId;
    }

    public void setSerpKeywordId(int serpKeywordId) {
        this.serpKeywordId = serpKeywordId;
    }

    public short getGoalRank() {
        return goalRank;
    }

    public void setGoalRank(short goalRank) {
        this.goalRank = goalRank;
    }

    public Date getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(Date goalDate) {
        this.goalDate = goalDate;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serpKeywordGoalId != null ? serpKeywordGoalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serpkeywordgoal)) {
            return false;
        }
        Serpkeywordgoal other = (Serpkeywordgoal) object;
        if ((this.serpKeywordGoalId == null && other.serpKeywordGoalId != null) || (this.serpKeywordGoalId != null && !this.serpKeywordGoalId.equals(other.serpKeywordGoalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Serpkeywordgoal[ serpKeywordGoalId=" + serpKeywordGoalId + " ]";
    }
    
}
