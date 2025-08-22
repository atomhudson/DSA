package Algorithm_and_Practice;

import java.util.Arrays;

public class _014_Rotated_Array_Left_Side_O_n {
    static int[] RotateLeft(int[] arr,int k){
        k = k % arr.length;
        if(k < 0) k = k + arr.length;
        Reverse(arr,0,k-1);
        Reverse(arr,k,arr.length-1);
        Reverse(arr,0,arr.length-1);
        return arr;
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
        int [] arr = {10,20,30,40,50,60,70,80,90};
        int k = 4;
        System.out.println(Arrays.toString(RotateLeft(arr,k)));
    }
}
