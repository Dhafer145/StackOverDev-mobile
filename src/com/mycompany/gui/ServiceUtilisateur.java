/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.User;
import com.mycompany.gui.NewsfeedForm;
import com.mycompany.gui.SessionManager;
import com.mycompany.utils.Static;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author mariem ayadi
 */
class ServiceUtilisateur {
     public ArrayList<User> users;
    
    private ConnectionRequest req;
    
    String json;
    
    public static ServiceUtilisateur instance=null; 

    private ServiceUtilisateur() {
        req = new ConnectionRequest();
    }
    
    public static ServiceUtilisateur getInstance(){
        if(instance == null){
            instance = new ServiceUtilisateur();
        }
        return instance;
        
    }
     
    public void signin(TextField email,TextField password, Resources rs ){
        
        String url =Static.BASE_URL+"log?email="+email.getText().toString()+"&password="+password.getText().toString();
       req = new ConnectionRequest(url, false);
        req.setUrl(url);
        
        req.addResponseListener((e) ->{
            
            JSONParser j = new JSONParser();
            
            String json = new String(req.getResponseData())+ "";
            
            if(email.getText().equals(" ") && password.getText().equals(" ")){
                Dialog.show("Erreur","Veuilllez remplir les champs","OK",null);
            }
            try{
                if(json.equals("failed")){
            Dialog.show("Echec d'authentification"," Email ou password incorrect ","OK",null);

                }
                else{
                    System.out.println("data ==>"+json);
                    Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    
                    // Session 
                    
                    float id = Float.parseFloat(user.get("id").toString());
                    SessionManager.setId((int)id);
                    
                    SessionManager.setUserName(user.get("username").toString());
                    SessionManager.setEmail(user.get("email").toString());
                    SessionManager.setPassowrd(user.get("password").toString());
                    
                  
                    System.out.println("current user ====>"+SessionManager.getEmail()+" ,"+SessionManager.getUserName()+" ,"+SessionManager.getPassowrd()+".");
                    if(user.size() > 0){
                        new NewsfeedForm(rs).show();
                    }
                }
            }catch(Exception ex){
                System.out.println(ex);
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    }
      public String getPasswordByEmail(String email , Resources rs ){
        String url = Static.BASE_URL+"getPasswordByEmail?email="+email;
        req = new ConnectionRequest(url, false);
        req.setUrl(url);

        req.addResponseListener(e ->{
            JSONParser j = new JSONParser();
            
             json = new String(req.getResponseData())+ "";
            
            try{
                Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));

                
            }catch(Exception ex){
                System.out.println(ex);
            }
        });
           NetworkManager.getInstance().addToQueueAndWait(req);

        return json;
    }
}
