package com.company.ecole;

import com.company.personnes.Personne;

public class Eleve extends Personne {
    private String ine;
    private int promo;
    private int annee;

    public Eleve(String nom, String prenom, String numSecu, String ine, int promo, int annee) {
        super(nom, prenom, numSecu);
        this.ine = ine;
        this.promo = promo;
        this.annee = annee;
    }

    public String getIne() {
        return ine;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
