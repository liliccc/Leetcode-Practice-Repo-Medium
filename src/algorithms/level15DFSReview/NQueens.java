package algorithms.level15DFSReview;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        search(result, new ArrayList<>(), n);
        return result;
    }

    private void search(List<List<String>> result, List<Integer> columns, int n) {
        if (columns.size() == n) {
            result.add(drawChessBoard(columns));
            return;
        }
        for (int columnIndex = 0; columnIndex < n; columnIndex++) {
            if (!isValid(columns, columnIndex)) {
                continue;
            }
            columns.add(columnIndex);
            search(result, columns, n);
            columns.remove(columns.size() - 1);
        }
    }

    // [2,1,3,0] -> (0,2), (1,1), (2,3), (3,0)
    private boolean isValid(List<Integer> columns, int tryColumn) {
        int tryRow = columns.size();
        for (int rowIndex = 0; rowIndex < columns.size(); rowIndex++) {
            // the same row has queen
            if (columns.get(rowIndex) == tryColumn) {
                return false;
            }
            // the same diagonal
            if (columns.get(rowIndex) + rowIndex == tryRow + tryColumn) {
                return false;
            }
            if (rowIndex - columns.get(rowIndex) == tryRow - tryColumn) {
                return false;
            }
        }
        return true;
    }

    private List<String> drawChessBoard(List<Integer> columns) {
        List<String> chessBoard = new ArrayList<>();
        for (int i = 0; i < columns.size(); i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < columns.size(); j++) {
                builder.append(j == columns.get(i) ? "Q" : ".");
            }
            chessBoard.add(builder.toString());
        }
        return chessBoard;
    }
}
