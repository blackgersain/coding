package com.korales.career.two_pointers;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, long target) {
        if (nums.length < 4) {
            return new ArrayList();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[left];
                    sum += nums[right];

                    if (sum == target) {
                        String quadrupletStr = nums[i] + "," + nums[j] + "," + nums[left] + "," + nums[right];

                        if (!set.contains(quadrupletStr)) {
                            set.add(quadrupletStr);
                            List<Integer> quadruplet = new ArrayList<>();
                            quadruplet.add(nums[i]);
                            quadruplet.add(nums[j]);
                            quadruplet.add(nums[left]);
                            quadruplet.add(nums[right]);
                            result.add(quadruplet);
                        }

                        left++;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
