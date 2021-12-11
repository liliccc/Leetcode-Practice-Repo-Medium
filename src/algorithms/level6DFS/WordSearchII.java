package algorithms.level6DFS;

import java.util.*;

public class WordSearchII {

    public static int[] DX = {0, 1, -1, 0};
    public static int[] DY = {1, 0, 0, -1};
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        if (board == null || board.length == 0) {
            return new ArrayList<>();
        }
        if (board[0] == null || board[0].length == 0) {
            return new ArrayList<>();
        }
        Map<String, Boolean> prefixMap = getPrefix(words);
        Set<String> results = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = true;
                dfs(board, String.valueOf(board[i][j]), i, j, prefixMap, results, visited);
                visited[i][j] = false;
            }
        }
        return new ArrayList<>(results);
    }

    private void dfs(char[][] board, String word, int x, int y, Map<String, Boolean> prefixMap, Set<String> subsets
            , boolean[][] visited) {
        if (!prefixMap.containsKey(word)) {
            return;
        }
        if (prefixMap.get(word)) {
            subsets.add(word);
        }
        for (int i = 0; i < 4; i++) {
            int dx = x + DX[i];
            int dy = y + DY[i];
            // !isInside must be before visited
            if (!isInside(board, dx, dy)|| visited[dx][dy]) {
                continue;
            }
            visited[dx][dy] = true;
            dfs(board, word + board[dx][dy], dx, dy, prefixMap, subsets, visited);
            visited[dx][dy] = false;
        }
    }

    private Map<String, Boolean> getPrefix(List<String> words) {
        Map<String, Boolean> prefixMap = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length() - 1; i++) {
                String prefix = word.substring(0, i + 1);
                if (!prefixMap.containsKey(prefix)) {
                    prefixMap.put(prefix, false);
                }
            }
            prefixMap.put(word, true);
        }
        return prefixMap;
    }

    private boolean isInside(char[][] board, int x, int y) {
        return x>= 0 && x < board.length && y >= 0 && y < board[0].length;
    }


}
