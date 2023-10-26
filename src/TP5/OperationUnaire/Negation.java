package TP5.OperationUnaire;

import TP5.Expressions.Expression;

public class Negation extends OperationUnaire {
    public Negation(Expression op) {
        super(op);
    }

    @Override
    protected String symbole() {
        return "-";
    }

    @Override
    public double evalue() {
        return this.op.evalue() * -1;
    }

    @Override
    public String toString() {
        return this.symbole() + this.parenthesage(this.op);
    }
}
