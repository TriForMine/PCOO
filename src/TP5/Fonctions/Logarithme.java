package TP5.Fonctions;

import TP5.Expressions.Expression;

public class Logarithme extends Fonction {
    public Logarithme(Expression op) {
        super(op);
    }

    @Override
    public double evalue() {
        return Math.log(op.evalue());
    }

    @Override
    protected String symbole() {
        return "log";
    }
}
