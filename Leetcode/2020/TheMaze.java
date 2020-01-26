package LeetCode;

public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start[0], start[1], destination);
    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination) {
        if (i < 0 || i >= maze.length || j < 0 || j >= maze[0].length || maze[i][j] == 1) {
            return false;
        }
        if (i == destination[0] && j == destination[1]) {
            return true;
        }
        maze[i][j] = 1;
        return dfs(maze, i+1, j, destination) || dfs(maze, i-1, j, destination) ||
                dfs(maze, i, j-1, destination) || dfs(maze, i, j+1, destination);
    }
}
