package com.reigninwild.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reigninwild.dao.ICraftsDao;
import com.reigninwild.orm.Crafts;

@Service("CraftsService")
@Transactional(readOnly = false)
public class CraftsService implements ICraftsService{
    
    @Autowired
    private ICraftsDao craftssDao;

    public void setDao(ICraftsDao dao) {
        this.craftssDao = dao;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveCraft(Crafts craft) {
        craftssDao.save(craft);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteCraft(Crafts craft) {
        craftssDao.delete(craft);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateCraft(Crafts craft) {
        craftssDao.delete(craft);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<Crafts> getAllCrafts() {
        // TODO Auto-generated method stub
        return craftssDao.getCrafts();
    }

    public List<Crafts> getCraft(int craftID) {
        // TODO Auto-generated method stub
        return craftssDao.getCraft(craftID);
    }

  
}
