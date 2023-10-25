package TP5;

public abstract class OperationBinaire extends Operation {
    protected Expression op1;
    protected Expression op2;

    protected OperationBinaire(Expression op1, Expression op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    protected abstract String symbole();

    @Override
    public String toString() {
        return this.parenthesage(this.op1) + " " + this.symbole() + " " + this.parenthesage(this.op2);
    }
}
