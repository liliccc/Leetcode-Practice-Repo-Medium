package algorithms.level4BFS;

import java.util.*;

public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode newNode;
                UndirectedGraphNode currentNode = queue.poll();
            if (mapping.containsKey(node)) {
                newNode = mapping.get(currentNode);
            }
            else {
                newNode = new UndirectedGraphNode(currentNode.label);
                mapping.put(currentNode, newNode);
            }
            UndirectedGraphNode newNeighbour;
            for (UndirectedGraphNode neighbour : currentNode.neighbors) {
                if (mapping.containsKey(neighbour)) {
                    newNeighbour = mapping.get(neighbour);
                }
                else {
                    newNeighbour = new UndirectedGraphNode(neighbour.label);
                    mapping.put(neighbour, newNeighbour);
                    queue.offer(neighbour);
                }
                newNode.neighbors.add(newNeighbour);
            }
        }
        return mapping.get(node);
    }

}

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) {
          label = x;
          neighbors = new ArrayList<UndirectedGraphNode>();
      }
}
