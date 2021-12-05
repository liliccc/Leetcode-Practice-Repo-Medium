package com.company.level5DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class ClosestBinarySearchTreeValueII {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> orderedList = new ArrayList<>();
        if (root == null) {
            return orderedList;
        }
        inOrderTraversal(orderedList, root);
        int closestPoint, size = orderedList.size();
        for (closestPoint = 0; closestPoint < size; closestPoint++) {
            if (orderedList.get(closestPoint) >= target) {
                // right = closestPoint + 1; upperbound must be greater than target
                break;
            }
        }
        int right = closestPoint;
        if (right >= size) {
            return orderedList.subList(size - k, size);
        }
        int left = right - 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k ; i++) {
            if (left >= 0 && (right >= size || orderedList.get(right) - target > target - orderedList.get(left))) {
                result.add(orderedList.get(left));
                left--;
            }
            else {
                result.add(orderedList.get(right));
                right++;
            }
        }
        return result;
    }

    private void inOrderTraversal (List<Integer> orderedList, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(orderedList, root.left);
        orderedList.add(root.val);
        inOrderTraversal(orderedList, root.right);
    }
}
