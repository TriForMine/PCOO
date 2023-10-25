package TP5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public final class Parser {
    HashMap<String, Variable> variables = new HashMap<>();

    public static void main(String[] args) {
        // std in reader line by line and parse each line
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();

        System.out.print("> ");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                break;
            }

            Expression expression = parser.parse(line);

            System.out.println(expression);

            if (expression != null) {
                System.out.println(expression.evalue());
            }

            System.out.print("> ");
        }
    }

    public Expression parse(String expression) {
        int i = 0;

        String[] tokens = ShuntingYard.parse(expression.split(" "));
        List<Expression> expressions = new ArrayList<>();

        // First pass: parse all tokens into expressions, constants, and variables
        // Leave operators as strings

        while (i < tokens.length) {
            String token = tokens[i];

            if (token.equals("+")) {
                expressions.add(new Addition(expressions.removeLast(), expressions.removeLast()));
            } else if (token.equals("-")) {
                expressions.add(new Soustraction(expressions.removeLast(), expressions.removeLast()));
            } else if (token.equals("*")) {
                expressions.add(new Multiplication(expressions.removeLast(), expressions.removeLast()));
            } else if (token.equals("/")) {
                expressions.add(new Division(expressions.removeLast(), expressions.removeLast()));
            } else if (token.equals("%")) {
                expressions.add(new Modulo(expressions.removeLast(), expressions.removeLast()));
            } else if (token.equals("neg")) {
                expressions.add(new Negation(expressions.removeLast()));
            } else if (token.equals("=")) {
                String variableName = tokens[i - 2];
                double variableValue = Double.parseDouble(tokens[i - 1]);

                if (variables.containsKey(variableName)) {
                    variables.get(variableName).setValeur(variableValue);
                } else {
                    variables.put(variableName, new Variable(variableName, variableValue));
                }
            } else {
                try {
                    expressions.add(new Constante(Double.parseDouble(token)));
                } catch (NumberFormatException e) {
                    if (variables.containsKey(token)) {
                        expressions.add(variables.get(token));
                    } else {
                        if (i + 1 < tokens.length && !tokens[i + 2].equals("=")) {
                            throw new IllegalArgumentException("La variable " + token + " n'a pas été définie");
                        }
                    }
                }
            }

            i++;
        }

        return expressions.get(0);
    }
}
