package com.korales.career.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleNumberTest {

    @Test
    void triangleNumber() {
        TriangleNumber triangleNumber = new TriangleNumber();
        int[] nums = {11,4,9,6,15,18};
        int result = triangleNumber.triangleNumber(nums);
        assertEquals(10, result);
    }
}