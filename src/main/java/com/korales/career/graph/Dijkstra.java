package com.korales.career.graph;

import java.util.*;

public class Dijkstra {

    Map<Integer, Integer> dijkstra(Map<Integer, List<int[]>> graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        distances.put(start, 0);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[]{0, start});

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int dist = curr[0], node = curr[1];

            if (dist > distances.getOrDefault(node, Integer.MAX_VALUE))
                continue;

            List<int[]> edges = graph.get(node);

            if (edges == null) {
                continue;
            }

            for (int[] edge : edges) {
                int neighbor = edge[0], weight = edge[1];
                int newDist = dist + weight;
                if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    heap.offer(new int[]{newDist, neighbor});
                }
            }
        }

        return distances;
    }
}
