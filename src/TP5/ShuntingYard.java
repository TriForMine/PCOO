package TP5;

import java.util.*;

public class ShuntingYard {
    private static final Map<String, Integer> PRECEDENCE = new HashMap<>();

    static {
        PRECEDENCE.put("+", 1);
        PRECEDENCE.put("-", 1);
        PRECEDENCE.put("*", 2);
        PRECEDENCE.put("/", 2);
        PRECEDENCE.put("%", 2);
        PRECEDENCE.put("neg", 3); // unary negation
        PRECEDENCE.put("=", 0);
    }

    private static boolean isHigherPrecedence(String op, String sub) {
        return (PRECEDENCE.containsKey(sub)
                && PRECEDENCE.get(op) <= PRECEDENCE.get(sub));
    }

    public static String[] parse(String[] inputTokens) {
        List<String> out = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : inputTokens) {
            if (PRECEDENCE.containsKey(token)) {
                while (!stack.empty() && isHigherPrecedence(token, stack.peek())) {
                    out.add(stack.pop());
                }
                stack.push(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    out.add(stack.pop());
                }
                stack.pop();
            } else {
                out.add(token);
            }
        }
        while (!stack.empty()) {
            out.add(stack.pop());
        }
        return out.toArray(new String[out.size()]);
    }

    public static void main(String[] args) {
        String[] input = "3 + 4 * 2 - ( 1 - 5 )".split(" ");
        String[] output = parse(input);

        System.out.println(Arrays.toString(output));
    }
}