import java.util.Scanner;

public class _127_GrapeCity_Pattern2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            int temp = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(temp++ + " ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(temp-- + " ");
            }
            System.out.println();
        }
    }
}

// Sample Input: 4

/* Sample Output:
1
1 2 1
1 2 3 2 1
1 2 3 4 3 2 1
1 2 3 4 5 4 3 2 1 */
