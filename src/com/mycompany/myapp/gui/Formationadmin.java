/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.formation;
import com.mycompany.myapp.services.serviceformation;
import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ghassen
 */
public class Formationadmin extends SideMenuBaseForm{
    public static int idfo;
    public static String upsujet;
    public static String updesc;
     public static String update;
     public Formationadmin(Resources res) {
         
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
        Button btnAddformation=new Button("Ajouter formation");
        Button Participants=new Button("List Participants");
        Button Statistique=new Button("Statistique");
        Container btnbar = new Container(BoxLayout.x());
        btnbar.addAll(btnAddformation,Participants);
     titleCmp.add(Statistique);
     btnAddformation.addActionListener(e -> new ajouterformation(res).show());
       tb.setTitleComponent(titleCmp);
       //Statistiqueeee
        Statistique.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                         new Formationstatistic(res).show();}
                     
     
            
        });
       
       
       //List participant
       Participants.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                         new ListParticipants(res).show();}
                     
     
            
        });
       
       
      
                        
        
//          Button btnAddformation=new Button();
//        btnAddformation.addActionListener(e -> new ajouterformation(res).show());
//         
//        tb.setTitleComponent(btnAddformation);
          
        Label lb=new Label("formation selectionné");
        Label idformation=new Label();
        Button modifier=new Button("Modifier");
        Button supprimer=new Button("supprimer");
        Button Ajouter_cour=new Button("Ajouter cour");
        
        addAll(lb);
       Container btn = new Container(BoxLayout.x());
       btn.addAll(modifier,supprimer,Ajouter_cour);
         addAll(btn,btnbar);
         
         modifier.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                         new FormationModifier(res).show();}
                     
     
            
        });
         
          Ajouter_cour.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                         new AjouterCour(res).show();}
                     
     
            
        });
        
         
         supprimer.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                    try {
                        
                       if( serviceformation.getInstance().suppTask(Integer.parseInt(idformation.getText()))){
                            Dialog.show("Success","formation supprimer",new Command("OK"));
                         new Formationadmin(res).show();}
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
     
            }
        });
        
        
        ArrayList<formation> array=serviceformation.getInstance().getAllTasks("no");
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        ArrayList<String> datahh = new ArrayList<>();
        ArrayList<String> datahhdesc = new ArrayList<>();
        ArrayList<String> datahhdate = new ArrayList<>();
        ArrayList<Integer> datahhid = new ArrayList<>();
        
        for(formation t:array){
           datahh.add(t.getSujet());
           datahhdesc.add(t.getDescription());
           datahhdate.add(t.getDate());
           
           datahhid.add(t.getId());
           data.add(createListEntry(t.getSujet(), t.getDescription()));
          
        }
         DefaultListModel<Map<String, Object>> model = new DefaultListModel<>(data);
  MultiList ml = new MultiList(model);
 
  add( ml);
         
   
  ml.addActionListener((e->{
  System.out.println(ml.getSelectedIndex());
      System.out.println(datahh.get(ml.getSelectedIndex()));
          lb.setText(datahh.get(ml.getSelectedIndex()));
         System.out.println(datahhid.get(ml.getSelectedIndex()));
         idformation.setText(String.valueOf(datahhid.get(ml.getSelectedIndex())));
         idfo=datahhid.get(ml.getSelectedIndex());
         upsujet=datahh.get(ml.getSelectedIndex());
         updesc=datahhdesc.get(ml.getSelectedIndex());
         update=datahhdate.get(ml.getSelectedIndex());
 
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
