package com.company.vente;

public class Primeur extends Article implements IVendreKilo, IPublicite, ISolde {
    float prixAuGramme;
    int remise;

    public Primeur(String nom) {
        super(nom);
    }

    public String getMessagePublicitaire() {
        return "Pour la rentrée, pensez à votre "+this.nom;
    }

    public float getRemisePourcent() {
        return remise;
    }

    public float getPrixAuKilo() {
        return prixAuGramme*1000*(1-remise/100);
    }
}
