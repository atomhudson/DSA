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
 * Stepwise conversion to Postfix:
 * -------------------------------------------------
 * Symbol  |   Stack       | Expression
 * --------------------------------------
 * (       | (             |
 * a       | (             | a
 * +       | (+            | a
 * (       | (+(           | a
 * b       | (+(           | ab
 * +       | (+(+          | ab
 * c       | (+(+          | abc
 * *       | (+(+*         | abc
 * (       | (+(+*(        | abc
 * d       | (+(+*(        | abcd
 * +       | (+(+*(+       | abcd
 * e       | (+(+*(+       | abcde
 * )       | (+(+*         | abcde+     <-- POP
 * )       | (+            | abcde+*+   <-- POP
 * +       | (+            | abcde+*++  <-- POP
 * f       | (+            | abcde+*++f
 * /       | (+/           | abcde+*++f
 * g       | (+/           | abcde+*++fg
 * )       |               | abcde+*++fg/+
 *
 * Final Postfix: abcde+*++fg/
 */

public class _008_InfixToPostfix {

    private static int precedence(char ch){
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    private static boolean isOperand(char ch){
        return Character.isLetterOrDigit(ch);
    }

    public static String infixToPostfix(String expression){
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isOperand(ch)){
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '('){
                    result.append(stack.pop());
                }
                stack.pop();
            }else{
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) result.append(stack.pop());
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String expression = "a+(b+c*(d+e))+f/g";
        String postfix = infixToPostfix(expression);
        System.out.println("Infix: " + expression);
        System.out.println("Postfix: " + postfix);
    }
}
