package algorithms.level12BFSReview;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPathII {
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
     // 使用双向宽度优先搜索, faster than using dp
    int[][] FORWARDS_DERECTIONS = {
            {1, 2},
            {-1, 2},
            {2, 1},
            {-2, 1}
    };
    // 4 directions backward is different
    int[][] BACKWARDS_DERECTIONS = {
            {-1, -2},
            {1, -2},
            {-2 ,-1},
            {2, -1}
    };
    public int shortestPath2(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int n = grid.length, m = grid[0].length;
        if (grid[n - 1][m - 1]) {
            return -1;
        }
        if (n * m == 1) {
            return 0;
        }
        Queue<Point> forwardQueue = new LinkedList<>();
        Queue<Point> backwardQueue = new LinkedList<>();
        boolean[][] forwardSet = new boolean[n][m];
        boolean[][] backwardSet = new boolean[n][m];
        forwardQueue.offer(new Point(0, 0));
        backwardQueue.offer(new Point(n - 1, m -1));
        forwardSet[0][0] = true;
        backwardSet[n -1][m - 1] = true;
        int distance = 0;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            distance++;
            if (bfs(forwardQueue, FORWARDS_DERECTIONS, forwardSet, backwardSet, grid)) {
                return distance;
            }
            distance++;
            if (bfs(backwardQueue, BACKWARDS_DERECTIONS, backwardSet, forwardSet, grid)) {
                return distance;
            }
        }
        return -1;
    }

    private boolean bfs(Queue<Point> queue, int[][] directions, boolean[][] forwardVisited, boolean[][] oppositeVisited, boolean[][] grid) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int x = queue.peek().x;
            int y = queue.poll().y;
            // error before
            for (int j = 0; j < 4; j++) {
                int newX = x + directions[j][0];
                int newY = y + directions[j][1];
                if (!isValid(newX, newY, forwardVisited, grid)) {
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

    private boolean isValid(int x, int y, boolean[][] forwardVisited, boolean[][] grid) {
        if (x < 0 || x >= grid.length) {
            return false;
        }
        if (y < 0 || y >= grid[0].length) {
            return false;
        }
        if (forwardVisited[x][y]) {
            return false;
        }
        if (grid[x][y]) {
            return false;
        }
        return true;
    }
}

