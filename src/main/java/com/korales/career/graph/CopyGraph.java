package com.korales.career.graph;

import java.util.*;

public class CopyGraph {

     class IntGraphNode {
         int value;
         IntGraphNode[] neighbors;
     }
    
    public Map<Integer, List<Integer>> copy_graph(IntGraphNode node) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        if (node == null) {
            return graph;
        }

        Set<Integer> visited = new HashSet<>();

        copy_graph(node, graph, visited);

        return graph;
    }

    public void copy_graph(IntGraphNode node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (node == null) {
            return ;
        }
        if (visited.contains(node.value)) {
            return ;
        }

        visited.add(node.value);
        graph.put(node.value, new ArrayList<>());

        for (IntGraphNode neighbor : node.neighbors) {
            List<Integer> currNeigbors = graph.get(node.value);

            if (!currNeigbors.contains(neighbor.value)) {
                currNeigbors.add(neighbor.value);
            }

            currNeigbors = graph.computeIfAbsent(neighbor.value, k -> new ArrayList());

            if (!currNeigbors.contains(node.value)) {
                currNeigbors.add(node.value);
            }

            copy_graph(neighbor, graph, visited);
        }
    }
}
