package TP5.Parser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShuntingYard {
    static final Set<String> OPERATORS = new HashSet<>(
            Arrays.asList("+", "-", "*", "^", "/", "%", "neg", "=", "sin", "cos", "tan", "log", "exp", "sqrt", "abs", "!"));
    static final Set<String> FUNCTIONS = new HashSet<>(
            Arrays.asList("sin", "cos", "tan", "log", "exp", "sqrt", "abs"));
    static final Map<String, Integer> PRECEDENCE = new HashMap<>();

    static {
        PRECEDENCE.put("+", 1);
        PRECEDENCE.put("-", 1);
        PRECEDENCE.put("*", 2);
        PRECEDENCE.put("^", 3);
        PRECEDENCE.put("/", 2);
        PRECEDENCE.put("%", 2);
        PRECEDENCE.put("neg", 3); // unary negation
        PRECEDENCE.put("=", 0);
        PRECEDENCE.put("sin", 4);
        PRECEDENCE.put("cos", 4);
        PRECEDENCE.put("tan", 4);
        PRECEDENCE.put("log", 4);
        PRECEDENCE.put("exp", 4);
        PRECEDENCE.put("sqrt", 4);
        PRECEDENCE.put("abs", 4);
        PRECEDENCE.put("!", 5);
    }

    private static boolean isHigherPrecedence(String op, String sub) {
        return (PRECEDENCE.containsKey(sub)
                && PRECEDENCE.get(op) <= PRECEDENCE.get(sub));
    }

    public static String[] parse(String[] inputTokens) {
        List<String> outputTokens = new ArrayList<>();
        Deque<String> stack = new LinkedList<>();
        for (String token : inputTokens) {
            if (OPERATORS.contains(token)) {
                while (!stack.isEmpty() && isHigherPrecedence(token, stack.peek())) {
                    addTokenToOutput(stack, outputTokens);
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (true) {
                    assert stack.peek() != null;
                    if (stack.peek().equals("(")) break;
                    addTokenToOutput(stack, outputTokens);
                }
                stack.pop();
                if (!stack.isEmpty() && FUNCTIONS.contains(stack.peek())) {
                    addTokenToOutput(stack, outputTokens);
                }
            } else {
                outputTokens.add(token);
            }
        }
        while (!stack.isEmpty()) {
            addTokenToOutput(stack, outputTokens);
        }
        return outputTokens.toArray(new String[0]);
    }

    private static void addTokenToOutput(Deque<String> stack, List<String> outputTokens) {
        outputTokens.add(stack.pop());
    }

    public static String[] prepareInput(String input) {
        String tempInput = input
                .replaceAll("\\s+", "")
                .replaceAll("\\b-\\b(?=\\d)", "- ") // replace binary - with sub
                .replaceAll("(?<=\\d)-(?!\\d)", "- ")
                .replaceAll("-(?=\\d|\\()", "neg ");
        Matcher m = Pattern.compile("(\\b\\w+\\b|[-+*=/^%()]|neg|sub)").matcher(tempInput);
        List<String> tokens = new ArrayList<>();
        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] input = prepareInput("3 + 4 * 2 - ( 1 - 5 )");
        String[] output = parse(input);
        System.out.println(Arrays.toString(output));
        input = prepareInput("cos(2 + 2)");
        output = parse(input);
        System.out.println(Arrays.toString(output)); // should print "[2, 2, +, cos]"
    }
}