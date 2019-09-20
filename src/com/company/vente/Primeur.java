package com.company.vente;

public class Primeur extends Article implements IVendreKilo, IPublicite, ISolde {
    float prixAuGramme;
    float remise;

    public Primeur(String nom, float prixAuGramme, float remise) {
        super(nom);
        this.prixAuGramme = prixAuGramme;
        this.remise = remise;
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

    @Override
    public void setRemisePourcent(float remise) throws PasEntre0et100Exception {
        if(remise < 0 || remise > 100)
            throw new PasEntre0et100Exception();
        this.remise = remise;
    }

    @Override
    public void presentoir() {
        System.out.println(this.nom+" | "+this.getPrixAuKilo()+"€/kg");
    }
}
