public class _38_1351_Count_Negative_Numbers_in_a_Sorted_Matrix {
    public static int countNegatives(int[][] grid) {
//        Brute Force approach
//        int count = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for(int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] < 0) {
//                    count++;
//                }
//            }
//        }
//        return count;
        int TR = grid.length;
        int TC = grid[0].length;
        int R = 0 , C = TC -1;
        int count = 0;
        while(R < TR && C >=0 ){
            if(grid[R][C] < 0){
                C--;
                count = count + TR - R;
            }else{
                R++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));

    }
}
