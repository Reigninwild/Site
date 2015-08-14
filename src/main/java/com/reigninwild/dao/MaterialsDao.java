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

}
