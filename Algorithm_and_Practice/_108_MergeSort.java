package Algorithm_and_Practice;

import java.util.Arrays;

public class _108_MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,3,4,12,5,6};
        System.out.println(Arrays.toString(MergeSort(arr)));
    }
    static int[] MergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = MergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = MergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    private static int[] merge(int[] left,int[] right){
        int[] finalArray = new int[left.length + right.length];
        int pointer1 = 0;
        int pointer2 = 0;
        int pointerForFinalArray = 0;

        while (pointer1 < left.length && pointer2 < right.length){
            if (left[pointer1] < right[pointer2]){
                finalArray[pointerForFinalArray] = left[pointer1];
                pointer1++;
            }else{
                finalArray[pointerForFinalArray] = right[pointer2];
                pointer2++;
            }
            pointerForFinalArray++;
        }
//      It may be possible that either or the array not is complete

        while (pointer1 < left.length){
            finalArray[pointerForFinalArray] = left[pointer1];
            pointer1++;
            pointerForFinalArray++;
        }
        while (pointer2 < right.length){
            finalArray[pointerForFinalArray] = right[pointer2];
            pointer2++;
            pointerForFinalArray++;
        }
        return finalArray;
    }
}
