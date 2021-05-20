/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.EvaluationMi;
import com.mycompany.entities.Evenement;

import com.mycompany.utils.Static;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mariem ayadi
 */
public class ServiceEvenement {
    public static ServiceEvenement instance=null;
    
        public static boolean resultOk = true;

    public ConnectionRequest req;
    
    
    public static ServiceEvenement getInstance(){
        if(instance == null)
            instance=new ServiceEvenement();
        return instance;
        
    }

    public ServiceEvenement() {
       req = new ConnectionRequest();
    }
    
    public void ajouterEnvenment (Evenement ev){
        String url=Statics.BASE_URL+"/addevenement?id="+ev.getId()+"&titre="+ev.getTitre()+"&emplacement="+ev.getEmplacement()+"&prix="+ev.getPrix()+"&date_event="+ev.getDate_event()+"&image_event="+ev.getImage_event()+"&fondation="+ev.getFondation()+"&nbMaxParticipants="+ev.getNbMaxParticipants()+"&duree="+ev.getDuree();
  
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str= new String(req.getResponseData());
            System.out.println("data == "+str);
        });
    
    NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public void ajouterEvaluation (EvaluationMi ev){
        
        String ponctualite;
        String integration;
        String travail;
        String competence;
        String eg;
        
        if(ev.isPonctualite()==true){ponctualite="1";}else{ponctualite="0";}
        if(ev.isIntegration()==true){integration="1";}else{integration="0";}
        if(ev.isTravail()==true){travail="1";}else{travail="0";}
        if(ev.isCompetence()==true){competence="1";}else{competence="0";}
        if(ev.isEg()==true){eg="1";}else{eg="0";}
        
       
        String url=Statics.BASE_URL+"/ev/json?ponctualite="+ponctualite+"&comm1="+ev.getComm1()+
                "&integration="+integration+"&comm2="+ev.getComm2()+
                "&travail="+travail+"&comm3="+ev.getComm3()+
                "&competence="+competence+"&comm4="+ev.getComm4()+
                "&eg="+eg+"&comm5="+ev.getComm5()+
                "&id_enc_entreprise_id="+ev.getId_enc()+
                "&eval_etudiant_id="+ev.getId_etu()
                ;
  
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str= new String(req.getResponseData());
            System.out.println("data == "+str);
        });
    
    NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    
    
    public ArrayList<Evenement>affichageEvenement() {
        ArrayList<Evenement> result = new ArrayList<>();
        
        String url =Statics.BASE_URL+"/displayentretien";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapEvents = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapEvents.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        Evenement ev = new Evenement();
                       
                        float id = Float.parseFloat(obj.get("id").toString());
                     // float user_id = Float.parseFloat(obj.get("user_id").toString());
                        float prix = Float.parseFloat(obj.get("prix").toString());

//                       float nbMaxParticipants = Float.parseFloat(obj.get("nbMaxParticipants").toString());

                        String titre = obj.get("titre").toString();
                        
                        String emplacement = obj.get("emplacement").toString();
//                      String numero_telephone= obj.get("numero_telephone").toString();

                      //  String image_event= obj.get("image_event").toString();
                        String fondation = obj.get("fondation").toString();

                        String duree = obj.get("duree").toString();

                        ev.setId((int)id);
                        ev.setTitre(titre);
                        ev.setEmplacement(emplacement);
                      //en.setNumeroTelephone(numero_telephone);
                       // ev.setImage_event(image_event);
                        ev.setPrix((int)prix);
                        //ev.setNbMaxParticipants((int)nbMaxParticipants);
                        ev.setFondation(fondation);
                    //  en.setUser_id((int) user_id);
                        ev.setDuree(duree);
                        
                        //Date 
//                        String DateConverter =  obj.get("date_event").toString().substring(obj.get("date_event").toString().indexOf("timestamp") + 10 , obj.get("date_event").toString().lastIndexOf("}"));
                        
                     //   Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
                        
                      //  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                       // String dateString = formatter.format(currentTime);
//                        ev.setDate_event(obj.get("date_event").toString());
                        
                        //insert data into ArrayList result
                            result.add(ev);
                        }
                    
                    
                    
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
        
        
    }
    
       public Evenement DetailEvenement( int id , Evenement ev) {
        
        String url = Statics.BASE_URL+"/detailentretien?"+id;
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                
                ev.setTitre(obj.get("titre").toString());
                ev.setEmplacement(obj.get("emplacement").toString());

                ev.setImage_event(obj.get("image_event").toString());
                ev.setFondation(obj.get("fondation").toString());
                ev.setDuree(obj.get("duree").toString());


            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);
              return ev;
        
        
    }
        public boolean deleteEvenement(int id ) {
        String url = Statics.BASE_URL +"/deleteentretien?id="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
        
    public boolean modifierEvenement(Evenement ev) {
        String url = Statics.BASE_URL +"/updateentretien?id="+ev.getId()+"&titre="+ev.getTitre()+"&emplacement="+ev.getEmplacement()+"&prix="+ev.getPrix()+"&date_event="+ev.getDate_event()+"&image_event="+ev.getImage_event()+"&fondation="+ev.getFondation()+"&nbMaxParticipants="+ev.getNbMaxParticipants()+"&duree="+ev.getDuree();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);
    return resultOk;
        
    }
    public boolean EnvoyerMail(){
         String url = Statics.BASE_URL +"/sendmail";
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
            req.removeResponseListener(this);
            

    }

}   );    
                NetworkManager.getInstance().addToQueueAndWait(req);

        return resultOk;
                }
   
            
        
    }
