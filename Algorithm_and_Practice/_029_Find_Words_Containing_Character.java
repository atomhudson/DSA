package Algorithm_and_Practice;

import java.util.ArrayList;
import java.util.List;

public class _029_Find_Words_Containing_Character {
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> arr = new ArrayList<Integer>();
        String a = String.valueOf(x);
        for (int i = 0; i < words.length; i++) {
            if(words[i].contains(a)){
                arr.add(i);
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        String[] word = {"abc","bcd","aaaa","cbc"};
        char x = 'z';
        System.out.println(findWordsContaining(word,x));
    }
}
