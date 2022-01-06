package algorithms.level14DataStructuresReview;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    // using array is faster than using hashmap
    public char firstUniqChar(String str) {
        if (str== null || str.length() == 0) {
            return '0';
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            }
            else {
                int num = map.get(ch);
                map.put(ch, num + 1);
            }
        }
        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return '0';
    }
}
