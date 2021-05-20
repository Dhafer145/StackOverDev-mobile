/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.pidev.services.JournalProjetService;
import com.pidev.services.serviceUser;
import java.util.Vector;

/**
 *
 * @author ASUS
 */
public class JournalForm extends BaseForm {
    
    public JournalForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");
                
        TextField tache = new TextField("", "tache", 20, TextField.ANY);
        TextField avis = new TextField("", "avis", 20, TextField.ANY);
        TextField etudiantjp = new TextField("", "id_etudiant", 20, TextField.ANY);
       
     
        
        
        tache.setSingleLineTextArea(false);
        avis.setSingleLineTextArea(false);
        etudiantjp.setSingleLineTextArea(false);
     
        Button next = new Button("Ajouter");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> new SignInForm(res).show());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Already have an account?");
        
        Container content = BoxLayout.encloseY(
                new Label("Journal de stage", "LogoLabel"),
                new FloatingHint(tache),
                createLineSeparator(),
                new FloatingHint(avis),
                createLineSeparator(),
                new FloatingHint(etudiantjp),
                createLineSeparator()
               
        );
        
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                next,
                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
        ));
        next.requestFocus();
        next.addActionListener((e) -> {
            JournalProjetService.getInstance().ajoutJournal(tache, avis, etudiantjp, res);
            Dialog.show("success"," journal ajouté" ,"ok",null);
                    
        });
    }
  
}
