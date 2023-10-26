package TP5.Fonctions;

import TP5.Expressions.Expression;

public class Exponentielle extends Fonction {
    public Exponentielle(Expression op) {
        super(op);
    }

    @Override
    public double evalue() {
        return Math.exp(op.evalue());
    }

    @Override
    protected String symbole() {
        return "exp";
    }
}
