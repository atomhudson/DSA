import java.util.ArrayList;
import java.util.Stack;

public class _064_Valid_Paranthesis {
    public static boolean valid(String x){
        Stack<Character> stack = new Stack<>();
        for (char c: x.toCharArray()){
            if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (c == '(') stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(valid("[][][][]"));
    }
}
