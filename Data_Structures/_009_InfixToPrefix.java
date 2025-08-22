package Data_Structures;

import java.util.Stack;

/**
 * Infix -> Prefix | Postfix
 * -------------------------------------------------
 * Infix:   a + b        (normal mathematical expression)
 * Prefix:  + a b        (Polish notation)
 * Postfix: a b +        (Reverse Polish notation)
 *
 * Example expression:
 *     ( a + ( b + c * (d + e)) + f / g )
 *
 * Stepwise conversion to Prefix:
 * -------------------------------------------------
 * Symbol  |   Stack       | Expression
 * --------------------------------------
 * (       | (             |
 * a       | (             | a
 * +       | (+            | + a
 * (       | (+(           | + a
 * b       | (+(           | + a b
 * +       | (+(+          | + a + b
 * c       | (+(+          | + a + b c
 * *       | (+(+*         | + a + b * c
 * (       | (+(+*(        | + a + b * (
 * d       | (+(+*(        | + a + b * d
 * +       | (+(+*(+       | + a + b * + d
 * e       | (+(+*(+       | + a + b * + d e
 * )       | (+(+*         | + a + b * + d e
 * )       | (+            | + a + b * + d e
 * +       | (+            | + a + b * + d e +
 * f       | (+            | + a + b * + d e + f
 * /       | (+/           | + a + b * + d e + / f
 * g       | (+/           | + a + b * + d e + / f g
 * )       |               | + a + b * + d e + / f g
 *
 * Final Prefix: + + a + b * c + d e / f g
 */

public class _009_InfixToPrefix {

    // Precedence order for operators
    private static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    // Check if character is an operand (letter or digit)
    private static boolean isOperand(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    // Convert an infix expression to prefix
    public static String infixToPrefix(String expression) {
        StringBuilder result = new StringBuilder();
        StringBuilder mainExpression = new StringBuilder(expression);

        mainExpression.reverse();
        System.out.println("Before Swap: "+mainExpression);

        // Step 2: Swap '(' with ')' and vice versa
        for (int i = 0; i < mainExpression.length(); i++) {
            if (mainExpression.charAt(i) == '(') {
                mainExpression.setCharAt(i, ')');
            } else if (mainExpression.charAt(i) == ')') {
                mainExpression.setCharAt(i, '(');
            }
        }

        System.out.println("After Swap: "+mainExpression);

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < mainExpression.length(); i++) {
            char ch = mainExpression.charAt(i);

            if (isOperand(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() &&
                        (precedence(stack.peek()) > precedence(ch) ||
                                (precedence(stack.peek()) == precedence(ch) && ch != '^'))) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String expression = "(a+(b+c*(d+e))+f/g)";
        String prefix = infixToPrefix(expression);
        System.out.println("Infix:  " + expression);
        System.out.println("Prefix: " + prefix);
    }
}
