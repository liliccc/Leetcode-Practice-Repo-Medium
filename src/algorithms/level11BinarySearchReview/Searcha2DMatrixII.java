package algorithms.level11BinarySearchReview;

public class Searcha2DMatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
     // 排列数组组成的矩阵，有重复的数，从左下角开始二分
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int row = n - 1, column = 0, count = 0;
        while (row >= 0 && column < m) {
            int number = matrix[row][column];
            if (number == target) {
                count++;
                row--;
                column++;
            }
            else if (number < target) {
                column++;
            }
            else {
                row--;
            }
        }
        return count;
    }
}
