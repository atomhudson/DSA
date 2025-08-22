package Algorithm_and_Practice;

import java.util.Arrays;

public class _016_Rotated_Array_Right_Side_O_n {
    static void Rotate(int[] arr, int k){
        k =  k % arr.length;
        if(k < 0) k = k + arr.length;
        //To Rotate Ist Part of Array
        Reverse(arr, 0, arr.length-1-k);
        //To Rotate IInd Part of Array
        Reverse(arr, arr.length - k, arr.length - 1);
        Reverse(arr, 0, arr.length - 1);
    }
    static void Reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90};
        int k = -2;
        Rotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }
}
