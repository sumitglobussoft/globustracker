/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package globuswoo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "serpkeywordgoal")
@XmlRootElement
public class Serpkeywordgoal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SerpKeywordGoalId", nullable = false)
    private Integer serpKeywordGoalId;
    @Column(name = "GoalRank", nullable = false)
    private int goalRank;
    @Column(name = "GoalDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date goalDate;
    @Column(name = "AddedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @JoinColumn(name = "SerpKeywordId", referencedColumnName = "KeywordID", nullable = false)
    @ManyToOne(optional = false)
    private Serpkeywords serpKeywordId;

    public Serpkeywordgoal() {
    }

    public Serpkeywordgoal(Integer serpKeywordGoalId) {
        this.serpKeywordGoalId = serpKeywordGoalId;
    }

    public Serpkeywordgoal(Integer serpKeywordGoalId, int goalRank, Date goalDate, Date addedDate) {
        this.serpKeywordGoalId = serpKeywordGoalId;
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

    public int getGoalRank() {
        return goalRank;
    }

    public void setGoalRank(int goalRank) {
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

    public Serpkeywords getSerpKeywordId() {
        return serpKeywordId;
    }

    public void setSerpKeywordId(Serpkeywords serpKeywordId) {
        this.serpKeywordId = serpKeywordId;
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
