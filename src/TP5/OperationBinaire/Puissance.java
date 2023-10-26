package TP5.OperationBinaire;

import TP5.Expressions.Expression;

public class Puissance extends OperationBinaire {
    public Puissance(Expression op1, Expression op2) {
        super(op1, op2);
    }

    @Override
    protected String symbole() {
        return "^";
    }

    @Override
    public double evalue() {
        return Math.pow(this.op1.evalue(), this.op2.evalue());
    }
}
