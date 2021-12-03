package com.company.level5;

import java.util.Stack;

public class KthSmallestElementinaBST {
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
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        for (int i = 0; i < k; i++) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.add(node);
                node = node.left;
            }
        }
        return stack.peek().val;
    }

    private void findLeftMost(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }
}
