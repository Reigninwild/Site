package com.redrisegames.reigninwildWeb.dao;

import java.util.List;

import com.redrisegames.reigninwildWeb.orm.Media;

public interface IMediaDao {
    public void save(Media media);
    public void delete(Media media);
    public void update(Media media);
    public List<Media> getVideos();
    public List<Media> getPictures();
}
