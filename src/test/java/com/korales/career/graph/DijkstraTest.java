package com.korales.career.graph;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void dijkstra() {
        Dijkstra dijkstra = new Dijkstra();
        Map<Integer, List<int[]>> graph = new HashMap<>();

        graph.put(0, List.of(new int[]{ 1, 4 }, new int[]{ 2, 1 }));
        graph.put(1, List.of(new int[]{ 3, 1 } ));
        graph.put(2, List.of(new int[]{ 1, 2 }, new int[]{ 3, 5 }));
        graph.put(3, List.of(new int[]{ 4, 3 }));

        Map<Integer, Integer> distances = dijkstra.dijkstra(graph, 0);
    }
}