package algorithms.level12BFSReview;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeKthFloorNode {
    /**
     * @param root: the root node
     * @param k: an integer
     * @return: the number of nodes in the k-th layer of the binary tree
     */
    public int kthfloorNode(TreeNode root, int k) {
        if (root == null || k == 0) {
            return 0;
        }
        if (k == 1) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (depth == k) {
                return size;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return 0;
    }
}
