package algorithms.level12BFSReview;

import java.util.*;

public class SlidingPuzzleII_Implicitgraph {
    /**
     * @param init_state: the initial state of chessboard
     * @param final_state: the final state of chessboard
     * @return: return an integer, denote the number of minimum moving
     */
     // given init state and final state -> use bidirectional bfs
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        if (init_state == null || init_state[0] == null) {
            return -1;
        }
        if (final_state == null || final_state[0] == null) {
            return -1;
        }
        // transfer to string
        String source = matrixToString(init_state);
        String target = matrixToString(final_state);
        if (source.equals(target)) {
            return 0;
        }
        Queue<String> forwardQueue = new ArrayDeque<>();
        Queue<String> backwardQueue = new ArrayDeque<>();
        Set<String> forwardSet = new HashSet<>();
        Set<String> backwardSet = new HashSet<>();
        forwardQueue.offer(source);
        backwardQueue.offer(target);
        forwardSet.add(source);
        backwardSet.add(target);
        int distance = 0;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            distance++;
            if (bfs(forwardQueue, forwardSet, backwardSet)) {
                return distance;
            }
            distance++;
            if (bfs(backwardQueue, backwardSet ,forwardSet)) {
                return distance;
            }
        }
        return -1;
    }

    // bidirectional bfs
    private boolean bfs(Queue<String> queue, Set<String> forwardSet, Set<String> oppositeSet) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String source = queue.poll();
            for (String next : getNext(source)) {
                if (oppositeSet.contains(next)) {
                    return true;
                }
                if (forwardSet.contains(next)) {
                    continue;
                }
                forwardSet.add(next);
                queue.add(next);
            }
        }
        return false;
    }

    // the core function of sliding puzzle
    private List<String> getNext(String source) {
        List<String> nextStrings = new ArrayList<>();
        int[][] DIRECTIONS = {
                {0, 1},
                {0 ,-1},
                {1 , 0},
                {-1, 0}
        };
        int zeroIndex = source.indexOf('0');
        // important - transfer from string to matrix
        int zeroX = zeroIndex / 3;
        int zeroY = zeroIndex % 3;
        for (int i = 0; i < 4; i++) {
            int newX = zeroX + DIRECTIONS[i][0];
            int newY = zeroY + DIRECTIONS[i][1];
            if (isNotValid(newX, newY)) {
                continue;
            }
            char[] array = source.toCharArray();
            array[zeroX * 3 + zeroY] = array[newX * 3 + newY];
            array[newX * 3 + newY] = '0';
            nextStrings.add(new String(array));
        }
        return nextStrings;
    }

    private boolean isNotValid(int x , int y) {
        return (x < 0 || x >= 3 || y < 0 || y >= 3);
    }

    // transfer the matrix to string, make it like word ladder
    private String matrixToString (int[][] state) {
        int n = state.length, m = state[0].length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                builder.append(state[i][j]);
            }
        }
        return builder.toString();
    }
}
