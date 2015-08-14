package com.reigninwild.services;

import java.util.List;

import com.reigninwild.orm.News;

public interface INewsService {

    public void saveNews(News news);

    public void deleteNews(News news);

    public void updateNews(News news);
    
    public News getTarget(int id);

    public List<News> getAllNews();
    
    public List<News> getNewsCount(int count);
  
}
