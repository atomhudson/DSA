package Algorithm_and_Practice;

import java.util.Stack;

public class _065_Consecutive_Characters {

    public static int maxPower(String s){
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        int max = 1;
        int count = 1;

        // Push the first character onto the stack
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == current) {
                count++;
            } else {
                stack.push(current);
                count = 1;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(maxPower("abbcccddddeeeeedcba"));
    }
}
