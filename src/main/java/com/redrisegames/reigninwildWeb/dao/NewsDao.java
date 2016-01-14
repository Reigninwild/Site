package com.redrisegames.reigninwildWeb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;

import com.redrisegames.reigninwildWeb.orm.News;

@Transactional
public class NewsDao implements INewsDao {
    
    @Autowired
    private HibernateTemplate  hibernateTemplate;
    
    @Autowired
    private SessionFactory sessionFactory;


   
    
    public void save(News news) {
        hibernateTemplate.save(news);
    }

    /**
     * @see com.exadel.dao.IUsersDao#delete(com.exadel.orm.Users)
     */
    public void delete(News news) {
        hibernateTemplate.delete(news);
    }

    /**
     * @see com.exadel.dao.IUsersDao#update(com.exadel.orm.Users)
     */
    public void update(News news) {
        hibernateTemplate.update(news);
    }

    @SuppressWarnings("unchecked")
    public List<News> getNews() {
        List<News> news = (List<News>) hibernateTemplate.find("from News");
        return news;
    }

    public List<News> getNewCount(int page,int newsOnPage) {
        List<News> allnews = (List<News>) hibernateTemplate.find("from News n order by n.newsID ASC");
        
        int size = allnews.size();
        int first= (size-1) - (page-1)*newsOnPage;
        int last= ((size-1) - (page-1)*newsOnPage-2 > 0) ? (size-1) - (page-1)*newsOnPage-2 : 0;
        
        List<News> news = new ArrayList<News>();
        news = allnews.subList(last,first+1);
        
        return news;
    }
    
    public News getLast() {
  	  List<News> news = (List<News>) hibernateTemplate.find("from News n order by n.newsID DESC LIMIT 1");
  	  News onenews = null;
  	  if (news.size() > 0)
  	    onenews  = news.get(0);
  	  
        return onenews;
      }

    public News getTarget(int id) {
        List<News> news = (List<News>) hibernateTemplate.find("from News n where n.newsID = "+id+"");
        News result = new News();
        if (news.size()!=0) result = news.get(0);
        else result =null;
        return result;
    }


    public int getCount() {
        int count = DataAccessUtils.intResult(hibernateTemplate.find("select count(*) from News"));
        return count;
    }
}
