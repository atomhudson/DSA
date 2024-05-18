import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _56_Reverse_Words_in_a_String_III {
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] sstring = s.split(" ");
        for (String as:sstring){
            StringBuilder word = new StringBuilder(as);
            result.append(word.reverse()+" ");
        }
        return result.toString().substring(0,result.length()-1);
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));

    }
}
