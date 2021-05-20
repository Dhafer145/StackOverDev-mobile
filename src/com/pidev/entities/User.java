/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.entities;

/**
 *
 * @author ramzuss
 */
public class User {
 
    protected int id_user;
    protected String user_name;
   
     protected String email;
    protected String password;
     
    protected String role;
    protected String adresse;

    public User() {
    }

    public User(int id_user, String user_name, String email, String password, String role, String adresse) {
        this.id_user = id_user;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.adresse = adresse;
    }

   

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", user_name=" + user_name + ", email=" + email + ", password=" + password + ", role=" + role + ", adresse=" + adresse + '}';
    }
    
    
    
    
    
}
