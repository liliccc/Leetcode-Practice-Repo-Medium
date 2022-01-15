package algorithms.level15DFSReview;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        if (n < 0) {
            return 0;
        }
        return dfs(new ArrayList<>(), n);
    }

    private int dfs(List<Integer> columns, int n) {
        if (columns.size() == n) {
            return 1;
        }
        int sum = 0;
        for (int columnIndex = 0; columnIndex < n; columnIndex++) {
            if (!isValid(columns, columnIndex)) {
                continue;
            }
            // backtracking
            columns.add(columnIndex);
            sum += dfs(columns, n);
            columns.remove(columns.size() - 1);
        }
        return sum;
    }

    private boolean isValid(List<Integer> columns, int columnIndex) {
        int rowIndex = columns.size();
        for (int row = 0; row < columns.size(); row++) {
            int column = columns.get(row);
            if (columnIndex == column || rowIndex - columnIndex  == row - column || rowIndex + columnIndex == row + column) {
                return false;
            }
        }
        return true;
    }
}
