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
public class Evenement {
    public static Command ent(String clicked){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private int id;
    private String titre;
    private String emplacement;
    private int prix;
    private String date_event;
    private String image_event;
    private String fondation;
    private int nbMaxParticipants;
    private String duree;

    public Evenement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDate_event() {
        return date_event;
    }

    public void setDate_event(String date_event) {
        this.date_event = date_event;
    }

    public String getImage_event() {
        return image_event;
    }

    public void setImage_event(String image_event) {
        this.image_event = image_event;
    }

    public String getFondation() {
        return fondation;
    }

    public void setFondation(String fondation) {
        this.fondation = fondation;
    }

    public Integer getNbMaxParticipants() {
        return nbMaxParticipants;
    }

    public void setNbMaxParticipants(int nbMaxParticipants) {
        this.nbMaxParticipants =nbMaxParticipants;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Evenement(int id, String titre, String emplacement, int prix, String date_event, String image_event, String fondation, int nbMaxParticipants, String duree) {
        this.id = id;
        this.titre = titre;
        this.emplacement = emplacement;
        this.prix = prix;
        this.date_event = date_event;
        this.image_event = image_event;
        this.fondation = fondation;
        this.nbMaxParticipants = nbMaxParticipants;
        this.duree = duree;
    }

    public Evenement(int id,String titre, String emplacement,String image_event,int prix ,String fondation,String duree, int nbMaxParticipants,String date_event) {
        this.titre = titre;
        this.emplacement = emplacement;
        this.image_event = image_event;
        this.fondation = fondation;
        this.prix=prix;
        this.duree=duree;
        this.nbMaxParticipants=nbMaxParticipants;
        this.date_event=date_event;
        this.id=id;
    }

    
}


