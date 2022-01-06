package algorithms.level14DataStructuresReview;

import java.util.List;

public class TwoSumIV_InputisaBST {
    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
     // using inorder traversal or BFS (get the number from BST in order)
    public int[] twoSum(TreeNode root, int n) {
        int[] results = new int[2];
        if (root == null) {
            return null;
        }
        inOrder(results, root, n);
        return results;
    }

    private void inOrder(int[] results, TreeNode root, int target) {
        if (root == null) {
            return;
        }
        inOrder(results, root.left, target);
        if (find(root, target -root.val)) {
            results[0] = root.val;
            results[1] = target - root.val;
        }
        inOrder(results, root.right, target);
    }

    private boolean find(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val < target) {
            return find(root.right, target);
        }
        else {
            return find(root.left, target);
        }
    }
}
