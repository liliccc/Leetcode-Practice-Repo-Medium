package algorithms.level12BFSReview;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPath {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    int[][] DIRECTIONS = {
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2},
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1}
    };
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        if (source.x == destination.x && source.y == destination.y) {
            return 0;
        }
        if (grid[destination.x][destination.y]) {
            return -1;
        }
        Queue<Point> forwardQueue = new LinkedList<>();
        Queue<Point> backwardQueue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] forwardSet = new boolean[n][m];
        boolean[][] backwardSet = new boolean[n][m];
        forwardQueue.offer(new Point(source.x, source.y));
        backwardQueue.offer(new Point(destination.x, destination.y));
        forwardSet[source.x][source.y] = true;
        backwardSet[destination.x][destination.y] = true;
        int distance = 0;
        // 双向宽度优先搜索, faster
        while (!backwardQueue.isEmpty() && !forwardQueue.isEmpty()) {
            distance++;
            if (bfs(forwardQueue, forwardSet, backwardSet, grid)) {
                return distance;
            }
            distance++;
            if (bfs(backwardQueue, backwardSet, forwardSet, grid)) {
                return distance;
            }
        }
        return -1;
    }

    private boolean bfs (Queue<Point> queue, boolean[][] forwardVisited, boolean[][] oppositeVisited, boolean[][] grid) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int x = queue.peek().x;
            int y = queue.poll().y;
            for (int j = 0; j < 8; j++) {
                int newX = x + DIRECTIONS[j][0];
                int newY = y + DIRECTIONS[j][1];
                if (!isValid(newX, newY, grid, forwardVisited)) {
                    continue;
                }
                if (oppositeVisited[newX][newY]) {
                    return true;
                }
                queue.offer(new Point(newX, newY));
                forwardVisited[newX][newY] = true;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y, boolean[][] grid, boolean[][] forwardVisited) {
        if (x < 0 || x >= grid.length) {
            return false;
        }
        if (y < 0 || y >= grid[0].length) {
            return false;
        }
        if (grid[x][y]) {
            return false;
        }
        if (forwardVisited[x][y]) {
            return false;
        }
        return true;
    }
}

