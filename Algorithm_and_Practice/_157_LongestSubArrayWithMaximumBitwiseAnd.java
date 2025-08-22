package Algorithm_and_Practice;

public class _157_LongestSubArrayWithMaximumBitwiseAnd {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,2,2};
        System.out.println(longestSubarray(nums));
    }
    public static int longestSubarray(int[] nums){
        int maxEle = 0 ;
        for (int n: nums){
            maxEle = Math.max(maxEle,n);
        }
        int count = 0;
        int ans = 1;
        for (int n : nums){
            if (n == maxEle){
                count++;
            }else {
                count = 0;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}
