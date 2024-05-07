import java.util.Arrays;

public class _20_Cyclic_Sort {
    static void CyclicSort(int[] nums){
        int i =0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums,i,correct);
            }else{
                i++;
            }
        }
    }
    static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums [b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,2,1,4};
        CyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
