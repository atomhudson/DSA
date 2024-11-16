import java.util.Arrays;
import java.util.Scanner;

public class _185_CopyCatInExam_HasedIn {
    static class Solution{
        int CheckPassword(String str1,String str2){
            str1 = str1.toUpperCase();
            str2 = str2.toUpperCase();
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            String a = new String(chars1);
            String b = new String(chars2);
            return a.equals(b) ? 1 : 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str2 = sc.next();
        Solution s = new Solution();
        System.out.println(s.CheckPassword(str,str2));
    }
}
