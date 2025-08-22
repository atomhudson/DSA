package Algorithm_and_Practice;

import java.util.Arrays;
public class _111_QuickSortApproach {
    public static void main(String[] args) {
        int[] arr = {23, 1, 10, 5, 2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr) {
        helperQuickSort(arr, 0, arr.length - 1);
    }
    private static void helperQuickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            helperQuickSort(arr, lo, pivot - 1);
            helperQuickSort(arr, pivot + 1, hi);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, high);
        return i; // pivot index
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
