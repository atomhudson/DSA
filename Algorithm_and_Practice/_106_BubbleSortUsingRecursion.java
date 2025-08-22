package Algorithm_and_Practice;

import java.util.Arrays;
public class _106_BubbleSortUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,6,9};
        BubbleSortUsingRecursion(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void BubbleSortUsingRecursion(int[] arr){
        int n = arr.length;
        helperBubbleSort(arr, 0, n - 1);
    }
    private static void helperBubbleSort(int[] arr,int start, int end){
        if (end == 0) {
            return;
        }
        if (start < end) {
            if (arr[start] > arr[start + 1]) {
                // Swap
                int temp = arr[start];
                arr[start] = arr[start + 1];
                arr[start + 1] = temp;
            }
            // Recur for the next element in the current pass
            helperBubbleSort(arr, start + 1, end);
        } else {
            // Recur for the next pass with one less element to consider
            helperBubbleSort(arr, 0, end - 1);
        }
    }
}
