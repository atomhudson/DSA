import java.util.Scanner;

public class _143_GrapeCity_LengthOfLongestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int maxLen = 1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = str.length()-1; j >= i ; j--) {
                if (isPalindrome(str,i,j)){
                    maxLen = Math.max(maxLen, j-i+1 );
                }
            }
        }
        System.out.println(maxLen);
    }
    static boolean isPalindrome(String str, int start, int end){
        while (start < end){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
