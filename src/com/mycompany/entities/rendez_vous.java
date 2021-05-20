/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;

/**
 *
 * @author dhiabenmabrouk
 */
public class rendez_vous {
    int id;
   String user_name;
   String lieu;
   Date date;
   String raison;

    public rendez_vous( String user_name, String lieu, Date date, String raison) {
        this.user_name = user_name;
        this.lieu = lieu;
        this.date = date;
        this.raison = raison;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }


   
     @Override
    public String toString() {
        return "rendez_vous{" + "id=" + id + ", user_name=" + user_name + ", lieu=" + lieu + ", date=" + date + ", raison=" + raison +'}';
    }
    
    
}
