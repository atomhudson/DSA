import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class isPrime {
    public static int[] isprime(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) if (check(arr[i])) list.add(i);
        int[] ar = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ar[i] = list.get(i);
        return ar;
    }
    public static boolean check(int n){
        if(n <= 1) return false;
        else if (n == 2) return true;
        else if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) if(n % i == 0 || n % (i + 2) == 0 ) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int arrelememt = sc.nextInt();
            arr[i] = arrelememt;
        }
        System.out.println(Arrays.toString(isprime(arr)));
    }
}
