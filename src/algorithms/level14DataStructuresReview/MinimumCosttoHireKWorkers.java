package algorithms.level14DataStructuresReview;

import java.util.*;

public class MinimumCosttoHireKWorkers {
    /**
     * @param quality: an array
     * @param wage: an array
     * @param K: an integer
     * @return: the least amount of money needed to form a paid group
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        if (quality == null || quality.length == 0) {
            return -1;
        }
        if (wage == null || wage.length == 0) {
            return -1;
        }
        Map<Double, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < quality.length; i++) {
            double wagePerQuality = (double) wage[i] / quality[i];
            // error before: must use arrayList, since there will be some same wagePerQuality
            map.putIfAbsent(wagePerQuality, new ArrayList<>());
            map.get(wagePerQuality).add(quality[i]);
        }
        Queue<Integer> queueOfQuality = new PriorityQueue<>((p1, p2) -> p2 - p1);
        double min = Double.MAX_VALUE;
        int sumOfQuality = 0;
        for (double wagePerQuality : map.keySet()) {
            List<Integer> qualities = map.get(wagePerQuality);
            for (int qua: qualities) {
                sumOfQuality += qua;
                queueOfQuality.offer(qua);
                if (queueOfQuality.size() > K) {
                    // remove the large quality
                    int theLargeQuality = queueOfQuality.poll();
                    sumOfQuality -= theLargeQuality;
                }
                if (queueOfQuality.size() == K) {
                    min = Math.min(min, sumOfQuality * wagePerQuality);
                }
            }
        }
        return min;
    }
}
