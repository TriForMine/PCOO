package TP5;

public abstract class OperationUnaire extends Operation {
    protected Expression op;

    protected OperationUnaire(Expression op) {
        this.op = op;
    }

    protected abstract String symbole();

    @Override
    public String toString() {
        String val1 = op.toString();

        if (op instanceof OperationBinaire) {
            val1 = "(" + op + ")";
        }

        return this.symbole() + " " + val1;
    }
}
