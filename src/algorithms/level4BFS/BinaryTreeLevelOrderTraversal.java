package algorithms.level4BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            // can not put treeNodes.size() into for loop
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = treeNodes.poll();
                level.add(head.val);
                if (head.left != null) {
                    treeNodes.offer(head.left);
                }
                if (head.right != null) {
                    treeNodes.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        tree.left = left;
        tree.right = right;

        System.out.println(levelOrder(tree));
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
