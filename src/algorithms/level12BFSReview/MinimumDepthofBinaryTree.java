package algorithms.level12BFSReview;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
     // bfs is faster than recursive method since it doesn't need to go through all the nodes
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left!= null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        // error before
        return 0;
    }
}
