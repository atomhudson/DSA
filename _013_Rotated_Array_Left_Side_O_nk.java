import java.util.Arrays;

public class _013_Rotated_Array_Left_Side_O_nk {
    static int[] RotateLeft(int [] arr,int k){
        k = k % arr.length;
        if(k < 0) k = k + arr.length;
        for (int i = 1; i <= k; i++){
            Reverse(arr);
        }
        return arr;
    }
    static void Reverse(int[] arr){
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++){
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        System.out.println(Arrays.toString(RotateLeft(arr,2)));
    }
}
