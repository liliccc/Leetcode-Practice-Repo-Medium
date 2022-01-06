package algorithms.level14DataStructuresReview;

import java.util.*;

public class SearchRangeinBinarySearchTree {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
     // https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
     // Using BFS can find the number in order
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val >= k1 && node.val <= k2) {
                    results.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        Collections.sort(results);
        return results;
    }

}

