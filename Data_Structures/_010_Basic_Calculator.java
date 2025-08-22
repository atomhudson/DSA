package Data_Structures;

import java.util.Stack;

public class _010_Basic_Calculator {
    private static int precedence(char ch){
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static int calculate(String expression){
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ' ') continue;

            else if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                operands.push(num);
                i--;
            }
            else if (ch == '(') {
                operator.push(ch);
            }
            else if (ch == ')') {
                while(!operator.isEmpty() && operator.peek() != '(') {
                    int b = operands.pop();
                    int a = operands.pop();
                    char op = operator.pop();
                    operands.push(applyOperations(a, b, op));
                }
                operator.pop();
            }
            else {
                int j = i - 1;
                while (j >= 0 && expression.charAt(j) == ' ') j--;
                if (ch == '-' && (j < 0 || expression.charAt(j) == '(' ||
                        expression.charAt(j) == '+' ||
                        expression.charAt(j) == '-' ||
                        expression.charAt(j) == '*' ||
                        expression.charAt(j) == '/')) {
                    operands.push(0);
                }

                while (!operator.isEmpty() && precedence(operator.peek()) >= precedence(ch)) {
                    int b = operands.pop();
                    int a = operands.pop();
                    char op = operator.pop();
                    operands.push(applyOperations(a, b, op));
                }
                operator.push(ch);
            }
        }

        while (!operator.isEmpty()) {
            int b = operands.pop();
            int a = operands.pop();
            char op = operator.pop();
            operands.push(applyOperations(a, b, op));
        }
        return operands.pop();
    }

    private static int applyOperations(int a,int b,char ch){
        return switch (ch){
            case '+' -> a+b;
            case '-' -> a-b;
            case '*' -> a*b;
            case '/' -> a/b;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        String s = "1-(     -2)";
        System.out.println(calculate(s));
    }
}
