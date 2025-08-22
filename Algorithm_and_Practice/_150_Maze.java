package Algorithm_and_Practice;

import java.util.ArrayList;

public class _150_Maze {
    public static void main(String[] args) {
        System.out.println(count(3,3));
        paths(3,3,"");
        System.out.println(pathsList(3,3,""));
        System.out.println(pathsListDiagonal(3,3,""));
    }
//        Only Right and Down Moves are Allowed
    static int count(int row,int column){
        if (row == 1 || column == 1){
            return 1;
        }
        int left = count(row-1,column);
        int right = count(row,column - 1);
        return left + right;
    }
//        Only Right and Down Moves are Allowed
    static void paths(int row,int column,String process){
        if (row == 1 && column == 1){
            System.out.println(process);
            return;
        }
        if (row > 1) {
            paths(row - 1, column, process + "Algorithm_and_Practice.D");
        }
        if (column > 1){
            paths(row,column-1,process+"R");
        }
    }
//    Only Right and Down Moves are Allowed
    static ArrayList<String> pathsList(int row, int column, String process){
        if (row == 1 && column == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(process);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (row > 1) {
            list.addAll(pathsList(row - 1, column, process + "Algorithm_and_Practice.D"));
        }
        if (column > 1){
            list.addAll(pathsList(row,column-1,process+"R"));
        }
        return list;
    }
//        Only Right,Down and Diagonal Moves are Allowed

//    Algorithm_and_Practice.D -> Diagonal
//    H -> Horizontal (Right Move)
//    V -> Vertical (Down Move)
    static ArrayList<String> pathsListDiagonal(int row, int column, String process){
        if (row == 1 && column == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(process);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (row > 1 && column > 1){
            list.addAll(pathsListDiagonal(row-1,column-1,process+"Algorithm_and_Practice.D"));
        }
        if (row > 1) {
            list.addAll(pathsListDiagonal(row - 1, column, process + "V"));
        }
        if (column > 1){
            list.addAll(pathsListDiagonal(row,column-1,process+"H"));
        }
        return list;
    }
}
