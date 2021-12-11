package algorithms.level5DivideAndConquer;

public class MinimumSubtree {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        return helper(root).minSubtree;
    }

    private ResultOfMinSubtree helper(TreeNode node) {
        if (node == null) {
            return new ResultOfMinSubtree(null, Integer.MAX_VALUE, 0);
        }
        ResultOfMinSubtree leftResult = helper(node.left);
        ResultOfMinSubtree rightResult = helper(node.right);
        ResultOfMinSubtree result = new ResultOfMinSubtree(node, leftResult.sum + rightResult.sum+ node.val,
        leftResult.sum + rightResult.sum+ node.val);
        if (leftResult.minSum < result.minSum) {
            result.minSum = leftResult.minSum;
            result.minSubtree = leftResult.minSubtree;
        }
        if (rightResult.minSum < result.minSum) {
            result.minSum = rightResult.minSum;
            result.minSubtree = rightResult.minSubtree;;
        }
        return result;
    }


}

class ResultOfMinSubtree {
    TreeNode minSubtree;
    int minSum;
    int sum;
    public ResultOfMinSubtree(TreeNode minSubtree, int minSum, int sum) {
        this.minSubtree = minSubtree;
        this.minSum = minSum;
        this.sum = sum;
    }
}