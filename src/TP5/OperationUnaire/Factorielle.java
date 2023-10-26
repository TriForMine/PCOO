package TP5.OperationUnaire;

import TP5.Expressions.Expression;

public class Factorielle extends OperationUnaire {
    public Factorielle(Expression op) {
        super(op);
    }

    @Override
    protected String symbole() {
        return "!";
    }

    private double recfact(long start, long n) {
        long i;
        if (n <= 16) {
            double r = start;
            for (i = start + 1; i < start + n; i++) r *= i;
            return r;
        }
        i = n / 2;
        return recfact(start, i) * recfact(start + i, n - i);
    }

    private double factorial(long n) {
        return recfact(1, n);
    }


    @Override
    public String toString() {
        return this.parenthesage(this.op) + this.symbole();
    }

    @Override
    public double evalue() {
        return factorial((long) this.op.evalue());
    }
}
