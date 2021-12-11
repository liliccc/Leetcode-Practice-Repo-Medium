package algorithms.level2TwoPointersTechnique;

import java.util.Arrays;

public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public static void sortColors(int[] nums) {
        int index = 0, front = 0, end = nums.length - 1;
        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, index, front);
                front++;
                index++;
            }
            else if (nums[index] == 2) {
                swap(nums, index, end);
                end--;
            }
            else {
                index++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

}
