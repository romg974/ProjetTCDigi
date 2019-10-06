package com.company;

import com.company.compteBancaire.CompteBanque;
import com.company.ecole.EchelonException;
import com.company.ecole.Enseignant;
import com.company.ecole.TempsDeTravailException;
import com.company.personnes.NumeroSecuriteSocialeInvalideException;
import com.company.personnes.Personne;
import com.company.vente.*;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Article[] articles = new Article[3];

        Primeur p0 = new Primeur("Pomme", 0.05f, 1.5f, 1);
        Electromenager e0 = new Electromenager("Machine à laver", 400);
        Habit h0 = new Habit("Veste en jean", "bleu", "L", 5, 60);

        articles[0] = p0;
        articles[1] = e0;
        articles[2] = h0;

        for(int i = 0; i<3; i++){
            articles[i].presentoir();
        }

        IPublicite[] pubs = new IPublicite[2];
        pubs[0] = p0;
        pubs[1] = e0;

        for(int i = 0; i<2; i++){
            System.out.println(pubs[i].getMessagePublicitaire());
        }

        Magasin magasin = new Magasin("Chez René", "37 Rue joliot curie", 2);
        magasin.addArticle(p0, 5);
        magasin.addArticle(e0, 10);
        magasin.addArticle(h0, 20);
        magasin.setCaisse(1000);

        System.out.println(magasin);

        Enseignant ens = null;
        try {
            ens = new Enseignant("Loutre", "Jean", "1969701010101", "20/11/2018", 100, "PROF");
        } catch (NumeroSecuriteSocialeInvalideException | TempsDeTravailException | EchelonException e) {
            e.printStackTrace();
        }

        assert ens != null;
        CompteBanque compte = new CompteBanque("1666", ens, "1234", "5678");

        try {
            compte.versement(100, "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(compte);


        Ticket ticket = null;
        try {
            ticket = magasin.achete(ens, p0, "1234");
        } catch (AchatException e) {
            e.printStackTrace();
        }

        System.out.println(compte);
        System.out.println(ticket);

        try {
            assert ticket != null;
            magasin.rembourse(ticket);
        } catch (RembourseException e) {
            e.printStackTrace();
        }

        System.out.println(compte);

        try {
            magasin.rembourse(ticket);
        } catch (RembourseException e) {
            e.printStackTrace();
        }

        try {
            magasin.debuterSolde(30, p0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(magasin);

        try {
            ens.save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Personne pclone = new Personne("out/Jean_Loutre.personne");
            System.out.println(ens);
            System.out.println(ens.getCompte());
            System.out.println(pclone);
            System.out.println(pclone.getCompte());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            magasin.save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Magasin mclone = new Magasin("out/Chez René.magasin");
            System.out.println(magasin);
            System.out.println(mclone);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
