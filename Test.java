import java.util.*;

public class Test {
    static class Cell {
        int x, y, moves;

        Cell(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read grid dimensions
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] grid = new int[M][N];

        // Read the grid
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // Read source and destination
        int srcX = scanner.nextInt();
        int srcY = scanner.nextInt();
        int destX = scanner.nextInt();
        int destY = scanner.nextInt();

        // Read move rule
        int moveX = scanner.nextInt();
        int moveY = scanner.nextInt();

        int result = minMoves(grid, srcX, srcY, destX, destY, moveX, moveY, M, N);
        System.out.println(result);
    }

    public static int minMoves(int[][] grid, int srcX, int srcY, int destX, int destY, int moveX, int moveY, int M, int N) {
        // If starting or destination cells are blocked
        if (grid[srcX][srcY] == 1 || grid[destX][destY] == 1) return -1;

        // Define directions based on the move rule
        int[][] directions = {
                {moveX, moveY},               // forward
                {moveY, -moveX},              // right (90 degrees clockwise)
                {-moveY, moveX},              // left (90 degrees anticlockwise)
                {-moveX, -moveY}              // backward (180 degrees)
        };

        // Queue for BFS
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(srcX, srcY, 0));

        // Visited array
        boolean[][] visited = new boolean[M][N];
        visited[srcX][srcY] = true;

        // BFS loop
        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            // Check if we reached the destination
            if (current.x == destX && current.y == destY) {
                return current.moves;
            }

            // Explore each direction
            for (int[] dir : directions) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                // Check bounds, if it's open (0), and unvisited
                if (newX >= 0 && newY >= 0 && newX < M && newY < N && grid[newX][newY] == 0 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Cell(newX, newY, current.moves + 1));
                }
            }
        }

        // If no path found
        return -1;
    }
}
