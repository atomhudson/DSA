package Algorithm_and_Practice;

import java.util.ArrayList;

public class _152_MazeWithFourAllowedMoves {
    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        allPaths(0,4,"",maze);
    }
    static void allPaths(int row,int column,String process,int[][] maze){
        if (row == 4 && column == 4){
            System.out.println(process);
            return;
        }
        if (maze[row][column] == 1){
            return;
        }
//       I am considering this block is my path
        maze[row][column] = 1;
        if (row < maze.length - 1) {
            allPaths(row + 1, column, process + "Algorithm_and_Practice.D",maze);
        }
        if (column < maze[0].length - 1){
            allPaths(row,column + 1,process + "R",maze);
        }
        if (row > 0){
            allPaths(row - 1,column,process + "U",maze);
        }
        if (column > 0){
            allPaths(row,column - 1,process + "L",maze);
        }
//        This line is where the function will be over or the recursion at a level is over
//        So before the function gets removed, also remove the changes that were made by the function
        maze[row][column] = 0;
    }
    static ArrayList<String> allPathsList(int row,int column,String process,int[][] maze){
        if (row == 4 && column == 4){
            ArrayList<String> list = new ArrayList<>();
            list.add(process);
            return list;
        }
        if (maze[row][column] == 1){
            return new ArrayList<>();
        }
//       I am considering this block is my path
        ArrayList<String> list = new ArrayList<>();
        maze[row][column] = 1;
        if (row < maze.length - 1) {
            list.addAll(allPathsList(row + 1, column, process + "Algorithm_and_Practice.D",maze));
        }
        if (column < maze[0].length - 1){
            list.addAll(allPathsList(row,column + 1,process + "R",maze));
        }
        if (row > 0){
            list.addAll(allPathsList(row - 1,column,process + "U",maze));
        }
        if (column > 0){
            list.addAll(allPathsList(row,column - 1,process + "L",maze));
        }
//        This line is where the function will be over or the recursion at a level is over
//        So before the function gets removed, also remove the changes that were made by the function
        maze[row][column] = 0;
        return list;
    }

}

