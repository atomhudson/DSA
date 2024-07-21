public class _009_Binary_search_Optimized_Approach {
    static boolean BinarySearchOn2DArray(int[][] matrix, int target){
        int N = matrix.length;
        int M = matrix[0].length;
        int start = 0 ;
        int end = N * M - 1;
        while (start <= end){
            int middle = start + (end - start) / 2;
            int row = middle / M;
            int column = middle % M;
            if(matrix[row][column] == target){
                return true;
            }else if (matrix[row][column] < target){
                start = middle + 1;
            }else {
                end = middle - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        System.out.println(BinarySearchOn2DArray(matrix,target));
    }

}
