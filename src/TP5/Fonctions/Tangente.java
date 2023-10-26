package TP5.Fonctions;

import TP5.Expressions.Expression;

public class Tangente extends Fonction {
    public Tangente(Expression op) {
        super(op);
    }

    @Override
    public double evalue() {
        return Math.tan(op.evalue());
    }

    @Override
    protected String symbole() {
        return "tan";
    }
}
