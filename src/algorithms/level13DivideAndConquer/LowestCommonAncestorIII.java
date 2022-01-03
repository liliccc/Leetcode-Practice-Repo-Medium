package algorithms.level13DivideAndConquer;

public class LowestCommonAncestorIII {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
     // the given A and B may not in the tree
    private boolean isFoundA = false, isFoundB = false;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        TreeNode node = divideAndConquer(root, A, B);
        // check if it can get the both nodes
        if (isFoundA && isFoundB) {
            return node;
        }
        else {
            return null;
        }
    }

    private TreeNode divideAndConquer(TreeNode root, TreeNode A, TreeNode B) {
        // handle leaf
        if (root == null) {
            return root;
        }
        // divide
        TreeNode leftTreeNode = divideAndConquer(root.left , A, B);
        TreeNode rightTreeNode = divideAndConquer(root.right, A ,B);
        //error before, must be after the divide(A and B need to be found before return root)
        if (root == A || root == B) {
            isFoundA = (root == A) || isFoundA;
            isFoundB = (root == B) || isFoundB;
            return root;
        }
        // conquer
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
