package com.company.personnes;

import java.util.Calendar;

public class Personne {
    private String nom;
    private String prenom;
    private String numSecu;
    private int anneeNaissance;
    private char sexe = 'N';
    private int deptNaissance;

    public Personne(String nom, String prenom, String numSecu) throws NumeroSecuriteSocialeInvalideException {
        this.nom = nom;
        this.prenom = prenom;

        if(numSecu.length() < 13)
            throw new NumeroSecuriteSocialeInvalideException();
        this.numSecu = numSecu;

        this.sexe();
        this.deptNaissance();
        this.anneeNaissance();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public char getSexe() {
        return sexe;
    }

    public int getDeptNaissance() { return deptNaissance; }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumSecu(String numSecu) throws NumeroSecuriteSocialeInvalideException {
        if(numSecu.length() < 13)
            throw new NumeroSecuriteSocialeInvalideException();

        this.numSecu = numSecu;

        this.sexe();
        this.deptNaissance();
        this.anneeNaissance();
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numSecu='" + numSecu + '\'' +
                (anneeNaissance != 0 ? ", anneeNaissance=" + anneeNaissance : "") +
                (sexe != 'N' ? ", sexe=" + sexe : "") +
                ", deptNaissance=" + deptNaissance +
                '}';
    }

    private void anneeNaissance(){
        int annee = Integer.parseInt(numSecu.substring(1,3));
        if(annee > 20)
            this.anneeNaissance = 1900+annee;
        else
            this.anneeNaissance = 2000+annee;
    }

    private void sexe(){
        if(numSecu.substring(0,1).equals("1")){
            sexe = 'M';
        }else if(numSecu.substring(0,1).equals("2")){
            sexe = 'F';
        }
    }

    private void deptNaissance(){
        this.deptNaissance = Integer.parseInt(numSecu.substring(5, 7));
    }

    public int calculAge(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);

        return year-this.anneeNaissance;
    }
}
