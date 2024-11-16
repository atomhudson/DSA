import java.util.*;
class CheckSumOfNumberAfterEliminatingTheMinAndMaxDigitFromIt {
    int CheckSumOfNumber(int [] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = removingMinMax(arr[i]);
            arr[i] = CheckSum(arr[i]);
            sum += arr[i];
        }
        return sum;
    }
    int removingMinMax(int num){
        ArrayList<Integer> arr = new ArrayList<>();
        while(num != 0){
            int remainder = num % 10;
            arr.add(remainder);
            num /= 10;
        }
        Collections.sort(arr);
        arr.remove(0);
        arr.remove(arr.size()-1);
        int finalNum = 0;
        for (int a: arr){
            finalNum = finalNum * 10 + a;
        }
        return finalNum;
    }
    int CheckSum(int num){
        int sum = 0;
        while(num != 0){
            int remainder = num % 10;
            sum+=remainder;
            num /= 10;
        }
        return sum;
    }
}
public class _190_CheckSumOfNumberAfterEliminatingTheMinAndMaxDigitFromIt {
    public static void main(String[] args) {
        int[] arr = {1223,234,3445,456};
        CheckSumOfNumberAfterEliminatingTheMinAndMaxDigitFromIt solution = new CheckSumOfNumberAfterEliminatingTheMinAndMaxDigitFromIt();
        System.out.println(solution.CheckSumOfNumber(arr));
    }
}
