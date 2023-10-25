package TP5;

public abstract class Operation implements Expression {
    protected String parenthesage(Expression op) {
        if ((this instanceof Multiplication || this instanceof Division) && (op instanceof Addition || op instanceof Soustraction || op instanceof Negation)) {
            return "(" + op + ")";
        }

        if (this instanceof Negation && op instanceof OperationBinaire) {
            return "(" + op + ")";
        }

        return op.toString();
    }
}
