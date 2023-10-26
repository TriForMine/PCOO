package TP5.Expressions;

import TP5.OperationBinaire.*;
import TP5.OperationUnaire.Negation;

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
