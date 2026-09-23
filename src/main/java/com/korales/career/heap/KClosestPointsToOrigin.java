package com.korales.career.heap;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, Integer k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            double distA = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
            double distB = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
            return Double.compare(distB, distA);
        });

        for (int i = 0; i < points.length; i++) {
            if (i < k) {
                heap.offer(points[i]);
            } else if (distance(points[i]) < distance(heap.peek())) {
                heap.poll();
                heap.offer(points[i]);
            }
        }

        return heap.toArray(int[][]::new);
    }

    public double distance(int[] a) {
        return Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
    }
}
