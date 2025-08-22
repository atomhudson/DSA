package Algorithm_and_Practice;

import java.util.*;
public class _032_3Sum {
    public static List<List<Integer>> threesum(int[] nums){
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                     result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                     left++;
                     right--;
                } else if (sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threesum(nums));
    }
}
