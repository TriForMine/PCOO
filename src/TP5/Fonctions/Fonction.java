package TP5.Fonctions;

import TP5.Expressions.Expression;
import TP5.Expressions.Operation;

public abstract class Fonction extends Operation {
    protected Expression op;

    protected Fonction(Expression op) {
        this.op = op;
    }

    protected abstract String symbole();

    @Override
    public String toString() {
        return String.format("%s(%s)", symbole(), op);
    }
}
