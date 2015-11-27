package com.reigninwild.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.reigninwild.dao.INewsDao;
import com.reigninwild.orm.News;

@Service("NewsService")
@Transactional(readOnly = false)
public class NewsService implements INewsService  {

    @Autowired
    private INewsDao newsDao;

    public void setDao(INewsDao dao) {
        this.newsDao = dao;
    }
    

    public UserDetails loadUserByUsername(String arg0)
            throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }



    public void saveNews(News news) {
        newsDao.save(news);
    }



    public void deleteNews(News news) {
        newsDao.delete(news);
    }



    public void updateNews(News news) {
        newsDao.update(news);
    }



    public List<News> getAllNews() {
        return newsDao.getNews();
    }


    public List<News> getNewsCount(int count) {
        // TODO Auto-generated method stub
        return newsDao.getNewCount(count);
    }


    public News getTarget(int id) {
        // TODO Auto-generated method stub
        return newsDao.getTarget(id);
    }


	public News getLast() {
		// TODO Auto-generated method stub
		return newsDao.getLast();
	}

}
