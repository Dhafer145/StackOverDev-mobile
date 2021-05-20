/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import com.codename1.ui.Command;




/**
 *
 * @author hiche
 */
public class rapport {
    public static Command ent(String clicked){
        throw new UnsupportedOperationException("Not supported yet.");
    }
      private int id ;
      private float plagiat ;
      private String image_name;
      private int rapp_etudiant_id ;
      private int enc_ac_correction_id ;
     
      
      
      

    public rapport() {
    }

    public rapport( float plagiat, String image_name, int rapp_etudiant_id, int enc_ac_correction_id) {
        this.id = id;
        this.plagiat = plagiat;
        this.image_name = image_name;
        this.rapp_etudiant_id = rapp_etudiant_id;
        this.enc_ac_correction_id = enc_ac_correction_id;
    }

    public int getId() {
        return id;
    }

    public float getPlagiat() {
        return plagiat;
    }

    public String getImage_name() {
        return image_name;
    }

    public int getRapp_etudiant_id() {
        return rapp_etudiant_id;
    }

    public int getEnc_ac_correction_id() {
        return enc_ac_correction_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlagiat(float plagiat) {
        this.plagiat = plagiat;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public void setRapp_etudiant_id(int rapp_etudiant_id) {
        this.rapp_etudiant_id = rapp_etudiant_id;
    }

    public void setEnc_ac_correction_id(int enc_ac_correction_id) {
        this.enc_ac_correction_id = enc_ac_correction_id;
    }

   

    
}


