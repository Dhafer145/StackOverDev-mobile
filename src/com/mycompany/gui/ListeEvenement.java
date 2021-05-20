/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Evenement;
import com.mycompany.services.ServiceEvenement;
import java.util.ArrayList;

/**
 *
 * @author hiche
 */
public class ListeEvenement extends BaseForm{
    Form current;
      public ListeEvenement (Resources res ){
            super("Newsfeed",BoxLayout.y()); 
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        getContentPane().setScrollVisible(false);
        
        
        tb.addSearchCommand(e ->  {
            
            
        });
        
    
        
        Tabs swipe = new Tabs();
        
        Label s1 = new Label();
        Label s2 = new Label();
        Label s3 = new Label();
        Label s4 = new Label();
        Label s5 = new Label();
        Label s6 = new Label();
        Label s7 = new Label();
        Label s8 = new Label();
        Label s9 = new Label();

        
        addTab(swipe,s1, res.getImage("back-logo.jpeg"),"","",res);
        
        //
        
         swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });
    
      
        Component.setSameSize(radioContainer, s1, s2 , s3 , s4 , s5,s6,s7,s8,s9);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
   
        RadioButton partage = RadioButton.createToggle("Listes Evenements", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


       
        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(1, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
       
        bindButtonSelection(partage, arrow);
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });
        
        ArrayList <Evenement> list = ServiceEvenement.getInstance().affichageEvenement();
        
        for(Evenement ev : list ) {
             String urlImage="back-logo.jpeg";//image statique pour le moment ba3d taw fi  videos jayin nwarikom image 
            
             Image placeHolder = Image.createImage(120, 90);
             EncodedImage enc =  EncodedImage.createFromImage(placeHolder,false);
             URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
             
                addButton(urlim,ev,res);
        
                ScaleImageLabel image = new ScaleImageLabel(urlim);
                
                Container containerImg = new Container();
                
                image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        }
        
        
        
    }
    
    
    
    
    
    
    
    
       private void addTab(Tabs swipe, Label spacer , Image image, String string, String text, Resources res) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        
        if(image.getHeight() < size) {
            image = image.scaledHeight(size);
        }
        
        
        
        if(image.getHeight() > Display.getInstance().getDisplayHeight() / 2 ) {
            image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
        
        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        Label overLay = new Label("","ImageOverlay");
        
        
        Container page1 = 
                LayeredLayout.encloseIn(
                imageScale,
                        overLay,
                        BorderLayout.south(
                        BoxLayout.encloseY(
                        new SpanLabel(text, "LargeWhiteText"),
                                        spacer
                        )
                    )
                );
        
        swipe.addTab("",res.getImage("back-logo.jpeg"), page1);
        
        
        
        
    }
    
    
    
    public void bindButtonSelection(Button btn , Label l ) {
        
        btn.addActionListener(e-> {
        if(btn.isSelected()) {
            updateArrowPosition(btn,l);
        }
    });
    }

    private void updateArrowPosition(Button btn, Label l) {
        
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth()  / 2  - l.getWidth() / 2 );
        l.getParent().repaint();
    }

    private void addButton(Image img,Evenement ev , Resources res) {
        
        Toolbar.setGlobalToolbar(true);


        
        
        int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);
        
        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt = BorderLayout.west(image);
        
        
        Label dateTxt = new Label("date : "+ev.getDate_event(),"NewsTopLine2");
        Label titreTxt = new Label("titre : "+ev.getTitre(),"NewsTopLine2");
        Label emplacementTxt = new Label("emplacement : "+ev.getEmplacement(),"NewsTopLine2" );
        Label image_eventTxt = new Label("image_event : "+ev.getImage_event(),"NewsTopLine2" );
        Label dureeTxt = new Label("duree : "+ev.getDuree(),"NewsTopLine2" );
        Label prixTxt = new Label("prix : "+ev.getPrix(),"NewsTopLine2" );
        Label fondationTxt = new Label("fondation : "+ev.getFondation(),"NewsTopLine2" );
        Label nbMaxParticipantsTxt = new Label("nbMaxParticipants : "+ev.getNbMaxParticipants(),"NewsTopLine2" );


        
        
        Label lsupprimer = new Label("   ");
        lsupprimer.setUIID("NewsTopLine");
        Style supprimertStyle = new Style(lsupprimer.getUnselectedStyle());
        supprimertStyle.setFgColor(0xf21f1f);
        FontImage supprimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimertStyle);
        lsupprimer.setIcon(supprimerImage);
        lsupprimer.setTextPosition(LEFT);

        lsupprimer.addPointerPressedListener(l -> {
           Dialog dig = new Dialog("Suppression");
           
          if ( dig.show("Suppression", "vous voulez supprimer cet entretien?", "Annuler", "Oui")){
              dig.dispose();
            
          }else{
                 dig.dispose();
                 if(ServiceEvenement.getInstance().deleteEvenement(ev.getId())){
                 new ListeEvenement(res).show();
            }
          }
          
        
        });

        

        
        
         Label sendmail = new Label("   ");
        sendmail.setUIID("NewsTopLine");
        Style sendStyle = new Style(sendmail.getUnselectedStyle());
        sendStyle.setFgColor(0xBD5E99);
        FontImage sendImage = FontImage.createMaterial(FontImage.MATERIAL_MAIL, sendStyle);
        sendmail.setIcon(sendImage);
        sendmail.setTextPosition(LEFT);

       /* sendmail.addPointerPressedListener(l -> {
           Dialog dig = new Dialog("Send");
           
          if ( dig.show("Send", "vous voulez envoyer le mail?", "Annuler", "Oui")){
              dig.dispose();
            
          }else{
                 dig.dispose();
                 if(ServiceEvenement.getInstance().EnvoyerMail(ev.getId())){
                 new ListeEvenement(res).show();
            }
          }
          
        
        });*/
        
        Label lmodifier = new Label("   ");
        lmodifier.setUIID("NewsTopLine");
        Style modifierStyle = new Style(lmodifier.getUnselectedStyle());
        modifierStyle.setFgColor(0xf7ad02);
        FontImage modifierImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
        lmodifier.setIcon(modifierImage);
        lmodifier.setTextPosition(LEFT);
        
           lmodifier.addPointerPressedListener(l -> {
            new ModifierEvent(res,ev ).show();
        });
        
        createLineSeparator();
        
            cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(dateTxt,titreTxt, prixTxt,
                    
                    
                    BoxLayout.encloseX(lsupprimer,lmodifier)
                    ));
       

        add(cnt);
        add(createLineSeparator(0xBD5E99));
        add(createLineSeparator(0xBD5E99));


        add(createLineSeparator(0xBD5E99));

    }
    
      
}

    

