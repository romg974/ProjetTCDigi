package com.company.ecole;

public class IATOS extends Personnel {
    private int salaireFixe;
    private int tauxVariable;
    private int heuresSupp;

    public IATOS(int salaireFixe, int tauxVariable) {
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
