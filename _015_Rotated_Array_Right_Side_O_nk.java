import java.util.Arrays;

public class _015_Rotated_Array_Right_Side_O_nk {
    static void Rotate(int[] arr, int k){
        k = k % arr.length;
        if(k < 0) k = k + arr.length;
        for(int i = 1; i <= k; i++){
            RotateRightOneTime(arr);
        }
    }
    static void RotateRightOneTime(int[] arr){
        int n = arr.length;
        int temp = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;
        Rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
