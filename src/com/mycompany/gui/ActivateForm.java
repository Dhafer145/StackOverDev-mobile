/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.pidev.services.serviceUser;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Account activation UI
 *
 * @author Shai Almog
 */
public class ActivateForm extends BaseForm {
TextField email;
    public ActivateForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("Activate");
        
        add(BorderLayout.NORTH, 
                BoxLayout.encloseY(
                        new Label(res.getImage("smily.png"), "LogoLabel"),
                        new Label("Awsome Thanks!", "LogoLabel")
                )
        );
        
        
       email = new TextField("", "Enter votre email", 30, TextField.ANY);
      email.setSingleLineTextArea(false);
       
      Button valider = new Button("Valider");

      Label HaveAnAccount = new Label("retour sur la page login");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> previous.showBack());
        signIn.setUIID("centerLink");
 Container content = BoxLayout.encloseY(
                new FloatingHint(email),
                (createLineSeparator()),
                valider,
                FlowLayout.encloseCenter(HaveAnAccount),
                signIn
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        valider.requestFocus();
         valider.addActionListener(e ->{
             InfiniteProgress ip=new InfiniteProgress();
             final Dialog ipDialoge=ip.showInfiniteBlocking();
             //api send mail
            sendMail(res);
            ipDialoge.dispose();
            Dialog.show("mot de passe","mot de passe envoyé",new Command("ok"));
            refreshTheme();
                 });
        
 
    }
    
public void sendMail(Resources res){
        try{
         Properties pros = new Properties();
         pros.put("mail.transport.protocol", "smtp");
         pros.put("mail.smtp.host", "smtp.gmail.com");
         pros.put("mail.smtp.auth", "true");
        
         
         pros.put("mail.smtp.port", "587");
         String user = "ramzikhefifi.98@gmail.com"; 
         String pass = "ramzuss12";
         Session session = Session.getInstance(pros, null);
         Message msg = new MimeMessage(session); 
           msg.setFrom(new InternetAddress(user));  
           InternetAddress[] address = {new InternetAddress(email.getText().toString())};
           msg.setRecipients(Message.RecipientType.TO,address ); 
           msg.setSubject("Mot de Passe Oublié");
           
           String mp=serviceUser.getInstance().getPassowrd(email, res);
           msg.setText("mot de passe :"+mp);
          
           SMTPTransport st=(SMTPTransport) session.getTransport("smtp");
           st.connect("smtp.gmail.com",465,user,pass);
           st.sendMessage(msg, address);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
       
}