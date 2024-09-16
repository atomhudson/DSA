import java.util.Arrays;

public class _155_XORQueriesOfASubArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] queries = {
                {0, 1},
                {1, 2},
                {0, 3},
                {3, 3}
        };
        System.out.println(Arrays.toString(xorQueries(arr,queries)));
        System.out.println(2 ^ 10);
        System.out.println(8 ^ 10);
        System.out.println(4 ^ 4);
        System.out.println(4 ^ 10);
    }
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[arr.length];
        int i = 0;
        for(int[] num : queries){
            if(num[0] == 0 && num[1] == arr.length-1){
                result[i] = wholeXor(arr);
            }else{
                result[i] = arr[num[0]] ^ arr[num[1]];
            }
            i++;
        }
        return result;
    }
    public static int wholeXor(int[] arr){
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }
}
