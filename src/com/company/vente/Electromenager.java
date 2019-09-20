package com.company.vente;

public class Electromenager extends Article implements IVendrePiece, IPublicite {
    private float prixUnitaire;

    public Electromenager(String nom, float prixUnitaire) {
        super(nom);
        this.prixUnitaire = prixUnitaire;
    }

    @Override
    public String getMessagePublicitaire() {
        return "Venez acheter le super "+this.nom+" pour votre maison";
    }

    @Override
    public float getPrixUnitaire() {
        return prixUnitaire;
    }
}
