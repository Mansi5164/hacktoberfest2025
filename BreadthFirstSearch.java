package com.thealgorithms.graph;

import java.util.*;

/**
 * Breadth First Search (BFS) algorithm for graph traversal.
 * Time Complexity: O(V + E)
 */
public class BreadthFirstSearch {

    public static List<Integer> bfsTraversal(Map<Integer, List<Integer>> graph, int startNode) {
        List<Integer> result = new ArrayList<>();
        if (graph == null || !graph.containsKey(startNode)) {
            return result;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }
}
