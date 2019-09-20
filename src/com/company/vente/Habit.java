package com.company.vente;

import java.util.regex.PatternSyntaxException;

public class Habit extends Article  implements IVendrePiece, ISolde{
    private String couleur;
    private String taille;

    private float remise;
    private float prixUnitaire;


    public Habit(String nom, String couleur, String taille, float remise, float prixUnitaire) {
        super(nom);
        this.couleur = couleur;
        this.taille = taille;
        this.remise = remise;
        this.prixUnitaire = prixUnitaire;
    }

    @Override
    public float getRemisePourcent() {
        return remise;
    }

    @Override
    public float getPrixUnitaire() {
        return prixUnitaire*(1-remise/100);
    }

    @Override
    public void setRemisePourcent(float remise) throws PasEntre0et100Exception {
        if(remise < 0 || remise > 100)
            throw new PasEntre0et100Exception();
        this.remise = remise;
    }

    @Override
    public void presentoir() {
        System.out.println(this.nom+" | "+this.getPrixUnitaire()+"€");
    }
}
