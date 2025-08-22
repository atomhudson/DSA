package Algorithm_and_Practice;

import java.util.ArrayList;

public class _173_MazeRevision {
    private class Solution{
        int allPaths(int row,int column){
            if (row == 1 || column == 1){
                return 1;
            }
            int left = allPaths(row - 1,column);
            int right = allPaths(row,column-1);
            return left+right;
        }
        void printAllPaths(int row, int columns, String process){
            if (row == 1 && columns == 1){
                System.out.println(process);
                return;
            }
            if (row > 1) printAllPaths(row-1,columns,process+"Algorithm_and_Practice.D");
            if (columns > 1) printAllPaths(row,columns-1,process+"R");
        }
        ArrayList<String> listOfAllPaths(int row, int column,String paths){
            if (row == 1 && column == 1){
                ArrayList<String> path = new ArrayList<>();
                path.add(paths);
                return path;
            }
            ArrayList<String> listPaths = new ArrayList<>();
            if (row > 1){
                listPaths.addAll(listOfAllPaths(row-1,column,paths+"Algorithm_and_Practice.D"));
            }
            if (column > 1){
                listPaths.addAll(listOfAllPaths(row,column-1,paths+"R"));
            }
            return listPaths;
        }
        ArrayList<String> listOfAllPathUsingDigonalMoves(int row, int column,String process){
            if (row == 1 && column == 1){
                ArrayList<String> path = new ArrayList<>();
                path.add(process);
                return path;
            }
            ArrayList<String> listPaths = new ArrayList<>();
            if (row > 1){
                listPaths.addAll(listOfAllPathUsingDigonalMoves(row-1,column,process+"V"));
            }
            if (column > 1){
                listPaths.addAll(listOfAllPathUsingDigonalMoves(row,column-1,process+"H"));
            }
            if (row > 1 && column > 1){
                listPaths.addAll(listOfAllPathUsingDigonalMoves(row-1,column-1,process+"Algorithm_and_Practice.D"));
            }
            return listPaths;
        }
        void pathsWithObstacles(String process, boolean[][] maze, int row, int columns){
            if (row == maze.length-1 && columns == maze[0].length - 1){
                System.out.println(process);
                return;
            }
            if (!maze[row][columns]){
                return;
            }
            if (row < maze.length - 1){
                pathsWithObstacles(process+"Algorithm_and_Practice.D",maze,row+1,columns);
            }
            if (columns < maze[0].length - 1){
                pathsWithObstacles(process+"R",maze,row,columns+1);
            }
        }
        ArrayList<String> listOfAllPathsWithObstacles(String process,boolean[][] maze,int row,int column){
            if (row == maze.length-1 && column == maze[0].length-1){
                ArrayList<String> path = new ArrayList<>();
                path.add(process);
                return path;
            }
            if (!maze[row][column]){
                return new ArrayList<>();
            }
            ArrayList<String> paths = new ArrayList<>();
            if (row < maze.length-1){
                paths.addAll(listOfAllPathsWithObstacles(process+"Algorithm_and_Practice.D",maze,row+1,column));
            }
            if (column < maze[0].length-1){
                paths.addAll(listOfAllPathsWithObstacles(process+"R",maze,row,column+1));
            }
            return paths;
        }
        void allDirectionPath(String process, boolean[][] maze, int row, int column){
            if (row == maze.length-1 && column == maze[0].length-1){
                System.out.println(process);
                return;
            }
            if (!maze[row][column]){
                return;
            }
            if (row < maze.length - 1){
                allDirectionPath(process+"Algorithm_and_Practice.D",maze,row+1,column);
            }
            if (column < maze[0].length - 1){
                allDirectionPath(process+"R",maze,row,column+1);
            }
            if (row > 0){
                allDirectionPath(process+"U",maze,row-1,column);
            }
            if (column > 0){
                allDirectionPath(process+"L",maze,row,column-1);
            }
        }

    }
    public static void main(String[] args) {
        _173_MazeRevision mazeRevision = new _173_MazeRevision();
        Solution solution = mazeRevision.new Solution();
        System.out.println(solution.allPaths(3,3));
        System.out.println("_____________________________________________________________________________________");
        solution.printAllPaths(3,3,"");
        System.out.println("_____________________________________________________________________________________");
        System.out.println(solution.listOfAllPaths(3,3,""));
        System.out.println("_____________________________________________________________________________________");
        System.out.println(solution.listOfAllPathUsingDigonalMoves(3,3,""));
        System.out.println("_____________________________________________________________________________________");
        boolean[][] maze = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        solution.pathsWithObstacles("",maze,0,0);
        System.out.println("_____________________________________________________________________________________");
        System.out.println(solution.listOfAllPathsWithObstacles("",maze,0,0));;
        System.out.println("_____________________________________________________________________________________");
        solution.allDirectionPath("",maze,0,0);
    }
}


