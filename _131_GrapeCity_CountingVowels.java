import java.util.HashSet;
import java.util.Scanner;
public class _131_GrapeCity_CountingVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        // Iterate through the string and count vowels
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowels.contains(ch)) {
                count++;
            }
        }
        System.out.println(count);
    }
}

//Sample Input: Good Morinh
//Sample Output: 4
