package com.reigninwild.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reigninwild.dao.IGuidesDao;
import com.reigninwild.orm.Guides;

@Service("GuidesService")
@Transactional(readOnly = false)
public class GuidesService implements IGuidesService {
    
    @Autowired
    private IGuidesDao guidesDao;

    public void setDao(IGuidesDao dao) {
        this.guidesDao = dao;
    }

    public void saveGuides(Guides guide) {
        guidesDao.save(guide);
    }

    public void deleteGuides(Guides guide) {
        guidesDao.delete(guide);
    }

    public void updateGuides(Guides guide) {
        guidesDao.update(guide);
    }

    public List<Guides> getAllGuides() {
        return guidesDao.getGuides();
    }

}
