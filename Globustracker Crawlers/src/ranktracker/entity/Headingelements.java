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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author GLB-214
 */
@Entity
@Table(name = "headingelements")
public class Headingelements implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "h1elements")
    private String h1elements;
    @Lob
    @Column(name = "h2elements")
    private String h2elements;
    @Lob
    @Column(name = "h3elements")
    private String h3elements;
    @Lob
    @Column(name = "h4elements")
    private String h4elements;
    @Lob
    @Column(name = "h5elements")
    private String h5elements;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;

    public Headingelements() {
    }

    public Headingelements(Integer id) {
        this.id = id;
    }

    public Headingelements(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getH1elements() {
        return h1elements;
    }

    public void setH1elements(String h1elements) {
        this.h1elements = h1elements;
    }

    public String getH2elements() {
        return h2elements;
    }

    public void setH2elements(String h2elements) {
        this.h2elements = h2elements;
    }

    public String getH3elements() {
        return h3elements;
    }

    public void setH3elements(String h3elements) {
        this.h3elements = h3elements;
    }

    public String getH4elements() {
        return h4elements;
    }

    public void setH4elements(String h4elements) {
        this.h4elements = h4elements;
    }

    public String getH5elements() {
        return h5elements;
    }

    public void setH5elements(String h5elements) {
        this.h5elements = h5elements;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
