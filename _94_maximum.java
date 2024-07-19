import java.util.Scanner;

public class _94_maximum {
    public int maximum(int x, int n, int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - x; i++) {
            min = Integer.MAX_VALUE;
            for (int j = i; j < i+x; j++) {
                min = Math.min(min,arr[j]);
                max = Math.max(min,max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Segment Size: ");
        int x = sc.nextInt();
        System.out.print("Enter the Size of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the "+i+"th number: ");
            arr[i] = sc.nextInt();
        }
        _94_maximum j = new _94_maximum();
        System.out.println(j.maximum(x,n,arr));
    }
}
