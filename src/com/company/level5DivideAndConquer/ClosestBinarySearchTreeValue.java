package com.company.level5DivideAndConquer;

public class ClosestBinarySearchTreeValue {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        TreeNode upperBound = root;
        TreeNode lowerBound = root;
        while (root != null) {
            if (root.val > target) {
                upperBound = root;
                root = root.left;
            }
            else if (root.val < target) {
                lowerBound = root;
                root = root.right;
            }
            else {
                return root.val;
            }
        }

        if (Math.abs(upperBound.val - target) > Math.abs(lowerBound.val - target)) {
            return lowerBound.val;
        }
        else {
            return upperBound.val;
        }
    }
}
