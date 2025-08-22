package Algorithm_and_Practice;

import java.util.Scanner;

public class _129_GrapeCity_Pattern4 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            int temp = 2;
            for (int j = 1; j < i; j++) {
                System.out.print(temp+ " ");
                temp += 2;
            }
            for (int j = 1; j <= i ; j++) {
                System.out.print(temp+ " ");
                temp -= 2;
            }
            System.out.println();
        }
    }
}

//Sample Input: 3
/*
Sample Output:
2
2 4 2
2 4 6 4 2
*/
