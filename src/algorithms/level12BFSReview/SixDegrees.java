package algorithms.level12BFSReview;

import java.util.*;

public class SixDegrees {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node (person 1)
     * @param t: Undirected graph node (person 2)
     * @return: an integer (the numbers of steps)
     */
     // # is split line
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (graph == null || graph.size() == 0) {
            return -1;
        }
        if (s == t) {
            return 0;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, Integer> visited = new HashMap<>();
        queue.offer(s);
        visited.put(s, 0);
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            int steps = visited.get(node);
            for (int i = 0; i < node.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = node.neighbors.get(i);
                if (visited.containsKey(neighbor)) {
                    continue;
                }
                visited.put(neighbor, steps + 1);
                queue.offer(neighbor);
                if (neighbor == t) {
                    return steps + 1;
                }
            }
        }
        return -1;
    }
};
