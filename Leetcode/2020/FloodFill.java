package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int s = image[sr][sc];
        //dfs(image, sr, sc, newColor, s);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        bfs(image, newColor, s, queue);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor, int s) {
        if (i < 0 || i > image.length - 1 || j < 0 || j > image[0].length - 1
                || image[i][j] != s || image[i][j] == newColor) {
            return;
        }
        image[i][j] = newColor;
        dfs(image, i+1, j, newColor, s);
        dfs(image, i-1, j, newColor, s);
        dfs(image, i, j+1, newColor, s);
        dfs(image, i, j-1, newColor, s);
    }

    private void bfs(int[][] image, int newColor, int s, Queue<int[]> queue) {
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0], j = point[1];
            if (i < 0 || i > image.length - 1 || j < 0 || j > image[0].length - 1
                    || image[i][j] != s || image[i][j] == newColor) {
                continue;
            }
            image[i][j] = newColor;
            queue.offer(new int[]{i+1,j});
            queue.offer(new int[]{i-1,j});
            queue.offer(new int[]{i,j+1});
            queue.offer(new int[]{i,j-1});
        }
    }
}
