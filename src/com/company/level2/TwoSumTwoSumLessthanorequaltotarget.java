package com.company.level2;

import java.util.Arrays;

public class TwoSumTwoSumLessthanorequaltotarget {

    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public static int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
       Arrays.sort(nums);
       int front = 0;
       int end = nums.length - 1;
       int pairsNum = 0;
       while (front <= end) {
        if ((nums[front] + nums[end]) <= target) {
            pairsNum += end - front;
            front ++;
        }
        else {
            end --;
        }
       }
       return pairsNum;
    }

    public static void main(String[] args) {
        int[] newArray = {2,3,6,1,4};
        int target = 5;
        System.out.println(twoSum5(newArray, target));
    }
}
