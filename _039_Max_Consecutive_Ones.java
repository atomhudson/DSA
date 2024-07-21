public class _039_Max_Consecutive_Ones {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0,j=-1,i=0;
        for(;i<nums.length;i++){
            if(nums[i]==0){
                max=Math.max(max,i-j-1);
                j=i;
            }
        }
        return Math.max(max,i-j-1);
    }
    public static void main(String[] args) {
        int[] arr= {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
