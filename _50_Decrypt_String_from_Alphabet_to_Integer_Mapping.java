import java.util.ArrayList;
import java.util.Arrays;

public class _50_Decrypt_String_from_Alphabet_to_Integer_Mapping {
    public static String freqAlphabets(String s) {
        StringBuilder string = new StringBuilder();
        for (int i = s.length()-1;i>=0;i--){
            int number;
            if (s.charAt(i) == '#'){
                number = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
                i = i -2;
            }else {
                number = s.charAt(i) - '0';
            }
            string.append((char) (number+96));
        }
        return string.reverse().toString();
    }
    public static void main(String[] args) {
        String s = "10#11#12";
        System.out.println(freqAlphabets(s));
        int  a = '1' - '0';
        System.out.println((char) (a+96));

    }
}
