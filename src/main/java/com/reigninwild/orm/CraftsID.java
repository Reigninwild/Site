package com.reigninwild.orm;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Embeddable
public class CraftsID implements Serializable {

    private static final long serialVersionUID = 1L;
    // PK consists of 2 FK: item id id and material id

    /* foreign key, join to users */
    @ManyToOne(targetEntity = Materials.class)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private Users uuser;
    
    
 // many crafts - one item
    @ManyToOne(targetEntity = Materials.class)
    @JoinColumn(name = "material_id")
    private Materials item;

    // many craft - one material
    @ManyToOne(targetEntity = Materials.class)
    @JoinColumn(name = "material_id")
    private Materials material;

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

}