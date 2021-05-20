/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import static com.codename1.io.Log.e;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.ProfileForm;
import com.mycompany.gui.SignInForm;
import com.mycompany.gui.SignUpForm;
import com.mycompany.gui.WalkthruForm;
import com.pidev.utils.Statics;
import static java.lang.Integer.parseInt;
import java.util.Map;
import java.util.Vector;



/**
 *
 * @author ramzuss
 */
public class serviceUser {
    
    public static serviceUser instance =null;
    public static boolean resultok=true;
String json;
    private ConnectionRequest req;
    
    public static serviceUser getInstance(){
    if(instance==null)
        instance=new serviceUser();
    return instance;
    }
    
    public serviceUser(){
    req=new ConnectionRequest();
    }
    public void signup(TextField username,TextField email,TextField password,TextField confirm,ComboBox<String> cmb,TextField adresse, Resources res)
    {
   
       
        String url=Statics.base_url+"/user/signup?user_name="+username.getText().toString()+"&email="+email.getText().toString()+
       "&password="+password.getText().toString()+"&role="+
                cmb.getSelectedItem().toString()
                +"&addresse="+adresse.getText().toString()
                
                ;
        
    req.setUrl(url);
    
    if(username.getText().length()==0||email.getText().length()==0||password.getText().length()==0 ||password.getText().equalsIgnoreCase(confirm.getText())  )
    {
        Dialog.show("erreur", "champs manquants","ok",null);
    }
    //wa9t tsir execution mtaa url
    req.addResponseListener((e)->{
        //njib data eli hatitha fi form    
        byte[]data=(byte[]) e.getMetaData();
            String responseData=new String(data);
                    
    });
    //reponse mtaa serveur
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    
}


     public void update(TextField id,TextField email,TextField password,TextField adresse, Resources res)
    {
   
       
        String url=Statics.base_url+"/user/editUser?id="+parseInt(id.getText().toString())+"&email="+email.getText().toString()+
       "&password="+password.getText().toString()+"&addresse="+adresse.getText().toString()
                
                ;
        
    req.setUrl(url);
    
    if(id.getText().length()==0||email.getText().length()==0||password.getText().length()==0 ||adresse.getText().length()==0   )
    {
        Dialog.show("erreur", "champs manquants","ok",null);
    }
    //wa9t tsir execution mtaa url
    req.addResponseListener((e)->{
        //njib data eli hatitha fi form    
        byte[]data=(byte[]) e.getMetaData();
            String responseData=new String(data);
                    
    });
    //reponse mtaa serveur
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    
}

    
    
    
    public void deleteuser(TextField id, Resources res)
    {
   
       
     String url=Statics.base_url+"/deleteUserjson?id="+id.getText().toString()                
                ;
        
    req.setUrl(url);
    
    if(id.getText().length()==0)   {
        Dialog.show("erreur", "champs manquants","ok",null);
    }
    //wa9t tsir execution mtaa url
    req.addResponseListener((e)->{
        //njib data eli hatitha fi form    
        byte[]data=(byte[]) e.getMetaData();
            String responseData=new String(data);
                    
    });
    //reponse mtaa serveur
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    
}
  











public void sigin(TextField username,TextField password ,ComboBox<String> cmb, Resources res)
 {
  String url=Statics.base_url+"/user/sigin?user_name="+username.getText().toString()+
       "&password="+password.getText().toString()+"&role="+
                cmb.getSelectedItem().toString();
     
  req=new ConnectionRequest(url,false); // url mazlt mab3thetch lel serveur
  req.setUrl(url);
   req.addResponseListener((e)->{
       JSONParser j=new JSONParser();
        String json=new String(req.getResponseData())+"";
        
        try{
        if(json.equals("failed"))
             {Dialog.show("Compte n'existe pas","Ok",null);}
             else
             {
               System.out.println("donnés :"+json);
                Map<String,Object> user=j.parseJSON(new CharArrayReader(json.toCharArray()));
          if((user.size()>0)&&(cmb.getSelectedItem().toString().equals("Encadrant Professionnel"))) {
                 new ProfileForm(res).show();
             }
           if((user.size()>0)&&(cmb.getSelectedItem().toString().equals("Encadrant Académique"))) {
                 new ProfileForm(res).show();
             }
            if((user.size()>0)&&(cmb.getSelectedItem().toString().equals("responsable des stages"))) {
                 new SignUpForm(res).show();
             }
           if((user.size()>0)&&(cmb.getSelectedItem().toString().equals("Etudiant"))) {
                 new WalkthruForm(res).show();
             }
             
             }
       
        }
        catch(Exception ex)
        {ex.printStackTrace();
        }
    });
   NetworkManager.getInstance().addToQueueAndWait(req);
 }  

public String getPassowrd(TextField email ,Resources res)
 {
 String mp;
  String url=Statics.base_url+"/user/getPasswordByEmail?email="+email;
     
  req=new ConnectionRequest(url,false); // url mazlt mab3thetch lel serveur
  req.setUrl(url);
   req.addResponseListener((e)->{
       
       JSONParser j=new JSONParser();
        json=new String(req.getResponseData())+"";
        
        try{
       
      System.out.println("donnés :"+json);
      Map<String,Object> password=j.parseJSON(new CharArrayReader(json.toCharArray()));
           
       
        }   
        catch(Exception ex)
        {ex.printStackTrace();
        }
    });
   NetworkManager.getInstance().addToQueueAndWait(req);

   return json;
 }  





}