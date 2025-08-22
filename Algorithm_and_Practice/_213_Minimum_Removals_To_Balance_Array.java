package Algorithm_and_Practice;

import java.util.Arrays;

public class _213_Minimum_Removals_To_Balance_Array {
    public static int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        int j = 0;

        for(int i = 0; i < n; i++){
            while(j < n && (long) nums[j] <= (long) nums[i] * k){
                j++;
            }
            max = Math.max(max, j - i);
        }
        return n - max;

    }

    public static void main(String[] args) {
        int [] nums = {1,6,2,9};
        System.out.println(minRemoval(nums,3));
    }

}
