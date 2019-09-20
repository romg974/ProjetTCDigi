package com.company.ecole;

public class Enseignant extends Personnel {
    private String echelon;
    private int service;
    private int prime;
    private boolean serviceFait;
    private int heuresSupp;

    public Enseignant(String echelon) {
        this.echelon = echelon;

        if(echelon == "MDC")
            service = 192;
        else if(echelon == "PROF")
            service = 96;
        else
            service = 192*2;
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
