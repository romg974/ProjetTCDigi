package com.company.ecole;

import com.company.personnes.NumeroSecuriteSocialeInvalideException;

import java.util.ArrayList;

public class EleveDigitale extends Eleve {
    private ArrayList<Note> notes;

    public EleveDigitale(String nom, String prenom, String numSecu, String ine, int promo, int annee) throws NumeroSecuriteSocialeInvalideException {
        super(nom, prenom, numSecu, ine, promo, annee);
        notes = new ArrayList<>();
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void addNote(Note n){
        notes.add(n);
    }
}
