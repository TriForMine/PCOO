package TP5.OperationBinaire;

import TP5.Expressions.Expression;

public class Division extends OperationBinaire {
    public Division(Expression op1, Expression op2) {
        super(op1, op2);
    }

    @Override
    protected String symbole() {
        return "/";
    }

    @Override
    public double evalue() {
        double val2 = this.op2.evalue();

        if (val2 == 0) {
            throw new ArithmeticException("Division par zéro");
        }

        return this.op1.evalue() / val2;
    }
}
