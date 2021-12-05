package com.company.level5DivideAndConquer;

public class FlattenBinaryTreetoLinkedList {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        flattenAndReturnNode(root);
    }

    private TreeNode flattenAndReturnNode (TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode leftLast = flattenAndReturnNode(node.left);
        TreeNode rightLast = flattenAndReturnNode(node.right);
        if (leftLast != null) {
            leftLast.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        if (rightLast != null) {
            return rightLast;
        }
        if (leftLast != null) {
            return leftLast;
        }
        return node;
    }
}
