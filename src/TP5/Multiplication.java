package TP5;

public class Multiplication extends OperationBinaire {
    public Multiplication(Expression op1, Expression op2) {
        super(op1, op2);
    }

    @Override
    protected String symbole() {
        return "*";
    }

    @Override
    public double evalue() {
        return this.op1.evalue() * this.op2.evalue();
    }
}
