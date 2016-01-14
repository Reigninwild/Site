package com.redrisegames.reigninwildWeb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.redrisegames.reigninwildWeb.orm.Emails;
import com.redrisegames.reigninwildWeb.orm.Media;

public class MediaDao implements IMediaDao{


    @Autowired
    private HibernateTemplate  hibernateTemplate;
    
    public void save(Emails email) {
          hibernateTemplate.save(email);
    }
    
    public void save(Media media) {
        hibernateTemplate.save(media);
    }

    public void delete(Media media) {
        hibernateTemplate.delete(media);
    }

    public void update(Media media) {
        hibernateTemplate.update(media);
    }

    public List<Media> getVideos() {
        List<Media> medias = (List<Media>) hibernateTemplate.find("from Media m where m.type = 'v'");
           return medias;
   }
    
    public List<Media> getPictures() {
        List<Media> medias = (List<Media>) hibernateTemplate.find("from Media m where m.type = 'p'");
           return medias;
   }
    
    

}
