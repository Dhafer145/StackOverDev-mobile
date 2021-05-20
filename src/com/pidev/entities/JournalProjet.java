/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class JournalProjet {
    
    public int id;
    public Date date;
    public String tache;
    public String avis;
    public int etudiantjp;

    public JournalProjet(int id, Date date, String tache, String avis, int etudiantjp) {
        this.id = id;
        this.date = date;
        this.tache = tache;
        this.avis = avis;
        this.etudiantjp = etudiantjp;
    }

    public JournalProjet(Date date, String tache, String avis, int etudiantjp) {
        this.date = date;
        this.tache = tache;
        this.avis = avis;
        this.etudiantjp = etudiantjp;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTache() {
        return tache;
    }

    public void setTache(String tache) {
        this.tache = tache;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public int getEtudiantjp() {
        return etudiantjp;
    }

    public void setEtudiantjp(int etudiantjp) {
        this.etudiantjp = etudiantjp;
    }
    
    
    
}
