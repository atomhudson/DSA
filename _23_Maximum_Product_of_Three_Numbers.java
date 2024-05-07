import java.util.Arrays;

public class _23_Maximum_Product_of_Three_Numbers {
    static int MaximumProduct(int[] nums){
        Arrays.sort(nums);
        Arrays.sort(nums);
        int lastmax = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int firstmax = nums[0]*nums[1]*nums[nums.length-1];
        return Math.max(lastmax,firstmax);
    }
    public static void main(String[] args) {
        int[] arr={-100,-98,-1,2,3,4};
        System.out.println(MaximumProduct(arr));

    }
}
