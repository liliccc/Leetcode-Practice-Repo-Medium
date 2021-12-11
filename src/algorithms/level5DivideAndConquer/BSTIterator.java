package algorithms.level5DivideAndConquer;

import java.util.Stack;

public class BSTIterator {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        findLeftMost(root, stack);
        TreeNode node = null;
        for (int i = 0; i < k; i++) {
            node = stack.pop();
            if (node.right != null) {
                findLeftMost(node.right, stack);
            }
        }
        return node.val;
    }

    private void findLeftMost(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }
}