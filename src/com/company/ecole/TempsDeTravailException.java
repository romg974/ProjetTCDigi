package com.company.ecole;

public class TempsDeTravailException extends Exception {
    @Override
    public String getMessage() {
        return "Le temps de travil doit être compris entre 0 et 100";
    }
}
