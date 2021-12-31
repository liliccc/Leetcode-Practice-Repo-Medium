package algorithms.level12BFSReview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RemoveSubstrings {
    /**
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int minLen = s.length();
        visited.add(s);
        queue.offer(s);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (String piece : dict) {
                int found = word.indexOf(piece);
                while (found != -1) {
                    String newWord = word.substring(0, found) + word.substring(found + piece.length(), word.length());
                    if (!visited.contains(newWord)) {
                        visited.add(newWord);
                        queue.offer(newWord);
                        if (newWord.length() < minLen) {
                            minLen = newWord.length();
                        }
                    }
                    // search after found index
                    found = word.indexOf(piece, found + 1);
                }
            }
        }
        return minLen;
    }
}
