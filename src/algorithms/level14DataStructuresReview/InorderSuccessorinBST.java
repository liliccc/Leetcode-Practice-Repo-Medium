package algorithms.level14DataStructuresReview;

public class InorderSuccessorinBST {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode succ = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            }
            // root.val > p.val
            else {
                if (succ == null || succ.val > root.val) {
                    succ = root;
                }
                root = root.left;
            }
        }
        return succ;
    }
}
