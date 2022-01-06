package algorithms.level14DataStructuresReview;

public class InorderPredecessorinBST {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
     // non-recursive dfs
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode pre = null;
        while (root != null) {
            if (p.val <= root.val) {
                root = root.left;
            }
            // p.val > root.val
            else {
                if (pre == null || root.val > pre.val) {
                    pre = root;
                }
                root = root.right;
            }
        }
        return pre;
    }
}
