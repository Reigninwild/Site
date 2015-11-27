package com.reigninwild.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reigninwild.dao.IEmailsDao;
import com.reigninwild.orm.Emails;

@Service("EmailsService")
public class EmailsService implements IEmailsService{
	
	
    @Autowired
    private IEmailsDao emailsDao;

    public void setDao(IEmailsDao dao) {
        this.emailsDao = dao;
    }

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


