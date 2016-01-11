package com.redrisegames.reigninwildWeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redrisegames.reigninwildWeb.dao.IEmailsDao;
import com.redrisegames.reigninwildWeb.orm.Emails;

@Service("EmailsService")
public class EmailsService implements IEmailsService{
	
	
    @Autowired
    private IEmailsDao emailsDao;

	public void save(Emails email) {
		emailsDao.save(email);		
	}

	public void delete(Emails email) {
		emailsDao.delete(email);
	}

	public void update(Emails email) {
		emailsDao.update(email);
	}

	public List<Emails> getEmails() {
		// TODO Auto-generated method stub
		return emailsDao.getEmails();
	}

	public Emails getEmail(String email) {
		// TODO Auto-generated method stub
		return emailsDao.getEmail(email);
	}

}


