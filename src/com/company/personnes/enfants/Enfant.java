package com.company.personnes.enfants;

public class Enfant {
    private String nom;
    private String prenom;
    private int anneeNaissance;
    private char sexe = 'N';
    private int deptNaissance;

    public Enfant(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
        this.sexe = sexe;
        this.deptNaissance = deptNaissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public char getSexe() {
        return sexe;
    }

    public int getDeptNaissance() {
        return deptNaissance;
    }
}
