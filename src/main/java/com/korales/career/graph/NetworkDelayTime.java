package com.korales.career.graph;

import java.util.*;

public class NetworkDelayTime {

    public Integer networkDelayTime(int[][] times, Integer n, Integer k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] edge : times) {
            adj.computeIfAbsent(edge[0], _ -> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
        }

        distances.put(k, 0);
        heap.offer(new int[]{ 0, k });

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int dist = curr[0];
            int node = curr[1];

            if (dist > distances.getOrDefault(node, Integer.MAX_VALUE)) {
                continue;
            }

            List<int[]> neighbors = adj.get(node);

            if (neighbors == null) {
                continue;
            }

            for (int[] neighbor : neighbors) {
                int newNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = dist + weight;

                if (newDist < distances.getOrDefault(newNode, Integer.MAX_VALUE)) {
                    distances.put(newNode, newDist);
                    heap.offer(new int[] { newDist, newNode });
                }
            }
        }

        if (distances.size() != n) {
            return -1;
        }

        int minDistance = 0;

        for (int value : distances.values()) {
            if (value > minDistance) {
                minDistance = value;
            }
        }

        return minDistance;
    }
}
