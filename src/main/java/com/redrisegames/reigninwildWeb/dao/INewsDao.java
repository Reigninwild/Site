package com.redrisegames.reigninwildWeb.dao;


import java.util.List;

import com.redrisegames.reigninwildWeb.orm.News;


public interface INewsDao {
    public void save(News news);

    public void delete(News news);

    public void update(News news);
    
    public News getTarget(int id);
    
    public List<News> getNews();

    public List<News> getNewCount(int count);
    
    public News getLast();
}
