package com.company.level7AdvancedDataStructures;

import java.util.*;

public class TopkLargestNumbersII {

    int k;
    Queue<Integer> queue;
    /*
     * @param k: An integer
     */public TopkLargestNumbersII(int k) {
        this.k = k;
        this.queue = new PriorityQueue<>();
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        queue.add(num);
        if (queue.size() > k) {
            queue.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        List<Integer> results = new ArrayList<>();
        Iterator it = queue.iterator();
        while (it.hasNext()) {
            results.add((int)it.next());
        }
        results.sort(Collections.reverseOrder());
        return results;
    }
}
