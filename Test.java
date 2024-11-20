import java.util.*;

public class Test {
    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for(char ch: S.toCharArray()){
            if(ch == '{'){
                stack.push('}');
            }else if(ch == '['){
                stack.push(']');
            }else if(ch == '('){
                stack.push(')');
            }else if(stack.isEmpty() || stack.peek() == ch){
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));
    }
}
