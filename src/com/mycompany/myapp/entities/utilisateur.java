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
public class utilisateur {
    private int ncli;
    private String nom;
    private String prenom;
    private String email;
    private String login;
    private String motDePasse;
    private String sexe;
    private String Date_naiss;
    private String type;
    private String activite;
    private String formation_participe;

    

     public utilisateur(int ncli, String nom, String prenom, String email, String login, String motDePasse) {
        this.ncli = ncli;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.login = login;
        this.motDePasse = motDePasse;
    }
     public utilisateur(int ncli, String nom, String prenom, String email) {
        this.ncli = ncli;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
      public utilisateur() {
        
    }
      
    
    public void setNcli(int ncli) {
        this.ncli = ncli;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDate_naiss(String Date_naiss) {
        this.Date_naiss = Date_naiss;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public void setFormation_participe(String formation_participe) {
        this.formation_participe = formation_participe;
    }

   

    public int getNcli() {
        return ncli;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDate_naiss() {
        return Date_naiss;
    }

    public String getType() {
        return type;
    }

    public String getActivite() {
        return activite;
    }

    public String getFormation_participe() {
        return formation_participe;
    }
   
   
    @Override
    public String toString() {
        return "utilisateur{" + "ncli=" + ncli + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", login=" + login + ", motDePasse=" + motDePasse + ", sexe=" + sexe + ", Date_naiss=" + Date_naiss + ", type=" + type + ", activite=" + activite + ", formation_participe=" + formation_participe + '}';
    }
    
}
