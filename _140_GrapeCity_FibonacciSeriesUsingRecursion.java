import java.util.Scanner;

public class _140_GrapeCity_FibonacciSeriesUsingRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            System.out.print(FibonacciSeries(i)+" ");
        }

    }
    static int FibonacciSeries(int n){
        if (n < 2){
            return n;
        }
        return FibonacciSeries(n-1) + FibonacciSeries(n-2);
    }
}
//Sample Input: 7
//Sample Output: 1 1 2 3 5 8 13