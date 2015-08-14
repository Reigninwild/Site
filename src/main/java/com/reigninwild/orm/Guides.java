package com.reigninwild.orm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "guides")
public class Guides implements Serializable {
    private static final long serialVersionUID = 1L;
    /*----private key---*/
    @Id
    @Column(name = "guide_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    private int guideID;

    /*------------*/
    @Column(name = "guide_text", nullable = true, length = 1000)
    private String guideText;
    /*------------*/
    @Column(name = "news_date", nullable = false)
    private Date guideDate;
    /*------------*/

    /* foreign key, join to users */
    @ManyToOne(targetEntity = Users.class)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private Users guser;

    public int getGuideID() {
        return guideID;
    }

    public void setGuideID(int guideID) {
        this.guideID = guideID;
    }

    public String getGuideText() {
        return guideText;
    }

    public void setGuideText(String guideText) {
        this.guideText = guideText;
    }

    public Date getGuideDate() {
        return guideDate;
    }

    public void setguideDate(Date guideDate) {
        this.guideDate = guideDate;
    }

    public Users getGuser() {
        return guser;
    }

    public void setGuser(Users guser) {
        this.guser = guser;
    }






}
