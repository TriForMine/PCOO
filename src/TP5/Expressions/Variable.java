package TP5.Expressions;

import java.util.ArrayList;
import java.util.List;

public class Variable implements Expression {
    protected final static List<String> variables = new ArrayList<>();

    private String nom;
    private double valeur;

    public Variable(String nom, double valeur) {
        if (variables.contains(nom)) {
            throw new RuntimeException("Variable déjà définie");
        }

        variables.add(nom);

        this.nom = nom;
        this.valeur = valeur;
    }

    public double evalue() {
        return this.valeur;
    }

    public void setValeur(double valeur) {
        if (!variables.contains(this.nom)) {
            throw new RuntimeException("Variable non définie");
        }

        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
