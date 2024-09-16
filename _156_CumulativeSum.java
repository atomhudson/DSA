import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _156_CumulativeSum {
    public static void main(String[] args) {
        _156_CumulativeSum cumulativeSum = new _156_CumulativeSum();
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(cumulativeSum.getCumulativeSum(arr)));
        System.out.println(cumulativeSum.getPositiveCumulativeSum(arr));
    }
    int[] getCumulativeSum (int[] arr) {
        int[] nums = new int[arr.length];
        nums[0] =  arr[0];
        for(int i = 1; i < arr.length;i++){
            int sum = 0;
            for(int j = i; j >= 0;j--){
                sum = sum+arr[j];
            }
            nums[i] = sum;
        }
        return nums;
    }
    List<Integer> getPositiveCumulativeSum (int[] arr) {
        // add your logic here
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            list.add(list.get(i - 1) + arr[i]);
        }
        return list;
    }
}
