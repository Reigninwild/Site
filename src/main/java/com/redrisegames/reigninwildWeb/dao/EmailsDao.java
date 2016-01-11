package com.redrisegames.reigninwildWeb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.redrisegames.reigninwildWeb.orm.Emails;


@Transactional
public class EmailsDao implements IEmailsDao{

    @Autowired
    private HibernateTemplate  hibernateTemplate;
    
	public void save(Emails email) {
	      hibernateTemplate.save(email);
	}

	public void delete(Emails email) {
		  hibernateTemplate.delete(email);
	}

	public void update(Emails email) {
		  hibernateTemplate.update(email);
	}

	@SuppressWarnings("unchecked")
	public List<Emails> getEmails() {
		 List<Emails> emails = (List<Emails>) hibernateTemplate.find("from Emails");
	        return emails;
	}

	@SuppressWarnings("unchecked")
	public Emails getEmail(String email) {
		 List<Emails> emails = (List<Emails>) hibernateTemplate.find("from Emails e where e.email = '"+email+"'");
		 Emails femail = new Emails();
		 if (emails.size() > 0) {
			 femail= emails.get(0);
		 }
	        return femail;
	}

	     
}

