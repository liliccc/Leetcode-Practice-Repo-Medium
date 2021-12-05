package com.company.level5DivideAndConquer;

public class MaximumSubtree {
    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        return helper(root).maxSubtree;
    }

    private ResultOfMaximumSubtree helper(TreeNode node) {
        if (node == null) {
            return new ResultOfMaximumSubtree(null, 0, Integer.MIN_VALUE);
        }
        ResultOfMaximumSubtree leftResult = helper(node.left);
        ResultOfMaximumSubtree rightResult = helper(node.right);
        int sum = leftResult.sum + rightResult.sum + node.val;
        ResultOfMaximumSubtree result = new ResultOfMaximumSubtree(node, sum, sum);
        if (leftResult.maxSum > result.maxSum) {
            result.maxSum = leftResult.maxSum;
            result.maxSubtree = leftResult.maxSubtree;
        }
        if (rightResult.maxSum > result.maxSum) {
            result.maxSubtree = rightResult.maxSubtree;
            result.maxSum = rightResult.maxSum;
        }
        return result;
    }
}

class ResultOfMaximumSubtree {
    TreeNode maxSubtree;
    int sum;
    int maxSum;
    public ResultOfMaximumSubtree(TreeNode maxSubtree, int sum, int maxSum) {
        this.maxSubtree = maxSubtree;
        this.sum = sum;
        this.maxSum = maxSum;
    }
}
