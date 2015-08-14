package com.reigninwild.orm;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "crafts")
public class Crafts implements Serializable {
    private static final long serialVersionUID = 1L;
    /*----private key---*/
    @Id
    @Column(name = "craft_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    private int craftID;
    
    // many crafts - one item
    @ManyToOne(targetEntity = Materials.class)
    @JoinColumn(name = "material_id1")
    private Materials item;

    // many craft - one material
    @ManyToOne(targetEntity = Materials.class)
    @JoinColumn(name = "material_id2")
    private Materials material;



    /*------------*/
    @Column(name = "material_count", nullable = true)
    private int materialCount;
    /*------------*/
    @Column(name = "item_desc", nullable = true, length = 200)
    private String itemDesc;
    
    public int getMaterialCount() {
        return materialCount;
    }
    public void setMaterialCount(int materialCount) {
        this.materialCount = materialCount;
    }
    public String getItemDesc() {
        return itemDesc;
    }
    public void setItemDesc(String _itemDesc) {
        itemDesc = _itemDesc;
    }
    
    public Materials getItem() {
        return item;
    }

    public void setItem(Materials item) {
        this.item = item;
    }

    public Materials getMaterial() {
        return material;
    }

    public void setMaterial(Materials material) {
        this.material = material;
    }
    public int getCraftID() {
        return craftID;
    }
    public void setCraftID(int craftID) {
        this.craftID = craftID;
    }

}
