/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.formation;
import com.mycompany.myapp.services.serviceformation;

/**
 *
 * @author ghassen
 */
public class FormationModifier extends SideMenuBaseForm{
    
     public FormationModifier(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
        profilePicLabel.setMask(mask.createMask());

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
         
       
        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.centerAbsolute(
                                BoxLayout.encloseY(
                                    new Label("Modifier formation", "Title")
                                       
                                    
                                )
                            )
                );
       
    
       tb.setTitleComponent(titleCmp);
       ////////////////
       
       
       
   
        setLayout(BoxLayout.y());
        
     
        TextField tfSujet = new TextField(Formationadmin.upsujet);
         
        
        Picker datePicker = new Picker();
        //datePicker.setType(Display.PICKER_TYPE_DATE);
        String datestring=(new SimpleDateFormat("yyyy-MM-dd")).format(datePicker.getDate());  
        TextField tfdescription = new TextField(Formationadmin.updesc);
        
       Button btnValider = new Button("Modifier Formation");
        
        
        
        btnValider.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                if ((tfSujet.getText().length()==0)||(tfdescription.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                       // Task t = new Task(Integer.parseInt(tfStatus.getText()), tfName.getText());
                        formation f=new formation(tfSujet.getText(), datestring, tfdescription.getText());
                      
                        if( serviceformation.getInstance().updateformation(Formationadmin.idfo,f)){
                            Dialog.show("Success","Connection accepted formation Modifier",new Command("OK"));
                         new Formationadmin(res).show();}
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        
         addAll(tfSujet,tfdescription,datePicker,btnValider);
         
        
  ////////////////
        
        setupSideMenu(res);
        
        
    }
    
    
    

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }
    
}
