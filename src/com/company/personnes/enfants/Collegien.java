package com.company.personnes.enfants;

public class Collegien extends Enfant implements Scolaire {
    static String[] niveaux = {"6eme", "5eme", "4eme", "3eme"};
    boolean examen;
    private String niveau;

    public Collegien(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String niveau) {
        super(nom, prenom, anneeNaissance, sexe, deptNaissance);
        this.niveau = niveau;
        examen = (niveau == "3eme");

    }

    @Override
    public boolean petit() {
        return niveau.equals("6eme");
    }

    @Override
    public boolean moyen() {
        return !niveau.equals("6eme") && !niveau.equals("3eme");
    }

    @Override
    public boolean grand() {
        return niveau.equals("3eme");
    }
}
