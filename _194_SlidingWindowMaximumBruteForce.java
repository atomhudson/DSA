import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SlidingWindowMaximumBruteForce{
    int[] SlidingWindow(int[] arr,int k){
        int[] resArr = new int[arr.length-k+1];
        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = FindMax(arr, i, i + k);
            resArr[i] = max;
        }
        return resArr;
    }
    private int FindMax(int[] arr,int start,int end){
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
public class _194_SlidingWindowMaximumBruteForce {
    public static void main(String[] args) {
        SlidingWindowMaximumBruteForce solution = new SlidingWindowMaximumBruteForce();
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(solution.SlidingWindow(arr,k)));
    }
}
