package com.company;

import com.company.vente.*;

public class Main {

    public static void main(String[] args) {
        Article[] articles = new Article[3];

        Primeur p0 = new Primeur("Crayon", 0.5f, 1);
        Electromenager e0 = new Electromenager("Machine à laver", 400);
        Habit h0 = new Habit("Veste en jean", "bleu", "L", 5, 60);

        articles[0] = p0;
        articles[1] = e0;
        articles[2] = h0;

        for(int i = 0; i<3; i++){
            articles[i].presentoir();
        }

        IPublicite[] pubs = new IPublicite[2];
        pubs[0] = p0;
        pubs[1] = e0;

        for(int i = 0; i<2; i++){
            System.out.println(pubs[i].getMessagePublicitaire());
        }

    }
}
