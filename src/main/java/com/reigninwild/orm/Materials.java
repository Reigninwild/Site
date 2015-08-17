package com.reigninwild.orm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

    @Entity
    @Table(name = "materials")
    public class Materials implements Serializable {
        private static final long serialVersionUID = 1L;
        /*----private key---*/
       @Id
       @Column(name = "material_id")
       @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
       @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
        private int materialID;

        /*------------*/
        @Column(name = "material_desc", nullable = true, length = 200)
        private String materialDesc;
        /*------------*/
        @Column(name = "material_desc_ru", nullable = true, length = 200)
        private String materialDescRU;
        /*------------*/
        @Column(name = "material_name", nullable = false, length = 30)
        private String materialName;
        /*------------*/
        @Column(name = "material_name_ru", nullable = false, length = 30)
        private String materialNameRU;
        /*------------*/
        @Column(name = "material_status", length = 10)
        private String materialStatus;
        /*------------*/
        @Column(name = "material_pic", nullable = true, length = 100)
        private String materialPic;
        
        @Column(name = "material_type", nullable = true, length = 30)
        private String materialType;
       

        public String getMaterialDesc() {
            return materialDesc;
        }


        public void setMaterialDesc(String materialDesc) {
            this.materialDesc = materialDesc;
        }


        public String getMaterialName() {
            return materialName;
        }


        public void setMaterialName(String materialName) {
            this.materialName = materialName;
        }


        public String getMaterialPic() {
            return materialPic;
        }


        public void setMaterialPic(String materialPic) {
            this.materialPic = materialPic;
        }


        public String getMaterialType() {
            return materialType;
        }


        public void setMaterialType(String materialType) {
            this.materialType = materialType;
        }


        public String getMaterialDescRU() {
            return materialDescRU;
        }


        public void setMaterialDescRU(String materialDescRU) {
            this.materialDescRU = materialDescRU;
        }


        public String getMaterialNameRU() {
            return materialNameRU;
        }


        public void setMaterialNameRU(String materialNameRU) {
            this.materialNameRU = materialNameRU;
        }


        public String getMaterialStatus() {
            return materialStatus;
        }


        public void setMaterialStatus(String materialStatus) {
            this.materialStatus = materialStatus;
        }


        public int getMaterialID() {
            return materialID;
        }


        public void setMaterialID(int materialID) {
            this.materialID = materialID;
        }
        
    }