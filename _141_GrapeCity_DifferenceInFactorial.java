import java.util.Scanner;

public class _141_GrapeCity_DifferenceInFactorial {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(factorial(a)-factorial(b));
    }
    static int factorial(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}
//Sample Input:
// a = 5
// b = 3
//Sample Output: 114