/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.services;

import com.codename1.io.ConnectionRequest;
import com.pidev.entities.JournalProjet;
import com.pidev.utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import static com.codename1.io.Log.e;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.pidev.utils.Statics;
import java.util.Map;
import java.util.Vector;


/**
 *
 * @author ASUS
 */
public class JournalProjetService {
    
     public static JournalProjetService instance =null;
    public static boolean resultok=true;
    private ConnectionRequest req;
    
    public static JournalProjetService getInstance(){
    if(instance==null)
        instance=new JournalProjetService();
    return instance;
    }
    
    public JournalProjetService(){
    req=new ConnectionRequest();
    }
    
    
    public void ajoutJournal(TextField tache,TextField avis,TextField etudiantjp, Resources res)
    {
   
       
        String url=Statics.base_url+"/journalstage?tache="+tache.getText().toString()+"&avis="+avis.getText().toString()+
       "&etudiantjp="+etudiantjp.getText().toString()
               
                ;
        
    req.setUrl(url);
    
    if(avis.getText().length()==0||tache.getText().length()==0||etudiantjp.getText().length()==0)
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
