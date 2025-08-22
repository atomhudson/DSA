package Algorithm_and_Practice;

import java.util.Scanner;

public class _126_GrapeCity_Pattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        for (int i = 1; i <= N; i++) {
            int temp = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(temp++ + " ");
            }
            temp -= 2;
            for (int j = 1; j < i ; j++) {
                System.out.print(temp-- + " " );
            }
            System.out.println();
        }
    }
}


// Sample Input: 4
/*
Sample Output:
1
2 3 2
3 4 5 4 3
4 5 6 7 6 5 4
*/
