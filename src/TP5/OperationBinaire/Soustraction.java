package TP5.OperationBinaire;

import TP5.Expressions.Expression;

public class Soustraction extends OperationBinaire {
    public Soustraction(Expression op1, Expression op2) {
        super(op1, op2);
    }

    @Override
    protected String symbole() {
        return "-";
    }

    @Override
    public double evalue() {
        return this.op1.evalue() - this.op2.evalue();
    }
}
