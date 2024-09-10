import java.util.Scanner;

public class _132_GrapeCity_KthLastElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int K = sc.nextInt();
//        Printing Kth last element
        for (int i = N-K; i < N  ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
/*
Sample Input:

N= 5
arr[]= {1 2 3 4 5}
K = 2

*/

//Sample Output: 4 5