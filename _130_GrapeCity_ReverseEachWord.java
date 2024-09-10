import java.util.Scanner;

public class _130_GrapeCity_ReverseEachWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(" ");
        String ans = "";
        for (String temp : strings) {
            String ansstr = "";
            for (int j = temp.length() - 1; j >= 0; j--) {
                ansstr += temp.charAt(j);
            }
            ans += ansstr + " ";
        }
        System.out.println(ans);
    }
}

//Sample Input: Good morning
//Sample Output: dooG gninrom