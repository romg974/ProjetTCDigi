package com.company.vente;

public class PasEntre0et100Exception extends Exception{
    @Override
    public String getMessage() {
        return "Le pourcentage doit être compris entre 0 et 100.";
    }
}
