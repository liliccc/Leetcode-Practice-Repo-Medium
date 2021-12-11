package algorithms.level7AdvancedDataStructures;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumberII {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        Set<Long> visited = new HashSet<>();
        Queue<Long> queue = new PriorityQueue<>();
        visited.add(1L);
        queue.add(1L);
        int[] primes = new int[3];
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        Long val = null;
        for (int i =0 ; i < n; i++) {
            val = queue.poll();
            for (int j = 0; j < 3; j++) {
                long uglyNum = val * primes[j];
                if (!visited.contains(uglyNum)) {
                    queue.add(uglyNum);
                    visited.add(uglyNum);
                }
            }
        }
        return val.intValue();
    }
}
