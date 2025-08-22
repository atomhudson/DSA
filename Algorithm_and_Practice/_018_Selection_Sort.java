package Algorithm_and_Practice;

import java.util.Arrays;

public class _018_Selection_Sort {
    static int[] SelectionSort(int[] arr){
        for(int i = 0; i < arr.length ;i++){
            int lastIndex = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr,0,lastIndex);
            swap(arr, maxIndex, lastIndex);
        }
        return arr;
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    static int getMaxIndex(int[] arr,int start,int end){
        int max = start;
        for(int i = 0; i <= end; i++){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] arr= {4,5,1,2,3};
        System.out.println(Arrays.toString(SelectionSort(arr)));
    }
}
