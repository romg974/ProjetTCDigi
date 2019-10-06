package com.company.vente;

public class Alcool extends Article implements IVendrePiece, ISolde{
    private float prix;
    private float remise;

    public Alcool(String nom, float prix) {
        super(nom);
        this.prix = prix;
    }

    @Override
    public void presentoir() {
        System.out.println(this.nom + " | " + this.prix + "€");
    }

    @Override
    public float getPrixUnitaire() {
        return this.prix * (1-this.remise/100);
    }

    @Override
    public float getRemisePourcent() {
        return remise;
    }

    @Override
    public void setRemisePourcent(float remise) throws PasEntre0et100Exception {
        if(remise < 0 || remise > 100)
            throw new PasEntre0et100Exception();
        this.remise = remise;
    }
}
