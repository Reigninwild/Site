package com.redrisegames.reigninwildWeb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<News> getNewCount(int count) {
        List<News> allnews = (List<News>) hibernateTemplate.find("from News n order by n.newsID DESC");
        
        List<News> news = new ArrayList<News>();
        
        if (allnews.size() > count) {
            if ((allnews.size() - count) < 3) {
                news = allnews.subList(count, count + (allnews.size() - count));
            } else {
                news = allnews.subList(count, count + 3);
            }
        }
        
        return news;
    }
    
    public News getLast() {
  	  List<News> news = (List<News>) hibernateTemplate.find("from News");
  	  
        return news.get(news.size()-1);
      }

    public News getTarget(int id) {
        List<News> news = (List<News>) hibernateTemplate.find("from News n where n.newsID = "+id+"");
        News result = new News();
        if (news.size()!=0) result = news.get(0);
        else result =null;
        return result;
    }
}
