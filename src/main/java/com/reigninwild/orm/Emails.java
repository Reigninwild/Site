package com.reigninwild.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name = "emails")
public class Emails implements Serializable {
    private static final long serialVersionUID = 1L;
    /*----private key---*/
   @Id
   @Column(name = "email_id")
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
   @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    private int email_id;

    /*------------*/
    @Column(name = "email", nullable = true, length = 30)
    private String email;
    /*------------*/

	public int getEmail_id() {
		return email_id;
	}

	public void setEmail_id(int email_id) {
		this.email_id = email_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}

