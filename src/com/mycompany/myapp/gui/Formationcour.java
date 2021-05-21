/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
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
import com.mycompany.myapp.entities.cour;
import com.mycompany.myapp.services.servieceCour;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ghassen
 */
public class Formationcour extends sidemenuclient{
      public Formationcour(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
       
        tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e->new FormationMesformation(res).show() );
        
        
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
      
       
        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.centerAbsolute(
                                BoxLayout.encloseY(
                                    new Label("Formation", "Title")
                                       
                                    
                                )
                            )
                );
        
       
       
     
       tb.setTitleComponent(titleCmp);
       int idformation= Formationclient.idf;
        ArrayList<cour> array=servieceCour.getInstance().getAllTasks(idformation);
        ArrayList<Map<String, Object>> data = new ArrayList<>();
         ArrayList<String> datahh = new ArrayList<>();
        ArrayList<String> datahhname = new ArrayList<>();
       
        
        for(cour t:array){

 int mm = Display.getInstance().convertToPixels(3);
EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(mm * 3, mm * 4, 0), false);
         Image icon5 = URLImage.createToStorage(placeholder, t.getNom(), "http://localhost/imagepi/"+t.getImag());
           datahh.add(t.getExtension());
            datahhname.add(t.getNom());
            
            
           data.add(createListEntry(icon5,t.getNom(),"Telecharger le cour "));
            
          
        }
         DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
  MultiList ml = new MultiList(model);
  ml.addActionListener((e->{
  
      System.out.println(datahh.get(ml.getSelectedIndex()));
      FileSystemStorage fs = FileSystemStorage.getInstance();
    
    String fileName = fs.getAppHomePath()+"cour/" +datahhname.get(ml.getSelectedIndex())+".pdf";
Util.downloadUrlToFile("http://localhost/"+datahh.get(ml.getSelectedIndex()), fileName, true);
 Display.getInstance().execute(fileName);
 
}));
 
  add( ml);
  
 
          
       
      
      
        setupSideMenu(res);
    }

    @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      private Map<String, Object> createListEntry(Image img,String name,String extension) {
  Map<String, Object> entry = new HashMap<>();
  entry.put("icon", img);
  entry.put("Line2", name);
  entry.put("Line3", extension);
  
  return entry;
}
    

    
}
