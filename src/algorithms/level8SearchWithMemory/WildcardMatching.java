package algorithms.level8SearchWithMemory;

public class WildcardMatching {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] memo = new boolean[s.length()][p.length()];
        return isMatchHelper(s, p, 0, 0, visited, memo);
    }

    private boolean isMatchHelper(String s, String p, int sIndex, int pIndex, boolean[][] visited, boolean[][] memo) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        if (sIndex == s.length()) {
            return allStar(p, pIndex);
        }
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        char pChar = p.charAt(pIndex);
        char sChar = s.charAt(sIndex);
        boolean match;
        if (pChar == '*') {
            match = isMatchHelper(s, p, sIndex, pIndex + 1, visited, memo) ||
            isMatchHelper(s, p, sIndex + 1, pIndex, visited, memo);
        }
        else {
            match = charMatch(sChar, pChar) && isMatchHelper(s, p , sIndex + 1, pIndex + 1, visited, memo);
        }
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }

    private boolean allStar(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    private boolean charMatch(char sChar, char pChar) {
        return sChar == pChar || pChar == '?';
    }
}
