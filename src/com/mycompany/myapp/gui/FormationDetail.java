/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;

import com.codename1.ui.Image;
import com.codename1.ui.Label;

import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.utilisateur;
import com.mycompany.myapp.services.serviceformation;
import java.util.ArrayList;
import java.util.Map;



/**
 *
 * @author ghassen
 */
public class FormationDetail extends sidemenuclient{
     int nbr=10;
    int nbrpart=0;
     public FormationDetail(Resources res) {
         
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
       tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e->new Formationclient(res).show() );
        
        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        
        menuButton.addActionListener(e -> getToolbar().openSideMenu());
         
        
        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.centerAbsolute(
                                BoxLayout.encloseY(
                                    new Label("bienvenue ", "Title")
                                       
                                    
                                )
                            )
                );
       
     
       tb.setTitleComponent(titleCmp);
      
          
        String url="http://localhost/imagepi/p.jpg";
        EncodedImage enc=EncodedImage.createFromImage(Image.createImage(getWidth(), getHeight()/ 3, 0xffff0000), true);
        URLImage urlimg=URLImage.createToStorage(enc, "sti", url);
        ImageViewer imgv=new ImageViewer(urlimg);
        Label sujet=new Label(Formationclient.sujetf,"ProfilePic");
         Container cnt = new Container(BoxLayout.x());
          Button Participer=new Button("Participer");
          
          
          //nombre de participants
           
        ArrayList<utilisateur> array=serviceformation.getInstance().getlistparticipants(Formationclient.idf);
        ArrayList<String> datahhnom = new ArrayList<>();
     int nbrpart=0;
        for(utilisateur t:array){
           datahhnom.add(t.getNom());
           
        }
          nbrpart=datahhnom.size();
          System.out.println(nbrpart);
          nbr=nbr - nbrpart;
          //Participer a une formation
            Participer.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                    try {
                        
                       if( serviceformation.getInstance().ParticiperF(Formationclient.idf,16,Formationclient.sujetf)){
                                                                                      //het l'id ye 3ajngui
                            Dialog.show("Success","PArticipation Enregistrer",new Command("OK"));
                            //nbr=nbr - 1;
                         new Formationclient(res).show();}
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
     
            }
        });
         
      // cnt.addAll(sujet,Participer);
       
       Container cntdesc = new Container(BoxLayout.y());
        Label lbdesc=new Label("Description :","StatusBarSideMenu");
         Label lbdescr=new Label(Formationclient.descriptionf+" L’ensemble des techniques et des processus   ","TextField");
        cntdesc.addAll(lbdesc,lbdescr);
        
         
         
        if(nbr>0){
            Label nbrrestant=new Label(nbr+" Place disponnible");
          nbrrestant.getAllStyles().setFgColor(0xff000);
            cnt.addAll(nbrrestant,Participer);
            addAll(imgv,sujet,cnt,cntdesc);
            
        }else{
           Label nodisp=new Label("Place Non disponnible");
           nodisp.getAllStyles().setFgColor(0xFF0000);
        cnt.addAll(sujet);
        addAll(imgv,cnt,nodisp,cntdesc);
        }
        
       
    
}

    @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
