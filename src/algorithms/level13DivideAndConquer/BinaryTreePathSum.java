package algorithms.level13DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
     // divide and conquer: big problem -> smaller problems, target is changing
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        // handle leaf, if root.val != target , return an empty ArrayList
        if (root.left == null && root.right == null && root.val == target) {
            List<Integer> nodeList = new ArrayList<>();
            nodeList.add(root.val);
            results.add(nodeList);
            return results;
        }
        // divide
        List<List<Integer>> leftResults = binaryTreePathSum(root.left, target - root.val);
        List<List<Integer>> rightResults = binaryTreePathSum(root.right, target - root.val);

        // merge
        for (List<Integer> leftList : leftResults) {
            leftList.add(0, root.val);
            results.add(leftList);
        }
        for (List<Integer> rightList : rightResults) {
            rightList.add(0, root.val);
            results.add(rightList);
        }
        return results;
    }
}

