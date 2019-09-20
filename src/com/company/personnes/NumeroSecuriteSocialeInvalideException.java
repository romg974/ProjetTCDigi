package com.company.personnes;

public class NumeroSecuriteSocialeInvalideException extends Exception {
    @Override
    public String getMessage() {
        return "Le numéro de sécurité sociale est invalide.";
    }
}
