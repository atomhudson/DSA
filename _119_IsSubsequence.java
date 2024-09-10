import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _119_IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
    static boolean isSubsequence(String s, String t){
        if (s.isEmpty()) return true;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
