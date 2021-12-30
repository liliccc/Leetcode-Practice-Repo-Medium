package algorithms.level12BFSReview;

import java.util.PriorityQueue;
import java.util.Queue;

public class TheMazeII {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */
    // get the shortest path - bfs
    // move up, down, left, right
    int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
     // not simple paths in graph, the ball will go more than one block each time
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return 0;
        }
        if (maze[0] == null || maze[0].length == 0) {
            return 0;
        }
        int n = maze.length, m = maze[0].length;
        if (start == destination) {
            return 1;
        }
        if (maze[destination[0]][destination[1]] == 1) {
            return 0;
        }
        // PriorityQueue will choose the element with smaller len first
        Queue<Position> queue = new PriorityQueue<>((p1, p2) -> (p1.len - p2.len));
        queue.offer(new Position(start[0], start[1], 0 ));
        boolean[][] visited = new boolean[n][m];
        while(!queue.isEmpty()) {
            Position point = queue.poll();
            int x = point.x;
            int y = point.y;
            if (x == destination[0] && y == destination[1]) {
                return point.len;
            }
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x;
                int newY = y;
                int newLen = point.len;
                // keep rolling until it hits the wall
                while (isValid(maze, newX, newY)) {
                    newX += DIRECTIONS[i][0];
                    newY += DIRECTIONS[i][1];
                    newLen++;
                }
                // hit the wall, move back one step
                newX -= DIRECTIONS[i][0];
                newY -= DIRECTIONS[i][1];
                newLen--;
                queue.offer(new Position(newX, newY, newLen));
            }
        }
        return -1;
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

class Position {
    int x;
    int y;
    int len;
    public Position(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }
}
