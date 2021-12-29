package algorithms.level12BFSReview;

import java.util.*;

public class WordLadder {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }
        Map<String, Set<String>> graph = constructGraph(dict);
        Queue<String> forwardQueue = new LinkedList<>();
        Queue<String> backwardQueue = new LinkedList<>();
        Set<String> forwardSet = new HashSet<>();
        Set<String> backwardSet = new HashSet<>();
        dict.add(start);
        dict.add(end);
        forwardQueue.offer(start);
        backwardQueue.offer(end);
        forwardSet.add(start);
        backwardSet.add(end);
        // bidirectional bfs
        // error before, start from 1
        int distance = 1;
        while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
            distance++;
            if (bfs(graph, forwardQueue, forwardSet, backwardSet)) {
                return distance;
            }
            distance++;
            if (bfs(graph, backwardQueue, backwardSet, forwardSet)) {
                return distance;
            }
        }
        return -1;
    }

    // bidirectional bfs
    private boolean bfs (Map<String, Set<String>> graph, Queue<String> queue, Set<String> forwardSet, Set<String> oppositeSet) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String word = queue.poll();
            Set<String> nextWords = graph.get(word);
            for (String nextWord: nextWords) {
                if (forwardSet.contains(nextWord)) {
                    continue;
                }
                if (oppositeSet.contains(nextWord)) {
                    return true;
                }
                queue.offer(nextWord);
                forwardSet.add(nextWord);
            }
        }
        return false;
    }

    // construct a graph first
    private Map<String, Set<String>> constructGraph(Set<String> dict) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (String word : dict) {
            graph .put(word, getNextWord(word, dict));
        }
        return graph;
    }

    private Set<String> getNextWord(String word, Set<String> dict) {
        int size = word.length();
        Set<String> nextWords = new HashSet<>();
        for (int i = 0; i < size; i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i + 1);
            char[] characters = ("abcdefghijklmnopqrstuvwxyz").toCharArray();
            for (int j = 0; j < 26; j++) {
                if (word.charAt(i) == characters[j]) {
                    continue;
                }
                String newWord = prefix + characters[j] + suffix;
                if (dict.contains(newWord)) {
                    nextWords.add(newWord);
                }
            }
        }
        return nextWords;
    }
}
