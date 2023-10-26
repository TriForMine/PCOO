package TP5.Fonctions;

import TP5.Expressions.Expression;

public class Cosinus extends Fonction {
    public Cosinus(Expression op) {
        super(op);
    }

    @Override
    public double evalue() {
        return Math.cos(op.evalue());
    }

    @Override
    protected String symbole() {
        return "cos";
    }
}
