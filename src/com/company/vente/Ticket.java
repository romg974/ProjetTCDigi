package com.company.vente;

import com.company.personnes.Personne;

public class Ticket {
    private Magasin magasin;
    private Personne personne;
    private Article article;
    private float montant;

    public Ticket(Magasin magasin, Personne personne, Article article, float montant) {
        this.magasin = magasin;
        this.personne = personne;
        this.article = article;
        this.montant = montant;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public Personne getPersonne() {
        return personne;
    }

    public Article getArticle() {
        return article;
    }

    public float getMontant() {
        return montant;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "magasin=" + magasin +
                ", personne=" + personne +
                ", article=" + article +
                ", montant=" + montant +
                '}';
    }
}
