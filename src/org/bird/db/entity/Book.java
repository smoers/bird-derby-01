/**
 * This file was generated by the JPA Modeler
 */ 

package org.bird.db.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="BOOK")
public class Book implements Serializable { 

    @Column(name="ID",table="BOOK",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="TITLE",table="BOOK",nullable=false,length=500)
    @Basic(optional=false)
    private String title;

    @Column(name="PRESENTATION",table="BOOK")
    @Lob
    @Basic
    private String presentation;

    @Column(name="COVER",table="BOOK",length=500)
    @Basic
    private String cover;

    @Column(name="EDITOR",table="BOOK")
    @Basic
    private String editor;

    @Column(name="COLLECTION",table="BOOK")
    @Basic
    private String collection;

    @Column(name="ISBN",table="BOOK",length=100)
    @Basic
    private String isbn;

    @Column(name="CREATIONDATE",table="BOOK")
    @Basic
    @Temporal(TemporalType.DATE)
    private Date creationdate;

    @ManyToOne(optional=false,targetEntity = System.class)
    @JoinColumn(name="STYLE_ID",referencedColumnName="ID")
    private System styleId;

    @OneToMany(targetEntity = Cycle.class,mappedBy = "bookId")
    private List<Cycle> cycleCollection;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPresentation() {
        return this.presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getEditor() {
        return this.editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCollection() {
        return this.collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public System getStyleId() {
        return this.styleId;
    }

    public void setStyleId(System styleId) {
        this.styleId = styleId;
    }

    public List<Cycle> getCycleCollection() {
        return this.cycleCollection;
    }

    public void setCycleCollection(List<Cycle> cycleCollection) {
        this.cycleCollection = cycleCollection;
    }


}
