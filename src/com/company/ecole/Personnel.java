package com.company.ecole;

public abstract class Personnel {
    protected String date_entree;
    protected int temps_travail;

    static public int taux = 10;

    abstract int calculSalaire();
}
