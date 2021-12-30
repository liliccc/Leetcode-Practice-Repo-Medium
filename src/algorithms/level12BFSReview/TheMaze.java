package algorithms.level12BFSReview;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        if (maze[0] == null || maze[0].length == 0) {
            return false;
        }
        if (maze[destination[0]][destination[1]] == 1) {
            return false;
        }
        if (start == destination) {
            return true;
        }
        int n = maze.length, m = maze[0].length;
        // not the shortest path, does not need to use priorityQueue
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));
        boolean[][] visited = new boolean[n][m];
        // check the visited when the queue offers new elements
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            // not moving one step each time, cannot search level by level
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            if (x == destination[0] && y == destination[1]) {
                return true;
            }
            // check the visited when the queue poll new elements
//            if (visited[x][y]) {
//                continue;
//            }
//            visited[x][y] = true;
            for (int j = 0; j < 4; j++) {
                int newX = x;
                int newY = y;
                while (isValid(maze, newX, newY)) {
                    newX += DIRECTIONS[j][0];
                    newY += DIRECTIONS[j][1];
                }
                // hit the wall, move back
                newX -= DIRECTIONS[j][0];
                newY -= DIRECTIONS[j][1];
                // check the visited when the queue poll new elements
                //queue.offer(new Point(newX, newY));
                // check the visited when the queue offers new elements, much faster
                if (!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new Point(newX, newY));
                }
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length) {
            return false;
        }
        if (y < 0 || y >= maze[0].length) {
            return false;
        }
        if (maze[x][y] == 1) {
            return false;
        }
        return true;
    }
}

