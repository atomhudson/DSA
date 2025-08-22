package Algorithm_and_Practice;

import java.util.Scanner;

public class _137_GrapeCity_Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(factorial(N));
        int result = 1;
        for (int i = N; i >= 1; i--) {
            result *= i;
        }
        System.out.println(result);
    }
    static int factorial(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
}

// Sample Input: 3
// Sample Output1: 6
// Sample Output2: 6