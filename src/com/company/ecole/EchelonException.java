package com.company.ecole;

public class EchelonException extends Exception {
    @Override
    public String getMessage() {
        return "L'echellon choisit n'existe pas pour ce type de personne";
    }
}
