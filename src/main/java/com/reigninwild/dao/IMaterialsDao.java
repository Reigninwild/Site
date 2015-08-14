package com.reigninwild.dao;

import java.util.List;


import com.reigninwild.orm.Materials;

public interface IMaterialsDao {
    public void save(Materials materials);
    /**
     * delete craft from db
     * @param craft
     */
    public void delete(Materials materials);
    /**
     * updates craft in db
     * @param craft
     */
    public void update(Materials materials);
    /**
     * returns the list of all craft
     * @return all craft
     */
    
    public List<Materials> getMaterials();
}
