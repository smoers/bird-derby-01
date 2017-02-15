/**
 * This file was generated by the JPA Modeler
 */ 

package org.bird.db.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="SYSTEM")
public class System implements Serializable { 

    @Column(name="ID",table="SYSTEM",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="KEY",table="SYSTEM",nullable=false,length=100)
    @Basic(optional=false)
    private String key;

    @Column(name="VALUE",table="SYSTEM",nullable=false)
    @Basic(optional=false)
    private String value;

    @Column(name="ENABLED",table="SYSTEM")
    @Basic
    private Boolean enabled;

    @OneToMany(targetEntity = Book.class,mappedBy = "styleId")
    private List<Book> bookCollection;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Book> getBookCollection() {
        return this.bookCollection;
    }

    public void setBookCollection(List<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }


}
