package com.company.vente;

public abstract class Article {
    protected String nom;

    public Article(String nom) {
        this.nom = nom;
    }

    abstract public void presentoir();
    abstract public float getPrixUnitaire();
}
