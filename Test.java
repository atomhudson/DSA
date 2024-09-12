import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
        int n = s.length-1;
        for(int i = 0; i <= n / 2;i++){
            char ch = s[i];
            s[i] = s[n-i];
            s[n-i] = ch;
        }
    }
}
