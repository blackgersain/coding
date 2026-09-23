package com.korales.career.graph;

import java.util.*;

public class CourseSchedule2 {

    public int[] findOrder(Integer numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]] += 1;

            List<Integer> neighbors = adj.computeIfAbsent(prerequisites[i][1], k -> new ArrayList<>());

            neighbors.add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            order.add(curr);

            List<Integer> neighbors = adj.get(curr);

            if (neighbors == null) {
                continue;
            }

            for (int neighbor : neighbors) {
                indegree[neighbor] -= 1;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (order.size() != numCourses) {
            return new int[0];
        }

        return order.stream().mapToInt(Integer::intValue).toArray();
    }
}
