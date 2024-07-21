import java.util.Arrays;

public class _004_Linear_Search_In_2D_Array {
    public static int[] LinearSearchIn2DArray(int[][] arr,int target){
        for (int row = 0; row < arr.length; row++ ){
            for(int column = 0; column < arr[row].length; column++){
                if (arr[row][column] == target) {
                    return new int[] {row,column};
                }
            }
        }
        return new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE};
    }

//    Finding MIN in 2D Array
    public static int FindingMinIn2DArrayUsingLinearSearch(int[][] arr){
        int MIN = arr[0][0];
        for (int[] row: arr){
            for (int element: row){
                if (element < MIN){
                    MIN = element;
                }
            }
        }
        return Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,54},
                {4,5,-1,3},
                {6,7,8,9,10}
        };
        int target = 123;
        System.out.println(Arrays.toString(LinearSearchIn2DArray(arr,target)));
        System.out.println(FindingMinIn2DArrayUsingLinearSearch(arr));
    }
}
