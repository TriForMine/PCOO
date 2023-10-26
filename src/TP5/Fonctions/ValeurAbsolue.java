package TP5.Fonctions;

import TP5.Expressions.Expression;

public class ValeurAbsolue extends Fonction {
    public ValeurAbsolue(Expression op) {
        super(op);
    }

    @Override
    public double evalue() {
        return Math.abs(this.op.evalue());
    }

    @Override
    protected String symbole() {
        return "abs";
    }
}
