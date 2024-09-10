import java.util.HashSet;
import java.util.Scanner;

public class _133_GrapeCity_RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        HashSet<Character> hashSet = new HashSet<>();
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hashSet.contains(ch)){
                continue;
            }
            else {
                ans += ch;
                hashSet.add(ch);
            }
        }
        System.out.println(ans);
    }
}
