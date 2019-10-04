package com.company.ecole;

import com.company.personnes.NumeroSecuriteSocialeInvalideException;

public class Enseignant extends Personnel {
    private String echelon;
    private int service;
    private int prime;
    private boolean serviceFait;
    private int heuresSupp;

    public Enseignant(String nom, String prenom, String numSecu, String date_entree, int temps_travail, String echelon) throws NumeroSecuriteSocialeInvalideException, TempsDeTravailException, EchelonException {
        super(nom, prenom, numSecu, date_entree, temps_travail);

        switch (echelon) {
            case "MDC":
                service = 192;
                break;
            case "PROF":
                service = 96;
                break;
            case "PRAG":
                service = 192*2;
                break;
            default:
                throw new EchelonException();
        }

        this.echelon = echelon;
    }

    public Enseignant(String nom, String prenom, String numSecu, String adresse, String date_entree, int temps_travail, String echelon) throws NumeroSecuriteSocialeInvalideException, TempsDeTravailException, EchelonException {
        super(nom, prenom, numSecu, adresse, date_entree, temps_travail);

        switch (echelon) {
            case "MDC":
                service = 192;
                break;
            case "PROF":
                service = 96;
                break;
            case "PRAG":
                service = 192*2;
                break;
            default:
                throw new EchelonException();
        }

        this.echelon = echelon;
    }

    public boolean isServiceFait() {
        return serviceFait;
    }

    public void setServiceFait(boolean serviceFait) {
        this.serviceFait = serviceFait;
    }

    public int getHeuresSupp() {
        return heuresSupp;
    }

    public void setHeuresSupp(int heuresSupp) {
        this.heuresSupp = heuresSupp;
    }

    @Override
    int calculSalaire() {
        int somme = 0;
        if(serviceFait)
            somme += prime;

        somme += heuresSupp*Personnel.taux;

        return somme;
    }
}
