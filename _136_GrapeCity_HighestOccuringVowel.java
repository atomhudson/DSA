import java.util.HashMap;
import java.util.Scanner;
public class _136_GrapeCity_HighestOccuringVowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> vowel = new HashMap<>();
        vowel.put('a',0);
        vowel.put('e',0);
        vowel.put('i',0);
        vowel.put('o',0);
        vowel.put('u',0);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowel.containsKey(ch)){
                vowel.put(ch, vowel.get(ch) + 1);
            }
        }
        char highestOccurring = ' ';
        int maxcount = 0;
        for (char key : vowel.keySet()){
            if (vowel.get(key) > maxcount){
                maxcount = vowel.get(key);
                highestOccurring = key;
            }
        }
        System.out.println(highestOccurring);
    }
}

//Sample Input: hello good morning
//Sample Output: o