package com.redrisegames.reigninwildWeb.dao;

import java.util.List;

import com.redrisegames.reigninwildWeb.orm.Emails;

public interface IEmailsDao {
    public void save(Emails email);

    public void delete(Emails email);

    public void update(Emails email);
    
    public List<Emails> getEmails();
    
    public Emails getEmail(String email);

}
