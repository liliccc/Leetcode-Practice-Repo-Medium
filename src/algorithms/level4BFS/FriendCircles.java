package algorithms.level4BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class FriendCircles {
    /**
     * @param M: a matrix
     * @return: the total number of friend circles among all the students
     */
    public static int findCircleNum(int[][] M) {
        if (M == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                count++;
                BFS(M, i);
            }
        }
        return count;
    }

    private static void BFS(int[][] M, int student) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(student);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int j = queue.poll();
                M[j][j] = 2;
                for (int k = 0; k < M[j].length; k++) {
                    if (M[j][k] == 1 && M[k][k] == 1) {
                        queue.offer(k);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(nums));
    }
}
