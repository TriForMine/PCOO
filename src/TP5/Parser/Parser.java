package TP5.Parser;

import TP5.Expressions.Constante;
import TP5.Expressions.Expression;
import TP5.Expressions.Variable;
import TP5.Fonctions.*;
import TP5.OperationBinaire.*;
import TP5.OperationUnaire.Factorielle;
import TP5.OperationUnaire.Negation;
import jline.console.ConsoleReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Parser {
    HashMap<String, Variable> variables = new HashMap<>();

    public static void main(String[] args) {
        // std in reader line by line and parse each line
        try (ConsoleReader console = new ConsoleReader()) {
            console.setHistoryEnabled(true);
            console.setPrompt("> ");

            Parser parser = new Parser();

            String line;
            while ((line = console.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                if (line.equalsIgnoreCase("clear")) {
                    console.clearScreen();
                    continue;
                }

                try {
                    Expression expression = parser.parse(line);

                    console.println(expression.toString());

                    console.println(String.valueOf(expression.evalue()));
                } catch (IllegalArgumentException e) {
                    console.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Pair<Expression, Expression> popTwoExpressions(List<Expression> expressions) {
        Expression right = expressions.removeLast();
        Expression left = expressions.removeLast();
        return new Pair<>(left, right);
    }

    public Expression parse(String expression) {
        int i = 0;

        String[] tokens = ShuntingYard.parse(ShuntingYard.prepareInput(expression));
        List<Expression> expressions = new ArrayList<>();

        while (i < tokens.length) {
            String token = tokens[i];

            switch (token) {
                case "+" -> {
                    var expressionsPair = popTwoExpressions(expressions);
                    expressions.add(new Addition(expressionsPair.getLeft(), expressionsPair.getRight()));
                }
                case "-" -> {
                    var expressionsPair = popTwoExpressions(expressions);
                    expressions.add(new Soustraction(expressionsPair.getLeft(), expressionsPair.getRight()));
                }
                case "*" -> {
                    var expressionsPair = popTwoExpressions(expressions);
                    expressions.add(new Multiplication(expressionsPair.getLeft(), expressionsPair.getRight()));
                }
                case "/" -> {
                    var expressionsPair = popTwoExpressions(expressions);
                    expressions.add(new Division(expressionsPair.getLeft(), expressionsPair.getRight()));
                }
                case "%" -> {
                    var expressionsPair = popTwoExpressions(expressions);
                    expressions.add(new Modulo(expressionsPair.getLeft(), expressionsPair.getRight()));
                }
                case "^" -> {
                    var expressionsPair = popTwoExpressions(expressions);
                    expressions.add(new Puissance(expressionsPair.getLeft(), expressionsPair.getRight()));
                }
                case "neg" -> expressions.add(new Negation(expressions.removeLast()));
                case "=" -> {
                    String variableName = tokens[0];
                    double variableValue = expressions.removeLast().evalue();

                    if (variables.containsKey(variableName)) {
                        variables.get(variableName).setValeur(variableValue);
                    } else {
                        variables.put(variableName, new Variable(variableName, variableValue));
                    }

                    expressions.add(variables.get(variableName));
                }
                case "cos" -> expressions.add(new Cosinus(expressions.removeLast()));
                case "sin" -> expressions.add(new Sinus(expressions.removeLast()));
                case "tan" -> expressions.add(new Tangente(expressions.removeLast()));
                case "log" -> expressions.add(new Logarithme(expressions.removeLast()));
                case "exp" -> expressions.add(new Exponentielle(expressions.removeLast()));
                case "sqrt" -> expressions.add(new RacineCarree(expressions.removeLast()));
                case "abs" -> expressions.add(new ValeurAbsolue(expressions.removeLast()));
                case "!" -> expressions.add(new Factorielle(expressions.removeLast()));
                case "pi" -> expressions.add(new Constante(Math.PI));
                case "e" -> expressions.add(new Constante(Math.E));
                default -> {
                    try {
                        expressions.add(new Constante(Double.parseDouble(token)));
                    } catch (NumberFormatException e) {
                        if (variables.containsKey(token)) {
                            expressions.add(variables.get(token));
                        } else {
                            if (!tokens[tokens.length - 1].equals("=")) {
                                throw new IllegalArgumentException("La variable " + token + " n'a pas été définie");
                            }
                        }
                    }
                }
            }

            i++;
        }

        return expressions.getFirst();
    }

    private class Pair<T, T1> {
        private T left;
        private T1 right;

        public Pair(T left, T1 right) {
            this.left = left;
            this.right = right;
        }

        public T getLeft() {
            return left;
        }

        public T1 getRight() {
            return right;
        }
    }
}
