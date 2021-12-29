package algorithms.level13DivideAndConquer;

import algorithms.level12BFSReview.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree {
    /**
     * @param root: root of the tree
     * @param p: the node p
     * @param q: the node q
     * @return: find the LCA of p and q
     */
     // BST => root.left <= root && root.right >= root, non-recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        int upperBound = Math.max(p.val, q.val);
        int lowerBound = Math.min(p.val, q.val);

        while (root != null) {
            if (root.val <= upperBound && lowerBound <= root.val) {
                return root;
            }
            else if (root.val > upperBound) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return null;
    }
}
