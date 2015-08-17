package com.reigninwild.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.reigninwild.orm.Materials;

public class MaterialsDao extends HibernateDaoSupport implements IMaterialsDao {

    public void save(Materials materials) {
        getHibernateTemplate().save(materials);
    }

    public void delete(Materials materials) {
        getHibernateTemplate().delete(materials);
    }

    public void update(Materials materials) {
        getHibernateTemplate().update(materials);
    }

    @SuppressWarnings("unchecked")
    public List<Materials> getMaterials() {
        List<Materials> materials = getHibernateTemplate().find("from Materials");
        return materials;
    }
    
    @SuppressWarnings("unchecked")
    public List<Materials> getMaterialsByType(String type) {
        List<Materials> materials = getHibernateTemplate().find("from Materials m where m.materialType = '"+type+"' ");
        return materials;
    }
    
    @SuppressWarnings("unchecked")
    public List<Materials> getEmptyMaterials() {
        List<Materials> materials = getHibernateTemplate().find("from Materials m where (select count(*) from Crafts c where c.item.materialID = m.materialID) = 0");
        return materials;
    }    

    @SuppressWarnings("unchecked")
    public Materials getMaterial(int materialID) {
        List<Materials> materials = getHibernateTemplate().find("from Materials m where m.materialID = "+materialID+"");
        Materials result = new Materials();
        if (materials.size()!=0) result = materials.get(0);
        else result =null;
        return result;
    }

}
