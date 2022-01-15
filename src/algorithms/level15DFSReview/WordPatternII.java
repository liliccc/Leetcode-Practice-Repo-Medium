package algorithms.level15DFSReview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        return dfs(pattern, str, new HashMap<>(), new HashSet<>());
    }

    private boolean dfs(String pattern, String str, Map<Character, String> map, Set<String>set) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        // a
        char character = pattern.charAt(0);
        if (map.containsKey(character)) {
            // red, the Java String class startsWith() method checks if this string starts with the given prefix
            if (!str.startsWith(map.get(character))) {
                return false;
            }
            return dfs(pattern.substring(1), str.substring(map.get(character).length()), map, set);
        }
        for (int i = 0; i < str.length(); i++) {
            String word = str.substring(0, i + 1);
            if (set.contains(word)) {
                continue;
            }
            map.put(character, word);
            set.add(word);
            if (dfs(pattern.substring(1), str.substring(i + 1), map, set)) {
                return true;
            }
            map.remove(character);
            set.remove(word);
        }
        return false;
    }
}
