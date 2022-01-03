package algorithms.level13DivideAndConquer;

public class LowestCommonAncestorII {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // handle the leaf
        if (root == null || root == A || root == B) {
            return root;
        }
        // divide
        ParentTreeNode leftTreeNode = lowestCommonAncestorII(root.left , A ,B);
        ParentTreeNode rightTreeNode = lowestCommonAncestorII(root.right, A , B);
        // merge
        if (leftTreeNode != null && rightTreeNode != null) {
            return root;
        }
        if (leftTreeNode != null) {
            return leftTreeNode;
        }
        if (rightTreeNode != null) {
            return rightTreeNode;
        }
        return null;
    }
}

 class ParentTreeNode {
    public ParentTreeNode parent, left, right;
}
