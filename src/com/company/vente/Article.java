package com.company.vente;

import java.io.Serializable;

public abstract class Article implements Serializable {
    protected String nom;

    public Article(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    abstract public void presentoir();
    abstract public float getPrixUnitaire();
}
