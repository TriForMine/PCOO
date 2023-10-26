package TP5.Expressions;

public class Constante implements Expression {
    private double valeur;

    public Constante(double valeur) {
        this.valeur = valeur;
    }

    public double evalue() {
        return this.valeur;
    }

    @Override
    public String toString() {
        return String.valueOf(this.valeur);
    }
}
