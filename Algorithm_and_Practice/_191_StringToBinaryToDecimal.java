package Algorithm_and_Practice;/*
example:
    zoo
    'z' is a constant so it is represented by 1.
    'o' is a vowel so it is represented by 0.
    'o' is a vowel so it is represented by 0.
    So binary is formed is 100.
    Now convert in into decimal 4.
    4 is our output
 */

import java.util.ArrayList;
import java.util.List;

class StringToBinaryToDecimal{
    int conversion(String str){
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        String binary = "";
        for (char a: str.toCharArray()){
            if (vowels.contains(a)){
                binary = binary.concat("0");
            }else {
                binary = binary.concat("1");
            }
        }
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            int b = (int)Math.pow(2,i);
            int digit = Character.getNumericValue(binary.charAt((binary.length()-1)-i));
            decimal += b * digit;
        }
        return decimal;
    }
}
public class _191_StringToBinaryToDecimal {
    public static void main(String[] args) {
        StringToBinaryToDecimal str = new StringToBinaryToDecimal();
//        str.conversion("zoo");
        System.out.println(str.conversion("zoo"));
    }
}
