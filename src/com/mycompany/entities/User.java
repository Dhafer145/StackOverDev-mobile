/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import com.codename1.io.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;



/**
 *
 * @author mariem ayadi
 */
public class User {
    int id;
    String username;
    String email;
    String nom;
    String prenom;
    String password;
    String roles;
    
    public User(){
        
    }
       
    public User(int id,String username,String email,String nom,String prenom,String password,String roles){
        this.id=id;
        this.username=username;
        this.email=email;
        this.nom=nom;
        this.prenom=prenom;
        this.password=password;
        this.roles=roles;
    }
      public int getId(){
        return id;
    }
    public void setId(int id){
      this.id=id;  
    }
       public String getUserName(){
        return username;
    }
    public void setUserName (String username){
      this.username=username;  
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
          public String getNom(){
        return nom;
    }
    public void setNom (String nom){
      this.nom=nom;  
    }
          public String getPrenom(){
        return prenom;
    }
    public void setPrenom(String prenom){
      this.prenom=prenom;  
    }
          public String getPassword(){
        return password;
    }
    public void setPassword (String password){
      this.password=password;  
    }
          public String getRoles(){
        return roles;
    }
    public void setRoles (String roles){
      this.roles=roles;  
    }
      @Override
    public  String toString(){
        
        return "User{"+"id="+id+",username="+username+",email="+email+",nom="
                +nom+",prenom="+prenom+",password="+password+",roles="+roles+"}\n";
    }
    
}

   



   
   
    