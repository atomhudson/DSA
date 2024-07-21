public class _021_Missing_Number {
    static int MissingNumber(int[] nums){
//        int i = 0;
//        while(i < nums.length){
//            if(i != nums[i] && nums[i] < nums.length ){
//                swap(nums,i,nums[i]);
//            }else {
//                i++;
//            }
//        }
//        for (int j = 0; j < nums.length; j++) {
//            if(j != nums[j]){
//                return j;
//            }
//        }
//        return -1;
        int allXOR = 0;
        for (int i = 0; i <= nums.length; i++) {
            allXOR = allXOR ^ i;
        }
        for (int num : nums){
            allXOR = allXOR ^ num;
        }
        return allXOR;
    }
//    static void swap(int[] arr,int a, int b){
//        int temp = arr[a];
//        arr[a] = arr[b];
//        arr[b] = temp;
//    }

    public static void main(String[] args) {
        int[] arr={5,2,1,0,3};
        System.out.println(MissingNumber(arr));

    }
}
