package com.korales.career.prefix_sum;

import java.util.Arrays;

public class SubarraySumEqualsK {

    public Integer subarraySum(int[] nums, Integer k) {
        int[] prefixSums = new int[nums.length + 1];

        for (int i = 1; i < prefixSums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        System.out.println(Arrays.toString(prefixSums));

        int totalSums = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = prefixSums[j + 1] - prefixSums[i];

                if (sum == k) {
                    totalSums++;
                }
            }
        }

        return totalSums;
    }
}
