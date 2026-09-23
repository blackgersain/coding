package com.korales.career.moving_window;

public class MaximumSumOfSubarray {

    public Integer maxSum(int[] nums, Integer k) {
        int start = 0;
        int i = 0;
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        while (i < nums.length) {
            windowSum += nums[i];

            if (i - start + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[start];
                start++;
            }

            i++;
        }

        return maxSum;
    }
}
