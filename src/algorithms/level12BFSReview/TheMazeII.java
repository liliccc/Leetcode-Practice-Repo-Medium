package algorithms.level12BFSReview;

public class TheMazeII {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: the shortest distance for the ball to stop at the destination
     */

    int[][] DIRECTIONS = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
     // not simple paths in graph, the ball will go more than one block each time
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        return 0;
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
