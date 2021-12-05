package com.company.level4BFS;

import java.util.Queue;
import java.util.ArrayDeque;

public class KnightShortestPath {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        Queue<Point> queue = new ArrayDeque<>();
        int distance = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] deltaX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] deltaY = {2, -2, 2, -2, 1, -1, 1, -1};
        queue.offer(source);
        visited[source.x][source.y] = true;
        while (!queue.isEmpty()) {
            // relative to return distance
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int direction = 0; direction < 8; direction++) {
                    int newX = point.x + deltaX[direction];
                    int newY = point.y + deltaY[direction];
                    if (isValid(grid, newX, newY, visited)) {
                        if (newX == destination.x && newY == destination.y) {
                            return distance;
                        }
                        queue.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(boolean[][] grid, int x, int y, boolean[][] visited) {
        int height = grid.length, width = grid[0].length;
        if (x < 0 || y < 0 || x >= height || y >= width) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (grid[x][y]) {
            return false;
        }
        return true;
    }
}

class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
}
