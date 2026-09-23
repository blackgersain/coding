package com.korales.career.two_pointers;

public class SortColorsV1 {

    public void sortColors(int[] nums) {
        int nextSwap = 0;

        nextSwap = swapN(nextSwap, nums, 0);
        nextSwap = swapN(nextSwap, nums, 1);
    }

    public int swapN(int nextSwap, int[] nums, int n) {
        int i = nextSwap;

        while (i < nums.length) {
            if (nums[i] == n) {
                int temp = nums[nextSwap];
                nums[nextSwap] = nums[i];
                nums[i] = temp;
                nextSwap++;
            }

            i++;
        }

        return nextSwap;
    }
}
