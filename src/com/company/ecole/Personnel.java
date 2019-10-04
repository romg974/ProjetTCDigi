package com.company.ecole;

import com.company.personnes.NumeroSecuriteSocialeInvalideException;
import com.company.personnes.Personne;

public abstract class Personnel extends Personne {

    protected String date_entree;
    protected int temps_travail;

    static public int taux = 10;

    public Personnel(String nom, String prenom, String numSecu, String date_entree, int temps_travail) throws NumeroSecuriteSocialeInvalideException, TempsDeTravailException {
        super(nom, prenom, numSecu);

        if (temps_travail < 0 || 100 < temps_travail)
            throw new TempsDeTravailException();

        this.date_entree = date_entree;
        this.temps_travail = temps_travail;
    }

    public Personnel(String nom, String prenom, String numSecu, String adresse, String date_entree, int temps_travail) throws NumeroSecuriteSocialeInvalideException, TempsDeTravailException {
        super(nom, prenom, numSecu, adresse);

        if (temps_travail < 0 || 100 < temps_travail)
            throw new TempsDeTravailException();

        this.date_entree = date_entree;
        this.temps_travail = temps_travail;
    }

    abstract int calculSalaire();
}
