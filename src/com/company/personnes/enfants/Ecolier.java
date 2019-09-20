package com.company.personnes.enfants;

public class Ecolier extends Enfant implements Scolaire {
    static String[] niveaux = {"CP", "CE1", "CE2", "CM1", "CM2"};
    private String niveau;

    public Ecolier(String nom, String prenom, int anneeNaissance, char sexe, int deptNaissance, String niveau) {
        super(nom, prenom, anneeNaissance, sexe, deptNaissance);
        this.niveau = niveau;
    }

    @Override
    public boolean petit() {
        return niveau.equals("CP");
    }

    @Override
    public boolean moyen() {
        return !niveau.equals("CP") && !niveau.equals("CM2");
    }

    @Override
    public boolean grand() {
        return niveau.equals("CM2");
    }
}
