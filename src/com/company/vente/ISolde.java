package com.company.vente;

public interface ISolde {
    float getRemisePourcent();
    void setRemisePourcent(float remise) throws PasEntre0et100Exception;
}
