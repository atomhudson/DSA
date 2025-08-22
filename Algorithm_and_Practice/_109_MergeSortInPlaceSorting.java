package Algorithm_and_Practice;

import java.util.Arrays;

public class _109_MergeSortInPlaceSorting {
    public static void main(String[] args) {
        int[] arr = {6, 4, 7, 5, 9, 2, 1};
        mergeSortInPlace(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortInPlace(int[] arr) {
        helperMergeSortInPlace(arr, 0, arr.length - 1); // Corrected arr.length to arr.length - 1
    }

    private static void helperMergeSortInPlace(int[] arr, int s, int e) {
        if (s >= e) { // Corrected e < s to s >= e
            return;
        }
        int mid = (s + e) / 2;
        helperMergeSortInPlace(arr, s, mid);
        helperMergeSortInPlace(arr, mid + 1, e);

        mergeInPlace(arr, s, mid, e);
    }

    private static void mergeInPlace(int[] arr, int s, int mid, int e) {
        int[] mix = new int[e - s + 1]; // Corrected e - s to e - s + 1
        int i = s;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j <= e) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        System.arraycopy(mix, 0, arr, s, mix.length);
    }
}
