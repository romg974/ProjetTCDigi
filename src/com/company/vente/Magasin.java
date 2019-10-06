package com.company.vente;

import com.company.compteBancaire.CompteBanque;
import com.company.personnes.Personne;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Magasin {
    private String nom;
    private String adresse;
    private int nbVendeurs;
    private Hashtable<Article, Integer> stocks;
    private ArrayList<Ticket> ventes;
    private int caisse;

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

    public int getCaisse() {
        return caisse;
    }

    public void setCaisse(int caisse) {
        this.caisse = caisse;
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

    public boolean verifieVente(Ticket ticket){
        return ventes.contains(ticket);
    }

    @Override
    public String toString() {
        return "Magasin{" +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", nbVendeurs=" + nbVendeurs +
                ", stocks=" + this.afficheStock() +
                ", caisse=" + this.caisse +
                "€}";
    }

    private String afficheStock() {
        StringBuilder res = new StringBuilder("{");
        boolean first = true;
        for (Article art : this.stocks.keySet()) {
            if (!first) {
                res.append(", ");
            } else {
                first = false;
            }
            res.append(art.getNom());
            res.append(":");
            res.append(this.stocks.get(art));
            res.append("€");
        }
        return res.append("}").toString();
    }

    public Ticket achete(Personne personne, Article art, String code) throws AchatException{
        if(!stocks.containsKey(art)){
            throw new AchatException("Cet article n'est pas disponible");
        }
        if (personne.calculAge() <= 10) {
            throw new AchatException("Une personne de moins de 10 ans ne peut pas faire d'achat");
        }
        if (art instanceof Alcool && personne.calculAge() < 18) {
            throw new AchatException("Une personne de moins de 18 ans ne peut pas acheter d'alcool");
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

        this.caisse += prix;

        Ticket ticket = new Ticket(this, personne, art, prix);

        stocks.put(art, stock-1);
        ventes.add(ticket);

        return ticket;
    }

    public void rembourse(Ticket ticket) throws RembourseException {
        if(ticket.getMagasin() != this)
            throw new RembourseException("Ce n'est pas le bon magasin !");

        if(!ventes.contains(ticket))
            throw new RembourseException("Le remboursement est impossible ! Le ticket est faux !");

        CompteBanque compte = ticket.getPersonne().getCompte();
        try {
            compte.rembourseTransaction(this, ticket);
        } catch (Exception e) {
            // Ceci ne peut normalement pas arriver
        }

        ventes.remove(ticket);
        stocks.put(ticket.getArticle(), stocks.get(ticket.getArticle())+1);
    }

    public void debuterSolde(float remise, Article article) throws PasEntre0et100Exception {
        if (!this.stocks.containsKey(article))
            throw new InvalidParameterException("Ce magasin ne possede pas cet article");

        if (!(article instanceof ISolde))
            throw new InvalidParameterException("Cet article ne peut pas être mis en solde");

        ((ISolde) article).setRemisePourcent(remise);
    }
}
