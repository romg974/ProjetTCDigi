package com.company.vente;

import com.company.compteBancaire.CompteBanque;
import com.company.personnes.Personne;

import java.io.*;
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
        this.stocks = new Hashtable<>();
        this.ventes = new ArrayList<>();
    }

    public Magasin(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            this.nom = (String) ois.readObject();
            this.adresse = (String) ois.readObject();
            this.nbVendeurs = (int) ois.readObject();
            this.caisse = (int) ois.readObject();

            Article art;
            int q;
            this.stocks = new Hashtable<>();
            int m = (int) ois.readObject();
            for (int i = 0; i < m; i++) {
                art = (Article) ois.readObject();
                q = (int) ois.readObject();
                this.stocks.put(art, q);
            }

            this.ventes = new ArrayList<>();
            m = (int) ois.readObject();
            for (int i = 0; i < m; i++) {
                this.ventes.add((Ticket) ois.readObject());
            }

            } catch (ClassNotFoundException e) {
            throw new IOException("Wrong stack format.");
        }

        ois.close();
        fis.close();
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

        this.caisse -= ticket.getMontant();

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

    public void save() throws IOException {
        File file = new File("out/" +this.nom + ".magasin");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(this.nom);
        oos.writeObject(this.adresse);
        oos.writeObject(this.nbVendeurs);
        oos.writeObject(this.caisse);

        oos.writeObject(this.stocks.keySet().size());
        for (Article art : this.stocks.keySet()) {
            oos.writeObject(art);
            oos.writeObject(this.stocks.get(art));
        }

        oos.writeObject(this.ventes.size());
        for(Ticket ticket : this.ventes) {
            oos.writeObject(ticket);
        }

        oos.flush();
        oos.close();
        fos.close();
    }
}
