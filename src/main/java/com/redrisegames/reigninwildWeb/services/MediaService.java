package com.redrisegames.reigninwildWeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redrisegames.reigninwildWeb.dao.IMediaDao;
import com.redrisegames.reigninwildWeb.orm.Media;

@Service("MediaService")
public class MediaService implements IMediaService {

    @Autowired
    private IMediaDao mediaDao;

    
    public void save(Media media) {
        mediaDao.save(media);
    }

    public void delete(Media media) {
        mediaDao.delete(media);
    }

    public void update(Media media) {
        mediaDao.update(media);
    }

    public List<Media> getVideos() {
        // TODO Auto-generated method stub
        return mediaDao.getVideos();
    }
    
    public List<Media> getPictures() {
        // TODO Auto-generated method stub
        return mediaDao.getPictures();
    }

}
