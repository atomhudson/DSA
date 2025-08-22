package Algorithm_and_Practice;

import java.util.HashMap;
import java.util.Map;

public class _044_Find_The_Single_Occuring_Number_In_Array {
//    arr[] = { 2, 2, 3, 4, 4, 3, 5, 1, 1};
//    ans: 5 it is occuring only one time;
    public static int findNumber(int[] arr){
//        Using HASHMAP
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            if (!map.containsKey(arr[i])){
                map.put(arr[i],count);
            }
            else {
                map.put(arr[i],count+1);
            }
        }
        for (Map.Entry<Integer,Integer> maps : map.entrySet()){
            if (maps.getValue() == 1){
                return maps.getKey();
            }
        }
        return -1;
    }
    public static int findSingleNumber(int[] arr){
//        Using XOR method
//        0 ^ 0 = 0;
//        1 ^ 1 = 0;
//        1 ^ 0 = 1;
//        0 ^ 1 = 1;
//        XOR all the number in array
        int result = 0;
        for (int a: arr){
            result = result ^ a;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr= {2,3,3,4,2,6,4};
        System.out.println(findNumber(arr));
        System.out.println(findSingleNumber(arr));

    }
}
