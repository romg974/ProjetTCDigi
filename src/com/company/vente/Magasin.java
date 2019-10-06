package com.company.vente;

import com.company.compteBancaire.CompteBanque;
import com.company.personnes.Personne;

import java.util.ArrayList;
import java.util.Hashtable;

public class Magasin {
    private String nom;
    private String adresse;
    private int nbVendeurs;
    private Hashtable<Article, Integer> stocks;
    private ArrayList<Ticket> ventes;

    public Magasin(String nom, String adresse, int nbVendeurs) {
        this.nom = nom;
        this.adresse = adresse;
        this.nbVendeurs = nbVendeurs;
        stocks = new Hashtable<>();
        ventes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getNbVendeurs() {
        return nbVendeurs;
    }

    public Hashtable<Article, Integer> getStocks() {
        return stocks;
    }

    public ArrayList<Ticket> getVentes() {
        return ventes;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNbVendeurs(int nbVendeurs) {
        this.nbVendeurs = nbVendeurs;
    }

    public int getStockOf(Article art){
        return stocks.get(art);
    }

    public void addArticle(Article art, int nb){
        stocks.put(art, nb);
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", nbVendeurs=" + nbVendeurs +
                ", stocks=" + stocks +
                '}';
    }

    public Ticket achete(Personne personne, Article art, String code) throws AchatException{
        if(!stocks.containsKey(art)){
            throw new AchatException("Cet article n'est pas disponible");
        }

        int stock = stocks.get(art);

        if(stock <= 0){
            throw new AchatException("Cet article n'est plus en stock.");
        }

        float prix = art.getPrixUnitaire();

        CompteBanque compte = personne.getCompte();
        try{
            compte.retrait(prix, code);
        }catch (Exception e){
            throw new AchatException(e.getMessage());
        }

        Ticket ticket = new Ticket(this, personne, art, 10);
        stocks.put(art, stock-1);
        ventes.add(ticket);

        return ticket;
    }
}
