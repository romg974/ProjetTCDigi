package com.company.personnes.enfants;

public class Lyceen extends Enfant implements Scolaire {
    static String[] niveaux = {"Seconde", "Premiere", "Terminale"};
    boolean examen;
    private String niveau;

    public Lyceen(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String niveau) {
        super(nom, prenom, anneeNaissance, sexe, deptNaissance);
        this.niveau = niveau;
        examen = (niveau == "Terminale");
    }

    @Override
    public boolean petit() {
        return niveau.equals("Seconde");
    }

    @Override
    public boolean moyen() {
        return !niveau.equals("Seconde") && !niveau.equals("Terminale");
    }

    @Override
    public boolean grand() {
        return niveau.equals("Terminale");
    }
}
