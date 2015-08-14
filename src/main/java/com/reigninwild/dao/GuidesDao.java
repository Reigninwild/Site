package com.reigninwild.dao;

import java.util.List;

import com.reigninwild.orm.Guides;



import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GuidesDao extends HibernateDaoSupport implements IGuidesDao {

    public void save(Guides guides) {
        getHibernateTemplate().save(guides);
    }

    public void delete(Guides guides) {
        getHibernateTemplate().delete(guides);
    }

    public void update(Guides guides) {
        getHibernateTemplate().update(guides);
    }

    @SuppressWarnings("unchecked")
    public List<Guides> getGuides() {
        List<Guides> guides = getHibernateTemplate().find("from Guides");
        return guides;
    }

}
