import java.util.ArrayList;
import java.util.List;

public class _167_SmallestPalindrome {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("abacd"));
    }

//    Simple Approach
    public static String shortestPalindrome(String s){
        StringBuilder str = new StringBuilder(s);
        StringBuilder reverse = str.reverse();
        List<Character> characterArrayList = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            String first = s.substring(0,n-i);
            String second = reverse.substring(i);
            if (first.equals(second)) {
                break;
            }
            characterArrayList.add(s.charAt(n - i - 1));
        }
        StringBuilder result = new StringBuilder();
        for (char ch : characterArrayList){
            result.append(ch);
        }
        return result.append(s).toString();
    }

}


