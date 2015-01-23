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
import javax.persistence.Table;

/**
 *
 * @author GLB-008
 */
@Entity
@Table(name = "reportfrequency")
public class Reportfrequency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FrequencyId")
    private Integer frequencyId;
    @Basic(optional = false)
    @Column(name = "FrequencyDetail")
    private String frequencyDetail;

    public Reportfrequency() {
    }

    public Reportfrequency(Integer frequencyId) {
        this.frequencyId = frequencyId;
    }

    public Reportfrequency(Integer frequencyId, String frequencyDetail) {
        this.frequencyId = frequencyId;
        this.frequencyDetail = frequencyDetail;
    }

    public Integer getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(Integer frequencyId) {
        this.frequencyId = frequencyId;
    }

    public String getFrequencyDetail() {
        return frequencyDetail;
    }

    public void setFrequencyDetail(String frequencyDetail) {
        this.frequencyDetail = frequencyDetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frequencyId != null ? frequencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reportfrequency)) {
            return false;
        }
        Reportfrequency other = (Reportfrequency) object;
        if ((this.frequencyId == null && other.frequencyId != null) || (this.frequencyId != null && !this.frequencyId.equals(other.frequencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ranktracker.entity.Reportfrequency[ frequencyId=" + frequencyId + " ]";
    }
    
}
