import java.util.Arrays;

class ReverseAnArray{
    int[] reserveAnArrayKTimes(int[] nums, int k){
        k = k % nums.length;
        nums = reverse(nums,0,nums.length - 1);
        nums = reverse(nums,0,k-1);
        nums = reverse(nums, k, nums.length-1);
        return nums;
    }
    private int[] reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
        return nums;
    }
}
public class _197_ReverseAnArray {
    public static void main(String[] args) {
        ReverseAnArray sol  = new ReverseAnArray();
        int [] A = {1,2,3,4};
        int  k = 4;
        System.out.println(Arrays.toString(sol.reserveAnArrayKTimes(A,k)));
    }
}
