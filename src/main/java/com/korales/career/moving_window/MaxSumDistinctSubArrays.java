package com.korales.career.moving_window;

import java.util.HashSet;
import java.util.Set;

public class MaxSumDistinctSubArrays {

    public Long maxSum(int[] nums, Integer k) {
        int start = 0;
        long windowSum = 0;
        long maxSum = Long.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];


            while (set.contains(nums[i])) {
                windowSum -= nums[start];
                set.remove(nums[start]);
                start++;
            }

            set.add(nums[i]);

            if (i - start + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[start];
                start++;
            }
        }

        if (maxSum == Long.MIN_VALUE) {
            return 0L;
        }

        return maxSum;
    }
}
