package com.reigninwild.dao;

import java.util.List;

import com.reigninwild.orm.Guides;

public interface IGuidesDao {
    public void save(Guides guides);

    public void delete(Guides guides);

    public void update(Guides guides);
    
    public List<Guides> getGuides();
}
