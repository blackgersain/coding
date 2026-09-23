package com.korales.career.heap;

import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {

    public List<Integer> kClosest(int[] nums, Integer k, Integer target) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            int aDist = diff(target, a);
            int bDist = diff(target, b);

            return Integer.compare(bDist, aDist);
        });

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                heap.offer(nums[i]);
            }
            else if (diff(target, nums[i]) < diff(target, heap.peek())) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }

        return heap.stream().sorted().toList();
    }

    public int diff(int target, int n) {
        return Math.abs(n - target);
    }
}
