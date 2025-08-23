package Data_Structures;

import java.util.Stack;

/**
 * Demonstrates operations applied on the top two values of a stack
 * while evaluating a postfix expression.
 * Example 1: Expression = 10, 5, +, 8, *
 * <p>
 * Symbol     | Stack        | Operation
 * ---------------------------------------
 *   10       | 10           |
 *    5       | 10, 5        |
 *    +       | 15           | 10 + 5
 *    8       | 15, 8        |
 *    *       | 120          | 15 * 8
 * Example 2: Expression = 4, 10, 5, +, *, 15, 3, /, -
 * Symbol     | Stack        | Operation
 * ---------------------------------------
 *    4       | 4            |
 *   10       | 4, 10        |
 *    5       | 4, 10, 5     |
 *    +       | 4, 15        | 10 + 5
 *    *       | 60           | 4 * 15
 *   15       | 60, 15       |
 *    3       | 60, 15, 3    |
 *    /       | 60, 5        | 15 / 3
 *    -       | 55           | 60 - 5
 */

public class _010_Evaluation_Of_PostFix_Expression {
    static class Solution{
        public int evaluation(String str){
            Stack<Integer> number = new Stack<>();
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == ',' || str.charAt(i) == ' ') continue;
                if (Character.isDigit(str.charAt(i))){
                    int num = 0;
                    while(str.charAt(i) != ',' && str.charAt(i) != ' '){
                        num = num * 10 + (str.charAt(i) - '0');
                        i++;
                    }
                    number.push(num);
                    i--;
                }
                else {
                    int value1 = number.pop();
                    int value2 = number.pop();
                    number.push(applyOperations(value1, value2, str.charAt(i)));
                }
            }
            return number.peek();
        }
        private int applyOperations(int value1, int value2, char ch){
            return switch (ch){
                case '+' -> value2 + value1;
                case '-' -> value2 - value1;
                case '*' -> value2 * value1;
                case '/' -> value2 / value1;
                default -> 0;
            };
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.evaluation("4, 10, 5, +, *, 15, 3, /, -"));

    }
}