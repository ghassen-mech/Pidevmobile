/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author dell
 */
public class Evenement {
    
        
    private int id_event;
    private String nom,description,type,date_deb,date_fin;
    private int nbMaxParticipant;


    public Evenement() {
    }

    public Evenement(int id_event) {
        this.id_event = id_event;
    }

    public Evenement(int id_event, String nom, String description, String type, String date_deb, String date_fin) {
        this.id_event = id_event;
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
    }

    public Evenement(int id_event, String nom, String description, String type, String date_deb, String date_fin, int nbMaxParticipant) {
        this.id_event = id_event;
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.nbMaxParticipant = nbMaxParticipant;
    }
    

    public Evenement(String nom, String description, String type, String date_deb, String date_fin) {
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
    } 

    public Evenement(String nom, String description, String type, String date_deb, String date_fin, int nbMaxParticipant) {
        this.nom = nom;
        this.description = description;
        this.type = type;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
        this.nbMaxParticipant = nbMaxParticipant;
    }
    
    

    public int getId_event() {
        return id_event;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getDate_deb() {
        return date_deb;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public int getNbMaxParticipant() {
        return nbMaxParticipant;
    }
    
    

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate_deb(String date_deb) {
        this.date_deb = date_deb;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public void setNbMaxParticipant(int nbMaxParticipant) {
        this.nbMaxParticipant = nbMaxParticipant;
    }
    
}
