/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.Switch;
import com.codename1.io.rest.RequestBuilder;
import com.codename1.io.rest.Response;
import com.codename1.io.rest.Rest;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import static com.codename1.ui.events.ActionEvent.Type.Response;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.EvaluationMi;
import com.mycompany.entities.Evenement;
import com.mycompany.services.ServiceEvenement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;


/**
 *
 * @author Jihene
 */



public class AjoutEvForm extends BaseForm{
        Form current;
        
    
    public AjoutEvForm(Resources res ) {
        super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Evaluation");
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
        Label s10 = new Label();
        Label s11 = new Label();
        Label s12 = new Label();
        Label s13 = new Label();

        
        addTab(swipe,s1, res.getImage("imagee.jpeg"),"","",res);
        
        
        
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

        Component.setSameSize(radioContainer, s1, s2 ,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("Mes E", barGroup);
        mesListes.setUIID("SelectBar");
      
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
            refreshTheme();
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(1, mesListes),
                FlowLayout.encloseBottom(arrow)
        ));

        arrow.setVisible(false);
       
        bindButtonSelection(mesListes, arrow);
     
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

        
        //
        
      
        TextField ponctualite = new TextField("", "ponctualite");
        ponctualite.setUIID("TextFieldBlack");
        addStringValue("ponctualite",ponctualite);
        
        TextField comm1 = new TextField("", "comm1");
        comm1.setUIID("TextFieldBlack");
        addStringValue("comm1",comm1);
        
        TextField integration = new TextField("", "integration");
        integration.setUIID("TextFieldBlack");
        addStringValue("integration",integration);
        
        TextField comm2 = new TextField("", "comm2"); 
        comm2.setUIID("TextFieldBlack");
        addStringValue("comm2",comm2);
        
        TextField travail = new TextField("", "travail");
        travail.setUIID("TextFieldBlack");
        addStringValue("travail",travail);
        
        TextField comm3 = new TextField("", "comm3");
        comm3.setUIID("TextFieldBlack");
        addStringValue("comm3",comm3);
        
        TextField competence = new TextField("", "competence");
        competence.setUIID("TextFieldBlack");
        addStringValue("competence",competence);
        
        TextField comm4 = new TextField("", "comm4"); 
        comm4.setUIID("TextFieldBlack");
        addStringValue("comm4",comm4);
        
        TextField eg = new TextField("", "eg");
        eg.setUIID("TextFieldBlack");
        addStringValue("eg",eg);
        
        TextField comm5 = new TextField("", "comm5");
        comm5.setUIID("TextFieldBlack");
        addStringValue("comm5",comm5);
        
        TextField id_enc = new TextField("", "id_enc");
        id_enc.setUIID("TextFieldBlack");
        addStringValue("id_enc",id_enc);
        
        TextField id_etu = new TextField("", "id_etu");
        id_etu.setUIID("TextFieldBlack");
        addStringValue("id_etu",id_etu);
  
        
         

        
        Button btnAjouter = new Button("Ajouter");
        addStringValue("", btnAjouter);
        
        
        //onclick button event 

        btnAjouter.addActionListener((e) -> {
            
            
            try {
                
                if(ponctualite.getText().equals("") || comm1.getText().equals("") || integration.getText().equals("") || comm2.getText().equals("") 
                        || travail.getText().equals("") || comm3.getText().equals("") || competence.getText().equals("")
                        || comm4.getText().equals("") || eg.getText().equals("") || comm5.getText().equals("")) {
                    Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
                }
                
                else {
                    InfiniteProgress ip = new InfiniteProgress();; //Loading  after insert data
                
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    
                    boolean ponctualite1;
                    boolean integration1;
                    boolean travail1;
                    boolean competence1;
                    boolean eg1;
                    
                    if(ponctualite.getText().equals("oui")){ponctualite1=true;}else{ponctualite1=false;}
                    if(integration.getText().equals("oui")){integration1=true;}else{integration1=false;}
                    if(travail.getText().equals("oui")){travail1=true;}else{travail1=false;}
                    if(competence.getText().equals("oui")){competence1=true;}else{competence1=false;}
                    if(eg.getText().equals("oui")){eg1=true;}else{eg1=false;}

                    EvaluationMi ev=new EvaluationMi(Integer.parseInt(id_enc.getText()),
                            Integer.parseInt(id_etu.getText()),
                            ponctualite1,
                            String.valueOf(comm1.getText()).toString(),
                            integration1,
                            String.valueOf(comm2.getText()).toString(),
                            travail1,
                            String.valueOf(comm3.getText()).toString(),
                            competence1,
                            String.valueOf(comm4.getText()).toString(),
                            eg1,
                            String.valueOf(comm5.getText()).toString()
                            
                           );
                    
                    System.out.println("data evenement == "+ev);
                    
                    
                    //appelle methode ajouterReclamation mt3 service Reclamation bch nzido données ta3na fi base 
                  ServiceEvenement c= ServiceEvenement.getInstance();
                    c.ajouterEvaluation(ev);
                   // c.EnvoyerMail();
                    
                   
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout   
                    
                    //ba3d ajout net3adaw lel ListREclamationForm
                   new ListeEvenement(res).show();
                    
                    refreshTheme();//Actualisation
                            
                }
                
            }catch(Exception ex ) {
                ex.printStackTrace();
            }
            
            
            
            
            
        });
        
        
    }

    private void addStringValue(String s, Component v) {
        
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
        add(createLineSeparator(0xeeeeee));
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
        
        swipe.addTab("",res.getImage("imagee.jpeg"), page1);
        
        
        
        
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

   
    
}
