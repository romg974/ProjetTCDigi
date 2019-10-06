package com.company.compteBancaire;

import com.company.personnes.Personne;
import com.company.vente.Magasin;
import com.company.vente.Ticket;

import java.security.InvalidParameterException;

public class CompteBanque {
    private String num;
    private Personne client;
    private float solde;
    private float decouvertAutorise;
    private String code1;
    private String code2;

    public CompteBanque (String num, Personne client, String code1, String code2) {
        this.num = num;
        this.client = client;
        this.code1 = code1;
        this.code2 = code2;
        this.solde = 0;
        this.decouvertAutorise = 0;
        client.setCompte(this);
    }

    public String getNum() {
        return num;
    }

    public Personne getClient() {
        return client;
    }

    public float getSolde() {
        return solde;
    }

    public float getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setCode1(String newCode1, String code1) throws CodeInvalideException {
        if (!this.code1.equals(code1))
            throw new CodeInvalideException();

        this.code1 = newCode1;
    }

    public void setCode2(String newCode2, String code2) throws CodeInvalideException {
        if (!this.code2.equals(code2))
            throw new CodeInvalideException();

        this.code2 = newCode2;
    }

    public void setSolde(float newSolde, String code1) throws CodeInvalideException {
        if (!this.code1.equals(code1))
            throw new CodeInvalideException();

        this.solde = newSolde;
    }

    public void setDecouvertAutorise(float newDecouvertAutorise, String code2) throws CodeInvalideException {
        if (!this.code2.equals(code2))
            throw new CodeInvalideException();

        this.decouvertAutorise = newDecouvertAutorise;
    }

    public void rembourseTransaction(Magasin magasin, Ticket ticket) throws Exception {
        if(!magasin.verifieVente(ticket))
            throw new Exception("Cette vente n'est pas vérifiée par le magasin");

        this.solde += ticket.getMontant();
    }

    public void versement(float somme, String code) throws Exception {
        if(!code1.equals(code))
            throw new CodeInvalideException();

        if(somme < 0)
            throw new InvalidParameterException("Somme doit être positive");

        this.solde += somme;
    }

    public void retrait(float somme, String code) throws Exception {
        if (!code1.equals(code))
            throw new CodeInvalideException();

        if (somme < 0)
            throw new InvalidParameterException("Somme doit être positive");

        if (solde - somme < -decouvertAutorise)
            throw new Exception("Operation invalide");

        solde -= somme;
    }

    @Override
    public String toString() {
        return "Compte de : " + client.getNom() + " " + client.getPrenom() +
                "\n  -Solde : " + solde +
                "\n  -Decouvert Autorise : " + decouvertAutorise + "\n";
    }
}
