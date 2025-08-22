package Algorithm_and_Practice;

import java.util.ArrayList;

public class _153_TheMazeLeetCode_Ca {
    public static void main(String[] args) {
        int[][] maze = {
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        int[] start = {0,4}, destination = {3,2};
        System.out.println(hasPath(maze, start, destination));
    }

    static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        ArrayList<String> list = allPathsList(start[0], start[1], destination[0], destination[1], "", maze);

        // Check if there are any valid paths
        if (list.isEmpty()) {
            return false;
        }

        // Find the shortest path (if needed)
        String shortestPath = null;
        int shortestPathLength = Integer.MAX_VALUE;
        for (String str : list) {
            if (str.length() < shortestPathLength) {
                shortestPath = str;
                shortestPathLength = str.length();
            }
        }

        // If no shortest path is found, return false
        if (shortestPath == null) {
            return false;
        }

        // Additional logic can be added here if you want to use the shortest path
        // Currently, just checking if the destination is valid
        int rowDestination = destination[0];
        int columnDestination = destination[1];

        // Checking if the destination is within bounds of the maze
        if (rowDestination >= 0 && rowDestination < maze.length && columnDestination >= 0 && columnDestination < maze[0].length) {
            return true; // Destination is reachable
        }
        return false; // Destination is not valid or out of bounds
    }

    static ArrayList<String> allPathsList(int row, int column, int rowDestination, int columnDestination, String process, int[][] maze) {
        if (row == rowDestination && column == columnDestination) {
            ArrayList<String> list = new ArrayList<>();
            list.add(process);
            return list;
        }

        if (maze[row][column] == 1) {
            return new ArrayList<>(); // Obstacle encountered
        }

        ArrayList<String> list = new ArrayList<>();
        maze[row][column] = 1; // Mark the current position as visited

        // Move down
        if (row < maze.length - 1) {
            list.addAll(allPathsList(row + 1, column, rowDestination, columnDestination, process + "Algorithm_and_Practice.D", maze));
        }
        // Move right
        if (column < maze[0].length - 1) {
            list.addAll(allPathsList(row, column + 1, rowDestination, columnDestination, process + "R", maze));
        }
        // Move up
        if (row > 0) {
            list.addAll(allPathsList(row - 1, column, rowDestination, columnDestination, process + "U", maze));
        }
        // Move left
        if (column > 0) {
            list.addAll(allPathsList(row, column - 1, rowDestination, columnDestination, process + "L", maze));
        }

        maze[row][column] = 0; // Backtrack and unmark the current position
        return list;
    }
}
