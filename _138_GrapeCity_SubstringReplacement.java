import java.util.Scanner;

public class _138_GrapeCity_SubstringReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = sc.nextLine();
        String replacement = sc.nextLine();
        String ans = str.replace(target,replacement);
        System.out.println(ans);
    }
}
//Sample Input:
//str = "Hello, this is an example Statement. this is a test Statement."
//target = "is"
//replacement = "at"
//Sample output = "Hello, that at an example Statement. that at a test Statement."
