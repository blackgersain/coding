package com.korales.career.two_pointers;

import java.util.Arrays;

public class TriangleNumber {

    public Integer triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 0;
        int i = nums.length - 1;

        while (i >= 2) {
            int left = 0;
            int right = i - 1;

            while (left < right) {
                if (nums[left] + nums[right]> nums[i]) {
                    count += right - left;
                    right--;
                }
                else {
                    left++;
                }
            }

            i--;
        }

        return count;
    }
}
