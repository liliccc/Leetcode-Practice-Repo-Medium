package algorithms.level5DivideAndConquer;

public class MaximumDepthofBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}