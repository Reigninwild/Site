package com.redrisegames.reigninwildWeb.orm;
import java.io.Serializable;


import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




/**
 * @author st02
 * 
 */

@Entity
@Table(name = "users")
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    /*----private key---*/
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    private int userID;

    /*------------*/
    @Column(name = "username", nullable = false, length = 20)
    private String username;
    /*------------*/
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    /*------------*/
    @Column(name = "email", length = 30)
    private String email;
    /*------------*/
    @Column(name = "user_group", length = 30)
    private String usergroup;
    /*------------*/


    /* setters */
    public void setUserID(int id) {
        this.userID = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserGroup(String usergroup) {
        this.usergroup = usergroup;
    }

 

    /* getters */
    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserGroup() {
        return usergroup;
    }




}
