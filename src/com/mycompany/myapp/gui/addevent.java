/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextComponent;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Evenement;
import com.mycompany.myapp.services.ServiceEvent;

/**
 *
 * @author dell
 */
public class addevent extends Form {

    public addevent(Resources res) 
    {
      setTitle("ajouter un event ");
      setLayout(BoxLayout.y());
      Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        
       tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e->new ProfileForm(res).show() );
      TextComponent tfname= new TextComponent().label("nom");
      TextComponent tfdescription= new TextComponent().label("description");
      TextComponent tfcontinent= new TextComponent().label("type");
      TextComponent tfimage= new TextComponent().label("nbMaxParticipant");
       Button btnValider = new Button("ajouter event");
      btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfname.getText().length()==0)||tfdescription.getText().length()==0)
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    Evenement e = new Evenement();
                    e.setNom(tfname.getText());
                    e.setDescription(tfdescription.getText());
                    e.setType(tfcontinent.getText());
                    e.setNbMaxParticipant((int) Float.parseFloat(tfimage.getText()));
                    if(ServiceEvent.getInstance().ajouterevent(e))
                        {
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        }
                        else
                           Dialog.show("ERROR", "Server error", new Command("OK"));
                }
                
              }  
            });      
      
      
      addAll(tfname,tfdescription,tfcontinent,tfimage,btnValider);
    }
    
}
