package com.korales.career.graph;

import java.util.*;

public class TopologicalSort {

    public static List<Integer> topologicalSort(Map<Integer, List<Integer>> adjList, int n) {
        // calculate indegree of each node
        int[] indegree = new int[n];
        for (int u : adjList.keySet()) {
            for (int v : adjList.get(u)) {
                indegree[v]++;
            }
        }

        // enqueue nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int u = 0; u < n; u++) {
            if (indegree[u] == 0) {
                queue.offer(u);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int v : adjList.getOrDefault(u, new ArrayList<>())) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return order.size() == n ? order : new ArrayList<>();
    }
}
