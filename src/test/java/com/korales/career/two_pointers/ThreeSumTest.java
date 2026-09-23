package com.korales.career.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    void threeSum() {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        var result = threeSum.threeSum(nums);
        assertTrue(result.contains(List.of(-1, -1, 2)));
        assertTrue(result.contains(List.of(-1, 0, 1)));
    }

    @Test
    void threeSum2() {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {0, 1, 1};
        var result = threeSum.threeSum(nums);
        assertTrue(result.isEmpty());
    }

    @Test
    void threeSum3() {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-2,0,1,1,2};
        var result = threeSum.threeSum(nums);
        assertTrue(result.contains(List.of(-2,0,2)));
        assertTrue(result.contains(List.of(-2,1,1)));
    }
}