package algorithms.level11BinarySearchReview;

public class Searcha2DMatrix {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
     // 二维数组转一维数组，再进行二分
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        // 二维数组转一维数组
        int start = 0, end = n * m - 1;
        // start != end
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getFromMatrix(matrix, mid) < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (getFromMatrix(matrix, start) == target) {
            return true;
        }
        if (getFromMatrix(matrix, end) == target) {
            return true;
        }
        return false;
    }
    // 一维数组转二维数组
    private int getFromMatrix (int[][] matrix, int number) {
        int length = matrix[0].length;
        int x = number / length;
        int y = number % length;
        return matrix[x][y];
    }
}
