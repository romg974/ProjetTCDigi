package com.company.ecole;

public class Note {
    private String matiere;
    private int note;
    private int credits;
    private boolean validation;

    public Note(String matiere, int note, int credits, boolean validation) {
        this.matiere = matiere;
        this.note = note;
        this.credits = credits;
        this.validation = validation;
    }

    public String getMatiere() {
        return matiere;
    }

    public int getNote() {
        return note;
    }

    public int getCredits() {
        return credits;
    }

    public boolean isValidation() {
        return validation;
    }
}
