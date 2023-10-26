package TP5.Fonctions;

import TP5.Expressions.Expression;

public class Sinus extends Fonction {
    public Sinus(Expression op) {
        super(op);
    }

    @Override
    public double evalue() {
        return Math.sin(op.evalue());
    }

    @Override
    protected String symbole() {
        return "sin";
    }
}
