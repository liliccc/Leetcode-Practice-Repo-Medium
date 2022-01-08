package algorithms.level14DataStructuresReview;

import java.util.Stack;

// BST: each store a key greater than all the keys in the node’s left subtree and less than those in its right subtree
public class BSTIterator {
    // problem name: Binary Search Tree Iterator
    /**
     * @param root: The root of binary tree.
     */
     // stack: first in last out, queue: first in first out
    Stack<TreeNode> stack;
    // add the left path of the left subtree
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return: return next node
     */
    public TreeNode next() {
        if (!hasNext()) {
            return null;
        }
        TreeNode currentNode = stack.pop();
        // find the right subtree leftmost node is the node which is bigger than root
        TreeNode rightSubtreeNode = currentNode.right;
        while (rightSubtreeNode != null) {
            stack.push(rightSubtreeNode);
            rightSubtreeNode = rightSubtreeNode.left;
        }
        return currentNode;
    }
}
