/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageButton;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.myapp.entities.Evenement;
import com.mycompany.myapp.services.ServiceEvent;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.text.DateFormat;
import java.text.DateFormatPatterns;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mohsen
 */
public class Listevents extends Form {
    
        private Form f,current;
        private Resources theme;
        private Resources themelabel;
        private UIBuilder uiBuilder;
        SpanLabel lb;


    public Listevents(Form previous,Resources theme) throws IOException
    {
        current=this;
        this.theme = theme;
        this.setLayout(BoxLayout.y());
      
        
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        
       tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , r->new ProfileForm(theme).show() );
       
        Component[] result = new Component[50];
        ServiceEvent so = new ServiceEvent();
        //search
        Toolbar.setGlobalToolbar(true);
        add(new InfiniteProgress());
        
                Display.getInstance().scheduleBackgroundTask(()-> {
                    // this will take a while...
                    Display.getInstance().callSerially(() -> {
                        removeAll();
                        List<Evenement> listeoffres=so.afficheEvent();
                        for(Evenement o : listeoffres)
                        {
                           

                            MultiButton m = new MultiButton();
                            
                            m.setTextLine1("nom:"+o.getNom());
                            m.setTextLine2("description:"+o.getDescription());
                            m.setTextLine3("type:"+o.getDescription());
                            m.setTextLine4("nb max :"+o.getNbMaxParticipant());
                            
                            add(m);
                            m.addPointerReleasedListener(new ActionListener()
                            {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        if (Dialog.show("Confirmation", "Que voulez vous faire ?", "Supprimer", "Modifier"))
                                        {
                                            Evenement k = new Evenement(o.getId_event());
                                                
                                                if( ServiceEvent.getInstance().suppoffre(k)){
                                                    {
                                                        Dialog.show("Success","supprimer",new Command("OK"));
                                                    }
                                                
                                        }
                                       }
                                        else
                                        {
                                                new editEvent(current,o,theme).show();
                                        }
                                    }
                                });
                         }    
                        revalidate();
                           });
                });
                   getToolbar().addSearchCommand(e -> { //rechercheee
    String text = (String)e.getSource();
    if(text == null || text.length() == 0) {
        // clear search
        for(Component cmp : getContentPane()) {
            cmp.setHidden(false);
            cmp.setVisible(true);
        }
        getContentPane().animateLayout(150);
    } else {
        text = text.toLowerCase();
        for(Component cmp : getContentPane()) {
            MultiButton mb = (MultiButton)cmp;
            String line1 = mb.getTextLine1();
            String line2 = mb.getTextLine2();
            boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1 ||
            line2 != null && line2.toLowerCase().indexOf(text) > -1;
            mb.setHidden(!show);
            mb.setVisible(show);
        }
        getContentPane().animateLayout(150);
    }
        }, 4);
                        
             
        
        
        
        
        setTitle("Liste des evenments");
     //   getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        
    }

  
    
    
}
