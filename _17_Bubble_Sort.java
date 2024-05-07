import java.util.Arrays;

public class _17_Bubble_Sort {
    static int[] Bubble_Sort(int[] arr){
        for(int i = 0;i < arr.length; i++){
            boolean swapped = false;
            for (int j = 1; j < arr.length - i;j++){
                if(arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                    swapped = true;
                }
            }
            // if only the array is already sorted.
            if(!swapped){
                break;
            }
        }
        return arr;
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(Bubble_Sort(arr)));
    }
}
