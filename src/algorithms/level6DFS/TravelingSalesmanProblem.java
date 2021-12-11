package algorithms.level6DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TravelingSalesmanProblem {
    /**
     * @param n: an integer,denote the number of cities
     * @param roads: a list of three-tuples,denote the road between cities
     * @return: return the minimum cost to travel all cities
     */
    public int minCost(int n, int[][] roads) {
        if (roads == null || n == 0) {
            return 0;
        }
        int[][] graph = constructGraph(n, roads);
        Set<Integer> visited = new HashSet<>();
        Result result = new Result();
        List<Integer> path = new ArrayList<>();
        visited.add(1);
        path.add(1);
        dfs(1, 0, n, graph, result, visited, path);
        return result.minCost;
     }

     private void dfs(int city, int cost, int n, int[][] graph, Result result, Set<Integer> visited, List<Integer> path) {
        if (visited.size() == n) {
            result.minCost = Math.min(result.minCost, cost);
            return;
        }
        // i start from 1
        for (int nextCity = 1; nextCity < graph[city].length; nextCity ++) {
            if (visited.contains(nextCity)) {
                continue;
            }
            if (hasTheBetterPath(graph, path, nextCity)) {
                continue;
            }
            visited.add(nextCity);
            path.add(nextCity);
            dfs(nextCity, cost + graph[city][nextCity], n, graph, result, visited, path);
            visited.remove(nextCity);
            path.remove(path.size() - 1);
        }
     }

    private int[][] constructGraph(int n, int[][] roads) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                graph[i][j] = Integer.MAX_VALUE >> 4;
            }
        }
        for (int[] road : roads) {
            int a = road[0], b = road[1], c = road[2];
            graph[a][b] = Math.min(graph[a][b], c);
            graph[b][a] = Math.min(graph[b][a], c);
        }
        return graph;
    }

     private boolean hasTheBetterPath(int[][] graph, List<Integer> path, int city){
        for (int i = 1; i < path.size(); i++) {
            int first = path.get(i - 1);
            int second = path.get(i);
            int beforeEnd = path.get(path.size() - 1);
            if (graph[first][second] + graph[beforeEnd][city] >
                    graph[first][beforeEnd] + graph[second][city]) {
                    return true;
            }
        }
        return false;
     }


}

class Result {
    int minCost;
    public Result() {
        this.minCost = Integer.MAX_VALUE;
    }
}
