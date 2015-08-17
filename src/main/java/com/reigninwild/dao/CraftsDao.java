package com.reigninwild.dao;

import java.util.List;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.reigninwild.orm.Crafts;

public class CraftsDao extends HibernateDaoSupport implements ICraftsDao {

    public void save(Crafts crafts) {
        getHibernateTemplate().save(crafts);
        
    }

    public void delete(Crafts crafts) {
        getHibernateTemplate().delete(crafts);
    }

    public void update(Crafts crafts) {
        getHibernateTemplate().update(crafts);
    }

    @SuppressWarnings("unchecked")
    public List<Crafts> getCrafts() {
        List<Crafts> crafts =  getHibernateTemplate().find("from Crafts");
        return crafts;
    }

    @SuppressWarnings("unchecked")
    public List<Crafts> getCraft(int craftID) {
        List<Crafts> crafts = getHibernateTemplate().find("from Crafts c where c.item.materialID = "+craftID+"");


        return crafts;
    }

}
