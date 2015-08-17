package com.reigninwild.services;

import java.util.List;

import com.reigninwild.orm.Crafts;


public interface ICraftsService {

    public void saveCraft(Crafts craft);

    public void deleteCraft(Crafts craft);

    public void updateCraft(Crafts craft);

    public List<Crafts> getAllCrafts();
    
    public List<Crafts> getCraft(int craftID);
}
