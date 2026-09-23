package com.korales.career.two_pointers;

public class TwoSum {

    public Boolean twoSum(int[] nums, Integer target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int current = nums[left] + nums[right];

            if (current == target) {
                return true;
            }
            else if (current < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return false;
    }
}
