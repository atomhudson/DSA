import java.util.Arrays;

public class _19_Insertion_Sort {
    static void InsertionSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j > 0; j--){
                if(nums[j] < nums[j-1]){
                    swap(nums,j,j-1);
                }else{
                    break;
                }
            }
        }
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {0,321,21,1,2};
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
