/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.formation;
import static com.mycompany.myapp.gui.Formationclient.descriptionf;
import static com.mycompany.myapp.gui.Formationclient.idf;
import static com.mycompany.myapp.gui.Formationclient.sujetf;
import com.mycompany.myapp.services.serviceformation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ghassen
 */
public class FormationMesformation extends sidemenuclient{
    
     public FormationMesformation(Resources res) {
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
                                    new Label("Nos Formation", "Title")
                                       
                                    
                                )
                            )
                );
       Button btnAddformation=new Button("nosss formation");
     titleCmp.add(btnAddformation);
     btnAddformation.addActionListener(e -> new Formationclient(res).show());
     
       tb.setTitleComponent(titleCmp);
       

         
        
        //liste des formation
        ArrayList<formation> array=serviceformation.getInstance().getMesformation();
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        ArrayList<String> datahh = new ArrayList<>();
        ArrayList<Integer> datahhid = new ArrayList<>();
        ArrayList<String> datahhdesc = new ArrayList<>();
        
        for(formation t:array){
            int mm = Display.getInstance().convertToPixels(3);
EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);
         Image icon5 = URLImage.createToStorage(placeholder, "ggf", "http://localhost/imagepi/dff.png");
           datahh.add(t.getSujet());
           datahhid.add(t.getId());
           datahhdesc.add(t.getDescription());
           
           data.add(createListEntry(icon5,t.getSujet(), t.getDescription()));
          
        }
         DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
  MultiList ml = new MultiList(model);
 
  add( ml);
         
   
  ml.addActionListener((e->{
  System.out.println(ml.getSelectedIndex());
      System.out.println(datahh.get(ml.getSelectedIndex()));
          //lb.setText(datahh.get(ml.getSelectedIndex()));
          
         System.out.println(datahhid.get(ml.getSelectedIndex()));
        // idformation.setText(String.valueOf(datahhid.get(ml.getSelectedIndex())));
            idf=datahhid.get(ml.getSelectedIndex());
            sujetf=datahh.get(ml.getSelectedIndex());
            descriptionf=datahhdesc.get(ml.getSelectedIndex());
            
             //   new Formationcour(res).show();
             new Formationcour(res).show();
           
 
}));
 
  
  
        
 
        
        setupSideMenu(res);
    }
    
    
 
    

    @Override
    protected void showOtherForm(Resources res) {
        new StatsForm(res).show();
    }
    private Map<String, Object> createListEntry(Image img,String name, String date) {
  Map<String, Object> entry = new HashMap<>();
  entry.put("icon", img);
  entry.put("Line1", name);
  entry.put("Line2", date);
  
  return entry;
    }
    
}
