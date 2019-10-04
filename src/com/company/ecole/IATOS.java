package com.company.ecole;

import com.company.personnes.NumeroSecuriteSocialeInvalideException;

public class IATOS extends Personnel {
    private int salaireFixe;
    private int tauxVariable;
    private int heuresSupp;

    public IATOS(String nom, String prenom, String numSecu, String date_entree, int temps_travail, int salaireFixe, int tauxVariable) throws NumeroSecuriteSocialeInvalideException, TempsDeTravailException {
        super(nom, prenom, numSecu, date_entree, temps_travail);

        this.salaireFixe = salaireFixe;
        this.tauxVariable = tauxVariable;
    }

    public IATOS(String nom, String prenom, String numSecu, String adresse, String date_entree, int temps_travail, int salaireFixe, int tauxVariable) throws NumeroSecuriteSocialeInvalideException, TempsDeTravailException {
        super(nom, prenom, numSecu, adresse, date_entree, temps_travail);

        this.salaireFixe = salaireFixe;
        this.tauxVariable = tauxVariable;
    }

    public int getSalaireFixe() {
        return salaireFixe;
    }

    public void setSalaireFixe(int salaireFixe) {
        this.salaireFixe = salaireFixe;
    }

    public int getTauxVariable() {
        return tauxVariable;
    }

    public void setTauxVariable(int tauxVariable) {
        this.tauxVariable = tauxVariable;
    }

    public int getHeuresSupp() {
        return heuresSupp;
    }

    public void setHeuresSupp(int heuresSupp) {
        this.heuresSupp = heuresSupp;
    }

    @Override
    int calculSalaire() {
        return salaireFixe+tauxVariable*heuresSupp;
    }
}
