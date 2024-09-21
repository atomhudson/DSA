import java.util.ArrayList;
import java.util.List;

public class _166_DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String s = "2*3-4*5";
        System.out.println(differentWaysToCompute(s));
    }
    static List<Integer> differentWaysToCompute(String expression){
        return solve(expression);
    }
    static List<Integer> solve(String s){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' ||
                s.charAt(i) == '-' ||
                s.charAt(i) == '*')
            {
                List<Integer> left_result = solve(s.substring(0,i));
                List<Integer> right_result = solve(s.substring(i+1));
                for(int x : left_result){
                    for (int y : right_result){
                        if (s.charAt(i) == '+'){
                            list.add(x+y);
                        } else if (s.charAt(i) == '-') {
                            list.add(x-y);
                        } else {
                            list.add(x*y);
                        }
                    }
                }
            }
        }
        if (list.isEmpty()){
            list.add(Integer.valueOf(s));
        }
        return list;
    }
}
