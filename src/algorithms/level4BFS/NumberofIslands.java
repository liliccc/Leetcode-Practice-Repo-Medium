package algorithms.level4BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberofIslands {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public static int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0, height = grid.length, width = grid[0].length;
        boolean[][] visited = new boolean[height][width];
        for (int i = 0 ; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    count++;
                    BFS(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private static void BFS(boolean[][] grid, int x, int y, boolean[][] visited) {
        Queue<Coordinate> queue = new ArrayDeque<>();
        int[] deltaX = {0, 0, 1, -1};
        int[] deltaY = {1, -1, 0, 0};
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Coordinate point = queue.poll();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                for (int direction = 0; direction < 4 ; direction++) {
                    int newX = point.x + deltaX[direction];
                    int newY = point.y + deltaY[direction];
                    if (isValid(grid, newX, newY, visited)) {
                        queue.offer(new Coordinate(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }

    private static boolean isValid(boolean[][] grid, int x, int y, boolean[][] visited) {
        int height = grid.length, width = grid[0].length;
        // x -> height, y -> width, important
        if (x < 0 || y < 0 || x >= height|| y >= width) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (!grid[x][y]) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
//        boolean[][] nums = {
//                {true,true,false,false,false},
//                {false,true,false,false,true},
//                {false,false,false,true,true},
//                {false,false,false,false,false},
//                {false,false,false,false,true}
//        };
        boolean[][] nums = {{true, true}};
        System.out.println(numIslands(nums));
    }
}

class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
