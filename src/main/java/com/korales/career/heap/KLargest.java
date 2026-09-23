package com.korales.career.heap;

import java.util.PriorityQueue;

public class KLargest {

    public Integer kthLargest(int[] nums, Integer k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        if (nums == null || nums.length == 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                heap.offer(nums[i]);
            }
            else if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }

        return heap.peek();
    }
}
