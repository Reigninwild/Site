package com.reigninwild.dao;

import java.util.List;

import com.reigninwild.orm.Emails;

public interface IEmailsDao {
    public void save(Emails email);

    public void delete(Emails email);

    public void update(Emails email);
    
    public List<Emails> getEmails();
    
    public Emails getEmail(String email);

}
