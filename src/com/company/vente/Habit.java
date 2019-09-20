package com.company.vente;

public class Habit extends Article  implements IVendrePiece, ISolde{
    private String couleur;
    private String taille;

    private int remise;
    private float prixUnitaire;

    public Habit(String nom, String couleur, String taille) {
        super(nom);
        this.couleur = couleur;
        this.taille = taille;
    }

    @Override
    public float getRemisePourcent() {
        return remise;
    }

    @Override
    public float getPrixUnitaire() {
        return prixUnitaire*(1-remise/100);
    }
}
