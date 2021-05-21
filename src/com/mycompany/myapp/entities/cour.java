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
public class cour {
      private int id ;
    private String nom;
    private String extension;
    private String imag;
    private int idf;
    

    public cour(String nom, String extension,String imag, int idf) {
        this.nom = nom;
        this.extension = extension;
        this.imag=imag;
        this.idf = idf;
    }

    public cour(int id) {
        this.id = id;
    }
     public cour() {
        
    }

    public cour(String nom) {
        this.nom = nom;
    }

    public cour(String nom, String extension) {
        this.nom = nom;
        this.extension = extension;
    }
    

    public cour(int id, String nom, String extension,String imag, int idf) {
        this.id = id;
        this.nom = nom;
        this.extension = extension;
        this.imag=imag;
        this.idf = idf;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setDomaine(String nom) {
        this.nom = nom;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getExtension() {
        return extension;
    }

    public int getIdf() {
        return idf;
    }

    public String getImag() {
        return imag;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }
    

    @Override
    public String toString() {
        return "cour{" + "id=" + id + ", nom=" + nom + ", extension=" + extension +", image=" + imag + ", idf=" + idf + '}';
    }
    
            

       
    
    
}
