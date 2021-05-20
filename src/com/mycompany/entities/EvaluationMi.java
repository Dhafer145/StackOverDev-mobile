/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;


/**
 *
 * @author Jihene
 */
public class EvaluationMi {
    
    private int id_ev_mi;
    private int id_enc;
    private int id_etu;
    
    private Date date_r;
    
    private boolean ponctualite;
    private String comm1;
    
    private boolean integration;
    private String comm2;
    
    private boolean travail;
    private String comm3;
    
    private boolean competence;
    private String comm4;
    
    private boolean eg;    
    private String comm5;
    
    

    public EvaluationMi() {
    }

   
    /**
     *
     * @param ponctualite
     * @param comm1
     * @param integration
     * @param comm2
     * @param travail
     * @param comm3
     * @param competence
     * @param comm4
     * @param eg
     * @param comm5
     */
    public EvaluationMi(boolean ponctualite, String comm1, boolean integration, String comm2, boolean travail, String comm3, boolean competence, String comm4, boolean eg, String comm5) {
        this.ponctualite = ponctualite;
        this.comm1 = comm1;
        this.integration = integration;
        this.comm2 = comm2;
        this.travail = travail;
        this.comm3 = comm3;
        this.competence = competence;
        this.comm4 = comm4;
        this.eg = eg;
        this.comm5 = comm5;
    }

    public EvaluationMi(int id_ev_mi, int id_enc, int id_etu, String nom_etudiant, String nom_encadrant, Date date_r) {
        this.id_ev_mi = id_ev_mi;
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.date_r = date_r;
    }

    public EvaluationMi(int id_ev_mi, int id_enc, int id_etu, Date date_r) {
        this.id_ev_mi = id_ev_mi;
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.date_r = date_r;
    }

    public EvaluationMi(int id_ev_mi, int id_enc, int id_etu, String nom_etudiant, Date date_r) {
        this.id_ev_mi = id_ev_mi;
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.date_r = date_r;
    }

    
    
    public EvaluationMi(int id_ev_mi, int id_enc, int id_etu, Date date_r, boolean ponctualite, String comm1, boolean integration, String comm2, boolean travail, String comm3, boolean competence, String comm4, boolean eg, String comm5) {
        this.id_ev_mi = id_ev_mi;
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.date_r = date_r;
        this.ponctualite = ponctualite;
        this.comm1 = comm1;
        this.integration = integration;
        this.comm2 = comm2;
        this.travail = travail;
        this.comm3 = comm3;
        this.competence = competence;
        this.comm4 = comm4;
        this.eg = eg;
        this.comm5 = comm5;
    }

    public EvaluationMi(int id_enc, int id_etu, boolean ponctualite, String comm1, boolean integration, String comm2, boolean travail, String comm3, boolean competence, String comm4, boolean eg, String comm5) {
        this.id_enc = id_enc;
        this.id_etu = id_etu;
        this.ponctualite = ponctualite;
        this.comm1 = comm1;
        this.integration = integration;
        this.comm2 = comm2;
        this.travail = travail;
        this.comm3 = comm3;
        this.competence = competence;
        this.comm4 = comm4;
        this.eg = eg;
        this.comm5 = comm5;
    }

    
    
    public int getId_ev_mi() {
        return id_ev_mi;
    }

    public void setId_ev_mi(int id_ev_mi) {
        this.id_ev_mi = id_ev_mi;
    }

    public int getId_enc() {
        return id_enc;
    }

    public void setId_enc(int id_enc) {
        this.id_enc = id_enc;
    }

    public int getId_etu() {
        return id_etu;
    }

    public void setId_etu(int id_etu) {
        this.id_etu = id_etu;
    }


    public Date getDate_r() {
        return date_r;
    }

    public void setDate_r(Date date_r) {
        this.date_r = date_r;
    }

    public boolean isPonctualite() {
        return ponctualite;
    }

    public void setPonctualite(boolean ponctualite) {
        this.ponctualite = ponctualite;
    }

    public String getComm1() {
        return comm1;
    }

    public void setComm1(String comm1) {
        this.comm1 = comm1;
    }

    public boolean isIntegration() {
        return integration;
    }

    public void setIntegration(boolean integration) {
        this.integration = integration;
    }

    public String getComm2() {
        return comm2;
    }

    public void setComm2(String comm2) {
        this.comm2 = comm2;
    }

    public boolean isTravail() {
        return travail;
    }

    public void setTravail(boolean travail) {
        this.travail = travail;
    }

    public String getComm3() {
        return comm3;
    }

    public void setComm3(String comm3) {
        this.comm3 = comm3;
    }

    public boolean isCompetence() {
        return competence;
    }

    public void setCompetence(boolean competence) {
        this.competence = competence;
    }

    public String getComm4() {
        return comm4;
    }

    public void setComm4(String comm4) {
        this.comm4 = comm4;
    }

    public boolean isEg() {
        return eg;
    }

    public void setEg(boolean eg) {
        this.eg = eg;
    }

    public String getComm5() {
        return comm5;
    }

    public void setComm5(String comm5) {
        this.comm5 = comm5;
    }
    
}
