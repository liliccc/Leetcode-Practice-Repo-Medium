package algorithms.level13DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumII {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
     // each node should be traversed as root
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        List<List<Integer>> fromRootResults = divideAndConquer(root, target);
        List<List<Integer>> fromLeftResults = binaryTreePathSum2(root.left, target);
        List<List<Integer>> fromRightResults = binaryTreePathSum2(root.right, target);
        results.addAll(fromRootResults);
        results.addAll(fromLeftResults);
        results.addAll(fromRightResults);
        return results;
    }

    private List<List<Integer>> divideAndConquer(TreeNode root, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                List<Integer> nodeList = new ArrayList<>();
                nodeList.add(root.val);
                results.add(nodeList);
                return results;
            }
        }
        if (root.val == target) {
            List<Integer> nodeList = new ArrayList<>();
            nodeList.add(root.val);
            results.add(nodeList);
        }
        List<List<Integer>> leftResults = divideAndConquer(root.left, target - root.val);
        List<List<Integer>> rightResults = divideAndConquer(root.right, target - root.val);
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
