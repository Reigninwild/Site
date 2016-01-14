package com.redrisegames.reigninwildWeb.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "media")
public class Media implements Serializable {
    private static final long serialVersionUID = 1L;
    /*----private key---*/
   @Id
   @Column(name = "media_id")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
   @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    private int mediaID;

    /*------------*/
    @Column(name = "url", nullable = true, length = 200)
    private String url;
    /*------------*/
    /*------------*/
    @Column(name = "description", nullable = true, length = 100)
    private String description;
    /*------------*/
   @Column(name = "type", nullable = true, length = 1)
    private String type;
    /*------------*/
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }



}