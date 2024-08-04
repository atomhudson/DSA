import java.util.Arrays;
import java.util.EnumSet;

public class _110_QuickSort {
    public static void main(String[] args) {
        int[] arr = {10,16,8,12,15,6,3};
        QuickSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void QuickSort(int[] nums){
        helperQuickSort(nums,0,nums.length-1);
    }
    private static void helperQuickSort(int[] arr,int low,int high){
        if (low >= high){
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];


        while (start <= end){
//           Checking the violation 1
//            Also a reason why if it's already sorted it will not swap
            while (arr[start] < pivot){
                start++;
            }
//           Checking the violation 2
            while (arr[end] > pivot){
                end--;
            }
            if (start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
//        Now my pivot is at correct index, please sort two half
        helperQuickSort(arr,low,end);
        helperQuickSort(arr,start,high);
    }
}
