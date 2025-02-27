import java.util.Arrays;

public class _211_SetMatrixZeroes {
    static class Solution1{
        public void setZeroes(int[][] matrix){
            int row = matrix.length;
            int col = matrix[0].length;
            boolean[] rowise = new boolean[row];
            boolean[] colwise = new boolean[col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0){
                        rowise[i] = true;
                        colwise[j] = true;
                    }
                }
            }
            for (int i = 0; i < row;i++){
                for (int j = 0; j < col; j++) {
                    if (rowise[i] || colwise[j]){
                        matrix[i][j] = 0;
                    }
                }
            }
            System.out.println(Arrays.toString(rowise));
            System.out.println(Arrays.toString(colwise));
            System.out.println(Arrays.deepToString(matrix));
        }
    }
    static class Solution2{
        public void setZeroes(int[][] matrix){
            boolean firstRow = false, firstCol=false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0){
                        if (i == 0) firstRow = true;
                        if (j == 0) firstCol = true;
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0){
                        matrix[i][j] = 0;
                    }
                }
            }
            if (firstRow){
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (firstCol){
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
            System.out.println(Arrays.deepToString(matrix));
        }
    }
    public static void main(String[] args) {
        int[][] mat = {{0,1,2,0},{3,4,0,2},{1,3,1,5}};
//        int[][] mat1 = {{1,1,1},{1,0,1},{1,1,1}};
//        Solution1 sol = new Solution1();
//        sol.setZeroes(mat);
        Solution2 solution2 = new Solution2();
        solution2.setZeroes(mat);
//        sol.setZeroes(mat1);
    }
}
