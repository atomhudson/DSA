import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class _187_SumOfPair_HasedIn {
    static class Solution{
        int SumOfPair(int length,int[] arr, int sum){
            Arrays.sort(arr);
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < length; i++) {
                for (int j = i+1; j < length; j++) {
                    if (arr[i]+arr[j] == sum){
                        set.add(arr[i]+" "+arr[j]);
                    }
                }
            }
            return set.size();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.SumOfPair(length,arr,sum));
    }
}
