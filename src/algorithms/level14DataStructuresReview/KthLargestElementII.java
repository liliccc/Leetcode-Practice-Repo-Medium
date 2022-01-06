package algorithms.level14DataStructuresReview;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementII {
    /**
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            // only keep k nums in the queue
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
