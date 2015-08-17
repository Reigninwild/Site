package com.reigninwild.services;

import java.util.List;

import com.reigninwild.orm.Materials;

public interface IMaterialsService {
    public void saveMaterial(Materials materials);

    public void deleteMaterial(Materials materials);

    public void updateMaterial(Materials materials);

    
    public Materials getMaterial(int materialID);
    
    public List<Materials> getAllMaterials();
    
    public List<Materials> getEmptyMaterials();
    
    public List<Materials> getMaterialsByType(String type);
}
