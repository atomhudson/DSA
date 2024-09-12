import java.util.ArrayList;

public class _151_MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        pathsWithObstacles(0,0,"",maze);
        System.out.println(pathsListWithObstacles(0,0,"",maze));
    }
    static void pathsWithObstacles(int row, int column, String process,boolean[][] maze){
        if (row == maze.length - 1 && column == maze[0].length - 1){
            System.out.println(process);
            return;
        }
        if (!maze[row][column]){
            return;
        }
        if (row < maze.length - 1) {
            pathsWithObstacles(row + 1, column, process + "D",maze);
        }
        if (column < maze[0].length - 1){
            pathsWithObstacles(row,column + 1,process+"R",maze);
        }
    }
    static ArrayList<String> pathsListWithObstacles(int row, int column, String process, boolean[][] maze){
        if (row == maze.length - 1 && column == maze[0].length - 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(process);
            return list;
        }
        if (!maze[row][column]){
            return new ArrayList<>();
        }
        ArrayList<String> list = new ArrayList<>();
        if (row < maze.length - 1) {
            list.addAll(pathsListWithObstacles(row + 1, column, process + "D",maze));
        }
        if (column < maze[0].length - 1){
            list.addAll(pathsListWithObstacles(row,column + 1,process+"R",maze));
        }
        return list;
    }
}
