/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;

import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Evenement;

import com.mycompany.myapp.utils.Statics;
import com.sun.javafx.collections.MappingChange.Map;

//import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class ServiceEvent {
    
    
        public static ServiceEvent instance = null;
        public boolean Result;
    
    //initialisation connexion
    private ConnectionRequest req;
    
    public static ServiceEvent getInstance()
    {
        if(instance == null)
        {
            instance = new ServiceEvent();
        }
            return instance;        
    }
    
    
    //construct
    public ServiceEvent()
    {
        req = new ConnectionRequest();
    }
    
    //Ajout Event
    public void ajoutEvent(Evenement event)
    {
        String url= Statics.BASE_URL+"/Evenement/Add?nom"+event.getNom()+"&description="+event.getDescription()+"&type="+event.getType()+"&date_deb="+event.getDate_deb()+"&date_fin="+event.getDate_fin()+"&nbMaxParticipant="+event.getNbMaxParticipant();
        req.setUrl(url);
        req.addResponseListener((e)-> {
                    String str = new String(req.getResponseData());
                    System.out.println("data == " + str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    }
    
    //Afich Event
    public ArrayList<Evenement> afficheEvent()
    {
        ArrayList<Evenement> result = new ArrayList<>();
        String url = Statics.BASE_URL+"/AffichePEventj";
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsnp;
//                jsnp = new jsnp();
                jsnp = new JSONParser();
                
                try{
                    java.util.Map<String,Object>mapEvenement = jsnp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<java.util.Map<String,Object>> listOfMaps = (List<java.util.Map<String,Object>>) mapEvenement.get("root");
                    
                    for( java.util.Map<String,Object> obj : listOfMaps )
                    {
                        Evenement ev = new Evenement();
                        float id_event = Float.parseFloat(obj.get("id").toString());
                        String nom = obj.get("nom").toString();
                        String description = obj.get("description").toString();
                        String type = obj.get("type").toString();
                        /*
                        String date_deb = obj.get("date_deb").toString();
                        String date_fin = obj.get("date_fin").toString();
                        */
                        float nbMaxParticipant = Float.parseFloat(obj.get("nbMaxParticipant").toString());
                        
                        ev.setId_event((int) id_event);
                        ev.setNom(nom);
                        ev.setDescription(description);
                        ev.setType(type);
                        // ev.setDate_deb(date_deb);
                        //ev.setDate_fin(date_fin);
                        ev.setNbMaxParticipant((int) nbMaxParticipant); 
                        
                        result.add(ev);
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                
            }
        
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
        
    }

    public boolean suppoffre(Evenement k) {
        String url = Statics.BASE_URL +"/SupPevent?id="+k.getId_event();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Result = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Result;
    }

   
   public boolean ajouterevent(Evenement e)
    {
        String url =  Statics.BASE_URL+"/ajoutPevent?nom="+e.getNom()+"&description="+e.getDescription()+"&type="+e.getType()+"&nbMaxParticipant="+e.getNbMaxParticipant();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Result = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Result;
    }
   
    
    public boolean editevent(Evenement k)
    {
      String url = Statics.BASE_URL+"/modifPEvent?id="+k.getId_event()+"&nom="+k.getNom()+"&description="+k.getDescription()+"&type="+k.getType()+"&nbMaxParticipant="+k.getNbMaxParticipant();
       req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Result = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Result;
 
    }


    }
    
    
    
    
    
    
    

