import java.util.Scanner;

public class _128_GrapeCity_Pattern3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
// Sample Input: 4
/*
Sample Output:

1
1 2
1 2 3
1 2 3 4

*/
