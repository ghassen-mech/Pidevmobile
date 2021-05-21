/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Evenement;
import com.mycompany.myapp.services.ServiceEvent;



/**
 *
 * @author dell
 */
public abstract class AjoutEventForm extends sidemenuclient{
    
    Form current;

    public AjoutEventForm(Resources res) {
        /*
        
        super(BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        tb.setTitleCentered(true);
        getTitleArea().setUIID("container");
        setTitle("Ajout Evenement");
        getContentPane().setScrollVisible(false);
        
        TextField nom = new TextField("","entrer nom::");
        nom.setUIID("TextFieldBlack");
        addStringValue("nom",nom);
        
        TextField description = new TextField("","entrer description::");
        description.setUIID("TextFieldBlack");
        addStringValue("description",description);
        
        TextField type = new TextField("","entrer type::");
        type.setUIID("TextFieldBlack");
        addStringValue("type",type);
        
        TextField date_deb = new TextField("","entrer date_deb::");
        date_deb.setUIID("TextFieldBlack");
        addStringValue("date_deb",date_deb);
        
        TextField date_fin = new TextField("","entrer date_fin::");
        date_fin.setUIID("TextFieldBlack");
        addStringValue("date_fin",date_fin);
        
        TextField nbMaxParticipant = new TextField("","entrer nbMaxParticipant::");
        nom.setUIID("TextFieldBlack");
        addStringValue("nbMaxParticipant",nbMaxParticipant);
        
        Button btnAjouter = new Button("Ajouter");
        addStringValue("",btnAjouter);
        
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    
                    if(nom.getText()=="" || description.getText()=="" )
                    {
                        Dialog.show("Veuillez verifier les données");
                    }
                    else{            
                        InfiniteProgress ip = new InfiniteProgress();
                        final Dialog iDialog;
                        iDialog = ip.showInfiniteBlocking();
                        
                        Evenement ev = new Evenement(String.valueOf(nom.getText()).toString(),
                                String.valueOf(description.getText()).toString(),
                                String.valueOf(type.getText()).toString(),
                                String.valueOf(date_deb.getText()).toString(),
                                String.valueOf(date_fin.getText()).toString(),
                                String.valueOf(nbMaxParticipant.getText()).toString());
                        System.out.println(ev);
                        ServiceEvent.getInstance().ajoutEvent(ev);
                 
                        
                        }
                        
                
                    

                }catch(Exception ex){
                }
            }
        });
        
        
        
        
    }
    

    private void addStringValue(String s, Component y) {
        
        add(BorderLayout.WEST(new Label(s,"PadiedLabel"))
                .add(BorderLayout.CENTER, y));
        add(createLineSeparator(oxeeeeee));
      
        
        
    }

    */
    
    
    
}
    
}
