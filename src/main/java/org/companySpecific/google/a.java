import java.util.*;

public class a {
    private static final char WALL = '#';
    private static final char SPACE = '.';
    private static final char EXIT = 'E';

    // Directions for moving: DOWN, RIGHT, UP, LEFT
    private static final int[][] DIRECTIONS = {
            {1, 0},  // DOWN
            {0, 1},  // RIGHT
            {-1, 0}, // UP
            {0, -1}  // LEFT
    };

    // Corresponding command letters for each direction
    private static final char[] COMMANDS = {'D', 'R', 'U', 'L'};

    public static void main(String[] args) {
        char[][] maze = {
                {'#', '#', '#', '#', '#', '#'},
                {'#', '.', '#', 'E', '.', '#'},
                {'#', '.', '.', '.', '.', '#'},
                {'#', '#', '#', '#', '#', '#'}
        };

        String path = findUniversalPath(maze);
        System.out.println("Universal Path: " + path);
    }

    private static String findUniversalPath(char[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;

        boolean[][] visited = new boolean[rows][cols];
        StringBuilder path = new StringBuilder();

        // Find the exit location
        int[] exitPos = findExit(maze);
        if (exitPos == null) {
            return ""; // No exit found
        }

        // Perform DFS from the exit to cover all reachable free spaces
        dfs(maze, exitPos[0], exitPos[1], visited, path);

        return path.toString();
    }

    private static int[] findExit(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == EXIT) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean isValidMove(char[][] maze, int row, int col, boolean[][] visited) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length
                && maze[row][col] != WALL && !visited[row][col];
    }

    private static void dfs(char[][] maze, int row, int col, boolean[][] visited, StringBuilder path) {
        visited[row][col] = true;

        // Explore all directions
        for (int d = 0; d < DIRECTIONS.length; d++) {
            int newRow = row + DIRECTIONS[d][0];
            int newCol = col + DIRECTIONS[d][1];

            if (isValidMove(maze, newRow, newCol, visited)) {
                path.append(COMMANDS[d]); // Append command for the direction
                dfs(maze, newRow, newCol, visited, path);
                path.append(reverseCommand(COMMANDS[d])); // Append reverse command to backtrack
            }
        }
    }

    private static char reverseCommand(char command) {
        switch (command) {
            case 'D': return 'U';
            case 'U': return 'D';
            case 'L': return 'R';
            case 'R': return 'L';
            default: return ' ';
        }
    }
}
