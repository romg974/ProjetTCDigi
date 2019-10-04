package com.company.ecole;

import com.company.personnes.NumeroSecuriteSocialeInvalideException;

import java.util.HashMap;
import java.util.Map;

public class Enseignant extends Personnel {
    private String echelon;
    private boolean serviceFait;
    private int heuresSupp;
    private int mission;

    private static int prime = 500;
    private static Map<String, Integer> fixe = new HashMap<>(){{
        //add the elements to the hastable
        put("PROF", 1000);
        put("MDC", 2000);
        put("PRAG", 4000);
    }};
    private static final Map<String, Integer> service = new HashMap<>() {{
        //add the elements to the hastable
        put("PROF", 192/2);
        put("MDC", 192);
        put("PRAG", 192*2);
    }};

    public Enseignant(String nom, String prenom, String numSecu, String date_entree, int temps_travail, String echelon) throws NumeroSecuriteSocialeInvalideException, TempsDeTravailException, EchelonException {
        super(nom, prenom, numSecu, date_entree, temps_travail);

        if (!fixe.containsKey(echelon))
            throw new EchelonException();

        this.echelon = echelon;
    }

    public Enseignant(String nom, String prenom, String numSecu, String adresse, String date_entree, int temps_travail, String echelon) throws NumeroSecuriteSocialeInvalideException, TempsDeTravailException, EchelonException {
        super(nom, prenom, numSecu, adresse, date_entree, temps_travail);

        if (!fixe.containsKey(echelon))
            throw new EchelonException();

        this.echelon = echelon;
    }

    public boolean isServiceFait() {
        //Doit pouvoir être calculer avec le temps réalisé + mission et le temps target
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

    public int getMission() {
        return mission;
    }

    public void setMission(int mission) {
        this.mission = mission;
    }

    @Override
    int calculSalaire() {
        int somme = fixe.get(echelon);

        if(serviceFait)
            somme += prime;

        somme += heuresSupp*Personnel.taux;

        return somme;
    }
}
