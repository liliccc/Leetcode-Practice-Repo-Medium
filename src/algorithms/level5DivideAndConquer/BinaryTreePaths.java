package algorithms.level5DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<String> path = new ArrayList<>();
        path.add(Integer.toString(root.val));
        findPaths(root, path, paths);
        return paths;
    }

    private void findPaths(TreeNode root, List<String>path, List<String> paths) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            paths.add(String.join("->", path));
        }
        if (root.left != null) {
            path.add(Integer.toString(root.left.val));
            findPaths(root.left, path, paths);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(Integer.toString(root.right.val));
            findPaths(root.right, path, paths);
            path.remove(path.size() - 1);
        }
    }
}
