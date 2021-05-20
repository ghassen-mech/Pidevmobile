/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.formation;
import com.mycompany.myapp.entities.utilisateur;
import static com.mycompany.myapp.gui.Formationadmin.idfo;
import com.mycompany.myapp.services.serviceformation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ghassen
 */
public class ListParticipants extends SideMenuBaseForm{
    public ListParticipants(Resources res) {
         
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
                                    new Label("List Des participants  ", "Title"),
                                       new Label(" de la formation : ", "Title"),
                                       new Label(Formationadmin.upsujet, "Title")
                                       
                                    
                                )
                            )
                );
     
       tb.setTitleComponent(titleCmp);
       
       
       
      
                        
        

         
         
        
        
        ArrayList<utilisateur> array=serviceformation.getInstance().getlistparticipants(Formationadmin.idfo);
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        ArrayList<String> datahhnom = new ArrayList<>();
        ArrayList<String> datahhprenom = new ArrayList<>();
        ArrayList<String> datahhemail = new ArrayList<>();
        
        for(utilisateur t:array){
           datahhnom.add(t.getNom());
           datahhprenom.add(t.getPrenom());
           datahhemail.add(t.getEmail());
           data.add(createListEntry(t.getNom()+" "+ t.getPrenom(),t.getEmail()));
          
        }
       
         DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
  MultiList ml = new MultiList(model);
 
  add( ml);
         
   
  ml.addActionListener((e->{
  System.out.println(ml.getSelectedIndex());
      System.out.println(datahhnom.get(ml.getSelectedIndex()));
       
 
}));
  
        
 
        
        setupSideMenu(res);
    }
    
    
    

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }
    private Map<String, Object> createListEntry(String name, String date) {
  Map<String, Object> entry = new HashMap<>();
  entry.put("Line1", name);
  entry.put("Line2", date);
  
  return entry;
}
    
}
