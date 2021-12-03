package com.company.level5;


public class BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, true);
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (!left.isBalanced || !right.isBalanced) {
            return new Result(-1, false);
        }
        if (Math.abs(left.height - right.height) > 1) {
            return new Result(-1, false);
        }
        return new Result(Math.max(left.height, right.height) + 1, true);
    }

}

class Result {
    int height;
    boolean isBalanced;
    public Result(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}


