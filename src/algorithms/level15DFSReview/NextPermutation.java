package algorithms.level15DFSReview;

public class NextPermutation {
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int left = nums.length - 1;
        // look for a number in the list which is not in descending order
        while (left > 0 && nums[left] <= nums[left - 1]) {
            left--;
        }
        makeAscendingOrder(nums, left, nums.length - 1);
        // Look for a number in the ascending list which is just larger than nums[left - 1]
        if (left > 0) {
            int right = left;
            while (nums[left - 1] >= nums[right]) {
                right++;
            }
            swapItem(nums, left - 1, right);
        }
        return nums;
    }

    private void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void makeAscendingOrder(int[] nums, int i, int j) {
        while (i < j) {
            swapItem(nums,i,j);
            i++;
            j--;
        }
    }
}
