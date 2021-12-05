package com.company.level4BFS;

import java.util.*;

public class TopologicalSorting {

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        Map<DirectedGraphNode, Integer> inDegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbour : node.neighbors) {
                if (!inDegree.containsKey(neighbour)) {
                    inDegree.put(neighbour, 1);
                }
                else {
                    inDegree.put(neighbour, inDegree.get(neighbour) + 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new ArrayDeque<>();
        for (DirectedGraphNode node : graph) {
            if (!inDegree.containsKey(node)) {
                queue.offer(node);
                order.add(node);
            }
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode head = queue.poll();
            for (DirectedGraphNode neighbour : head.neighbors) {
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                if (inDegree.get(neighbour) == 0) {
                    queue.offer(neighbour);
                    order.add(neighbour);
                }
            }
        }
        return order;
    }
}

class DirectedGraphNode {
    int label;
    List<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
