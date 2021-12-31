package algorithms.level12BFSReview;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
     // using bfs traversal the tree level and level and reverse the collection
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            results.add(level);
        }
        Collections.reverse(results);
        return results;
    }
}
