/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author ghassen
 */
public class formation {
    
     private int id;
    private String sujet;
    private String date ;
    private String description;
    private int effectif;
      public formation() {
        
    }


    public formation(int id, String sujet, String date, String description, int effectif) {
        this.id = id;
        this.sujet = sujet;
        this.date = date;
        this.description = description;
        this.effectif = effectif;
    }


   

    public void setEffectif(int effectif) {
        this.effectif = effectif;
    }

    public int getEffectif() {
        return effectif;
    }

    public formation(String sujet, String date, String description) {
        this.sujet = sujet;
        this.date = date;
        this.description = description;
    }

    public formation(int id) {
        this.id = id;
    }

    public formation(String sujet) {
        this.sujet = sujet;
    }

    public formation(int id, String sujet, String date, String description) {
        this.id = id;
        this.sujet = sujet;
        this.date = date;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    

    public int getId() {
        return id;
    }

    public String getSujet() {
        return sujet;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
    

    @Override
    public String toString() {
        return "formation{" + "id=" + id + ", sujet=" + sujet + ", date=" + date + ", description=" + description + ", effectif=" + effectif + '}';
    }
     

    
    
}
