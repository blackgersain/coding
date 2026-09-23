package com.korales.career.two_pointers;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        int i = 0;

        while (i < nums.length - 2) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];

                if (current == 0) {
                    String tripletStr = nums[i] + "," + nums[left] + "," + nums[right];

                    if (!set.contains(tripletStr)) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        result.add(triplet);
                        set.add(tripletStr);
                    }

                    if (left + 1 < right) {
                        left++;
                    }
                    else {
                        break;
                    }
                }
                else if (current < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }

            i++;
        }

        return result;
    }
}
