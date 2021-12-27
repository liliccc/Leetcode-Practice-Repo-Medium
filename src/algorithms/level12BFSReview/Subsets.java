package algorithms.level12BFSReview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> queue = new ArrayList<>();
        if (nums == null) {
            return queue;
        }
        queue.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int num: nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(queue.get(i));
                subset.add(num);
                queue.add(subset);
            }
        }
        return queue;
    }
}
