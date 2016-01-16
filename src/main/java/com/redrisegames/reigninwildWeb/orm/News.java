package com.redrisegames.reigninwildWeb.orm;
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




@Entity
@Table(name = "news")
public class News implements Serializable {
    private static final long serialVersionUID = 1L;
    /*----private key---*/
    @Id
    @Column(name = "news_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    private int newsID;
    
    @Column(name = "news_title", nullable = true, length = 200)
    private String newsTitle;

    @Column(name = "news_text", nullable = true, length = 1000)
    private String newsText;

    @Column(name = "news_text_ru", nullable = true, length = 1000)
    private String newsTextRU;

    @Column(name = "news_date", nullable = false)
    private Date newsDate;

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsTextRU() {
        return newsTextRU;
    }

    public void setNewsTextRU(String newsTextRU) {
        this.newsTextRU = newsTextRU;
    }

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}


}

