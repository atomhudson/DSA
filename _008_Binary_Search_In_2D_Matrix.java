
public class _008_Binary_Search_In_2D_Matrix {
    static boolean searchMatric(int[][] matrix, int target){
        for(int i = 0 ;i < matrix.length;i++){
            if(matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target){
                return BinarySearch(matrix[i],target);
            }
        }
        return false;
    }
    static boolean BinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int middle = start + (end - start) / 2;
            if (target == arr[middle]){
                return true;
            } else if (target > arr[middle]) {
                start = middle + 1;
            }else if (target < arr[middle]){
                end = middle - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1,3}};
        int target = 3;
        System.out.println(searchMatric(matrix,target));
    }
}
