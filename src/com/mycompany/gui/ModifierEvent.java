/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Evenement;
import com.mycompany.services.ServiceEvenement;

/**
 *
 * @author hiche
 */
public class ModifierEvent extends BaseForm {
    
    Form current;
    public ModifierEvent(Resources res , Evenement ev) {
         super("Newsfeed",BoxLayout.y()); 
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
       TextField titre = new TextField(ev.getTitre(), "titre" , 20 , TextField.ANY);
       TextField emplacement = new TextField(ev.getEmplacement(), "emplacement" , 20 , TextField.ANY);
       TextField image_event = new TextField(ev.getImage_event(), "image_event" , 20 , TextField.ANY);
       TextField duree = new TextField(ev.getDuree(), "Duree" , 20 , TextField.ANY);
       TextField fondation = new TextField(ev.getFondation(), "fondation" , 20 , TextField.ANY);


 
     
        
        
        
        titre.setUIID("NewsTopLine");
        emplacement.setUIID("NewsTopLine");
        image_event.setUIID("NewsTopLine");
        duree.setUIID("NewsTopLine");
        fondation.setUIID("NewsTopLine");



        
        
        titre.setSingleLineTextArea(true);
        emplacement.setSingleLineTextArea(true);
        image_event.setSingleLineTextArea(true);
        duree.setSingleLineTextArea(true);

        fondation.setSingleLineTextArea(true);

        
        
        Button btnModifier = new Button("Modifier");
        btnModifier.setUIID("Button");
       
       
       btnModifier.addPointerPressedListener(l ->   { 
           
           ev.setTitre(titre.getText());
           ev.setEmplacement(emplacement.getText());
           ev.setImage_event(image_event.getText());
           ev.setDuree(duree.getText());
           ev.setFondation(fondation.getText());
       
       
       if(ServiceEvenement.getInstance().modifierEvenement(ev)) { // if true
           new ListeEvenement(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListeEvenement(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(titre),
                createLineSeparator(),
                new FloatingHint(emplacement),
                createLineSeparator(),
                new FloatingHint(image_event),

                createLineSeparator(),
                 new FloatingHint(fondation),

                createLineSeparator(),
                 new FloatingHint(duree),

                createLineSeparator(),
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
}
    


    

