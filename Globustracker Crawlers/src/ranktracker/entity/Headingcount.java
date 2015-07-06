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
 * @author GLB-214
 */
@Entity
@Table(name = "headingcount")
public class Headingcount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "heading1")
    private String heading1;
    @Column(name = "heading2")
    private String heading2;
    @Column(name = "heading3")
    private String heading3;
    @Column(name = "heading4")
    private String heading4;
    @Column(name = "heading5")
    private String heading5;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;

    public Headingcount() {
    }

    public Headingcount(Integer id) {
        this.id = id;
    }

    public Headingcount(Integer id, String url) {
        this.id = id;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeading1() {
        return heading1;
    }

    public void setHeading1(String heading1) {
        this.heading1 = heading1;
    }

    public String getHeading2() {
        return heading2;
    }

    public void setHeading2(String heading2) {
        this.heading2 = heading2;
    }

    public String getHeading3() {
        return heading3;
    }

    public void setHeading3(String heading3) {
        this.heading3 = heading3;
    }

    public String getHeading4() {
        return heading4;
    }

    public void setHeading4(String heading4) {
        this.heading4 = heading4;
    }

    public String getHeading5() {
        return heading5;
    }

    public void setHeading5(String heading5) {
        this.heading5 = heading5;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

 
}
