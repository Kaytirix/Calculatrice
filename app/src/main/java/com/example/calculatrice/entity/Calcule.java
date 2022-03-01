package com.example.calculatrice.entity;

public class Calcule extends BaseEntity{

    Integer premierElement;
    Integer deuxiemeElement;
    String symbole;
    Double resultat;

    public Integer getPremierElement() {
        return premierElement;
    }

    public Integer getDeuxiemeElement() {
        return deuxiemeElement;
    }

    public String getSymbole() {
        return symbole;
    }

    public Double getResultat() {
        return resultat;
    }

    public void setPremierElement(Integer premierElement) {
        this.premierElement = premierElement;
    }

    public void setDeuxiemeElement(Integer deuxiemeElement) {
        this.deuxiemeElement = deuxiemeElement;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }
}
