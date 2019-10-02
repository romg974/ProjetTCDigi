package com.company.compteBancaire;

public class CodeInvalideException extends Exception {
    @Override
    public String getMessage() {
        return "Le code entré est invalide.";
    }
}
