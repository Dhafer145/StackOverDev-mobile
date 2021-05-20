package com.pidevv;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.mycompany.gui.BaseForm;
import com.mycompany.gui.ListeEvenement;
import com.mycompany.gui.AjoutEvForm;

import com.mycompany.gui.SignInForm;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

    public void init(Object context) {
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        Toolbar.setGlobalToolbar(true);

        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
    //  new AjoutEvForm(theme).show();
    //  new SignInForm(theme).show();
    //  new AjoutTypeForm(theme).show();
    //  new ListeEntretienForm(theme).show();
   //   new ListeCandidat(theme).show();
   //   new SignUpForm(theme).show();
        new AjoutEvForm(theme).show();
           
           
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}
