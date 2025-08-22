package Algorithm_and_Practice;

import java.util.Scanner;

public class _183_RatCountHouse_Acc {
    static class Solution {
        int calculate(int r,int unit, int n,int[] arr){
            if (n == 0){
                return -1;
            }
            int allRatsNeed = r*unit;
            int sum = 0;
            int i = 0;
            for (i = 0; i < n; ++i) {
                sum+=arr[i];
                if (allRatsNeed <= sum){
                    break;
                }
            }
            if (allRatsNeed > sum){
                return 0;
            }
            return i+1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int unit = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Solution sol = new Solution();
        System.out.println(sol.calculate(r,unit,n,arr));
    }
}
