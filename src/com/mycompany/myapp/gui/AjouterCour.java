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
import com.codename1.ui.Display;
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

import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.cour;


import com.mycompany.myapp.services.servieceCour;




/**
 *
 * @author ghassen
 */
public class AjouterCour extends SideMenuBaseForm{
     public AjouterCour(Resources res) {
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
                                    new Label("Ajouter cour", "Title")
                                       
                                    
                                )
                            )
                );
       
    
       tb.setTitleComponent(titleCmp);
       ////////////////
       
       
       //ajouter cour
   
        setLayout(BoxLayout.y());
        
     
        
        TextField tnom = new TextField("","description");
        TextField textension = new TextField("","Ajouter un pdf");
         
        TextField timage = new TextField("","Ajouter image");
       
        
        
       Button btnValider = new Button("Ajouter cour");
       
    //chooser pdf   
       Button chooser = new Button("Add");
         
       chooser.addActionListener(new ActionListener() {
            ActionListener callback = e->{
   if (e != null && e.getSource() != null) {
       String filePath = (String)e.getSource();
       int pos = filePath.lastIndexOf("/");
       
       textension.setText(filePath.substring(pos+1));

   }
};
            @Override
            public void actionPerformed(ActionEvent evt) {
              
                        Display.getInstance().openGallery(callback, Display.GALLERY_IMAGE);
            }
   
        });
        Container cntex=new Container(BoxLayout.x());
        cntex.addAll(textension,chooser);
        
        
   //chooser image
        Button chooserimage = new Button("Add");
        
       chooserimage.addActionListener(new ActionListener() {
            ActionListener callback = e->{
   if (e != null && e.getSource() != null) {
       String filePath = (String)e.getSource();
       int pos = filePath.lastIndexOf("/");
      timage.setText(filePath.substring(pos+1));
     
   }
};
            @Override
            public void actionPerformed(ActionEvent evt) {
              
                        Display.getInstance().openGallery(callback, Display.GALLERY_IMAGE);
            }
   
        });
        Container cntimg=new Container(BoxLayout.x());
        cntimg.addAll(timage,chooserimage);
        
   //valider button     
        btnValider.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                if ((tnom.getText().length()==0)||(textension.getText().length()==0)||(timage.getText().length()==0))
                    Dialog.show("Alert", "PVerifier les champs", new Command("OK"));
                else
                {
                    try {
                       // Task t = new Task(Integer.parseInt(tfStatus.getText()), tfName.getText());
                        cour t=new cour(tnom.getText(),textension.getText(), timage.getText(), Formationadmin.idfo);
                      
                        if( servieceCour.getInstance().addcour(t)){
                            Dialog.show("Success","Cour Ajouter",new Command("OK"));
                         new Formationadmin(res).show();}
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        
         addAll(tnom,cntex,cntimg,btnValider);
         
        
  ////////////////
        
        setupSideMenu(res);
    
}

    @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}