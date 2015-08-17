package com.reigninwild.dao;

import java.util.List;

import com.reigninwild.orm.Crafts;


public interface ICraftsDao {
    public void save(Crafts crafts);
    /**
     * delete craft from db
     * @param craft
     */
    public void delete(Crafts crafts);
    /**
     * updates craft in db
     * @param craft
     */
    public void update(Crafts crafts);
    /**
     * returns the list of all craft
     * @return all craft
     */
    
    public List<Crafts> getCraft(int craftID);

    
    public List<Crafts> getCrafts();
}
