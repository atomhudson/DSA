package Algorithm_and_Practice;

import java.util.Scanner;

public class _135_GrapeCity_SortString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int val = ch - 'a';
            arr[val]++;
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a'+i);
            while (arr[i] > 0){
                arr[i]--;
                System.out.print(ch);
            }
        }

    }
}

//Sample Input: qazqazqazqazqaz
//Sample Output: aaaaaqqqqqzzzzz
