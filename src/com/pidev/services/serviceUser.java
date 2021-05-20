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
import com.mycompany.gui.SignInForm;
import com.mycompany.gui.SignUpForm;
import com.mycompany.gui.WalkthruForm;
import com.pidev.utils.Statics;
import java.util.Map;
import java.util.Vector;



/**
 *
 * @author ramzuss
 */
public class serviceUser {
    
    public static serviceUser instance =null;
    public static boolean resultok=true;
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


  

}






