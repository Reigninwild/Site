package com.reigninwild.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reigninwild.dao.IMaterialsDao;
import com.reigninwild.orm.Materials;

@Service("MaterialsService")
@Transactional(readOnly = false)
public class MaterialsService implements IMaterialsService{
    
    @Autowired
    private IMaterialsDao materialsDao;

    public void setDao(IMaterialsDao dao) {
        this.materialsDao = dao;
    }

    public void saveMaterial(Materials materials) {
        materialsDao.save(materials);
    }

    public void deleteMaterial(Materials materials) {
        materialsDao.delete(materials);
    }

    public void updateMaterial(Materials materials) {
        materialsDao.update(materials);
    }

    public List<Materials> getAllMaterials() {
        // TODO Auto-generated method stub
        return materialsDao.getMaterials();
    }

    public Materials getMaterial(int materialID) {
        // TODO Auto-generated method stub
        return materialsDao.getMaterial(materialID);
    }

    public List<Materials> getEmptyMaterials() {
        // TODO Auto-generated method stub
        return materialsDao.getEmptyMaterials();
    }

    public List<Materials> getMaterialsByType(String type) {
        // TODO Auto-generated method stub
        return materialsDao.getMaterialsByType(type);
    }

}
