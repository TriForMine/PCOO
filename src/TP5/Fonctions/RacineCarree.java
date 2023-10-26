package TP5.Fonctions;

import TP5.Expressions.Expression;

public class RacineCarree extends Fonction {
    public RacineCarree(Expression op) {
        super(op);
    }

    @Override
    public double evalue() {
        return Math.sqrt(this.op.evalue());
    }

    @Override
    protected String symbole() {
        return "sqrt";
    }
}
