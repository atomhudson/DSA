package Algorithm_and_Practice;

import java.util.Arrays;
import java.util.HashMap;

public class _181_RankTransformOfAnArray {
    public static void main(String[] args) {
        int[] arr1 = {40,10,20,30};
        int[] arr2 = {100,100,100};
        int[] arr3 = {37,12,28,9,100,56,80,5,12};
        RankTransformOfArray array = new RankTransformOfArray();
        System.out.println(Arrays.toString(array.arrayRankTransform(arr1)));
        System.out.println(Arrays.toString(array.arrayRankTransform(arr2)));
        System.out.println(Arrays.toString(array.arrayRankTransform(arr3)));
    }
}
class RankTransformOfArray{
    public int[] arrayRankTransform(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 1;
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], count);
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}
