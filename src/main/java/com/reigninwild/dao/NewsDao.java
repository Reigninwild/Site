package com.reigninwild.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.reigninwild.orm.News;

public class NewsDao extends HibernateDaoSupport implements INewsDao {
    public void save(News news) {
        getHibernateTemplate().save(news);
    }

    /**
     * @see com.exadel.dao.IUsersDao#delete(com.exadel.orm.Users)
     */
    public void delete(News news) {
        getHibernateTemplate().delete(news);
    }

    /**
     * @see com.exadel.dao.IUsersDao#update(com.exadel.orm.Users)
     */
    public void update(News news) {
        getHibernateTemplate().update(news);
    }

    @SuppressWarnings("unchecked")
    public List<News> getNews() {
        List<News> news = getHibernateTemplate().find("from News");
        return news;
    }

    public List<News> getNewCount(int count) {
        List<News> allnews = getHibernateTemplate().find("from News n order by n.newsID DESC");
        
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

    public News getTarget(int id) {
        List<News> news = getHibernateTemplate().find("from News n where n.newsID = "+id+"");
        News result = new News();
        if (news.size()!=0) result = news.get(0);
        else result =null;
        return result;
    }
}
