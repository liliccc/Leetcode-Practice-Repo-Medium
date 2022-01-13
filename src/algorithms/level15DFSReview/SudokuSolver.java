package algorithms.level15DFSReview;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {
    /**
     * @param board: the sudoku puzzle
     * @return: nothing
     */
    public void solveSudoku(int[][] board) {
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] columnUsed = new boolean[9][10];
        boolean[][] boxUsed = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int val = board[i][j];
                rowUsed[i][val] = true;
                columnUsed[j][val] = true;
                boxUsed[i / 3 * 3 + j / 3][val] = true;
            }
        }
        dfs(board, rowUsed, columnUsed, boxUsed);
    }

    private boolean dfs(int[][] board, boolean[][] rowUsed, boolean[][] columnUsed, boolean[][] boxUsed) {
        Position position = getAtLeastChoicesPosition(board, rowUsed, columnUsed, boxUsed);
        if (position == null) {
            return true;
        }
        for (int i = 0; i < position.choices.size(); i++) {
            int val = position.choices.get(i);
            int x = position.x;
            int y = position.y;
            // add it to next dfs
            rowUsed[x][val] = true;
            columnUsed[y][val] = true;
            boxUsed[x / 3 * 3 + y / 3][val] = true;
            board[x][y] = val;
            if (dfs(board, rowUsed, columnUsed, boxUsed)) {
                return true;
            }
            rowUsed[x][val] = false;
            columnUsed[y][val] = false;
            boxUsed[x / 3 * 3 + y / 3][val] = false;
            board[x][y] = 0;
        }
        return false;
    }

    // Brute Force Search - O(9^3)
    private Position getAtLeastChoicesPosition(int[][] board, boolean[][] rowUsed, boolean[][] columnUsed, boolean[][] boxUsed) {
        Position position = null;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // error before: == 0
                if (board[i][j] != 0) {
                    continue;
                }
                List<Integer> choices = new ArrayList<>();
                // find all possible choices that can be filled
                for (int val = 1; val < 10; val++) {
                    if (isValid(rowUsed, columnUsed, boxUsed, i, j, val)) {
                        choices.add(val);
                    }
                }
                if (position == null || choices.size() < position.choices.size()) {
                    position = new Position(i, j);
                    position.choices = choices;
                }
            }
        }
        return position;
    }

    private boolean isValid(boolean[][] rowUsed, boolean[][] columnUsed, boolean[][] boxUsed, int x, int y, int val) {
        if (rowUsed[x][val]) {
            return false;
        }
        if (columnUsed[y][val]) {
            return false;
        }
        if (boxUsed[x / 3 * 3 + y / 3][val]) {
            return false;
        }
        return true;
    }
}

class Position {
    int x, y;
    List<Integer> choices;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.choices = new ArrayList<>();
    }
}
