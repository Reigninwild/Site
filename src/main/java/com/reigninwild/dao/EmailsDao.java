package com.reigninwild.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.reigninwild.orm.Emails;
import com.reigninwild.orm.News;

public class EmailsDao extends HibernateDaoSupport implements IEmailsDao{

	public void save(Emails email) {
	      getHibernateTemplate().save(email);
	}

	public void delete(Emails email) {
		  getHibernateTemplate().delete(email);
	}

	public void update(Emails email) {
		  getHibernateTemplate().update(email);
	}

	@SuppressWarnings("unchecked")
	public List<Emails> getEmails() {
		 List<Emails> emails = getHibernateTemplate().find("from Emails");
	        return emails;
	}

	@SuppressWarnings("unchecked")
	public Emails getEmail(String email) {
		 List<Emails> emails = getHibernateTemplate().find("from Emails e where e.email = '"+email+"'");
		 Emails femail = new Emails();
		 if (emails.size() > 0) {
			 femail= emails.get(0);
		 }
	        return femail;
	}

	     
}

