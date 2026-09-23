package com.korales.career.graph;

import java.util.*;

public class CourseSchedule {

    public Boolean canFinish(Integer numCourses, int[][] prerequisites) {
        int[] indegre = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            indegre[prerequisites[i][1]] += 1;

            List<Integer> neighbors = adj.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>());

            neighbors.add(prerequisites[i][1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < indegre.length; i++) {
            if (indegre[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            order.add(curr);

            List<Integer> neigbors = adj.get(curr);

            if (neigbors == null) {
                continue;
            }

            for (int neigbor : neigbors) {
                indegre[neigbor] -= 1;

                if (indegre[neigbor] == 0) {
                    queue.offer(neigbor);
                }
            }
        }

        return order.size() == numCourses;
    }
}
