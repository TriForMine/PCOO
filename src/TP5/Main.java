package TP5;

public class Main {
    public static void main(String[] args) {
        Variable variable1 = new Variable("v1", 42.0);
        Variable variable2 = new Variable("v2", 1.0);

        Expression expression = new Addition(new Addition(
                new Division(
                        new Constante(5.0),
                        variable1
                ),
                variable2
        ), new Division(
                new Multiplication(
                        new Addition(
                                new Constante(2.0),
                                new Constante(2.0)
                        ),
                        new Negation(
                                new Modulo(
                                        new Constante(7.0),
                                        new Constante(4.0)
                                )
                        )
                ),
                new Negation(new Constante(2.0))
        ));

        System.out.println(expression);
        System.out.println(expression.evalue());

        System.out.println();

        Expression expression2 = new Addition(
                new Division(
                        new Constante(2.0),
                        variable1
                ),
                new Constante(1.0));

        System.out.println(expression2);
        System.out.println(expression2.evalue());
    }
}
