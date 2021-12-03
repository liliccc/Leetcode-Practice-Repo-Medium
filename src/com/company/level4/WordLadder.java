package com.company.level4;

import java.util.*;

public class WordLadder {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public static int ladderLength(String start, String end, Set<String> dict) {
        dict.add(end);
        Queue<String> queue = new ArrayDeque<>();
        Map<String , Integer> distance = new HashMap<>();
        queue.offer(start);
        distance.put(start, 1);
        while (!queue.isEmpty()) {
            String newWord = queue.poll();
            if(newWord.equals(end)) {
                return distance.get(newWord);
            }
            for (String nextWord : validWord(newWord, dict)) {
                if (!distance.containsKey(nextWord)) {
                    queue.offer(nextWord);
                    distance.put(nextWord, distance.get(newWord) + 1);
                }
            }
        }
        return 0;
    }

    private static List<String> validWord(String word, Set<String> dict) {
        List<String> words = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i + 1);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (word.charAt(i) == ch) {
                    continue;
                }
                String nextWord = left + ch + right;
                if (dict.contains(nextWord)) {
                    words.add(nextWord);
                }
            }
        }
        return words;
        // slower
//        List<String> nextWords = new ArrayList<>();
//        for (String comparedWord : dict) {
//            int count = 0;
//            for (int j = 0; j < word.length() ; j++) {
//                if (word.charAt(j) != comparedWord.charAt(j)) {
//                    count++;
//                }
//            }
//            if (count == 1) {
//                nextWords.add(comparedWord);
//            }
//        }
//        return nextWords;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> set = new HashSet<>();
//        set.add("a");
//        set.add("b");
//        set.add("c");
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        set.add("cog");
        System.out.println(ladderLength(start, end , set));
    }
}
